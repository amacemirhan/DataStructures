/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yods;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author amacemirhan
 */
public class BinarySearchTree {


    public static class Node {

        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }
    public Node root;
    public String OrderSonuc = "";

    public BinarySearchTree() {

    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public void insert(int value) {
        this.root = insert(root, value);
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        } else if (root.value >= value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public Node deleteNode(Node root, Node node) {//Aldigi root nodunun agacinda node nodunun degerini agactan siliyor

        if (root == null) {
            return null;
        } else if (node.value < root.value) {
            root.left = deleteNode(root.left, node);
        } else if (node.value > root.value) {
            root.right = deleteNode(root.right, node);
        } else if (root.value == node.value) {

            if (root.left != null && root.right != null) {
                int lmax = findMax(root.left);
                root.value = lmax;
                root.left = deleteNode(root.left, new Node(lmax));
                return root;
            } else if (root.left != null) {
                return root.left;
            } else if (root.right != null) {
                return root.right;
            } else {
                return null;
            }
        }
        return null;
    }
    
    
    
    public void postOrder(Node root) {//recursive gezinme
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            OrderSonuc += (root.value+" ");
            //System.out.println(root.value);
        }
    }
    public void preOrder(Node root) {//recursive gezinme
        if (root != null) {
            OrderSonuc += (root.value+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void InOrder(Node root) {//recursive gezinme
        if (root != null) {
            InOrder(root.left);
            OrderSonuc += (root.value+" ");
            InOrder(root.right);
            
        }
    }

    public int findMax(Node root) {//Ağaçtaki en büyük degeri donduruyor,recursive
        if (root.right != null) {
            return findMax(root.right);
        } else {
            return root.value;
        }
    }
    


    public static void main(String[] args) {
        

        Node root1 = null;//oyuncu 1 icin olusturulmus bst
        BinarySearchTree bst = new BinarySearchTree(root1);

        root1=bst.insert(root1,4);
        bst.insert(root1,5);
        bst.insert(root1,16);
        
        bst.postOrder(root1);
        System.out.println(bst.OrderSonuc);
        

        
        

        

    }

}
