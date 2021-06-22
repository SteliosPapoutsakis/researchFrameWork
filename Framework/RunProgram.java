package Framework;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class RunProgram {
    public static void main(String[] args) {
        String fileName = "StelliTest";
        String file ="Start FSM\n" +
                "input Size 1 Var start Size 8 Var n \n" +
                "output Size 1 Var busy Size 8 Reg r1 \n" +
                "State:0 Define\n" +
                "Size 8 Reg A = Var n   \n" +
                "Reg r1 = 0   \n" +
                "Size 8 Reg r0 = 1   \n" +
                "Var busy = 0   \n" +
                "Next State if Var start==1 State:1\n" +
                "Next State State:0\n" +
                "End\n" +
                "State:1 Define\n" +
                "Reg A = Reg A\n" +
                "Reg r1 = Reg r1\n" +
                "Reg r0 = Reg r0\n" +
                "Var busy = 1   \n" +
                "Next State if Reg A==0 State:3\n" +
                "Next State if Reg A~=0 State:2\n" +
                "End\n" +
                "State:2 Define\n" +
                "Reg A = Reg A -  1\n" +
                "Reg r1 = Reg r1 + Reg  r0\n" +
                "Reg r0 = Reg r1   \n" +
                "Var busy = 1   \n" +
                "Next State if Reg A==0 State:3\n" +
                "Next State State:2\n" +
                "End\n" +
                "State:3 Define\n" +
                "Reg A = Reg A\n" +
                "Reg r1 = Reg r1\n" +
                "Reg r0 = Reg r0\n" +
                "Var busy = 0   \n" +
                "Next State State:3\n" +
                "End\n" +
                "End FSM";

//        String file ="Start FSM\n" +
//                "input Size 1 Var req0 Size 1 Var req1 \n" +
//                "output Size 1 Var grant0 Size 1 Var grant1 \n" +
//                "State:0 Define\n" +
//                "Var grant1 = 1   \n" +
//                "Var grant0 = 0   \n" +
//                "Next State if Var req0==1 State:1\n" +
//                "Next State if Var req0==0 State:0\n" +
//                "Next State if Var req0==0 State:2\n" +
//                "Next State if Var req1==0 State:0\n" +
//                "Next State if Var req1==1 State:2\n" +
//                "End\n" +
//                "State:1 Define\n" +
//                "Var grant1 = 0   \n" +
//                "Var grant0 = 1   \n" +
//                "Next State if Var req0==0 State:3\n" +
//                "Next State if Var req0==1 State:1\n" +
//                "End\n" +
//                "State:2 Define\n" +
//                "Var grant1 = 1   \n" +
//                "Var grant0 = 0\n" +
//                "Next State if Var req1==1 State:2\n" +
//                "Next State if Var req1==0 State:4\n" +
//                "End\n" +
//                "State:3 Define\n" +
//                "Var grant1 = 0   \n" +
//                "Var grant0 = 0   \n" +
//                "Next State if Var req0==0 State:3\n" +
//                "Next State if Var req0==0 State:5\n" +
//                "Next State if Var req0==1 State:1\n" +
//                "Next State if Var req0==1 State:2\n" +
//                "Next State if Var req1==1 State:2\n" +
//                "Next State if Var req1==0 State:1\n" +
//                "Next State if Var req1==1 State:5\n" +
//                "Next State if Var req1==0 State:3\n" +
//                "End\n" +
//                "State:4 Define\n" +
//                "Var grant1 = 0   \n" +
//                "Var grant0 = 0   \n" +
//                "Next State if Var req0==0 State:4\n" +
//                "Next State if Var req0==0 State:2\n" +
//                "Next State if Var req0==1 State:6\n" +
//                "Next State if Var req0==1 State:1\n" +
//                "Next State if Var req1==1 State:1\n" +
//                "Next State if Var req1==0 State:6\n" +
//                "Next State if Var req1==1 State:2\n" +
//                "Next State if Var req1==0 State:4\n" +
//                "End\n" +
//                "State:5 Define\n" +
//                "Var grant1 = 1   \n" +
//                "Var grant0 = 0   \n" +
//                "Next State if Var req1==0 State:3\n" +
//                "Next State if Var req1==1 State:5\n" +
//                "End\n" +
//                "State:6 Define\n" +
//                "Var grant1 = 0   \n" +
//                "Var grant0 = 1\n" +
//                "Next State if Var req0==0 State:4\n" +
//                "Next State if Var req0==1 State:6\n" +
//                "End\n" +
//                "End FSM";
        FSMLexer lexer = new FSMLexer(CharStreams.fromString(file));
        FSMParser parser = new FSMParser(new CommonTokenStream(lexer));
        ProgramListener listener = new ProgramListener(fileName);
        ParseTreeWalker.DEFAULT.walk(listener, parser.fsm());


    }
    public void run(String fileName, String file) {
        FSMLexer lexer = new FSMLexer(CharStreams.fromString(file));
        FSMParser parser = new FSMParser(new CommonTokenStream(lexer));
        ProgramListener listener = new ProgramListener(fileName);
        ParseTreeWalker.DEFAULT.walk(listener, parser.fsm());


        //commands(fileName);

    }












    public void commands(String fileName) {
        //https:
//stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder
// https://www.youtube.com/watch?v=6QNAAIotdxk
        File folder = new File("./" + fileName + "_Generate");
        File[] listOfFiles = folder.listFiles();
        String command = "cd " + folder.getPath() +
                "\niverilog -o " + fileName + "_tb.vcd ";
        for (File f : listOfFiles) {
            if (f.getName().substring(f.getName().length() - 4, f.getName().length()).equals(".vcd")) {
                f.delete();
                continue;
            }
            command += f.getName() + " ";
        }
        command += "\nvvp " + fileName + "_tb.vcd";
        command += "\ngtkwave";
        try {
            PrintWriter writer = new PrintWriter("./" + fileName + "_Generate/bash.bat");
            writer.println(command);
            writer.close();
        } catch (FileNotFoundException e) {
        }

        try {
            Process p = Runtime.getRuntime().exec("./" + fileName + "_Generate/bash.bat");
            p.waitFor();
            Files.delete(Paths.get("./" + fileName + "_Generate/bash.bat"));

        } catch (IOException e) {
            System.out.println("ERRRORR");
        } catch (InterruptedException e) {

        }
    }

//    public static void main(String[] args) {
//        RunProgram run = new RunProgram();
//        run.run("test","Start FSM \n" +
//                "input Size 8 Var n \n" +
//                "output Size 8 Reg a \n" +
//                "State:0 Define\n" +
//                "Size 8 Reg Fact Assign Var n\n" +
//                "Reg a Assign 1\n" +
//                "Next State State:1\n" +
//                "End\n" +
//                "\n" +
//                "State:1 Define\n" +
//                "Reg Fact Assign Reg Fact\n" +
//                "Reg a Assign Reg a\n" +
//                "Next State if Reg Fact equals 0 State:3\n" +
//                "Next State if Reg Fact greater than 0 State:2\n" +
//                "End\n" +
//                "\n" +
//                "State:2 Define\n" +
//                "Reg Fact Assign Reg Fact - 1\n" +
//                "Reg a Assign Reg a * Reg Fact\n" +
//                "Next State State:1\n" +
//                "End\n" +
//                "\n" +
//                "State:3 Define\n" +
//                "Reg Fact Assign Reg Fact\n" +
//                "Reg a Assign Reg a\n" +
//                "Next State State:3\n" +
//                "End\n" +
//                "End FSM\n" +
//                "\n","#20 reset = 0;  n = 8'b00000100;");
//    }
}
