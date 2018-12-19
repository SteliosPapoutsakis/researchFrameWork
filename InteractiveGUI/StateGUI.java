package InteractiveGUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class StateGUI implements Runnable, ActionListener {
    private HashMap<String, String> assigments = new HashMap<>();
    private HashMap<String, Integer> nextState = new HashMap<>();
    private ArrayList<String> regs;
    private ArrayList<String> outputs;
    private JFrame frame = new JFrame("State assigments");
    private JTextField assigmentsText = new JTextField();
    private JTextField values = new JTextField();
    private JTextField equals = new JTextField("=");
    private JTextField conditions = new JTextField();
    private JTextField nextStateNum = new JTextField();
    private Button read = new Button("Read");
    private Button readCon = new Button("Read");
    private JPanel nextStatePanel = new JPanel();
    private JPanel assign = new JPanel();
    private JTabbedPane tab = new JTabbedPane();


    public StateGUI(ArrayList<String> regs, ArrayList<String> outputs) {
        this.regs = regs;
        this.outputs = outputs;


/**
 * set up the frame
 */
        this.frame.setSize(700, 200);
        Font font = this.assigmentsText.getFont().deriveFont(Font.PLAIN, 30f);
        this.frame.setResizable(false);
        this.equals.setEditable(false);

        // setting up assigment tab
        this.assigmentsText.setColumns(20);
        this.assigmentsText.setFont(font);
        this.equals.setColumns(10);
        this.values.setColumns(20);
        this.values.setFont(font);
        this.assign.add(this.assigmentsText);
        this.assign.add(this.equals);
        this.assign.add(this.values);
        this.assign.add(this.read);


        //setting up the conditions tab
        this.conditions.setColumns(20);
        this.conditions.setFont(font);
        this.nextStateNum.setColumns(5);
        this.nextStateNum.setFont(font);
        this.readCon.addActionListener(this);
        this.nextStatePanel.add(this.conditions);
        this.nextStatePanel.add(this.readCon);
        this.nextStatePanel.add(this.nextStateNum);


        // setting up the tab
        this.tab.addTab("Assignments", this.assign);
        this.tab.addTab("Conditions", this.nextStatePanel);
        this.frame.add(this.tab);
        this.read.addActionListener(this);
    }

    @Override
    public void run() {
        for (String str : this.regs) {
            this.assigmentsText.setText(this.assigmentsText.getText() + str + ",");
        }
        for (String str : this.outputs) {
            this.assigmentsText.setText(this.assigmentsText.getText() + str + ",");

        }

        if (this.assigmentsText.getText().length() > 0)
            this.assigmentsText.setText(this.assigmentsText.getText().substring(0,
                    this.assigmentsText.getText().length() - 1));
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<>();
        test.add("Reg a");
        test.add("Reg b");
        ArrayList<String> test1 = new ArrayList<>();
        test1.add("Var busy");
        test1.add("Reg busy");
        StateGUI gui = new StateGUI( test, test1);
        gui.run();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            if (this.tab.getSelectedIndex() == 0) {
                String str = this.assigmentsText.getText();
                String foo = this.values.getText();
                while (str.length() > 0) {
                    String temp = "";
                    String value = "";
                    if (str.indexOf(',') > -1) {
                        temp = str.substring(0, str.indexOf(','));
                        value = foo.substring(0, foo.indexOf(','));
                        str = str.substring(str.indexOf(',') + 1, str.length());
                        foo = foo.substring(foo.indexOf(',') + 1, foo.length());
                    } else {
                        temp = str;
                        value = foo;
                        str = "";
                        foo = "";
                    }
                    if (value.length() > 0) {
                        this.assigments.put(temp, value);
                    } else {
                        this.assigments.put(temp, temp);
                    }


                }

            } else if (this.tab.getSelectedIndex() == 1) {
                String str = this.conditions.getText();
                String foo = this.nextStateNum.getText();
                while (str.length() > 0) {
                    String temp = "";
                    String value = "";
                    if (str.indexOf(',') > -1) {
                        temp = str.substring(0, str.indexOf(','));
                        str = str.substring(str.indexOf(',') + 1, str.length());
                        value = foo.substring(0, foo.indexOf(','));
                        foo = foo.substring(foo.indexOf(',') + 1, foo.length());

                    } else {
                        temp = str;
                        str = "";
                        if (foo.indexOf(',') > -1) {
                            value = foo.substring(0, foo.indexOf(','));
                            foo = foo.substring(foo.indexOf(',') + 1, foo.length());
                        } else {
                            value = foo;
                            foo = "";
                        }
                    }

                    this.nextState.put(temp, Integer.parseInt(value));
                }

                if (foo.length() > 0)
                    this.nextState.put("NO_CONDITION", Integer.parseInt(foo));


            }

        }
        System.out.println(this.nextState);
        System.out.println(this.assigments);

    }


}
