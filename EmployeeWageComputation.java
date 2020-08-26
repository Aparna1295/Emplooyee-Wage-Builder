import java.util.*;

interface IComputeWage{

	public void addCompanyWage(String company,int ratePerHr, int noOfDaysPerMonth, int maxHrsPerMonth);
	public void computeWage();
	public int getmonthlyWage(String company);


}


class CompanyWage{

 // CLASS VARIABLES
   protected final String company;
   protected final int noOfDaysPerMonth;
   protected final int maxHrsPerMonth;
   protected final int ratePerHr;
   protected int monthlyWage;

	public CompanyWage(String company,int ratePerHr, int noOfDaysPerMonth, int maxHrsPerMonth){

		this.company = company;
		this.ratePerHr = ratePerHr;
		this.noOfDaysPerMonth = noOfDaysPerMonth;
		this.maxHrsPerMonth = maxHrsPerMonth;
		monthlyWage=0;

	}

	public void setMonthlyWage(int monthlyWage){

		this.monthlyWage=monthlyWage;

	}

	@Override
	public String toString(){

	   return "Monthly Wage of an Employee of "+company+": " +monthlyWage;

	}

}


public class EmployeeWageComputation implements IComputeWage{

  //CONSTANTS DECLARATION
	public static final int IS_PART_TIME =1;
   public static final int IS_FULL_TIME =2;

	//	CLASS VARIABLES
	private int numOfCompany=0;
	private LinkedList<CompanyWage> companyWageList;
	private Map<String,CompanyWage> companyToWageMap;

	//PARAMETERIZED CONSTRUCTOR
	public EmployeeWageComputation(){

		companyWageList = new LinkedList<>();
		companyWageMap = new  HashMap<>();

	}


	private void addCompanyWage(String company,int ratePerHr, int noOfDaysPerMonth, int maxHrsPerMonth){

		CompanyWage companyWage = new  CompanyWage(company,ratePerHr,noOfDaysPerMonth,maxHrsPerMonth);
		companyWageList.add(companyWage);
		companyWageMap.put(company,companyWageList);

	}


	public void computeWage(){

		for(int i=0; i<companyWageList.size(); i++){

			CompanyWage companyWage = companyWageList.get(i);
			companyWage.setMonthlyWage(this.computeWage(companyWage));
			System.out.println(companyWage);

		}

	}

	public int getMonthlyWage(String company){
		return companyWageMap.get(company).monthlyWage;
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
		IComputeWage empWageCompute= new EmployeeWageComputation( );
		empWageCompute.addCompanyWage(company:"Accenture", ratePerHr:15, noOfDaysPerMonth:20, maxHrsPerMonth:80);
		empWageCompute.addCompanyWage(company:"Citi Corp", ratePerHr:20, noOfDaysPerMonth:25, maxHrsPerMonth:90);
      empWageCompute.computeWage( );
		System.out.println("Monthly Wage for Company:" +empWageCompute.getMonthlyWage(company:"Accenture"));
		System.out.println("Monthly Wage for Company:" +empWageCompute.getMonthlyWage(company:"Citi Corp"));


	}

}
