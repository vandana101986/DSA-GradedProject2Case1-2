package com.gl.Driver;

class Node
{
	int key;
	Node left;
	Node right;
	
	Node(int data)
	{
		key = data;
		left = null;
		right = null;
	}
}
class RightSkewedTree
{
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void convertToRightSkew(Node root)
	{
	
		// Base Case
		if(root == null)
		{
			return;
		}
	
		convertToRightSkew(root.left);
		
		Node rightNode = root.right;
		
		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		convertToRightSkew(rightNode);		
	}


	static void traverseRightSkewed(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.key + " ");
		traverseRightSkewed(root.right);	
	}

	// Driver Code
	public static void main (String[] args)
	{
		RightSkewedTree tree = new RightSkewedTree();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left= new Node(55);


		convertToRightSkew(node);
		traverseRightSkewed(headNode);
	}
}


