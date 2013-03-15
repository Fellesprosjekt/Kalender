package databaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import appLogic.Employee;
import appLogic.InvalidEmailException;
import appLogic.InvalidNameException;

public class Factory {
	
	DBConnection db;
	
	
	public Factory(Properties properties) throws ClassNotFoundException, SQLException
	{
		 db=new DBConnection(properties);
	}
	
	public  Employee  createEmployee(String name, String email) throws ClassNotFoundException, SQLException, InvalidNameException, InvalidEmailException
	{
		Employee e= new Employee(name, email);
		String query=String.format("insert into employee " +
				"(name, email, 'Employee') values ('%s','%s',)",name,email); 
		db.initialize();
		db.makeSingleUpdate(query);
		db.close();
		
		return e;
	}
	
	public Employee getEmployee(String email) throws ClassNotFoundException, SQLException, InvalidNameException, InvalidEmailException
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
		
		Employee e= new Employee(name,email);
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