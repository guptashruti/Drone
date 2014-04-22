/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package neu.is.gui;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JLabel;

/**
 *
 * @author Shruti
 */
public class Cell extends Component{
 
    public static enum Status {
		Empty, Start, Finish, Blocked, inOpenList, inClosedList,Path;
    }   
    private Point position;
    private Status status;
    private double distFromStart;
    private double distFromFinish;
    private JLabel imageMap;

    // Constructor
    public Cell(Point point,JLabel imageMap) {
            this.imageMap=imageMap;
            this.position = point;
            init();
    }

    // Constructor
    public Cell(Point p, boolean block,JLabel imageMap) {
            this.imageMap=imageMap;
            this.position = p;
            init();
            this.set_status(Status.Blocked);
    }

    private void init() {
            this.set_status(Status.Empty);
            this.distFromStart = -1;
            this.distFromFinish = -1;
//
//		// Action and mouse listener support
//		enableEvents(AWTEvent.MOUSE_EVENT_MASK);
//
//		MouseListener mouseOnCell = new MouseOnCell();
//		this.addMouseListener(mouseOnCell);

    }

    /**
     * @return the _position
     */
    public Point getPosition() {
            return position;
    }

    /**
     * @param position
     *            the _position to set
     */
    public void setPosition(Point position) {
            this.position = position;
    }

    /**
     * @return the _distFromStart
     */
    public double getDistFromStart() {
            return distFromStart;
    }

    /**
     * @param distFromStart
     *            the _distFromStart to set
     */
    public void setDistFromStart(double distFromStart) {
            this.distFromStart = distFromStart;
    }

    /**
     * @return the _distFromFinish
     */
    public double getDistFromFinish() {
            double ans;
            if (this.status == Status.Start) {
                    ans = 0;
            }
            if (this.status == Status.Blocked) {
                    ans = -1;
            } else {
                    ans = this.distFromStart;
            }
            return ans;
    }

    /**
     * @param distFromFinish
     *            the _distFromFinish to set
     */
    public void setDistFromFinish(double distFromFinish) {
            this.distFromFinish = distFromFinish;
    }

    public void set_status(Status _status) {
            this.status = _status;
    }

    public Status get_status() {
            return status;
    }

    @Override
    public void paint(Graphics g) {	
            Dimension size = getSize();
            if (this.status == Status.Empty) {
                    g.setColor(Color.white);
            }
            if (this.status == Status.Start) {
                    g.setColor(Color.green);
            }
            if (this.status == Status.Finish) {
                    g.setColor(Color.red);
            }
            if (this.status == Status.Blocked) {
                    g.setColor(Color.black);
            }
            if (this.status == Status.inOpenList) {
                    g.setColor(Color.gray);
            }
            if (this.status == Status.inClosedList) {
                    g.setColor(Color.darkGray);
            }
            if (this.status == Status.Path ) {
                    g.setColor(Color.blue);
            }
            if (this.status == Status.Path ) {
                    g.setColor(Color.cyan);
            }
            g.fillRect(0, 0, size.width-1, size.height-1);	
            g.setColor(Color.black);	
            //g.setFont(new Font("sansserif", Font.BOLD, 13));
            //g.drawString(Double.toString(this._cost),5,15);
            g.drawRect(0, 0, size.width - 2, size.height - 2);
    }
}
