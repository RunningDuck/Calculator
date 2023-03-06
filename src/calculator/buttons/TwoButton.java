package calculator.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import calculator.buttons.CalculatorButton;

public class TwoButton implements CalculatorButton {
    
    private final JButton jButton;
    private JTextField textField;
    
    public TwoButton(ActionListener actionListener, JTextField textField) {
        this.textField = textField;
        jButton = new JButton("2");
        jButton.addActionListener(actionListener);
    }
    
    
    public JButton getjButton() {
        return jButton;
    }
    
    @Override
    public void performAction() {
        textField.setText(textField.getText() + "2");
    }
    
    @Override
    public boolean isFromActionEvent(ActionEvent e) {
        return e.getSource() == jButton;
    }
}
