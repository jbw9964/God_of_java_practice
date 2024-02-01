package scripts.ch_01.code;

public class Calculator {
    public static void main(String args[])
    {
        int num1, num2;
        num1 = 10;
        num2 = 3;

        InnerCalculator calculator = new InnerCalculator(num1, num2);
        System.out.println("Subtraction \t\t: " + calculator.subtract());
        System.out.println("Multiplication \t\t: " + calculator.multiply());
        System.out.println("Division \t\t: " + calculator.divide());
        System.out.println("Modulus \t\t: " + calculator.modulus());
    }
}

class InnerCalculator {
    int num1, num2;
    public InnerCalculator(int num1, int num2)
    {
        this.num1 = num1;
        this.num2 = num2;
    }
    public int subtract() {return this.num1 - this.num2;}
    public int multiply() {return this.num1 * this.num2;}
    public int divide()   {return this.num1 / this.num2;}
    public int modulus()  {return this.num1 % this.num2;}
}
