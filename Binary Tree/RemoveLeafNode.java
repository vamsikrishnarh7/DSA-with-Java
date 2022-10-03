/*
program to remove the leaf nodes in the tree and
to print the mirror image of binary tree
************************************************
Sample Input (levelwise):
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output :
1 
3 2 
7 6 5 4
************************************************
*/

public class RemoveLeafNode {
    public static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root){
        if(root == null) return null;
        if(root.left == null && root.right == null) return null;
        root.left = removeLeaf(root.left);
        root.right = removeLeaf(root.right);
        return root;
    }
    public static void printTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " : ");
        if(root.left!=null) System.out.print("L"+root.left.data + ",");
        if(root.right != null) System.out.print("R" + root.right.data);
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }
    public static void mirrorOfTree(BinaryTreeNode<Integer> root){
        if(root == null) return;
        if(root.left!=null && root.right!=null){
            BinaryTreeNode<Integer> temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        mirrorOfTree(root.left);
        mirrorOfTree(root.right);
    }
    static Scanner sc = new Scanner(System.in);
    public static BinaryTreeNode<Integer> treeInput(boolean isRoot, int parentData, boolean isLeft){
        if(isRoot) System.out.println("Enter root data : ");
        if(isLeft) System.out.println("Enter left child of " + parentData);
        else System.out.println("Enter left child of " + parentData);
        int data = sc.nextInt();
        BinaryTreeInput<Integer> root = new BinaryTreeInput<>(data);
        root.left = treeInput(false,data,true);
        root.right = treeInput(false,data,false);
        return root;
    }
  
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = treeInput(true,0,true);
        System.out.println("Before mirroring : ");
        printTree(root);
        System.out.println("After mirroring : ");
        mirrorOfTree(root);
        printTree(root);

        System.out.println("the tree before removing the leaf nodes : ");
        printTree(root);
        System.out.println("the tree after removing the leaf nodes : ");
        removeLeaf(root);
        
    }
}
