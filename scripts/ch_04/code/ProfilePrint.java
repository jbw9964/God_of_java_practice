package scripts.ch_04.code;

interface Required_methods {
    void setAge(byte age);
    byte getAge();

    void setName(String name);
    String getName();

    void setMarried(boolean flag);
    boolean isMarried();
}

public class ProfilePrint implements Required_methods {
    private byte age;
    private String name;
    private boolean isMarried;

    public static void main(String[] args) {
        ProfilePrint test = new ProfilePrint();

        test.setAge((byte) 100);
        test.setName("GilDong Hong");
        test.setMarried(true);

        System.out.println("Age \t\t: " + test.getAge());
        System.out.println("Name \t\t: " + test.getName());
        System.out.println("Is married \t: " + test.isMarried());
    }

    @Override
    public void setAge(byte age)            {this.age = age;}
    public byte getAge()                    {return this.age;}

    @Override
    public void setName(String name)        {this.name = name;}
    public String getName()                 {return this.name;}

    @Override
    public void setMarried(boolean flag)    {this.isMarried = flag;}
    public boolean isMarried()              {return this.isMarried;}
}
