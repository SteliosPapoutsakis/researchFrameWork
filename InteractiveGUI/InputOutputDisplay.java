package InteractiveGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InputOutputDisplay implements Runnable, ActionListener {
    private JPanel inputPanel;
    private JPanel outputPanel;
    private JFrame frame;
    private JTabbedPane tab = new JTabbedPane();
    private Button addIn = new Button("Add");
    private Button addOut = new Button("Add");
    private TextField inputs = new TextField("please enter the inputs to your FSM seperated by a comma");
    private TextField outputs = new TextField("please enter the outputs to your FSM seperated by a comma");
    private ArrayList<String> input;
    private ArrayList<String> output;

    public InputOutputDisplay(ArrayList<String> input, ArrayList<String> output) {
        this.input = input;
        this.output = output;
        this.frame = new JFrame("Inputs Outputs");
        this.frame.setSize(600, 500);
        this.frame.setResizable(false);
        this.inputPanel = new JPanel();
        this.outputPanel = new JPanel();
        tab.addTab("Inputs", this.inputPanel);
        tab.addTab("Outputs", this.outputPanel);
        this.inputs.setPreferredSize(new Dimension(50, 400));


        frame.add(tab);
        this.inputPanel.add(this.inputs);
        this.inputPanel.add(this.addIn);
        this.outputPanel.add(this.outputs);
        this.outputPanel.add(this.addOut);
        this.addIn.addActionListener(this);
        this.addOut.addActionListener(this);
        frame.pack();


    }

    @Override
    public void run() {
        /**
         * sets the frame visible
         */
        this.frame.setVisible(true);


    }

    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<>();
        ArrayList<String> test1 = new ArrayList<>();
        InputOutputDisplay display = new InputOutputDisplay(test, test1);
        display.run();

    }

    @Override
    /**
     *action listener used to listen to the buttons of the input output display
     *
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            if (this.tab.getSelectedIndex() == 0) {
                /**
                 * collecting the information in the texfield for inputs
                 * code ignores all the input that isn't type Var
                 */
                this.input.clear();

                while (this.inputs.getText().length() > 0) {
                    int index = this.inputs.getText().indexOf(',');
                    String str = "";
                    if (index > -1) {
                        str = this.inputs.getText().substring(0, index);
                        if (str.length() > 3
                                && str.substring(0, 3).equals("Var")) {
                            this.input.add(this.inputs.getText().substring(0, index));
                        }
                        this.inputs.setText(this.inputs.getText().substring(index + 1
                                , this.inputs.getText().length()));
                    } else if (this.inputs.getText().length() > 0) {
                        str = this.inputs.getText();
                        if (str.length() > 3 && str.substring(0, 3).equals("Var"))
                            this.input.add(this.inputs.getText());
                        this.inputs.setText("");
                    }


                }
                System.out.println(this.input);

            } else if (this.tab.getSelectedIndex() == 1) {
                /**
                 * collecting the information in the texfield for outputs
                 * code ignores all the input that isn't type Reg or Var
                 */
                this.output.clear();
                while (this.outputs.getText().length() > 0) {
                    int index = this.outputs.getText().indexOf(',');
                    String str = "";
                    if (index > -1) {
                        str = this.outputs.getText().substring(0, index);
                        if (str.length() > 3 && str.substring(0, 3).equals("Reg")
                                || str.substring(0, 3).equals("Var")) {
                            this.output.add(this.outputs.getText().substring(0, index));
                        }
                        this.outputs.setText(this.outputs.getText().substring(index + 1
                                , this.outputs.getText().length()));

                    } else if (this.outputs.getText().length() > 0) {
                        this.output.add(this.outputs.getText());
                        this.outputs.setText("");
                    }


                }


            }
            System.out.println(this.output);
        }

    }
}

