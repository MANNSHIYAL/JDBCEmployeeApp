import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeApp {
//	execute update TO UPDATE DATABASE 
//	execute query TO EXECUTE QUERY OF FETCHING DATA

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int recordsChanged = 0;
		int recordDeleted = 0;
		ArrayList<Employee> employeeList;
		Employee employee = null;
		
		try {
			while(true) {
				System.out.println("Select operation\n 1. Insert Employee Details\n 2. List Of Employees\n 3. Find Employee\n 4. Delete Employee\n 5. Exit");
				int select = input.nextInt();
				if(select == 1) {
					System.out.print("Please insert employee name: ");
					String name = input.next();
					System.out.print("Please insert employee phone number: ");
					String phoneNumber = input.next();
					System.out.print("Please insert employee email: ");
					String email = input.next();
					System.out.print("Please insert employee country: ");
					String country = input.next();
					System.out.print("Please insert employee salary: ");
					int salary = input.nextInt();
					System.out.print("Please insert employee name style: ");
					String style = input.next();
					recordsChanged  = Operations.insertEmployee(name,phoneNumber,email,country,salary,style);
				}
				else if (select == 2){
					employeeList = Operations.listEmployee();
				}
				else if(select == 3) {
					System.out.print("Enter employee Id: ");
					int sr_no = input.nextInt();
					employee = Operations.findEmployee(sr_no);
				}
				else if(select == 4) {
					System.out.print("Enter employee Id: ");
					int sr_no = input.nextInt();
					recordDeleted = Operations.deleteEmployee(sr_no);
					System.out.println("Record deleted successfully.");
				}
				else if (select == 5) break;
				else System.out.println("Invalid Input");
			}

		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		input.close();

	}

}
