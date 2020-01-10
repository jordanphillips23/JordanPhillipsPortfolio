
public class SearchTreeSort {
	
	public static int[] TreeSort(int[] arr) {
		if (arr.length < 2) {
			return arr;
		}
		
		TreeNode root = new TreeNode(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			
		}
		return new int[0];
	}
	
	private static void insert(TreeNode node, int val) {
		if (val > node.val) {
			if (node.right == null) {
				node.right = new TreeNode(val, node);
			}
			else {
				insert(node.right, val);
			}
		}
		else {
			if (node.left == null) {
				node.left = new TreeNode(val, node);
			}
			else {
				insert(node.left, val);
			}
		}
	}
	
	private static void balance(TreeNode node) {
		int r = getDepth(node.right);
		int l = getDepth(node.left);
		if (l > r + 1) {
			rotateRight(node);
		}
		else if (r > l + 1) {
			rotateLeft(node);
		}
		if (node.parent != null) {
			balance(node.parent);
		}
	}
	
	
	private static void rotateRight(TreeNode node) {
		TreeNode y = node.right;
		TreeNode par = node.parent;
		node.parent = node;
		node.parent = par.parent;
		node.right = par;
		
		
	}
	
	private static int getDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		else {
			int r = getDepth(node.right);
			int l = getDepth(node.left);
			return 1 + ((r > l)? r : l);
		}
	}
	

	
	private static class TreeNode {
		int val;
		TreeNode right;
		TreeNode left;
		TreeNode parent;
		
		public TreeNode(int n, TreeNode parent) {
			val = n;
			this.parent = parent;
		}
		
	}
}


