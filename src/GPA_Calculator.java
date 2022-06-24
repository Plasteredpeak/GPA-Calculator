import java.util.*;
import java.io.*;
public class GPA_Calculator {
    public static boolean check = false;

    //**********************************MAIN METHOD*********************************************//
    public static void main(String[] args)throws IOException {
        gpa_Calculator();
    }

    //******************************************REG NO CHECK**********************************//
    public static String Reg() {
        char R[] = new char[12];
        do {
            System.out.printf("\nEnter your Reg no (AA00-BBB-000) :");
            Scanner in = new Scanner(System.in);
            String r = in.next();
            if (r.length() == 12) {
                for (int i = 0; i < 12; i++) {
                    R[i] = r.charAt(i);
                }
                if (Character.isLetter(R[0]) && Character.isLetter(R[1]) && Character.isLetter(R[5])
                        && Character.isLetter(R[6]) && Character.isLetter(R[7])) {
                    if (Character.isDigit(R[2]) && Character.isDigit(R[3]) && Character.isDigit(R[9])
                            && Character.isDigit(R[10]) && Character.isDigit(R[11])) {
                        if (R[4] == '-') {
                            if (R[8] == '-') {
                                return r;
                            } else {
                                System.out.println("Invalid format");
                                check = false;
                            }
                        } else {
                            System.out.println("Invalid format");
                            check = false;
                        }
                    } else {
                        System.out.println("Invalid format");
                        check = false;
                    }
                } else {
                    System.out.println("Invalid format");
                    check = false;
                }
            } else {
                System.out.println("reg no should be 12 characters long");
                check = false;
            }

        } while (check==false);
        return "ajeeb";
    }

    //*****************************************SEMESTER NO CHECK********************************//
    public static int semester(){
        while(true){
            System.out.printf("\nEnter semester 1-8:");
            Scanner in=new Scanner(System.in);
            if(in.hasNextInt()){
                int n=in.nextInt();
                if(n>=1 && n<=8){
                    return n;
                }
                else
                    System.out.println("Enter a number from 1 to 8");
            }
            else
                System.out.println("Invalid");
        }
    }

