package ExpressionEvaluate;

import apple.laf.JRSUIUtils;
import com.sun.tools.corba.se.idl.InvalidArgument;

import java.util.*;

public class Term implements ExpressionElements {

    private ExpressionEnum expressionEnum=ExpressionEnum.TERM;

    private Set<String> elements=new TreeSet<>();

    public Term(TreeSet<String> elements){
        this.elements=elements;
    }


    public Term(Term term){
        this.elements=term.elements;
    }

    public void andOperation(Term term){

      for(String element:term.elements){
          this.elements.add(element);
      }
    }

    public static SimpleExpression andOperation(Term t1, Term t2){

        TreeSet<String> result=new TreeSet<>();

        for(String element:t1.elements){
           result.add(element);
        }
        for(String element:t2.elements){
            result.add(element);
        }
        Term term=new Term(result);
        HashSet<Term> hashSetTerm=new HashSet<>();
        hashSetTerm.add(term);
        return new SimpleExpression(hashSetTerm);
    }

    public static Term andOperationGetTerm(Term t1, Term t2){

        TreeSet<String> result=new TreeSet<>();

        for(String element:t1.elements){
            result.add(element);
        }
        for(String element:t2.elements){
            result.add(element);
        }
        return new Term(result);

    }


    public static SimpleExpression andOperation(SimpleExpression simpleExpression,Term term){

        HashSet<Term> result=new HashSet<>();
            for(Term term1:simpleExpression.getExpression()){
                result.add(andOperationGetTerm(term1,term));
            }
        return new SimpleExpression(result);
    }

    public static SimpleExpression orOperation(Term t1,Term t2){
        HashSet<Term> result=new HashSet<>();
        result.add(t1);
        result.add(t2);
        return new SimpleExpression(result);
    }

    public static SimpleExpression orOperation(SimpleExpression simpleExpression,Term term){
        SimpleExpression simpleExpression1=new SimpleExpression(simpleExpression);
        simpleExpression1.getExpression().add(term);
        return simpleExpression1;
    }

    public static SimpleExpression andOperation(SimpleExpression s1,SimpleExpression s2){

        HashSet<Term> result=new HashSet<>();

        for(Term t1:s1.getExpression()){

            for(Term t2:s2.getExpression()){

                Term temp=Term.andOperationGetTerm(t1,t2);
                result.add(temp);
            }
        }
        return new SimpleExpression(result);
    }

    public static SimpleExpression orOperation(SimpleExpression s1,SimpleExpression s2){

        HashSet<Term> result=new HashSet<>();

        for(Term term:s1.getExpression()){
            result.add(term);
        }

        for(Term term:s2.getExpression()){
            result.add(term);
        }
        return new SimpleExpression(result);
    }


    public Term(String term){
        String[] elements=term.split("&&");
        for(String element:elements){
            this.elements.add(element);
        }
    }

    public static SimpleExpression operatorFun(ExpressionElements e1,ExpressionElements e2,OperatorBase operatorBase) throws InvalidArgument {


        if(Operator.AND.toString().compareTo(operatorBase.getOperator().toString())==0){


            if((ExpressionEnum.EXPRESSION.toString().compareTo(e1.getElementType().toString())==0) && (ExpressionEnum.EXPRESSION.toString().compareTo(e2.getElementType().toString())==0)){

                    return andOperation((SimpleExpression) e1,(SimpleExpression) e2);
            }

            if((ExpressionEnum.EXPRESSION.toString().compareTo(e1.getElementType().toString())==0) && (ExpressionEnum.TERM.toString().compareTo(e2.getElementType().toString())==0)){

                return andOperation((SimpleExpression) e1,(Term) e2);
            }
            if((ExpressionEnum.TERM.toString().compareTo(e1.getElementType().toString())==0) && (ExpressionEnum.EXPRESSION.toString().compareTo(e2.getElementType().toString())==0)){

                return andOperation((SimpleExpression) e2,(Term) e1);

            }

            if((ExpressionEnum.TERM.toString().compareTo(e1.getElementType().toString())==0) && (ExpressionEnum.TERM.toString().compareTo(e2.getElementType().toString())==0)){

                return andOperation((Term) e2,(Term) e1);

            }

        }


        if(Operator.OR.toString().compareTo(operatorBase.getOperator().toString())==0){

            if((ExpressionEnum.EXPRESSION.toString().compareTo(e1.getElementType().toString())==0) && (ExpressionEnum.EXPRESSION.toString().compareTo(e2.getElementType().toString())==0)){

                return orOperation((SimpleExpression) e1,(SimpleExpression) e2);
            }

            if((ExpressionEnum.EXPRESSION.toString().compareTo(e1.getElementType().toString())==0) && (ExpressionEnum.TERM.toString().compareTo(e2.getElementType().toString())==0)){

                return orOperation((SimpleExpression) e1,(Term) e2);
            }
            if((ExpressionEnum.TERM.toString().compareTo(e1.getElementType().toString())==0) && (ExpressionEnum.EXPRESSION.toString().compareTo(e2.getElementType().toString())==0)){

                return orOperation((SimpleExpression) e2,(Term) e1);

            }

            if((ExpressionEnum.TERM.toString().compareTo(e1.getElementType().toString())==0) && (ExpressionEnum.TERM.toString().compareTo(e2.getElementType().toString())==0)){

                return orOperation((Term) e2,(Term) e1);

            }

        }

        throw new InvalidArgument("Invalid Expression Input");

    }

    @Override
    public int hashCode() {
        int hashCode=0;
        return hashString().hashCode();
    }

    public String hashString(){
        String code="";
        for(String s:this.elements){
            code=code+"_"+s;
        }
        return code;
    }
    @Override
    public String getElementType() {
        return expressionEnum.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Term term=(Term)obj;
        Iterator<String> it=term.elements.iterator();
        for(String s:term.elements){
            if(s.compareTo(it.next())!=0){
                return false;
            }
        }
        return true;
    }



    public static boolean isSubSet(Term t1,Term t2){

        if(t1.elements.size()>=t2.elements.size()){
            if(t1.elements.containsAll(t2.elements)){
                return true;
            }
        }else{
            if(t2.elements.containsAll(t1.elements)){
                return true;
            }
        }
        return false;
    }

    public static Term mergeTerms(Term t1,Term t2)throws InvalidArgument {

        if(Term.isSubSet(t1,t2)){

            if(t1.elements.size()>=t2.elements.size()){
                return t2;
            }
            return t1;
        }
        else {
            throw new InvalidArgument("Cannot reduce Terms");
        }
    }

    public TreeSet<Term> reducedTerm(Term t1,Term t2){

        TreeSet<Term> result=new TreeSet<>();
        result.add(t1);
        result.add(t2);
        if(t1.elements.size()>=t2.elements.size()){
            if(t1.elements.containsAll(t2.elements)){
                result.remove(t1);
            }
        }else{
            if(t2.elements.containsAll(t1.elements)){
                result.remove(t2);
            }
        }
        return result;
    }

    public void print(){
        System.out.print("( ");
        boolean isFirst=true;
        for(String s:this.elements){
            if(!isFirst)
                System.out.print(" && ");
            System.out.print(s+" ");
            isFirst=false;
        }
        System.out.print(")");
    }
}
