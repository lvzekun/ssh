using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;

using System.Data.SqlClient;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LVZEKUN
{
    public partial class Form6 : Form
    {
        public Form6()
        {
            InitializeComponent();
        }
        public string  id;
        private void Form6_Load(object sender, EventArgs e)
        {
            this.BackColor = Color.LightBlue;
            textBox1.Text = id.ToString();
            SqlConnection conn = new SqlConnection("Data Source=(local);Initial Catalog=Car;Integrated Security=True");
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = conn;
            conn.Open();
            cmd.CommandText = "select * from xuefulan2 where 编号=" + id.ToString();
            SqlDataAdapter sda = new SqlDataAdapter(cmd);
            DataSet ds = new DataSet();
            sda.Fill(ds);
            if (ds.Tables[0].Rows.Count == 1)//数据维一行
            {
                this.textBox2.Text = (ds.Tables[0].Rows[0]["车型"].ToString());
                this.textBox3.Text = (ds.Tables[0].Rows[0]["库存"].ToString());
                this.textBox4.Text = (ds.Tables[0].Rows[0]["售价"].ToString());
                this.textBox5.Text = (ds.Tables[0].Rows[0]["优惠"].ToString());
              //  this.textBox6.Text = (ds.Tables[0].Rows[0]["经理"].ToString());
                //this.textBox7.Text = (ds.Tables[0].Rows[0]["日期"].ToString());

                conn.Close();
            }

        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (textBox2.Text.Trim() == "" || textBox3.Text.Trim() == "" || textBox4.Text.Trim() == "" || textBox5.Text.Trim() == ""
             )
            {
                MessageBox.Show("请输入完整信息！", "错误", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                SqlConnection conn = new SqlConnection();
                string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
                conn.ConnectionString = str;
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.CommandText = "update xuefulan2 set 编号=@编号,车型=@车型,库存=@库存,售价=@优惠,优惠开始日期=@优惠开始日期,优惠截至日期=@优惠截至日期 where 编号=@编号";
                cmd.Connection = conn;
                cmd.Parameters.Add("@编号", SqlDbType.Int);
                cmd.Parameters.Add("@车型", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@库存", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@售价", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@优惠", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@优惠开始日期", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@优惠截至日期", SqlDbType.VarChar, 30);
                // cmd.Parameters.Add("@车型", SqlDbType.NVarChar, 50);
                cmd.Parameters["@编号"].Value = textBox1.Text.Trim();
                cmd.Parameters["@车型"].Value = textBox2.Text.Trim();
                cmd.Parameters["@库存"].Value = textBox3.Text.Trim();

                cmd.Parameters["@优惠截至日期"].Value = this.dateTimePicker2.Value.ToString("yyyy/MM/dd");
                cmd.Parameters["@售价"].Value = textBox4.Text.Trim();
                cmd.Parameters["@优惠"].Value = textBox5.Text.Trim();
                cmd.Parameters["@优惠开始日期"].Value = this.dateTimePicker1.Value.ToString("yyyy/MM/dd");
                 //cmd.Parameters["@车型"].Value = textBox8.Text.Trim();
                cmd.ExecuteNonQuery();
                conn.Close();
                this.Close();
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
