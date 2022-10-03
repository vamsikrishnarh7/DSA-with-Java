/*
program to find the path from the root to the given node
*/

import java.util.*;

public class PathToNode {
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

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int x){
        if(root == null) return null;
        ArrayList<Integer> ans = new ArrayList<>();
        if(x == root.data) {
            ans.add(x);
            return ans;
        }
        if(x < root.data) ans = getPath(root.left,x);
        if(x >= root.data) ans = getPath(root.right,x);
        if(ans != null) ans.add(root.data);
        return ans;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = treeInput(true,0,true);
        System.out.println("Enter the node to find it's path : ");
        int x = sc.nextInt();
        ArrayList<Integer> ans = getPath(root,x);
        for(int a : ans){
            System.out.print(a + " ");
        }
    }
}
