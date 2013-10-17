package br.unb.meb.rna.sandbox.api;

/**
 * Created with IntelliJ IDEA.
 * User: danielbraga
 * Date: 10/17/13
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Layer {

    public Layer add(Neuron neuron);

    public Layer add(int index, Neuron neuron) throws IndexOutOfBoundsException;

    public Layer remove(Neuron neuron);

    public Layer remove(int index) throws IndexOutOfBoundsException;

    public int size();

    public double[] calculate();

    public double[] calculate(double[] inputs);
}
