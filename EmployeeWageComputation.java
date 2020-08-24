public class EmployeeWageComputation{

  //CONSTANTS DECLARATION
	public static final int IS_PART_TIME =1;
   public static final int IS_FULL_TIME =2;

	public static int computeWage(String company, int ratePerHr, int noOfDaysPerMonth, int maxHrsPerMonth){

		//VARIABLES DECLARATION
		int dailyHrs= 0;
		int monthlyHrs=0;
		int dailyWage=0;
		int monthlyWage=0;
		int day=1;

		//COMPUTE MONTHLY WAGE UNTIL MAX HOURS(100) OR MAX NO OF WORKING DAYS(20) REACHES
		System.out.println("-----------Employee Wage Computation for "+company+"------------");
		while(monthlyHrs<=maxHrsPerMonth && day < noOfDaysPerMonth){
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
 			dailyWage=dailyHrs * ratePerHr;
			monthlyWage+=dailyWage;
			System.out.println("Daily Wage of an Employee for Day" +day+":"+dailyWage);
		}
      System.out.println("Monthly Wage of an Employee for "+monthlyHrs+" Hours and "+day+" Days:"+monthlyWage);
		return monthlyWage;
	}

	public static void main(String[] args){
		System.out.println("****************Welcome to Employee Wage Computation**************");
		computeWage("Accenture",15,20,84);
      computeWage("Citi Corp",20,22,98);

	}

}
