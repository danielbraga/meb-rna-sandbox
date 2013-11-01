package br.unb.meb.rna.sandbox.api;

/**
 * Created with IntelliJ IDEA.
 * User: danielbraga
 * Date: 10/17/13
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Network {

    public Network add(Layer layer);
    public Network add(int index, Layer layer) throws IndexOutOfBoundsException;
    public Network remove(Layer layer);
    public Network remove(int index) throws IndexOutOfBoundsException;
    public int size();
    public double[] calculate();
    public double[] calculate(double[] inputs);

}
