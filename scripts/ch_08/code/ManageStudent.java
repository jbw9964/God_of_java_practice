package scripts.ch_08.code;

interface Required_methods_1 {
    String toString();
}

class Student implements Required_methods_1 {
    private String name, address, phone, email;
    private String[] Array = {
        name, address, phone, email
    };

    public Student(String ... args)
    {
        for (int i = 0; i < args.length; i++)
        {
            this.Array[i] = args[i];
        }
    }

    @Override
    public String toString()
    {
        String concateString = "";
        for (String var : Array)
        {
            if (var != null)    {concateString += var + " ";}
            else                {concateString += "None ";}
        }

        return concateString;
    }
}

interface Required_methods_2 {
    Student[] addStudents();
}

public class ManageStudent implements Required_methods_2 {
    public static void main(String[] args) {
        ManageStudent test = new ManageStudent();
        Student[] student = test.addStudents();

        test.printStudents(student);
    }

    @Override
    public Student[] addStudents()
    {
        Student[] student = new Student[3];
        student[0] = new Student("Lim");
        student[1] = new Student("Min");
        student[2] = new Student(
            "Sook", "Seoul", 
            "010xxxxxxxx", "ask@godofjava.com"
        );

        return student;
    }

    public void printStudents(Student ... students)
    {
        for (Student single_student : students)
        {
            System.out.println(single_student);
        }
    }
}

