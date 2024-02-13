package scripts.ch_05.code;

interface Required_methods {
    double getMonthlySalary(int yearlySalary);
    double calculateTax(double monthSalary);
    double calculateNationalPension(double monthSalary);
}

public class SalaryManager implements Required_methods {
    public static void main(String[] args) {
        SalaryManager test = new SalaryManager();

        System.out.println(test.calculateNationalPension(300));
    }

    @Override
    public double getMonthlySalary(int yearlySalary)
    {
        double month_salary = yearlySalary / 12.d;
        return month_salary - calculateTax(month_salary);
    }
    public double calculateTax(double monthSalary)
    {
        return monthSalary * (0.125d);
    }
    public double calculateNationalPension(double monthSalary)
    {
        monthSalary -= calculateTax(monthSalary);
        return 12 * monthSalary;
    }
}
