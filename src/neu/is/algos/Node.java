package neu.is.algos;

import java.awt.Point;
import java.util.ArrayList;
import neu.is.dstarlight.State;
import neu.is.gui.MapGrid;

public class Node implements Comparable<Node> {

    public String name;
    public ArrayList<Edge> adj;
    public ArrayList<Drone> drones;
    public ArrayList<Product> products;
    public State nodeState;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Node previous = null;

    public Node(MapGraph g,String nodeName,Point loc, MapGrid grid){
        name = nodeName ;
        nodeState = grid.getStateFromGrid(loc.x, loc.y);
        adj = new ArrayList<>();
        drones = new ArrayList<>();        
        products = new ArrayList<>();
        for(String s: g.getProductCategory()){
           products.add(new Product(s));
        }
    }
    public void addProductsToNode(String prodCategory, int quantity){
        for(Product p: products){
            if(p.getCategory().equals(prodCategory)){
                p.setQuantity(p.getQuantity()+quantity);
            }
        }
    }
    
    public Drone getAvailableDrone(){
        for(Drone d: drones){
            if(d.isDroneAvailable){
                d.isDroneAvailable = false;
                return d;
            }
        }
        return null;
    }
    
    public ArrayList<Drone> getAllActiveDrones(){
        ArrayList<Drone> activeDrones = new ArrayList<>();
        for(Drone d: drones){
            if(!d.isDroneAvailable){                
                activeDrones.add(d);
            }
        }
        return activeDrones;
    }
    
    @Override
    public String toString(){
        return name;
    }        

    @Override
    public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return Double.compare(minDistance, node.minDistance);
    }	
	
}