    //**********************************GPA CALCULATOR*********************************************//
    public static void gpa_Calculator() throws IOException{
        int n;
        System.out.println("\n__________________________________GPA CALCULATOR______________________________________");
        System.out.println("\n\n\t\t\t\t\t\t\t\t(1) Caculator");
        System.out.println("\n\t\t\t\t\t\t\t\t(2) Records");
        System.out.println("\n\t\t\t\t\t\t\t\t(3) Exit");
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("\nEnter number :");
            if (in.hasNextInt()) {
                n = in.nextInt();
                switch (n) {
                    case (1): {
                        Calculator();
                        break;
                    }
                    case (2): {
                        Record();
                        break;
                    }
                    case (3):
                        System.exit(0);
                    default: {
                        System.out.println("number has to be b/w 1 and 3");
                        check = false;
                    }
                }
            } else {
                System.out.println("Wrong input");
                check = false;
            }

        }
        while (check == false);
    }

    //*********************************************calculator******************************************************//

    public static void Calculator() throws IOException{
        System.out.println("\n------------------------------CALCULATOR------------------------------------\n");
        System.out.println("\n\t\t\t\t\t\t\t\t(1) GPA");
        System.out.println("\n\t\t\t\t\t\t\t\t(2) CGPA");
        System.out.println("\n\t\t\t\t\t\t\t\t(3) Go back");
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("\nEnter number :");
            if (in.hasNextInt()) {
                int n = in.nextInt();
                switch (n) {
                    case (1): {
                        do {
                            Scanner IN = new Scanner(System.in);
                            System.out.printf("Enter no. of Subjects (5 or 6) :");
                            if (IN.hasNextInt()) {
                                n = IN.nextInt();
                                if (n == 5) {
                                    GPA(n);
                                    check = true;
                                } else if (n == 6) {
                                    GPA(n);
                                    check = true;
                                } else {
                                    System.out.println("number has to be 5 or 6");
                                    check = false;
                                }
                            } else {
                                System.out.println("you have to enter a number");
                                check = false;
                            }
                        } while (check == false);
                        check = true;
                        break;
                    }
                    case (2): {
                        CGPA();
                        check = true;
                        break;
                    }
                    case (3):
                        gpa_Calculator();
                    default: {
                        System.out.println("You have to enter b/w 1 and 3");
                        check = false;
                    }
                }
            } else {
                System.out.println("Invalid Input");
                check = false;
            }

        } while (check == false);

    }

    //***********************************************************GPA*********************************************************//

    public static void GPA(int n) throws IOException {
        float Cgpa = 0;
        int C_sum = 0;
        Object[][] Data = new Object[n][3];
        System.out.println("\n\n***********************************************GPA********************************************************\n");
        for (int i = 0; i < n; i++) {
            float[][] quiz = new float[4][2];
            float[][] assign = new float[4][2];
            float[][] sessional = new float[2][2];
            float[] terminal = new float[2];
            float[][] Lassign = new float[4][2];
            float[][] Lsessional = new float[2][2];
            float[] Lterminal = new float[2];
            float[] total;
            String S_name = "";
            int credit_h = 0, terminal_t = 0, Lterminal_t = 0,c=0;
            //***********************SUBJECT NAME***************************//
            do {
                System.out.printf("Subject Name :");
                Scanner subject = new Scanner(System.in);
                if (subject.hasNext()) {
                    S_name = subject.next();
                    for(c=0;c<S_name.length();c++){
                        if(Character.isLetter(S_name.charAt(c)))
                            continue;
                        else
                            break;
                    }
                    if(c==S_name.length())
                        check = true;
                    else{
                        check=false;
                        System.out.println("Name cannot have numbers or special characters");
                    }
                }
                else {
                    System.out.println("Enter a valid name");
                    check = false;
                }
            } while (check == false);
            //***********************Credit hours***************************//
            do {
                System.out.printf("Credit Hours :");
                Scanner credit = new Scanner(System.in);
                if (credit.hasNextInt()) {
                    credit_h = credit.nextInt();
                    if (credit_h == 3 || credit_h == 4)
                        check = true;
                    else {
                        System.out.println("credit hours must be 3 or 4");
                        check = false;
                    }
                } else {
                    System.out.println("Invalid");
                    check = false;
                }
            } while (check == false);
            //***********************quizes***************************//
            for (int q = 0; q < 4; q++) {
                int quiz_t = 0;
                System.out.println("\n--------QUIZ no. " + (q + 1) + "------------\n");
                do {
                    System.out.printf("Total Marks :");
                    Scanner q_t = new Scanner(System.in);
                    if (q_t.hasNextInt()) {
                        quiz_t = q_t.nextInt();
                        quiz[q][0] = quiz_t;
                        check = true;
                    } else {
                        System.out.println("Invalid");
                        check = false;
                    }
                } while (check == false);
                do {
                    System.out.printf("Obtained Marks :");
                    Scanner q_o = new Scanner(System.in);
                    if (q_o.hasNextFloat()) {
                        float quiz_o = q_o.nextFloat();
                        if (quiz_o <= quiz_t) {
                            quiz[q][1] = quiz_o;
                            check = true;
                        } else {
                            System.out.println("Obtained marks cannot be greater than total");
                            check = false;
                        }
                    } else {
                        System.out.println("Invalid");
                        check = false;
                    }
                } while (check == false);
            }
            //***********************Assignments***************************//
            for (int a = 0; a < 4; a++) {
                int assign_t = 0;
                System.out.println("\n--------Assignment no. " + (a + 1) + "------------\n");
                do {
                    System.out.printf("Total Marks :");
                    Scanner a_t = new Scanner(System.in);
                    if (a_t.hasNextInt()) {
                        assign_t = a_t.nextInt();
                        assign[a][0] = assign_t;
                        check = true;
                    } else {
                        System.out.println("Invalid");
                        check = false;
                    }
                } while (check == false);
                do {
                    System.out.printf("Obtained Marks :");
                    Scanner a_o = new Scanner(System.in);
                    if (a_o.hasNextFloat()) {
                        float assign_o = a_o.nextFloat();
                        if (assign_o <= assign_t) {
                            assign[a][1] = assign_o;
                            check = true;
                        } else {
                            System.out.println("Obtained marks cannot be greater than total");
                            check = false;
                        }
                    } else {
                        System.out.println("Invalid");
                        check = false;
                    }
                } while (check == false);
            }
            //***************************Sessionals**********************************//
            for (int s = 0; s <= 1; s++) {
                int S_t = 0;
                System.out.println("\n--------Sessional no. " + (s + 1) + "------------\n");
                do {
                    System.out.printf("Total Marks :");
                    Scanner s_t = new Scanner(System.in);
                    if (s_t.hasNextInt()) {
                        S_t = s_t.nextInt();
                        sessional[s][0] = S_t;
                        check = true;
                    } else {
                        System.out.println("Invalid");
                        check = false;
                    }
                } while (!check);
                do {
                    System.out.printf("Obtained Marks :");
                    Scanner s_o = new Scanner(System.in);
                    if (s_o.hasNextFloat()) {
                        float S_o = s_o.nextFloat();
                        if (S_o <= S_t) {
                            sessional[s][1] = S_o;
                            check = true;
                        } else {
                            System.out.println("Obtained marks cannot be greater than total");
                            check = false;
                        }
                    } else {
                        System.out.println("Invalid");
                        check = false;
                    }
                } while (check == false);

            }
            System.out.println("\n-------- Terminals------------\n");
            do {
                System.out.printf("Total Marks :");
                Scanner t_t = new Scanner(System.in);
                if (t_t.hasNextInt()) {
                    terminal_t = t_t.nextInt();
                    terminal[0] = terminal_t;
                    check = true;
                } else {
                    System.out.println("Invalid");
                    check = false;
                }
            } while (check == false);
            do {
                System.out.printf("Obtained Marks :");
                Scanner t_o = new Scanner(System.in);
                if (t_o.hasNextFloat()) {
                    float terminal_o = t_o.nextFloat();
                    if (terminal_o <= terminal_t) {
                        terminal[1] = terminal_o;
                        check = true;
                    } else {
                        System.out.println("Obtained marks cannot be greater than total");
                        check = false;
                    }
                } else {
                    System.out.println("Invalid");
                    check = false;
                }
            } while (check == false);

            //******************************LAB********************************//
            if (credit_h == 4) {
                //***********************LAB Assignments***************************//
                for (int a = 0; a < 4; a++) {
                    int assign_t = 0;
                    System.out.println("\n---------- LAB Assignment no. " + (a + 1) + "------------\n");
                    do {
                        System.out.printf("Total Marks :");
                        Scanner a_t = new Scanner(System.in);
                        if (a_t.hasNextInt()) {
                            assign_t = a_t.nextInt();
                            Lassign[a][0] = assign_t;
                            check = true;
                        } else {
                            System.out.println("Invalid");
                            check = false;
                        }
                    } while (check == false);
                    do {
                        System.out.printf("Obtained Marks :");
                        Scanner a_o = new Scanner(System.in);
                        if (a_o.hasNextFloat()) {
                            float assign_o = a_o.nextFloat();
                            if (assign_o <= assign_t) {
                                Lassign[a][1] = assign_o;
                                check = true;
                            } else {
                                System.out.println("Obtained marks cannot be greater than total");
                                check = false;
                            }
                        } else {
                            System.out.println("Invalid");
                            check = false;
                        }
                    } while (check == false);
                }
                //***************************LAB Sessionals**********************************//
                for (int s = 0; s <= 1; s++) {
                    int S_t = 0;
                    System.out.println("\n----------LAB Sessional no. " + (s + 1) + "------------\n");
                    do {
                        System.out.printf("Total Marks :");
                        Scanner s_t = new Scanner(System.in);
                        if (s_t.hasNextInt()) {
                            S_t = s_t.nextInt();
                            Lsessional[s][0] = S_t;
                            check = true;
                        } else {
                            System.out.println("Invalid");
                            check = false;
                        }
                    } while (check == false);
                    do {
                        System.out.printf("Obtained Marks :");
                        Scanner s_o = new Scanner(System.in);
                        if (s_o.hasNextFloat()) {
                            float S_o = s_o.nextFloat();
                            if (S_o <= S_t) {
                                Lsessional[s][1] = S_o;
                                check = true;
                            } else {
                                System.out.println("Obtained marks cannot be greater than total");
                                check = false;
                            }
                        } else {
                            System.out.println("Invalid");
                            check = false;
                        }
                    } while (check == false);

                }
                //*****************************LAB TERMINALS*************************************//
                System.out.println("\n--------LAB Terminal or Project------------\n");
                do {
                    System.out.printf("Total Marks :");
                    Scanner t_t = new Scanner(System.in);
                    if (t_t.hasNextInt()) {
                        Lterminal_t = t_t.nextInt();
                        Lterminal[0] = Lterminal_t;
                        check = true;
                    } else {
                        System.out.println("Invalid");
                        check = false;
                    }
                } while (check == false);
                do {
                    System.out.printf("Obtained Marks :");
                    Scanner t_o = new Scanner(System.in);
                    if (t_o.hasNextFloat()) {
                        float terminal_o = t_o.nextFloat();
                        if (terminal_o <= Lterminal_t) {
                            Lterminal[1] = terminal_o;
                            check = true;
                        } else {
                            System.out.println("Obtained marks cannot be greater than total");
                            check = false;
                        }
                    } else {
                        System.out.println("Invalid");
                        check = false;
                    }
                } while (check == false);


            }
//******************************************Printing**************************************************************//
            total = Calculate_total(quiz, assign, sessional, terminal, credit_h, Lassign, Lsessional, Lterminal);
            System.out.printf(String.format("\nSubject marks :%.2f\nGpa :%.2f\n", total[0], total[1]));
            System.out.println();
            Cgpa += (total[1] * credit_h);
            C_sum += credit_h;

            Data[i][0] = S_name;
            Data[i][1] = String.format("%.2f",total[0]);
            Data[i][2] = total[1];
        }
        System.out.printf(String.format("-----Your CGPA is %.2f-----\n", (Cgpa / C_sum)));

    //********************************************SAVE******************************************//
        do {
            System.out.println("\n\n--(1) SAVE INFO--");
            System.out.println("--(2) Go Back--");
            System.out.println("--(3) Exit");
            Scanner ask = new Scanner(System.in);
            System.out.printf("Enter number :");
            if (ask.hasNextInt()) {
                int num = ask.nextInt();
                switch (num) {
                    case (1): {
                        Save(Data,Cgpa/C_sum,C_sum);
                        break;
                    }
                    case (2): {
                        Calculator();
                        check = true;
                        break;
                    }
                    case (3):
                        System.exit(0);
                    default: {
                        System.out.println("number has to be b/w 1 and 3");
                        check = false;
                    }
                }
            } else {
                System.out.println("Wrong input");
                check = false;
            }
        } while (check == false);
        gpa_Calculator();
    }

