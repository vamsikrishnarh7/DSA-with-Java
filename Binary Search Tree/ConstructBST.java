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
program to construct the binary search tree from the sorted array
it takes no.of nodes and the array elements as input
Sample Input:
7
1 2 3 4 5 6 7
Sample Output:(preorder)
4 2 1 3 6 5 7 
*/

import java.util.Scanner;

public class ConstructBST {

    public static BinaryTreeNode<Integer> buildTree(int[] arr,int size){
        return buildTree(arr,0,size-1);

    }

    public static BinaryTreeNode<Integer> buildTree(int[] arr, int low , int high){
        if(low > high) return null;
        int middle = (low+high)/2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[middle]);
        root.left = buildTree(arr,low,middle-1);
        root.right = buildTree(arr,middle+1,high);
        return root;
    }

    public static void preorder(BinaryTreeNode<Integer> root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.of nodes : ");
        int nodes = sc.nextInt();
        int[] arr = new int[nodes];
        System.out.println("Enter array elements : ");
        for(int i =0 ; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        preorder(buildTree(arr,nodes));
    }
}
