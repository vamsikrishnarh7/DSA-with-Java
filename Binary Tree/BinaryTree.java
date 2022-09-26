

public class BinaryTree {
    public static void printTree(BinaryTreeNode<Integer> root){
        //prints the tree with detailed information
        //'L' represents the left child and 'R' represents the right child
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
    public static void main(String[] args) {
        // creating the binary tree nodes using the class BinaryTreeNode
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> rootleft = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> rootright = new BinaryTreeNode<>(3);
        root.left = rootleft;
        root.right = rootright;

        BinaryTreeNode<Integer> tworight = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> threeleft = new BinaryTreeNode<>(5);
        rootleft.right = tworight;
        rootright.left = threeleft;
        //printing the binary tree
        printTree(root);
    }
}
