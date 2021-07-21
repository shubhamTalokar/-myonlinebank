

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckAccountServlet")
public class CheckAccountServlet extends HttpServlet 
{
	PrintWriter out;
	String email;
	int acno;
	float amt;
	Database db;
	String msg;
	String url;
	boolean status = false;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		out = response.getWriter();
		response.setContentType("text/html");
		db = new Database();
		
		acno = Integer.parseInt(request.getParameter("tacno1"));
		email = request.getParameter("temail1");
				
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
		
		
					
		out.print("<div id='contenttext'><div style='padding:10px'><span class='titletext'>Welcome to Mybank!</span></div>");
		out.print("<div class='bodytext' style='padding:12px;' align='justify'>");
	
	
			try 
			{
				amt = db.checkAccount(acno,email);
				msg="Balance in your account = " + amt + " !!!";
					out.print("<div id='menu'> <div align='right' class='smallwhitetext' style='padding:9px;'> "
						+ "<a href='userhome.html'>User-Home</a> | "
						+ "<a href='myaccount.html'>My-Account</a> | "
						+ "<a href='trans.html'>Transactions</a> | "
						+ "<a href='banktra.html'>Bank-Transfer</a> | "
						+ "<a href='index.html'>Logout</a> </div> </div>");
		
			}
			catch(Exception e) {e.printStackTrace();}
			out.print("<h3 style='text-align:center;display: inline-block;\r\n"
					+ "  border: 1px solid black;'>"+msg+"</h3></div></div>");
		
		out.print("<div id='contenttext'>"
				+ "				<div style=padding:10px>"
				+ "					</div>\r\n"
				+ "					<div class=bodytext style=padding:12px; align=justify>"
				+ "					  <img src='/Myonlinebank/images/home.jpg' width=500 height=300></img>"
				+ "				</div>"
				+ "			</div>");
		
		out.print("<div id=footer class=smallgraytext>| MyOnlineBank | &copy; 2021 |</div></div>");  
	
		out.print("</body></html>");
		out.close();
	}
}
