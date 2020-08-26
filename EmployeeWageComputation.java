class CompanyWage{

 // CLASS VARIABLES
   protected final String company;
   protected final int noOfDaysPerMonth;
   protected final int maxHrsPerMonth;
   protected final int ratePerHr;
   private int monthlyWage;

	public CompanyWage(String company,int ratePerHr, int noOfDaysPerMonth, int maxHrsPerMonth){

		this.company = company;
		this.ratePerHr = ratePerHr;
		this.noOfDaysPerMonth = noOfDaysPerMonth;
		this.maxHrsPerMonth = maxHrsPerMonth;

	}

	public void setMonthlyWage(int monthlyWage){

		this.monthlyWage=monthlyWage;

	}

	@Override
	public String toString(){

	   return "Monthly Wage of an Employee of "+company+": " +monthlyWage;

	}

}


public class EmployeeWageComputation{

  //CONSTANTS DECLARATION
	public static final int IS_PART_TIME =1;
   public static final int IS_FULL_TIME =2;

	//	CLASS VARIABLES
	private int numOfCompany=0;
	private CompanyWage[] companyWageArray;

	//PARAMETERIZED CONSTRUCTOR
	public EmployeeWageComputation(){

	companyWageArray= new CompanyWage[5];

	}


	private void addCompanyWage(String company,int ratePerHr, int noOfDaysPerMonth, int maxHrsPerMonth){

		companyWageArray[numOfCompany]=new CompanyWage(company,ratePerHr,noOfDaysPerMonth,maxHrsPerMonth);
		numOfCompany++;

	}


	private void computeWage(){

		for(int i=0; i<numOfCompany; i++){

			companyWageArray[i].setMonthlyWage(this.computeWage(companyWageArray[i]));
			System.out.println(companyWageArray[i]);

		}

	}

	public int computeWage(CompanyWage companyWage){
		//VARIABLES DECLARATION
		int dailyHrs= 0;
		int monthlyHrs=0;
		int dailyWage=0;
		int day=1;
		
		//COMPUTE MONTHLY WAGE UNTIL MAX HOURS(100) OR MAX NO OF WORKING DAYS(20) REACHES
		while(monthlyHrs<=companyWage.maxHrsPerMonth && day < companyWage.noOfDaysPerMonth){
			System.out.println("------------Monthly Wage Computation for EMployee of  " +companyWage.company);
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
 			dailyWage=dailyHrs * companyWage.ratePerHr;
			System.out.println("Daily Wage of an Employee for Day" +day+":"+dailyWage);
		}
      return  monthlyHrs * companyWage.ratePerHr;

	}

	public static void main(String[] args){
		System.out.println("****************Welcome to Employee Wage Computation**************");

		//CREATE OBJECTS  TO INVOKE CLASS METHODS
		EmployeeWageComputation empWageCompute= new EmployeeWageComputation();
		empWageCompute.addCompanyWage("Accenture",15,20,80);
		empWageCompute.addCompanyWage("Citi Corp",20,25,90);
      empWageCompute.computeWage();

	}

}
