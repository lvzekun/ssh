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
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
            
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            

            this.BackColor = Color.LightSkyBlue;
            try
            {
                SqlConnection conn = new SqlConnection();
                string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
                conn.ConnectionString = str;
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.CommandText = "select * from customer";
                cmd.Connection = conn;
                SqlDataAdapter sda = new SqlDataAdapter(cmd);
                DataSet ds = new DataSet();
                sda.Fill(ds, "customer");
                this.dataGridView1.DataSource = ds;
                this.dataGridView1.DataMember = "customer";
                this.dataGridView1.AutoGenerateColumns = true;
                for (int i = 1; i < this.dataGridView1.ColumnCount; i++)
                {
                    this.dataGridView1.Columns[i].DefaultCellStyle.SelectionBackColor = Color.White;
                    this.dataGridView1.Columns[i].DefaultCellStyle.SelectionForeColor = Color.Black;
                    this.dataGridView1.Columns[i].ReadOnly = true;
                }
                conn.Close();
            }
            catch (Exception ee)
            {
                MessageBox.Show("错误：" + ee.Message, "错误");
            }
           /*try
            {
                SqlConnection conn = new SqlConnection();
                string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
                conn.ConnectionString = str;
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.CommandText = "select * from xuefulan2";
                cmd.Connection = conn;
                SqlDataAdapter sda = new SqlDataAdapter(cmd);
                DataSet ds = new DataSet();
                sda.Fill(ds, "xuefulan2");
                this.dataGridView7.DataSource = ds;
                this.dataGridView7.DataMember = "xuefulan2";
                this.dataGridView7.AutoGenerateColumns = true;
                for (int i = 1; i < this.dataGridView1.ColumnCount; i++)
                {
                    this.dataGridView7.Columns[i].DefaultCellStyle.SelectionBackColor = Color.White;
                    this.dataGridView7.Columns[i].DefaultCellStyle.SelectionForeColor = Color.Black;
                    this.dataGridView7.Columns[i].ReadOnly = true;
                }
                conn.Close();
            }
            catch (Exception ee)
            {
                MessageBox.Show("错误：" + ee.Message, "错误");
            }*/
                      
            // tabPage1.Parent = null;//隐藏客户信息tabpage1
            pictureBox1_Click(sender, e); //显示图片
            this.BackColor = Color.LightBlue;
            get_All();
            
           


        }//刷新
        private void get_All()
    {
        get_cm();//车型种类进货
        get_cm2();//进货刷新
        get_bh2();//进货编号

        get_bh3();//显示销售单号
        get_cm3();//显示添加销售单信息
       


       
        
       // get_cm6();//显示汽车库存信息
      
    }
        
        private void buttonF2Add_Click(object sender, EventArgs e)
        {
            Form3 M3 = new Form3();
            M3.ShowDialog();
        }//添加客户信息

        //刷新客户信息
        private void buttonF2new_Click(object sender, EventArgs e)
        {
            // Form2_Load(sender, e);
            try
            {
                SqlConnection conn = new SqlConnection();
                string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
                conn.ConnectionString = str;
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.CommandText = "select * from customer";
                cmd.Connection = conn;
                SqlDataAdapter sda = new SqlDataAdapter(cmd);
                DataSet ds = new DataSet();
                sda.Fill(ds, "customer");
                this.dataGridView1.DataSource = ds;
                this.dataGridView1.DataMember = "customer";
                this.dataGridView1.AutoGenerateColumns = true;
                for (int i = 1; i < this.dataGridView1.ColumnCount; i++)
                {
                    this.dataGridView1.Columns[i].DefaultCellStyle.SelectionBackColor = Color.White;
                    this.dataGridView1.Columns[i].DefaultCellStyle.SelectionForeColor = Color.Black;
                    this.dataGridView1.Columns[i].ReadOnly = true;
                }
                conn.Close();
            }
            catch (Exception ee)
            {
                MessageBox.Show("错误：" + ee.Message, "错误");
            }
        }
        //删除客户信息按钮
        private void buttonF2delete_Click(object sender, EventArgs e)
        {
            if (this.dataGridView1.SelectedCells == null)
            {
                MessageBox.Show("请选择要删¦除的项！", "错误", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                if (this.dataGridView1.CurrentCell.ColumnIndex == 0)
                {
                    string st = this.dataGridView1[0, this.dataGridView1.CurrentCell.RowIndex].Value.ToString();
                    SqlConnection conn = new SqlConnection();
                    string str = "Data Source=(local);Initial Catalog=car;Integrated Security=True";
                    conn.ConnectionString = str;
                    conn.Open();
                    SqlCommand cmd = new SqlCommand();
                    cmd.CommandText = "delete from customer where 编号='" + st + "'";
                    cmd.Connection = conn;
                    cmd.ExecuteNonQuery();
                    conn.Close();
                    MessageBox.Show("删除成功", "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);

                }//if
            }//else
            buttonF2new_Click(sender, e);
        }
        //修改客户信息按钮
        private void buttonF2gai_Click(object sender, EventArgs e)
        {
            Form4 M4 = new Form4();
            M4.id = Convert.ToInt32(this.dataGridView1[0, this.dataGridView1.CurrentCell.RowIndex].Value.ToString());
            M4.ShowDialog();
        }

        private void buttonF2Select_Click(object sender, EventArgs e)
        {
            if (textBoxF2.Text.Trim() == " ")
            {
                MessageBox.Show(" 请输入要查询的姓名：", "提示");
            }
            else
            {
                SqlConnection conn = new SqlConnection();
                string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
                conn.ConnectionString = str;
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.CommandText = "select *from customer where 姓名='" + this.textBoxF2.Text.Trim() + "'";
                cmd.Connection = conn;
                //显示在DataGridView.
                SqlDataAdapter sda = new SqlDataAdapter(cmd);//初始化sda
                DataSet ds = new DataSet();
                sda.Fill(ds);
                this.dataGridView1.DataSource = ds;
                this.dataGridView1.DataMember = ds.Tables[0].ToString();
                this.dataGridView1.AutoGenerateColumns = true;
                conn.Close();


            }

        }

        private void groupBoxF2_Enter(object sender, EventArgs e)
        {
            this.BackColor = Color.LightBlue;
        }
        //引用显示条框

        private void treeView1_NodeMouseClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            if (e.Node.Name == "kh1")//客户信息
            {
                tabPage1.Parent = tabControl1;
                tabControl1.SelectedTab = tabPage1;
            }
            if (e.Node.Name == "car1")//汽车信息
            {
                tabPage3.Parent = tabControl1;
                tabControl1.SelectedTab = tabPage3;
            }
            if (e.Node.Name == "car2")//汽车库存单
            {
                tabPage2.Parent = tabControl1;
                tabControl1.SelectedTab = tabPage2;
            }
            if (e.Node.Name == "car3")//汽车库存跟新
            {
                tabPage8.Parent = tabControl1;
                tabControl1.SelectedTab = tabPage8;
            }
            if (e.Node.Name == "car4")//汽车订单
            {
                tabPage4.Parent = tabControl1;
                tabControl1.SelectedTab = tabPage4;
            }
            if (e.Node.Name == "car5")//订单查询
            {
                tabPage10.Parent = tabControl1;
                tabControl1.SelectedTab = tabPage10;
            }
            if (e.Node.Name == "car6")//销售单
            {
                tabPage5.Parent = tabControl1;
                tabControl1.SelectedTab = tabPage5;
            }
            if (e.Node.Name == "car7")//车型销售查看
            {
                tabPage6.Parent = tabControl1;
                tabControl1.SelectedTab = tabPage6;
            }
            if (e.Node.Name == "car8")//车型销售查看
            {
                tabPage7.Parent = tabControl1;
                tabControl1.SelectedTab = tabPage7;
            }

        }

        private void get_bh2()//显示添加汽车信息的编号
        {
            SqlConnection conn = new SqlConnection();
            string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
            conn.ConnectionString = str;
            conn.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.CommandText = "select * from dingdan";
            //cmd.CommandText = "select isnull(max(编号),0)+1 from 基本信息表";
            cmd.Connection = conn;
            SqlDataAdapter sda = new SqlDataAdapter(cmd);
            DataSet ds = new DataSet();
            sda.Fill(ds);
            int t = ds.Tables[0].Rows.Count;
            int bh = t - 1;
            this.textBox1.Text = (Int32.Parse(ds.Tables[0].Rows[bh]["订单单号"].ToString()) + 1).ToString();//汽车进货单编号
            this.textBox3.Text = " ";//汽车类型
            this.textBox4.Text = " ";//汽车
           
            
            this.textBox2.Text = " ";//售价
            
            conn.Close();
        }
        //表示添加汽车的编号和类型
        private void get_cm()
        {
            this.BackColor = Color.LightBlue;
            comboBox1.Items.Add("雪佛兰科迈罗");
            comboBox1.Items.Add("雪佛兰科鲁兹");
            comboBox1.Items.Add("大黄蜂2014版");
            comboBox1.Items.Add("雪佛兰SUV2016");
            comboBox1.DropDownStyle = ComboBoxStyle.DropDownList;
            comboBox2.Items.Add("潍坊旗舰店201");
            comboBox2.Items.Add("旗舰店202");
            comboBox2.Items.Add("旗舰店203");
            comboBox2.Items.Add("旗舰店204");

            comboBox2.DropDownStyle = ComboBoxStyle.DropDownList;

            comboBox3.Items.Add("雪佛兰科迈罗");
            comboBox3.Items.Add("雪佛兰科鲁兹");
            comboBox3.Items.Add("大黄蜂2014版");
            comboBox3.Items.Add("雪佛兰SUV2016");
            comboBox3.DropDownStyle = ComboBoxStyle.DropDownList;

            comboBox4.Items.Add("全额付款");
            comboBox4.Items.Add("分期付款");
            comboBox4.DropDownStyle = ComboBoxStyle.DropDownList;

            comboBox5.Items.Add("李红");
            comboBox5.Items.Add("王皓");
            comboBox5.Items.Add("张震");
            comboBox5.DropDownStyle = ComboBoxStyle.DropDownList;

            comboBox6.Items.Add("雪佛兰科迈罗");
            comboBox6.Items.Add("雪佛兰科鲁兹");
            comboBox6.Items.Add("大黄蜂2014版");
            comboBox6.Items.Add("雪佛兰SUV2016");
            comboBox6.DropDownStyle = ComboBoxStyle.DropDownList;

           comboBox7.Items.Add("1");
            comboBox7.Items.Add("2");
            comboBox7.Items.Add("3");
            comboBox7.Items.Add("4");
            comboBox7.DropDownStyle = ComboBoxStyle.DropDownList;

            comboBox8.Items.Add("1");
            comboBox8.Items.Add("2");
            comboBox8.Items.Add("3");
            comboBox8.Items.Add("4");
            comboBox8.DropDownStyle = ComboBoxStyle.DropDownList;

            
        }


        //刷新订货单信息
        private void get_cm2()
        {
            try
            {
                SqlConnection conn = new SqlConnection();
                string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
                conn.ConnectionString = str;
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.CommandText = "select * from dingdan";
                cmd.Connection = conn;
                SqlDataAdapter sda = new SqlDataAdapter(cmd);
                DataSet ds = new DataSet();
                sda.Fill(ds, "dingdan");
                this.dataGridView2.DataSource = ds;
                this.dataGridView2.DataMember = "dingdan";
                this.dataGridView2.AutoGenerateColumns = true;
                for (int i = 1; i < this.dataGridView2.ColumnCount; i++)
                {
                    this.dataGridView2.Columns[i].DefaultCellStyle.SelectionBackColor = Color.White;
                    this.dataGridView2.Columns[i].DefaultCellStyle.SelectionForeColor = Color.Black;
                    this.dataGridView2.Columns[i].ReadOnly = true;
                }
                conn.Close();
            }
            catch (Exception ee)
            {
                MessageBox.Show("错误：" + ee.Message, "错误");
            }
        }



        //显示销售单
        private void get_cm3()
        {
            try
            {
                SqlConnection conn = new SqlConnection();
                string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
                conn.ConnectionString = str;
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.CommandText = "select * from xiaoshou";
                cmd.Connection = conn;
                SqlDataAdapter sda = new SqlDataAdapter(cmd);
                DataSet ds = new DataSet();
                sda.Fill(ds, "xiaoshou");
                this.dataGridView3.DataSource = ds;
                this.dataGridView3.DataMember = "xiaoshou";
                this.dataGridView3.AutoGenerateColumns = true;
                for (int i = 1; i < this.dataGridView3.ColumnCount; i++)
                {
                    this.dataGridView3.Columns[i].DefaultCellStyle.SelectionBackColor = Color.White;
                    this.dataGridView3.Columns[i].DefaultCellStyle.SelectionForeColor = Color.Black;
                    this.dataGridView3.Columns[i].ReadOnly = true;
                }
                conn.Close();
            }
            catch (Exception ee)
            {
                MessageBox.Show("错误：" + ee.Message, "错误");
            }
            


        }
        //显示图片
        //显示雪佛兰车辆以及种类
        private void pictureBox1_Click(object sender, EventArgs e)
        {
            pictureBox1.Image = imageList1.Images[0];

            pictureBox2.Image = imageList1.Images[1];
            pictureBox3.Image = imageList1.Images[2];
            pictureBox4.Image = imageList1.Images[3];
            SqlConnection conn = new SqlConnection("Data Source=(local);Initial Catalog=Car;Integrated Security=True");
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = conn;
            conn.Open();
            cmd.CommandText = "select * from xuefulan2";
            SqlDataAdapter sda = new SqlDataAdapter(cmd);
            DataSet ds = new DataSet();
            sda.Fill(ds);
            this.textBoxT201.Text = (ds.Tables[0].Rows[0][1].ToString());
            this.textBoxT202.Text = ("库存：" + ds.Tables[0].Rows[0][2].ToString());
            this.textBox10.Text = ("优惠：" + ds.Tables[0].Rows[0][4].ToString());

            this.textBoxT203.Text = (ds.Tables[0].Rows[1][1].ToString());
            this.textBoxT204.Text = ("库存：" + ds.Tables[0].Rows[1][2].ToString());
            this.textBox11.Text = ("优惠：" + ds.Tables[0].Rows[1][4].ToString());

            this.textBoxT205.Text = (ds.Tables[0].Rows[2][1].ToString());
            this.textBoxT206.Text = ("库存：" + ds.Tables[0].Rows[2][2].ToString());
            this.textBox12.Text = ("优惠：" + ds.Tables[0].Rows[2][4].ToString());

            this.textBoxT207.Text = (ds.Tables[0].Rows[3][1].ToString());
            this.textBoxT208.Text = ("库存：" + ds.Tables[0].Rows[3][2].ToString());
            this.textBox13.Text = ("优惠：" + ds.Tables[0].Rows[3][4].ToString());
           /* this.textBoxT205.Text = (ds.Tables[0].Rows[1][1].ToString());
            * 
            this.textBoxT206.Text = ("库存：" + ds.Tables[0].Rows[1][2].ToString());*/

            conn.Close();

        }
        //汽车销售类型
      
        //显示销售单号便于添加
        private void get_bh3()
        {
            
            SqlConnection conn = new SqlConnection();
            string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
            conn.ConnectionString = str;
            conn.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.CommandText = "select * from xiaoshou";
            //cmd.CommandText = "select isnull(max(编号),0)+1 from 基本信息表";
            cmd.Connection = conn;
            SqlDataAdapter sda = new SqlDataAdapter(cmd);
            DataSet ds = new DataSet();
            sda.Fill(ds);
            int t = ds.Tables[0].Rows.Count;
            int bh = t - 1;
            this.textBox5.Text = (Int32.Parse(ds.Tables[0].Rows[bh]["销售单号"].ToString()) + 1).ToString();//汽车销售货单编号

            this.textBox6.Text = " ";//汽车买主
            this.textBox7.Text = " ";//汽车付款
           // this.textBox8.Text = " ";//汽车收买日期
        }
        //库存类型
      
        //显示库存信息
       
        
        //显示汽车种类以及库存



        //进货添加
        private void button1_Click_1(object sender, EventArgs e)
        {
            if (textBox2.Text.Trim() == "" || textBox4.Text.Trim() == ""  || textBox1.Text.Trim() == ""|| textBox3.Text.Trim()==" " )
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
                cmd.CommandText = "insert into dingdan(订单单号,车型,台数,进价,旗舰店名,经理,日期)values(@订单单号,@车型,@台数,@进价,@旗舰店名,@经理,@日期)";
                cmd.Connection = conn;
                cmd.Parameters.Add("@订单单号", SqlDbType.Int);
                cmd.Parameters.Add("@车型", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@台数", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@进价", SqlDbType.VarChar, 30);

                cmd.Parameters.Add("@旗舰店名", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@经理", SqlDbType.VarChar, 30);

                cmd.Parameters.Add("@日期", SqlDbType.VarChar, 30); 

                cmd.Parameters["@订单单号"].Value = textBox1.Text.Trim();
                cmd.Parameters["@车型"].Value = comboBox1.Text.Trim();
                cmd.Parameters["@台数"].Value = textBox2.Text.Trim();
                cmd.Parameters["@进价"].Value = textBox4.Text.Trim();
               
                cmd.Parameters["@旗舰店名"].Value = comboBox2.Text.Trim();
                cmd.Parameters["@经理"].Value = textBox3.Text.Trim();
                cmd.Parameters["@日期"].Value = this.dateTimePicker3.Value.ToString("yyyy/MM/dd");


                cmd.ExecuteNonQuery();
                conn.Close();
            }

            get_cm2();
            get_bh2();
        }
        //销售单添加
        private void button2_Click(object sender, EventArgs e)
        {
            if (textBox5.Text.Trim() == "" || textBox6.Text.Trim() == "" || textBox7.Text.Trim() == "" )
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
                cmd.CommandText = "insert into xiaoshou (销售单号,车型,客户,购买方式,付款,销售员,日期)values(@销售单号,@车型,@客户,@购买方式,@付款,@销售员,@日期)";
                cmd.Connection = conn;
                cmd.Parameters.Add("@销售单号", SqlDbType.Int);
                cmd.Parameters.Add("@车型", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@客户", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@购买方式", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@付款", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@销售员", SqlDbType.VarChar, 30);
                cmd.Parameters.Add("@日期", SqlDbType.VarChar, 30);

                cmd.Parameters["@销售单号"].Value = textBox5.Text.Trim();
                cmd.Parameters["@车型"].Value = comboBox3.Text.Trim();
                cmd.Parameters["@客户"].Value = textBox6.Text.Trim();

                cmd.Parameters["@付款"].Value = textBox7.Text.Trim();
                cmd.Parameters["@购买方式"].Value = comboBox4.Text.Trim();
                cmd.Parameters["@销售员"].Value = comboBox5.Text.Trim();
                cmd.Parameters["@日期"].Value = this.dateTimePicker2.Value .ToString ("yyyy/MM/dd");

                cmd.ExecuteNonQuery();
                conn.Close();
            }
            get_cm3();
            get_bh3();
        }
        //查询的销售单号
        private void button3_Click(object sender, EventArgs e)
        {
            if (textBox9.Text.Trim() == " ")
            {
                MessageBox.Show(" 请输入要查询的单号：", "提示");
            }
            else
            {
                SqlConnection conn = new SqlConnection();
                string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
                conn.ConnectionString = str;
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.CommandText = "select *from xiaoshou where 销售单号='" + this.textBox9.Text.Trim() + "'";
                cmd.Connection = conn;
                //显示在DataGridView.
                SqlDataAdapter sda = new SqlDataAdapter(cmd);//初始化sda
                DataSet ds = new DataSet();
                sda.Fill(ds);
                this.dataGridView3.DataSource = ds;
                this.dataGridView3.DataMember = ds.Tables[0].ToString();
                this.dataGridView3.AutoGenerateColumns = true;
                conn.Close();


            }
        }

       
        

        private void 刷新_Click(object sender, EventArgs e)
        {
            get_cm3();
        }
        //车辆销售查询
        private void button4_Click(object sender, EventArgs e)
        {
            if (comboBox6.Text.Trim() == " ")
            {
                MessageBox.Show(" 请输入要查询的车型：", "提示");
            }
            else
            {
                SqlConnection conn = new SqlConnection();
                string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
                conn.ConnectionString = str;
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.CommandText = "select *from xiaoshou where 车型='" + this.comboBox6.Text.Trim() + "'";
                cmd.Connection = conn;
                //显示在DataGridView.
                SqlDataAdapter sda = new SqlDataAdapter(cmd);//初始化sda
                DataSet ds = new DataSet();
                sda.Fill(ds);
                dataGridView4.Rows.Clear(); 
                this.dataGridView4.DataSource = ds;
                this.dataGridView4.DataMember = ds.Tables[0].ToString();
                this.dataGridView4.AutoGenerateColumns = true;
                conn.Close();


            }
        }

        
        //时期查询
        private void button5_Click(object sender, EventArgs e)
        {

            SqlConnection conn = new SqlConnection();
            string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
            conn.ConnectionString = str;
            conn.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.CommandText = "select *from xiaoshou where 日期='" + this.dateTimePicker1.Value .ToString ("yyyy/MM/dd") + "'";
            cmd.Connection = conn;
            //显示在DataGridView.
            SqlDataAdapter sda = new SqlDataAdapter(cmd);//初始化sda
            DataSet ds = new DataSet();
            sda.Fill(ds);
            this.dataGridView5.DataSource = ds;
            this.dataGridView5.DataMember = ds.Tables[0].ToString();
            this.dataGridView5.AutoGenerateColumns = true;
            conn.Close();
          
        }
        //订单查询
        private void button6_Click(object sender, EventArgs e)
        {
            if (textBox8.Text.Trim() == " ")
            {
                MessageBox.Show(" 请输入旗舰店经历名：", "提示");
            }
            else
            {
                SqlConnection conn = new SqlConnection();
                string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
                conn.ConnectionString = str;
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.CommandText = "select *from dingdan where 经理='" + this.textBox8 .Text.Trim() + "'";
                cmd.Connection = conn;
                //显示在DataGridView.
                SqlDataAdapter sda = new SqlDataAdapter(cmd);//初始化sda
                DataSet ds = new DataSet();
                sda.Fill(ds);
                this.dataGridView6.DataSource = ds;
                this.dataGridView6.DataMember = ds.Tables[0].ToString();
                this.dataGridView6.AutoGenerateColumns = true;
                conn.Close();


            }
        }
        //修改订单
       
        private void 修改订单_Click(object sender, EventArgs e)
        {
            Form5 M4 = new Form5();

           // M4.id == Convert.ToInt32(this.dataGridView6[0, this.dataGridView1.CurrentCell.RowIndex].Value.ToString());
            
            
            

           
            M4.id = Convert.ToInt32(this.dataGridView6[0, this.dataGridView1.CurrentCell.RowIndex].Value.ToString());

            M4.ShowDialog();
           
            
            
            
        }

       

       

       

       
        //汽车库存查看
        private void button8_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection();
            string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
            conn.ConnectionString = str;
            conn.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.CommandText = "select *from  xuefulan2 where 编号='" + this.comboBox8.Text.Trim() + "'";
            cmd.Connection = conn;
            //显示在DataGridView.
            SqlDataAdapter sda = new SqlDataAdapter(cmd);//初始化sda
            DataSet ds = new DataSet();
            sda.Fill(ds);
           //dataGridView7.Rows.Clear();  //清空原有datagridview列表
            this.dataGridView7.DataSource = ds;
            this.dataGridView7.DataMember = ds.Tables[0].ToString();
           this.dataGridView7.AutoGenerateColumns = true;
        }

       
        //库存更新查询
        private void button7_Click_1(object sender, EventArgs e)
        {
            if (comboBox7.Text.Trim() == " ")
            {
                MessageBox.Show(" 请输入要查询的车型：", "提示");
            }
            else
            {
                Form6 m = new Form6();
                m.id = this.comboBox7.Text.Trim();
                m.ShowDialog();
                SqlConnection conn = new SqlConnection();
                string str = "Data Source=(local);Initial Catalog=Car;Integrated Security=True";
                conn.ConnectionString = str;
                conn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.CommandText = "select *from xuefulan2 ";// where 编号='" + this.comboBox7.Text.Trim() + "'";
                cmd.Connection = conn;
                //显示在DataGridView.
                SqlDataAdapter sda = new SqlDataAdapter(cmd);//初始化sda
                DataSet ds = new DataSet();
                sda.Fill(ds);
                dataGridView4.Rows.Clear();
                this.dataGridView8.DataSource = ds;
                this.dataGridView8.DataMember = ds.Tables[0].ToString();
                this.dataGridView8.AutoGenerateColumns = true;
                conn.Close();
            }









        }
      
            //string strconn = "data source=(local); Database=Car;user id=sa1; password=1";
            //SqlConnection conn = new SqlConnection(strconn);
           /* SqlConnection cn = new SqlConnection("Data Source=(local);Database=Car;user id=sa1; password=1");
            SqlCommand cm = new SqlCommand();
            DataSet ds = new DataSet();
            SqlDataAdapter da = new SqlDataAdapter();
            SqlCommandBuilder cb = new SqlCommandBuilder();*/
        //进行更新库存
        
        private void dataGridView6_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
        //name="e"></param>
        //删除订单
        private void button9_Click_1(object sender, EventArgs e)
        {
            if (this.dataGridView6.SelectedCells == null)
            {
                MessageBox.Show("请选择要删¦除的项！", "错误", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                if (this.dataGridView6.CurrentCell.ColumnIndex == 0)
                {
                    string st = this.dataGridView6[0, this.dataGridView6.CurrentCell.RowIndex].Value.ToString();
                    SqlConnection conn = new SqlConnection();
                    string str = "Data Source=(local);Initial Catalog=car;Integrated Security=True";
                    conn.ConnectionString = str;
                    conn.Open();
                    SqlCommand cmd = new SqlCommand();
                    cmd.CommandText = "delete from dingdan  where 订单单号='" + st + "'";
                    cmd.Connection = conn;
                    cmd.ExecuteNonQuery();
                    conn.Close();
                    MessageBox.Show("删除成功", "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);

                }//if
            }//else
        }


        private void buttonF2TC_Click(object sender, EventArgs e)
        {
            this.Close();
        }

      

       
     } 
}

