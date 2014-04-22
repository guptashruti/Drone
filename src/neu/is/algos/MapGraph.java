package neu.is.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapGraph {

	private int capacityOfDrones;
	private ArrayList<Node> nodes;
        private List<String> productCategory;
        private List<Drone> drones;
	
        public MapGraph(){
            nodes = new ArrayList<>();
            drones = new ArrayList<>();
            productCategory = new ArrayList<>(Arrays.asList("Medication","Food","Clothes","Grocery"));
        }

        public List<String> getProductCategory() {
            return productCategory;
        }

        public void setProductCategory(List<String> productCategory) {
            this.productCategory = productCategory;
        }
        public int getCapacityOfDrones() {
		return capacityOfDrones;
	}
	public void setCapacityOfDrones(int capacityOfDrones) {
		this.capacityOfDrones = capacityOfDrones;
	}	
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
        public List<Drone> getDrones() {
            return drones;
        }

        public void setDrones(List<Drone> drones) {
            this.drones = drones;
        }
}
