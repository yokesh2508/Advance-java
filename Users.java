package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class Users extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int Id=Integer.parseInt(req.getParameter("id"));
    	String Name=req.getParameter("name");
    	String Email=req.getParameter("email");
    	String Pass=req.getParameter("password");
    	String Phone=req.getParameter("phone");
    	
    	PrintWriter out=resp.getWriter();
    	resp.setContentType("text/HTML");
    	out.print("<h1>User Details</h1>");
    	out.print("Id :"+Id+"<br>");
    	out.print("Name :"+Name+"<br>");
    	out.print("Email :"+Email+"<br>");
    	out.print("Password :"+Pass+"<br>");
    	out.print("Phone Number :"+Phone+"<br>");
    	
    	
    	
    	try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/user_db";
			String user="postgres";
			String password="root";
			Connection connection=DriverManager.getConnection(url,user,password);
			String sql="insert into users(id,name,email,password,phone) values(?,?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, Id);
			ps.setString(2, Name);
			ps.setString(3, Email);
			ps.setString(4, Pass);
			ps.setString(5, Phone);
			
			int rows=ps.executeUpdate();
			
			if(rows>0) {
				System.out.println("Data Saved Successfully...");
			}
			ps.close();
		}
    	catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
       }
}
