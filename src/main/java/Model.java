import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Model {
	
	private String uname;
	private String email;
	private String password;
	private String ucity;
	
	private Connection connect;
	private PreparedStatement pstmnt;
	private int row;
	
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	
	public int register() {
		try {
			connect=JdbcUtil.getConnection();
			String sql="INSERT INTO personalinfo VALUES(?,?,?,?)";
			pstmnt=connect.prepareStatement(sql);
			
			pstmnt.setString(1,uname );
			pstmnt.setString(2,email );
			pstmnt.setString(3,password );
			pstmnt.setString(4,ucity);
			
			row=pstmnt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeResource(connect, pstmnt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public boolean login(String username, String password) {
		boolean result=false;
		try {
			Connection connect=JdbcUtil.getConnection();
			String sql="SELECT * FROM personalinfo WHERE uname=? and password=?";
			PreparedStatement ps=connect.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.closeResource(connect, pstmnt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public ResultSet getUsers(String currentUser) {

	    ResultSet rs = null;

	    try {

	        connect = JdbcUtil.getConnection();

	        String sql = "SELECT uname FROM personalinfo WHERE uname <> ?";

	        pstmnt = connect.prepareStatement(sql);

	        pstmnt.setString(1, currentUser);

	        rs = pstmnt.executeQuery();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rs;
	}
	
	
	public ResultSet getMessages(String sender, String receiver) {

		ResultSet rs = null;

		try {

			connect = JdbcUtil.getConnection();

			String sql = "SELECT * FROM chatmessages "
					+ "WHERE (sender=? AND receiver=?) "
					+ "OR (sender=? AND receiver=?) "
					+ "ORDER BY sent_time";

			pstmnt = connect.prepareStatement(sql);

			pstmnt.setString(1, sender);
			pstmnt.setString(2, receiver);
			pstmnt.setString(3, receiver);
			pstmnt.setString(4, sender);

			rs = pstmnt.executeQuery();

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return rs;
	}
	
	
	public int sendMessage(String sender, String receiver, String message) {

		int row = 0;

		try {

			connect = JdbcUtil.getConnection();

			String sql = "INSERT INTO chatmessages(sender,receiver,message) VALUES(?,?,?)";

			pstmnt = connect.prepareStatement(sql);

			pstmnt.setString(1, sender);
			pstmnt.setString(2, receiver);
			pstmnt.setString(3, message);

			row = pstmnt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return row;
	}
	
	
}
