/*
this programs takes the input from user and builds the tree and
prints the tree INORDER,PREORDER,POSTORDER and LEVELORDER forms
Note : enter -1 if no child
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintingTree {
    public static void printLevelWise(BinaryTreeNode<Integer> root){
        //base condition
        if(root == null) return;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> front = queue.poll();
            System.out.print(front.data + "  ");
            if(front.left != null)  queue.add(front.left);
            if(front.right != null) queue.add(front.right);

        }
    }

    public static void printInorder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        //recursive call on leftsubtree
        printInorder(root.left);
        //printing the root data
        System.out.print(root.data+" ");
        //recursive call on rightsubtree
        printInorder(root.right);

    }
    public static void printPreOrder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        //recursive call on leftsubtree
        printPreOrder(root.left);
        //recursive call on rightsubtree
        printPreOrder(root.right);

    }
    public static void printPostOrder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        //recursive call on leftsubtree
        printPostOrder(root.left);
        //recursive call on rightsubtree
        printPostOrder(root.right);
        System.out.print(root.data + " ");

    }

    static Scanner sc = new Scanner(System.in);
    //function to take tree data input
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
        //recursive call for leftsubtree
        root.left = treeInput(false,data,true);
        //recursive call for rightsubtree
        root.right = treeInput(false,data,false);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Enter the tree elements\nNote: enter -1 for null data");
        BinaryTreeNode<Integer> root = treeInput(true,0,true);
        //printing the tree in inorder
        System.out.println("Inorder : ");
        printInorder(root);
        System.out.println();
        //printing the tree in preorder
        System.out.println("Preorder : ");
        printPreOrder(root);
        System.out.println();
        //printing the tree in postorder
        System.out.println("Postorder : ");
        printPostOrder(root);
        System.out.println();
        //printing the tree levelwise
        System.out.println("LevelWise : ");
        printLevelWise(root);


    }
}
