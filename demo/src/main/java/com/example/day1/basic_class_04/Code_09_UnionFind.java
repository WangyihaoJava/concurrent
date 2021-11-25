package com.example.day1.basic_class_04;

import java.util.HashMap;
import java.util.List;

/**
 * 两个元素是否属于一个集合
 * 合并
 *
 * 用list或者hashset也可以实现 但是代价很高 需要遍历
 * 那么用并查集是怎么做呢 最开始每个元素都指向自己 如果a在b中 a就指向b
 * 如果两个元素往上找都发现是指向b那么 两个元素在同一个集合
 * 也就是 a代 = b代 那么在一个集合
 *
 * 为什么要打平 打平后下一次再查的话代价就没那么高了
 */
public class Code_09_UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class DisjointSets {
		public HashMap<Node, Node> fatherMap;
		public HashMap<Node, Integer> rankMap;

		public DisjointSets() {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
		}

		public void makeSets(List<Node> nodes) {
			fatherMap.clear();
			rankMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				rankMap.put(node, 1);
			}
		}

		public Node findFather(Node n) {
			Node father = fatherMap.get(n);
			if (father != n) {
				father = findFather(father);
			}
			fatherMap.put(n, father);
			return father;
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			//寻找代表点
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			//如果两个不在一个集合里面 我才给你合并
			if (aFather != bFather) {
				int aFrank = rankMap.get(aFather);
				int bFrank = rankMap.get(bFather);
				//小的挂在大的下面
				if (aFrank <= bFrank) {
					fatherMap.put(aFather, bFather);
					//同级代表节点
					rankMap.put(bFather, aFrank + bFrank);
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFrank + bFrank);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
