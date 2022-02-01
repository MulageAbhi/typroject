package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NoSelectQueryExmpl {

	public static void main(String[] args) throws Throwable  {
Connection conn=null;
int res=0;
try {
Driver driverref=new Driver();
DriverManager.registerDriver(driverref);
conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");

Statement stat=conn.createStatement();
String actualquery="insert into project values('TY_PROJ_004','Deepak','12/01/2022','HDFC','on going',10)";
 res=stat.executeUpdate(actualquery);

}
catch(Exception e) {
System.out.println("exception handled");
}
finally {
	if(res==1) {
		System.out.println("values inserted sucessfully");
	}
	else {
		System.out.println("vlues insertion is failed");
	}
	conn.close();
	System.out.println("---connection closed----");
}
	}

}
