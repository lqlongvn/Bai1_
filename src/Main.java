
import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /**
         * Tạo map: mảng 2 chiều chứa phần tử "*"*/
        String[][] map = {
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "P", "*"},
                {"*", "*", "*", "*"}
        };

        /**
         * Khai bao mot list tat ca cac toa do tren ban do*/
        ArrayList<Point> positions = new ArrayList<>();
        for (int i = 0; i < map.length; i ++) {
            for (int j = 0; j < map[i].length; j ++) {
                positions.add(new Point(j, i));
            }
        }

        /**
         * Player o toa do (2, 2) nen se xoa toa do (2, 2) trong list*/
        positions.remove(10);
        Random random = new Random();

        int x = 2;
        int y = 2;

        /**
         * Random 2 enemy co toa do khach nhau va khac player.
         * Random de lay bat ky toa do nao trong list. Do toa do cua player dc xoa khoi khi nen khi random se ko bao gio lay phai toa do cua player
         * Cach nay se chi cab random 1 lan nhung khong bao gio trung vs player*/

        Point point = positions.remove(random.nextInt(positions.size()));
        int enemy1X = point.x;
        int enemy1Y = point.y;

        /**
         * Enemy dau tien da random toa do va xoa toa do khoi list
         * Enemy thu hai se random lay 1 toa do trong list. do toa do enemy 1 dc xoa khoi list nen toa do enemy 2 ko trung voi 1*/
        point = positions.remove(random.nextInt(positions.size()));
        int enemy2X = point.x;
        int enemy2Y = point.y;

        // Random vi tri cua qua
        point = positions.remove(random.nextInt(positions.size()));
        int giftX = point.x;
        int giftY = point.y;


        map[enemy1Y][enemy1X] = "N";
        map[enemy2Y][enemy2X] = "D";
        map[giftY][giftX] = "G";
        while (true) {
            /**
             * Print map*/
            printMap(map);

            /**
             * kiem tra qua vi tri cua gift vs player co trung nhau ko
             * Kiem tra tai vi tri nay sau khi print map de nhin thay player an gift truoc khi dung game*/
            if (giftX == x && giftY == y) {
                System.out.println("win");
                break;
            }

            // Nhap ky tu tu ban phim
            System.out.println("Nhap ban phim: ");
            Scanner scanner = new Scanner(System.in);
            String key = scanner.next();

            // Ban dau van gan vi tri cua player = "*"
            map[y][x] = "*";

            // Kiem tra ban phim nhap vao de di chuyen
            switch (key) {
                case "a":
                    if (x == 0) {
                        x = map.length - 1;
                    } else {
                        x -= 1;
                    }
                    break;
                case "d":
                    if (x == map.length - 1) {
                        x = 0;
                    } else {
                        x += 1;
                    }
                    break;

                case "w":
                    if (y == 0) {
                        y = map[0].length - 1;
                    } else {
                        y -= 1;
                    }
                    break;
                case "s":
                    if (y == map[0].length - 1) {
                        y = 0;
                    } else {
                        y += 1;
                    }
                    break;
                default:
                    System.out.println("key ko dung");
            }


            // Kiem tra player co di chuyen vao enemy hay ko
            if ((x == enemy1X && y == enemy1Y) || (x == enemy2X && y == enemy2Y)) {
                System.out.println("lost");
                break;
            }

            // Ban dau gan vi tri 2 enemy la "*"
            map[enemy1Y][enemy1X] = "*";
            map[enemy2Y][enemy2X] = "*";

            // Di chuyen enemy theo huong ngang - doc
            enemy1X = (enemy1X + 1) % map.length;
            enemy2Y = (enemy2Y + 1) % map[0].length;

            // kiem tra enemy co trung vs qua hay ko? Neu ko thi hien thi qua, neu co thi thay the bang enemy
            if ((enemy1X != giftX || enemy1Y != giftY) || (enemy2X != giftX || enemy2Y != giftY)) {
                map[giftX][giftY] = "G";
            }

            map[enemy1Y][enemy1X] = "N";
            map[enemy2Y][enemy2X] = "D";

            map[y][x] = "P";

            // kiem tra enemy co di chuyen vao player ko
            if ((x == enemy1X && y == enemy1Y) || (x == enemy2X && y == enemy2Y)) {
                System.out.println("lost");
                break;
            }
        }
    }

    /***
     * <kieu tra ve> [ten ham] ([paramters optional]) {
     *
     * }
     */
    static void printMap(String[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int add(int x, int y) {
        return x + y;
    }

}
