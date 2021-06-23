package Framework;/*
This class is used to describe a Register in verilog
This class takes the info and prints the appropriate
verilog code

@author Stelios Papoutsakis

 */

public class Register extends VerilogComp {


    public Register(String name, int size, boolean isInput, boolean isOutput) {
        super(name, size, isInput, isOutput);

    }


    /*
    Overriden methods which write verilog code
     */
    @Override
    public String defineInput() {
        return "input " + sizeDef() + this.getName() + ";\n";

    }


    @Override
    public String defineOutput() {
        return "output " + sizeDef() + this.getName() + ";\n";

    }

    @Override
    public String defineReg() {
        int bit = this.getBitSize() - 1;
        if (bit > 0)
            return "wire " + "[" + bit + ":0] " + this.getName() + ";\n";
        return "wire " + this.getName() + ";\n";
    }

    @Override
    public String defineWire() {
        return "wire " + sizeDef() + this.getName() + "_next;\n";
    }

    @Override
    public String defineFlipFlop() {
        return "DFFR #(.SIZEFF(" + this.getBitSize() + ")) DFFR_" + this.getName() + "(" + this.getName() +
                "," + this.getName() + "_next," + VerilogComp.getClkName() + "," + VerilogComp.getResetName() + "," + this.getBitSize() + "'b0);\n";
    }

    public String sizeDef() {
        if (this.getBitSize() > 1) {
            int size = this.getBitSize() - 1;
            return "[" + size + ":0] ";
        }

        return "";
    }

    public static void main(String[] args) {
        Register r = new Register("A", 8, true, false);
        String str = r.defineOutput() + "\n" + r.defineReg() + "\n" + r.defineWire() + "\n" + r.defineFlipFlop();
        System.out.println(str);

    }


}
