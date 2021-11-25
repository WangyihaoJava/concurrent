package com.example.day1.basic_class_04;

import java.util.HashMap;
import java.util.List;

/**
 * 两个元素是否属于一个集合
 *
 *
 * 用list或者hashset也可以实现 但是代价很高 需要遍历
 * 那么用并查集是怎么做呢 最开始每个元素都指向自己 如果a在b中 a就指向b
 * 如果两个元素往上找都发现是指向b那么 两个元素在同一个集合
 * 也就是 a代 = b代 那么在一个集合
 *
 * 为什么要打平 打平后下一次再查的话代价就没那么高了
 *
 *
 * 合并 需要先查一下issameset就是两个是否在同一个集合 如果不在才需要合并
 * 合并就是把小的集合的头部挂在大的集合头部的底下 就合并完成了（头部也就是代表点）
 *
 *
 *
 */
public class Code_09_UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class DisjointSets {
		//用的是map 的对应关系来表示往上指的过程
		//k v 表示 k的父亲节点 是v 比如（a,b）代表a的父亲是b
		public HashMap<Node, Node> fatherMap;
		//k v k是节点 v是数字 表示如果k是代表节点 v存的是指向k的数量 可以理解为孩子的数量 如果k不是代表点 那么这个信息是无效的
		public HashMap<Node, Integer> rankMap;

		public DisjointSets() {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
		}

		//初始化操作 如果想用并查集 应该把数据给我 然后进行初始化操作 甚至可以改成构造方法中做这件事
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
				//递归行为 每次会把返回的father 在每次的下面map中put 的时候使用
				father = findFather(father);
			}
			//father就是每次递归返回回来的father
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
				//小的代表点挂在大的代表点下面就完成了合并
				if (aFrank <= bFrank) {
					//说明 aFrank小 bFrank大 aFrank小挂在bFrank下面就行了
					fatherMap.put(aFather, bFather);
					//同级代表节点
					rankMap.put(bFather, aFrank + bFrank);
				} else {
					//否则就是bFrank小 aFrank大
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFrank + bFrank);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
