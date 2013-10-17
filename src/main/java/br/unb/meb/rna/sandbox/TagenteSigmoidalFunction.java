package br.unb.meb.rna.sandbox;

import br.unb.meb.rna.sandbox.api.Function;

/**
 * Created by daniel on 10/16/13.
 */
public class TagenteSigmoidalFunction implements Function {

    private double limiar;

    TagenteSigmoidalFunction(double limiar) {
        this.limiar = limiar;
    }

    TagenteSigmoidalFunction() {
        this.limiar = 0.0;
    }

    @Override
    public double discrete(double x) {
        double e_plus = Math.exp(x + this.limiar);
        double e_minus = Math.exp(-1 * (x + this.limiar));

        double p = e_plus - e_minus;
        double q = e_plus + e_minus;

        double y = p / q;

        return y;
    }


}
