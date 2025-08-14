package HomeWork;

import java.util.Scanner;

public class EmployeeManager {
    public static void main(String[] args) {
        EmployeeContainer container = new EmployeeContainer();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. View Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter empno: ");
                    int empno = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter job: ");
                    String job = sc.nextLine();
                    container.addEmployee(new Employee(empno, name, job));
                    break;

                case 2:
                    System.out.print("Enter empno to delete: ");
                    container.deleteEmployee(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter empno to view: ");
                    container.viewEmployee(sc.nextInt());
                    break;

                case 4:
                    container.viewEmployees();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
