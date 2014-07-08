package ca.uwaterloo.comsec.leet.solutions.p8BinaryTreePreorder;

import ca.uwaterloo.comsec.leet.solutions.p7BinaryTreePostorder.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
		TreeNode tmp;
		if(root == null)
			return ret;
		stack.add(root);
		while(!stack.isEmpty()) {
			tmp = stack.remove(0);
			ret.add(tmp.val);
			if(tmp.right != null)
				stack.add(0, tmp.right);
			if(tmp.left != null)
				stack.add(0, tmp.left);
			
		}
		return ret;
    }
}