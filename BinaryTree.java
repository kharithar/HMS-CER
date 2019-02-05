//
//// A recursive Java program to calculate the size of the tree 
//  
///* Class containing left and right child of current 
//   node and key value*/
//class Node 
//{ 
//    int data; 
//    Node left, right; 
//  
//    public Node(int item) 
//    { 
//        data = item; 
//        left = right = null; 
//    } 
//} 
//  
///* Class to find size of Binary Tree */
//class BinaryTree 
//{ 
//    Node root; 
//  
//    /* Given a binary tree. Print its nodes in level order 
//       using array for implementing queue */
//    int size() 
//    { 
//        return size(root); 
//    } 
//  
//    /* computes number of nodes in tree */
//    int size(Node node) 
//    { 
//        if (node == null) 
//            return 0; 
//        else
//            return(size(node.left) + 1 + size(node.right)); 
//    } 
//  
//    public static void main(String args[]) 
//    { 
//        /* creating a binary tree and entering the nodes */
//        BinaryTree tree = new BinaryTree(); 
//        tree.root = new Node(1); 
//        tree.root.left = new Node(2); 
//        tree.root.right = new Node(3); 
//        tree.root.left.left = new Node(4); 
//        tree.root.left.right = new Node(5); 
//  
//        System.out.println("The size of binary tree is : "
//                            + tree.size()); 
//    } 
//}



// Java code to Find maximum (or minimum) in  
// Binary Tree 
  
// A binary tree node 
class Node { 
    int data; 
    Node left, right; 
  
public Node(int data) 
    { 
        this.data = data; 
        left = right = null; 
    } 
} 
  
class BinaryTree { 
    Node root; 
  
    // Returns the max value in a binary tree 
    static int findMax(Node node) 
    { 
        if (node == null) 
            return Integer.MIN_VALUE; 
  
        int res = node.data; 
        int lres = findMax(node.left); 
        int rres = findMax(node.right); 
  
        if (lres > res) 
            res = lres; 
        if (rres > res) 
            res = rres; 
        return res; 
    } 
  
    /* Driver program to test above functions */
    public static void main(String args[]) 
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(2); 
        tree.root.left = new Node(7); 
        tree.root.right = new Node(5); 
        tree.root.left.right = new Node(6); 
        tree.root.left.right.left = new Node(1); 
        tree.root.left.right.right = new Node(11); 
        tree.root.right.right = new Node(9); 
        tree.root.right.right.left = new Node(4); 
  
        System.out.println("Maximum element is " + 
                         tree.findMax(tree.root)); 
    } 
} 
  