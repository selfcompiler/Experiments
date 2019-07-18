package ExpressionEvaluate;

import java.util.Comparator;

public class TermComparator implements Comparator<Term> {
    @Override
    public int compare(Term o1, Term o2) {

        return o1.hashCode()-o2.hashCode();

    }
}
