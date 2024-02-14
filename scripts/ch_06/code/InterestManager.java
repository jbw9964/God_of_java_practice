package scripts.ch_06.code;

interface Required_method{
    double getInterestRate(int day);
    double calculateAmount(int day, long amount);
}

public class InterestManager implements Required_method {
    public static void main(String[] args) {
        InterestManager test = new InterestManager();

        double sum_1 = 100;
        double sum_2 = 100;

        for (int day = 1; day < 365; day++) {
            sum_1 = test.calculateAmount(day, (long) sum_1);
        }
        for (int day = 1; day < 365; day += 10) {
            sum_2 = test.calculateAmount(day, (long) sum_2);
        }

        System.out.println("1 ~ 365 by one day \t : " + sum_1);
        System.out.println("1 ~ 365 by ten days \t : " + sum_2);
    }

    @Override
    public double getInterestRate(int day)
    {
        return day >= 365 ? 0.056d : day >= 181 ? 0.02d : day >= 91 ? 0.01d : 0.005d;
    }
    public double calculateAmount(int day, long amount)
    {
        return amount + amount * this.getInterestRate(day);
    }
}
