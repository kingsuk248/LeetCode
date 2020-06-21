package challenge.coding.june;

public class InvertBinaryTree {
	public static void main(String[] args) {
		InvertBinaryTree ibt = new InvertBinaryTree();
		TreeNode root = null;
		root = ibt.constructTree(root);
		ibt.inOrder(root);
		ibt.invertTree(root);
	}

	private TreeNode constructTree(TreeNode root) {
		root = new TreeNode();
		root.val = 4;
		TreeNode left1 = new TreeNode();
		left1.val = 2;
		TreeNode right1 = new TreeNode();
		right1.val = 7;
		TreeNode left2 = new TreeNode();
		left2.val = 1;
		TreeNode right2 = new TreeNode();
		right2.val = 3;
		root.left = left1;
		root.right = right1;
		left1.left = left2;
		left1.right = right2;
		TreeNode left3 = new TreeNode();
		left3.val = 6;
		TreeNode right3 = new TreeNode();
		right3.val = 9;
		right1.left = left3;
		right1.right = right3;
		return root;
	}
	
	private void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.val);
		inOrder(node.right);
	}

	public TreeNode invertTree(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		invertTree(node.left);
		invertTree(node.right);
		return node;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
