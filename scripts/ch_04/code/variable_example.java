package scripts.ch_04.code;

public class variable_example {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Sample sample_1 = new Sample();
        Sample sample_2 = new Sample();

        Object[] obj_arr = new Object[2];
        String[] head_arr = {"sample_1", "sample_2", "In Static way"};

        System.out.println("- Instance variables");
        obj_arr[0] = sample_1.instance_var;
        obj_arr[1] = sample_2.instance_var;
        print_hashcode(obj_arr, head_arr);
        

        System.out.println("\n- Class variables");
        obj_arr = new Object[3];
        obj_arr[0] = sample_1.class_var;
        obj_arr[1] = sample_2.class_var;
        obj_arr[2] = Sample.class_var;
        print_hashcode(obj_arr, head_arr);

        System.out.println("\n<Class variable has been reinitialized>");
        sample_1.class_var = new Sample.InnerClass();
        obj_arr[0] = sample_1.class_var;
        obj_arr[1] = sample_2.class_var;
        obj_arr[2] = Sample.class_var;
        print_hashcode(obj_arr, head_arr);
    }

    static void print_hashcode(Object[] obj_arr, String[] head_arr)
    {
        for (int i = 0; i < obj_arr.length; i++)
        {
            System.out.print(head_arr[i] + "\t: ");
            System.out.println(
            String.format(
                "0x%08x", 
                System.identityHashCode(obj_arr[i])
            )
        );
        }
    }
}

class Sample {
    static class InnerClass {}
    
    InnerClass instance_var;
    static InnerClass class_var;

    static          {class_var = new InnerClass();}

    public Sample() {this.instance_var = new InnerClass();}
}
