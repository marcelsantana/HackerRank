/*
 * Given a pointer to the root of a binary tree, you need to print the level order traversal of this tree. 
 * In level-order traversal, nodes are visited level by level from left to right. 
 * Complete the function LevelOrder and print the values in a single line separated by a space.
 * 
 * https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
 * 
 */
package tree.level.order.transversal;
import java.util.*;
import java.io.*;

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class Solution {


	public static void levelOrder(Node root)
	{
		Node node = root;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(node); 
		while (queue.size() != 0)
		{
			int s = queue.poll().data;
			System.out.print(s + " ");

			if(node.left != null) {
				queue.add(node.left);
			}

			if(node.right != null) {
				queue.add(node.right);
			}   
			node = queue.peek();
		}       
	}


	public static Node insert(Node root, int data) {
		if(root == null) {
			return new Node(data);
		} else {
			Node cur;
			if(data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while(t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}

		scan.close();
		levelOrder(root);
	}
}