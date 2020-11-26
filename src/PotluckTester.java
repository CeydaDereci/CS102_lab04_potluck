import java.awt.*;
import java.util.Scanner;
public class PotluckTester {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int row;
        int column;

        System.out.println("Enter dimension: ");
        row = scan.nextInt();
        column = row;

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Potluck frame = new Potluck(row,column);
                frame.setVisible(true);
                System.out.println("Bomb 1: " + frame.bomb1  + " Bomb 2: " + frame.bomb2 + " Prize: " + frame.prize);
            }
        });


    }

}
