import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton,decButton,equButton,clrButton, delButton;
    JPanel panel;
    
    Font myFont = new Font("Ink Free", Font.BOLD,30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calculator() {

        frame = new JFrame("Our Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] =subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5]= equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;


        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }




        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
        }

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);
        frame.add(delButton);
        frame.add(clrButton);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);

        frame.setVisible(true);
        frame.add(textfield);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }

            if (e.getSource() == addButton) {
                num1 = Double.valueOf(textfield.getText());
                operator = '+';
                textfield.setText(null);
            }

            if(e.getSource() == subButton) {
                num1 = Double.valueOf(textfield.getText());
                operator = '-';
                textfield.setText(null);
            }

            if(e.getSource() == mulButton) {
                num1 = Double.valueOf(textfield.getText());
                operator = '*';
                textfield.setText(null);
            }

            if(e.getSource() == divButton) {
                num1 = Double.valueOf(textfield.getText());
                operator = '/';
                textfield.setText(null);
            }

            if(e.getSource() == equButton) {
                num2 = Double.valueOf(textfield.getText());

                switch(operator) {
                    case '+': result = add(num1,num2); break;
                    case '-': result = sub(num1, num2); break;
                    case '*': result = mul(num1, num2); break;
                    case '/': result = div(num1, num2); break;
                    default: break;
                }
                textfield.setText(Double.toString(result));
            }

            if(e.getSource() == clrButton) {
                textfield.setText(null);
            }

            if(e.getSource() == delButton) {
                String str = textfield.getText();
                textfield.setText(str.substring(0, str.length() - 1));
            }



    }

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double sub(double num1, double num2) {
        return num1 - num2;
    }

    public double mul(double num1, double num2) {
        return num1 * num2;
    }

    public double div(double num1, double num2) {
        return num1 / num2;
    }
}
