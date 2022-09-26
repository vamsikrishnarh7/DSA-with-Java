/*
a binary tree node contains the data along with the addresses of 
it's left child and right child
*/
public class BinaryTreeNode <T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    public BinaryTreeNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
