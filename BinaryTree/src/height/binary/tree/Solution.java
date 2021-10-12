/***********************************************************************************************************************************************************************************
* Tree: Height of a Binary Tree
* The height of a binary tree is the number of edges between the tree's root and its furthest leaf. For example, the following binary tree is of height 2:
* Function Description:
*
* Complete the getHeight or height function in the editor. It must return the height of a binary tree as an integer.
*
* getHeight or height has the following parameter(s):
* 
* root: a reference to the root of a binary tree.
* Note -The Height of binary tree with single node is taken as zero.
* 
* Input Format
* 
* The first line contains an integer "n", the number of nodes in the tree.
* Next line contains "n" space separated integer where "i"th integer denotes node[i].data.
* 
* Note: Node values are inserted into a binary search tree before a reference to the tree's root node is passed to your function. In a binary search tree, all nodes on the left branch of a node are less than the node value.
* All values on the right branch are greater than the node value.
* 
* Constraints
* 1 <= node.data[i] <= 20
* 1 <= n <= 20
* 
* Output Format:
* 
* Your function should return a single integer denoting the height of the binary tree.
**********************************************************************************************************************************************************************************/
package height.binary.tree;
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

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {

    int leftHeight = 0;
    int rightHeight = 0;

    if (root.left != null) {
        leftHeight = 1 + height(root.left);
    }

    if (root.right != null) {
        rightHeight = 1 + height(root.right);
    }

    return leftHeight > rightHeight ? leftHeight : rightHeight;
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
        int height = height(root);
        System.out.println(height);
    }	
}