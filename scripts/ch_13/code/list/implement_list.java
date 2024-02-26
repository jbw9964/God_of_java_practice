package scripts.ch_13.code.list;

interface List {
    public void add(Object obj);
    public void update(int index, Object obj);
    public void remove(int index);
}

abstract class AbstractList implements List {
    public abstract void clear();
}

@SuppressWarnings("unused")
enum HealthInsurance {
    LEVEL_ONE(1000, 1.0),   LEVEL_TWO(2000, 2.0),   LEVEL_THREE(3000, 3.2),
    LEVEL_FOUR(4000, 4.5),  LEVEL_FIVE(5000, 5.6),  LEVEL_SIX(6000, 7.1);

    private final int maxSalary;
    private final double ratio;
    private HealthInsurance(int maxSalary, double ratio) {
        this.maxSalary = maxSalary;
        this.ratio = ratio;
    }

    public double getRatio()    {return ratio;}

    public static HealthInsurance getHealthInsurance(int salary)
    {
        if (salary >= 6_000)        {return HealthInsurance.LEVEL_SIX;}
        else if (salary >= 5_000)   {return HealthInsurance.LEVEL_FIVE;}
        else if (salary >= 4_000)   {return HealthInsurance.LEVEL_FOUR;}
        else if (salary >= 3_000)   {return HealthInsurance.LEVEL_THREE;}
        else if (salary >= 2_000)   {return HealthInsurance.LEVEL_TWO;}
        else                        {return HealthInsurance.LEVEL_ONE;}
    }
}

public class implement_list {
    public static void main(String[] args) {
        int salaryArray[] = {1_500, 5_500, 8_000};
        HealthInsurance[] insurances = new HealthInsurance[3];
        insurances[0] = HealthInsurance.getHealthInsurance(salaryArray[0]);
        insurances[1] = HealthInsurance.getHealthInsurance(salaryArray[1]);
        insurances[2] = HealthInsurance.getHealthInsurance(salaryArray[2]);

        for (int i = 0; i < insurances.length; i++) {
            System.out.println(salaryArray[i] + "=" + insurances[i] + "\t" + insurances[i].getRatio());
        }
    }
}