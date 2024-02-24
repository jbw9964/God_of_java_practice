package scripts.ch_12.code;

import java.util.Objects;

interface Required_methods_1 {
    String toString();
    boolean equals(Object obj);
    int hashCode();
}

class Student implements Required_methods_1 {
    public String name, address, phone, email;
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

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass())
        {
            return false;
        }

        Student casted = (Student) obj;
        return  Objects.equals(this.name, casted.name) && 
                Objects.equals(this.address, casted.address) && 
                Objects.equals(this.phone, casted.phone) && 
                Objects.equals(this.email, casted.email);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, address, phone, email);
    }
}

interface Required_methods_2 {
    Student[] addStudents();
    void checkEquals();
}

public class ManageStudent implements Required_methods_2 {
    public static void main(String[] args) {
        ManageStudent test = new ManageStudent();
        // Student[] student = test.addStudents();

        // test.printStudents(student);

        test.checkEquals();
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

    @Override
    public void checkEquals()
    {
        Student a = new Student("Min", "Seoul", "010xxxxxxxx", "ask@godofjava.com");
        Student b = new Student("Min", "Seoul", "010xxxxxxxx", "ask@godofjava.com");

        if (a.equals(b))
        {
            System.out.println("Equal");
        }
        else
        {
            System.out.println("Not Equal");
        }
    }

    public void printStudents(Student ... students)
    {
        for (Student single_student : students)
        {
            System.out.println(single_student);
        }
    }
}

