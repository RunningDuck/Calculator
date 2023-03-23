package calculator.buttons;

import calculator.ButtonHost;
import calculator.ExpressionNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpButton implements CalculatorButton{


    private ButtonHost buttonHost;
    private final JButton jButton;

    public ExpButton(ActionListener actionListener, ButtonHost buttonHost) {
        this.buttonHost = buttonHost;
        this.jButton = new JButton("^");
        jButton.addActionListener(actionListener);
    }
    @Override
    public void performAction() {
        buttonHost.getCalculator().addOpNode(ExpressionNode.Operator.EXPONENT);
        buttonHost.setTextField(ExpressionNode.Operator.EXPONENT.getText());
    }

    @Override
    public boolean isFromActionEvent(ActionEvent e) {
        return e.getSource() == jButton;
    }

    @Override
    public JButton getjButton() {
        return jButton;
    }
}
