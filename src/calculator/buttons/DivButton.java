package calculator.buttons;

import calculator.ButtonHost;
import calculator.ExpressionNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivButton implements CalculatorButton{

    private final JButton jButton;
    private ButtonHost buttonHost;
    private char operator;

    public DivButton(ActionListener actionListener, ButtonHost buttonHost) {
        jButton = new JButton("/");
        this.buttonHost = buttonHost;
        jButton.addActionListener(actionListener);
    }


    @Override
    public void performAction() {
        buttonHost.getCalculator().addOpNode(ExpressionNode.Operator.DIVIDE);
        buttonHost.setTextField(ExpressionNode.Operator.DIVIDE.getText());
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
