package GUI;

import Drawing.*;


import Framework.IntToBinary;
import Framework.RunProgram;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class Controller {

    private String inputFile;
    private String testbench;

    private ArrayList<State> statesFSM = new ArrayList<>();


    //titled panes
    public TitledPane filePane;
    public TitledPane state0;
    public TitledPane state1;
    public TitledPane state2;
    public TitledPane state3;
    public TitledPane state4;


    //inputFile stuff
    public Button readFile;
    public TextField file;
    private String fileName;

    //input stuff
    public TextField numInputs;
    private String numberInputs;
    private Integer numberInputsInt;
    //1 input
    public TextField inSize;
    public ComboBox<String> inType = new ComboBox<>();
    public TextField inText;
    //2 inputs
    public TextField inSize1;
    public ComboBox<String> inType1 = new ComboBox<>();
    public TextField inText1;
    //3 inputs
    public TextField inSize2;
    public ComboBox<String> inType2 = new ComboBox<>();
    public TextField inText2;
    //4 inputs
    public TextField inSize3;
    public ComboBox<String> inType3 = new ComboBox<>();
    public TextField inText3;
    //5 inputs
    public TextField inSize4;
    public ComboBox<String> inType4 = new ComboBox<>();
    public TextField inText4;
    //6 inputs
    public TextField inSize5;
    public ComboBox<String> inType5 = new ComboBox<>();
    public TextField inText5;


    public ArrayList<String> inputSize = new ArrayList<>();
    private ArrayList<String> inputType = new ArrayList<>();
    private ArrayList<String> inputText = new ArrayList<>(); //array of inputs

    public Button addInputs;


    //output stuff
    private String numberOutputs;
    private Integer numberOutputsInt;
    public TextField numOutputs;
    public TextField outSize;
    public ComboBox<String> outType = new ComboBox<>();
    public TextField outText;
    public TextField outSize1;
    public ComboBox<String> outType1 = new ComboBox<>();
    public TextField outText1;
    public TextField outSize2;
    public ComboBox<String> outType2 = new ComboBox<>();
    public TextField outText2;
    public TextField outSize3;
    public ComboBox<String> outType3 = new ComboBox<>();
    public TextField outText3;
    public TextField outSize4;
    public ComboBox<String> outType4 = new ComboBox<>();
    public TextField outText4;
    public TextField outSize5;
    public ComboBox<String> outType5 = new ComboBox<>();
    public TextField outText5;
    public ArrayList<String> outputSize = new ArrayList<>();
    private ArrayList<String> outputType = new ArrayList<>();
    private ArrayList<String> outputText = new ArrayList<>(); //array of outputs

    // for variable
    private String numVariablesString;
    private Integer numVarialesInt;
    public TextField numVariables;
    //1 input
    public TextField varSize;
    public ComboBox<String> varType = new ComboBox<>();
    public TextField varText;
    //2 inputs
    public TextField varSize1;
    public ComboBox<String> varType1 = new ComboBox<>();
    public TextField varText1;
    //3 inputs
    public TextField varSize2;
    public ComboBox<String> varType2 = new ComboBox<>();
    public TextField varText2;
    //4 inputs
    public TextField varSize3;
    public ComboBox<String> varType3 = new ComboBox<>();
    public TextField varText3;
    //5 inputs
    public TextField varSize4;
    public ComboBox<String> varType4 = new ComboBox<>();
    public TextField varText4;
    //6 inputs
    public TextField varSize5;
    public ComboBox<String> varType5 = new ComboBox<>();
    public TextField varText5;

    public Button addVariables;


    public ArrayList<String> varbSize = new ArrayList<>();
    private ArrayList<String> varbType = new ArrayList<>();
    private ArrayList<String> varbText = new ArrayList<>(); //array of outputs
    //number of states stuff
    public TextField numStates;
    public String numberStates;
    public Integer numStatesInt;


    //assignment stuff
    private Boolean wasAssigned = false;
    private Boolean wasAssigned1 = false;
    private Boolean wasAssigned2 = false;
    private Boolean wasAssigned3 = false;
    private Boolean wasAssigned4 = false;


    private ArrayList<String> ass = new ArrayList<>();
    private ArrayList<String> ass1 = new ArrayList<>();
    private ArrayList<String> ass2 = new ArrayList<>();
    private ArrayList<String> ass3 = new ArrayList<>();
    private ArrayList<String> ass4 = new ArrayList<>();
    private ArrayList<String> assText = new ArrayList<>();
    private ArrayList<String> assText1 = new ArrayList<>();
    private ArrayList<String> assText2 = new ArrayList<>();
    private ArrayList<String> assText3 = new ArrayList<>();
    private ArrayList<String> assText4 = new ArrayList<>();
    public ComboBox<String> assign = new ComboBox<>();
    public TextField assignVal;
    public ComboBox<String> assign2 = new ComboBox<>();
    public Label equal2;
    public TextField assignVal2;
    public ComboBox<String> assign3 = new ComboBox<>();
    public Label equal3;
    public TextField assignVal3;
    public ComboBox<String> assign4 = new ComboBox<>();
    public Label equal4;
    public TextField assignVal4;

    public ComboBox<String> assign11 = new ComboBox<>();
    public ComboBox<String> assign21 = new ComboBox<>();
    public ComboBox<String> assign31 = new ComboBox<>();
    public ComboBox<String> assign41 = new ComboBox<>();

    public ComboBox<String> assign12 = new ComboBox<>();
    public ComboBox<String> assign22 = new ComboBox<>();
    public ComboBox<String> assign32 = new ComboBox<>();
    public ComboBox<String> assign42 = new ComboBox<>();

    public ComboBox<String> assign13 = new ComboBox<>();
    public ComboBox<String> assign23 = new ComboBox<>();
    public ComboBox<String> assign33 = new ComboBox<>();
    public ComboBox<String> assign43 = new ComboBox<>();

    public ComboBox<String> assign14 = new ComboBox<>();
    public ComboBox<String> assign24 = new ComboBox<>();
    public ComboBox<String> assign34 = new ComboBox<>();
    public ComboBox<String> assign44 = new ComboBox<>();

    public Label equal21;
    public Label equal31;
    public Label equal41;

    public Label equal22;
    public Label equal32;
    public Label equal42;

    public Label equal23;
    public Label equal33;
    public Label equal43;

    public Label equal24;
    public Label equal34;
    public Label equal44;

    public TextField assignVal11;
    public TextField assignVal21;
    public TextField assignVal31;
    public TextField assignVal41;

    public TextField assignVal12;
    public TextField assignVal22;
    public TextField assignVal32;
    public TextField assignVal42;

    public TextField assignVal13;
    public TextField assignVal23;
    public TextField assignVal33;
    public TextField assignVal43;

    public TextField assignVal14;
    public TextField assignVal24;
    public TextField assignVal34;
    public TextField assignVal44;

    public Button addAssign;
    public Button addAssign2;
    public Button addAssign3;

    public Button addAssign11;
    public Button addAssign21;
    public Button addAssign31;

    public Button addAssign12;
    public Button addAssign22;
    public Button addAssign32;

    public Button addAssign13;
    public Button addAssign23;
    public Button addAssign33;

    public Button addAssign14;
    public Button addAssign24;
    public Button addAssign34;

    //next state stuff
    public TextField nextState;
    public TextField nextState2;
    public TextField nextState11;
    public TextField nextState21;
    public TextField nextState12;
    public TextField nextState22;
    public TextField nextState13;
    public TextField nextState23;
    public TextField nextState14;
    public TextField nextState24;

    public Button addState;
    public Button addState1;
    public Button addState2;
    public Button addState3;
    public Button addState4;
    public Label if1;
    public Label if2;
    public Label if21;
    public Label if22;
    public Label if23;
    public Label if24;
    public Label if11;
    public Label if12;
    public Label if13;
    public Label if14;
    public Button ifButton;
    public Button ifButton1;
    public Button ifButton2;
    public Button ifButton3;
    public Button ifButton4;

    private ArrayList<Integer> nextStateArr = new ArrayList<>(2);
    private ArrayList<Integer> nextStateArr1 = new ArrayList<>();
    private ArrayList<Integer> nextStateArr2 = new ArrayList<>();
    private ArrayList<Integer> nextStateArr3 = new ArrayList<>();
    private ArrayList<Integer> nextStateArr4 = new ArrayList<>();

    //conditional stuff

    private Boolean ifStatement = false;
    private Boolean ifStatement1 = false;
    private Boolean ifStatement2 = false;
    private Boolean ifStatement3 = false;
    private Boolean ifStatement4 = false;

    public ComboBox<String> condition = new ComboBox<>();
    // public ComboBox<String> condition1 = new ComboBox<>();
    public ComboBox<String> condition2 = new ComboBox<>();
    public ComboBox<String> condition11 = new ComboBox<>();
    public ComboBox<String> condition21 = new ComboBox<>();
    public ComboBox<String> condition12 = new ComboBox<>();
    public ComboBox<String> condition22 = new ComboBox<>();
    public ComboBox<String> condition13 = new ComboBox<>();
    public ComboBox<String> condition23 = new ComboBox<>();
    public ComboBox<String> condition14 = new ComboBox<>();
    public ComboBox<String> condition24 = new ComboBox<>();

    ArrayList<String> conditionArr = new ArrayList<>(2);
    ArrayList<String> conditionArr2 = new ArrayList<>();
    ArrayList<String> conditionArr3 = new ArrayList<>();
    ArrayList<String> conditionArr4 = new ArrayList<>();
    ArrayList<String> conditionArr1 = new ArrayList<>();

    public ComboBox<String> comparator = new ComboBox<>();
    // public ComboBox<String> comparator1 = new ComboBox<>();
    public ComboBox<String> comparator2 = new ComboBox<>();
    public ComboBox<String> comparator11 = new ComboBox<>();
    public ComboBox<String> comparator21 = new ComboBox<>();
    public ComboBox<String> comparator12 = new ComboBox<>();
    public ComboBox<String> comparator22 = new ComboBox<>();
    public ComboBox<String> comparator13 = new ComboBox<>();
    public ComboBox<String> comparator23 = new ComboBox<>();
    public ComboBox<String> comparator14 = new ComboBox<>();
    public ComboBox<String> comparator24 = new ComboBox<>();
    ArrayList<String> comparatorArr = new ArrayList<>(2);
    ArrayList<String> comparatorArr1 = new ArrayList<>();
    ArrayList<String> comparatorArr2 = new ArrayList<>();
    ArrayList<String> comparatorArr3 = new ArrayList<>();
    ArrayList<String> comparatorArr4 = new ArrayList<>();

    public TextField conditionVal;
    // public TextField conditionVal1;
    public TextField conditionVal2;
    public TextField conditionVal11;
    public TextField conditionVal21;
    public TextField conditionVal12;
    public TextField conditionVal22;
    public TextField conditionVal13;
    public TextField conditionVal23;
    public TextField conditionVal14;
    public TextField conditionVal24;

    ArrayList<String> conditionValArr = new ArrayList<>(2);
    ArrayList<String> conditionValArr1 = new ArrayList<>();
    ArrayList<String> conditionValArr2 = new ArrayList<>();
    ArrayList<String> conditionValArr3 = new ArrayList<>();
    ArrayList<String> conditionValArr4 = new ArrayList<>();

    //enter state button stuff
    public Button enterState, enterState1, enterState2, enterState3, enterState4;

    //generate button stuff
    public Button generate;
    public Button generate1;
    public Button generate2;
    public Button generate3;
    public Button generate4;


    //test bench stuff
    public TitledPane testBenchPane;
    public TextField time1, variableVal1;
    public ComboBox<String> variable1 = new ComboBox<>();
    public Label tequal1;
    public Button addTime1, testButton, addAssTime, enterTime;

    private ArrayList<Integer> time = new ArrayList<>();
    private ArrayList<String> vars = new ArrayList<>();
    private ArrayList<Integer> varVal = new ArrayList<>();


/////////////////////////////////////////////////////////////////////////////////////////////////////////

    //starts all state panes as invisible until user specifies amount
    //starts all but first input as invisible until user specifies amount
    public void filePaneAction() {
        this.state0.setVisible(false);
        this.state1.setVisible(false);
        this.state2.setVisible(false);
        this.state3.setVisible(false);
        this.state4.setVisible(false);

        //sets all inputs invisible until user specifies input amount
        this.inSize1.setVisible(false);
        this.inType1.setVisible(false);
        this.inText1.setVisible(false);
        this.inSize2.setVisible(false);
        this.inType2.setVisible(false);
        this.inText2.setVisible(false);
        this.inSize3.setVisible(false);
        this.inType3.setVisible(false);
        this.inText3.setVisible(false);
        this.inSize4.setVisible(false);
        this.inType4.setVisible(false);
        this.inText4.setVisible(false);
        this.inSize5.setVisible(false);
        this.inType5.setVisible(false);
        this.inText5.setVisible(false);

        this.outSize1.setVisible(false);
        this.outType1.setVisible(false);
        this.outText1.setVisible(false);
        this.outSize2.setVisible(false);
        this.outType2.setVisible(false);
        this.outText2.setVisible(false);
        this.outSize3.setVisible(false);
        this.outType3.setVisible(false);
        this.outText3.setVisible(false);
        this.outSize4.setVisible(false);
        this.outType4.setVisible(false);
        this.outText4.setVisible(false);
        this.outSize5.setVisible(false);
        this.outType5.setVisible(false);
        this.outText5.setVisible(false);


        //sets all inputs invisible until user specifies input amount
        this.varType1.setVisible(false);
        this.varType2.setVisible(false);
        this.varType3.setVisible(false);
        this.varType4.setVisible(false);
        this.varType5.setVisible(false);
        this.varSize1.setVisible(false);
        this.varSize2.setVisible(false);
        this.varSize3.setVisible(false);
        this.varSize4.setVisible(false);
        this.varSize5.setVisible(false);
        this.varText1.setVisible(false);
        this.varText2.setVisible(false);
        this.varText3.setVisible(false);
        this.varText4.setVisible(false);
        this.varText5.setVisible(false);


        this.assign2.setVisible(false);
        this.equal2.setVisible(false);
        this.assignVal2.setVisible(false);
        this.addAssign2.setVisible(false);
        this.assign3.setVisible(false);
        this.equal3.setVisible(false);
        this.assignVal3.setVisible(false);
        this.addAssign3.setVisible(false);
        this.assign4.setVisible(false);
        this.equal4.setVisible(false);
        this.assignVal4.setVisible(false);

        this.assign21.setVisible(false);
        this.equal21.setVisible(false);
        this.assignVal21.setVisible(false);
        this.addAssign21.setVisible(false);
        this.assign31.setVisible(false);
        this.equal31.setVisible(false);
        this.assignVal31.setVisible(false);
        this.addAssign31.setVisible(false);
        this.assign41.setVisible(false);
        this.equal41.setVisible(false);
        this.assignVal41.setVisible(false);

        this.assign22.setVisible(false);
        this.equal22.setVisible(false);
        this.assignVal22.setVisible(false);
        this.addAssign22.setVisible(false);
        this.assign32.setVisible(false);
        this.equal32.setVisible(false);
        this.assignVal32.setVisible(false);
        this.addAssign32.setVisible(false);
        this.assign42.setVisible(false);
        this.equal42.setVisible(false);
        this.assignVal42.setVisible(false);

        this.assign23.setVisible(false);
        this.equal23.setVisible(false);
        this.assignVal23.setVisible(false);
        this.addAssign23.setVisible(false);
        this.assign33.setVisible(false);
        this.equal33.setVisible(false);
        this.assignVal33.setVisible(false);
        this.addAssign33.setVisible(false);
        this.assign43.setVisible(false);
        this.equal43.setVisible(false);
        this.assignVal43.setVisible(false);

        this.assign24.setVisible(false);
        this.equal24.setVisible(false);
        this.assignVal24.setVisible(false);
        this.addAssign24.setVisible(false);
        this.assign34.setVisible(false);
        this.equal34.setVisible(false);
        this.assignVal34.setVisible(false);
        this.addAssign34.setVisible(false);
        this.assign44.setVisible(false);
        this.equal44.setVisible(false);
        this.assignVal44.setVisible(false);

        //setting conditional invisible
        this.addState.setVisible(false);

        this.condition.setVisible(false);
        this.if1.setVisible(false);
        this.comparator.setVisible(false);
        this.conditionVal.setVisible(false);

        this.nextState2.setVisible(false);
        this.nextState21.setVisible(false);
        this.nextState22.setVisible(false);
        this.nextState23.setVisible(false);
        this.nextState24.setVisible(false);

        this.condition2.setVisible(false);
        this.condition21.setVisible(false);
        this.condition22.setVisible(false);
        this.condition23.setVisible(false);
        this.condition24.setVisible(false);

        this.comparator2.setVisible(false);
        this.comparator21.setVisible(false);
        this.comparator22.setVisible(false);
        this.comparator23.setVisible(false);
        this.comparator24.setVisible(false);

        this.conditionVal2.setVisible(false);
        this.conditionVal21.setVisible(false);
        this.conditionVal22.setVisible(false);
        this.conditionVal23.setVisible(false);
        this.conditionVal24.setVisible(false);

        //  this.condition1.setVisible(false);
        this.condition11.setVisible(false);
        this.condition12.setVisible(false);
        this.condition13.setVisible(false);
        this.condition14.setVisible(false);

        //   this.comparator1.setVisible(false);
        this.comparator11.setVisible(false);
        this.comparator12.setVisible(false);
        this.comparator13.setVisible(false);
        this.comparator14.setVisible(false);

        this.conditionVal11.setVisible(false);
        this.conditionVal12.setVisible(false);
        this.conditionVal13.setVisible(false);
        this.conditionVal14.setVisible(false);

        this.if2.setVisible(false);
        this.if21.setVisible(false);
        this.if22.setVisible(false);
        this.if23.setVisible(false);
        this.if24.setVisible(false);

        this.if1.setVisible(false);
        this.if11.setVisible(false);
        this.if12.setVisible(false);
        this.if13.setVisible(false);
        this.if14.setVisible(false);


    }

    public void readFileAction() {
        this.numberInputs = numInputs.getText();
        this.numberInputsInt = Integer.parseInt(this.numberInputs);

        this.numberOutputs = numOutputs.getText();
        this.numberOutputsInt = Integer.parseInt(this.numberOutputs);

        this.numberStates = numStates.getText();
        this.numStatesInt = Integer.parseInt(this.numberStates);

        this.numVariablesString = this.numVariables.getText();
        this.numVarialesInt = Integer.parseInt(this.numVariablesString);

        if (this.numberInputsInt == 2) {
            this.inSize1.setVisible(true);
            this.inType1.setVisible(true);
            this.inText1.setVisible(true);
        } else if (this.numberInputsInt == 3) {
            this.inSize1.setVisible(true);
            this.inType1.setVisible(true);
            this.inText1.setVisible(true);
            this.inSize2.setVisible(true);
            this.inType2.setVisible(true);
            this.inText2.setVisible(true);
        } else if (this.numberInputsInt == 4) {
            this.inSize1.setVisible(true);
            this.inType1.setVisible(true);
            this.inText1.setVisible(true);
            this.inSize2.setVisible(true);
            this.inType2.setVisible(true);
            this.inText2.setVisible(true);
            this.inSize3.setVisible(true);
            this.inType3.setVisible(true);
            this.inText3.setVisible(true);
        } else if (this.numberInputsInt == 5) {
            this.inSize1.setVisible(true);
            this.inType1.setVisible(true);
            this.inText1.setVisible(true);
            this.inSize2.setVisible(true);
            this.inType2.setVisible(true);
            this.inText2.setVisible(true);
            this.inSize3.setVisible(true);
            this.inType3.setVisible(true);
            this.inText3.setVisible(true);
            this.inSize4.setVisible(true);
            this.inType4.setVisible(true);
            this.inText4.setVisible(true);
        } else if (this.numberInputsInt == 6) {
            this.inSize1.setVisible(true);
            this.inType1.setVisible(true);
            this.inText1.setVisible(true);
            this.inSize2.setVisible(true);
            this.inType2.setVisible(true);
            this.inText2.setVisible(true);
            this.inSize3.setVisible(true);
            this.inType3.setVisible(true);
            this.inText3.setVisible(true);
            this.inSize4.setVisible(true);
            this.inType4.setVisible(true);
            this.inText4.setVisible(true);
            this.inSize5.setVisible(true);
            this.inType5.setVisible(true);
            this.inText5.setVisible(true);
        } else if (numberInputsInt < 1 | numberInputsInt > 6) {
            numInputs.setText("That's not a valid number!!! >:(");
        }

        if (this.numberOutputsInt == 2) {
            outSize1.setVisible(true);
            outType1.setVisible(true);
            outText1.setVisible(true);
        } else if (this.numberOutputsInt == 3) {
            outSize1.setVisible(true);
            outType1.setVisible(true);
            outText1.setVisible(true);
            outSize2.setVisible(true);
            outType2.setVisible(true);
            outText2.setVisible(true);
        } else if (this.numberOutputsInt == 4) {
            outSize1.setVisible(true);
            outType1.setVisible(true);
            outText1.setVisible(true);
            outSize2.setVisible(true);
            outType2.setVisible(true);
            outText2.setVisible(true);
            outSize3.setVisible(true);
            outType3.setVisible(true);
            outText3.setVisible(true);
        } else if (this.numberOutputsInt == 5) {
            outSize1.setVisible(true);
            outType1.setVisible(true);
            outText1.setVisible(true);
            outSize2.setVisible(true);
            outType2.setVisible(true);
            outText2.setVisible(true);
            outSize3.setVisible(true);
            outType3.setVisible(true);
            outText3.setVisible(true);
            outSize4.setVisible(true);
            outType4.setVisible(true);
            outText4.setVisible(true);
        } else if (this.numberOutputsInt == 6) {
            outSize1.setVisible(true);
            outType1.setVisible(true);
            outText1.setVisible(true);
            outSize2.setVisible(true);
            outType2.setVisible(true);
            outText2.setVisible(true);
            outSize3.setVisible(true);
            outType3.setVisible(true);
            outText3.setVisible(true);
            outSize4.setVisible(true);
            outType4.setVisible(true);
            outText4.setVisible(true);
            outSize5.setVisible(true);
            outType5.setVisible(true);
            outText5.setVisible(true);
        } else if (this.numberOutputsInt > 6 | this.numberOutputsInt < 1) {
            numOutputs.setText("That's not a valid number!!!");
        }

        if (this.numVarialesInt == 2) {
            varSize1.setVisible(true);
            varType1.setVisible(true);
            varText1.setVisible(true);
        } else if (this.numVarialesInt == 3) {
            varSize1.setVisible(true);
            varType1.setVisible(true);
            varText1.setVisible(true);
            varSize2.setVisible(true);
            varType2.setVisible(true);
            varText2.setVisible(true);
        } else if (this.numVarialesInt == 4) {
            varSize1.setVisible(true);
            varType1.setVisible(true);
            varText1.setVisible(true);
            varSize2.setVisible(true);
            varType2.setVisible(true);
            varText2.setVisible(true);
            varSize3.setVisible(true);
            varType3.setVisible(true);
            varText3.setVisible(true);
        } else if (this.numVarialesInt == 5) {
            varSize1.setVisible(true);
            varType1.setVisible(true);
            varText1.setVisible(true);
            varSize2.setVisible(true);
            varType2.setVisible(true);
            varText2.setVisible(true);
            varSize3.setVisible(true);
            varType3.setVisible(true);
            varText3.setVisible(true);
            varSize4.setVisible(true);
            varType4.setVisible(true);
            varText4.setVisible(true);
        } else if (this.numVarialesInt == 6) {
            varSize1.setVisible(true);
            varType1.setVisible(true);
            varText1.setVisible(true);
            varSize2.setVisible(true);
            varType2.setVisible(true);
            varText2.setVisible(true);
            varSize3.setVisible(true);
            varType3.setVisible(true);
            varText3.setVisible(true);
            varSize4.setVisible(true);
            varType4.setVisible(true);
            varText4.setVisible(true);
            varSize5.setVisible(true);
            varType5.setVisible(true);
            varText5.setVisible(true);
        } else if (this.numVarialesInt > 6 | this.numVarialesInt < 1) {
            numOutputs.setText("That's not a valid number!!!");
        }

        if (numStatesInt == 1) {
            this.state0.setVisible(true);
        } else if (numStatesInt == 2) {
            this.state0.setVisible(true);
            this.state1.setVisible(true);
        } else if (numStatesInt == 3) {
            this.state0.setVisible(true);
            this.state1.setVisible(true);
            this.state2.setVisible(true);
        } else if (numStatesInt == 4) {
            this.state0.setVisible(true);
            this.state1.setVisible(true);
            this.state2.setVisible(true);
            this.state3.setVisible(true);
        } else if (numStatesInt == 5) {
            this.state0.setVisible(true);
            this.state1.setVisible(true);
            this.state2.setVisible(true);
            this.state3.setVisible(true);
            this.state4.setVisible(true);
        } else {
            numStates.setText("That's not a valid number!!!!");
        }


    }

    public void fileAction() {
        this.fileName = file.getText();
        this.inType.getItems().add("Var");
        this.inType1.getItems().add("Var");
        this.inType2.getItems().add("Var");
        this.inType3.getItems().add("Var");
        this.inType4.getItems().add("Var");
        this.inType5.getItems().add("Var");
        this.outType.getItems().add("Reg");
        this.outType.getItems().add("Var");
        this.outType1.getItems().add("Reg");
        this.outType1.getItems().add("Var");
        this.outType2.getItems().add("Reg");
        this.outType2.getItems().add("Var");
        this.outType3.getItems().add("Reg");
        this.outType3.getItems().add("Var");
        this.outType4.getItems().add("Reg");
        this.outType4.getItems().add("Var");
        this.outType5.getItems().add("Reg");
        this.outType5.getItems().add("Var");
        this.varType.getItems().add("Reg");
        this.varType1.getItems().add("Reg");
        this.varType2.getItems().add("Reg");
        this.varType3.getItems().add("Reg");
        this.varType4.getItems().add("Reg");
        this.varType5.getItems().add("Reg");
    }


    //adds inputs to array of inputs
    public void addInputsAction() {
        if (inSize.getLength() > 0) {
            this.inputSize.add(inSize.getText());
        }
        if (inSize1.getLength() > 0) {
            this.inputSize.add(inSize1.getText());
        }
        if (inSize2.getLength() > 0) {
            this.inputSize.add(inSize2.getText());
        }
        if (inSize3.getLength() > 0) {
            this.inputSize.add(inSize3.getText());
        }
        if (inSize4.getLength() > 0) {
            this.inputSize.add(inSize4.getText());
        }
        if (inSize5.getLength() > 0) {
            this.inputSize.add(inSize5.getText());
        }

        if (inType.getValue() != null) {
            this.inputType.add(inType.getValue());
        }
        if (inType1.getValue() != null) {
            this.inputType.add(inType1.getValue());
        }
        if (inType2.getValue() != null) {
            this.inputType.add(inType2.getValue());
        }
        if (inType3.getValue() != null) {
            this.inputType.add(inType3.getValue());
        }
        if (inType4.getValue() != null) {
            this.inputType.add(inType4.getValue());
        }
        if (inType5.getValue() != null) {
            this.inputType.add(inType5.getValue());
        }

        if (inText.getLength() > 0) {
            this.inputText.add(inText.getText());
        }
        if (inText1.getLength() > 0) {
            this.inputText.add(inText1.getText());
        }
        if (inText2.getLength() > 0) {
            this.inputText.add(inText2.getText());
        }
        if (inText3.getLength() > 0) {
            this.inputText.add(inText3.getText());
        }
        if (inText4.getLength() > 0) {
            this.inputText.add(inText4.getText());
        }
        if (inText5.getLength() > 0) {
            this.inputText.add(inText5.getText());
        }

        for (int i = 0; i < this.numberInputsInt; i++) {
            condition.getItems().add(this.inputType.get(i) + " " + this.inputText.get(i));
            condition2.getItems().add(this.inputType.get(i) + " " + this.inputText.get(i));
            condition11.getItems().add(this.inputType.get(i) + " " + this.inputText.get(i));
            condition21.getItems().add(this.inputType.get(i) + " " + this.inputText.get(i));
            condition12.getItems().add(this.inputType.get(i) + " " + this.inputText.get(i));
            condition22.getItems().add(this.inputType.get(i) + " " + this.inputText.get(i));
            condition13.getItems().add(this.inputType.get(i) + " " + this.inputText.get(i));
            condition23.getItems().add(this.inputType.get(i) + " " + this.inputText.get(i));
            condition14.getItems().add(this.inputType.get(i) + " " + this.inputText.get(i));
            condition24.getItems().add(this.inputType.get(i) + " " + this.inputText.get(i));

        }


    }

    //adds outputs to assign choices
    public void addOutputsAction() {
        if (outSize.getLength() > 0) {
            this.outputSize.add(outSize.getText());
        }
        if (outSize1.getLength() > 0) {
            this.outputSize.add(outSize1.getText());
        }
        if (outSize2.getLength() > 0) {
            this.outputSize.add(outSize2.getText());
        }
        if (outSize3.getLength() > 0) {
            this.outputSize.add(outSize3.getText());
        }
        if (outSize4.getLength() > 0) {
            this.outputSize.add(outSize4.getText());
        }
        if (outSize5.getLength() > 0) {
            this.outputSize.add(outSize5.getText());
        }

        if (outType.getValue() != null) {
            this.outputType.add(outType.getValue());
        }
        if (outType1.getValue() != null) {
            this.outputType.add(outType1.getValue());
        }
        if (outType2.getValue() != null) {
            this.outputType.add(outType2.getValue());
        }
        if (outType3.getValue() != null) {
            this.outputType.add(outType3.getValue());
        }
        if (outType4.getValue() != null) {
            this.outputType.add(outType4.getValue());
        }
        if (outType5.getValue() != null) {
            this.outputType.add(outType5.getValue());
        }

        if (outText.getLength() > 0) {
            this.outputText.add(outText.getText());
        }
        if (outText1.getLength() > 0) {
            this.outputText.add(outText1.getText());
        }
        if (outText2.getLength() > 0) {
            this.outputText.add(outText2.getText());
        }
        if (outText3.getLength() > 0) {
            this.outputText.add(outText3.getText());
        }
        if (outText4.getLength() > 0) {
            this.outputText.add(outText4.getText());
        }
        if (outText5.getLength() > 0) {
            this.outputText.add(outText5.getText());
        }

        for (int i = 0; i < this.outputText.size(); i++) {
            assign.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign2.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign3.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign4.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign11.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign21.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign31.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign41.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign12.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign22.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign32.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign42.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign13.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign23.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign33.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign43.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign14.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign24.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign34.getItems().add(outputType.get(i) + " " + outputText.get(i));
            assign44.getItems().add(outputType.get(i) + " " + outputText.get(i));
            condition.getItems().add(outputType.get(i) + " " + outputText.get(i));
            condition2.getItems().add(outputType.get(i) + " " + outputText.get(i));
            condition11.getItems().add(outputType.get(i) + " " + outputText.get(i));
            condition21.getItems().add(outputType.get(i) + " " + outputText.get(i));
            condition13.getItems().add(outputType.get(i) + " " + outputText.get(i));
            condition23.getItems().add(outputType.get(i) + " " + outputText.get(i));
            condition14.getItems().add(outputType.get(i) + " " + outputText.get(i));
            condition24.getItems().add(outputType.get(i) + " " + outputText.get(i));
            condition12.getItems().add(outputType.get(i) + " " + outputText.get(i));
            condition22.getItems().add(outputType.get(i) + " " + outputText.get(i));
        }

    }


    //adds outputs to assign choices
    public void addVarAction() {
        if (varSize.getLength() > 0) {
            this.varbSize.add(varSize.getText());
        }
        if (varSize1.getLength() > 0) {
            this.varbSize.add(varSize1.getText());
        }
        if (varSize2.getLength() > 0) {
            this.varbSize.add(varSize2.getText());
        }
        if (varSize3.getLength() > 0) {
            this.varbSize.add(varSize3.getText());
        }
        if (varSize4.getLength() > 0) {
            this.varbSize.add(varSize4.getText());
        }
        if (varSize5.getLength() > 0) {
            this.varbSize.add(varSize5.getText());
        }

        if (varType.getValue() != null) {
            this.varbType.add(varType.getValue());
        }
        if (varType1.getValue() != null) {
            this.varbType.add(varType1.getValue());
        }
        if (varType2.getValue() != null) {
            this.varbType.add(varType2.getValue());
        }
        if (varType3.getValue() != null) {
            this.varbType.add(varType3.getValue());
        }
        if (varType4.getValue() != null) {
            this.varbType.add(varType4.getValue());
        }
        if (varType5.getValue() != null) {
            this.varbType.add(varType5.getValue());
        }

        if (varText.getLength() > 0) {
            this.varbText.add(varText.getText());
        }
        if (varText1.getLength() > 0) {
            this.varbText.add(varText1.getText());
        }
        if (varText2.getLength() > 0) {
            this.varbText.add(varText2.getText());
        }
        if (varText3.getLength() > 0) {
            this.varbText.add(varText3.getText());
        }
        if (varText4.getLength() > 0) {
            this.varbText.add(varText4.getText());
        }
        if (varText5.getLength() > 0) {
            this.varbText.add(varText5.getText());
        }

        for (int i = 0; i < this.varbText.size(); i++) {
            assign.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign2.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign3.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign4.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign11.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign21.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign31.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign41.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign12.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign22.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign32.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign42.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign13.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign23.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign33.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign43.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign14.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign24.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign34.getItems().add(varbType.get(i) + " " + varbText.get(i));
            assign44.getItems().add(varbType.get(i) + " " + varbText.get(i));
            condition.getItems().add(varbType.get(i) + " " + varbText.get(i));
            condition2.getItems().add(varbType.get(i) + " " + varbText.get(i));
            condition11.getItems().add(varbType.get(i) + " " + varbText.get(i));
            condition21.getItems().add(varbType.get(i) + " " + varbText.get(i));
            condition13.getItems().add(varbType.get(i) + " " + varbText.get(i));
            condition23.getItems().add(varbType.get(i) + " " + varbText.get(i));
            condition14.getItems().add(varbType.get(i) + " " + varbText.get(i));
            condition24.getItems().add(varbType.get(i) + " " + varbText.get(i));
            condition12.getItems().add(varbType.get(i) + " " + varbText.get(i));
            condition22.getItems().add(varbType.get(i) + " " + varbText.get(i));
        }

    }


////////////////////////////////////////////////////////////////state stuff

    ///////////////assignments

    @FXML
    public void assignAction(ActionEvent event) {
        if (event.getSource() == assign) {
            this.assText.add(assign.getValue());
        } else if (event.getSource() == assign2) {
            this.assText.add(assign2.getValue());
        } else if (event.getSource() == assign3) {
            this.assText.add(assign3.getValue());
        } else if (event.getSource() == assign4) {
            this.assText.add(assign4.getValue());
        } else if (event.getSource() == assign11) {
            this.assText1.add(assign11.getValue());
        } else if (event.getSource() == assign21) {
            this.assText1.add(assign21.getValue());
        } else if (event.getSource() == assign31) {
            this.assText1.add(assign31.getValue());
        } else if (event.getSource() == assign41) {
            this.assText1.add(assign41.getValue());
        } else if (event.getSource() == assign12) {
            this.assText2.add(assign12.getValue());
        } else if (event.getSource() == assign22) {
            this.assText2.add(assign22.getValue());
        } else if (event.getSource() == assign32) {
            this.assText2.add(assign32.getValue());
        } else if (event.getSource() == assign42) {
            this.assText2.add(assign42.getValue());
        } else if (event.getSource() == assign13) {
            this.assText3.add(assign13.getValue());
        } else if (event.getSource() == assign23) {
            this.assText3.add(assign23.getValue());
        } else if (event.getSource() == assign33) {
            this.assText3.add(assign33.getValue());
        } else if (event.getSource() == assign43) {
            this.assText3.add(assign43.getValue());
        } else if (event.getSource() == assign14) {
            this.assText4.add(assign14.getValue());
        } else if (event.getSource() == assign24) {
            this.assText4.add(assign24.getValue());
        } else if (event.getSource() == assign34) {
            this.assText4.add(assign34.getValue());
        } else if (event.getSource() == assign44) {
            this.assText4.add(assign44.getValue());
        }
    }

    @FXML
    public void addAssignAction(ActionEvent event) {
        if (event.getSource() == addAssign) {
            assignVal2.setVisible(true);
            assign2.setVisible(true);
            equal2.setVisible(true);
            addAssign2.setVisible(true);
        } else if (event.getSource() == addAssign2) {
            addAssign2.setVisible(true);
            assignVal2.setVisible(true);
            assign2.setVisible(true);
            equal2.setVisible(true);
            assignVal3.setVisible(true);
            equal3.setVisible(true);
            assign3.setVisible(true);
            addAssign3.setVisible(true);
        } else if (event.getSource() == addAssign3) {
            addAssign2.setVisible(true);
            addAssign3.setVisible(true);
            assignVal2.setVisible(true);
            equal2.setVisible(true);
            assign2.setVisible(true);
            assignVal3.setVisible(true);
            equal3.setVisible(true);
            assign3.setVisible(true);
            assignVal4.setVisible(true);
            assign4.setVisible(true);
            equal4.setVisible(true);
        } else if (event.getSource() == addAssign11) {
            assignVal21.setVisible(true);
            assign21.setVisible(true);
            equal21.setVisible(true);
            addAssign21.setVisible(true);
        } else if (event.getSource() == addAssign21) {
            addAssign21.setVisible(true);
            assignVal21.setVisible(true);
            assign21.setVisible(true);
            equal21.setVisible(true);
            assignVal31.setVisible(true);
            equal31.setVisible(true);
            assign31.setVisible(true);
            addAssign31.setVisible(true);
        } else if (event.getSource() == addAssign31) {
            addAssign21.setVisible(true);
            addAssign31.setVisible(true);
            assignVal21.setVisible(true);
            equal21.setVisible(true);
            assign21.setVisible(true);
            assignVal31.setVisible(true);
            equal31.setVisible(true);
            assign31.setVisible(true);
            assignVal41.setVisible(true);
            assign41.setVisible(true);
            equal41.setVisible(true);
        } else if (event.getSource() == addAssign12) {
            assignVal22.setVisible(true);
            assign22.setVisible(true);
            equal22.setVisible(true);
            addAssign22.setVisible(true);
        } else if (event.getSource() == addAssign22) {
            addAssign22.setVisible(true);
            assignVal22.setVisible(true);
            assign22.setVisible(true);
            equal22.setVisible(true);
            assignVal32.setVisible(true);
            equal32.setVisible(true);
            assign32.setVisible(true);
            addAssign32.setVisible(true);
        } else if (event.getSource() == addAssign32) {
            addAssign22.setVisible(true);
            addAssign32.setVisible(true);
            assignVal22.setVisible(true);
            equal22.setVisible(true);
            assign22.setVisible(true);
            assignVal32.setVisible(true);
            equal32.setVisible(true);
            assign32.setVisible(true);
            assignVal42.setVisible(true);
            assign42.setVisible(true);
            equal42.setVisible(true);
        } else if (event.getSource() == addAssign13) {
            assignVal23.setVisible(true);
            assign23.setVisible(true);
            equal23.setVisible(true);
            addAssign23.setVisible(true);
        } else if (event.getSource() == addAssign23) {
            addAssign23.setVisible(true);
            assignVal23.setVisible(true);
            assign23.setVisible(true);
            equal23.setVisible(true);
            assignVal33.setVisible(true);
            equal33.setVisible(true);
            assign33.setVisible(true);
            addAssign33.setVisible(true);
        } else if (event.getSource() == addAssign33) {
            addAssign23.setVisible(true);
            addAssign33.setVisible(true);
            assignVal23.setVisible(true);
            equal23.setVisible(true);
            assign23.setVisible(true);
            assignVal33.setVisible(true);
            equal33.setVisible(true);
            assign33.setVisible(true);
            assignVal43.setVisible(true);
            assign43.setVisible(true);
            equal43.setVisible(true);
        } else if (event.getSource() == addAssign14) {
            addAssign24.setVisible(true);
            addAssign34.setVisible(true);
            assignVal24.setVisible(true);
            equal24.setVisible(true);
        } else if (event.getSource() == addAssign24) {
            addAssign24.setVisible(true);
            addAssign34.setVisible(true);
            assignVal24.setVisible(true);
            equal24.setVisible(true);
            assign24.setVisible(true);
            assignVal34.setVisible(true);
            equal34.setVisible(true);
            assign34.setVisible(true);
        } else if (event.getSource() == addAssign34) {
            addAssign24.setVisible(true);
            addAssign34.setVisible(true);
            assignVal24.setVisible(true);
            equal24.setVisible(true);
            assign24.setVisible(true);
            assignVal34.setVisible(true);
            equal34.setVisible(true);
            assign34.setVisible(true);
            assignVal44.setVisible(true);
            assign44.setVisible(true);
            equal44.setVisible(true);
        }
    }


    ///////////next state
    @FXML
    public void addStateAction(ActionEvent event) {
        if (event.getSource() == addState) {
            this.nextState2.setVisible(true);
            this.condition2.setVisible(true);
            this.comparator2.setVisible(true);
            this.conditionVal2.setVisible(true);
            this.if2.setVisible(true);
        } else if (event.getSource() == addState1) {
            this.nextState21.setVisible(true);
            this.condition21.setVisible(true);
            this.comparator21.setVisible(true);
            this.conditionVal21.setVisible(true);
            this.if21.setVisible(true);
        } else if (event.getSource() == addState2) {
            this.nextState22.setVisible(true);
            this.condition22.setVisible(true);
            this.comparator22.setVisible(true);
            this.conditionVal22.setVisible(true);
            this.if22.setVisible(true);
        } else if (event.getSource() == addState3) {
            this.nextState23.setVisible(true);
            this.condition23.setVisible(true);
            this.comparator23.setVisible(true);
            this.conditionVal23.setVisible(true);
            this.if23.setVisible(true);
        } else if (event.getSource() == addState4) {
            this.nextState24.setVisible(true);
            this.condition24.setVisible(true);
            this.comparator24.setVisible(true);
            this.conditionVal24.setVisible(true);
            this.if24.setVisible(true);
        }

    }

    ////////conditions

    @FXML
    public void ifButtonAction(ActionEvent event) {
        if (event.getSource() == ifButton) {
            this.ifStatement = true;
            this.if1.setVisible(true);
            this.condition.setVisible(true);
            this.comparator.setVisible(true);
            this.conditionVal.setVisible(true);
            this.addState.setVisible(true);
        } else if (event.getSource() == ifButton1) {
            this.ifStatement1 = true;
            this.if11.setVisible(true);
            this.condition11.setVisible(true);
            this.comparator11.setVisible(true);
            this.conditionVal11.setVisible(true);
            this.addState1.setVisible(true);
        } else if (event.getSource() == ifButton2) {
            this.ifStatement2 = true;
            this.if12.setVisible(true);
            this.condition12.setVisible(true);
            this.comparator12.setVisible(true);
            this.conditionVal12.setVisible(true);
            this.addState2.setVisible(true);
        } else if (event.getSource() == ifButton3) {
            this.ifStatement3 = true;
            this.if13.setVisible(true);
            this.condition13.setVisible(true);
            this.comparator13.setVisible(true);
            this.conditionVal13.setVisible(true);
            this.addState3.setVisible(true);
        } else if (event.getSource() == ifButton4) {
            this.ifStatement4 = true;
            this.if14.setVisible(true);
            this.condition14.setVisible(true);
            this.comparator14.setVisible(true);
            this.conditionVal14.setVisible(true);
            this.addState4.setVisible(true);
        }
    }

    @FXML
    private void conditionAction(ActionEvent event) {
        if (event.getSource() == condition) {
            this.conditionArr.add(0, condition.getValue());
        } else if (event.getSource() == condition2) {
            this.conditionArr.add(1, condition2.getValue());
        } else if (event.getSource() == condition11) {
            this.conditionArr1.add(0, condition11.getValue());
        } else if (event.getSource() == condition21) {
            this.conditionArr1.add(1, condition21.getValue());
        } else if (event.getSource() == condition12) {
            this.conditionArr2.add(0, condition12.getValue());
        } else if (event.getSource() == condition22) {
            this.conditionArr2.add(1, condition22.getValue());
        } else if (event.getSource() == condition13) {
            this.conditionArr3.add(0, condition13.getValue());
        } else if (event.getSource() == condition23) {
            this.conditionArr3.add(1, condition23.getValue());
        } else if (event.getSource() == condition14) {
            this.conditionArr4.add(0, condition14.getValue());
        } else if (event.getSource() == condition24) {
            this.conditionArr4.add(1, condition24.getValue());
        }
        comparator.getItems().add("equals");
        comparator.getItems().add("greater than");
        comparator.getItems().add("less than");
        comparator2.getItems().add("equals");
        comparator2.getItems().add("greater than");
        comparator2.getItems().add("less than");

        comparator11.getItems().add("equals");
        comparator11.getItems().add("greater than");
        comparator11.getItems().add("less than");
        comparator21.getItems().add("equals");
        comparator21.getItems().add("greater than");
        comparator21.getItems().add("less than");

        comparator12.getItems().add("equals");
        comparator12.getItems().add("greater than");
        comparator12.getItems().add("less than");
        comparator22.getItems().add("equals");
        comparator22.getItems().add("greater than");
        comparator22.getItems().add("less than");

        comparator13.getItems().add("equals");
        comparator13.getItems().add("greater than");
        comparator13.getItems().add("less than");
        comparator23.getItems().add("equals");
        comparator23.getItems().add("greater than");
        comparator23.getItems().add("less than");

        comparator14.getItems().add("equals");
        comparator14.getItems().add("greater than");
        comparator14.getItems().add("less than");
        comparator24.getItems().add("equals");
        comparator24.getItems().add("greater than");
        comparator24.getItems().add("less than");
    }

    @FXML
    private void comparatorAction(ActionEvent event) {
        if (event.getSource() == comparator) {
            this.comparatorArr.add(0, comparator.getValue());
        } else if (event.getSource() == comparator2) {
            this.comparatorArr.add(1, comparator2.getValue());
        } else if (event.getSource() == comparator11) {
            this.comparatorArr1.add(0, comparator11.getValue());
        } else if (event.getSource() == comparator21) {
            this.comparatorArr1.add(1, comparator21.getValue());
        } else if (event.getSource() == comparator12) {
            this.comparatorArr2.add(0, comparator12.getValue());
        } else if (event.getSource() == comparator22) {
            this.comparatorArr2.add(1, comparator22.getValue());
        } else if (event.getSource() == comparator13) {
            this.comparatorArr3.add(0, comparator13.getValue());
        } else if (event.getSource() == comparator23) {
            this.comparatorArr3.add(1, comparator23.getValue());
        } else if (event.getSource() == comparator14) {
            this.comparatorArr4.add(0, comparator14.getValue());
        } else if (event.getSource() == comparator24) {
            this.comparatorArr4.add(1, comparator24.getValue());
        }
    }


    ///////generate the coodddddeeeee :)
    @FXML
    public void enterStateAction(ActionEvent event) {
        if (event.getSource() == enterState) {
            if (assignVal.getLength() > 0) {
                this.ass.add(assignVal.getText());
            }
            if (assignVal2.getLength() > 0) {
                this.ass.add(assignVal2.getText());
            }
            if (assignVal3.getLength() > 0) {
                this.ass.add(assignVal3.getText());
            }
            if (assignVal4.getLength() > 0) {
                this.ass.add(assignVal4.getText());
            }
            if (nextState.getLength() > 0) {
                int nextStateNumInt = Integer.parseInt(nextState.getText());
                this.nextStateArr.add(0, nextStateNumInt);
                if (nextStateNumInt >= this.numStatesInt | nextStateNumInt < 0) {
                    nextState.setText("That's not a valid state!!");
                }
            }
            if (nextState2.getLength() > 0) {
                int nextStateNumInt = Integer.parseInt(nextState2.getText());
                this.nextStateArr.add(1, nextStateNumInt);
                if (nextStateNumInt >= this.numStatesInt | nextStateNumInt < 0) {
                    nextState2.setText("That's not a valid state!!");
                }
            }
            if (conditionVal.getLength() > 0) {
                this.conditionValArr.add(0, conditionVal.getText());
            }
            if (conditionVal2.getLength() > 0) {
                this.conditionValArr.add(1, conditionVal2.getText());
            }
        }
        if (event.getSource() == enterState1) {
            if (assignVal11.getLength() > 0) {
                this.ass1.add(assignVal11.getText());
            }
            if (assignVal21.getLength() > 0) {
                this.ass1.add(assignVal21.getText());
            }
            if (assignVal31.getLength() > 0) {
                this.ass1.add(assignVal31.getText());
            }
            if (assignVal41.getLength() > 0) {
                this.ass1.add(assignVal41.getText());
            }
            if (nextState11.getLength() > 0) {
                int nextStateNumInt = Integer.parseInt(nextState11.getText());
                this.nextStateArr1.add(0, nextStateNumInt);
                if (nextStateNumInt >= this.numStatesInt | nextStateNumInt < 0) {
                    nextState11.setText("That's not a valid state!!");
                }
            }
            if (nextState21.getLength() > 0) {
                int nextStateNumInt = Integer.parseInt(nextState21.getText());
                this.nextStateArr1.add(1, nextStateNumInt);
                if (nextStateNumInt >= this.numStatesInt | nextStateNumInt < 0) {
                    nextState21.setText("That's not a valid state!!");
                }
            }
            if (conditionVal11.getLength() > 0) {
                this.conditionValArr1.add(0, conditionVal11.getText());
            }
            if (conditionVal21.getLength() > 0) {
                this.conditionValArr1.add(1, conditionVal21.getText());
            }
        }
        if (event.getSource() == enterState2) {
            if (assignVal12.getLength() > 0) {
                this.ass2.add(assignVal12.getText());
            }
            if (assignVal22.getLength() > 0) {
                this.ass2.add(assignVal22.getText());
            }
            if (assignVal32.getLength() > 0) {
                this.ass2.add(assignVal32.getText());
            }
            if (assignVal42.getLength() > 0) {
                this.ass2.add(assignVal42.getText());
            }
            if (nextState12.getLength() > 0) {
                int nextStateNumInt = Integer.parseInt(nextState12.getText());
                this.nextStateArr2.add(0, nextStateNumInt);
                if (nextStateNumInt >= this.numStatesInt | nextStateNumInt < 0) {
                    nextState12.setText("That's not a valid state!!");
                }
            }
            if (nextState22.getLength() > 0) {
                int nextStateNumInt = Integer.parseInt(nextState22.getText());
                this.nextStateArr2.add(1, nextStateNumInt);
                if (nextStateNumInt >= this.numStatesInt | nextStateNumInt < 0) {
                    nextState22.setText("That's not a valid state!!");
                }
            }
            if (conditionVal12.getLength() > 0) {
                this.conditionValArr2.add(0, conditionVal12.getText());
            }
            if (conditionVal22.getLength() > 0) {
                this.conditionValArr2.add(1, conditionVal22.getText());
            }
        }
        if (event.getSource() == enterState3) {
            if (assignVal13.getLength() > 0) {
                this.ass3.add(assignVal13.getText());
            }
            if (assignVal23.getLength() > 0) {
                this.ass3.add(assignVal23.getText());
            }
            if (assignVal33.getLength() > 0) {
                this.ass3.add(assignVal33.getText());
            }
            if (assignVal43.getLength() > 0) {
                this.ass3.add(assignVal43.getText());
            }
            if (nextState13.getLength() > 0) {
                int nextStateNumInt = Integer.parseInt(nextState13.getText());
                this.nextStateArr3.add(0, nextStateNumInt);
                if (nextStateNumInt >= this.numStatesInt | nextStateNumInt < 0) {
                    nextState13.setText("That's not a valid state!!");
                }
            }
            if (nextState23.getLength() > 0) {
                int nextStateNumInt = Integer.parseInt(nextState23.getText());
                this.nextStateArr3.add(1, nextStateNumInt);
                if (nextStateNumInt >= this.numStatesInt | nextStateNumInt < 0) {
                    nextState23.setText("That's not a valid state!!");
                }
            }
            if (conditionVal13.getLength() > 0) {
                this.conditionValArr3.add(0, conditionVal13.getText());
            }
            if (conditionVal23.getLength() > 0) {
                this.conditionValArr3.add(1, conditionVal23.getText());
            }
        }
        if (event.getSource() == enterState4) {
            if (assignVal14.getLength() > 0) {
                this.ass4.add(assignVal14.getText());
            }
            if (assignVal24.getLength() > 0) {
                this.ass4.add(assignVal24.getText());
            }
            if (assignVal34.getLength() > 0) {
                this.ass4.add(assignVal34.getText());
            }
            if (assignVal44.getLength() > 0) {
                this.ass4.add(assignVal44.getText());
            }
            if (nextState14.getLength() > 0) {
                int nextStateNumInt = Integer.parseInt(nextState14.getText());
                this.nextStateArr4.add(0, nextStateNumInt);
                if (nextStateNumInt >= this.numStatesInt | nextStateNumInt < 0) {
                    nextState14.setText("That's not a valid state!!");
                }
            }
            if (nextState24.getLength() > 0) {
                int nextStateNumInt = Integer.parseInt(nextState24.getText());
                this.nextStateArr4.add(1, nextStateNumInt);
                if (nextStateNumInt >= this.numStatesInt | nextStateNumInt < 0) {
                    nextState24.setText("That's not a valid state!!");
                }
            }
            if (conditionVal14.getLength() > 0) {
                this.conditionValArr4.add(0, conditionVal14.getText());
            }
            if (conditionVal24.getLength() > 0) {
                this.conditionValArr4.add(1, conditionVal24.getText());
            }
        }
    }

    @FXML
    public void generateAction(ActionEvent event) {
        if (event.getSource() == generate | event.getSource() == generate1 | event.getSource() == generate2 | event.getSource() == generate3 | event.getSource() == generate4) {
            createInput();
        }
    }


    //////////////////////////////////////////////////////////test bench stuff
    public void testBenchPaneAction() {

        for (int i = 0; i < this.inputText.size(); i++) {
            variable1.getItems().add(inputType.get(i) + " " + inputText.get(i));
        }
    }

    @FXML
    private void addTimeAction(ActionEvent event) {
        if (event.getSource() == enterTime) { //processes time assignment
            int timeInt = Integer.parseInt(this.time1.getText());
            String varText = this.variable1.getValue();
            int varValText = Integer.parseInt(this.variableVal1.getText());
            this.time.add(timeInt);
            this.vars.add(varText);
            this.varVal.add(varValText);
        } else if (event.getSource() == addTime1) { //clears all fields to add new assignment
            this.time1.setText("");
            this.variable1.setValue("");
            this.variableVal1.setText("");
        } else if (event.getSource() == addAssTime) { //clears assignment but keeps time
            this.variable1.setValue("");
            this.variableVal1.setText("");
        }

    }
//

    public void testButtonAction() {

        createTestBench();
    }


    //////////////////////////////////////////////////////////////////////////////////////////////print input inputFile
    private void createInput() {
        //try {
        //PrintWriter inputFile = new PrintWriter(this.fileName + ".txt");
        StringBuilder inputs = new StringBuilder().append("input ");
        StringBuilder outputs = new StringBuilder().append("output ");
        StringBuilder state = new StringBuilder();


        //goes through array of inputs and adds them to input string
        for (int i = 0; i < this.numberInputsInt; i++) {
            inputs.append("Size " + this.inputSize.get(i) + " ");
            inputs.append(this.inputType.get(i) + " ");
            inputs.append(this.inputText.get(i) + " ");
        }

        //goes through array of outputs and adds them to output string
        for (int j = 0; j < this.numberOutputsInt; j++) {
            outputs.append("Size " + this.outputSize.get(j) + " ");
            outputs.append(this.outputType.get(j) + " ");
            outputs.append(this.outputText.get(j) + " ");
        }

        for (int k = 0; k < this.numStatesInt; k++) {
            state.append("\nState:" + k + " Define\n");
            if (k == 0) {
                // adding a state for FSM
                this.statesFSM.add(new State(0));
                //adds variable assignments
                for (int l = 0; l < this.assText.size(); l++) {
                    Boolean inputOutput = false;
                    int index = 0;
                    for (int i = 0; i < this.inputType.size(); i++) {
                        if ((this.inputType.get(i) + " " + this.inputText.get(i)).equals(this.assText.get(l))) {
                            inputOutput = true;
                            break;
                        }

                    }
                    for (int i = 0; i < this.outputType.size(); i++) {
                        if ((this.outputType.get(i) + " " + this.outputText.get(i)).equals(this.assText.get(l))) {
                            inputOutput = true;
                            break;
                        }
                    }

                    for (int i = 0; i < this.varbSize.size(); i++) {
                        if ((this.varbType.get(i) + " " + this.varbText.get(i)).equals(this.assText.get(l)))
                            index = i;
                    }
                    if (!inputOutput)
                        state.append("Size " + this.varbSize.get(index) + " " +
                                this.assText.get(l) + " Assign " + this.ass.get(l) + "\n");
                    else
                        state.append(this.assText.get(l) + " Assign " + this.ass.get(l) + "\n");

                }

                for (int j = 0; j < this.nextStateArr.size(); j++) {
                    if (!this.ifStatement) {  //WRONG SHIT
                        state.append("Next State State:" + this.nextStateArr.get(j) + "\n");
                        this.statesFSM.get(0).AddNextState(null, this.nextStateArr.get(j));
                    } else if (this.ifStatement) {
                        state.append("Next State if " + this.conditionArr.get(j) + " " + this.comparatorArr.get(j) + " " +
                                this.conditionValArr.get(j) + " State:" + this.nextStateArr.get(j) + "\n");
                        this.statesFSM.get(0).AddNextState(
                                this.conditionArr.get(j) + " " + this.comparatorArr.get(j) + " " +
                                        this.conditionValArr.get(j), this.nextStateArr.get(j));
                    }
                }
            } else if (k == 1) {
                for (int l = 0; l < this.assText1.size(); l++) {
                    state.append(this.assText1.get(l) + " Assign " + this.ass1.get(l) + "\n");
                }
                this.statesFSM.add(new State(1));
                for (int j = 0; j < this.nextStateArr1.size(); j++) {
                    if (!ifStatement1) {
                        state.append("Next State State:" + this.nextStateArr1.get(j) + "\n");
                        this.statesFSM.get(1).AddNextState(null, this.nextStateArr1.get(j));
                    } else {
                        state.append("Next State if " + this.conditionArr1.get(j) + " " + this.comparatorArr1.get(j) + " " +
                                this.conditionValArr1.get(j) + " State:" + this.nextStateArr1.get(j) + "\n");
                        this.statesFSM.get(1).AddNextState(
                                this.conditionArr1.get(j) + " " + this.comparatorArr1.get(j) + " " +
                                        this.conditionValArr1.get(j), this.nextStateArr1.get(j));
                    }
                }
            } else if (k == 2) {
                this.statesFSM.add(new State(2));
                for (int l = 0; l < this.assText2.size(); l++) {
                    state.append(this.assText2.get(l) + " Assign " + this.ass2.get(l) + "\n");
                }

                for (int j = 0; j < this.nextStateArr2.size(); j++) {
                    if (!ifStatement2) {
                        this.statesFSM.get(2).AddNextState(null, this.nextStateArr2.get(j));
                        state.append("Next State State:" + this.nextStateArr2.get(j) + "\n");
                    } else {
                        // CHRASHES HERE
                        state.append("Next State if " + this.conditionArr2.get(j) + " " + this.comparatorArr2.get(j) + " " +
                                this.conditionValArr2.get(j) + " State:" + this.nextStateArr2.get(j) + "\n");
                        this.statesFSM.get(2).AddNextState(
                                this.conditionArr2.get(j) + " " + this.comparatorArr2.get(j) + " " +
                                        this.conditionValArr2.get(j), this.nextStateArr2.get(j));
                    }
                }
            } else if (k == 3) {

                this.statesFSM.add(new State(3));
                for (int v = 0; v < this.assText3.size(); v++) {
                    state.append(this.assText3.get(v) + " Assign " + this.ass3.get(v) + "\n");
                }

                for (int j = 0; j < this.nextStateArr3.size(); j++) {
                    if (!ifStatement3) {
                        this.statesFSM.get(3).AddNextState(null, this.nextStateArr3.get(j));
                        state.append("Next State State:" + this.nextStateArr3.get(j) + "\n");
                    } else {
                        this.statesFSM.get(3).AddNextState(
                                this.conditionArr3.get(j) + " " + this.comparatorArr3.get(j) + " " +
                                        this.conditionValArr3.get(j), this.nextStateArr3.get(j));

                        state.append("Next State if " + this.conditionArr3.get(j) + " " + this.comparatorArr3.get(j) + " " +
                                this.conditionValArr3.get(j) + " State:" + this.nextStateArr3.get(j) + "\n");
                    }
                }
            } else if (k == 4) {
                this.statesFSM.add(new State(4));
                for (int l = 0; l < this.assText4.size(); l++) {
                    state.append(this.assText4.get(l) + " Assign " + this.ass4.get(l) + "\n");
                }

                for (int j = 0; j < this.nextStateArr4.size(); j++) {
                    if (!ifStatement4) {
                        this.statesFSM.get(4).AddNextState(null, this.nextStateArr4.get(j));
                        state.append("Next State State:" + this.nextStateArr4.get(j) + "\n");
                    } else {
                        this.statesFSM.get(4).AddNextState(
                                this.conditionArr4.get(j) + " " + this.comparatorArr4.get(j) + " " +
                                        this.conditionValArr4.get(j), this.nextStateArr4.get(j));
                        state.append("Next State if " + this.conditionArr4.get(j) + " " + this.comparatorArr4.get(j) + " " +
                                this.conditionValArr4.get(j) + " State:" + this.nextStateArr4.get(j) + "\n");
                    }
                }
            }
            state.append("End\n");
        }

//            inputFile.println("Start FSM ");
//            inputFile.println(inputs);
//            inputFile.println(outputs);
//            inputFile.println(state);
//            inputFile.println("End");
//            inputFile.close();
//        }
//
//        catch (FileNotFoundException e){
//            System.out.println("File error");
//        }
        this.inputFile = "Start FSM \n" + inputs + "\n" + outputs + state + "End FSM";
    }

    private void createTestBench() {
        StringBuilder timeString = new StringBuilder();

        for (int i = 0; i < this.time.size(); i++) {
            String reset = "";
            if (i == 0) {
                reset = " reset = 0; ";
            }
            //appends assignments to the same line as the last time if assignments are for the same time
            if (i > 0 && (time.get(i - 1) == time.get(i))) {
                timeString.append(" " + vars.get(i).substring(3, vars.get(i).length()) + " = " + IntToBinary.printToBinary(varVal.get(i), Integer.parseInt(
                        varbSize.get(i))) + ";");
            } else {
                int times = time.get(i);
                timeString.append("\n#" + times + reset + vars.get(i).substring(3, vars.get(i).length())
                        + " = " + IntToBinary.printToBinary(varVal.get(i),
                        Integer.parseInt(varbSize.get(i)))
                        + ";");
            }
        }

        this.testbench = timeString.toString();
        createProgram();

    }


    public void createProgram() {
        RunProgram run = new RunProgram();
        System.out.println(this.inputFile);
        System.out.println(this.testbench);
        Display d = new Display(this.statesFSM);
        run.run(this.fileName, this.inputFile, this.testbench);
    }
}
