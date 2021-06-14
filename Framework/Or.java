package Framework;


public class Or extends VerilogComp {

    private VerilogComp[] inputs = new VerilogComp[2]; // adder has two inputs that add

    // constructor
    public Or(String name, int size) {
        super(name, size, false, false);
    }

    /*

    Overriden methods which write verilog code
     */
    @Override
    public String defineWire() {
        return "wire " + sizeDef() + this.getName() + "_or;\n";
    }

    @Override
    public String defineComp() {
        return "Or#(.SIZE(" + this.getBitSize() + "))" + " " + this.getName() + "( " + this.getName() + "_or," + this.inputs[0].getName() + ", "
                + this.inputs[1].getName() + ");\n";

    }

    // adds inputs to the adder
    public void addInput(VerilogComp comp, int index) {
        if (Math.abs(index) > 1) System.out.println("Error index too high");
        this.inputs[index] = comp;
    }

    public VerilogComp[] getInputs() {
        return inputs;
    }

    public boolean isAndInput(VerilogComp comp)
    {
        for(VerilogComp comp2:this.getInputs())
            if(comp2==comp) return true;
        return false;
    }


    public String sizeDef() {
        if (this.getBitSize() > 1) {
            int size = this.getBitSize() - 1;
            return "[" + size + ":0] ";
        }

        return "";
    }

}
