package Drawing;

import java.awt.*;
import java.util.HashMap;

/**
 * Purpose is to represent a state to be drawn. Has its ordinates, state number, and next state representations saved
 */

public class State {
    private int xC;
    private int yC;



    private int stateNum;
    private final static int RADIUS = 50;
    private final static int SCREEN = 1000;


    private HashMap<String, Integer> nextState = new HashMap<>();

    public State(int num) {
        this.stateNum = num;

        // if state is between 0-2 it is on the top
        if (num < 3) {
            this.yC = 200;
            this.xC = 50 + (num) * (int)(SCREEN * .45-15);
        } else {
            // if state is between 3-4 its on the bottom row
            this.yC = 700;
            this.xC = (int)(SCREEN * .25) + 50 + (num-3) * (int)((SCREEN*.5)-50);
        }


    }

    // adds the next state conditiions into a hashtable
    public void AddNextState(String condition, int nextState) {
        this.nextState.put(condition, nextState);
    }

    public void drawState(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(this.xC - this.RADIUS, this.yC - this.RADIUS, this.RADIUS * 2, this.RADIUS * 2);
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman",Font.PLAIN,40));
        g.drawString("S" + this.stateNum, this.xC - 30, this.yC);
    }

    public int getxC() {
        return xC;
    }

    public int getyC() {
        return yC;
    }

    public int getStateNum() {
        return stateNum;
    }

    public HashMap<String, Integer> getNextState() {
        return nextState;
    }



}