//*********************************************************CALCULATION*************************************************************//

    public static float[] Calculate_total(float quiz[][], float assign[][], float sessional[][], float terminal[], int credit,
                                          float[][] Lassign, float[][] Lsessional, float[] Lterminal) {
        float quiz_total,
                marks,
                Lmarks,
                Total,
                assign_total,
                Lassign_total,
                Sessional1,
                Sessional2,
                Terminal,
                LSessional1,
                LSessional2,
                LTerminal,
                gpa,
                q_obt = 0f,
                La_obt = 0f,
                a_obt = 0f;
        float[] Marks = new float[2];

        int q_total = 0,
                a_total = 0,
                La_total = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    q_total += quiz[i][j];
                    a_total += assign[i][j];
                } else {
                    q_obt += quiz[i][j];
                    a_obt += assign[i][j];
                }
            }
        }
        quiz_total = (q_obt / q_total) * 15;
        assign_total = (a_obt / a_total) * 10;
        Sessional1 = (sessional[0][1] / sessional[0][0]) * 10;
        Sessional2 = (sessional[1][1] / sessional[1][0]) * 15;
        Terminal = (terminal[1] / terminal[0]) * 50;
        marks = quiz_total + assign_total + Sessional1 + Sessional2 + Terminal;
        if (credit == 4) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 2; j++) {
                    if (j == 0) {
                        La_total += Lassign[i][j];
                    } else {
                        La_obt += Lassign[i][j];
                    }
                }
            }
            Lassign_total = (La_obt / La_total) * 25;
            LSessional1 = (Lsessional[0][1] / Lsessional[0][0]) * 10;
            LSessional2 = (Lsessional[1][1] / Lsessional[1][0]) * 15;
            LTerminal = (Lterminal[1] / Lterminal[0]) * 50;
            Lmarks = Lassign_total + LSessional1 + LSessional2 + LTerminal;
            Total = ((marks / 100) * 75) + ((Lmarks / 100) * 25);
            gpa = grade(Total);
            Marks[0] = Total;
            Marks[1] = gpa;
            return (Marks);
        }
        gpa = grade(marks);
        Marks[0] = marks;
        Marks[1] = gpa;
        return (Marks);

    }


