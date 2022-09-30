/*
program to print nodes at depth k of the tree and 
replace each node with it's depth
*/
import java.util.Scanner;

public class DepthOfNode {
    public static void nodesAtDepthK(BinaryTreeNode<Integer> root, int k){
        if(root == null) return;
        if(k == 0 ){ System.out.println(root.data); return;}
        nodesAtDepthK(root.left,k-1);
        nodesAtDepthK(root.right,k-1);
    }

    public static void replaceWithDepth(BinaryTreeNode<Integer> root, int depth){
        if(root.left == null & root.right == null){root.data = depth; return;}
        if(root.left!=null) replaceWithDepth(root.left,depth+1);
        if(root.right!=null) replaceWithDepth(root.right,depth+1);
        root.data = depth;
    }


    public static void printTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }
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

    public static void main(String[] args) {
        
        System.out.println("Enter the tree elements\nNote: enter -1 for null data");
        BinaryTreeNode<Integer> root = treeInput(true,0,true);
        replaceWithDepth(root,0);

        System.out.println("nodes at depth 2 : ");
        nodesAtDepthK(root,2);
      
      
        System.out.println("Tree after replacing each node with corresponding depth (inorder) : ");
        printTree(root);
    }
}
