package challenge.coding;

public class CousinsBinaryTree {
	public static void main(String[] args) {
		int x = 5;
		int y = 4;
		CousinsBinaryTree cbt = new CousinsBinaryTree();
		Integer[] treeArray = { 1, 2, 3, null, 4, null, 5 };
		TreeNode root = new TreeNode();
		root = cbt.constructTree(root, treeArray, 0);
		System.out.println(cbt.isCousins(root, x, y));
	}

	private TreeNode constructTree(TreeNode node, Integer[] treeArray, int currentIndex) {
		if (currentIndex < treeArray.length) {
			TreeNode newNode = new TreeNode();
			newNode.val = treeArray[currentIndex];
			node = newNode;
			newNode.left = constructTree(newNode.left, treeArray, 2 * currentIndex + 1);
			newNode.right = constructTree(newNode.right, treeArray, 2 * currentIndex + 2);
		}
		return node;
	}

	private TreeNode xP = null;
	private TreeNode yP = null;
	private int xDepth = -1;
	private int yDepth = -1;

	public boolean isCousins(TreeNode root, int x, int y) {
		figureOut(root, x, y, null, 0);
		return xP != yP && xDepth == yDepth;
	}

	private void figureOut(TreeNode node, int x, int y, TreeNode parent, int depth) {
		if (node == null || node.val == null) {
			return;
		} else if (node.val == x) {
			xDepth = depth;
			xP = parent;
		} else if (node.val == y) {
			yDepth = depth;
			yP = parent;
		} else {
			figureOut(node.left, x, y, node, depth + 1);
			figureOut(node.right, x, y, node, depth + 1);
		}
	}

	public static class TreeNode {
		Integer val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(Integer val) {
			this.val = val;
		}

		TreeNode(Integer val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
