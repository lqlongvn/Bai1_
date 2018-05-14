import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] array = new String [4][4];
        String[][] map = {
                {"*","*","*","*"},
                {"*","*","P","*"},
                {"*","*","*","*"},
                {"*","*","*","*"},

        };
        int hang0=1;
        int cot0=2;
        for (int i=0; i<map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        int cot1=cot0;
        int hang1=hang0;
        System.out.println(hang1);
        System.out.println(cot1);
        String a="z";
        while (a != "x") {
            a = scanner.next();
            System.out.println(a);
            switch (a) {
                case "a":
                    if (cot1>0) {cot1 = cot1 - 1;}
                    else {
                        cot1 = 3;
//                        System.out.println("Cận cột 1");
                    } ;
                    break;
                case "s":
                    if (hang1<3) {hang1 = hang1 + 1;}
                    else {
                        hang1 = 0;
//                            System.out.println("Cận hàng 4");
                    }
                    break;
                case "w":
                    if (hang1>0) {hang1 = hang1 - 1;}
                    else {
                        hang1=3;
//                            System.out.println("Cận hàng 1");
                    }
                    break;
                case "d":
                    if (cot1 <3) {cot1 = cot1 + 1;}
                    else {
                        cot1 = 0;
//                        System.out.println("Cận cột 4");
                    }
                    break;
            }
//                System.out.println(hang1);
//                System.out.println(cot1);
            if ((cot1 != cot0) || (hang1 != hang0)) {
                map[hang0][cot0] = "*";
                map[hang1][cot1] = "P";
                hang0=hang1;
                cot0=cot1;
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}

