package com.example.day1.basic_class_05;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 最小生成树算法应用范围一定是无向图
 * 最小生成树算法 一个是现在这个k算法 一个是p算法下一个的 都是生成最小生成树 只是策略不一样
 * 保证所有点是连通的 并且边是最小的
 *
 * k算法以最小权重开始算 每个节点只要没有形成回路就选那个小权重的边 形成回路就不要 连起来的节点就生成一个集合
 */
//undirected graph only
public class Code_05_Kruskal {

	// Union-Find Set
	public static class UnionFind {
		private HashMap<Node, Node> fatherMap;
		private HashMap<Node, Integer> rankMap;

		public UnionFind() {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
		}

		//寻找代表点
		private Node findFather(Node n) {
			Node father = fatherMap.get(n);
			if (father != n) {
				//递归行为 每次会把返回的father 在每次的下面map中put 的时候使用
				father = findFather(father);
			}
			//father就是每次递归返回回来的father
			fatherMap.put(n, father);
			return father;
		}
		//初始化操作 如果想用并查集 应该把数据给我 然后进行初始化操作 甚至可以改成构造方法中做这件事
		public void makeSets(Collection<Node> nodes) {
			fatherMap.clear();
			rankMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				rankMap.put(node, 1);
			}
		}

		public boolean isSameSet(Node a, Node b) {
			return findFather(a) == findFather(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			if (aFather != bFather) {
				int aFrank = rankMap.get(aFather);
				int bFrank = rankMap.get(bFather);
				if (aFrank <= bFrank) {
					fatherMap.put(aFather, bFather);
					rankMap.put(bFather, aFrank + bFrank);
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFrank + bFrank);
				}
			}
		}
	}

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

	public static Set<Edge> kruskalMST(Graph graph) {
		UnionFind unionFind = new UnionFind();
		//所有点变成并查集的小集合
		unionFind.makeSets(graph.nodes.values());
		//按照边的权重组成小根堆 里面放的都是边
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		for (Edge edge : graph.edges) {
			priorityQueue.add(edge);
		}
		Set<Edge> result = new HashSet<>();
		while (!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll();
			//每次从并查集里面弹出一个 如果from和to已经在一个集合了 这个边是不要的 否则是要的
			//为什么在一个集合里面就不要了呢 因为这样就形成回路了
			if (!unionFind.isSameSet(edge.from, edge.to)) {
				result.add(edge);
				//并且把from和to的集合合并在一起
				unionFind.union(edge.from, edge.to);
			}
		}
		return result;
	}
}
