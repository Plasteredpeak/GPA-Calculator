

import java.io.IOException;
import java.util.*;
public class Trash {
    public static boolean check = false;
    public static int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    public static String Alphabets = "abcdefghijklmnopqrstuvwxyz";
    public static String specials = "~!@#$%^&*()_+|}{;'/?><,.";

    public static void main(String[] args)throws IOException {
        Object[][] test=new Object[5][3];
        for(int x=0;x<5;x++){
            for(int y=0;y<3;y++){
                test[x][y]=(int)(100*Math.random());
            }
        }
        GPA_Calculator obj=new GPA_Calculator();
        obj.Save(test,3.33f,15);
    }

}
