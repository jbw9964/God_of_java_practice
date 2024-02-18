package scripts.ch_09.code.package_example;

import static scripts.ch_09.code.package_example.sub_package.SubPackage.CLASS_NAME;

public class SupPackage1 {

    public final static String CLASS_NAME = "SupPackage1";
    public static void main(String[] args) {
        System.out.println(CLASS_NAME);
        TempClass test = new TempClass();
        test.method();
    }
}

class TempClass {
    public void method()
    {
        System.out.println(CLASS_NAME);
    }
}
