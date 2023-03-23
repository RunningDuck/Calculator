package calculator;

import java.util.ArrayList;

import static calculator.ExpressionNode.NodeType.OPERATOR_TYPE;

public class Calculator {

    private ArrayList<ExpressionNode> nodeList;

    public Calculator() {
        nodeList = new ArrayList<>();
        nodeList.add(new ExpressionNode(""));
    }


    public void addNumNode(String number) {
        if (getLastNode().getNodeType() == OPERATOR_TYPE) {
            nodeList.add(new ExpressionNode(number));
        } else {
            getLastNode().appendNumber(number);
        }

    }

    public void appendDot() {
        if (getLastNode().getNodeType() == OPERATOR_TYPE) {
            throw new IllegalArgumentException("can not add dot here");
        } else if (getLastNode().getNumber().contains(".")) {
            throw new IllegalArgumentException("can not have more than one dot in a number");
        } else {
            getLastNode().setNumber(".");
        }

    }


    public void addOpNode(ExpressionNode.Operator operator) {
        if (getLastNode().getNodeType() != OPERATOR_TYPE) {
            nodeList.add(new ExpressionNode(operator));
        } else {
            getLastNode().setNodeType(operator);
        }
    }


    public ExpressionNode getLastNode() {
        return this.nodeList.get(nodeList.size() - 1);
    }

    public double getResult() {
        for (int i = 0; i < nodeList.size() - 1; i++) {
            if (nodeList.get(i).getNodeType() == OPERATOR_TYPE) {
                if (nodeList.get(i).getOperator().getOrder() == ExpressionNode.Operator.Order.HIGHEST) {
                    doCalculation(i);
                    i--;
                }
            }
        }

        for (int i = 0; i < nodeList.size() - 1; i++) {
            if (nodeList.get(i).getNodeType() == OPERATOR_TYPE) {
                if (nodeList.get(i).getOperator().getOrder() == ExpressionNode.Operator.Order.MIDDLE) {
                    doCalculation(i);
                    i--;
                }
            }
        }

        for (int i = 0; i < nodeList.size() - 1; i++) {
            if (nodeList.get(i).getNodeType() == OPERATOR_TYPE) {
                doCalculation(i);
                i--;
            }
        }
        return nodeList.get(0).getValue();

    }

    public void doCalculation(int index) {
        double num1 = nodeList.get(index - 1).getValue();
        double num2 = nodeList.get(index + 1).getValue();
        double result = 0;

        switch (nodeList.get(index).getOperator()) {
            case PLUS: {
                result = num1 + num2;
                break;
            }
            case MINUS: {
                result = num1 - num2;
                break;
            }
            case MULTIPLY:
                result = num1 * num2;
                break;
            case DIVIDE:
                result = num1 / num2;
                break;
            case EXPONENT:
                result = Math.pow(num1, num2);
                break;
            default:
                break;


        }

        nodeList.set(index - 1, new ExpressionNode(String.valueOf(result)));
        nodeList.remove(index);
        nodeList.remove(index);

    }

}
