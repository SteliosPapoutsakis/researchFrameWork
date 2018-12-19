package Drawing;
/*
purpose is to draaw arrows inbetween the states
@author Stelios Papoutsakis
 */

import java.awt.*;

public class ArrowDrawing {
    private Graphics g;

    public ArrowDrawing(Graphics g) {
        this.g = g;
    }

    public void DrawArc(State state, State nextState, String text) {
        int width = Math.abs(state.getxC() - nextState.getxC());
        int height = 200;
        Graphics2D g2 = (Graphics2D) this.g;
        g2.setStroke(new BasicStroke(5));
        //case if the next state is itself
        this.g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        if (state.getStateNum() == nextState.getStateNum()) {
            this.g.drawArc(state.getxC(), state.getyC(), 200, 100, 0, 360);
            if (text != null)
                this.g.drawString(text, state.getxC() + 100, state.getyC() + 50);

            //draw arrow

            g2.drawLine(200 + state.getxC(), state.getyC() + 50, 210 + state.getxC(), state.getyC() + 60);
            g2.drawLine(200 + state.getxC(), state.getyC() + 50, 190 + state.getxC(), state.getyC() + 60);
        }

        // for upper row
        else {
            int angle = 180;
            int startAngle = 0;
            if (state.getStateNum() - nextState.getStateNum() > 0) {
                startAngle = 0;
                angle = -180;
                this.g.drawArc(nextState.getxC(), nextState.getyC() - 50, width, height, startAngle, angle);
                if (text != null)
                    this.g.drawString(text, state.getxC() - width / 2,
                            state.getyC() + 200);
            } else {
                this.g.drawArc(state.getxC(), state.getyC() - 50, width, height, startAngle, angle);
                if (text != null)
                    this.g.drawString(text, state.getxC() + width / 2,
                            state.getyC() - 70);
            }
            // for drawing the arrow from left to right

            if (state.getStateNum() < nextState.getStateNum()) {
                g2.drawLine(state.getxC() + width / 2, state.getyC() - 60, state.getxC() + width / 2 + 20
                        , state.getyC() - 50);

                g2.drawLine(state.getxC() + width / 2 + 20
                        , state.getyC() - 50, state.getxC() + width / 2
                        , state.getyC() - 40);


            }
            // for drawing arrow right to left
            else {
                g2.drawLine(state.getxC() - width / 2
                        , state.getyC() + 150, state.getxC() - width / 2 + 20
                        , state.getyC() + 140);

                g2.drawLine(state.getxC() - width / 2
                        , state.getyC() + 150, state.getxC() - width / 2 + 20
                        , state.getyC() + 160);
            }

        }
    }

    public void DrawLine(State state, State nextState, String text) {
        this.g.drawLine(state.getxC(), state.getyC(), nextState.getxC(), nextState.getyC());
        if (text != null)
            this.g.drawString(text, Math.abs(state.getxC() + nextState.getxC()) / 2 + 20,
                    (state.getyC() + nextState.getyC()) / 2);

        int x = (state.getxC() + nextState.getxC()) / 2;
        int y = (state.getyC() + nextState.getyC()) / 2;
        Graphics2D g2 = (Graphics2D) this.g;
        g2.setStroke(new BasicStroke(5));
        //drawing angles
        if (state.getStateNum() < nextState.getStateNum()) {
            g2.drawLine(x, y, x - 10, y - 10);
            g2.drawLine(x, y, x + 10, y - 10);
        } else {
            g2.drawLine(x, y, x - 10, y + 10);
            g2.drawLine(x, y, x + 10, y + 10);
        }

    }


}

