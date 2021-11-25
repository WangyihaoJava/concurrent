package com.example.day1.basic_class_05;

//生成图
public class GraphGenerator {

	public static Graph createGraph(Integer[][] matrix) {
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			Integer from = matrix[i][0];
			Integer to = matrix[i][1];
			Integer weight = matrix[i][2];

			//建立from节点
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			//建立to节点
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}

			//建立from 和 to 的边
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);
			fromNode.nexts.add(toNode);
			fromNode.out++;
			toNode.in++;
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);
		}
		return graph;
	}

}
