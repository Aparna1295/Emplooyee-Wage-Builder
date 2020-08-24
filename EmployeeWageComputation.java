public class EmployeeWageComputation{

  //CONSTANTS DECLARATION
	public static final int IS_PART_TIME =1;
   public static final int IS_FULL_TIME =2;
	public static final int EMP_RATE_PER_HOUR=20;
	public static final int NO_OF_WORKING_DAYS=20;
	public static final int MAX_HRS_IN_A_MONTH=100;

	public static int computeWage(){
		System.out.println("****************Welcome to Employee WAge COmputation**************");

		//VARIABLES DECLARATION
		int dailyHrs= 0;
		int monthlyHrs=0;
		int dailyWage=0;
		int monthlyWage=0;
		int day=1;

		//COMPUTE MONTHLY WAGE UNTIL MAX HOURS(100) OR MAX NO OF WORKING DAYS(20) REACHES

		while(monthlyHrs<=MAX_HRS_IN_A_MONTH && day < NO_OF_WORKING_DAYS){
			day++;
		//CHECK USER INPUT THROUGH RANDOM()
			int empCheck = (int)Math.floor(Math.random()*10)%3;
		//CHECK WHETHER EMPLOYEE IS PRESENT FULL TIME/PART TIME OR ABSENT 
			switch(empCheck){
				case IS_FULL_TIME:
					System.out.println("Employee is Present for Full Day");
					dailyHrs=8;
					break;

				case IS_PART_TIME:
      			System.out.println("Employee is Present for Half Day");
         		dailyHrs=4;
					break;

				default:
					System.out.println("Employee is Absent");
					dailyHrs=0;
			}

			//CALCULATE WORKING HOURS
			monthlyHrs+=dailyHrs;
			System.out.println("Working Hours for Day"+day+": "+monthlyHrs);
			//COMPUTE DAILY WAGE OF AN EMPLOYEE
 			dailyWage=dailyHrs * EMP_RATE_PER_HOUR;
			monthlyWage+=dailyWage;
			System.out.println("Daily Wage of an Employee for Day" +day+":"+dailyWage);
		}
      System.out.println("Monthly Wage of an Employee for "+monthlyHrs+" Hours and "+day+" Days:"+monthlyWage);
		return monthlyWage;
	}

public static void main(String[] args){
computeWage();
}

}