//***************************************************GRADE**************************************************//
    public static float grade(float marks) {
        if (marks < 50)
            return 0;
        else if (marks >= 50 && marks < 55)
            return 1.3f;
        else if (marks >= 55 && marks < 60)
            return 1.7f;
        else if (marks >= 60 && marks < 65)
            return 2.0f;
        else if (marks >= 65 && marks < 70)
            return 2.3f;
        else if (marks >= 70 && marks < 75)
            return 2.7f;
        else if (marks >= 75 && marks < 80)
            return 3.0f;
        else if (marks >= 80 && marks < 85)
            return 3.3f;
        else if (marks >= 85 && marks < 90)
            return 3.7f;
        else if (marks >= 90)
            return 4.0f;
        else
            return -1;
    }

//************************************************** GPA SAVE*********************************************//

    public static void Save(Object data[][],Float Cgpa,int t_credit) throws IOException {
        do {
            String Reg_no = Reg();
            int semester_no = semester();
            File f = new File(Reg_no + "." + semester_no);
            File c = new File(Reg_no + "-CGPA-" + semester_no);
            if (f.createNewFile() &&  c.createNewFile()) {
                FileWriter F=new FileWriter(f);
                FileWriter C=new FileWriter(c);
                for(Object[] x:data){
                    for(Object y:x){
                        F.write(y+" ");
                    }
                    F.write("\n");
                }
                C.write(String.format("%.2f \n",Cgpa));
                C.write(String.valueOf(t_credit));
                C.close();
                F.close();

                System.out.println("\n-----SAVED SUCCESSFULLY-----\n");
                check=true;

            } else {
                System.out.println("File already exists try accessing record");
                check = false;
            }
        }while(!check);

        gpa_Calculator();
    }


        //**************************************************CGPA***********************************************//

    public static void CGPA() throws IOException{
        int n;
        System.out.println("\n---------------------------------------CGPA CALCULATION----------------------------------");
        System.out.println("\n\n\t\t\t\t\t\t\t\t(1) GET GPA FROM RECORDs");
        System.out.println("\n\t\t\t\t\t\t\t\t(2) ENTER MANUALLY");
        System.out.println("\n\t\t\t\t\t\t\t\t(3) GO BACK");
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("\nEnter number :");
            if (in.hasNextInt()) {
                n = in.nextInt();
                switch (n) {
                    case (1): {
                        CGPA_record();
                        break;
                    }
                    case (2): {
                        CGPA_manual();
                        break;
                    }
                    case (3):
                        Calculator();
                    default: {
                        System.out.println("number has to be b/w 1 and 3");
                        check = false;
                    }
                }
            } else {
                System.out.println("Wrong input");
                check = false;
            }

        }
        while (check == false);

    }

  //********************************CGPA FROM RECORD***********************************//

    public static void CGPA_record() throws IOException{
        String Reg_no=Reg();
        float t_A_cgpa=0f,total_credit=0f;
        do{
            System.out.printf("Enter number of semesters you want to calculate CGPA of :");
            Scanner in=new Scanner(System.in);
            if(in.hasNextInt()) {
                int i;
                int n = in.nextInt();
                if (n >= 1 && n <= 8) {
                    for(i=1;i<=n;i++){
                        File f = new File(Reg_no + "-CGPA-" +n);
                        if(f.exists()){
                            Scanner F=new Scanner(f);
                            float Gpa =Float.valueOf(F.next());
                            int t_credit=Integer.valueOf(F.next());
                            float A_gpa=t_credit*Gpa;
                            t_A_cgpa+=A_gpa;
                            total_credit+=t_credit;
                            F.close();

                        }
                        else
                            break;
                    }
                    float t_CGPA =t_A_cgpa/total_credit;
                    if(i-1==n){
                        System.out.printf(String.format("\n\n\t\t----------- Your CGPA is : %.2f -------------\n\n", t_CGPA));
                        check=true;
                        do{
                            System.out.printf("\nDo you want to save CGPA? (y/n) :");
                            Scanner In=new Scanner(System.in);
                            String ans=In.next();
                            if(ans.equalsIgnoreCase("y")){
                                Save_Cgpa(Reg_no,n,t_CGPA);
                                System.out.println("\n----SAVED----\n");
                                break;
                            }
                            else if(ans.equalsIgnoreCase("n")){
                                break;
                            }
                            else{
                                System.out.println("enter y or n");
                                check=false;
                            }
                        }while(!check);
                    }
                    else{
                        System.out.println("\nYou don't have the required record!\n");
                        do{
                            System.out.printf("Do you want to Continue or GO back? (c/b) :");
                            Scanner In=new Scanner(System.in);
                            String ans=In.next();
                            if(ans.equalsIgnoreCase("c")){
                                break;
                            }
                            else if(ans.equalsIgnoreCase("b")){
                                CGPA();
                            }
                            else{
                                System.out.println("enter c or b");
                                check=false;
                            }
                        }while(!check);
                        check=false;
                    }

                }
                else {
                    System.out.println("Enter a number from 1 to 8");
                    check=false;
                }
            }
            else{
                    System.out.println("Invalid");
                    check=false;
                }

        }while(!check);
        CGPA();
    }

  //********************************CGPA MANUALLY*************************************//

  public static void CGPA_manual() throws IOException{
        do {
            float t_gpa = 0;
            int t_credit = 0;
            int no_of_S = semester();
            for (int i = 1; i <= no_of_S; i++) {
                float gpa;
                int credit = 0;
                System.out.printf(String.format("\n----------Semester %d------------\n\n", i));
                do {
                    System.out.print("Enter Total Credits (12-24) :");
                    Scanner in = new Scanner(System.in);
                    if (in.hasNextInt()) {
                        credit = in.nextInt();
                        if (credit >= 12 && credit <= 24) {
                            t_credit += credit;
                            check = true;
                        } else {
                            System.out.println("GPA can only be between 12 and 24");
                            check = false;
                        }
                    } else {
                        System.out.println("Invalid");
                        check = false;
                    }
                } while (!check);
                do {
                    System.out.print("Enter GPA :");
                    Scanner in = new Scanner(System.in);
                    if (in.hasNextFloat()) {
                        gpa = in.nextFloat();
                        if (gpa > 0 && gpa <= 4) {
                            t_gpa += (credit * gpa);
                            check = true;
                        } else {
                            System.out.println("GPA can only be between 0 and 4");
                            check = false;
                        }
                    } else {
                        System.out.println("Invalid");
                        check = false;
                    }
                } while (!check);


            }
            float Cgpa = t_gpa / t_credit;
            System.out.printf(String.format("\n\n\t\t\t----------CGPA : %.2f -------------\n\n", Cgpa));
            do{
                System.out.printf("Do you want to save CGPA? (y/n) :");
                Scanner in=new Scanner(System.in);
                String ans=in.next();
                if(ans.equalsIgnoreCase("y")){
                    String reg_no=Reg();
                    Save_Cgpa(reg_no,no_of_S,Cgpa);
                    System.out.println("\n----Saved----\n");
                    break;
                }
                else if(ans.equalsIgnoreCase("n")){
                    break;
                }
                else{
                    System.out.println("enter y or n");
                    check=false;
                }
            }while(!check);
            do {
                System.out.printf("Do you want to Continue ? (y/n) :");
                Scanner in = new Scanner(System.in);
                String ans = in.next();
                if (ans.equalsIgnoreCase("y")) {
                    check = true;
                    break;
                } else if (ans.equalsIgnoreCase("n")) {
                    CGPA();
                } else {
                    System.out.println("enter y or n");
                    check = false;
                }
            } while (!check);
        }while (!check);
  }

  //**********************************CGPA SAVE*************************************//

  public static void Save_Cgpa(String reg_no,int S,float CGPA) throws IOException{
        File f=new File(reg_no+"-TCGPA-"+S);
        if(f.createNewFile()){
            FileWriter F=new FileWriter(f);
            F.write(String.format("%.2f",CGPA));
            F.close();
        }
        else{
            System.out.println("\n File Already exists try accessing it from records");
        }
  }

  //***************************************************RECORD*********************************************************//
    public static void Record() throws IOException{
        int n;
        System.out.println("\n--------------------------------------- RECORDS ----------------------------------");
        System.out.println("\n\n\t\t\t\t\t\t\t\t(1) Access GPA Records");
        System.out.println("\n\t\t\t\t\t\t\t\t(2) Access CGPA Records");
        System.out.println("\n\t\t\t\t\t\t\t\t(3) GO BACK");
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("\nEnter number :");
            if (in.hasNextInt()) {
                n = in.nextInt();
                switch (n) {
                    case (1): {
                        gpa_Record();
                        break;
                    }
                    case (2): {
                        Cgpa_Record();
                        break;
                    }
                    case (3):
                        gpa_Calculator();
                    default: {
                        System.out.println("number has to be b/w 1 and 3");
                        check = false;
                    }
                }
            } else {
                System.out.println("Wrong input");
                check = false;
            }

        }
        while (check == false);
    }

    //**************************************** GPA RECORD**********************************************//
    public static void gpa_Record() throws IOException {
        do {
            String Reg_no = Reg();
            int semester_no = semester();
            File f = new File(Reg_no + "." + semester_no);
            File c = new File(Reg_no + "-CGPA-" + semester_no);
            if (f.exists() && !f.isDirectory()) {
                Scanner read = new Scanner(f);
                Scanner r = new Scanner(c);
                while(read.hasNext()){
                    System.out.print("\n\t\t\t\t\tSUBJECT : "+read.next()+"\t------\t");
                    System.out.print("Marks : "+read.next()+"\t------\t");
                    System.out.print("GPA : "+read.next());
                    System.out.println();
                }
                System.out.println("\n\n\t\t\t\t\t\t\t----------------- Semester CGPA :"+r.next()+"----------------\n\n");
                read.close();
                r.close();
                do{
                    System.out.printf("Do you want to delete record? (y/n) :");
                    Scanner in=new Scanner(System.in);
                    String ans=in.next();
                    if(ans.equalsIgnoreCase("y")){
                        f.delete();
                        c.delete();
                        System.out.println("\n----Deleted Successfully----\n");
                        break;
                    }
                    else if(ans.equalsIgnoreCase("n")){
                        break;
                    }
                    else{
                        System.out.println("enter y or n");
                        check=false;
                    }
                }while(!check);

        }
            else {
            System.out.println("\nRecord doesn't exist\n");
            check = false;
        }

            do{
                System.out.printf("Do you want to Continue or GO back? (c/b) :");
                Scanner in=new Scanner(System.in);
                String ans=in.next();
                if(ans.equalsIgnoreCase("c")){
                    check=false;
                    break;
                }
                else if(ans.equalsIgnoreCase("b")){
                    Record();
                }
                else{
                    System.out.println("enter c or b");
                    check=false;
                }
            }while(!check);

        }while(!check);
    }

    //*********************************************CGPA RECORD**************************************//

    public static void Cgpa_Record() throws IOException{
        do {
            String Reg_no = Reg();
            int semester_no = semester();
            File c = new File(Reg_no + "-TCGPA-" + semester_no);
            if (c.exists() && !c.isDirectory()) {
                Scanner r = new Scanner(c);
                System.out.println("\n\n\t\t\t\t\t\t\t-----------------CGPA :"+r.next()+"----------------\n\n");
                r.close();
                do{
                    System.out.printf("Do you want to delete record? (y/n) :");
                    Scanner in=new Scanner(System.in);
                    String ans=in.next();
                    if(ans.equalsIgnoreCase("y")){
                        c.delete();
                        System.out.println("\n----Deleted Successfully----\n");
                        break;
                    }
                    else if(ans.equalsIgnoreCase("n")){
                        break;
                    }
                    else{
                        System.out.println("enter y or n");
                        check=false;
                    }
                }while(!check);

            }
            else {
                System.out.println("\nRecord doesn't exist\n");
                check = false;
            }

            do{
                System.out.printf("Do you want to Continue or GO back? (c/b) :");
                Scanner in=new Scanner(System.in);
                String ans=in.next();
                if(ans.equalsIgnoreCase("c")){
                    check=false;
                    break;
                }
                else if(ans.equalsIgnoreCase("b")){
                    Record();
                }
                else{
                    System.out.println("enter c or b");
                    check=false;
                }
            }while(!check);

        }while(!check);

    }

}


