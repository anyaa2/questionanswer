import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Marks extends HttpServlet
{ public void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException
{ response.setContentType("text/html");
PrintWriter out = response.getWriter();
try
{ out.print("<html><body>");
int total=Integer.parseInt(request.getParameter("total"));
int marks=0;
for(int i=1; i<=total; i++)
{
String sel=request.getParameter(Integer.toString(i));
String ans=request.getParameter("ans"+i);
if (sel.equals(ans)) marks++;
}
out.println("Total Marks : "+marks);
out.print("</body></html>");
}
catch(NumberFormatException e)
{
out.println("ERROR "+e.getMessage());
}
}
}
