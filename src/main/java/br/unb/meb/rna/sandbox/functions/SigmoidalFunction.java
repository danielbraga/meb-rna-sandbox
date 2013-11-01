package br.unb.meb.rna.sandbox.functions;

import br.unb.meb.rna.sandbox.api.Function;

/**
 * Created by daniel on 10/16/13.
 */
public class SigmoidalFunction implements Function {

    private double limiar;

    public SigmoidalFunction(double limiar) {
        this.limiar = limiar;
    }

    public SigmoidalFunction() {
        this.limiar = 0.0;
    }

    @Override
    public double discrete(double x) {
        double y = 1 + Math.exp(-1 * (x + this.limiar));
        return y;
    }


}
