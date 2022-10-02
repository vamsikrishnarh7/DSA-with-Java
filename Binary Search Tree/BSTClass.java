/*
************************************************************
class BinaryTreeNode<T> {
  T data;
  BinaryTreeNode<T> left, right;
  public BinaryTreeNode(T data){
    this.data = data;
    this.left = null;
    this.right = null;
  }
}
*************************************************************
*/

import java.util.*;

public class BSTClass {
    BinaryTreeNode<Integer> root ;
    static ArrayList<Integer> inlist = new ArrayList<>();
  // function to find inorder
    private static ArrayList<Integer> inorder(BinaryTreeNode<Integer> root, ArrayList<Integer> ans){
        if(root == null) return ans;
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
        return ans;
    }
    // delete helper function
    private static BinaryTreeNode<Integer> delete(BinaryTreeNode<Integer> root,int x){
        if(root == null) return null;
        if(root.data < x){
            BinaryTreeNode<Integer> newRight = delete(root.right,x);
            root.right = newRight;
        }
        if(root.data > x){
            BinaryTreeNode<Integer> newLeft = delete(root.left,x);
            root.left = newLeft;
        }
        if(root.data == x){
            if(root.left == null && root.right == null) return null;
            if(root.left!= null && root.right==null) return root.left;
            if(root.left == null && root.right != null) return root.right;
            if(root.left != null && root.right !=null){
                int max = Collections.min(inorder(root.right,inlist));
                root.data = max;
                root.right = delete(root.right,max);
            }
        }
        return root;
    }
    // insert helper function
    private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, int x){
        if(node == null){
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(x);
            return newNode;
        }
        if(x <= node.data){
            node.left = insert(node.left,x);
        }
        if(x > node.data){
            node.right = insert(node.right,x);
        }
        return node;
    }

    // printTree helper function
    private static void printTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        System.out.print(root.data + ":");
        /*if(root.left!=null) System.out.print("L:"+root.left.data + ",");
        if(root.left ==null) System.out.print("L:" + ",");
        if(root.right != null) System.out.print("R:" + root.right.data);
        if(root.left == null) System.out.print("R:");*/
        if(root.left !=null && root.right != null) System.out.print("L:"+root.left.data + "," + "R:" + root.right.data);
        if(root.left == null && root.right != null) System.out.print("L:," + "R:" + root.right.data);
        if(root.left != null && root.right == null) System.out.print("L:"+root.left.data + "," + "R:");
        if(root.left == null && root.right == null) System.out.print("L:," + "R:");
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }
    // search helper function
    private static boolean search(BinaryTreeNode<Integer> root, int x){
        if(root == null) return false;
        if(root.data == x) return true;
        boolean flag = false;
        if(x < root.data) flag = search(root.left,x);
        else flag = search(root.right,x);
        return flag;
    }
    public void insert(int x){
        root = insert(root,x);
    }
    public void printTree(){
        printTree(root);
    }
    public void delete(int x){
        root = delete(root,x);
    }
    public boolean search(int x){
        return search(root,x);
    }
}
