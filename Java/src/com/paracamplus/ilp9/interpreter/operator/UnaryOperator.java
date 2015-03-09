/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp9.interpreter.operator;

import com.paracamplus.ilp9.interpreter.interfaces.EvaluationException;

public abstract class UnaryOperator extends Operator {
    
    public UnaryOperator (String name) {
        super(name);
    }

    public int getArity() {
        return 1;
    }
    
    public abstract Object apply (Object operand) throws EvaluationException;

    public Object apply(Object... argument) throws EvaluationException {
        if ( argument.length == getArity() ) {
            return apply(argument[0]);
        } else {
            String msg = "Wrong arity for operator " + this.getName();
            throw new EvaluationException(msg);
        }
    }
}
