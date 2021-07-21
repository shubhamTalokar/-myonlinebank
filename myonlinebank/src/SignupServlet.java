
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet 
{
	PrintWriter out;
	String email, passw1, passw2;
	Database db;
	String msg;
	String url;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		out = response.getWriter();
		response.setContentType("text/html");
		db = new Database();
		
		email = request.getParameter("temail1");
		passw1 = request.getParameter("tpass1");
		passw2 = request.getParameter("tpass2");
	
		url="<link rel='stylesheet' type='text/css' href='css/style.css'>";
		System.out.println(url);
		out.println("<html>");
	    out.println("<head><title>Title Name</title>"+url+"</head>");
	    out.println("<body>");
		
		out.print("<div id='page' align='center'>"); 
		out.print("<div id='content' style='width:800px'>");
		out.print("<div id='logo'>	<div style='"
				+ "margin-top:70px' class='whitetitle'>MyBank</div> "
				+ "</div> <div id='topheader'> <div align='left' class='bodytext'> <br /> "
				+ "<strong>Our Address</strong><br /> 25, Sai Nagar<br /> "
				+ "Amravati, Maharashtra<br /> Phone: 432-653-3121<br /> info@mybank.com </div> </div>");
		out.print("<div id='menu'> <div align='right' class='smallwhitetext' style='padding:9px;'> "
				+ "<a href='index.html'>Home</a> | "
				+ "<a href='#'>About Us</a> | "
				+ "<a href='#'>Products</a> | "
				+ "<a href='#'>Our Services</a> | "
				+ "<a href='#'>Contact Us</a> </div> </div>");
		
					
		out.print("<div id='contenttext'><div style='padding:10px'><span class='titletext'>Welcome to Mybank!</span></div>");
		out.print("<div class='bodytext' style='padding:12px;' align='justify'>");
	
		if(! passw1.equals(passw2))
		{
			msg="Password does not match !!";
			out.print("<h1 style='text-align:center'>"+msg+"</h1></div></div>");
		}
		else
		{
			try 
			{
				if (db.storeUser(email, passw1)==true)
					msg="Signup Successful !!";
				else
					msg="Signup Failed !!";
			}
			catch(Exception e) {e.printStackTrace();}
			
			out.print("<h1 style='text-align:center'>"+msg+"</h1></div></div>");
		}
		
		out.print("<div id='contenttext'>"
				+ "				<div style=padding:10px>"
				+ "					</div>\r\n"
				+ "					<div class=bodytext style=padding:12px; align=justify>"
				+ "					  <img src='/Myonlinebank/images/home.jpg' width=500 height=300></img>"
				+ "				</div>"
				+ "			</div>");
		out.print("<div id=leftpanel>\r\n"
				+ "				<div align=justify class=graypanel>\r\n"
				+ "					<span class=smalltitle>User Area</span><br /><br />\r\n"
				+ "					<h3> User Login</h3>\r\n"
				+ "					<form method=post action=LoginServlet>\r\n"
				+ "						<table>\r\n"
				+ "							<tr>\r\n"
				+ "								<td>\r\n"
				+ "									EmailID\r\n"
				+ "								</td>\r\n"
				+ "								<td>\r\n"
				+ "									<input type=email size=15 name=temail />\r\n"
				+ "								</td>\r\n"
				+ "							</tr>\r\n"
				+ "							<tr>\r\n"
				+ "								<td>\r\n"
				+ "									Password\r\n"
				+ "								</td>\r\n"
				+ "								<td>\r\n"
				+ "									<input type=password size=15 name=tpass />\r\n"
				+ "								</td>\r\n"
				+ "							</tr>\r\n"
				+ "							<tr>\r\n"
				+ "								<td>\r\n"
				+ "									\r\n"
				+ "								</td>\r\n"
				+ "								<td>\r\n"
				+ "									<input type=submit value=LOGIN />\r\n"
				+ "								</td>\r\n"
				+ "							</tr>\r\n"
				+ "						</table>\r\n"
				+ "					</form>\r\n"
				+ "					\r\n"
				+ "					<h3> User Signup </h3>\r\n"
				+ "					<form method=post action=SignupServlet>\r\n"
				+ "						<table>\r\n"
				+ "							<tr>\r\n"
				+ "								<td>\r\n"
				+ "									EmailID\r\n"
				+ "								</td>\r\n"
				+ "								<td>\r\n"
				+ "									<input type=email size=15 name=temail1 />\r\n"
				+ "								</td>\r\n"
				+ "							</tr>\r\n"
				+ "							<tr>\r\n"
				+ "								<td>\r\n"
				+ "									Password\r\n"
				+ "								</td>\r\n"
				+ "								<td>\r\n"
				+ "									<input type=password size=15 name=tpass1 />\r\n"
				+ "								</td>\r\n"
				+ "							</tr>\r\n"
				+ "							<tr>\r\n"
				+ "								<td>\r\n"
				+ "									Re-Password\r\n"
				+ "								</td>\r\n"
				+ "								<td>\r\n"
				+ "									<input type=password size=15 name=tpass2 />\r\n"
				+ "								</td>\r\n"
				+ "							</tr>\r\n"
				+ "							<tr>\r\n"
				+ "								<td>\r\n"
				+ "									\r\n"
				+ "								</td>\r\n"
				+ "								<td>\r\n"
				+ "									<input type=submit value=SIGNUP />\r\n"
				+ "								</td>\r\n"
				+ "							</tr>\r\n"
				+ "						</table>\r\n"
				+ "					</form>\r\n"
				+ "				</div>\r\n"
				+ "			</div>");
		out.print("<div id=footer class=smallgraytext>| MyOnlineBank | &copy; 2021 |</div></div>");  
	
		out.print("</body></html>");
		out.close();

	}

}
