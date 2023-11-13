package com.ds.vinod.trees.bst;

import com.ds.vinod.trees.BNode;

public class BST{
    private BNode root;
    private int size;

    public BNode getRoot() {
        return root;
    }

    public void setRoot(BNode root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * BST insertion in a iterative way
     * @param data
     */
    public void insert(int data){
        BNode bNode = new BNode(data);
        if(root == null){
            root = bNode;
            size++;
            return;
        }

       BNode temp = root;
        while (temp != null) {
            if (data < temp.getData()) {
                if (temp.getLeft() == null) {
                    temp.setLeft(bNode);
                    size++;
                    return;
                } else {
                    temp = temp.getLeft();
                }
            } else if (data > temp.getData()) {
                if (temp.getRight() == null) {
                    temp.setRight(bNode);
                    size++;
                    return;
                } else {
                    temp = temp.getRight();
                }
            }
        }
    }

    /**
     * BST insertion in a recursive way
     * @param data
     */
    public void insertRecursive(int data){
        BNode bNode = insert(root, data);
        this.root = bNode;
    }

    private BNode insert(BNode root, int data){
        if(root == null){
            BNode bNode = new BNode(data);
            return bNode;
        }else{
            if(data < root.getData()){
                BNode left = insert(root.getLeft(), data);
                root.setLeft(left);
                return root;
            }else{
                BNode right = insert(root.getRight(), data);
                root.setRight(right);
                return root;
            }
        }
    }

    public boolean search(int data){
        if(root == null) return false;
        if(root.getData() == data) return true;
        BNode temp = root;
        while(temp != null){
            if(data < temp.getData()){
                if(temp.getData() == data) return true;
                temp = temp.getLeft();
            }else{
                if(temp.getData() == data) return true;
                temp = temp.getRight();
            }
        }
        return false;
    }

    public boolean searchRecursive(int data){
        return searchRecursive(data, root);
    }

    private boolean searchRecursive(int data, BNode root){
        if(root == null) return false;
        if(root.getData() == data) return true;
        if(data < root.getData()){
            boolean left = searchRecursive(data, root.getLeft());
            return left;
        }else{
            boolean right = searchRecursive(data, root.getRight());
            return right;
        }
    }

    public int findMin(){
        if(root == null) return -1;
        BNode temp = root;
        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp.getData();
    }

    public int findMax(){
        if(root == null) return -1;
        BNode temp = root;
        while (temp.getRight() !=  null){
            temp = temp.getRight();
        }
        return temp.getData();
    }

    private BNode findMax(BNode root){
        if(root == null) return null;
        BNode temp = root;
        while (temp.getRight() !=  null){
            temp = temp.getRight();
        }
        return temp;
    }

    public void delete(int data){
        delete(root, data);
    }

    //https://youtu.be/P3LAcrJABvI - Code not working properly, check this.
    private BNode delete(BNode root, int data) {
        if(root == null) return null;
        if(data < root.getData()){
            BNode left = delete(root.getLeft(), data);
            root.setLeft(left);
            return left;
        }else if(data > root.getData()){
            BNode right = delete(root.getRight(), data);
            root.setRight(right);
            return right;
        }else{
            if(isLeaf(root)) return null;
            if(root.getLeft() != null && root.getRight() == null) return root.getLeft();
            if(root.getRight() != null && root.getLeft() == null) return root.getRight();
            BNode temp = findMax(root.getLeft());
            root.setData(temp.getData());
            BNode left = delete(root.getLeft(), temp.getData());
            root.setLeft(left);
            return root;
        }
    }

    private boolean isLeaf(BNode root) {
        return root.getLeft() == null && root.getRight() == null;
    }

    public void preOrderTraversal(BNode root){
        if(root == null) return;
        System.out.println(" "+root.getData());
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    private int prev = -1;
    public boolean isBst(BNode root){
        if(root == null) return true;
        boolean left = isBst(root.getLeft());
        if(!left) return left;
        if(prev > root.getData()) return false;
        prev = root.getData();
        System.out.println(root.getData());
        boolean right = isBst(root.getRight());
        return right;
    }

    private int count = 0;
    public BNode kthSmallest(BNode root, int k){
        if(root == null) return null;
        BNode left = kthSmallest(root.getLeft(), k);
        if(left != null) return left;
        count++;
        if(count == k){
            return root;
        }
        BNode right = kthSmallest(root.getRight(), k);
        return right;
    }
}
