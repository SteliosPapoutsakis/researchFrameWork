//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class FSMListenerExtend extends FSMBaseListener {
//
//    private File dataPath;
//    private File controller;
//    private ArrayList<VerilogComp> comps = new ArrayList<>();
//    private HashMap<Register,ArrayList<VerilogComp>> regInputs = new HashMap<>();
//
//
//    public FSMListenerExtend(File dataPath, File controller) {
//        this.dataPath = dataPath;
//        this.controller = controller;
//
//    }
//
//    @Override
//    public void enterRegister_assign(FSMParser.Register_assignContext ctx) {
//        if (ctx.register().NEW() != null) {
//            Register temp = new Register(ctx.register().NAME().getText(), Integer.parseInt(
//                    ctx.register().integer().INT().getText()),
//                    false, false);
//            this.comps.add(temp);
//            this.regInputs.put(temp,
//                    new ArrayList<VerilogComp>());
//        } else {
//            Register reg = (Register) findComp(ctx.register().NAME().getText());
//            if (ctx.adder_assign() != null) {
//                Adder temp = new Adder("Adder_" + reg.getName(), reg.getBitSize());
//                this.comps.add(temp);
//                this.regInputs.get(reg).add(temp);
//
//                if (ctx.adder_assign().register(0) != null) {
//                    temp.addInput(findComp(ctx.adder_assign().register(0).NAME().getText()),0);
//                    if(ctx.adder_assign().register(1) != null)
//                        temp.addInput(findComp(ctx.adder_assign().register(1).NAME().getText()),1);
//                    else {
//                        temp.addInput(new FixedNumber((Integer.parseInt
//                                (ctx.adder_assign().integer(0).getText())),reg.getBitSize()),1);
//                    }
//                }
//                else {
//                    temp.addInput(new FixedNumber((Integer.parseInt
//                            (ctx.adder_assign().integer(0).getText())),reg.getBitSize()),0);
//                    if(ctx.adder_assign().register(0) != null)
//                    {
//                        temp.addInput(findComp(ctx.adder_assign().register(0).NAME().getText()),1);
//                    }
//                    else
//                        temp.addInput(new FixedNumber((Integer.parseInt
//                                (ctx.adder_assign().integer(1).getText())),reg.getBitSize()),1);
//                }
//
//
//
//            }
//
//            if(ctx.assigment() != null)
//            {
//
//                if(ctx.assigment().register()!=null)
//                {
//                    this.regInputs.get(reg).add(findComp(ctx.assigment().register().NAME().getText()));
//                }
//                else
//                {
//                    this.regInputs.get(reg).add(new FixedNumber(Integer.parseInt(
//                        ctx.assigment().integer().getText()),reg.getBitSize()));
//                }
//
//
//
//
//            }
//        }
//    }
//
//    @Override public void exitFsm(FSMParser.FsmContext ctx) {
//        ArrayList<Mux> muxes = new ArrayList<>();
//        for(VerilogComp comp: this.comps)
//        {
//            if(comp instanceof  Register)
//            {
//                Register reg = (Register)comp;
//                ArrayList<VerilogComp> inputs = this.regInputs.get(reg);
//                int size = getMuxSize(inputs);
//                Mux mux = new Mux(size,reg.getBitSize(),reg);
//                this.comps.add(mux);
//                int i = 0;
//                for(VerilogComp comp2: inputs)
//                {
//                    mux.addInput(comp2,i);
//                    i++;
//                }
//                muxes.add(mux);
//
//            }
//        }
//
//        displayFileDataPath(muxes);
//
//    }
//
//    @Override public void enterCondition(FSMParser.ConditionContext ctx) {
//        Var output = null;
//       if(findComp("flag_" + ctx.getText()) == null) {
//           output = new Var("flag_" + ctx.getText(),
//                   1, false, true, false);
//       }
//        this.comps.add(output);
//    }
//
//
//    public VerilogComp findComp(String name) {
//        for (VerilogComp comp : this.comps) {
//            if (comp.getName().equals(name))
//                return comp;
//        }
//        return null;
//    }
//
//    public int getMuxSize(ArrayList<VerilogComp> inputs)
//    {
//        int count = 0;
//        int countPower2 = 1;
//        for(VerilogComp comp: inputs)
//        {
//            count++;
//            if(Math.pow(count,(double)(1/countPower2)) == 2)
//                countPower2*=2;
//        }
//        return countPower2;
//    }
//
//
//    // method that takes the ArrayList of Verilog comps and muxes and prints every line ot in order
//    public void displayFileDataPath(ArrayList<Mux> muxes) {
//        try {
//            PrintWriter file = new PrintWriter("test.v");
//            String header = "module " + null + "(";
//            String outputHeader = "";
//            String inputHeader = "";
//            String inputs = "";
//            String outputs = "";
//            String reg = "";
//            String wire = "";
//            String comps = "";
//            String assign = "";
//            String flipflop = "";
//            boolean hasReg = false;
//
//            for (VerilogComp comp : this.comps) {
//                if (comp instanceof Var) {
//                    Var select = (Var) comp;
//                    if (select.isSelectSignal() == true)
//                        assign = select.defineAssign(muxes) + "\n";
//                }
//
//                if (comp instanceof Register) {
//                    hasReg = true;
//                }
//
//                if (!(comp.defineInput().equals(""))) {
//                    inputHeader += comp.getName() + ",";
//                    inputs += comp.defineInput() + "\n";
//                }
//                if (!(comp.defineOutput().equals(""))) {
//                    outputHeader += comp.getName() + ",";
//                    outputs += comp.defineOutput() + "\n";
//                }
//                if (!(comp.defineReg().equals("")))
//                    reg += comp.defineReg() + "\n";
//                if (!(comp.defineWire().equals("")))
//                    wire += comp.defineWire() + "\n";
//                if (!(comp.defineComp().equals("")))
//                    comps += comp.defineComp() + "\n";
//                if (!(comp.defineFlipFlop().equals("")))
//                    flipflop += comp.defineFlipFlop() + "\n";
//
//
//            }
//
//            inputHeader += "clk,reset);";
//            header += outputHeader + inputHeader;
//            inputs+="input clk,reset;" + "\n";
//
//            file.println(header);
//            file.println(outputs + "\n");
//            file.println(inputs + "\n");
//            file.println(reg + "\n");
//            file.println(wire + "\n");
//            file.println(assign + "\n");
//            file.println(comps + "\n");
//            file.println(flipflop + "\n");
//            file.println("endmodule" + "\n");
//
//            // if this files contains a register, print this added module
//            if (hasReg) {
//                file.println("module DFFR(output reg[SIZE-1:0] q, input[SIZE-1:0] d, input clk, input rst" +
//                        ",input[SIZE-1:0] rst_next);");
//                file.println("parameter SIZE = 8;");
//                file.println("always_ff @(posedge clk, posedge rst)");
//                file.println("begin");
//                file.println("if(rst) q <= rst_next;");
//                file.println("else q <= d;");
//                file.println("end");
//                file.println("endmodule");
//
//            }
//            file.close();
//        }
//        catch (FileNotFoundException e)
//        {
//            System.out.println("File error");
//        }
//
//
//    }
//
//
//}
//
//
//
