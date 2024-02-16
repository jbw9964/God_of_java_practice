package scripts.ch_07.code;

interface Required_methods {
    void setData();
    void printHeight(int classNo);
    void printAverage(int classNo);
}
public class ManageHeight implements Required_methods {
    static int[][] gradeHeights;
    static {
        gradeHeights = new int[5][];

        gradeHeights[0] = new int[5];
        gradeHeights[1] = new int[4];
        gradeHeights[2] = new int[4];
        gradeHeights[3] = new int[3];
        gradeHeights[4] = new int[5];
    }

    public static void main(String[] args) {
        ManageHeight test = new ManageHeight();
        for (int i = 0; i < 5; i++) {
            test.printAverage(i);
            test.printHeight(i);
            System.out.println();
        }
    }

    public ManageHeight()   {this.setData();}
    
    @Override
    public void setData()
    {
        gradeHeights[0][0] = 170;
        gradeHeights[0][1] = 180;
        gradeHeights[0][2] = 173;
        gradeHeights[0][3] = 175;
        gradeHeights[0][4] = 177;

        gradeHeights[1][0] = 160;
        gradeHeights[1][1] = 165;
        gradeHeights[1][2] = 167;
        gradeHeights[1][3] = 186;

        gradeHeights[2][0] = 158;
        gradeHeights[2][1] = 177;
        gradeHeights[2][2] = 187;
        gradeHeights[2][3] = 176;

        gradeHeights[3][0] = 173;
        gradeHeights[3][1] = 182;
        gradeHeights[3][2] = 181;

        gradeHeights[4][0] = 170;
        gradeHeights[4][1] = 180;
        gradeHeights[4][2] = 165;
        gradeHeights[4][3] = 177;
        gradeHeights[4][4] = 172;
    }
    public void printHeight(int classNo)
    {
        int[] array_1dim = ManageHeight.gradeHeights[classNo];
        for (int value : array_1dim)
        {
            System.out.print(value + " ");
        };  System.out.println();
    }
    public void printAverage(int classNo)
    {
        double sum = 0.d;
        for (int value : ManageHeight.gradeHeights[classNo])
        {
            sum += value;
        }

        System.out.println(String.format(
            "[%2d] average \t: %6.3f", classNo, sum / ManageHeight.gradeHeights[classNo].length
        ));
    }
}
