package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import calculator.buttons.CalculatorButton;
import calculator.buttons.NumberButton;


public class CalculatorTemp implements ActionListener {
    
    JFrame frame;
    //    calculator.buttons.AddButton addButton;
    //    calculator.buttons.OneButton oneButton;
    
    ArrayList<CalculatorButton> buttons = new ArrayList<>();
    
    
    JTextField textfield;
    
    
    public CalculatorTemp() {
        
        
        frame = new JFrame("Our calculator.Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(new Font("Ink Free", Font.BOLD, 30));
        textfield.setEditable(false);
        
        
        JPanel panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        
        
//        calculator.buttons.AddButton addButton = new calculator.buttons.AddButton(this, textfield);
//        panel.add(addButton.getjButton());
//        calculator.buttons.add(addButton);
//
//        calculator.buttons.OneButton oneButton = new calculator.buttons.OneButton(this, textfield);
//        panel.add(oneButton.getjButton());
//        calculator.buttons.add(oneButton);
    
        for (int i = 0; i <= 9; i++) {
            NumberButton numberButton = new NumberButton(this, textfield, i);
            panel.add(numberButton.getjButton());
            buttons.add(numberButton);
        }
        
//        calculator.buttons.NumberButton oneButton = new calculator.buttons.NumberButton(this, textfield, 1);
//        panel.add(oneButton.getjButton());
//        calculator.buttons.add(oneButton);
//
//
//        calculator.buttons.NumberButton twoButton = new calculator.buttons.NumberButton(this, textfield, 2);
//        panel.add(twoButton.getjButton());
//        calculator.buttons.add(twoButton);
//
//
//        calculator.buttons.NumberButton threeButton = new calculator.buttons.NumberButton(this, textfield, 3);
//        panel.add(threeButton.getjButton());
//        calculator.buttons.add(oneButton);
//
        
        frame.add(panel);
        
        frame.setVisible(true);
        frame.add(textfield);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (CalculatorButton button : buttons) {
            if (button.isFromActionEvent(e)) {
                button.performAction();
            }
        }
    }
}
