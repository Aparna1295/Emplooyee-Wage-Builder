public class EmployeeWageComputation{

  //CONSTANTS DECLARATION
	public static final int IS_PART_TIME =1;
   public static final int IS_FULL_TIME =2;
	public static final int EMP_RATE_PER_HOUR=20;
	public static final int NO_OF_WORKING_DAYS=20;

	public static void main(String[] args){
		System.out.println("****************Welcome to Employee WAge COmputation**************");

		//VARIABLES DECLARATION
		int empHrs= 0;
		int dailyWage=0;
		int monthlyWage=0;
		int day;

		//COMPUTE MONTHLY WAGE USING FOR LOOP
		for(day=1; day<NO_OF_WORKING_DAYS; day++){

		//CHECK USER INPUT THROUGH RANDOM()
			int empCheck = (int)Math.floor(Math.random()*10)%3;
		//CHECK WHETHER EMPLOYEE IS PRESENT FULL TIME/PART TIME OR ABSENT 
			switch(empCheck){
				case IS_FULL_TIME:
					System.out.println("Employee is Present for Full Day");
					empHrs=8;
					break;

				case IS_PART_TIME:
      			System.out.println("Employee is Present for Half Day");
         		empHrs=4;
					break;

				default:
					System.out.println("Employee is Absent");
					empHrs=0;
			}

		//COMPUTE DAILY WAGE OF AN EMPLOYEE USING CASE
 			dailyWage=empHrs * EMP_RATE_PER_HOUR;
			monthlyWage+=dailyWage;
			System.out.println("Daily Wage of an Employee for Day" +day+":"+dailyWage);
		}
      System.out.println("Monthly Wage of an Employee for "+day+" Days:"+monthlyWage);

	}


}
