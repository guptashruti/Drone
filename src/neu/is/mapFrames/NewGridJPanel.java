/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package neu.is.mapFrames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import neu.is.algos.Drone;
import neu.is.algos.MapGraph;
import neu.is.algos.Node;
import neu.is.dstarlight.State;

/**
 *
 * @author Shruti
 */
public class NewGridJPanel extends javax.swing.JPanel {

    private JLabel mapImage;
    private State[][] grid;
    public int width;
    public int height;
    private List<Point> fillCells;
    private MapGraph graph;
    private Point p;
    int dv = 2;
    int dw = 10;
    int weather = 5;
    double m,c, x1, x2, y1, y2;
    boolean movingRight = true;
    private Drone drone;
    private static JFrame window;
    public Color color;
   
    /**
     * Creates new form NewGridJPanel
     */
    public NewGridJPanel() {
        initComponents();
        this.width = 900;
        this.height = 500;
        graph = new MapGraph();
        grid = new State[width][height];
	for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = new State(i,j);
			}
	}
       initializeGraph(graph);        
       for(Node n : graph.getNodes()){
           sourceCityjComboBox1.addItem(n);
           destinationjComboBox2.addItem(n);
       }
        this.fillCells = new ArrayList<>();        
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
             g2d.setColor(color);
             g2d.fillRect(point.x, point.y, 1, 1);             
        }            
    }
        
    public void fillCell(int x, int y) {
        fillCells.add(new Point(x,y));
        this.color = Color.RED;
        repaint();
    }
    
    public void removeColor(int x, int y){
        fillCells.add(new Point(x,y));
        this.color = new Color(240,240,240);
        repaint();
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
    
    public void initializeGraph(MapGraph g){        
                
        ArrayList<Node> nodes = g.getNodes();        
        Node montana_node = new Node(g, "Montana",montana.getLocation(),this);        
        montana_node.addProductsToNode("Medication", 100);
        montana_node.addProductsToNode("Food", 100);
        montana_node.addProductsToNode("Clothes", 100);
        montana_node.addProductsToNode("Grocery", 100);
        montana_node.drones.add(new Drone(drone_montana1, this, graph));
        montana_node.drones.add(new Drone(drone_montana2, this, graph));
        montana_node.drones.add(new Drone(drone_montana3, this, graph));
        
//        Node salt_lake_node = new Node(g,"Salt Lake City", salt_lake.getLocation());        
//        salt_lake_node.addProductsToNode("Clothes", 80);
//        salt_lake_node.addProductsToNode("Grocery", 80);
        
        Node phoenix_node = new Node(g,"Phoenix", phoenix.getLocation(),this);
        phoenix_node.addProductsToNode("Food", 90);
        phoenix_node.addProductsToNode("Clothes", 80);
        phoenix_node.drones.add(new Drone(drone_phoenix1, this, graph));
        phoenix_node.drones.add(new Drone(drone_phoenix2, this, graph));
        phoenix_node.drones.add(new Drone(drone_phoenix3, this, graph));
        
        
        Node austin_node = new Node(g,"Austin", austin.getLocation(),this);
        austin_node.addProductsToNode("Medication", 120);
        austin_node.addProductsToNode("Food", 50);
        austin_node.addProductsToNode("Clothes", 170);
        austin_node.addProductsToNode("Grocery", 30);
        austin_node.drones.add(new Drone(drone_austin1, this, graph));
        austin_node.drones.add(new Drone(drone_austin2, this, graph));
        austin_node.drones.add(new Drone(drone_austin3, this, graph));
        
//        Node columbus_node = new Node(g,"Columbus", columbus.getLocation());
//        columbus_node.addProductsToNode("Medication", 90);
//        columbus_node.addProductsToNode("Food", 70);
//        columbus_node.addProductsToNode("Clothes", 100);
        
        Node springfield_node = new Node(g,"Springfield", springfield.getLocation(),this);
        springfield_node.addProductsToNode("Medication", 60);
        springfield_node.addProductsToNode("Food", 90);
        springfield_node.drones.add(new Drone(drone_springfield1, this, graph));
        springfield_node.drones.add(new Drone(drone_springfield2, this, graph));
        springfield_node.drones.add(new Drone(drone_springfield3, this, graph));
        
        Node denver_node = new Node(g,"Denver", denver.getLocation(),this);
        denver_node.addProductsToNode("Food", 80);
        denver_node.addProductsToNode("Clothes", 90);
        denver_node.drones.add(new Drone(drone_denver1, this, graph));
        denver_node.drones.add(new Drone(drone_denver2, this, graph));
        denver_node.drones.add(new Drone(drone_denver3, this, graph));
        
//        Node richmond_node = new Node(g,"Richmond", richmond.getLocation());
//        richmond_node.addProductsToNode("Medication", 100);
//        richmond_node.addProductsToNode("Food", 100);
//        richmond_node.addProductsToNode("Clothes", 100);
//        richmond_node.addProductsToNode("Grocery", 100);
        
        Node sacremanto_node = new Node(g,"Sacremanto", sacramento.getLocation(),this);
        sacremanto_node.addProductsToNode("Medication", 60);
        sacremanto_node.addProductsToNode("Grocery", 70);
        sacremanto_node.drones.add(new Drone(drone_sacramento1, this, graph));
        sacremanto_node.drones.add(new Drone(drone_sacramento2, this, graph));
        sacremanto_node.drones.add(new Drone(drone_sacramento3, this, graph));
        
        Node atlanta_node = new Node(g,"Atlanta", atlanta.getLocation(),this);
        atlanta_node.addProductsToNode("Clothes", 90);
        atlanta_node.addProductsToNode("Grocery", 150);
        atlanta_node.drones.add(new Drone(drone_atlanta1, this, graph));
        atlanta_node.drones.add(new Drone(drone_atlanta2, this, graph));
        atlanta_node.drones.add(new Drone(drone_atlanta3, this, graph));
        
        Node new_york_node = new Node(g,"New York",newyork.getLocation(),this); 
        new_york_node.addProductsToNode("Medication", 100);
        new_york_node.addProductsToNode("Food", 100);
        new_york_node.addProductsToNode("Clothes", 100);
        new_york_node.addProductsToNode("Grocery", 100);
        new_york_node.drones.add(new Drone(drone_newyork1, this, graph));
        new_york_node.drones.add(new Drone(drone_newyork2, this, graph));
        new_york_node.drones.add(new Drone(drone_newyork3, this, graph));        
        
        nodes.add(montana_node);
        //nodes.add(salt_lake_node);
        nodes.add(phoenix_node);
        nodes.add(austin_node);
        //nodes.add(columbus_node);
        nodes.add(springfield_node);
        nodes.add(denver_node);
        //nodes.add(richmond_node);
        nodes.add(sacremanto_node);
        nodes.add(atlanta_node);
        nodes.add(new_york_node);
    }
    
    public static void main(String[] a) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                NewGridJPanel grid = new NewGridJPanel();
                window = new JFrame();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        montana = new javax.swing.JLabel();
        salt_lake = new javax.swing.JLabel();
        drone_phoenix1 = new javax.swing.JLabel();
        phoenix = new javax.swing.JLabel();
        sacramento = new javax.swing.JLabel();
        denver = new javax.swing.JLabel();
        columbus = new javax.swing.JLabel();
        atlanta = new javax.swing.JLabel();
        springfield = new javax.swing.JLabel();
        newyork = new javax.swing.JLabel();
        richmond = new javax.swing.JLabel();
        drone_montana1 = new javax.swing.JLabel();
        drone_montana2 = new javax.swing.JLabel();
        drone_montana3 = new javax.swing.JLabel();
        drone_phoenix2 = new javax.swing.JLabel();
        drone_phoenix3 = new javax.swing.JLabel();
        drone_sacramento1 = new javax.swing.JLabel();
        drone_sacramento2 = new javax.swing.JLabel();
        drone_sacramento3 = new javax.swing.JLabel();
        drone_springfield1 = new javax.swing.JLabel();
        drone_springfield2 = new javax.swing.JLabel();
        drone_springfield3 = new javax.swing.JLabel();
        drone_denver1 = new javax.swing.JLabel();
        drone_denver2 = new javax.swing.JLabel();
        drone_denver3 = new javax.swing.JLabel();
        drone_newyork3 = new javax.swing.JLabel();
        drone_newyork2 = new javax.swing.JLabel();
        drone_newyork1 = new javax.swing.JLabel();
        drone_atlanta1 = new javax.swing.JLabel();
        drone_atlanta2 = new javax.swing.JLabel();
        drone_atlanta3 = new javax.swing.JLabel();
        austin = new javax.swing.JLabel();
        drone_austin1 = new javax.swing.JLabel();
        drone_austin2 = new javax.swing.JLabel();
        drone_austin3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sourceCityjComboBox1 = new javax.swing.JComboBox();
        startjButton1 = new javax.swing.JButton();
        destinationjComboBox2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        infojTable = new javax.swing.JTable();

        setLayout(null);

        montana.setText("Montana");
        add(montana);
        montana.setBounds(220, 80, 60, 20);
        add(salt_lake);
        salt_lake.setBounds(200, 200, 30, 20);

        drone_phoenix1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_phoenix1.setText("jLabel1");
        add(drone_phoenix1);
        drone_phoenix1.setBounds(140, 320, 40, 20);

        phoenix.setText("Phoenix");
        add(phoenix);
        phoenix.setBounds(170, 350, 50, 20);

        sacramento.setText("Sacremento");
        add(sacramento);
        sacramento.setBounds(30, 200, 60, 20);

        denver.setText("Denver");
        add(denver);
        denver.setBounds(340, 250, 40, 20);
        add(columbus);
        columbus.setBounds(700, 210, 20, 20);

        atlanta.setText("Atlanta");
        add(atlanta);
        atlanta.setBounds(700, 350, 50, 20);

        springfield.setText("Illinois");
        add(springfield);
        springfield.setBounds(590, 220, 60, 20);

        newyork.setText("New York");
        add(newyork);
        newyork.setBounds(850, 150, 50, 30);
        add(richmond);
        richmond.setBounds(820, 240, 10, 20);

        drone_montana1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_montana1.setText("jLabel1");
        add(drone_montana1);
        drone_montana1.setBounds(250, 60, 40, 20);

        drone_montana2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_montana2.setText("jLabel1");
        add(drone_montana2);
        drone_montana2.setBounds(220, 40, 40, 20);

        drone_montana3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_montana3.setText("jLabel1");
        add(drone_montana3);
        drone_montana3.setBounds(180, 60, 40, 20);

        drone_phoenix2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_phoenix2.setText("jLabel1");
        add(drone_phoenix2);
        drone_phoenix2.setBounds(190, 360, 40, 20);

        drone_phoenix3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_phoenix3.setText("jLabel1");
        add(drone_phoenix3);
        drone_phoenix3.setBounds(140, 350, 40, 20);

        drone_sacramento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_sacramento1.setText("jLabel1");
        add(drone_sacramento1);
        drone_sacramento1.setBounds(0, 190, 40, 20);

        drone_sacramento2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_sacramento2.setText("jLabel1");
        add(drone_sacramento2);
        drone_sacramento2.setBounds(0, 220, 40, 20);

        drone_sacramento3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_sacramento3.setText("jLabel1");
        add(drone_sacramento3);
        drone_sacramento3.setBounds(40, 220, 40, 20);

        drone_springfield1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_springfield1.setText("jLabel1");
        add(drone_springfield1);
        drone_springfield1.setBounds(550, 230, 40, 20);

        drone_springfield2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_springfield2.setText("jLabel1");
        add(drone_springfield2);
        drone_springfield2.setBounds(580, 210, 40, 20);

        drone_springfield3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_springfield3.setText("jLabel1");
        add(drone_springfield3);
        drone_springfield3.setBounds(610, 230, 40, 20);

        drone_denver1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_denver1.setText("jLabel1");
        add(drone_denver1);
        drone_denver1.setBounds(280, 230, 40, 20);

        drone_denver2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_denver2.setText("jLabel1");
        add(drone_denver2);
        drone_denver2.setBounds(300, 250, 40, 20);

        drone_denver3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_denver3.setText("jLabel1");
        add(drone_denver3);
        drone_denver3.setBounds(340, 230, 40, 20);

        drone_newyork3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_newyork3.setText("jLabel1");
        add(drone_newyork3);
        drone_newyork3.setBounds(850, 130, 40, 20);

        drone_newyork2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_newyork2.setText("jLabel1");
        add(drone_newyork2);
        drone_newyork2.setBounds(810, 150, 40, 20);

        drone_newyork1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_newyork1.setText("jLabel1");
        add(drone_newyork1);
        drone_newyork1.setBounds(870, 160, 40, 20);

        drone_atlanta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_atlanta1.setText("jLabel1");
        add(drone_atlanta1);
        drone_atlanta1.setBounds(720, 360, 40, 20);

        drone_atlanta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_atlanta2.setText("jLabel1");
        add(drone_atlanta2);
        drone_atlanta2.setBounds(700, 380, 40, 20);

        drone_atlanta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        drone_atlanta3.setText("jLabel1");
        add(drone_atlanta3);
        drone_atlanta3.setBounds(660, 370, 40, 20);

        austin.setText("Austin");
        add(austin);
        austin.setBounds(450, 450, 50, 20);

        drone_austin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        add(drone_austin1);
        drone_austin1.setBounds(470, 450, 40, 20);

        drone_austin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        add(drone_austin2);
        drone_austin2.setBounds(440, 470, 40, 20);

        drone_austin3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/is/mapFrames/drone.jpg"))); // NOI18N
        add(drone_austin3);
        drone_austin3.setBounds(400, 450, 40, 20);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Source City");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 20));

        jLabel2.setText("Destination City");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, 20));

        jPanel1.add(sourceCityjComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, -1));

        startjButton1.setText("Start");
        startjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startjButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(startjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 80, -1));

        jPanel1.add(destinationjComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 150, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null},
                {"", null},
                {"", null},
                {"", null}
            },
            new String [] {
                "Category", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 150, 100));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null},
                {"", null},
                {"", null},
                {"", null}
            },
            new String [] {
                "Category", "Quantity"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 150, 100));
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 70, -1));

        jButton1.setText(">>");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 50, -1));

        infojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Drone", "Source city", "Dest City", "Current Loc", "Weather", "Intensity"
            }
        ));
        jScrollPane2.setViewportView(infojTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 520, 150));

        add(jPanel1);
        jPanel1.setBounds(900, 0, 540, 510);
    }// </editor-fold>//GEN-END:initComponents

    private void startjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startjButton1ActionPerformed
        // TODO add your handling code here:

        Node source = (Node)sourceCityjComboBox1.getSelectedItem();
        Node destination = (Node)destinationjComboBox2.getSelectedItem();
        drone = source.getAvailableDrone();
        p = new Point(source.nodeState.x,source.nodeState.y);
        //defineslope here
        y2 = destination.nodeState.y;
        x2 =  destination.nodeState.x;

        y1 = source.nodeState.y;
        x1 = source.nodeState.x;

        drone.droneLabel.setLocation(p);
        graph.getDrones().add(drone);
        drone.run(window,source, destination, infojTable);
    }//GEN-LAST:event_startjButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atlanta;
    private javax.swing.JLabel austin;
    private javax.swing.JLabel columbus;
    private javax.swing.JLabel denver;
    private javax.swing.JComboBox destinationjComboBox2;
    private javax.swing.JLabel drone_atlanta1;
    private javax.swing.JLabel drone_atlanta2;
    private javax.swing.JLabel drone_atlanta3;
    private javax.swing.JLabel drone_austin1;
    private javax.swing.JLabel drone_austin2;
    private javax.swing.JLabel drone_austin3;
    private javax.swing.JLabel drone_denver1;
    private javax.swing.JLabel drone_denver2;
    private javax.swing.JLabel drone_denver3;
    private javax.swing.JLabel drone_montana1;
    private javax.swing.JLabel drone_montana2;
    private javax.swing.JLabel drone_montana3;
    private javax.swing.JLabel drone_newyork1;
    private javax.swing.JLabel drone_newyork2;
    private javax.swing.JLabel drone_newyork3;
    private javax.swing.JLabel drone_phoenix1;
    private javax.swing.JLabel drone_phoenix2;
    private javax.swing.JLabel drone_phoenix3;
    private javax.swing.JLabel drone_sacramento1;
    private javax.swing.JLabel drone_sacramento2;
    private javax.swing.JLabel drone_sacramento3;
    private javax.swing.JLabel drone_springfield1;
    private javax.swing.JLabel drone_springfield2;
    private javax.swing.JLabel drone_springfield3;
    private javax.swing.JTable infojTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel montana;
    private javax.swing.JLabel newyork;
    private javax.swing.JLabel phoenix;
    private javax.swing.JLabel richmond;
    private javax.swing.JLabel sacramento;
    private javax.swing.JLabel salt_lake;
    private javax.swing.JComboBox sourceCityjComboBox1;
    private javax.swing.JLabel springfield;
    private javax.swing.JButton startjButton1;
    // End of variables declaration//GEN-END:variables
}
