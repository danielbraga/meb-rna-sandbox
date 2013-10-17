package br.unb.meb.rna.sandbox.api;

/**
 * Created by daniel on 10/8/13.
 */
public interface Neuron extends Cloneable {

    public Neuron input(double[] inputs);

    public Neuron weight(double[] weights);

    public double run(double[] inputs);

    public double run();

}
