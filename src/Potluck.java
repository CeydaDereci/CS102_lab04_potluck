import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Potluck extends JFrame implements ActionListener{

    JPanel panel;
    JPanel innerPanel;
    JLabel label;
    JButton bombButton1;
    JButton bombButton2;
    JButton prizeButton;

    int count;
    int prize;
    int bomb1;
    int bomb2;

    int row;
    int column;

    public Potluck(int row, int column){

        setTitle("POTLUCK");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);

        count = 0;
        this.row = row;
        this.column = column;

        panel = new JPanel();
        innerPanel = new JPanel();
        label = new JLabel("Number of tries:" + count);
        label.setHorizontalAlignment(SwingConstants.CENTER);


        innerPanel.add(label,BorderLayout.NORTH);
        innerPanel.setBorder(new EmptyBorder(row, row, column, column));
        panel.setLayout(new GridLayout(row,column,row*2,column*2));
        panel.setLayout(new BorderLayout(0, 0));
        innerPanel.add(panel, BorderLayout.CENTER);
        setContentPane(innerPanel);

        //choose bombs and prize randomly
        while (prize == bomb1 ||  prize == bomb2 ||bomb1 == bomb2){
            prize = (int)(Math.random()*(row * column));
            bomb1 = (int)(Math.random()*(row * column));
            bomb2 = (int)(Math.random()*(row * column));
        }

        //create buttons
        for(int i = 0; i< row * column; i++){
            if(i == prize){
                prizeButton = new JButton();
                prizeButton.addActionListener(this);
                innerPanel.add(prizeButton);
            }
            else if(i == bomb1){
                bombButton1= new JButton();
                bombButton1.addActionListener(this);
                innerPanel.add(bombButton1);
            }
            else if(i == bomb2){
                bombButton2 = new JButton();
                bombButton2.addActionListener(this);
                innerPanel.add(bombButton2);
            }
            else{
                JButton button = new JButton();
                button.addActionListener(this);
                innerPanel.add(button);
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == prizeButton) {
            count++;
            label.setText("Prize found in " + count + " tries!");
            for (int i = 0; i < (row * column); i++) {
                if (panel.getComponent(i) != prizeButton)
                    ((JButton) panel.getComponent(i)).setEnabled(false);
            }
        }
        else if(event.getSource() == bombButton1 || event.getSource() == bombButton2 ){
            count ++;
            label.setText("Sorry! You are blown up at attempt " + count);
            for (int i = 0; i < (row * column); i++) {
                if (panel.getComponent(i) != prizeButton || panel.getComponent(i) != bombButton1 || panel.getComponent(i) != bombButton2 )
                    ((JButton) panel.getComponent(i)).setEnabled(false);
            }
        }
        else{
            count ++;
            label.setText("Tries: " + count);
            ((JButton) event.getSource()).setEnabled(false);
        }

    }
}
