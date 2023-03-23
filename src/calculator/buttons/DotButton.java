package calculator.buttons;

import calculator.ButtonHost;
import calculator.ExpressionNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DotButton implements CalculatorButton{

    private JButton jButton;
    private ButtonHost buttonHost;

    public DotButton(ActionListener actionListener, ButtonHost buttonHost) {
        this.jButton = new JButton(".");
        this.buttonHost = buttonHost;
        jButton.addActionListener(actionListener);
    }

    @Override
    public void performAction() {
        buttonHost.getCalculator().appendDot();
        buttonHost.setTextField(jButton.getText());
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
