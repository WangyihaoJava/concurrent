package com.example.day1.basic_class_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 就是先编译那个后编译哪个 先编译被依赖的那个就能编译下一个
 * 前提是有向图 无向图有环的
 * 每次把没有指向该节点的删掉 删掉后会有新的没有被指向的 依次把这些删掉 每次删的时候打印出来 按照这种就是拓扑排序
 *
 */
public class Code_04_TopologySort {

	// directed graph and no loop
	public static List<Node> sortedTopology(Graph graph) {
		HashMap<Node, Integer> inMap = new HashMap<>();
		Queue<Node> zeroInQueue = new LinkedList<>();
		//把所有点的入渡登记在map中
		for (Node node : graph.nodes.values()) {
			inMap.put(node, node.in);
			if (node.in == 0) {
				zeroInQueue.add(node);
			}
		}
		List<Node> result = new ArrayList<>();
		while (!zeroInQueue.isEmpty()) {
			Node cur = zeroInQueue.poll();
			result.add(cur);
			for (Node next : cur.nexts) {
				//相当于删掉依赖为零的节点 删完会出现新的为零的点 循环直到最后一个
				inMap.put(next, inMap.get(next) - 1);
				if (inMap.get(next) == 0) {
					zeroInQueue.add(next);
				}
			}
		}
		return result;
	}
}
