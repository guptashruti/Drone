package neu.is.algos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import neu.is.dstarlight.DStarLite;
import neu.is.dstarlight.State;
import neu.is.gui.Cell;
import neu.is.gui.MapGrid;

public class Drone {

    public Node baseCity;
    public Node travelCity;
    public Node intermediateCity;

    public JLabel droneLabel;
    public State currentCell;
    //public Vector<myPoint> paths;
    public int dv;
    public JFrame frame;
    public MapGrid grid;
    public Cell[][] heuristics;
    public boolean isDroneAvailable;
    public boolean topologyChanged;
    private DStarLite pf;
    public List<State> path;
    Random random;
    private State startNode = new State();
    private State endNode = new State();
    private JTable infoTable;
    private MapGraph graph;

    public Drone(JLabel label, MapGrid grid, MapGraph graph) {
        this.droneLabel = label;
        droneLabel.setVisible(false);
        this.isDroneAvailable = true;
        this.grid = grid;
        pf = new DStarLite();
        path=new ArrayList<>();
        this.graph = graph;
    }

    public void run(JFrame mainFrame, Node source, Node destination, JTable infoTable) {
       this.random = new Random();
       this.infoTable = infoTable;
       baseCity = source;
       travelCity = destination;
       droneLabel.setVisible(true);
       startNode.x = baseCity.nodeState.x;
       startNode.y = baseCity.nodeState.y;
       endNode.x = travelCity.nodeState.x;
       endNode.y = travelCity.nodeState.y;
       pf.init(startNode.x,startNode.y,endNode.x ,endNode.y);
      
                   
       pf.replan();
       path = pf.getPath();
       System.out.println("Path returned"+path.size());
//       for (State i : path)
//        {
//            System.out.println("x: " + i.x + " y: " + i.y);
//	}
        //paths = pathFinder.calcShortestPath(baseCityX, baseCityY, travelCityX, travelCityY);
        //paths = result;
        dv = 0;
        frame = mainFrame;
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//here i choose points ok 
                if(path==null){
                    System.out.println("Error : path is null");
                }
                else if(path.size()==0){
                    System.out.println("Error : path size is zero");
                 }else{
                   if(random.nextInt(50)==0){
                       System.out.println("-----------now weather is changing-----------");                      
                       path.clear();//I will clear the old list of paths
                       dv = 0;
                       //List<State> blockedPath = createBlocks(pf,droneLabel.getX(), droneLabel.getY(), endNode.x, endNode.y);
                       pf.updateStart(droneLabel.getX(), droneLabel.getY());
                       List<State> blockedPath = createBlocks2(40,droneLabel.getX(), droneLabel.getY());
                       for(State s: blockedPath){
                           System.out.println("Blocked Path: "+ s.x +", "+ s.y);
                           pf.updateCell(s.x, s.y, -1);
                       }
                       //pf.updateStart(droneLabel.getX(), droneLabel.getY());// This sets my start position to be the current position
                       //goal is still d same so i dont need to change tat.. ok
                       if(pf.replan()){
                           path = pf.getPath();//Now you have the updated path according to ur new topology.. hurray                                                 
                       }else{
                           pf.init(droneLabel.getX(), droneLabel.getY(),endNode.x ,endNode.y);
                           pf.replan();
                           path = pf.getPath();
                       }
                    
                       
                    }
                   if(dv<path.size()){
                       State mp = path.get(dv);
                       //System.out.println("mp::x->"+ mp.x+ " y->"+mp.y);                   
                       droneLabel.setLocation(mp.x, mp.y);                       
                       dv++;
                       frame.repaint();
                       //refreshInfoTable(droneLabel);
                   }
                  else if (dv >= path.size() || path.size()==0) {
                   ((Timer) e.getSource()).stop();                   
                 }                                 
               }
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }
    
    public void refreshInfoTable(JLabel droneLabel){
         int count = infoTable.getRowCount();
        for (int i = count - 1; i >= 0; i--){
            DefaultTableModel dff = (DefaultTableModel) infoTable.getModel();
            dff.removeRow(i);
        }
        for (Drone drone : graph.getDrones()) {
            Object[] orderRow = new Object[6];
            orderRow[0] = droneLabel.getX()+ ","+ droneLabel.getY();            
            orderRow[1] = drone.baseCity;
            orderRow[2] = drone.travelCity;
            orderRow[3] = 0;
            orderRow[4] = 0;
            orderRow[5] = 0;
            ((DefaultTableModel) infoTable.getModel()).addRow(orderRow);
        }
    }
    
    /**Function : createBlocks2
     * @param int Density: defines the line length
     * @param int yCoordinate : defines the axis, where i'll create a parallel line
     */
    public List<State> createBlocks2(int density,int xCoordinate,int yCoordinate){
        List<State> listreturn=new ArrayList<State>();
        for(int i=1;i<=density;i++){//creates a square
            listreturn.add(new State(xCoordinate+i,yCoordinate+10));
            listreturn.add(new State(xCoordinate-i,yCoordinate+10));
            listreturn.add(new State(xCoordinate+i,yCoordinate+density-10));
            listreturn.add(new State(xCoordinate-i,yCoordinate+density-10));
            listreturn.add(new State(xCoordinate+density,yCoordinate+i));
            listreturn.add(new State(xCoordinate-density,yCoordinate+i));
        }
        return listreturn;
    }
    
     public List<State> createBlocks(DStarLite pf, int startX, int startY, int endX, int endY){
        Set<State> droneCurrState = new HashSet<>();
        for(Drone d :  baseCity.getAllActiveDrones()){
            droneCurrState.add(d.currentCell);
        }
        Set<State> listPointReturn=new HashSet<>();// Here i have used a array
        int intensity = random.nextInt(2)+5;// defining intensity
        int dv = Math.abs(endX - startX);
        if(startX > endX){
                dv = -dv;
        }

        int m = (endY - startY)/(endX-startX);
        int c = startY - (m*(startX));

        State weatherSt;
        int divison,addition,newX,newY;
            addition = random.nextInt(dv-1);
            newX = startX + addition;
            newY = (m * newX) + c;
            System.out.println("x:"+newX+" y:"+newY);
            weatherSt = new State();
            weatherSt.x = newX;
            weatherSt.y = newY;
            
            
            listPointReturn.addAll(pf.getSucc(weatherSt));
            listPointReturn.removeAll(droneCurrState);
        System.out.println("blockedList in method::" + listPointReturn.size());
        return new ArrayList<>(listPointReturn);
    }
}
