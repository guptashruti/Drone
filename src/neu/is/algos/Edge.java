package neu.is.algos;

public class Edge {
	
	public double distance;
	private Node one;
	private Node other;	
	
        @SuppressWarnings("LeakingThisInConstructor")
        public Edge(Node source, Node target, double dist){
            one = source;
            other = target;
            distance = dist;
            other.adj.add(this);
            one.adj.add(this);
        }

	public Node either(){
		return one;
	}
	
	public Node other(Node node){
		if(node == one){ return other;}
		else return one;
	}

}
