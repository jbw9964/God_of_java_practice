package scripts.ch_05.code;

interface Required_methods {
    double getMonthlySalary(int yearlySalary);

    double calculateTax(double monthSalary);
    double calculateNationalPension(double monthSalary);
    double calculateHealthInsurance(double monthSalary);
}

public class SalaryManager implements Required_methods {
    public static void main(String[] args) {
        SalaryManager test = new SalaryManager();

        double monthSalary = test.getMonthlySalary(2000);
        System.out.println(monthSalary * 12);
    }

    public double payoff_total(double monthSalary)
    {
        return calculateTax(monthSalary) + calculateNationalPension(monthSalary) + calculateHealthInsurance(monthSalary);
    }

    @Override
    public double getMonthlySalary(int yearlySalary)
    {
        double monthSalary = yearlySalary / 12.d;
        monthSalary -= payoff_total(monthSalary);
        return monthSalary;
    }
    public double calculateTax(double monthSalary)
    {
        return monthSalary * (0.125d);
    }
    public double calculateNationalPension(double monthSalary)
    {
        return monthSalary * (0.081d);
    }
    public double calculateHealthInsurance(double monthSalary)
    {
        return monthSalary * (0.135d);
    }
}
