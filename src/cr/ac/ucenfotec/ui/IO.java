package cr.ac.ucenfotec.ui;

import java.util.Scanner;

public class IO { private final Scanner sc = new Scanner(System.in);

    public String str(String prompt){
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public int i(String prompt){
        System.out.print(prompt);
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch(Exception e){ return -1; }
    }
}