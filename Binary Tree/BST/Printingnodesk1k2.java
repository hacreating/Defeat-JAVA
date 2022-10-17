package binaryTree1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Printingnodesk1k2 {

	// Function for print all the elements with the range k1 k2 in BST
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2)
    {
            if(root == null)
                return;
           else if(root.data >=k1  && root.data <=k2)
           {
               
               elementsInRangeK1K2(root.left,k1,k2);  // because all smaller nodes will be in lkefty so that will be printed first
               System.out.print(root.data+" ");// root itself
               elementsInRangeK1K2(root.right,k1,k2);// all the nodes which are greater the root will be printed then
           }
        else if(root.data < k1)
            elementsInRangeK1K2(root.right,k1,k2);
        else if(root.data >k2)
            elementsInRangeK1K2(root.left,k1,k2);
		}
	
	// to take the input levelwise order
	public static BinaryTreeNode<Integer> takeinputlevelwise()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the root data");
	    
		int rootdata = s.nextInt();
		if(rootdata == -1)
    	{
			return null;
    	}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);
		Queue<BinaryTreeNode<Integer>>q = new LinkedList<>();
		q.add(root);
    	
		while(!q.isEmpty())
		{
			 BinaryTreeNode<Integer> front = q.poll();
			 System.out.println("Enter left child of root"+" "+front.data);
			 int leftdata = s.nextInt();
			 if(leftdata != -1)
			 {
				BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(leftdata);
				q.add(node1);
				front.left = node1;
			 }
			 // for right child
			 System.out.println("Enter right child of root"+" "+front.data);
			 int rightdata = s.nextInt();
			 if(rightdata != -1)
			 {
				BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(rightdata);
				q.add(node2);
				front.right =node2;
			 }
		}
		return root;
     }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeinputlevelwise();
		System.out.println("Enter K1 value");
		int k1 = s.nextInt();
		System.out.println("Enter K2 value");
		int k2 = s.nextInt();
		
		elementsInRangeK1K2(root,k1,k2);

	}

}
