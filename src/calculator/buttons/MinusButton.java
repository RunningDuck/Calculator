package calculator.buttons;

import calculator.ButtonHost;
import calculator.ExpressionNode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MinusButton implements CalculatorButton {

    private final JButton jButton;
    private ButtonHost buttonHost;
    private char operator;

    public MinusButton(ActionListener actionListener, ButtonHost buttonHost) {
        this.buttonHost = buttonHost;
        jButton = new JButton("-");
        jButton.addActionListener(actionListener);
    }


    public JButton getjButton() {
        return jButton;
    }


    @Override
    public void performAction() {
        buttonHost.getCalculator().addOpNode(ExpressionNode.Operator.MINUS);
        buttonHost.setTextField(ExpressionNode.Operator.MINUS.getText());
    }

    @Override
    public boolean isFromActionEvent(ActionEvent e) {
        return e.getSource() == jButton;
    }


    public double addSomething(double num1, double num2) {
        return num1 + num2;
    }
}
