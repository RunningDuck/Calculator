package calculator.buttons;

import calculator.ButtonHost;
import calculator.ExpressionNode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddButton implements CalculatorButton {
    
    private final JButton jButton;
    private ButtonHost buttonHost;
    
    public AddButton(ActionListener actionListener, ButtonHost buttonHost) {
        this.buttonHost = buttonHost;
        jButton = new JButton("+");
        jButton.addActionListener(actionListener);
    }
    
    
    public JButton getjButton() {
        return jButton;
    }
    
    
    @Override
    public void performAction() {
        buttonHost.getCalculator().addOpNode(ExpressionNode.Operator.PLUS);
        buttonHost.setTextField(ExpressionNode.Operator.PLUS.getText());
    }

    @Override
    public boolean isFromActionEvent(ActionEvent e) {
        return e.getSource() == jButton;
    }
    

}
