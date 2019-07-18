package ExpressionEvaluate;

import com.sun.tools.corba.se.idl.InvalidArgument;

import java.util.*;

public class Expression {

    boolean isFinalExpression = false;

    private String expression;


    private Set<Term> expressionSet = new HashSet<>();

    private Set<Set<Expression>> expresssionSet = new HashSet<>();

    public Expression(String expression) {
        this.expression = expression;
    }

    public LinkedList<String> splitter(String expression) {
        List<String> temp = Arrays.asList(expression.split(","));
        System.out.println(temp);
        LinkedList<String> result=new LinkedList<>();
        for(String t:temp){

            result.add(t);
        }


        return result;
    }

    public ExpressionElements getFinalExpressionSet(LinkedList<String> expression) throws InvalidArgument, InvalidPropertiesFormatException {

        ExpressionElementFactory expressionElementFactory=new ExpressionElementFactory();
        Stack<ExpressionElements> operand=new Stack<>();

        Stack<OperatorBase> operator=new Stack<>();

        Iterator<String> it=expression.iterator();

        ExpressionElements expressionElement;

        if (it.hasNext()){

            BracesTerm bracesTerm=(BracesTerm)expressionElementFactory.getExpressionElement(it.next());
            if(bracesTerm.isOpen()){

                operand.push(bracesTerm);

            }else {
                throw new InvalidArgument("Invalid Expression For Evaluation");
            }

        }
        while (it.hasNext()){

            expressionElement=expressionElementFactory.getExpressionElement(it.next());

            if(ExpressionEnum.TERM.toString().compareTo(expressionElement.getElementType().toString())==0){

                operand.push((Term)expressionElement);
                continue;
            }
            if(ExpressionEnum.OPERATOR.toString().compareTo(expressionElement.getElementType().toString())==0){

                OperatorBase currentElement=(OperatorBase)expressionElement;
                operator.push(currentElement);
                continue;
            }
            if(ExpressionEnum.BRACKET.toString().compareTo(expressionElement.getElementType())==0){

                BracesTerm bracesTerm=(BracesTerm)expressionElement;

                if(bracesTerm.isOpen()){

                    operand.push(bracesTerm);
                    continue;
                }

                if(bracesTerm.isClose()){

                    ExpressionElements topStack=operand.peek();

                    if(ExpressionEnum.BRACKET.toString().compareTo(topStack.getElementType())==0){

                        BracesTerm temp=(BracesTerm) topStack;
                        if(temp.isOpen()){
                            throw new InvalidArgument("EMPTY BRACKETS NOT ALLOWED");
                        }
                        else{
                            throw new InvalidArgument("Invalid Expression got '))' ");
                        }
                    }
                    while (true){
                                            /*
                                            *
                                            *    (<EMPTY>) IS INVALID STMT
                                            *    (<NOT_EMPTY>) IS VALID STMT
                                            *
                                            *
                                            * */
                        ExpressionElements e1=operand.peek();
                        operand.pop();
                        ExpressionElements e2=operand.peek();
                        operand.pop();

                        if(ExpressionEnum.BRACKET.toString().compareTo(e2.getElementType())==0){

                            BracesTerm temp=(BracesTerm)e2;

                            if(temp.isOpen()){
                                operand.push(e1);
                                break;
                            }
                            else{
                                throw new InvalidArgument("Invalid compuation Exception");
                            }
                        }

                        ExpressionElements result=OperatorHelper.doOperations(e1,e2,operator.peek());
                        operator.pop();
                        operand.push(result);

                    }
                    continue;
                }
            }

        }

        if(operand.size()>1 || operator.size()>0){

            throw new InvalidArgument("Missing operators in expression or Some operand missing ");
        }

        ExpressionElements expressionElements=operand.peek();
        operand.pop();
        operand.clear();
        operator.clear();



        return expressionElements;

    }



}

