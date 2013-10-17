package br.unb.meb.rna.sandbox;

import br.unb.meb.rna.sandbox.api.Function;
import br.unb.meb.rna.sandbox.api.Neuron;

/**
 * Created by daniel on 10/8/13.
 */
public class NeuronImpl implements Neuron {

    private Function transfer;

    //private Function sum = new SumFunction();

    private double[] inputs;

    private double[] weights;

    public NeuronImpl(Function transfer) {
        this.transfer = transfer;
    }

    public NeuronImpl(Function transfer, double[] inputs) {
        this(transfer);
        this.inputs = inputs.clone();
    }

    public NeuronImpl(Function transfer, double[] inputs, double[] weights) {
        this(transfer, inputs);
        this.weights = weights.clone();
    }

    @Override
    public Neuron input(double[] inputs) {
        this.inputs = inputs.clone();
        return this;
    }

    @Override
    public Neuron weight(double[] weights) {
        this.weights = weights.clone();
        return this;
    }

    @Override
    public double run(double[] inputs) {
        this.inputs = inputs.clone();
        return run();
    }

    @Override
    public double run() {
        double sum = sum(this.inputs, this.weights);
        double y = transfer.discrete(sum);

        return y;
    }

    private double sum(double[] inputs, double[] weights) {
        double sum = 0;
        if (inputs != null && inputs.length > 0) {
            for (int i = 0; i < inputs.length; i++) {
                sum += inputs[i] * weights[i];
            }
        }
        return sum;
    }
}
