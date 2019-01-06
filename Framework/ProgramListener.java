package Framework;/*
this class is the Listener that goes through the parser tree and takes out all the relivent info,
with that info it hands off the data to other classes and then prints that info to a ".v" file at the end

@author Stelios Papoutsakis
 */

//import jdk.nashorn.internal.parser.DateParser;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class ProgramListener extends FSMBaseListener {

    private String programName; // name of file
    private ArrayList<VerilogComp> comps = new ArrayList<>(); // List of all Verilog comps
    private ArrayList<HashMap<Var, Integer>> conditions = new ArrayList<>(); // arraylist of conditions hashmaps, hashmap 0 corresponds with true conditions
    private ArrayList<State> states = new ArrayList<>(); // List of states
    private HashMap<Register, ArrayList<VerilogComp>> regInputs = new HashMap<>(); // map of register and its respective inputs
    private HashMap<Var, Integer> assignments = new HashMap<>(); // map of variables and their respective int assignments
    private HashMap<String, Var[]> compInputs = new HashMap<>(); // comparator inputs mapped with their corresponding flag[]
    private ArrayList<Var> conditionsOrder = new ArrayList<>();
    //ctor
    public ProgramListener(String fileName) {
        this.programName = fileName;
        this.conditions.add(new HashMap<>());
        this.conditions.add(new HashMap<>());
    }


    @Override
    public void exitState(FSMParser.StateContext ctx) {
        // for every variable that has an assigmnet in this state
        for (int i = 0; i < ctx.var_assign().size(); i++) {

            //find the variable
            FSMParser.Var_assignContext varAssign = ctx.var_assign(i);
            Var var = (Var) findComp(varAssign.var().NAME().getText());

            //find the int value that it is assigned to
            int num = Integer.parseInt(varAssign.var_assigment().integer().getText());
            this.assignments.put(var, num);
            //add that variable value pair to assignments hashmap
        }

        //find the statenumber and make the new state
        String temp = ctx.STATENUMBER().getText();
        int temp2 = Integer.parseInt(temp.substring(6, temp.length())); //starts at 6 to ignore 'State:'
        State state = new State(temp2, new HashMap<>(this.assignments), new HashMap<>(this.conditions.get(0))
                , new HashMap<>(this.conditions.get(1)),new ArrayList<>(this.conditionsOrder));
        this.states.add(state);
        //clear maps for new state
        this.assignments.clear();
        this.conditionsOrder.clear();
        this.conditions.get(0).clear();
        this.conditions.get(1).clear();


    }


    @Override
    public void enterInputs(FSMParser.InputsContext ctx) {
        // for every integer context in the input rule...
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof FSMParser.RegisterContext) {

                // if defining a new register
                FSMParser.RegisterContext regcont = (FSMParser.RegisterContext) ctx.getChild(i);
                Register reg = new Register(regcont.NAME().getText(), Integer.parseInt(regcont.getChild(1).getText()),
                        true, false); //getChild(i-1) because size is always defined before the register

                this.comps.add(reg);
                this.regInputs.put(reg, new ArrayList<>());

                //if defining a new Variable
            } else if (ctx.getChild(i) instanceof FSMParser.VarContext) {
                FSMParser.VarContext varCont = (FSMParser.VarContext) ctx.getChild(i);

                // if this varaible is a clock (labled with C_)
                if (varCont.Clk() != null) {
                    Var var = new Var(varCont.NAME().getText(), Integer.parseInt(varCont.getChild(1).getText()), true,
                            false, false);
                    VerilogComp.setClkName(var.getName());


                    // if this varible is a reset(labled with R_)
                } else if (varCont.RESET() != null) {
                    Var var = new Var(varCont.NAME().getText(), Integer.parseInt(varCont.getChild(1).getText()), true,
                            false, false);
                    VerilogComp.setResetName(var.getName());

                }
                // else just a standard variable
                else {
                    Var var = new Var(varCont.NAME().getText(), Integer.parseInt(varCont.getChild(1).getText()), true,
                            false, false);
                    this.comps.add(var);

                }
            }

        }


    }

    @Override
    public void enterOutputs(FSMParser.OutputsContext ctx) {
        //for every varible label as an output
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof FSMParser.RegisterContext) {

                //find it regesitor
                FSMParser.RegisterContext regcont = (FSMParser.RegisterContext) ctx.getChild(i);
                Register reg = new Register(regcont.NAME().getText(), Integer.parseInt(regcont.getChild(1).getText()),
                        false, true);
                this.comps.add(reg);
                this.regInputs.put(reg, new ArrayList<>());

// if else variable
            } else if (ctx.getChild(i) instanceof FSMParser.VarContext) {
                FSMParser.VarContext varCont = (FSMParser.VarContext) ctx.getChild(i);
                Var var = new Var(varCont.NAME().getText(), Integer.parseInt(varCont.getChild(1).getText()), false,
                        true, false);
                this.comps.add(var);
            }

        }


    }

    @Override
    public void enterRegister_assign(FSMParser.Register_assignContext ctx) {
        // if the register doesn't exist, make a new one
        if (findComp(ctx.register().NAME().getText()) == null) {
            Register temp = new Register(ctx.register().NAME().getText(),
                    Integer.parseInt(ctx.register().INT().getText())
                    , false, false);
            this.comps.add(temp);
            this.regInputs.put(temp, new ArrayList<>());

        }
    }

    @Override
    public void enterVar_assign(FSMParser.Var_assignContext ctx) {
        //if variable doesn't exist, make it
        if (findComp(ctx.var().NAME().getText()) == null) {
            Var temp = new Var(
                    ctx.var().NAME().getText(),
                    Integer.parseInt(ctx.var().INT().getText()),
                    false, false, false);
            this.comps.add(temp);

        }
    }

    @Override
    public void enterVar_assigment(FSMParser.Var_assigmentContext ctx) {
        // this nodes parent was an instance of var_Assign
        if (ctx.getParent() instanceof FSMParser.Var_assignContext) {
            //find the variable and add it to the assignments map
            FSMParser.Var_assignContext varCont = (FSMParser.Var_assignContext) ctx.getParent();
            Var var = (Var) findComp(varCont.var().NAME().getText());
            this.assignments.put(var, Integer.parseInt(ctx.integer().getText()));


        }
    }

    @Override
    public void enterAdder_assign(FSMParser.Adder_assignContext ctx) {
        Register reg;
        // if this is coming from a Register_Assign context
        if (ctx.getParent() instanceof FSMParser.Register_assignContext) {


            FSMParser.Register_assignContext regCont = (FSMParser.Register_assignContext) ctx.getParent();
            reg = (Register) findComp(regCont.register().NAME().getText());


            Adder newAdder = null;
            int j = 1;

            // giving it a unique name
            for (int i = 0; i < regCont.getChildCount(); i++) {
                if (findComp("Adder_" + j + reg.getName()) == null) {
                    newAdder = new Adder("Adder_" + j + reg.getName(), reg.getBitSize());
                    this.comps.add(newAdder);
                    this.regInputs.get(reg).add(newAdder);
                    break;
                }
                j++;
            }


            // finding 1st input for adder
            if (ctx.expression(0).register() != null)
                newAdder.addInput(findComp(ctx.expression(0).register().NAME().getText()), 0);
            else if (ctx.expression(0).integer() != null)
                newAdder.addInput(new FixedNumber(Integer.parseInt(ctx.expression(0).integer().getText()), reg.getBitSize()), 0);
            else if (ctx.expression(0).var() != null)
                newAdder.addInput(findComp(ctx.expression(0).var().getText()), 0);

            //finding second input for adder
            if (ctx.expression(1).register() != null)
                newAdder.addInput(findComp(ctx.expression(1).register().NAME().getText()), 1);
            else if (ctx.expression(1).integer() != null)
                newAdder.addInput(new FixedNumber(Integer.parseInt(ctx.expression(1).integer().getText()), reg.getBitSize()), 1);
            else if (ctx.expression(1).var() != null)
                newAdder.addInput(findComp(ctx.expression(1).var().getText()), 1);


        }

    }


    @Override
    public void enterMult_assigment(FSMParser.Mult_assigmentContext ctx) {
        Register reg;
        // if this is coming from a Register_Assign context
        if (ctx.getParent() instanceof FSMParser.Register_assignContext) {


            FSMParser.Register_assignContext regCont = (FSMParser.Register_assignContext) ctx.getParent();
            reg = (Register) findComp(regCont.register().NAME().getText());


            Multiplier mult = null;
            int j = 1;

            // giving it a unique name
            for (int i = 0; i < regCont.getChildCount(); i++) {
                if (findComp("Mult_" + j + reg.getName()) == null) {
                    mult = new Multiplier("Mult_" + j + reg.getName(), reg.getBitSize());
                    this.comps.add(mult);
                    this.regInputs.get(reg).add(mult);
                    break;
                }
                j++;
            }

            // finding 1st input for adder
            if (ctx.expression(0).register() != null)
                mult.addInput(findComp(ctx.expression(0).register().NAME().getText()), 0);
            else if (ctx.expression(0).integer() != null)
                mult.addInput(new FixedNumber(Integer.parseInt(ctx.expression(0).integer().getText()), reg.getBitSize()), 0);
            else if (ctx.expression(0).var() != null)
                mult.addInput(findComp(ctx.expression(0).var().getText()), 0);

            //finding second input for adder
            if (ctx.expression(1).register() != null)
                mult.addInput(findComp(ctx.expression(1).register().NAME().getText()), 1);
            else if (ctx.expression(1).integer() != null)
                mult.addInput(new FixedNumber(Integer.parseInt(ctx.expression(1).integer().getText()), reg.getBitSize()), 1);
            else if (ctx.expression(1).var() != null)
                mult.addInput(findComp(ctx.expression(1).var().getText()), 1);


        }

    }

    @Override
    public void enterDiv_assigment(FSMParser.Div_assigmentContext ctx) {
        Register reg;
        // if this is coming from a Register_Assign context
        if (ctx.getParent() instanceof FSMParser.Register_assignContext) {


            FSMParser.Register_assignContext regCont = (FSMParser.Register_assignContext) ctx.getParent();
            reg = (Register) findComp(regCont.register().NAME().getText());


            Divider div = null;
            int j = 1;

            // giving it a unique name
            for (int i = 0; i < regCont.getChildCount(); i++) {
                if (findComp("Div_" + j + reg.getName()) == null) {
                    div = new Divider("Div_" + j + reg.getName(), reg.getBitSize());
                    this.comps.add(div);
                    this.regInputs.get(reg).add(div);
                    break;
                }
                j++;
            }

            // finding 1st input for adder
            if (ctx.expression(0).register() != null)
                div.addInput(findComp(ctx.expression(0).register().NAME().getText()), 0);
            else if (ctx.expression(0).integer() != null)
                div.addInput(new FixedNumber(Integer.parseInt(ctx.expression(0).integer().getText()), reg.getBitSize()), 0);
            else if (ctx.expression(0).var() != null)
                div.addInput(findComp(ctx.expression(0).var().getText()), 0);

            //finding second input for adder
            if (ctx.expression(1).register() != null)
                div.addInput(findComp(ctx.expression(1).register().NAME().getText()), 1);
            else if (ctx.expression(1).integer() != null)
                div.addInput(new FixedNumber(Integer.parseInt(ctx.expression(1).integer().getText()), reg.getBitSize()), 1);
            else if (ctx.expression(1).var() != null)
                div.addInput(findComp(ctx.expression(1).var().getText()), 1);


        }
    }

    @Override
    public void enterSub_assignment(FSMParser.Sub_assignmentContext ctx) {

        Register reg;
        // if this is coming from a Register_Assign context
        if (ctx.getParent() instanceof FSMParser.Register_assignContext) {


            FSMParser.Register_assignContext regCont = (FSMParser.Register_assignContext) ctx.getParent();
            reg = (Register) findComp(regCont.register().NAME().getText());


            Subtractor newSub = null;
            int j = 1;

            // giving it a unique name
            for (int i = 0; i < regCont.getChildCount(); i++) {
                if (findComp("Sub_" + j + reg.getName()) == null) {
                    newSub = new Subtractor("Sub_" + j + reg.getName(), reg.getBitSize());
                    this.comps.add(newSub);
                    this.regInputs.get(reg).add(newSub);
                    break;
                }
                j++;
            }



            // finding 1st input for adder
            if (ctx.expression(0).register() != null)
                newSub.addInput(findComp(ctx.expression(0).register().NAME().getText()), 0);
            else if (ctx.expression(0).integer() != null)
                newSub.addInput(new FixedNumber(Integer.parseInt(ctx.expression(0).integer().getText()), reg.getBitSize()), 0);
            else if (ctx.expression(0).var() != null)
                newSub.addInput(findComp(ctx.expression(0).var().getText()), 0);

            //finding second input for adder
            if (ctx.expression(1).register() != null)
                newSub.addInput(findComp(ctx.expression(1).register().NAME().getText()), 1);
            else if (ctx.expression(1).integer() != null)
                newSub.addInput(new FixedNumber(Integer.parseInt(ctx.expression(1).integer().getText()), reg.getBitSize()), 1);
            else if (ctx.expression(1).var() != null)
                newSub.addInput(findComp(ctx.expression(1).var().getText()), 1);


        }

    }


    @Override
    public void enterReg_assigment(FSMParser.Reg_assigmentContext ctx) {

        //if nodes parent was a register_assign node
        if (ctx.getParent() instanceof FSMParser.Register_assignContext) {
            FSMParser.Register_assignContext regCont = (FSMParser.Register_assignContext) ctx.getParent();
            Register reg = (Register) findComp(regCont.register().NAME().getText());
            //if register, assign register
            if (ctx.expression().register() != null) {
                this.regInputs.get(reg).add(findComp(ctx.expression().register().NAME().getText()));
            } else if (ctx.expression().integer() != null) {
                //if int assign an int
                this.regInputs.get(reg).add(new FixedNumber(Integer.parseInt(
                        ctx.expression().integer().getText()), reg.getBitSize()));

// if assigned var, assign var
            } else if (ctx.expression().var() != null) {
                this.regInputs.get(reg).add(findComp(ctx.expression().var().NAME().getText()));

                }

        }
    }

    @Override
    public void enterAnd_assigment(FSMParser.And_assigmentContext ctx) {
        Register reg;
        // if this is coming from a Register_Assign context
        if (ctx.getParent() instanceof FSMParser.Register_assignContext) {


            FSMParser.Register_assignContext regCont = (FSMParser.Register_assignContext) ctx.getParent();
            reg = (Register) findComp(regCont.register().NAME().getText());


            And newand = null;
            int j = 1;

            // giving it a unique name
            for (int i = 0; i < regCont.getChildCount(); i++) {
                if (findComp("Sub_" + j + reg.getName()) == null) {
                    newand = new And("And_" + j + reg.getName(), reg.getBitSize());
                    this.comps.add(newand);
                    this.regInputs.get(reg).add(newand);
                    break;
                }
                j++;
            }



            // finding 1st input for adder
            if (ctx.expression(0).register() != null)
                newand.addInput(findComp(ctx.expression(0).register().NAME().getText()), 0);
            else if (ctx.expression(0).integer() != null)
                newand.addInput(new FixedNumber(Integer.parseInt(ctx.expression(0).integer().getText()), reg.getBitSize()), 0);
            else if (ctx.expression(0).var() != null)
                newand.addInput(findComp(ctx.expression(0).var().getText()), 0);

            //finding second input for adder
            if (ctx.expression(1).register() != null)
                newand.addInput(findComp(ctx.expression(1).register().NAME().getText()), 1);
            else if (ctx.expression(1).integer() != null)
                newand.addInput(new FixedNumber(Integer.parseInt(ctx.expression(1).integer().getText()), reg.getBitSize()), 1);
            else if (ctx.expression(1).var() != null)
                newand.addInput(findComp(ctx.expression(1).var().getText()), 1);


        }

    }


    @Override
    public void enterCondition(FSMParser.ConditionContext ctx) {
        //if one of the flags is based on a input
        if (ctx.var() != null && ((Var) findComp(ctx.var().NAME().getText())).isInput() &&
                ((Var) findComp(ctx.var().NAME().getText())).getBitSize() < 2) {
            Var inputflag = (Var) findComp(ctx.var().NAME().getText());
            FSMParser.Next_stateContext context = (FSMParser.Next_stateContext) ctx.getParent();
            int nextState = Integer.parseInt(
                    context.STATENUMBER().getText().substring(6, context.STATENUMBER().getText().length()));

            //checking to see if true or false
            if (Integer.parseInt(ctx.expression().integer().opp.getText()) == 1) {
                this.conditions.get(0).put(inputflag, nextState);
                this.conditionsOrder.add(inputflag);
            } else if (Integer.parseInt(ctx.expression().integer().opp.getText()) == 0) {
                this.conditions.get(1).put(inputflag, nextState);
                this.conditionsOrder.add(inputflag);
            }
            return;

        }
        //finding the 2 components that are compaired
        VerilogComp compare1 = null;
        VerilogComp compare2 = null;
        if (ctx.register() != null) {
            compare1 = findComp(ctx.register().NAME().getText());

        } else {
            compare1 = findComp(ctx.var().NAME().getText());
        }

        if (ctx.expression().var() != null) {
            compare2 = findComp(ctx.expression().var().NAME().getText());
        } else if (ctx.expression().integer() != null) {
            int temp = Integer.parseInt(ctx.expression().integer().getText());
            FixedNumber tempfixed = new FixedNumber(temp, compare1.getBitSize());
            compare2 = tempfixed;
            this.comps.add(tempfixed);

        } else {
            compare2 = findComp(ctx.expression().register().NAME().getText());
        }

        String text = compare1.getName().substring(0, 1) + compare2.getName().substring(0, 1) + ctx.opp.getType();
        FSMParser.Next_stateContext context = (FSMParser.Next_stateContext) ctx.getParent();
        int nextState = Integer.parseInt(
                context.STATENUMBER().getText().substring(6, context.STATENUMBER().getText().length()));
        //if there is no flag for this condition, make a variable and give it to conditionsTrue map
        if (findComp("flag_" + text) == null) {

            if (ctx.opp.getType() == 17) {
                text = text.substring(0, text.length() - 2) + "14";
                if (findComp("flag_" + text) != null) {
                    this.conditions.get(1).put((Var) findComp("flag_" + text), nextState);
                    this.conditionsOrder.add((Var)findComp("flag_" + text));
                    return;
                }
            }
            Var output = new Var("flag_" + text,
                    1, false, true, false);
            if (!(this.compInputs.containsKey(compare1.getName() + "|" + compare2.getName()))) {
                this.compInputs.put(compare1.getName() + "|" + compare2.getName(), new Var[3]);
            }

            Var[] flags = this.compInputs.get(compare1.getName() + "|" + compare2.getName());


            // finding the type of condition based on token Num
            if (ctx.opp.getType() == 14 || ctx.opp.getType() == 17) {
                flags[1] = output;
                if (ctx.opp.getType() == 14) {
                    this.conditions.get(0).put(output, nextState);
                    this.conditionsOrder.add(output);
                }
                else {
                    this.conditions.get(1).put(output, nextState);
                    this.conditionsOrder.add(output);
                }
            } else if (ctx.opp.getType() == 15) {
                flags[2] = output;
                this.conditions.get(0).put(output, nextState);
                this.conditionsOrder.add(output);

            } else if (ctx.opp.getType() == 16) {
                flags[0] = output;
                this.conditions.get(0).put(output, nextState);
                this.conditionsOrder.add(output);
            }
            this.comps.add(output);


            //if equals flag exists but creating a not equals flag
        } else if (!this.conditions.get(0).containsKey(findComp("flag_" + text)) && ctx.opp.getType() == 17) {
            this.conditions.get(1).put((Var) findComp("flag_" + text), nextState);
            this.conditionsOrder.add((Var)findComp("flag_" + text));
        }

        else {
            Var output = (Var) findComp("flag_" + text);
            if (ctx.opp.getType() ==17) {
                this.conditions.get(1).put(output, nextState);
                this.conditionsOrder.add(output);
            }
            else if (ctx.opp.getType() == 14 || ctx.opp.getType() == 15
                    || ctx.opp.getType() == 16) {
                this.conditions.get(0).put(output, nextState);
                this.conditionsOrder.add(output);
            }
        }

    }


    @Override
    public void exitNext_state(FSMParser.Next_stateContext ctx) {
        // if no conditionsTrue, make a dummy variable with the next state number;
        if (ctx.condition() == null) {
            Var var = new Var("NO_CONDITIONS", 1, false, false, false);
            this.conditions.get(0).put(var, Integer.parseInt(ctx.STATENUMBER().getText().substring(6, ctx.STATENUMBER().getText().length())));
            this.conditionsOrder.add(var);
        }
    }

    @Override
    public void exitFsm(FSMParser.FsmContext ctx) {
        HashMap<Mux, ArrayList<VerilogComp>> muxIn = new HashMap<>(); //hashmap linking every mux to an array of its inputs
        ArrayList<ArrayList<StringBuilder>> string = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            string.add(new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                string.get(i).add(new StringBuilder());
            }
        }
        // creating comparitors
        for (String str : this.compInputs.keySet()) {
            VerilogComp comp1 = findComp(str.substring(0, str.indexOf('|')));
            VerilogComp comp2 = findComp(str.substring(str.indexOf('|') + 1, str.length()));
            this.comps.add(new Comp(this.compInputs.get(str), comp1, comp2));

        }
        for (VerilogComp comp : this.comps) {
            // for every component thats a register, make a mux for it
            if (comp instanceof Register) {
                Register reg = (Register) comp;
                ArrayList<VerilogComp> inputs = this.regInputs.get(reg);
                //find the size of the mux
                int size = getMuxSize(inputs);
                Mux mux = new Mux(size, reg.getBitSize(), reg);
                int i = 0;
                int index = 0;
                // add the inputs to each mux from the register
                for (VerilogComp comp2 : inputs) {
                    boolean b = mux.addInput(comp2, index);
                    if (b)
                        index++;
                }

                muxIn.put(mux, inputs);


            }
        }
        int size = 0;
