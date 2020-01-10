package homework3;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public List<Integer> getValsBetween(Node n, int low, int high) {
		List<Integer> out = new ArrayList<Integer>();
		getValsHelper(n, low, high, out);
		return out;

	}

	private void getValsHelper(Node n, int low, int high, List<Integer> l) {
		if (n == null) {
			return;
		}
		if (n.val < high) {
			if (n.val >= low) {
					l.add(n.val);
					getValsHelper(n.right, low, high, l);
			}
		}
		getValsHelper(n.left, low, high, l);
	}
	
	
	public static void main(String args[]) {
		Node tree = new Node(5, new Node(3, new Node(1), new Node(4)), new Node(7, new Node(6), new Node(8)));
		Test t = new Test();
		System.out.println(t.getValsBetween(tree, 1,6));
	}

}
class Node {
	int val;
	Node right;
	Node left;
	Node(int val) {
		this.val = val;
	}
	Node(int val, Node left, Node right) {
		this.val = val;
		this.right = right;
		this.left = left;
	}
}
