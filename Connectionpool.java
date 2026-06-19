import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Connectionpool
    {
    private static final String url="jdbc:postgresql://localhost:5432/learning_advance_java";
    private static final String user="postgres";
    private static final String password="root";
    private static final int pool_size=5;
    private static final List<Connection> CONNECTIONS = new ArrayList<>();
    static {
    	try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(int i=0;i<=5;i++) {
    		CONNECTIONS.add(createConnection());
    	}
    }
    	
    	public static Connection createConnection() {
    		try {
    		    return DriverManager.getConnection(url,user,password);
    		}
    		catch(SQLException e) {
    			e.printStackTrace();
    		}
    	 return null;
    	}
    	
    	public static Connection getConnection() {
    		if(CONNECTIONS.size()>0)
    		{
    			return CONNECTIONS.remove(0);
    		}   
    		return createConnection();
    	}
    	public static void closeConnection(Connection connection) {
    		if(CONNECTIONS.size()<pool_size) {
    			CONNECTIONS.add(connection);
    		}
    		try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}  	
    }

