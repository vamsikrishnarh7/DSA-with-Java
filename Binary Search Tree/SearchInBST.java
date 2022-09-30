/*
**********************************
public class BinaryTreeNode <T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
***********************************
program to demonstrate searching in binary search tree
it gives output as 'true' if the requested element is present in tree otherwise 'false'
*/
import java.util.Scanner;

public class SearchInBST {
    static Scanner sc = new Scanner(System.in);
    public static BinaryTreeNode<Integer> treeInput(boolean isRoot,int parentData, boolean isLeft){
        if(isRoot){
            System.out.println("Enter root data : ");
        }
        else if(isLeft){
            System.out.println("Enter left child of : " + parentData);
        }
        else System.out.println("Enter right child of : " + parentData);
        int data = sc.nextInt();
        //base condition
        if(data == -1) return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        root.left = treeInput(false,data,true);
        root.right = treeInput(false,data,false);
        return root;
    }

    public static boolean search(BinaryTreeNode<Integer> root, int x){
        if(root == null) return false;
        else if(root.data == x) return true;
        boolean left = false ,right = false;
        if(x < root.data) {
            left = search(root.left , x);
        }
        if(x > root.data) {
            right = search(root.right, x);
        }
        return right | left;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = treeInput(true,0,true);
        System.out.println("Enter an element to search : ");
        int x = sc.nextInt();
        if(search(root,x)){
            System.out.println("true");
        }
        else System.out.println("false");
    }
}
