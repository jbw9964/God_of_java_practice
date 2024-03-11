package scripts.GOJ_mid_check.practice_problems.code;

public class Employee {
    public enum Type {
        OWNER(1), MANAGER(2), DESIGNER(3), ARCHITECT(4), DEVELOPER(5);

        private int type;
        private Type(int type)  {this.type = type;} 

        public int getType()    {return type;}
        public double getRatio() throws RuntimeException {
            double ratio;

            switch (this.type) {
                case 1 : ratio = -0.95d;    break;
                case 2 : ratio = 0.1d;      break;
                case 3 : ratio = 0.2d;      break;
                case 4 : ratio = 0.3d;      break;
                case 5 : ratio = 1.0d;      break;
            
                default : throw new RuntimeException(
                    "Unexpected type encountered in Employee.Type constant"
                );
            }
            
            return ratio;
        }
    };

    private String name;
    private Employee.Type type;
    private long salary;

    public Employee(String name, int type, long salary) {
        setName(name);
        setType(type);
        setSalary(salary);
    }

    public Employee(String name, Employee.Type type, long salary) {
        setName(name);
        setType(type);
        setSalary(salary);
    }

    public void setName(String name)        {this.name = name;}
    public void setType(Employee.Type type) {this.type = type;}
    public void setType(int type) throws RuntimeException {
        switch (type) {
            case 1 : this.type = Type.OWNER;        break;
            case 2 : this.type = Type.MANAGER;      break;
            case 3 : this.type = Type.DESIGNER;     break;
            case 4 : this.type = Type.ARCHITECT;    break;
            case 5 : this.type = Type.DEVELOPER;    break;
            default:
                throw new RuntimeException("Unsupported type encountered : " + type);
        }
    }
    public void setSalary(long salary)      {this.salary = salary;}

    public String getName()         {return name;}
    public Employee.Type getType()  {return type;}
    public long getSalary()         {return salary;}
    public double getRatio()        {return this.type.getRatio();}
}
