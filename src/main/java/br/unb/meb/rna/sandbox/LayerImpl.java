package br.unb.meb.rna.sandbox;

import br.unb.meb.rna.sandbox.api.Layer;
import br.unb.meb.rna.sandbox.api.Neuron;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 10/18/13.
 */
public class LayerImpl implements Layer {

    private List<Neuron> neurons = new ArrayList();

    private boolean first  = false;

    public LayerImpl() {
    }

    public LayerImpl(boolean first) {
        this.first = first;
    }

    @Override
    public Layer add(Neuron neuron) {
        if (neuron != null) {
            if (neurons.contains(neuron)) {
                neurons.add(neuron);
            }
        }
        return this;
    }

    @Override
    public Layer add(int index, Neuron neuron) throws IndexOutOfBoundsException {
        if (neuron != null && index > -1) {
            neurons.set(index, neuron);
        }
        return this;
    }

    @Override
    public Layer remove(Neuron neuron) {
        if (neuron != null) {
            neurons.remove(neuron);
        }
        return this;
    }

    @Override
    public Layer remove(int index) throws IndexOutOfBoundsException {
        if (index > -1) {
            neurons.remove(index);
        }
        return this;
    }

    @Override
    public int size() {
        return neurons.size();
    }

    public Layer defineFirstLayer() {
        this.first = true;
        return this;
    }

    public Layer defineNotFirstLayer() {
        this.first = false;
        return this;
    }

    @Override
    public double[] calculate() {
        double[] output = null;
        int size = size();
        if (size > 0) {
            output = new double[size];
            for (int i = 0; i < size; i++) {
                output[i] = neurons.get(i).calculate();
            }
        }

        return output;
    }

    @Override
    public double[] calculate(final double[] inputs) {
        int size = size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (first) {
                    if (i < inputs.length) {
                        double ins[] = new double[]{inputs[i]};
                        neurons.get(i).input(ins);
                    }
                } else {
                    neurons.get(i).input(inputs);
                }
            }
        }
        return calculate();
    }
}
