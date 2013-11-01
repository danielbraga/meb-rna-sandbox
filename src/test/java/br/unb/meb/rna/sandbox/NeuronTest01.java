package br.unb.meb.rna.sandbox;

import br.unb.meb.rna.sandbox.api.Function;
import br.unb.meb.rna.sandbox.api.Neuron;
import br.unb.meb.rna.sandbox.functions.TagenteSigmoidalFunction;

/**
 * Created by daniel on 10/16/13.
 */
public class NeuronTest01 {

    public static void main(String[] args) {
        //inputs
        double[] input1 = new double[]{0, 0};
        double[] input2 = new double[]{0, 1};
        double[] input3 = new double[]{1, 0};
        double[] input4 = new double[]{1, 1};

        Object[] inputs = new Object[]{input1, input2, input3, input4};

        //weights
        double[] weight1 = new double[]{0.2, 0.2};
        double[] weight2 = new double[]{0.25, 0.25};
        double[] weight3 = new double[]{0.26, 0.26}; //Start AND with Degrau com limiar 0.5
        double[] weight4 = new double[]{0.3, 0.3};
        double[] weight5 = new double[]{0.5, 0.5};
        double[] weight6 = new double[]{0.6, 0.6}; //Start OR with Degrau com limiar 0.5
        double[] weight7 = new double[]{1, 1};
        double[] weight8 = new double[]{1.4, 1.4};

        //Object[] weights = new Object[]{weight1, weight2, weight3, weight4, weight5, weight6, weight7};
        Object[] weights = new Object[]{weight8};


        //Function t = new DegrauFunction(0.5);
        Function t = new TagenteSigmoidalFunction();

        for (Object input : inputs) {
            double[] in = (double[]) input;

            System.out.println("-------------------------------");
            System.out.print("Inputs......: ");
            System.out.print("[ ");
            for (int i = 0; i < in.length; i++) {
                if (i != 0) {
                    System.out.print(", ");
                }
                System.out.print(in[i]);
            }
            System.out.println("  ]");

            for (Object weight : weights) {
                double[] we = (double[]) weight;

                Neuron neuron = new NeuronImpl(t, in, we);
                double output = neuron.calculate();
                printvar(in, we, output);
            }
        }



    }

    private static void printvar(double[] inputs, double[] weights, double output) {
        System.out.print("Weights.....: ");
        System.out.print("[ ");
        for (int i = 0; i < weights.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(weights[i]);
        }
        System.out.println("  ]");
        System.out.println("Output......: " + output);
    }
}
