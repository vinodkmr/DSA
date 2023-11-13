package com.ds.vinod.trees;

public class TreeTest {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.inEfficientInsert(10);
        tree.inEfficientInsert(20);
        tree.inEfficientInsert(30);
        tree.inEfficientInsert(40);

        System.out.println("level Order traversal root-leftright-left-right");
        tree.levelOrderTraversal();
        System.out.println("Pre Order traversal, root-left-right");
        tree.preOrderTraversal(tree.getRoot());

        System.out.println("In Order traversal left-root-right");
        tree.inOrderTraversal(tree.getRoot());

      /*  System.out.println("deleting the tree");
        tree.deleteTree(tree.getRoot());

        tree.preOrderTraversal(tree.getRoot());*/

        System.out.println("Element exist "+tree.search(40));

        Tree tree2 = new Tree();
        tree2.inEfficientInsert(10);
        tree2.inEfficientInsert(20);
        tree2.inEfficientInsert(30);
        tree2.inEfficientInsert(401);
        System.out.println("Equal tree "+tree.equals(tree.getRoot(), tree2.getRoot()));
    }
}
