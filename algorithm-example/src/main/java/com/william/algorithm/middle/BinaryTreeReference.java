package com.william.algorithm.middle;

/**
 * 
 * @author zdpwilliam
 * 1¡¢recursive and divide-and-conquer thinking
 * 2¡¢the smallest cell is a node with left or right
 *
 */
public class BinaryTreeReference {
	
	/**
	 * calculate BinaryTree depth : 
	 * @param tnode
	 * @return
	 */
	public static int depth(BinaryNode tnode) {
		if(tnode == null)
			return 0;
		int leftDepth = depth(tnode.getLeftNode());
		int rigthDepth = depth(tnode.getRightNode());
		return ( leftDepth > rigthDepth ? leftDepth : rigthDepth) + 1;
	}
	
	/**
	 * calculate BinaryTree number of node : 
	 * @param tnode
	 * @return
	 */
	public static int numOfNodes(BinaryNode tnode) {
		if(tnode == null)
			return 0;
		return 1 + numOfNodes(tnode.getLeftNode()) + numOfNodes(tnode.getRightNode());
	}
	
	/**
	 * calculate BinaryTree number of leaf : 
	 * @param tnode
	 * @return
	 */
	public static int numOfleaf(BinaryNode tnode) {
		if(tnode == null)
			return 0;
		
		if(tnode.getLeftNode() == null && tnode.getRightNode() == null)
			return 1;
		
		return numOfleaf(tnode.getLeftNode()) + numOfleaf(tnode.getRightNode());
	}
	
	public static void main(String[] args) {
		//create a binary tree
		BinaryNode n1 = new BinaryNode("1");
		BinaryNode n2 = new BinaryNode("2");
		BinaryNode n3 = new BinaryNode("3");
		BinaryNode n4 = new BinaryNode("4");
		BinaryNode n5 = new BinaryNode("5");
		
		n1.setLeftNode(n2);
		n1.setRightNode(n3);
		n3.setLeftNode(n4);
		n3.setRightNode(n5);
		
		System.out.println("binary tree depth: " + depth(n1));
		System.out.println("binary tree node count: " + numOfNodes(n1));
		System.out.println("binary tree leaf count: " + numOfleaf(n1));
	}
}
