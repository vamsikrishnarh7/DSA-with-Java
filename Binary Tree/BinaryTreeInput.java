
/*
*this program demonstrates to take input for binary trees
*Each time...this program asks to enter the root data since it treats every left child and
the right child as a tree
*Note : enter -1 to identify there are no children for the root
 */

import java.util.Scanner;

public class BinaryTreeWithInput {
    static Scanner sc = new Scanner(System.in);
    public static BinaryTreeNode<Integer> inputTree(){
        System.out.println("Enter the root data : ");
        int data = sc.nextInt();
        //base condition
        if(data == -1) return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        //recursive call for left subtree
        BinaryTreeNode<Integer> leftChild = inputTree();
        //recursive call for right subtree
        BinaryTreeNode<Integer> rightChild = inputTree();
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
    public static void printTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " : ");
        if(root.left !=null) System.out.print("L"+root.left.data + ",");
        if(root.right != null) System.out.print("R" + root.right.data);
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }
    public static void main(String[] args) {
        System.out.println("Enter the tree elements\nNote: enter -1 for null data");
        BinaryTreeNode<Integer> root = inputTree();
        System.out.println("Printing the binary tree : ");
        printTree(root);
    }
}
