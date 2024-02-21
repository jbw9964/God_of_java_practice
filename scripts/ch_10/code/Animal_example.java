package scripts.ch_10.code;

public class Animal_example {
    public static void main(String[] args) {
        Dog test1 = new Dog("Random dog", 5);
        Cat test2 = new Cat(1, 2);

        test1.print_status();   System.out.println("");
        test2.print_status();
    }
}

class Dog extends Animal {
    final static String Kind = "Dog";

    public static void main(String[] args) {
        Dog test = new Dog("Some Dog for test", 5, 4);
        test.print_status();
    }

    public Dog()                                    {super();}
    public Dog(String name)                         {super(name);}
    public Dog(int pos_x, int pos_y)                {super(pos_x, pos_y);}
    public Dog(String name, int pos_x, int pos_y)   {super(name, pos_x, pos_y);}
    public Dog(String name, int age)                {super(name, age);}

    @Override
    public void print_status()
    {
        System.out.println("Kind \t\t\t : " + Kind);
        super.print_status();
    }
}

class Cat extends Animal {
    final static String Kind = "Cat";

    public static void main(String[] args) {
        Cat test = new Cat("Some Cat for test", 3);
        test.print_status();
    }

    public Cat()                                    {super();}
    public Cat(String name)                         {super(name);}
    public Cat(int pos_x, int pos_y)                {super(pos_x, pos_y);}
    public Cat(String name, int pos_x, int pos_y)   {super(name, pos_x, pos_y);}
    public Cat(String name, int age)                {super(name, age);}

    @Override
    public void print_status()
    {
        System.out.println("Kind \t\t\t : " + Kind);
        super.print_status();
    }
}