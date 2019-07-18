package ExpressionEvaluate;

public class AndOperator extends OperatorBase implements ExpressionElements {

    private int priority=2;

    public AndOperator(){
        super(Operator.AND,2);

    }

}
