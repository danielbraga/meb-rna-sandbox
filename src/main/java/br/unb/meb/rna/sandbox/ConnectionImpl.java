package br.unb.meb.rna.sandbox;

import br.unb.meb.rna.sandbox.api.Connection;
import br.unb.meb.rna.sandbox.api.Neuron;

/**
 * Created with IntelliJ IDEA.
 * User: danielbraga
 * Date: 10/17/13
 * Time: 5:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionImpl implements Connection {

    protected Neuron from;

    protected Neuron to;

    public ConnectionImpl(Neuron from, Neuron to) {
        this.from = from;
        this.to = to;

        this.from.add(this);
        this.to.add(this);
    }

    @Override
    public boolean equalsConnectionFrom(Object o) {
        if (o == null) return false;
        if (!(o instanceof Neuron)) return false;
        Neuron n = (Neuron) o;
        return from.equals(n);
    }

    @Override
    public boolean equalsConnectionTo(Object o) {
        if (o == null) return false;
        if (!(o instanceof Neuron)) return false;
        Neuron n = (Neuron) o;
        return to.equals(n);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Connection)) return false;

        Connection c = (Connection) o;
        if (c.equalsConnectionFrom(from)) {
            if (c.equalsConnectionTo(to)) {
                return true;
            }
        }
        return false;
    }
}
