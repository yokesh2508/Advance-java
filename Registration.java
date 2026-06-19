package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/registration")
public class Registration extends GenericServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		String course=req.getParameter("course");
		String gender=req.getParameter("gender");
		String skills1=req.getParameter("html");
		String skills2=req.getParameter("css");
		String skills3=req.getParameter("js");
		String skills4=req.getParameter("java");
		System.out.println(name+" "+dob+" "+address+" "+course+" "+gender+" "+skills1+" "+skills2+" "+skills3+" "+skills4);
		
		PrintWriter out=res.getWriter();
		res.setContentType("text/HTML");
		out.print("<h1>Student Form</h1>");
		out.print("Name :"+name+"<br>");
		out.print("DOB :"+dob+"<br>");
		out.print("Address :"+address+"<br>");
		out.print("Gender :"+gender+"<br>");
		out.print("Skill1 :"+skills1+"<br>");
		out.print("Skill2 :"+skills2+"<br>");
		out.print("Skill3 :"+skills3+"<br>");
		out.print("Skill4 :"+skills4+"<br>");
	
		try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/postgres";
			String user="postgres";
			String password="root";
			Connection connection=DriverManager.getConnection(url,user,password);
			String sql =
					"INSERT INTO registration(name,dob,address,course,gender,skills) VALUES(?,?,?,?,?,?)";

					PreparedStatement ps = connection.prepareStatement(sql);

					ps.setString(1, name);
					ps.setDate(2, java.sql.Date.valueOf(dob));
					ps.setString(3, address);
					ps.setString(4, course);
					ps.setString(5, gender);
					 String skills = "";

					    if(req.getParameter("html") != null)
					        skills += "HTML,";   //skills=skills+"HTML"------->""+HTML

					    if(req.getParameter("css") != null)
					        skills += "CSS,";

					    if(req.getParameter("js") != null)
					        skills += "JavaScript,";

					    if(req.getParameter("java") != null)
					        skills += "Java,";
					 ps.setString(6, skills);
					int rows = ps.executeUpdate();

					if(rows > 0) {
					    System.out.println("Data Saved Successfully");
					}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
