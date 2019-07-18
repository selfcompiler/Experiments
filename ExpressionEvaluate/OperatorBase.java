package ExpressionEvaluate;

import java.util.InvalidPropertiesFormatException;

public abstract class OperatorBase implements ExpressionElements {

    private Operator operator;

    private int priority;

    private ExpressionEnum expressionEnum=ExpressionEnum.OPERATOR;

    public OperatorBase(Operator operator,int priority){
        this.operator=operator;
        this.priority=priority;

    }
    @Override
    public String getElementType() {
        return expressionEnum.toString();
    }


    public int getPriority() {
        return this.priority;
    }

    public Operator getOperator(){
        return this.operator;
    }

    public static boolean comparePriority(OperatorBase o1,OperatorBase o2){
        return o1.getPriority() >= o2.getPriority();
    }
}
