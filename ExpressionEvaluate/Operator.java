package ExpressionEvaluate;

public enum Operator {

    AND("&&"),

    OR("||");

    private String logicalOperator;

     Operator(String logicalOperator){
        this.logicalOperator=logicalOperator;
    }

    public String toString(){
         return this.logicalOperator;
    }
}
