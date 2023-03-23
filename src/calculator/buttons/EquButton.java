package calculator.buttons;

import calculator.ButtonHost;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquButton implements CalculatorButton {
    private final JButton jButton;

    private ButtonHost buttonHost;



    public EquButton(ActionListener actionListener, ButtonHost buttonHost) {
        this.buttonHost = buttonHost;
        jButton = new JButton("=");
        jButton.addActionListener(actionListener);
    }
    @Override
    public void performAction() {
        buttonHost.clearTextField();
        buttonHost.setTextField(String.valueOf(buttonHost.getCalculator().getResult()));
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
