package scripts.ch_10.code;

public class Animal {
    int Age;
    int Health;
    String Name;

    private int pos_x;
    private int pos_y;

    int[] Coordinate = new int[2];

    public static void main(String[] args) {
        Animal test = new Animal("Some animals to test", 5);
        test.print_status();
    }

    protected Animal()
    {
        setAge(0);
        setHealth(10);
        setName("Unknown");
        setPos(0, 0);
    }

    protected Animal(String name)
    {
        this();
        setName(name);
    }

    protected Animal(int pos_x, int pos_y)
    {
        this();
        setPos(pos_x, pos_y);
    }

    protected Animal(String name, int pos_x, int pos_y)
    {
        this();
        setName(name);
        setPos(pos_x, pos_y);
    }

    protected Animal(String name, int age)
    {
        this();
        setName(name);
        setAge(age);
    }

    private void setAge(int age)        {this.Age = age;}
    private void setHealth(int health)  {this.Health = health;}
    private void setName(String name)   {this.Name = name;}
    private void setPos(int x, int y)   {
        this.pos_x = x;
        this.pos_y = y;
        this.Coordinate[0] = this.pos_x;
        this.Coordinate[1] = this.pos_y;
    }

    protected void print_status()
    {
        System.out.println("Age \t\t\t : " + Age);
        System.out.println("Name \t\t\t : " + Name);
        System.out.println("Health\t\t\t : " + Health);
        System.out.printf("Current Position \t : (%2d , %2d)\n", pos_x, pos_y);
    }
}
