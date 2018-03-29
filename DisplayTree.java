
public class DisplayTree {
	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(25);
		root.right.left = new Node(22);
		root.right.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);
		displayTree(root, "", false);
	}

	public static void displayTree(Node node, String prefix, boolean isLeft) {
		if (node == null) {
			System.out.println("Empty tree");
			return;
		}
		if (node.right != null) {
			displayTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
		}
		System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);

		if (node.left != null) {
			displayTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
		}
	}

	private static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}
	}
}
