import java.util.*;
import java.text.*;

class KYC
{
	 String startdate, enddate;
	 Date signUpDate, currentDate;
	 Date startDate, endDate;
	 public  void rangeOfDates(String SignUpDate, String CurrentDate) throws ParseException 
	 {
		
			//Converting the given string to a date format
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			currentDate= formatter.parse(CurrentDate);
			signUpDate = formatter.parse(SignUpDate);
			if(signUpDate.after(currentDate)) 
			{
				System.out.println("No range");
			}
			else
			{
				startDate = signUpDate;
				//setting the year to current  year 
				startDate.setYear(currentDate.getYear());
				Calendar calendar = Calendar.getInstance();
 				calendar.setTime(startDate);
 				//The form needs to be filled on +-30 days signup anniversary
				calendar.add(Calendar.DATE, -30);
				//past the +-30 days then we are backdating it
				calendar.add(Calendar.DATE, 60);
				endDate=calendar.getTime();
				//for those who fall in the +-30 days of signup anniversary we set it to currentDate
				if(endDate.after(currentDate)) {
					endDate=currentDate;
				}
			}
			startdate=formatter.format(startDate);
			enddate=formatter.format(endDate);
			System.out.print(startdate);
			System.out.print("	");
			System.out.println(enddate);
		
		
		
	}
}

class KYCFormDates {

	public static void main(String[] args) throws ParseException {
		KYC obj =new KYC();
		obj.rangeOfDates("16-07-1998", "27-06-2017");
		obj.rangeOfDates("04-02-2016", "04-04-2017");
		obj.rangeOfDates("04-05-2017", "04-04-2017");
		obj.rangeOfDates("04-04-2015", "04-04-2016");
		obj.rangeOfDates("04-04-2015", "15-03-2016");
	}

}
