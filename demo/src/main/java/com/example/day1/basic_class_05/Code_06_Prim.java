package com.example.day1.basic_class_05;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 从一个节点开始相邻的边都是可以解锁的点 选择一个边最小的边进行解锁点 看这个点是不是新出现的 如果是就要 依次往下考察 解锁 直到所有的点都被解锁
 *
 *
 * 我们总是用一个大集合 让新节点加进来所以用hashset就可以 不需要并查集 k算法需要并查集是因为他需要比较两个集合是否需要合并(一个边的引入 出现两个点 两个点各自的集合 是否在一个并查集 是就连在一起了)
 */
// undirected graph only
public class Code_06_Prim {

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

	public static Set<Edge> primMST(Graph graph) {
		//优先级队列和k算法一个 里面放的边 小根堆
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		HashSet<Node> set = new HashSet<>();
		Set<Edge> result = new HashSet<>();
		for (Node node : graph.nodes.values()) {
			//不在集合里面
			if (!set.contains(node)) {
				//node加集合里面
				set.add(node);
				//node所有的边加在优先级队列
				for (Edge edge : node.edges) {
					priorityQueue.add(edge);
				}
				while (!priorityQueue.isEmpty()) {
					//从队列弹出最小的边
					Edge edge = priorityQueue.poll();
					Node toNode = edge.to;
					//这个tonode是否已经加进set了
					if (!set.contains(toNode)) {
						//不在加进来
						set.add(toNode);
						result.add(edge);
						//重新解锁新的边 就是往优先级队列加这个新的tonode的边
						for (Edge nextEdge : node.edges) {
							priorityQueue.add(nextEdge);
						}
					}
				}
			}
		}
		return result;
	}

}
