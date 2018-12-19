package Framework;/*
This class is used to describe a variable in verilog
This class takes the info and prints the appropriate
verilog code

@author Stelios Papoutsakis
*/

import java.util.ArrayList;

public class Var extends VerilogComp {
    private boolean isSelectSignal; // if it is a select signal for Muxes


    public Var(String name, int bitSize, boolean isInput, boolean isOutput, boolean isSelectSignal) {
        super(name, bitSize, isInput, isOutput);
        this.isSelectSignal = isSelectSignal;
    }

    /*
Overriden methods which write verilog code
 */

    @Override
    public String defineInput() {

        int bit = this.getBitSize() - 1;
        String str = "input ";
        if (this.getBitSize() > 1)
            str += "[" + bit + ":0] ";
        return str += this.getName() + ";\n";

    }

    @Override
    public String defineOutput() {

        String reg = " ";
        if (this.isSelectSignal || !(getName().length() > 4 && getName().substring(0, 4).equals("flag")))
            reg = " reg ";
        int bit = this.getBitSize() - 1;
        String str = "output" + reg;
        if (this.getBitSize() > 1)
            str += "[" + bit + ":0] ";
        return str += this.getName() + ";\n";

    }


    // if it is a select signal break up the var into Mux_select signals
    public String defineAssign(ArrayList<Mux> comp) {
        if (this.isSelectSignal) {
            String str = "";
            int allSelect = 0;
            for (Mux mux : comp)
                allSelect += mux.getSelectionSize();
            allSelect--;
            int start = 0;
            int end = allSelect;
            for (Mux mux : comp) {
                start = end - (mux.getSelectionSize() - 1);
                int size = mux.getSelectionSize() - 1;
                String temp = "";
                String temp2 = "";
                if (size > 0) {
                    temp = "[" + size + ":0]";
                }
                if (comp.size() > 1)
                    temp2 = "[" + start + "]";
                if (start != end)
                    temp2 = "[" + end + ":" + start + "]";

                str += "assign " + mux.getName() + "_Select" + temp +
                        " = " + this.getName() + temp2 + ";";
                str += "\n";
                end = end - mux.getSelectionSize();
            }


            return str;
        }
        return "";
    }

    public boolean isSelectSignal() {
        return isSelectSignal;
    }


    public String sizeDef() {
        if (this.getBitSize() > 1) {
            int size = this.getBitSize() - 1;
            return "[" + size + ":0] ";
        }

        return "";
    }


}
