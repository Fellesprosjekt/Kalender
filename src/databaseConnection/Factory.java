package databaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import appLogic.Employee;

public class Factory {
	
	DBConnection db;
	
	
	public Factory(Properties properties) throws ClassNotFoundException, SQLException
	{
		 db=new DBConnection(properties);
	}
	
	public  Employee  createEmployee(String name) throws ClassNotFoundException, SQLException
	{
		Employee e= new Employee(name);
		String query=String.format("insert into employee " +
				"(name) values ('%s')",name); 
		db.initialize();
		db.makeSingleUpdate(query);
		db.close();
		
		return e;
	}
	
	public Employee getEmployee(String email) throws ClassNotFoundException, SQLException
	{
		
		String emailYearString="peterts@stud.ntnu.no";//done for demonstration reasons
		
		String query=String.format("Select name,%s from employee where id=%d",emailYearString,email);
		db.initialize();
		ResultSet rs=db.makeSingleQuery(query);
		String name=null;
		while(rs.next())
		{
			name=rs.getString(1);
		}
		
		Employee e=new Employee(name);
		rs.close();
		db.close();
		
		return e;
	
		
	}
	
	public void deleteEmployee()
	{
		;
	}
	public void updateEmployee()
	{
		;
	}

}