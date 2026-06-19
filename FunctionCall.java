import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FunctionCall {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/learning_advance_java";
			String user="postgres";
			String password="root";
			Connection connection=DriverManager.getConnection(url,user,password);
			String sql="select start_with(?)";
			CallableStatement cs=connection.prepareCall(sql);
			cs.setString(1,"k");
			ResultSet rs=cs.executeQuery();
			rs.next();
			System.out.print(rs.getInt(1));
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
