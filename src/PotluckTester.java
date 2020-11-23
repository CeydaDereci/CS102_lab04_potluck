import java.awt.*;
import java.util.Scanner;
public class PotluckTester {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int row;
        int column;

        System.out.println("Enter row: ");
        row = scan.nextInt();
        System.out.println("Enter column: ");
        column = scan.nextInt();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Potluck frame = new Potluck(row,column);
                frame.setVisible(true);

            }
        });
    }

}
