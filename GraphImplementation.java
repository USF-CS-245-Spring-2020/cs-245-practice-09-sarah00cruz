import java.util.*;

public class GraphImplementation implements Graph{
	
	public List<Integer> sorted;
	public int[][] graph;
	public int size;

	//constructor
	public GraphImplementation(int vertices) {
		size = vertices;
		graph = new int[size][size];
		sorted = new ArrayList<>();
	}

	//looks through vertices and adds the marked ones to n arr
	public List<Integer> topologicalSort() {
		int[] n = new int[size];
		for (int k=0; k<size; k++) {
			for (int i=0; i<size; i++) {
				if (graph[i][k] == 1)
					n[k]++;
			}
		}

		while (sorted.size() != size) {
			for (int i=0; i<n.length; i++) {
				if (n[i] == 0) {
					sorted.add(i);
					n[i] = -1;
					for (int k=0; k<size; k++) {
						if (graph[i][k] != 0) 
							n[k]--;
					}
				}
			}
		}return sorted;
	}

	//add the neighbors, check it with a 1
	public List<Integer> neighbors(int vertex) throws Exception {
		if (vertex >= size) {
			throw new Exception();
		}
		List<Integer> neighbors = new ArrayList<>();
		for (int i=0; i<graph.length; i++) {
			if (graph[vertex][i] == 1)
				neighbors.add(i);
		}
		return neighbors;
	}

	//puttinr a new edge on the graph with 1 by wanted vertices
	public void addEdge(int v1, int v2) throws Exception {
		if (v1>=size || v2>=size) 
			throw new Exception();
		graph[v1][v2] = 1;
	}
}