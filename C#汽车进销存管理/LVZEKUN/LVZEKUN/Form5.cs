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
    public partial class Form5 : Form
    {
        public Form5()
        {
            InitializeComponent();
        }
        public int id;
        private void Form5_Load(object sender, EventArgs e)
        {
            this.BackColor = Color.LightBlue;
            textBox1.Text = id.ToString();
            SqlConnection conn = new SqlConnection("Data Source=(local);Initial Catalog=Car;Integrated Security=True");
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = conn;
            conn.Open();
            cmd.CommandText = "select * from dingdan where 订单单号=" + id.ToString();
            SqlDataAdapter sda = new SqlDataAdapter(cmd);
            DataSet ds = new DataSet();
            sda.Fill(ds);
            if (ds.Tables[0].Rows.Count == 1)//数据维一行
            {
                this.textBox2.Text = (ds.Tables[0].Rows[0]["车型"].ToString());
                this.textBox3.Text = (ds.Tables[0].Rows[0]["台数"].ToString());
                this.textBox4.Text = (ds.Tables[0].Rows[0]["进价"].ToString());
                this.textBox5.Text = (ds.Tables[0].Rows[0]["旗舰店名"].ToString());
                this.textBox6.Text = (ds.Tables[0].Rows[0]["经理"].ToString());
                //this.textBox7.Text = (ds.Tables[0].Rows[0]["日期"].ToString());

                conn.Close();
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox2.Text.Trim() == "" || textBox3.Text.Trim() == "" || textBox4.Text.Trim() == "" || textBox5.Text.Trim() == "" || textBox6.Text.Trim() == ""
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
                cmd.CommandText = "update dingdan set 订单单号=@订单单号,车型=@车型,台数=@台数,进价=@进价,旗舰店名=@旗舰店名,经理=@经理,日期=@日期 where 订单单号=@订单单号";
                cmd.Connection = conn;
                cmd.Parameters.Add("@订单单号", SqlDbType.Int);
                cmd.Parameters.Add("@车型", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@台数", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@进价", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@旗舰店名", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@经理", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@日期", SqlDbType.VarChar, 30);
                // cmd.Parameters.Add("@车型", SqlDbType.NVarChar, 50);
                cmd.Parameters["@订单单号"].Value = textBox1.Text.Trim();
                cmd.Parameters["@车型"].Value = textBox2.Text.Trim();
                cmd.Parameters["@台数"].Value = textBox3.Text.Trim();

                cmd.Parameters["@进价"].Value = textBox4.Text.Trim();
                cmd.Parameters["@旗舰店名"].Value = textBox5.Text.Trim();
                cmd.Parameters["@经理"].Value = textBox6.Text.Trim();
                cmd.Parameters["@日期"].Value = this.dateTimePicker1.Value.ToString("yyyy/MM/dd");
                // cmd.Parameters["@车型"].Value = textBox8.Text.Trim();
                cmd.ExecuteNonQuery();
                conn.Close();
                MessageBox.Show("修改成功", "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
                this.Close();
            }
            
           
        }
        
        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
