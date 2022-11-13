import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class QueAnsDBServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException
{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
try
{
out.print("<html><body><br>");
out.println("<form method='post' action='Marks'>");
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/questionsdb","root","123");
Statement st = con.createStatement();
String sql="select * from queans";
ResultSet rs = st.executeQuery(sql);
int i=0;
out.print("<center>Online Exam</center>");
while(rs.next())
{
i++;
out.print("<br><br><hr>"+rs.getInt(1)+" ");
out.print(rs.getString(2));
out.print("<br><input type=radio name="+i+" value=1>"+rs.getString(3));
out.print("<br><input type=radio name="+i+" value=2>"+rs.getString(4));
out.print("<br><input type=radio name="+i+" value=3>"+rs.getString(5));
out.print("<br><input type=radio name="+i+" value=4>"+rs.getString(6));
String ans="ans"+i;
out.println("<br><input type=hidden name="+ans+" value="+rs.getString(7)+">");
}
out.println("<br><input type=hidden name=total value="+i+">");
out.println("<input type=submit value=submit>");
out.println("</form>");
out.print("</body></html>");
}
catch(ClassNotFoundException | SQLException e)
{
out.println("ERROR "+e.getMessage());
}
}
}
/* create database questionsdb;
use questionsdb;
create table queans(queno integer primary key,question varchar (200),opt1 varchar (100),opt2 varchar (100),opt3 varchar (100),anskey varchar 1);
insert into queans values('1','what is RDBMS?','Relational Database System','Releational','Database','Redbms','1');
insert into queans values('2','what is COMPUTER?','Electronic Device','Calculator','Mobile','','1');
insert into queans values('3','Who is Saurar?','Smart','Dumb','Medium','','1');
*/