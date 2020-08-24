public class EmployeeWageComputation{
	public static void main(String[] args){
		System.out.println("****************Welcome to Employee WAge COmputation**************");
		//CONSTANTS DECLARATION
		int IS_PART_TIME =1;
		int IS_FULL_TIME =2;

		int EMP_RATE_PER_HOUR=20;

		//VARIABLES DECLARATION
		int empHrs= 0;
		int empWage=0;

		//CHECK USER INPUT THROUGH RANDOM()
		double empCheck = Math.floor(Math.random()*10)%3;
		//CHECK WHETHER EMPLOYEE IS PRESENT OR ABSENT
		if (empCheck == IS_FULL_TIME){
			System.out.println("Employee is Present for Full Day");
			empHrs=8;
		}
      else if(empCheck == IS_PART_TIME){
			System.out.println("Employee is Present for Half Day");
         empHrs=4;

		}
		else{
			System.out.println("Employee is Absent");
			empHrs=0;
		}

		//COMPUTE DAILY WAGE OF AN EMPLOYEE
		empWage=empHrs * EMP_RATE_PER_HOUR;
		System.out.println("Daily Wage of an Employee:"+empWage);
	}


}
