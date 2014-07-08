package ca.uwaterloo.comsec.leet.solutions.p7BinaryTreePostorder;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ArrayList<TreeNode> stack0 = new ArrayList<TreeNode>(), stack1 = new ArrayList<TreeNode>();
		TreeNode tmp;
		if(root == null)
			return ret;
		stack0.add(root);
		while(!stack0.isEmpty()) {
			tmp = stack0.remove(0);
			ret.add(0, tmp.val);
			if(tmp.left != null)
				stack0.add(0, tmp.left);
			if(tmp.right != null)
				stack0.add(0, tmp.right);
		}
		return ret;
	}
}