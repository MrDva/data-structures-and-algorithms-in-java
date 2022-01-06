package edu.czb.datastructures.util;

/**
 * @author: 陈泽彬
 * @date: 2022/1/6 14:19
 * @description:
 */
public class TreeNode<E> {
    private E element;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(){
        this(null);
    }
    public TreeNode(E e){
        this.element=e;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }
}
