package neu.is.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathDijkstra {

	public static void computePaths(Node source)
	{
		source.minDistance = 0.0;
		PriorityQueue<Node> nodeQueue = new PriorityQueue<>();
		nodeQueue.add(source);

		while (!nodeQueue.isEmpty()) {
			Node u = nodeQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adj){
				Node v = e.other(u);
				double dist = e.distance;
				double distanceThroughU = u.minDistance + dist;

				if(distanceThroughU < v.minDistance){
					nodeQueue.remove(v);
					v.minDistance = distanceThroughU ;
					v.previous = u;
					nodeQueue.add(v);
				}
			}
		}
	}

	public static List<Node> getShortestPathTo(Node target)
	{
		List<Node> path = new ArrayList<>();
		for (Node node = target; node != null; node = node.previous){
			path.add(node);
		}
		Collections.reverse(path);
		return path;
	}
}
