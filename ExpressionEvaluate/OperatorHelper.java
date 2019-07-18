package ExpressionEvaluate;

import com.sun.tools.corba.se.idl.InvalidArgument;

public class OperatorHelper {

    public static SimpleExpression doOperations(ExpressionElements e1,ExpressionElements e2,OperatorBase operatorBase) throws InvalidArgument {

        return Term.operatorFun(e1,e2,operatorBase);
    }

}
