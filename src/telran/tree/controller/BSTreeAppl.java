package telran.tree.controller;

import telran.tree.model.BSTree;

public class BSTreeAppl {

	public static void main(String[] args) {
		BSTree<Integer, String> tree = new BSTree<>();
		tree.add(2, "B");
		tree.add(1, "A");
		tree.add(3, "C");
		tree.add(2, "B1");
		tree.add(1, "A1");
		System.out.println(tree.contains(3));
		System.out.println(tree.contains(0));
		System.out.println(tree.get(3));
		System.out.println(tree.get(2));
		System.out.println(tree.get(1));
		tree.traverse((k, v) -> System.out.println(k + " -> " + v));
	}

}
