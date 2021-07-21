// database class for all database operations
import java.sql.*;

public class Database 
{
	Connection cnn;
	PreparedStatement stat;
	ResultSet res;

	String driver="com.mysql.cj.jdbc.Driver";
	String dsn="jdbc:mysql://localhost/myonlinebank", user="root", pwd="admin";
	
	public Database()
	{
		try
		{
			Class.forName(driver);
			cnn=DriverManager.getConnection(dsn,user,pwd);
		}
		catch(Exception e1) { e1.printStackTrace(); }
	}
	
	public boolean storeUser(String email, String passw) throws Exception
	{
		stat=cnn.prepareStatement("insert into users values('"+email+"','"+passw+"')");
		if(stat.executeUpdate() > 0 )
			return true; // if stored into table
		else
			return false; // if not stored into table
	}
	
	public boolean storeAccount(int acno, String email, float amt) throws Exception
	{
		stat=cnn.prepareStatement("insert into accounts values('"+acno+"','"+email+"','"+amt+"')");
		if(stat.executeUpdate() > 0 )
			return true; // if stored into table
		else
			return false; // if not stored into table
	}
	
	public boolean storeTrans(int acno, String email, float amt, String type) throws Exception
	{
		if(type.equals("Deposit"))
			stat=cnn.prepareStatement("update accounts set balance=balance + '"+amt+"' "
					+ "where acno='"+acno+"' and emaild='"+email+"'");
		else
			stat=cnn.prepareStatement("update accounts set balance=balance - '"+amt+"' "
					+ "where acno='"+acno+"' and emaild='"+email+"'");
		
		if(stat.executeUpdate() > 0 )
			return true; // if stored into table
		else
			return false; // if not stored into table
	}
	
	public boolean moneyTrans(int acno1,int acno2, String email, float amt) throws Exception
	{
		stat=cnn.prepareStatement("update accounts set balance=balance + '"+amt+"' "
					+ "where acno='"+acno2+"' and emaild='"+email+"'");
				
		if(stat.executeUpdate() > 0 )
		{
			stat=cnn.prepareStatement("update accounts set balance=balance - '"+amt+"' "
					+ "where acno='"+acno1+"' and emaild='"+email+"'");
			stat.executeUpdate();
			return true; // if stored into table
			
		}
		else
			return false; // if not stored into table
	}
	
	public boolean checkUser(String email, String passw) throws Exception
	{
		stat=cnn.prepareStatement("select * from users where emailid='"+email+"' and password='"+passw+"'");
		res=stat.executeQuery();
		if(res.next())
			return true; // if semail and password found in table
		else
			return false; // if not stored into table
	}
	
	public float checkAccount(int acno,String email) throws Exception
	{
		float amt=0.0f;
		stat=cnn.prepareStatement("select * from accounts where acno='"+acno+"' and emaild='"+email+"'");
		res=stat.executeQuery();
		if(res.next())
		{
			amt = res.getFloat(3);
		}
		return amt;
	}
	
}
