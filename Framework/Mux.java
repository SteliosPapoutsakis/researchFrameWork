package Framework;/*
This class is used to describe a Mux in verilog
This class takes the info and prints the appropriate
verilog code

@author Stelios Papoutsakis
*/


public class Mux extends VerilogComp {
    private VerilogComp[] inputs; // array of the inputs to the mux
    private int selectionSize = 0; // size of the select bits
    private Register input; // register whose mux outputs to it
    private int size; // size of mux

    public Mux(int size, int bitSize, Register input) {
        super("mux" + input.getName(), bitSize, false, false);
        this.input = input;
        this.size = size;
        int i = size;
        // calculating size of array based on size of mux
        while (i != 1) {
            i = i / 2;
            this.selectionSize++;
        }
        this.inputs = new VerilogComp[size];
    }

    /*
Overriden methods which write verilog code
 */


    @Override
    public String defineWire() {
        int bit = this.selectionSize - 1;
        String str = "";
        if (bit > 0)
            str = "[" + bit + ":0] ";
        return "wire " + str + this.getName() + "_Select;\n";
    }

    @Override
    public String defineComp() {

        String str = "Mux" + this.getSize() + "#(.SIZE(" + this.getBitSize() + "))"
                + " " + this.getName() + "(" + this.input.getName() + "_next, ";
        int count = 0;
        // loops to see how many inputs the mux has
        for (VerilogComp comp : this.inputs) {
            if (comp == null) continue;
            if (comp instanceof Subtractor)
                str += comp.getName() + "_difference";
            else if (comp instanceof Multiplier)
                str += comp.getName() + "_product";
            else if (comp instanceof Divider)
                str += comp.getName() + "_quotient";
            else if (comp instanceof Adder)
                str += comp.getName() + "_sum";
            else if (comp instanceof And)
                str += comp.getName() + "_and";
            else if (comp instanceof Or)
                str += comp.getName() + "_or";
            else
                str += comp.getName();
            count++;
            str += ", ";
        }
        // if inputs don't match the size, fill it with "," and empty parameters
        while (count < this.size) {
            str += ", ";
            count++;
        }
        str += this.getName() + "_Select);";
        return str + "\n";

    }


    // adding inputs for the muxes
    public boolean addInput(VerilogComp comp, int index) {
        if (Math.abs(index) >= this.size) {
            System.out.println("Error index too big");
            return false;
        }

        // don't put in duplicates
        for (VerilogComp comp2 : this.inputs) {
            if (comp2 == null) continue;
            if (comp2.getName().equals(comp.getName()))
                return false;
        }
        this.inputs[index] = comp;
        return true;
    }


    // Getters and Setters
    public Register getInput() {
        return input;
    }

    public int getSize() {
        return size;
    }


    public static void main(String[] args) {

    }

    public VerilogComp[] getInputs() {
        return inputs;
    }


    public int getSelectionSize() {
        return selectionSize;
    }


}
