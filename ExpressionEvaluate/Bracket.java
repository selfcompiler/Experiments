package ExpressionEvaluate;

public enum Bracket {

    OPEN("("),
    CLOSE(")");

    private String type;

    Bracket(String type) {
        this.type=type;
    }

    @Override
    public String toString() {
        return type;
    }
}
