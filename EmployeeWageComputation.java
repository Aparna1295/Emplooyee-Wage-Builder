public class EmployeeWageComputation{
	public static void main(String[] args){
		System.out.println("****************Welcome to Employee WAge COmputation**************");
		//CONSTANTS DECLARATION
		int IS_FULL_TIME =1;
		//CHECK USER INPUT THROUGH RANDOM()
		double empCheck = Math.floor(Math.random()*10)%2;
		//CHECK WHETHER EMPLOYEE IS PRESENT OR ABSENT
		if (empCheck == IS_FULL_TIME)
			System.out.println("Employee is Present");
		else
			System.out.println("Employee is Absent");

	}


}
