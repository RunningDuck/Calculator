package calculator.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import calculator.buttons.CalculatorButton;

public class OneButton implements CalculatorButton {
    
    private final JButton jButton;
    private JTextField textField;
    
    public OneButton(ActionListener actionListener, JTextField textField) {
        this.textField = textField;
        jButton = new JButton("1");
        jButton.addActionListener(actionListener);
    }
    
    
    public JButton getjButton() {
        return jButton;
    }
    
    @Override
    public void performAction() {
        textField.setText(textField.getText() + "1");
    }
    
    @Override
    public boolean isFromActionEvent(ActionEvent e) {
        return e.getSource() == jButton;
    }
}
