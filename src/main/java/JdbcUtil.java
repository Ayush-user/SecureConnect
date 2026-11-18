import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver is registered");
		
	}
		public static Connection getConnection() throws SQLException {
			String url="jdbc:postgresql://localhost:5432/ServletRegistrationApp";
			String userName="postgres";
			String password="ayush8822";
			return DriverManager.getConnection(url,userName,password);
		}
		
		public static void closeResource(Connection connect,Statement stmt) throws SQLException {
			if(connect!=null) {
				connect.close();
			} 
			if(stmt!=null) {
				stmt.close();
			}
		}
	
}
