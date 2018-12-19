package Framework;

/*
The purpose of this class is to set a
list of params that all the comp in verilog follow

This makes it easy to print out the reset of the information later the verilog file

@author Stelios Papoutsakis
 */
public abstract class VerilogComp {

    /*
        shared parameters of all verilog comps
         */
    private String name;
    private int bitSize;
    private boolean isInput;


    private boolean isOutput;
    private static String clkName = "clk"; // default values of clk and reset, only changed if the user specifies
    private static String resetName = "reset";

    //ctor
    public VerilogComp(String name, int bitSize, boolean isInput, boolean isOutput) {
        this.bitSize = bitSize;
        this.name = name;
        this.isInput = isInput;
        this.isOutput = isOutput;
    }

    /*
    sub classes of this class will chose to see which methods they want to override
    , the rest will be empty strings
     */
    public String defineInput() {
        return "";
    } // verilog code which tells this compents is an input

    public String defineOutput() {
        return "";
    } // verilog code which tells this compents is an output

    public String defineReg() {
        return "";
    } // verilog defines a register

    public String defineWire() {
        return "";
    } // verilog code which defines a wire variable

    public String defineComp() {
        return "";
    } // verilog code which defines a component, like an Adder or Mux

    public String defineFlipFlop() {
        return "";
    } // verilog code which defines the flip flop behavour of a register at the end of a file


    //Getters Setters


    public String getName() {
        return name;
    }

    public int getBitSize() {
        return bitSize;
    }

    public void setBitSize(int bitSize) {
        this.bitSize = bitSize;
    }


    public boolean isInput() {
        return isInput;
    }

    public boolean isOutput() {
        return isOutput;
    }

    public void setInput(boolean input) {
        isInput = input;
    }

    public void setOutput(boolean output) {
        isOutput = output;
    }


    public static void setClkName(String clkName) {
        VerilogComp.clkName = clkName;
    }

    public static void setResetName(String resetName) {
        VerilogComp.resetName = resetName;
    }


    // I wanted these variables to be static so they are the same across all components

    public static String getClkName() {
        return clkName;
    }

    public static String getResetName() {
        return resetName;
    }

    public void setName(String name) {
        this.name = name;
    }


}
