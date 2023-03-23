package calculator;

import java.util.ArrayList;

import static calculator.ExpressionNode.NodeType.*;

public class ExpressionNode {

    private ExpressionNode.Operator operator;
    private Enum NodeType;

    private String number;

    public Enum getNodeType() {
        return NodeType;
    }

    public ExpressionNode.Operator getOperator() {
        return operator;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number += number;
    }

    public void setNodeType(Enum nodeType) {
        this.NodeType = nodeType;
    }

    public enum NodeType {
        NUMBER_TYPE,
        OPERATOR_TYPE,
    }


    public ExpressionNode(String num) {
        this.number = num;
        this.NodeType = NUMBER_TYPE;
    }

    public ExpressionNode(ExpressionNode.Operator operator) {
        this.NodeType = OPERATOR_TYPE;
        this.operator = operator;
    }


    public void appendNumber(String num) {
        if(num.length() !=1) {
            throw new IllegalArgumentException();
        }

        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("not a number", e);
        }


        this.number += num;
    }


    public double getValue() {
        return Double.parseDouble(this.number);
    }


    public enum Operator {
        PLUS("+", Order.LOWEST),
        MINUS("-", Order.LOWEST),
        MULTIPLY("*", Order.MIDDLE),
        DIVIDE("/", Order.MIDDLE),
        EXPONENT("^", Order.HIGHEST);

        private String text;
        private Order order;

        Operator(String text, Order order) {
            this.text = text;
            this.order = order;
        }

        public String getText() {
            return text;
        }

        public Order getOrder() {
            return order;
        }

        enum Order {
            HIGHEST,
            MIDDLE,
            LOWEST;
        }


    }


}
