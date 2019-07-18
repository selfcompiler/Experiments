package ExpressionEvaluate;

import com.sun.tools.corba.se.idl.InvalidArgument;

public class ExpressionElementFactory {

    public ExpressionElementFactory(){

    }

    public ExpressionElements getExpressionElement(String element) throws InvalidArgument {

        ExpressionEnum expressionEnum;
        if((Bracket.OPEN.toString().compareTo(element)==0) || (Bracket.CLOSE.toString().compareTo(element)==0)){
            expressionEnum=ExpressionEnum.BRACKET;
        }else if((Operator.AND.toString().compareTo(element)==0)||(Operator.OR.toString().compareTo(element)==0)){
            expressionEnum=ExpressionEnum.OPERATOR;
        }else{
            expressionEnum=ExpressionEnum.TERM;
        }

        switch (expressionEnum){
            case TERM:
                return new Term(element);
            case OPERATOR:
                 if(Operator.AND.toString().compareTo(element)==0){
                     return new AndOperator();
                 }else{
                     return new OrOperator();
                 }
            case BRACKET:
                return new BracesTerm(element);
            default:
                throw new InvalidArgument("Invalid Argument " + expressionEnum);

        }

    }
}
