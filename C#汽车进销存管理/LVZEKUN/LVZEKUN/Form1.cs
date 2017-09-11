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
    public partial class Form1 : Form
    {
        public Form2 M;
        public Form1()
        {
            InitializeComponent();
        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            if (textBoxName.Text == " ")
            {
                MessageBox.Show("请输入用户名", "警告", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else
            {
                if (textBoxPassword.Text == " ")
                {
                    MessageBox.Show("请输入用户名", "警告", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
                else
                {
                    SqlConnection conn = DBconn.Camcon();
                    conn.Open();
                    SqlCommand cmd = new SqlCommand("select count(*) from Login where username='" + textBoxName.Text + "'and password='" + textBoxPassword.Text + "'", conn);
                    int num = Convert.ToInt32(cmd.ExecuteScalar());
                    if (num > 0)
                    {
                        conn.Close();
                        MessageBox.Show("登录成功", "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    }
                    else
                    {
                        MessageBox.Show("密码或用户名", "错误", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }
            }
            
            this.Hide();
            M.Show();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.BackColor = Color.LightBlue;
            textBoxName.TabIndex = 0;
            textBoxPassword.TabIndex = 0;

            textBoxName.Focus();
            M = new Form2();
        }


        private void buttonQuit_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("是否放弃登陆", "警告", MessageBoxButtons.OK, MessageBoxIcon.Information) == DialogResult.OK)
            {
                Application.Exit();
            }
        }
    }
}
