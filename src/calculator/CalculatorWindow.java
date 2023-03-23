package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import calculator.buttons.*;


public class CalculatorWindow implements ActionListener, ButtonHost{
    
    JFrame frame;
    
    ArrayList<CalculatorButton> buttons = new ArrayList<>();
    
    
    JTextField textField;
    Calculator calculator = new Calculator();

    
    public CalculatorWindow() {
        
        
        frame = new JFrame("Our calculator.Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(new Font("Ink Free", Font.BOLD, 30));
        textField.setEditable(false);


        JPanel panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        

        for (int i = 0; i <= 9; i++) {
            NumberButton numberButton = new NumberButton(this, i, this);
            panel.add(numberButton.getjButton());
            buttons.add(numberButton);
        }


        AddButton addButton = new AddButton(this, this);
        panel.add(addButton.getjButton());
        buttons.add(addButton);

        MulButton mulButton = new MulButton(this, this);
        panel.add(mulButton.getjButton());
        buttons.add(mulButton);

        DivButton divButton = new DivButton(this, this);
        panel.add(divButton.getjButton());
        buttons.add(divButton);

        MinusButton minusButton = new MinusButton(this, this);
        panel.add(minusButton.getjButton());
        buttons.add(minusButton);

        ExpButton expButton = new ExpButton(this, this);
        panel.add(expButton.getjButton());
        buttons.add(expButton);

        EquButton equButton = new EquButton(this,this);
        panel.add(equButton.getjButton());
        buttons.add(equButton);

        DotButton dotButton = new DotButton(this,this);
        panel.add(dotButton.getjButton());
        buttons.add(dotButton);

        frame.add(panel);
        
        frame.setVisible(true);
        frame.add(textField);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (CalculatorButton button : buttons) {
            if (button.isFromActionEvent(e)) {
                button.performAction();
            }
        }
    }


    @Override
    public Calculator getCalculator() {
        return calculator;
    }

    @Override
    public void setTextField(String text){
        textField.setText(textField.getText() + text);
    }

    @Override
    public void clearTextField() {
        textField.setText("");
    }


}
