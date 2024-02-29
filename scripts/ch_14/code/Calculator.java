
package scripts.ch_14.code;

class Calculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        try {
            calc.printDivide(1, 2);
            calc.printDivide(1, 0);
        }

        catch (ArithmeticException exception) {
            System.out.println(exception.getMessage());
        }
    }
    
    public void printDivide(double d1, double d2) throws ArithmeticException {
            if (d2 == 0.d)
                throw new ArithmeticException("Second value can't be Zero");
            
            double result = d1 / d2;
            System.out.println(result);
    }
}