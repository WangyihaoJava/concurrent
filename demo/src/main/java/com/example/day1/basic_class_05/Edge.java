package com.example.day1.basic_class_05;

//边
public class Edge {
	public int weight;//边的权重
	public Node from;//边的开始节点
	public Node to;//边的结束节点

	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

}
