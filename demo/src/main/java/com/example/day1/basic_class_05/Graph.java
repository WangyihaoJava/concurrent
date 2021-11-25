package com.example.day1.basic_class_05;

import java.util.HashMap;
import java.util.HashSet;
//图
public class Graph {
	//k点的编号 v实际的边
	public HashMap<Integer,Node> nodes;//点的集合
	public HashSet<Edge> edges;//边的集合

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
