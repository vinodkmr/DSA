package com.ds.vinod.trees.bst;

import com.ds.vinod.trees.BNode;

public class BSTTest {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(30);
        bst.insert(40);

        boolean search = bst.search(40);
        System.out.println("found ? "+search);

        boolean searchRec = bst.searchRecursive(400);
        System.out.println("found ? "+searchRec);

        int min = bst.findMin();
        System.out.println("min "+min);

        int max = bst.findMax();
        System.out.println("max "+max);

        System.out.println("Pre order traversal");
        bst.preOrderTraversal(bst.getRoot());

        System.out.println("Is BST Call");
        boolean isBST = bst.isBst(bst.getRoot());
        System.out.println("is BST "+isBST);
//        bst.delete(40);

        System.out.println("KTH smallest");
        BNode bNode = bst.kthSmallest(bst.getRoot(), 4);
        System.out.println(bNode.getData());


    }
}
