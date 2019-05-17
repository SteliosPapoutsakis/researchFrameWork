package Framework;

import java.util.ArrayList;
import java.util.HashMap;

public class State {
    private HashMap<Var, Integer> assignments; // variable assignments
    private HashMap<Var, Integer> conditionsTrue; // conditions which are needed for the flag to be true
    private HashMap<Var, Integer> conditionsFalse; // conditions which the flag is false
    private HashMap<Mux, ArrayList<VerilogComp>> select; //maps mux to its inputs
    private int selectSize; // select bit size
    private int stateSize; // state biit size
    private ArrayList<Var> conditionsorderl;


    private String stateNumberBinary; // state in binary
    private int stateNumber; // state in decimal

    public State(int stateNumber, HashMap<Var, Integer> assignments, HashMap<Var, Integer> conditionsTrue, HashMap<Var, Integer> conditionsFalse,
                 ArrayList<Var> conditionsorder) {
        this.assignments = assignments;
        this.conditionsTrue = conditionsTrue;
        this.conditionsFalse = conditionsFalse;
        this.stateNumberBinary = null;
        this.stateNumber = stateNumber;
        this.conditionsorderl = conditionsorder;
    }


    public String defState() {
        StringBuilder str = new StringBuilder("\t\t\t" + this.stateNumberBinary + ": begin \n");
        //first go through true conditions
        HashMap<Integer,String> conditionals = new HashMap<>();
        ArrayList<Integer> conditionNextState= new ArrayList<>();
        boolean needTemp=false;
        String temp = "\t\t\t\telse\n\t\t\t\t\tnext_state <= ";
        for (Var var : this.conditionsorderl) {
            if(var.getName().equals("NO_CONDITIONS")) {
                needTemp=true;
                temp+=IntToBinary.printToBinary(this.conditionsTrue.get(var)) + ";";
                continue;
            }
            if(conditionsTrue.containsKey(var)&&!conditionals.containsKey(this.conditionsTrue.get(var)))
            {
                conditionals.put(this.conditionsTrue.get(var),"If(" + var.getName());
                conditionNextState.add(this.conditionsTrue.get(var));
            }
            else if(conditionsTrue.containsKey(var))
            {
                conditionals.put(this.conditionsTrue.get(var),conditionals.get(this.conditionsTrue.get(var))
                        +" && " +var.getName());
            }
        }
        // then go through false conditions
        for (Var var : this.conditionsorderl) {

            if(conditionsFalse.containsKey(var)&&!conditionals.containsKey(this.conditionsFalse.get(var)))
            {
                conditionals.put(this.conditionsFalse.get(var),"If(!" + var.getName());
                conditionNextState.add(this.conditionsFalse.get(var));
            }
            else if(conditionsFalse.containsKey(var))
            {
                conditionals.put(this.conditionsFalse.get(var),conditionals.get(this.conditionsFalse.get(var))
                        +" && !" +var.getName());
            }
        }


        //puting all the branching statments now
        for(Integer i:conditionNextState)
        {
                str.append("\t\t\t\t" + conditionals.get(i) + ")\n");
                str.append("\t\t\t\t\t" + "next_state <= " + IntToBinary.printToBinary(i,stateSize) + ";\n");


        }
        if(needTemp)
        str.append(temp+"\n");





        // go through variable assignments
        for (Var var : this.assignments.keySet())
            str.append(defAssignemts(var, this.assignments.get(var)));

        // define Mux select
        str.append(defMuxSelect(this.selectSize));


        return str.toString();

    }




    public String defAssignemts(Var var, int number) {
        return "\t\t\t\t" + var.getName() + var.sizeDef() + " <= " + IntToBinary.printToBinary(number) + ";\n";

    }

    public String defMuxSelect(int size) {

        StringBuilder str = new StringBuilder();
        for (Mux mux : this.select.keySet()) {
            for (int i = 0; i < mux.getInputs().length; i++) { //getInputs gets the array of mux inputs
                // if the mux input index matches the supposed assignment for the state
                System.out.println(mux.getName());
                if (mux.getInputs()[i].getName().equals(this.select.get(mux).get(this.stateNumber).getName())) {
                    str.append(IntToBinary.strickBinary(i, mux.getSelectionSize()));
                    break;
                }
            }
        }

        String temp = "SelectionBits";
        if (size > 1) {
            size--;
            temp += "[" + size + ":0]";
        }

        return "\t\t\t\t" + temp + " <= " + str.length() + "'b" + str.toString() + ";";

    }


    public String getStateNumber() {
        return stateNumberBinary;
    }

    public void setSelect(HashMap<Mux, ArrayList<VerilogComp>> select, int size) {

        this.select = select;
        this.selectSize = size;
    }

    public void setbinarystatenumber(int sizeOfAllStates) {
        this.stateNumberBinary = IntToBinary.printToBinary(this.stateNumber, sizeOfAllStates);
        this.stateSize = sizeOfAllStates;
    }

//    public static void main(String[] args) {
//        HashMap<Var, String> assignments = new HashMap<>();
////        Var var = new Var("busy", 1, false, false, false, false, false);
////        Var var2 = new Var("busy", 1, false, false, false, false, false);
////        Var var3 = new Var("busy", 3, false, false, false, false, false);
//
//        assignments.put(var, new FixedNumber(0, var.getBitSize()).getName());
//        assignments.put(var2, new FixedNumber(1, var2.getBitSize()).getName());
//        assignments.put(var3, new FixedNumber(3, var3.getBitSize()).getName());
//
//        HashMap<Var, String> conditionsTrue = new HashMap<>();
//        Var var4 = new Var("flag", 1, false, true, false, false, false);
//        conditionsTrue.put(var4, new FixedNumber(3, 4).getName());
//
//       // State state = new State(new FixedNumber(1, 1).getName(), assignments, conditionsTrue);
//
//
//        HashMap<Mux, VerilogComp> select = new HashMap<>();
//        Mux mux1 = new Mux(4, 4, new Register("sas", 4, false, false));
//        mux1.addInput(new FixedNumber(3, 2), 0);
//        mux1.addInput(new FixedNumber(2, 2), 1);
//
//        select.put(mux1,mux1.getInputs()[1]);
//
//      //  state.setSelect(select);
//        //System.out.println(state.defMuxSelect(2));


}



