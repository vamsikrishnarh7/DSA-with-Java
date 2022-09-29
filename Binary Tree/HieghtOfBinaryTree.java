/*
Note: Height of root node is '1'
program to print the height of the binary tree and
check whether the tree is balanced or not
and to print the diameter of the tree
 */
package com.dsa.bitree;

public class HeightOfTree {
    public static int heightOfT(BinaryTreeNode<Integer> root){
        if(root == null) return 0;
        int left_height = heightOfT(root.left);
        int right_height = heightOfT(root.right);
        return 1+Math.max(left_height,right_height);
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root){
        if(root == null )return true;
        int leftHeight = heightOfT(root.left);
        int rightHeight = heightOfT(root.right);
        if(Math.abs(leftHeight - rightHeight)>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    //Better time complexity O(n).
    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root){
        if(root==null){
            int height= 0;
            boolean isBal= true;
            BalancedTreeReturn ans= new BalancedTreeReturn();
            ans.height= height;
            ans.isBalanced= isBal;
            return ans;
        }
        BalancedTreeReturn leftOutput= isBalancedBetter(root.left);
        BalancedTreeReturn rightOutput= isBalancedBetter(root.right);
        boolean isBal= true;
        int height= 1+Math.max(leftOutput.height, rightOutput.height);

        if(Math.abs(leftOutput.height-rightOutput.height)>1){
            isBal= false;
        }
        if(!leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal=false;
        }
        BalancedTreeReturn ans= new BalancedTreeReturn();
        ans.height= height;
        ans.isBalanced= isBal;
        return ans;
    }
    public static int diameter(BinaryTreeNode<Integer> root){
        //base condition
        if(root == null ) return 0;
        int leftdia = diameter(root.left);
        int rightdia = diameter(root.right);
        int dia = heightOfT(root.left) + heightOfT(root.right) + 1;
        return Math.max(dia, Math.max(leftdia,rightdia));
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
        if(data == -1) return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        BinaryTreeNode<Integer> leftChild = treeInput(false,data,true);
        BinaryTreeNode<Integer> rightChild = treeInput(false,data,false);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = treeInput(true,0,true);
        height = heightOfT(root);
        System.out.println("The height of the tree : "+height);
        //printing whether the tree balanced or not
        if(isBalanced(root)) System.out.println("The tree is balanced");
        else System.out.println("Tree is not balanced");*/
        int ans = diameter(root);
        System.out.println("The diameter of the tree is : " + ans);

    }
}
