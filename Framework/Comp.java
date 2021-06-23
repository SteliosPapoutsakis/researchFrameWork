package Framework;/*
This class is used to describe a comparator in verilog
This class takes the info and prints the appropriate
verilog code

@author Stelios Papoutsakis

 */


public class Comp extends VerilogComp {
    private Var[] flag; // array of flags, index:0 stands for less than, index 1 is equals to, index 2 is greator than
    private VerilogComp comp; // compare component 1
    private VerilogComp comp2; // compare component 2


    public Comp(String name, Var[] flag, VerilogComp comp, VerilogComp comp2) {
        super(name, comp.getBitSize(), false, false);
        this.flag = flag;
        this.comp = comp;
        this.comp2 = comp2;

    }

    @Override
    public String defineComp() {
        StringBuilder comp = new StringBuilder("Comp #(.SIZE(" + this.getBitSize() + ")) " + this.getName() + "(");
        for (int i = 0; i < flag.length; i++) {

            // if there are no flags, fill with empty ','
            if (this.flag[i] == null) {
                comp.append(" ,");
            } else {
                comp.append(" " + this.flag[i].getName() + ",");
            }
        }
        return comp.toString() + this.comp.getName() + ", " + this.comp2.getName() + ");\n";
    }


}
