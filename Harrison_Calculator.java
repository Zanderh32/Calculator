import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Harrison_Calculator implements ActionListener {
    private double memory;
    private double displayNum;
    // int constants
    private int operator;
    private final int ADD = 0;
    private final int SUB = 1;
    private final int MULT = 2;
    private final int DIV = 3;
    
    JFrame frame = new JFrame("Calculator");
    JPanel displayPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel displayLabel = new JLabel("0");

    String[] names = {"7",  "8",  "9",  "/",  "4",  "5",  "6",   "*", "1",  "2",  "3",   "-", "0",  "=",  "Clr", "+"};
    JButton buttons[] = new JButton[16];

    public Harrison_Calculator(){
        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel, BorderLayout.CENTER);
        
        displayLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setBackground(Color.WHITE);
        displayLabel.setOpaque(true);

        buttonPanel.setLayout(new GridLayout(4,4));
        frame.add(buttonPanel, BorderLayout.CENTER);
        
        frame.add(displayPanel, BorderLayout.NORTH);
        
        frame.setVisible(true);
        frame.setSize(400,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);

        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton(names[i]);
            buttons[i].setFont(new Font("Times New Roman", Font.BOLD, 30));
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }
    }
    
    public static void main(String[] args){
        new Harrison_Calculator();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttons[0]){
            numberButtonUpdate(7);
        }
        if(e.getSource() == buttons[1]){
            numberButtonUpdate(8);
        }
        if(e.getSource() == buttons[2]){
            numberButtonUpdate(9);
        }
        if(e.getSource() == buttons[3]){
            operatorButtonUpdate(DIV);
        }
        if(e.getSource() == buttons[4]){
            numberButtonUpdate(4);
        }
        if(e.getSource() == buttons[5]){
            numberButtonUpdate(5);
        }
        if(e.getSource() == buttons[6]){
            numberButtonUpdate(6);
        }
        if(e.getSource() == buttons[7]){
            operatorButtonUpdate(MULT);
        }
        if(e.getSource() == buttons[8]){
            numberButtonUpdate(1);
        }
        if(e.getSource() == buttons[9]){
            numberButtonUpdate(2);
        }
        if(e.getSource() == buttons[10]){
            numberButtonUpdate(3);
        }
        if(e.getSource() == buttons[11]){
            operatorButtonUpdate(SUB);
        }
        if(e.getSource() == buttons[12]){
            numberButtonUpdate(0);
        }
        if(e.getSource() == buttons[13]){
            if(operator == ADD){
                displayNum += memory;
            }
            if(operator == SUB){
                displayNum = memory - displayNum;
            }
            if(operator == MULT){
                displayNum *= memory;
            }
            if(operator == DIV){
                displayNum = memory / displayNum;
            }
            displayLabel.setText(Double.toString(displayNum));
        }
        if(e.getSource() == buttons[14]){
            displayNum = 0;
            memory = 0;
            displayLabel.setText(Double.toString(displayNum));
        }
        if(e.getSource() == buttons[15]){
            operatorButtonUpdate(ADD);
        }
    }
    private void numberButtonUpdate(double buttonValue){
         displayNum = displayNum*10 + buttonValue;
            displayLabel.setText(Double.toString(displayNum));
    }
     private void operatorButtonUpdate(int operatorChoice){
         memory = displayNum;
         displayNum = 0.0;
         operator = operatorChoice;
        }
    }
