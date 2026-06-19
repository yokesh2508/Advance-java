import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
public class InsertStu {
       public static void main(String[] args) throws ClassNotFoundException {
    	    try {
				Class.forName("org.postgresql.Driver");
				String url="jdbc:postgresql://localhost:5432/learning_advance_java";
				String user="postgres";
				String password="root";
	            Connection connection=DriverManager.getConnection(url,user,password);
	            String sql="create table Stude(id integer primary key,name character varying,mobno bigint)";
	            Statement statement=connection.createStatement();
	            statement.execute(sql);
	            System.out.println("Columns has been added successfully...");
	            connection.close();
				}
    	        catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
       }
				
//			 catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
       }

