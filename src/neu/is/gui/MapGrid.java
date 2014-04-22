/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package neu.is.gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import neu.is.dstarlight.State;

/**
 *
 * @author Shruti
 */
public class MapGrid extends JPanel{
    
    private JLabel mapImage;
    private State[][] grid;
    public int width;
    public int height;
    private List<Point> fillCells;
    
    public MapGrid() {
        //this.mapImage = map;
        this.width = 900;
        this.height = 500;
        this.fillCells = new ArrayList<>();
        grid = new State[width][height];
	for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = new State(i,j);
			}
		}
	}
    
    public State getStateFromGrid(int x, int y){
       State st = grid[x][y];
        return st;
    } 
    
    public State getStateFromGrid(State state){
       State st = grid[state.x][state.y];
        return st;
    } 

    @Override
    protected void paintComponent(Graphics g) {            
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Point point : fillCells){
             g2d.setColor(Color.RED);
             g2d.fillRect(point.x, point.y, 5, 5);             
        }            
    }
        
    public void fillCell(int x, int y) {
        fillCells.add(new Point(x,y));
        repaint();
    }

    public static void main(String[] a) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                MapGrid grid = new MapGrid();
                JFrame window = new JFrame();
                window.setSize(840, 560);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.add(grid);
                window.setVisible(true);
                grid.fillCell(0, 0);
                grid.fillCell(79, 0);
                grid.fillCell(0, 49);
                grid.fillCell(79, 49);
                grid.fillCell(39, 24);
            }
        });
    }
    public JLabel getMapImage() {
        return mapImage;
    }

    public void setMapImage(JLabel mapImage) {
        this.mapImage = mapImage;
    }

    public State[][] getGrid() {
        return grid;
    }

    public void setGrid(State[][] grid) {
        this.grid = grid;
    }
    
     public List<Point> getFillCells() {
        return fillCells;
    }

    public void setFillCells(List<Point> fillCells) {
        this.fillCells = fillCells;
    }    
}
