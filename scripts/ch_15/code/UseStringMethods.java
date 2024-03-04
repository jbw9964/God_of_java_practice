package scripts.ch_15.code;

interface Required_methods {
    public void printWords(String str);
    public void findString(String str, String findStr);
    public void findAnyCaseString(String str, String findStr);
    public void countChar(String str, char c);
    public void printContainWords(String str, String findStr);

    static final String STR = "The String class represents character strings.";
}

public class UseStringMethods implements Required_methods{

    public static void main(String[] args) {
        UseStringMethods test = new UseStringMethods();

        String str = UseStringMethods.STR;
        String findStr = "String";
        test.printWords(str);                   System.out.println();
        test.findString(str, findStr);          System.out.println();
        test.findAnyCaseString(str, findStr);   System.out.println();
        test.countChar(str, 's');               System.out.println();
        test.printContainWords(str, "ss");
    }
    
    @Override
    public void printWords(String str) {
        if (str == null)    return;

        for (String var : str.split(" "))   {System.out.println(var);}
    }

    @Override
    public void findString(String str, String findStr) {
        if (str == null || findStr == null)     return;

        System.out.printf("%s appeared at %d", findStr, str.indexOf(findStr));
    }
    
    @Override
    public void findAnyCaseString(String str, String findStr) {
        if (str == null || findStr == null)     return;

        String origin = findStr;
        str = str.toLowerCase();
        findStr = findStr.toLowerCase();

        System.out.printf("%s appeared at %d", origin, str.indexOf(findStr));
    }

    @Override
    public void countChar(String str, char c) {
        if (str == null)    return;

        int count = 0;
        for (char character : str.toCharArray()) {
            if (character == c) {count++;}
        }

        System.out.printf("char '%c' count is %d", c, count);
    }

    @Override
    public void printContainWords(String str, String findStr) {
        if ((str == null || findStr == null) || !str.contains(findStr)) return;

        System.out.println("class contains " + findStr);
    }
}
