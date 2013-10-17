package br.unb.meb.rna.sandbox;

import br.unb.meb.rna.sandbox.api.Function;
import br.unb.meb.rna.sandbox.api.Neuron;

/**
 * Created by daniel on 10/16/13.
 */
public class NeuronPortLogicANDTrainingTest {


    public static void main(String[] args) {

        //Test Port Logic AND - One Neuron

        double degrau_limit = 0.5d;


        // inputs of neuron
        double[] inputs = new double[]{1, 1};

        // value expect
        double expect = 1;

        // precision
        double precision = 0.01;

        // tax of evaluation
        double evaluation = 0.1;
        //double evaluation = degrau_limit;

        // weight init
        double[] weigths = new double[]{0, 0};

        // function T
        //Function t = new DegrauFunction(degrau_limit);
        //Function t = new LogisticSigmoidalFunction();
        Function t = new TagenteSigmoidalFunction();

        //Create a neuron for Port Logic AND
        Neuron neuron = new NeuronImpl(t, inputs, weigths);

        //training vars
        double error_rms = 0;
        int training_limit = 100;
        int count = 0;
        boolean training = true;

        double output = 0;

        //Loop of training
        while (training) {
            output = neuron.run();

            error_rms = Math.abs(expect - output);
            if (error_rms <= precision) {
                training = false;
                break;
            }

            for (int i = 0; i < weigths.length; i++) {
                double factor = evaluation * error_rms * inputs[i];
                weigths[i] += factor;
            }
            neuron.weight(weigths);


            count++;
        }

        System.out.println("Port Logic AND - end of trainning");
        System.out.println("------------------------------------");
        System.out.println(String.format("Output.............: %s", output));
        System.out.println(String.format("Count of training..: %s", count));
        System.out.print("Weigths............: ");
        for (int i = 0; i < weigths.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(weigths[i]);
        }
        System.out.println();
        System.out.println("------------------------------------");
    }


}
