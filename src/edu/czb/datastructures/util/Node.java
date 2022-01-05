package edu.czb.datastructures.util;

/**
 * @author: 陈泽彬
 * @date: 2021/12/27 12:41
 * @description:
 */
public class Node<E> {
    private E element;
    private Node<E> next;
    public Node(){
        this(null,null);
    }
    public Node(E e,Node<E> n){
        this.element=e;
        this.next=n;
    }
    public Node(E e){
        this.element=e;
        this.next=null;
    }
    public E getElement(){
        return element;
    }
    public Node<E> getNext(){
        return next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
