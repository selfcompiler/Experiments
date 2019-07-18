package ExpressionEvaluate;

public enum ExpressionEnum {

    BRACKET("BRACKET"),
    TERM("TERM"),
    EXPRESSION("EXPRESSION"),
    OPERATOR("OPERATOR");


    String type;

    ExpressionEnum(String type) {

        this.type=type;

    }

    public String toString(){
        return this.type;
    }

}
