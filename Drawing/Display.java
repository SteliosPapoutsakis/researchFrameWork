package Drawing;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * purpose is to create a new frame where the FSM drawing is shown
 */

public class Display extends JPanel {
    private ArrayList<State> states;
    private JFrame frame;

    public Display(ArrayList<State> states) {
        this.states = states;
        this.frame = new JFrame("FSM Drawing");
        this.frame.setSize(1000, 1000);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.add(this);
        System.out.println(this.frame.getSize());
    }


    @Override
    public void paint(Graphics g) {
        ArrowDrawing draw = new ArrowDrawing(g);
        for (State state : this.states) {
            for (String str : state.getNextState().keySet())
                if ((state.getStateNum() < 3 && state.getNextState().get(str) < 3)
                        || state.getStateNum() > 2 && state.getNextState().get(str) > 2)
                    draw.DrawArc(state, this.states.get(state.getNextState().get(str)), str);
                else
                    draw.DrawLine(state, this.states.get(state.getNextState().get(str)), str);

        }


// drawing th actual states
        for (State state : this.states) {
            state.drawState(g);


        }


    }



    public static void main(String[] args) {
        ArrayList<State> a = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            a.add(new State(i));
        }
        a.get(0).getNextState().put("S", 1);
        a.get(0).getNextState().put("Sss", 2);
        a.get(1).getNextState().put("Sss", 1);
        a.get(2).getNextState().put("Sdd", 1);
        a.get(3).getNextState().put("Sdd", 1);
        Display d = new Display(a);


    }

}
