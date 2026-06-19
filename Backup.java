import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Backup {
     public static void main(String[] args) {
    	 try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/learning_advance_java";
			String user="postgres";
			String password="root";
            Connection connection=DriverManager.getConnection(url,user,password);
            String sql="call get_backup(?,?,?)";
            CallableStatement cs=connection.prepareCall(sql);
            cs.setInt(1,109);
            cs.setString(2,"riyan");
            cs.setLong(3 ,987657432);
           // cs.registerOutParameter(1,Types.INTEGER);
            cs.execute();
          //  System.out.print("Bill: "+cs.getInt(1));
            connection.close();
            System.out.println("data saved");
		 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
}
