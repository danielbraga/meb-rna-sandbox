package br.unb.meb.rna.sandbox;

import br.unb.meb.rna.sandbox.api.Connection;
import br.unb.meb.rna.sandbox.api.Function;
import br.unb.meb.rna.sandbox.api.Neuron;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 10/8/13.
 */
public class NeuronImpl implements Neuron {

    private Function transfer;

    private double[] inputs;

    private double[] weights;

    private List<Connection> connections = new ArrayList<Connection>();

    public NeuronImpl(final Function transfer) {
        this.transfer = transfer;
    }

    public NeuronImpl(final Function transfer, final double[] inputs) {
        this(transfer);
        this.inputs = inputs.clone();
    }

    public NeuronImpl(final Function transfer, final double[] inputs, final double[] weights) {
        this(transfer, inputs);
        this.weights = weights.clone();
    }

    @Override
    public Neuron input(final double[] inputs) {
        this.inputs = inputs.clone();
        return this;
    }

    @Override
    public Neuron weight(final double[] weights) {
        this.weights = weights.clone();
        return this;
    }

    @Override
    public double calculate(final double[] inputs) {
        this.inputs = inputs.clone();
        return calculate();
    }

    @Override
    public double calculate() {
        double sum = sum(this.inputs, this.weights);
        double y = transfer.discrete(sum);

        return y;
    }

    @Override
    public Neuron add(Connection conn) {
        if (conn != null) {
            if (!connections.contains(conn)) {
                connections.add(conn);
            }
        }
        return this;
    }

    @Override
    public Neuron conectTo(Neuron neuron) {
        if (neuron != null) {
            Connection c = new ConnectionImpl(this, neuron);
            add(c);
        }
        return this;
    }

    private double sum(final double[] inputs, final double[] weights) {
        double sum = 0;
        if (inputs != null && inputs.length > 0) {
            for (int i = 0; i < inputs.length; i++) {
                sum += inputs[i] * weights[i];
            }
        }
        return sum;
    }
}
