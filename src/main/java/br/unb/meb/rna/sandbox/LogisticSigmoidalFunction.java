package br.unb.meb.rna.sandbox;

import br.unb.meb.rna.sandbox.api.Function;

/**
 * Created by daniel on 10/16/13.
 */
public class LogisticSigmoidalFunction extends SigmoidalFunction {

    LogisticSigmoidalFunction(double limiar) {
        super(limiar);
    }

    LogisticSigmoidalFunction() {
        super();
    }

    @Override
    public double discrete(double x) {
        double s = super.discrete(x);
        double y = 1 / s;
        return y;
    }


}
