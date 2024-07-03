import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
	public void service(HttpServletRequest rq,HttpServletResponse res) throws ServletException, IOException{
		String Username=rq.getParameter("Username");
		String Password=rq.getParameter("Password");
		
		try {
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","root");
			String str="select * from user where Username=? and Password=?;";
			PreparedStatement ps=cn.prepareStatement(str);
			ps.setString(1, Username);   //this 1 is represent the ? (1st phaseholder)
			ps.setString(2, Password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int mark1=rs.getInt(3);
				int mark2=rs.getInt(4);
				//return true;
					HttpSession htp=rq.getSession();
					htp.setAttribute("mark1",mark1);
					HttpSession htp1=rq.getSession();
					htp1.setAttribute("mark2",mark2);
					RequestDispatcher rs1=rq.getRequestDispatcher("NewFile.jsp");
					rs1.forward(rq, res);
				}else {
			RequestDispatcher rs2=rq.getRequestDispatcher("login.html");
			rs2.forward(rq, res);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}