package br.unb.meb.rna.sandbox;

import br.unb.meb.rna.sandbox.api.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 10/18/13.
 */
public class NetworkImpl implements Network {

    private List<Layer> layers = new ArrayList<Layer>();

    @Override
    public Network add(Layer layer) {
        if (layer != null) {
            if (!layers.contains(layer)) {
                if (layers.size() == 0) {
                    layer.defineFirstLayer();
                } else {
                    layer.defineNotFirstLayer();
                }
                layers.add(layer);
            }
        }
        return this;
    }

    @Override
    public Network add(int index, Layer layer) throws IndexOutOfBoundsException {
        if (layer != null && index > -1) {
            layers.set(index, layer);
        }
        return this;
    }

    @Override
    public Network remove(Layer layer) {
        if (layer != null) {
            layers.remove(layer);
        }
        return this;
    }

    @Override
    public Network remove(int index) throws IndexOutOfBoundsException {
        if (index > -1) {
            layers.remove(index);
        }
        return this;
    }

    @Override
    public int size() {
        return layers.size();
    }

    @Override
    public double[] calculate() {
        return calculate(null);
    }

    @Override
    public double[] calculate(final double[] inputs) {
        double[] output = null;
        int size = size();

        if (size > 0) {
            double[][] outputs = null;
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    if (inputs == null || inputs.length == 0) {
                        outputs[i] = layers.get(i).calculate();
                    } else {
                        outputs[i] = layers.get(i).calculate(inputs);
                    }
                } else {
                    int preview = i - 1;
                    outputs[i] = layers.get(i).calculate(outputs[preview]);
                }
            }
            int last = size - 1;
            output = outputs[last];
        }

        return output;
    }
}
