/*
program to print the largest node in the tree
and to print all the nodes greater than the node x
Note : enter -1 if no child
*/

import java.util.Scanner;

public class LargestNode {
    public static int count = 0;
    public static int largestNode(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftLargest = largestNode(root.left);
        int rightLargest = largestNode(root.right);
        return Math.max(root.data, Math.max(leftLargest,rightLargest));
    }
    public static int largestThanX(BinaryTreeNode<Integer> root, int x){
        if(root == null) return 0;
        largestThanX(root.left,x);
        largestThanX(root.right, x);
        if(root.data > x) count++;
        return count;
    }
    static Scanner sc = new Scanner(System.in);
    public static BinaryTreeNode<Integer> treeInput(boolean isRoot, int parentData, boolean isLeft){
        if(isRoot){
            System.out.println("Enter root data : ");
        }
        else if(isLeft){
            System.out.println("Enter left child of "+parentData+" : ");
        }
        else System.out.println("Enter right child of " + parentData + " : ");
        int data = sc.nextInt();
        //base condition
        if(data == -1) return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        root.left = treeInput(false,data,true);
        root.right = treeInput(false,data,false);
        return root;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = treeInput(true,0,true);
        int max = largestNode(root);
        System.out.println("Largest node is : " + max);
        int count = largestThanX(root,5);
        System.out.println("Number of nodes greater than 3 are : "+ count);
    }
}
