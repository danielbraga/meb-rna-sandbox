package br.unb.meb.rna.sandbox.api;

/**
 * Created with IntelliJ IDEA.
 * User: danielbraga
 * Date: 10/17/13
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Connection {

    //public Connection(Neuron from, Neuron to);

    public boolean equalsConnectionFrom(Object o);
    public boolean equalsConnectionTo(Object o);
}
