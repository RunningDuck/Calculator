package calculator.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import calculator.ButtonHost;

public class NumberButton implements CalculatorButton {
    
    private final JButton jButton;
    private int number;
    private ButtonHost buttonHost;


    
    public NumberButton(ActionListener actionListener, int number, ButtonHost buttonHost) {
        jButton = new JButton("#"+number);
        this.number = number;
        this.buttonHost = buttonHost;
        jButton.addActionListener(actionListener);
    }
    
    
    public JButton getjButton() {
        return jButton;
    }
    
    @Override
    public void performAction() {
        buttonHost.getCalculator().addNumNode(String.valueOf(number));
        buttonHost.setTextField(String.valueOf(number));
    }
    
    @Override
    public boolean isFromActionEvent(ActionEvent e) {
        return e.getSource() == jButton;
    }
    
    
}
