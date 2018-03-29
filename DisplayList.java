public class DisplayList {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		displayList(head);
	}
  
	public static void displayList(Node node) {
		while (node != null && node.next != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		if (node != null) {
			System.out.println(node.data);
		} else {
			System.out.println("Empty LinkedList");
		}
	}
  
	private static class Node {
		private int data;
		private Node next;
		public Node(int data) {
			this.data = data;
		}
	}
}
