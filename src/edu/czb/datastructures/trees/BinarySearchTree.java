package edu.czb.datastructures.trees;

import edu.czb.datastructures.util.DrawDemo;
import edu.czb.datastructures.util.TreeNode;

import java.util.Random;

/**
 * @author: 陈泽彬
 * @date: 2022/1/6 14:39
 * @description:
 */
public class BinarySearchTree<E> {
    private TreeNode<E> root;
    private int high;
    private int size;

    private boolean isEmpty(){
        return this.root==null;
    }
    TreeNode<E> find(E e){
        return find(e,this.root);
    }

    public TreeNode<E> find(E e,TreeNode<E> treeNode){
        if(treeNode==null){
            return null;
        }
        if(e.hashCode()<treeNode.getElement().hashCode()){
            return find(e,treeNode.getLeft());
        }else if(e.hashCode()>treeNode.getElement().hashCode()){
            return find(e,treeNode.getRight());
        }else {
            return treeNode;
        }
    }

    public TreeNode<E> findMin(){
        return findMin(this.root);
    }

    public TreeNode<E> findMin(TreeNode<E> treeNode){
        if(treeNode==null){
            return null;
        }else if(treeNode.getLeft()==null){
            return treeNode;
        }else{
            return findMin(treeNode.getLeft());
        }
    }

    public TreeNode<E> findMax(){
        return findMax(this.root);
    }

    public TreeNode<E> findMax(TreeNode<E> treeNode){
        if(treeNode==null){
            return null;
        }else if(treeNode.getRight()==null){
            return treeNode;
        }else{
            return findMax(treeNode.getRight());
        }
    }

    public void insert(E e){
        if(this.root==null){
            this.root=new TreeNode<>(e);
            this.size=1;
            //return this.root;
            return;
        }
        insert(e,this.root);
    }

    public void insert(E e,TreeNode<E> treeNode){
        if(e.hashCode()<treeNode.getElement().hashCode()){
            if(treeNode.getLeft()==null){
                treeNode.setLeft(new TreeNode<>(e));
                this.size++;
            }else{
                insert(e,treeNode.getLeft());
            }
        }else if(e.hashCode()>treeNode.getElement().hashCode()){
            if(treeNode.getRight()==null){
                treeNode.setRight(new TreeNode<>(e));
                this.size++;
            }else{
                insert(e,treeNode.getRight());
            }
        }
    }


    public void delete(E e){
        this.root=delete(e,this.root);
    }

    /**
     * lazy deletion
     * */
    public TreeNode<E> delete(E e,TreeNode<E> treeNode){
        if(treeNode==null){
            return null;
        }
        if(e.hashCode()<treeNode.getElement().hashCode()){
            if(treeNode.getLeft()==null){
                return treeNode;
            }
            treeNode.setLeft(delete(e,treeNode.getLeft()));
        }else if(e.hashCode()>treeNode.getElement().hashCode()){
            if(treeNode.getRight()==null){
                return treeNode;
            }
            treeNode.setRight(delete(e,treeNode.getRight()));
        }else {
            if(treeNode.getRight()==null&&treeNode.getLeft()==null){
                return null;
             }else if(treeNode.getLeft()!=null){
                TreeNode<E> tmp=findMax(treeNode.getLeft());
                treeNode.setElement(tmp.getElement());
                treeNode.setLeft(delete(treeNode.getElement(),treeNode.getLeft()));
                return treeNode;
            } else /*if(treeNode.getRight()!=null)*/{
            /* Replace with smallest in right subtree */
            TreeNode<E> tmp=findMin(treeNode.getRight());
            treeNode.setElement(tmp.getElement());
            treeNode.setRight(delete(treeNode.getElement(),treeNode.getRight()));
            return treeNode;
            }/*else {
            TreeNode<E> tmp=findMin(treeNode.getRight());
            treeNode.setElement(tmp.getElement());
            treeNode.setRight(delete(treeNode.getElement(),treeNode.getRight()));
            return treeNode;
        }*/
        }
        return treeNode;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public static void main(String[] args) {
        int MAX_SIZE=50;
        BinarySearchTree<Integer> tree=new BinarySearchTree<>();
        Random random=new Random();
        for(int i=0;i<MAX_SIZE;i++){
            tree.insert(random.nextInt(1000));
        }
        /*tree.insert(2);
        tree.insert(1);
        tree.insert(3);*/
        System.out.println(tree.size);
        tree.delete(1);
        for(int i=0;i<MAX_SIZE/3;i++){
            tree.delete(random.nextInt(10));
        }
        DrawDemo drawDemo=new DrawDemo(tree);

        //drawDemo.paintTree(tree,drawDemo.getG());
    }

}
