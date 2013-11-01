package br.unb.meb.rna.sandbox.functions;

/**
 * Created by daniel on 10/16/13.
 */
public class LogisticSigmoidalFunction extends SigmoidalFunction {

    public LogisticSigmoidalFunction(double limiar) {
        super(limiar);
    }

    public LogisticSigmoidalFunction() {
        super();
    }

    @Override
    public double discrete(double x) {
        double s = super.discrete(x);
        double y = 1 / s;
        return y;
    }


}
