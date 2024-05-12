MyServlet.java
package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	 /** Initializes the servlet.
	 */
	 public void init(ServletConfig config) throws ServletException {
	 super.init(config);
	 }
	 /** Destroys the servlet.
	 */
	 public void destroy() {
	 }
	 
	 public String display(int mark)
	 {
	 if(mark>90 && mark<=100)
	 {
	 return "S";
	 }
	 else if(mark>80 && mark<=90)
	 {
	 return("A");
	 }
	 else if(mark>70 && mark<=80)
	 {
	 return("B");
	 }
	 else if(mark>60 && mark<=70)
	 {
	 return("C");
	 }
	 else if(mark>55 && mark<=60)
	 {
	 return("D");
	 }
	 else if(mark>=50 && mark<55)
	 {
	 return("E");
	 }
	 else
	 {
	 return("Re Appear");
	 }
	 } 
	 
	 /** Handles the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 */
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
	 
	 response.setContentType("text/html");
	 PrintWriter out = response.getWriter();
	 int total=0;
	 int per;
	 try {
	 String name, reg;
	 int mark,s1,s2,s3,s4,s5,s6;
	 name = request.getParameter("name");
	 reg = request.getParameter("reg");
	 s1 = Integer.parseInt(request.getParameter("sub1"));
	 s2 = Integer.parseInt(request.getParameter("sub2"));
	 s3 = Integer.parseInt(request.getParameter("sub3"));
	 s4 = Integer.parseInt(request.getParameter("sub4"));
	 s5 = Integer.parseInt(request.getParameter("sub5"));
	 s6 = Integer.parseInt(request.getParameter("sub6"));
	 total=s1+s2+s3+s4+s5+s6;
	 per=total/6;
	 response.setContentType("text/html");
	 out.println("<html>");
	 out.println("<head>");
	 out.println("<title>Mark Report Servlet</title>");
	 out.println("</head>");
	 out.println("<body>");
	 out.println("<center><p><h2><b>Name :" + name + "</p>");
	 out.println("<p><b>Reg No :" + reg + "</p>");
	 out.println("<p><b>Your Mark Details</p></center>");
	 out.println("<center><table border=2 cellpadding=5 cellspacing=5>");
	 out.println("<tr><th>Subjects</th><th>Mark</th><th>Grade</th></tr>");
	 out.println("<tr><th>Sub1</th><td>"+s1 + "</td>/<td>" + display(s1) + 
	"</td></tr>");
	 out.println("<tr><th>Sub2</th><td>"+s2 + "</td><td>" + display(s2) + 
	"</td></tr>");
	 out.println("<tr><th>Sub3</th><td>"+s3 + "</td><td>" + display(s3) + 
	"</td></tr>");
	 out.println("<tr><th>Sub4</th><td>"+s4 + "</td><td>" + display(s4) + 
	"</td></tr>");
	 out.println("<tr><th>Sub5</th><td>"+s5 + "</td><td>" + display(s5) + 
	"</td></tr>");
	 out.println("<tr><th>Sub6</th><td>"+s6 + "</td><td>" + display(s6) + 
	"</td></tr></table>");
	 out.println("<B>ToTal:<input type=text value="+total+">");
	 out.println("<B>Percentage:<input type=text value="+per+">");
	 out.println("<B>Your Overall Grade is :<input type=text value="+display(per)+">"); 
	 out.println("</body>");
	 out.println("</html>");
	 } 
	 finally
	 {
	 out.close();
	 }
	 }
	 }
