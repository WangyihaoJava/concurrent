package com.example.day1.basic_class_05;

import java.util.ArrayList;

public class Node {
	public int value;
	public int in;//入度 有多少节点指向我
	public int out;//出度 我指向多少个节点
	public ArrayList<Node> nexts;//从我出发到达的下一个节点
	public ArrayList<Edge> edges;//从我出发发散出的边的集合

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
