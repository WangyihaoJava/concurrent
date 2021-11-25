package com.example.day1.basic_class_05;

/**
 * 最小前缀树就是 在如果是完全没有走向当前点的路径 就新创建路径指向当前点 如果有 不重复建直到走向没有的点才加上
 * 比如我想直到一个字符串“hello”出现过多少次 就只需要查他的有多少次结尾
 */
public class Code_01_TrieTree {

	public static class TrieNode {
		public int path;//这个节点经过多少次 删除的时候有用 删除的时候减减后如果等于零 说明就没用了
		public int end;//多少次结尾
		public TrieNode[] map;

		public TrieNode() {
			path = 0;
			end = 0;
			map = new TrieNode[26];
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				//对应要去找哪条路 如果当前字符是a返回0 b返回1 c返回2
				index = chs[i] - 'a';
				//说明这条路还没建出来
				if (node.map[index] == null) {
					//放新节点建出来
					node.map[index] = new TrieNode();
				}
				//不管有没有建出来 到这里肯定有了 node往下跑
				node = node.map[index];

				//沿途经过的节点有多少节点划过我
				node.path++;
			}

			//记录有多少以我这个尾节点结尾的
			node.end++;
		}

		public void delete(String word) {
			if (search(word)) {
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					//如果等于1 说明只有一个 直接删除就行了 因为别的路径没有用到 不是共享的
					//如果不等于1 每次减1
					if (node.map[index].path-- == 1) {
						node.map[index] = null;
						return;
					}
					node = node.map[index];
				}
				node.end--;
			}
		}

		public boolean search(String word) {
			if (word == null) {
				return false;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				//根据当前节点找哪条路 如果是a返回0 b返回1 c返回2
				index = chs[i] - 'a';
				//当前节点的路没有 肯定查不出来 说明里面没有
				if (node.map[index] == null) {
					return false;
				}
				node = node.map[index];
			}
			return node.end != 0;
		}

		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.map[index] == null) {
					return 0;
				}
				node = node.map[index];
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		System.out.println(7 % 8);
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));

	}

}
