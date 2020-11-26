import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Potluck extends JFrame implements ActionListener{

    JPanel panel;
    JPanel buttonPanel;

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
        buttonPanel = new JPanel();

        label = new JLabel("Number of tries:" + count + "\n");




        panel.setBorder(new EmptyBorder(row*2, column*2, row*2, column*2));
        panel.add(label,BorderLayout.CENTER);
        panel.setBackground(Color.pink);

        buttonPanel.setLayout(new GridLayout(row,column));
        add(panel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        //choose bombs and prize randomly
        while (prize == bomb1 ||  prize == bomb2 ||bomb1 == bomb2){
            prize = (int)(Math.random()*(row * column - 1 ))+ 1;
            bomb1 = (int)(Math.random()*(row * column - 1 )) + 1;
            bomb2 = (int)(Math.random()*(row * column - 1)) + 1;
        }

        //create buttons
        for(int i = 1; i < row * column  + 1 ; i++){
            if(i == prize){
                prizeButton = new JButton("Pot " + i);
                prizeButton.addActionListener(this);
                buttonPanel.add(prizeButton);
            }
            else if(i == bomb1){
                bombButton1= new JButton("Pot " + i);
                bombButton1.addActionListener(this);
                buttonPanel.add(bombButton1);
            }
            else if(i == bomb2){
                bombButton2 = new JButton("Pot " + i);
                bombButton2.addActionListener(this);
                buttonPanel.add(bombButton2);
            }
            else{
                JButton button = new JButton("Pot " + i);
                button.addActionListener(this);
                buttonPanel.add(button);
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == prizeButton) {
            count++;
            label.setText("Prize found in " + count + " tries!" + "\n");
            for (int i = 0; i < (row * column); i++) {
                if (buttonPanel.getComponent(i) != prizeButton)
                    ((JButton) buttonPanel.getComponent(i)).setEnabled(false);
            }
        }
        else if(event.getSource() == bombButton1 || event.getSource() == bombButton2 ){
            count ++;
            label.setText("Sorry! You are blown up at attempt " + count + "\n");
            for (int i = 0; i < (row * column); i++) {
                if (buttonPanel.getComponent(i) != prizeButton || buttonPanel.getComponent(i) != bombButton1 || buttonPanel.getComponent(i) != bombButton2 )
                    ((JButton) buttonPanel.getComponent(i)).setEnabled(false);
            }
        }
        else{
            count ++;
            label.setText("Tries: " + count);
            ((JButton) event.getSource()).setEnabled(false);
        }

    }
}
