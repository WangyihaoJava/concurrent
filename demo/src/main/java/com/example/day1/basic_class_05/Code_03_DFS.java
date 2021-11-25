package com.example.day1.basic_class_05;

import java.util.HashSet;
import java.util.Stack;

/**
 * 深度优先遍历
 * 对于任何一个节点 你的所有路可达的节点都走完才回到父
 */
public class Code_03_DFS {

	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		//上来就打印
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			//从栈中弹出一个 第一次就是刚刚加进来的
			Node cur = stack.pop();
			//从第一个开始遍历他的后续
			for (Node next : cur.nexts) {
				//如果他的任何一个孩子存在一个没走过的 进行注册
				if (!set.contains(next)) {
					//先将当前放进来 在放下一级的
					stack.push(cur);
					stack.push(next);
					set.add(next);
					//下一级的放进来就打印
					System.out.println(next.value);
					break;
				}
			}
		}
	}

}
