package br.unb.meb.rna.sandbox;

import br.unb.meb.rna.sandbox.api.Function;

/**
 * Created by daniel on 10/16/13.
 */
public class DegrauFunction implements Function {

    private double limiar;

    DegrauFunction(double limiar) {
        this.limiar = limiar;
    }

    @Override
    public double discrete(double x) {
        if (x <= this.limiar) {
            return 0;
        } else {
            return 1;
        }
    }


}
