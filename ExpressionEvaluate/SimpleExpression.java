package ExpressionEvaluate;

import com.sun.tools.corba.se.idl.InvalidArgument;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SimpleExpression implements ExpressionElements {

    private ExpressionEnum expressionEnum=ExpressionEnum.EXPRESSION;

    private Set<Term> expression=new TreeSet<>(new TermComparator());

    public SimpleExpression(){

    }

    public SimpleExpression(HashSet<Term> expression){
        this.expression=expression;
    }

    public SimpleExpression(SimpleExpression simpleExpression){

        this.expression=simpleExpression.getExpression();

    }

    @Override
    public int hashCode() {
        return hashString().hashCode();
    }

    public String hashString(){
        String code="";
        for(Term term:this.expression){
            code=code+"#"+term.hashString();
        }
        return code;
    }

    @Override
    public boolean equals(Object obj) {

        SimpleExpression simpleExpression=(SimpleExpression)obj;

        if(this.expression.size()!=simpleExpression.getExpression().size()){
            return false;
        }
        Iterator<Term> localIt=this.expression.iterator();
        for(Term t:simpleExpression.getExpression()){
            if(!t.equals(localIt.next())){
                return false;
            }
        }
        return true;
    }

    @Override
    public String getElementType() {
        return expressionEnum.toString();
    }

    public Set<Term> getExpression(){
        return this.expression;
    }

    public void eliminateSuperSetTerms() throws InvalidArgument {

        TreeSet<Term> result=new TreeSet<>(new TermComparator());

        Iterator<Term> iterator;
        while(this.expression.size()>0){

            iterator=this.expression.iterator();
            TreeSet<Term> mergedTerms=new TreeSet<>(new TermComparator());
            Term term=iterator.next();
            mergedTerms.add(term);
            while (iterator.hasNext()){

                    Term next= iterator.next();
                    if(Term.isSubSet(term,next)){

                        term=Term.mergeTerms(term,next);
                        mergedTerms.add(next);
                    }
            }
            result.add(term);
            this.expression.removeAll(mergedTerms);
            mergedTerms.clear();
        }
        this.expression.addAll(result);
        result.clear();
    }

    public void printExpression(){

        System.out.print("( ");
        boolean isFirst=true;
        for(Term t:this.expression){

            if(!isFirst){
                System.out.print(" || ");
            }
            isFirst=false;
            t.print();
        }
        System.out.println(" )");
    }

}
