 package ExpressionEvaluate;

import com.sun.tools.corba.se.idl.InvalidArgument;

import java.util.InvalidPropertiesFormatException;

public class MainFile {
    public static void main(String[] args) throws InvalidArgument, InvalidPropertiesFormatException {

        Expression expression=new Expression("");
        SimpleExpression simpleExpression1= (SimpleExpression) expression.getFinalExpressionSet( expression.splitter("(,(,A,||,(,C,&&,(,D,||,(,E,&&,(,F,||,X,),),),),),||,(,A,||,(,C,&&,(,D,||,(,E,&&,(,F,||,X,),),),),),)"));
        SimpleExpression simpleExpression2= (SimpleExpression) expression.getFinalExpressionSet( expression.splitter("(,(,A,||,(,C,&&,(,D,||,(,E,&&,(,F,||,X,),),),),),||,(,A,||,(,C,&&,(,D,||,(,E,&&,(,F,||,X,),),),),),)"));

        simpleExpression1.eliminateSuperSetTerms();
        simpleExpression2.eliminateSuperSetTerms();
        simpleExpression1.printExpression();
        simpleExpression2.printExpression();

        SimpleExpression simpleExpression=(SimpleExpression) expression.getFinalExpressionSet(expression.splitter("(,A,||,(,A,&&,(,B,&&,C,),),)"));


        //SimpleExpression simpleExpression2=(SimpleExpression) expression.getFinalExpressionSet(expression.splitter("(,A,&&,(,B,&&,C,),)"));

        simpleExpression.printExpression();

        simpleExpression.eliminateSuperSetTerms();

        simpleExpression.printExpression();


        System.out.println("Hello");
    }
}
