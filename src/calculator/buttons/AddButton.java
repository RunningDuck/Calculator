package calculator.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddButton implements CalculatorButton {
    
    private final JButton jButton;
    private JTextField textField;
    
    public AddButton(ActionListener actionListener, JTextField textField) {
        this.textField = textField;
        jButton = new JButton("+");
        jButton.addActionListener(actionListener);
    }
    
    
    public JButton getjButton() {
        return jButton;
    }
    
    
    @Override
    public void performAction() {
        addSomething();
        double currentNumber = Double.valueOf(textField.getText());
//        operator = '+';
//        textfield.setText(null);
    
    }
    
    @Override
    public boolean isFromActionEvent(ActionEvent e) {
        return e.getSource() == jButton;
    }
    
    
    public void addSomething() {}
}
