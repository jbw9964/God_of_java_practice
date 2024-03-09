package scripts.GOJ_mid_check.practice_problems.code;

import Practice.TestAnnotation;
import scripts.GOJ_mid_check.practice_problems.code.Employee;

@SuppressWarnings("unused")
public class CalculateSalary {
    
    public static final String[] testNameArray = {
        "LeeDaeRi",
        "KimManager",
        "WhangDesign",
        "ParkArchi",
        "LeeDevelop"
    };
    public static final Employee.Type[] testTypeArray = {
        Employee.Type.OWNER,
        Employee.Type.MANAGER,
        Employee.Type.DESIGNER,
        Employee.Type.ARCHITECT,
        Employee.Type.DEVELOPER
    };
    public static final long[] testSalaryArray = {
        1_000_000_000,
        100_000_000,
        70_000_000,
        80_000_000,
        60_000_000
    };


    public static void main(String[] args) throws Exception {
        if (testNameArray.length != testTypeArray.length 
            || testTypeArray.length != testSalaryArray.length) {
                throw new Exception(
                    "Static fields for test should have same lengths : (" + 
                    testNameArray.length + ", " + testTypeArray.length + ", " + testSalaryArray.length + 
                    ")"
                );
        }
        

        int length = testNameArray.length;

        for (int i = 0; i < length; i++) {
            String name = testNameArray[i];
            Employee.Type type = testTypeArray[i];
            long salary = testSalaryArray[i];

            Employee testEmployee = new Employee(name, type, salary);
            salary = getSalaryIncrease(testEmployee);

            System.out.printf(
                "%-10s\t= %,15d\n", 
                name, salary
            );
        }
    }

    public static long getSalaryIncrease(Employee employee) throws NullPointerException {
        if (employee == null)   throw new NullPointerException("Parameter 'Employee employee' has null reference");

        long salary = employee.getSalary();
        double ratio = employee.getType().getRatio();

        salary = (long) (salary + ratio * salary);
        
        return salary;
    }

}
