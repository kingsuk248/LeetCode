package challenge.coding;

public class BinarySearchTreeFromPreOrder {
	public static void main(String[] args) {
		BinarySearchTreeFromPreOrder bstfp = new BinarySearchTreeFromPreOrder();
		int[] input = { 8, 5, 1, 7, 10, 12 };
		TreeNode root = bstfp.bstFromPreorder(input);
		System.out.println(root.val);
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		return constructTree(preorder, preorder.length);
	}

	private TreeNode constructTree(int[] preorder, int size) {
		return constructTreeUtil(preorder, index, 0, size - 1, size);
	}

	private TreeNode constructTreeUtil(int[] preorder, Index preorderArrayIndex, int start, int end, int size) {
		// Base case
		if (start > end || preorderArrayIndex.index >= size) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preorderArrayIndex.index]);
		preorderArrayIndex.index = preorderArrayIndex.index + 1;
		if (start == end) {
			return root;
		}
		int i;
		for (i = start; i <= end; ++i) {
			if (preorder[i] > root.val) {
				break;
			}
		}
		root.left = constructTreeUtil(preorder, preorderArrayIndex, preorderArrayIndex.index, i - 1, size);
		root.right = constructTreeUtil(preorder, preorderArrayIndex, i, end, size);
		return root;
	}

	Index index = new Index();

	public static class Index {
		int index = 0;
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
