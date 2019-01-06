package Framework;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class RunProgram {
    public static void main(String[] args) {
        String fileName = "FIBFINAL";
        String file ="Start FSM\n" +
                "input Size 5 Var N \n" +
                "output Size 5 Reg R0\n" +
                "State:0 Define\n" +
                "Reg R0 = 1\n" +
                "Size 5 Reg A = Var N\n" +
                "Size 5 Reg R1 = 0\n" +
                "Next State State:1 \n" +
                "End\n" +
                "State:1 Define\n" +
                "Reg R0 = Reg R0\n" +
                "Reg A = Reg A\n" +
                "Reg R1 = Reg R1\n" +
                "Next State if Reg A ~= 0 State:2\n" +
                "Next State State:3 \n" +
                "End\n" +
                "State:2 Define\n" +
                "Reg R0 = Reg R1\n" +
                "Reg R1 = Reg R1 + Reg R0\n" +
                "Reg A = Reg A - 1\n" +
                "Next State State:1\n" +
                "End\n" +
                "State:3 Define\n" +
                "Reg R0 = Reg R0\n" +
                "Reg R1 = Reg R1\n" +
                "Reg A = Reg A\n" +
                "Next State State:3 \n" +
                "End\n" +
                "End FSM\n";
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
