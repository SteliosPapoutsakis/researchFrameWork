package Framework;/*
This class is used to describe a Adder in verilog
This class takes the info and prints the appropriate
verilog code

@author Stelios Papoutsakis

 */

public class Adder extends VerilogComp {

    private VerilogComp[] inputs = new VerilogComp[2]; // adder has two inputs that add

    // constructor
    public Adder(String name, int size)
    {
        super(name,size,false,false);
    }
    /*

    Overriden methods which write verilog code
     */
    @Override
    public String defineWire(){
        return "wire " + sizeDef() + this.getName() +"_sum;\n";
    }

    @Override
    public String defineComp()
    {
        return "full_Adder #(.SIZE(" + this.getBitSize() + "))" + " " + this.getName() + "(," + this.getName() +"_sum," + this.inputs[0].getName() + ", "
                + this.inputs[1].getName() + ");\n";

    }

    // adds inputs to the adder
    public void addInput(VerilogComp comp, int index)
    {
        if(Math.abs(index) > 1) System.out.println("Error index too high");
        this.inputs[index] = comp;
    }

    public VerilogComp[] getInputs() {
        return inputs;
    }


    public String sizeDef() {
        if (this.getBitSize() > 1) {
            int size = this.getBitSize() - 1;
            return "[" + size + ":0] ";
        }

        return "";
    }


    //Testing
    /*public static void main(String[] args) {
        Adder add = new Adder("addy",8);
        add.addInput(new Register("a",8,false,false),0);
        add.addInput(new Register("a",8,false,false),1);
        String str = add.defineWire() + "\n" + add.defineComp();
        System.out.println(str);

    }*/


}
