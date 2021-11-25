package com.example.day1.basic_class_05;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 宽度优先遍历 广度优先遍历
 * 离中间那么节点最近的先输出 同一层的谁先输出谁后输出无所谓
 */
public class Code_02_BFS {

	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		//进过队列的就保留进来
		HashSet<Node> map = new HashSet<>();
		queue.add(node);
		map.add(node);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			//每次弹出就打印
			System.out.println(cur.value);
			//当前节点所有子节点没有加入到队列的都加入进去 通过next找到下一级的邻居
			for (Node next : cur.nexts) {
				//忽略已经进过队列的
				if (!map.contains(next)) {
					map.add(next);
					queue.add(next);
				}
			}
		}
	}

}
