package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ProjectUnitTest {
	@Test
	public void projectUnitTest() throws Throwable{
		String projectname="HDFC";
		Connection conn=null;
		//try {
			
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			System.out.println("connection done");
			Statement stat=conn.createStatement();
			String query="select * from project";
			ResultSet rset=stat.executeQuery(query);
			boolean flag=false;
			while(rset.next())
			{
				String actproject=rset.getString(4);
				if(actproject.equals(projectname))
				{
					flag=true;
				}
			}
			Assert.assertTrue(flag);
		//}
	//catch{
			
	//	}
	//	finally {
			conn.close();
			System.out.println("---connecton closed----");
		//}
	}


}
