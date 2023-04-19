package telran.tree.model;

import java.util.function.BiConsumer;

public class BSTree<K extends Comparable<K>, V> {
	private Node<K, V> root;

	public void add(K key, V value) {
		if (root == null) {
			root = new Node<>(key, value);
		} else {
			add(root, key, value);
		}
	}

	private void add(Node<K, V> curRoot, K key, V value) {
		if (key.compareTo(curRoot.key) <= 0) {
			if (curRoot.left == null) {
				curRoot.left = new Node<>(key, value);
			} else {
				add(curRoot.left, key, value);
			}
		} else {
			if (curRoot.right == null) {
				curRoot.right = new Node<>(key, value);
			} else {
				add(curRoot.right, key, value);
			}
		}
	}

	public boolean contains(K key) {
		return search(root, key) != null;
	}

	public V get(K key) {
		Node<K, V> node = search(root, key);
		return node == null ? null : node.value;
	}

	private Node<K, V> search(Node<K, V> curRoot, K key) {
		if (curRoot == null || curRoot.key.compareTo(key) == 0) {
			return curRoot;
		}
		if (key.compareTo(curRoot.key) <= 0) {
			return search(curRoot.left, key);
		} else {
			return search(curRoot.right, key);
		}
	}

	public void traverse(BiConsumer<K, V> biConsumer) {
		traverse(root, biConsumer);
	}
	
	private void traverse(Node<K,V> curRoot, BiConsumer<K, V> biConsumer) {
		if(curRoot == null) {
			return;
		}
		traverse(curRoot.left, biConsumer);
		biConsumer.accept(curRoot.key, curRoot.value);
		traverse(curRoot.right, biConsumer);
	}

	private static class Node<K, V> {
		K key;
		V value;
		Node<K, V> left;
		Node<K, V> right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

}
