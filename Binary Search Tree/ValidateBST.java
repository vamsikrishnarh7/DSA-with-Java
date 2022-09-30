/*
this program demonstrates to check whether the given binary tree is binary serach tree or not
**************************************************************************************
approach 1:
*get the inorder of binary tree
*if that list is in sorted order, then it is a BST, otherwise not
**************************************************************************************
approach 2:
*checking the range of each node
*/

import java.util.*;

public class ValidateBST {
    static Scanner sc = new Scanner(System.in);
    public static BinaryTreeNode<Integer> treeInput(boolean isRoot, int parentData, boolean isLeft){
        if(isRoot) System.out.println("Enter root element : ");
        else if(isLeft) System.out.println("Enter left child of " + parentData + " : ");
        else System.out.println("Enter right child of " + parentData + " : ");
        int data = sc.nextInt();
        if (data == -1) return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        root.left = treeInput(false,data,true);
        root.right = treeInput(false,data,false);
        return root;
    }
    // Approach 2
//     public static boolean isBST(BinaryTreeNode<Integer> root, int min, int max){
//         if(root == null) return true;
//         if(root.data > min && root.data < max) {
//             return isBST(root.left, min, root.data) & isBST(root.right, root.data, max);
//         }
//         else return false;
//     }

//     public static boolean isBST(BinaryTreeNode<Integer> root){
//         if(root == null) return false;
//         if(root.left == null && root.right == null) return true;
//         return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    // approach 1
    public static ArrayList<Integer> inorder(BinaryTreeNode<Integer> root, ArrayList<Integer> inlist){
        if(root == null) return inlist;
        // recursive call on leftsubtree
        inorder(root.left,inlist);
        // adding the root element to the list
        inlist.add(root.data);
        //recusive call on rightsubtree
        inorder(root.right,inlist);
        return inlist;
    }
    public static boolean isBST(BinaryTreeNode<Integer> root){
        if(root == null) return true;
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorderList = inorder(root,inorderList);
        if(inorderList.size() == 0){
            return true;
        }
        else{
            for(int i =0;i<inorderList.size()-1;i++){
                if(inorderList.get(i) > inorderList.get(i+1)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = treeInput(true,0,true);
        if(isBST(root)){
            System.out.println("Tree is BST");
        }
        else System.out.println("Tree is not a BST");

    }
}
