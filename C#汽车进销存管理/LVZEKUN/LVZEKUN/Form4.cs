using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace LVZEKUN
{
    public partial class Form4 : Form
    {
        public Form4()
        {
            InitializeComponent();
        }
        public int id;
        private void buttonF41_Click(object sender, EventArgs e)
        {
            if (textBox2.Text.Trim() == "" || textBox3.Text.Trim() == "" || textBox4.Text.Trim() == "" || textBox5.Text.Trim() == "" || textBox6.Text.Trim() == "" || textBox7.Text.Trim() == ""
                || textBox8.Text.Trim() == "")
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
                cmd.CommandText = "update customer set 编号=@编号,姓名=@姓名,身份证号=@身份证号,性别=@性别,年龄=@年龄,地址=@地址,手机号=@手机号,车型=@车型 where 编号=@编号";
                cmd.Connection = conn;
                cmd.Parameters.Add("@编号", SqlDbType.Int);
                cmd.Parameters.Add("@姓名", SqlDbType.NVarChar, 50);
                cmd.Parameters.Add("@身份证号", SqlDbType.NVarChar, 50);
                cmd.Parameters.Add("@性别", SqlDbType.NVarChar, 50);
                cmd.Parameters.Add("@年龄", SqlDbType.Int);
                cmd.Parameters.Add("@地址", SqlDbType.NVarChar, 50);
                cmd.Parameters.Add("@手机号", SqlDbType.NVarChar, 50);
                cmd.Parameters.Add("@车型", SqlDbType.NVarChar, 50);
                cmd.Parameters["@编号"].Value = textBox1.Text.Trim();
                cmd.Parameters["@姓名"].Value = textBox2.Text.Trim();
                cmd.Parameters["@身份证号"].Value = textBox3.Text.Trim();

                cmd.Parameters["@性别"].Value = textBox4.Text.Trim();
                cmd.Parameters["@年龄"].Value = textBox5.Text.Trim();
                cmd.Parameters["@地址"].Value = textBox6.Text.Trim();
                cmd.Parameters["@手机号"].Value = textBox7.Text.Trim();
                cmd.Parameters["@车型"].Value = textBox8.Text.Trim();
                cmd.ExecuteNonQuery();
                conn.Close();
                this.Close();
            }

        }

        private void Form4_Load(object sender, EventArgs e)

        {
            this.BackColor = Color.LightBlue;
            textBox1.Text = id.ToString();
            SqlConnection conn = new SqlConnection("Data Source=(local);Initial Catalog=Car;Integrated Security=True");
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = conn;
            conn.Open();
            cmd.CommandText = "select * from customer where 编号=" + id.ToString();
            SqlDataAdapter sda = new SqlDataAdapter(cmd);
            DataSet ds = new DataSet();
            sda.Fill(ds);
            if (ds.Tables[0].Rows.Count == 1)//数据维一行
            {
                this.textBox2.Text = (ds.Tables[0].Rows[0]["姓名"].ToString());
                this.textBox3.Text = (ds.Tables[0].Rows[0]["身份证号"].ToString());
                this.textBox4.Text = (ds.Tables[0].Rows[0]["性别"].ToString());
                this.textBox5.Text = (ds.Tables[0].Rows[0]["年龄"].ToString());
                this.textBox6.Text = (ds.Tables[0].Rows[0]["地址"].ToString());
                this.textBox7.Text = (ds.Tables[0].Rows[0]["手机号"].ToString());
                this.textBox8.Text = (ds.Tables[0].Rows[0]["车型"].ToString());
                conn.Close();
            }

        }

        private void buttonF42_Click(object sender, EventArgs e)
        {
            this.Close();
        }//
    }
}
