package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS{
	private final Vertex startVertex;
	private Graph graph;
	
	public BFS(Graph graph, Vertex v) {
		this.graph = graph;
		this.startVertex = v;
	}
	
	public void traverse() {
		HashSet<Vertex> visited = new HashSet<>();
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(startVertex);
		
		while(!queue.isEmpty()) {
			Vertex current = queue.poll();
			visited.add(current);
			System.out.println(current);
			
			for(Vertex neighbor : graph.adjList.get(current)) {
				if(!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
		}
	}
	
	public boolean connected() {
		HashSet<Vertex> visited = new HashSet<>();
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(startVertex);
		int count = 0;
		
		while(!queue.isEmpty()) {
			Vertex current = queue.poll();
			if(!visited.contains(current)) {
				System.out.println("Count bumped on : -> " + current.getData());
				count++;
			}
			visited.add(current);
			System.out.println(current);
			
			for(Vertex neighbor : graph.adjList.get(current)) {
				if(!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
		}
		return count <= 1;
	}
	public boolean pathExists(Vertex src, Vertex dst) {
		System.out.println("from : " + src + " -> " + dst);
		HashSet<Vertex> visited = new HashSet<>();
		Queue<Vertex> q = new LinkedList<>();
		q.add(src);
		
		while(q.size() > 0) {
			Vertex current = q.poll();
			System.out.println(q);
			
			if(current.equals(dst)) return true;
			for(Vertex neighbor : graph.adjList.get(current)) {
				if(!visited.contains(neighbor)) {
					q.add(neighbor);
					visited.add(neighbor);
				}
			}
		}
		
		return false;
	}
}



