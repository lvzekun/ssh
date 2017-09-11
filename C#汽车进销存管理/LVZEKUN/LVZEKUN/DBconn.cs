using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.SqlClient;
using System.Data;
using System.Threading.Tasks;

namespace LVZEKUN
{
    class DBconn
    {
        public static SqlConnection Camcon()
        {
            return new SqlConnection("Data Source=(local);Initial Catalog=Car;Integrated Security=True");
        }
    }
}
