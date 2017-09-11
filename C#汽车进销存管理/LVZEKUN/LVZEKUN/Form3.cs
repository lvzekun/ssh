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
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

      

        private void Form3_Load(object sender, EventArgs e)
        {
            comboBox1.Items.Add("男");
            comboBox1.Items.Add("女");
            comboBox1.DropDownStyle = ComboBoxStyle.DropDownList;
            get_bh();
            this.BackColor = Color.LightBlue;
        }
        private void get_bh()
        {
            SqlConnection conn = new SqlConnection();
            string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
            conn.ConnectionString = str;
            conn.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.CommandText = "select * from customer";
            //cmd.CommandText = "select isnull(max(编号),0)+1 from 基本信息表";
            cmd.Connection = conn;
            SqlDataAdapter sda = new SqlDataAdapter(cmd);
            DataSet ds = new DataSet();
            sda.Fill(ds);
            int t = ds.Tables[0].Rows.Count;
            int bh = t - 1;
            this.textBoxF31.Text = (Int32.Parse(ds.Tables[0].Rows[bh]["编号"].ToString()) + 1).ToString();
            //this.textBox1.Text = cmd.ExecuteScalar().ToString();
            conn.Close();
        }

        private void buttonF32_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void buttonF3OK_Click_1(object sender, EventArgs e)
        {
            if (textBoxF32.Text.Trim() == "" || textBoxF33.Text.Trim() == "" || comboBox1.Text.Trim() == "" || textBoxF34.Text.Trim() == "" || textBoxF35.Text.Trim() == ""
               || textBoxF36.Text.Trim() == "" || textBoxF37.Text.Trim() == "")
            {
                MessageBox.Show("请输入完整信息！", "错误", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                string str1 = textBoxF34.Text.Trim();
                int l = str1.Length;
                for (int i = 0; i < l; i++)
                {
                    if (!char.IsNumber(str1[i]))
                    {
                        MessageBox.Show("年龄输入有误！", "错误", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        textBoxF34.SelectAll();
                        textBoxF34.Focus();
                        return;
                    }
                }
                SqlConnection conn = new SqlConnection();
                string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
                conn.ConnectionString = str;
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.CommandText = "insert into customer(编号,姓名,身份证号,性别,年龄,地址,手机号,车型)values(@编号,@姓名,@身份证号,@性别,@年龄,@地址,@手机号,@车型)";
                cmd.Connection = conn;
                cmd.Parameters.Add("@编号", SqlDbType.Int);
                cmd.Parameters.Add("@姓名", SqlDbType.NVarChar, 50);
                cmd.Parameters.Add("@身份证号", SqlDbType.NVarChar, 50);
                cmd.Parameters.Add("@性别", SqlDbType.NVarChar, 50);
                cmd.Parameters.Add("@年龄", SqlDbType.Int);
                cmd.Parameters.Add("@地址", SqlDbType.NVarChar, 50);
                cmd.Parameters.Add("@手机号", SqlDbType.NVarChar, 50);
                cmd.Parameters.Add("@车型", SqlDbType.NVarChar, 50);
                cmd.Parameters["@编号"].Value = textBoxF31.Text.Trim();
                cmd.Parameters["@姓名"].Value = textBoxF32.Text.Trim();
                cmd.Parameters["@身份证号"].Value = textBoxF33.Text.Trim();

                cmd.Parameters["@性别"].Value = comboBox1.Text.Trim();
                cmd.Parameters["@年龄"].Value = textBoxF34.Text.Trim();
                cmd.Parameters["@地址"].Value = textBoxF35.Text.Trim();
                cmd.Parameters["@手机号"].Value = textBoxF36.Text.Trim();
                cmd.Parameters["@车型"].Value = textBoxF37.Text.Trim();

                cmd.ExecuteNonQuery();
                conn.Close();
                this.Close();
            }
           
        }

        

        
    }
}