// find the total size of all the selections bit
        for (Mux mux : muxIn.keySet()) {
            this.comps.add(mux);
            size += mux.getSelectionSize();
        }
        Var var = new Var("SelectionBits", size, true, false, true);
        this.comps.add(var);


// for every state add the size and muxIn
        for (State state : this.states) {
            state.setSelect(muxIn, size);
        }
        ArrayList<Mux> muxes = new ArrayList<>();
        for (Mux mux : muxIn.keySet())
            muxes.add(mux);
        //creating new directory to put files in
        try {
            if (Files.notExists(Paths.get("./" + this.programName + "_Generate")))
                Files.createDirectory(Paths.get("./" + this.programName + "_Generate"));
        } catch (java.io.IOException e) {
            System.out.println("problem creating directory");
        }

        string.get(0).get(6).append(var.defineAssign(muxes) + "\n");
        for (VerilogComp component : this.comps) {
            displayFiles(component, string);
        }
        printAll(string);


        // making the full module


    }

    /*
    FIND BETTER ALGORITHM FOR THISSSS
    @purpose to find the size of a certin mux based on inputs
    @return size
     */
    public int getMuxSize(ArrayList<VerilogComp> inputs) {
        int count = 0;
        for (int i = 0; i < inputs.size(); i++) {
            boolean isDup = false;
            for (int j = i + 1; j < inputs.size(); j++) {
                if (inputs.get(i).getName().equals(inputs.get(j).getName()))
                    isDup = true;
            }
            if (!isDup)
                count++;
        }

        int size = IntToBinary.strickBinary(count - 1).length();


        switch (size) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;

        }
        return 16;
    }

    /*
    @purpose to find a Verilog component given a name
    @return the component
     */
    public VerilogComp findComp(String name) {
        for (VerilogComp comp : this.comps) {
            if (comp.getName().equals(name))
                return comp;
        }
        return null;
    }

    public void printAll(ArrayList<ArrayList<StringBuilder>> str) {
        ArrayList<StringBuilder> dataPath = str.get(0);
        ArrayList<StringBuilder> conPath = str.get(1);
        ArrayList<StringBuilder> module = str.get(2);
        ArrayList<StringBuilder> tb = str.get(3);
        try {
            /**
             * PRINTING DATA PATH
             */
            PrintWriter data = new PrintWriter("./" + this.programName + "_Generate/" + this.programName + "_DataPath.v");
            data.print("module " + this.programName + "_DataPath(" + dataPath.get(1) + dataPath.get(0) +
                    VerilogComp.getClkName() + "," + VerilogComp.getResetName() + ");\n");
            data.print("\n\n" + dataPath.get(3).toString() + "\n\n" + dataPath.get(2).toString() + "input " + VerilogComp.getClkName()
                    + "," + VerilogComp.getResetName() + ";\n\n" +
                    dataPath.get(4).toString() + "\n\n" + dataPath.get(5).toString() + "\n\n"
                    + dataPath.get(6).toString() + "\n\n" + dataPath.get(7).toString() + "\n\n");
            data.print("endmodule");
            data.close();
            /**
             * DONE
             */

            /**
             * PRINTING CONTROLLER
             */
            PrintWriter con = new PrintWriter("./" + this.programName + "_Generate/" + this.programName + "_ConPath.v");
            con.print("module " + this.programName + "_Controller(" + conPath.get(1) + conPath.get(0) +
                    VerilogComp.getClkName() + "," + VerilogComp.getResetName() + ");\n");
            con.print("\n\n" + conPath.get(3).toString() + "\n\n" + conPath.get(2).toString() + "input clk,reset;\n");
            int size = IntToBinary.strickBinary(this.states.size() - 1).length();
            int sizeOfReg = size - 1;
            String name = "reg state, ";
            String name2 = "next_state;";
            if (size > 1) {
                name = "reg [" + sizeOfReg + ":0] state, ";

            }
            con.print(name + name2 + "\n");
            con.print("always @ (posedge " + VerilogComp.getClkName() + ", posedge " +
                    VerilogComp.getResetName() + ")\n\tbegin\nif(" + VerilogComp.getResetName() +
                    ")\n\t\tbegin\n" + conPath.get(4).toString() + "\t\t\tstate <= " + size + "'b0;" +
                    "\n\t\tend\n\telse state <= next_state;\nend\n");
            conPath.get(5).append("always @ (*)\n\tbegin\n\t\tcase(state)\n");
            for (State state : this.states) {
                state.setbinarystatenumber(size);
                conPath.get(5).append(state.defState() + "\n");
                conPath.get(5).append("\t\t\tend \n");
            }
            conPath.get(5).append("\t\tendcase\n\tend\n");
            conPath.get(5).append("endmodule");

            con.print(conPath.get(5));
            con.close();

            /**
             * DONE
             */


            /**
             * PRINTING FULL MODULE
             */

            PrintWriter full = new PrintWriter("./" + this.programName + "_Generate/" + this.programName + "_Full.v");
            full.print("module " + this.programName + "_Full(" + module.get(0) + module.get(1) + VerilogComp.getClkName() +
                    "," + VerilogComp.getResetName() + ");\n");
            full.append(module.get(3) + "\n" + module.get(2) + "input clk,reset;\n\n");
            full.append(this.programName + "_DataPath Data(" + dataPath.get(1) + dataPath.get(0) +
                    VerilogComp.getClkName() + "," + VerilogComp.getResetName() + ");\n");
            full.append(this.programName + "_Controller controller(" + conPath.get(1) + conPath.get(0) +
                    VerilogComp.getClkName() + "," + VerilogComp.getResetName() + ");\n");
            full.append("\n" + "endmodule");
            full.close();

            /**
             * DONE
             */

            /**
             * Displaying Test Bench
             */

            PrintWriter bench = new PrintWriter("./" + this.programName + "_Generate/" + this.programName + "tb.v");
            bench.print("`timescale 1ns / 1ns\n");
            bench.print("module " + this.programName + "_tb;\n");
            bench.print(tb.get(0) + "reg clk,reset;\n" + tb.get(1) + "\n");
            bench.print(this.programName + "_Full Fullmodule(" + module.get(0) + module.get(1) + VerilogComp.getClkName() +
                    "," + VerilogComp.getResetName() + ");\n");
            bench.print("\ninitial begin\n" +
                    "\tclk = 0;\n" +
                    "\tforever #10 clk = !clk;\n" +
                    "end\n");

            bench.print("initial begin\n" +
                    "\t$dumpfile(" + '"' + this.programName + "_tb.vcd" + '"' + ");\n" +
                    "\t$dumpvars(0," + this.programName + "_tb);\n" +
                    "end\n");

            bench.print("initial begin\n" +
                    "reset = 1;\n" +
                    "//PUT TESTING CODE HERE" +
                    "\n#500\n" +
                    "\n" +
                    "$finish;\n" +
                    "end");

            bench.print("\ninitial begin\n" +
                    "\t$display(\"" + tb.get(2) + "clk           reset" + '"' + ");\n" +
                    "\t$monitor($stime,,,," + tb.get(3) + "clk,,,,,,,,,,reset);\n" +
                    "end\n" +
                    "endmodule");
            bench.close();

            /**
             * DONE
             */

            /**
             * Displaying rest of Files
             */

            PrintWriter adder = new PrintWriter("./" + this.programName + "_Generate/" + "Arithmetic.v");
            adder.println("module full_Adder(Cout, sum, a, b);");
            adder.println("parameter SIZE = 8;");
            adder.println("output reg [SIZE-1:0] sum, Cout;");
            adder.println("input [SIZE-1:0] a,b;");
            adder.println("always @ (*) begin");
            adder.println("sum <= a + b;");
            adder.println("Cout <= 0;");
            adder.println("end");
            adder.println("endmodule\n");
            adder.print("module full_Sub(diff,a,b);\n" +
                    "parameter SIZE = 8;\n" +
                    "output reg [SIZE-1:0] diff;\n" +
                    "input [SIZE-1:0] a,b;\n" +
                    "always @ (*) begin\n" +
                    "diff <= a - b;\n" +
                    "end\n" +
                    "endmodule\n");
            adder.print("module full_Mult(product,a,b);\n" +
                    "parameter SIZE = 8;\n" +
                    "output reg [SIZE-1:0] product;\n" +
                    "input [SIZE-1:0] a,b;\n" +
                    "always @ (*) begin\n" +
                    "product <= a * b;\n" +
                    "end\n" +
                    "endmodule\n");
            adder.print("module full_Div(quotient,a,b);\n" +
                    "parameter SIZE = 8;\n" +
                    "output reg [SIZE-1:0] quotient;\n" +
                    "input [SIZE-1:0] a,b;\n" +
                    "always @ (*) begin\n" +
                    "quotient <= a / b;\n" +
                    "end\n" +
                    "endmodule");

            adder.print("module And(c,a,b);\n" +
                    "parameter SIZE = 8;\n" +
                    "output reg [SIZE-1:0] c;\n" +
                    "input [SIZE-1:0] a,b;\n" +
                    "always @ (*) begin\n" +
                    "c <= a & b;\n" +
                    "end\n" +
                    "endmodule");

            adder.close();

            PrintWriter file = new PrintWriter("./" + this.programName + "_Generate/" + "DFF.v");
            file.println("module DFFR(output reg [SIZEFF-1:0] q, input [SIZEFF-1:0] d, input clk , input rst" +
                    ",input [SIZEFF-1:0] rst_next);");
            file.println("parameter SIZEFF = 8;");
            file.println("always @(posedge clk, posedge rst)");
            file.println("begin");
            file.println("if(rst) q <= rst_next;");
            file.println("else q <= d;");
            file.println("end");
            file.println("endmodule");
            file.close();


            PrintWriter mux = new PrintWriter("./" + this.programName + "_Generate/" + "Muxes.v");
            mux.println("module Mux2(next,i0,i1,s);");
            mux.println("parameter SIZE = 8;");
            mux.println("output reg [SIZE-1:0] next;");
            mux.println("input [SIZE-1:0] i1,i0;");
            mux.println("input s;");
            mux.println("always @ (*) begin");
            mux.println("\tcase(s)");
            mux.println("\t\t1'b0: begin");
            mux.println("\t\t\tnext <= i0;\n\t\tend");
            mux.println("\t\t1'b1: begin");
            mux.println("\t\t\tnext <= i1;\n\t\tend");
            mux.println("\tendcase");
            mux.println("end\nendmodule\n");
            mux.println("module Mux4(next,i0,i1,i2,i3,s);");
            mux.println("parameter SIZE = 8;");
            mux.println("output wire [SIZE-1:0] next;");
            mux.println("input [SIZE-1:0] i3,i2,i1,i0;");
            mux.println("input [1:0] s;");
            mux.println("wire [SIZE-1:0] temp1,temp2;");
            mux.println("\tMux2 #(.SIZE(SIZE)) a(temp1,i0,i1,s[0]);");
            mux.println("\tMux2 #(.SIZE(SIZE)) b(temp2,i2,i3,s[0]);");
            mux.println("\tMux2 #(.SIZE(SIZE)) c(next,temp1,temp2,s[1]);");
            mux.println("endmodule\n");


            mux.println("module Mux8(next,i0,i1,i2,i3,i4,i5,i6,i7,s);");
            mux.println("parameter SIZE = 8;");
            mux.println("output wire [SIZE-1:0] next;");
            mux.println("input [SIZE-1:0] i7,i6,i5,i4,i3,i2,i1,i0;");
            mux.println("input [2:0] s;");
            mux.println("wire [SIZE-1:0] temp1,temp2;");
            mux.println("\tMux4 #(.SIZE(SIZE)) a(temp1,i0,i1,i2,i3,s[1:0]);");
            mux.println("\tMux4 #(.SIZE(SIZE)) b(temp2,i4,i5,i6,i7,s[1:0]);");
            mux.println("\tMux2 #(.SIZE(SIZE)) c(next,temp1,temp2,s[2]);");
            mux.println("endmodule\n");
            mux.close();


            PrintWriter comp = new PrintWriter("./" + this.programName + "_Generate/" + "Comp.v");
            comp.println("module Comp(LT,EQ,GT,a,b);");
            comp.println("parameter SIZE = 8;");
            comp.println("output reg LT,EQ,GT;");
            comp.println("input [SIZE-1:0] a,b;");
            comp.println("always @ (*) begin");
            comp.println("if(a>b) begin\n\tGT <= 1'b1;\n\tLT <= 1'b0;\n\tEQ <= 1'b0;\nend");
            comp.println("else if(a<b) begin\n\tLT <= 1'b1;\n\tGT <= 1'b0;\n\tEQ <= 1'b0;\nend");
            comp.println("else begin\n\tEQ <= 1'b1;\n\tGT <= 1'b0;\n\tLT <= 1'b0;\nend");
            comp.println("end");
            comp.println("endmodule");
            comp.close();



            /**
             * END
             */


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error writing files");
        }
    }


    /*
    One method that displays that formats all the info for verilog files
     */

    /**
     * KEY:
     * Index dataPath        conPath         module         tb
     * 0     headerout       headerout       headerout      reg
     * 1     headerin        headerin        headerin       wire
     * 2     inputs          inputs/        inputs/wire     display
     * 3     outputs         outputs          outputs       monitor
     * 4         reg          reset val        module def    -
     * 5          wire        state def        -            -
     * 6        comp def
     * 7         flipflop
     */
    public void displayFiles(VerilogComp comp, ArrayList<ArrayList<StringBuilder>> str) {
        ArrayList<StringBuilder> dataPath = str.get(0);
        ArrayList<StringBuilder> conPath = str.get(1);
        ArrayList<StringBuilder> module = str.get(2);
        ArrayList<StringBuilder> tb = str.get(3);
        if (comp instanceof Var) {
            Var var = (Var) comp;
            // if select signal
            if (var.isSelectSignal()) {
                dataPath.get(1).append(var.getName() + ",");
                conPath.get(0).append(var.getName() + ",");
                dataPath.get(2).append(var.defineInput());
                conPath.get(3).append(var.defineOutput());
                module.get(2).append("wire " + var.sizeDef() + var.getName() + ";\n");
                conPath.get(4).append("\t\t\t" + var.getName() + " <= " + var.getBitSize() + "'b0;\n");

                //if flag
            } else if (var.getName().length() > 4 && var.getName().substring(0, 4).equals("flag")) {
                dataPath.get(0).append(var.getName() + ",");
                conPath.get(1).append(var.getName() + ",");
                dataPath.get(3).append(var.defineOutput());
                conPath.get(2).append(var.defineInput());
                module.get(2).append("wire " + var.sizeDef() + var.getName() + ";\n");
            } else if (var.isInput()) {
                if (var.getBitSize() < 2) {
                    boolean isData = true;
                    for (VerilogComp comp2 : this.comps) {
                        if (comp2 instanceof Register && !this.regInputs.get(comp2).contains(var)) {
                            conPath.get(0).append(var.getName() + ",");
                            conPath.get(2).append(var.defineInput());
                            isData = false;
                        }

                    }
                    if (isData) {
                        dataPath.get(1).append((var.getName() + ","));
                        dataPath.get(2).append(var.defineInput());
                    }

                } else {
                    dataPath.get(1).append((var.getName() + ","));
                    dataPath.get(2).append(var.defineInput());
                }
                module.get(1).append(var.getName() + ",");
                module.get(2).append("input wire " + var.sizeDef() + var.getName() + ";\n");
                tb.get(0).append("reg " + var.sizeDef() + var.getName() + ";\n");
                tb.get(2).append(var.getName() + "      ");
                tb.get(3).append(var.getName() + ",,,,,,,");

            } else if (var.isOutput()) {
                conPath.get(0).append(var.getName() + ",");
                conPath.get(3).append(var.defineOutput());
                conPath.get(4).append("\t\t\t" + var.getName() + " <= " + var.getBitSize() + "'b0;\n");
                module.get(0).append(var.getName() + ",");
                module.get(3).append("output wire " + var.sizeDef() + var.getName() + ";\n");
                tb.get(1).append("wire " + var.sizeDef() + var.getName() + ";\n");
            }
        } else if (comp instanceof Register) {
            Register reg = (Register) comp;
            if (reg.isOutput()) {
                dataPath.get(0).append(reg.getName() + ",");
                dataPath.get(3).append(reg.defineOutput());
                module.get(0).append(reg.getName() + ",");
                module.get(3).append("output wire " + reg.sizeDef() + reg.getName() + ";\n");
                tb.get(1).append("wire " + reg.sizeDef() + reg.getName() + ";\n");

            }
            dataPath.get(4).append(reg.defineReg());
            dataPath.get(5).append(reg.defineWire());
            dataPath.get(7).append(reg.defineFlipFlop());

        } else if (comp instanceof Adder || comp instanceof Mux || comp instanceof Comp ||
                comp instanceof Multiplier || comp instanceof Subtractor || comp instanceof Divider || comp
                instanceof And) {
            dataPath.get(5).append(comp.defineWire());
            dataPath.get(6).append(comp.defineComp());
        }


    }


}
