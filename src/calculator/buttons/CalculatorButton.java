package calculator.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public interface CalculatorButton {
    
    void performAction();
    
    boolean isFromActionEvent(ActionEvent e);
    
    public JButton getjButton();
}
