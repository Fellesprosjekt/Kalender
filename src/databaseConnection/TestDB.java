package databaseConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;

import databaseConnection.DBConnection;


public class TestDB {
	
	
	public void test(Properties p) throws SQLException, ClassNotFoundException
	{
		DBConnection db=new DBConnection(p);
		
		String insert="insert into calendaruser (email,uname, UType)" +
				" values('mail@eksempel.org','Peter','Employee')";
		db.initialize();
		db.makeSingleUpdate(insert);
		db.close();
		
	}
	
	
	public void batchTest(Properties p) throws SQLException, ClassNotFoundException
	{
		DBConnection db=new DBConnection(p);
		db.initialize();
		String insert="insert into calendaruser (email,uname, utype) values (?,?,'Employee')";
		PreparedStatement ps=db.preparedStatement(insert);
		
		String email=null;
		String name=null;
		String type=null;
		Scanner sc=new Scanner(System.in);
		String line=sc.nextLine();
		while(line.trim().length()>3)
		{
			StringTokenizer t=new StringTokenizer(line);
			email=t.nextToken();
			name=t.nextToken();
			type=t.nextToken();
			ps.setString(1, email);
			ps.setString(2,name);
			ps.setString(3,type);
			ps.addBatch();
			line=sc.nextLine();
		}
		sc.close();
		
		ps.executeBatch();
		ps.close();
		db.close();	
	}
	
	
	public void readTest(Properties p) throws ClassNotFoundException, SQLException
	{
		DBConnection db=new DBConnection(p);
		
		String sql="select name from employee";
		
		db.initialize();
		ResultSet rs=db.makeSingleQuery(sql);
		ResultSetMetaData meta=rs.getMetaData();
		rs.beforeFirst();
		System.out.print("Col1:"+meta.getSchemaName(1));
		while(rs.next())
		{
			String name=rs.getString(1);
			System.out.println(String.format("%s\n",name));
		}
		rs.close();
		db.close();	
	}
	
	
	public static void main(String args[]) 
	{
		TestDB t=new TestDB();
		Properties p=new Properties();
		try {
			p.load(new FileInputStream(new File("Properties.properties")));
			//t.readTest(p);
			t.batchTest(p);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}