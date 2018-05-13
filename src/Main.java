import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

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
            Random random = new Random();
            int E1hang0 = random.nextInt(4);
            int E1cot0 = random.nextInt(4);
            int E2hang0 = random.nextInt(4);
            int E2cot0 = random.nextInt(4);
//          E1 là Enemy đi ngang (tăng cột)
//          E2 là Enemy đi dọc (tăng dòng)
            while ( (E1hang0 == hang0) && (E1cot0 == cot0) ) {
                E1hang0 = random.nextInt(4); //random trong khoảng từ 0-4
                E1cot0 = random.nextInt(4);
            }
            map[E1hang0][E1cot0] = "E";
            while ( (E2hang0 == hang0) && (E2cot0 == cot0) &&
                    (E2hang0 == E1hang0) && (E2cot0 == E1cot0)
                    )

            {
                E2hang0 = random.nextInt(4);
                E2cot0 = random.nextInt(4);
            }
            map[E2hang0][E2cot0] = "E";


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
            int E1cot1=E1cot0;
            int E1hang1=E1hang0;
            int E2cot1=E2cot0;
            int E2hang1=E2hang0;

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

//          E1 là Enemy đi ngang (tăng cột)
                if (E1cot1<3) {E1cot1 = E1cot1 + 1;}
                else { E1cot1 = 0; }
                map[E1hang0][E1cot0] = "*";
                map[E1hang1][E1cot1] = "E";
                E1hang0=E1hang1;
                E1cot0=E1cot1;

//          E2 là Enemy đi dọc (tăng hàng)
                if (E2hang1<3) {E2hang1 = E2hang1 + 1;}
                else { E2hang1 = 0; }
                map[E2hang0][E2cot0] = "*";
                map[E2hang1][E2cot1] = "E";
                E2hang0=E2hang1;
                E2cot0=E2cot1;

                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        System.out.print(map[i][j]);
                    }
                    System.out.println();
                }
            }
            }
        }

