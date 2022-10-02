
//import java.util.Scanner;

public class BSTClassUse {


    public static void main(String[] args) {
        BSTClass tree = new BSTClass() ;
        //Scanner sc = new Scanner(System.in);

        tree.insert(10);
        tree.insert(2);
        tree.insert(12);
        tree.insert(4);
        tree.insert(1);
        tree.insert(11);
        tree.insert(16);

        System.out.println("The BST : ");
        tree.printTree();
      
        tree.delete(16);
        System.out.println("After deleting node 16 : ");
        tree.printTree();
      
        System.out.print("11 present in tree : ");
        if(tree.search(11)) System.out.println("true");
        else System.out.println("false");
    }
}
