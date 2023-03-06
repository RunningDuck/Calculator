package calculator.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import calculator.buttons.CalculatorButton;

public class NumberButton implements CalculatorButton {
    
    private final JButton jButton;
    private int number;
    private JTextField textField;
    
    public NumberButton(ActionListener actionListener, JTextField textField, int number) {
        this.textField = textField;
        jButton = new JButton(String.valueOf(number));
        this.number = number;
        jButton.addActionListener(actionListener);
    }
    
    
    public JButton getjButton() {
        return jButton;
    }
    
    @Override
    public void performAction() {
        textField.setText(textField.getText() + number);
    }
    
    @Override
    public boolean isFromActionEvent(ActionEvent e) {
        return e.getSource() == jButton;
    }
    
    
}
