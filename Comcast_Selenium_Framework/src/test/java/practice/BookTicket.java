package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicket {

	@Test(dataProvider = "dtatProvoider_bookTicketsTest")
	public void bookTicketTest(String src,String dest) {
		System.out.println("book tickets from "+src+" to "+dest);
		
	}
@DataProvider
public Object[][] dtatProvoider_bookTicketsTest(){
	Object[][] objArr=new Object[5][2];
	
	objArr[0][0]="Bangalore";
	objArr[0][1]="Goa";
	
	objArr[1][0]="Bangalore";
	objArr[1][1]="Mumbai";
	
	objArr[2][0]="Delhi";
	objArr[2][1]="Bangalore";
	
	objArr[3][0]="Bangalore";
	objArr[3][1]="Mysore";
	
	objArr[4][0]="Bangalore";
	objArr[4][1]="Patna";
	
	return objArr;
}
}
