package ExpressionEvaluate;

import com.sun.tools.corba.se.idl.InvalidArgument;

import java.util.InvalidPropertiesFormatException;

public class BracesTerm implements ExpressionElements {

    private String braces;

    private ExpressionEnum expressionEnum=ExpressionEnum.BRACKET;

    public BracesTerm(String braces) throws InvalidArgument {

        if(braces.compareTo(")")!=0 && braces.compareTo("(")!=0)
        {
            throw new InvalidArgument("Invalid Argument Exception ");
        }
        this.braces=braces;

    }

    public boolean isOpen(){

        return braces.equalsIgnoreCase("(");

    }

    public boolean isClose(){
        return braces.equalsIgnoreCase(")");
    }

    @Override
    public String getElementType() {

        return expressionEnum.toString();

    }
}
