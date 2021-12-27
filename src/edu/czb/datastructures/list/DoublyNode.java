package edu.czb.datastructures.list;

/**
 * @author: 陈泽彬
 * @date: 2021/12/27 14:19
 * @description:
 */
public class DoublyNode <E>{
    private E element;
    private DoublyNode<E> next;
    private DoublyNode<E> previous;

    public DoublyNode(){
        this(null,null,null);
    }
    public DoublyNode(E e,DoublyNode<E> next,DoublyNode<E> previous){
        this.element=e;
        this.next=next;
        this.previous=previous;
    }
    public DoublyNode(E e){
        this.element=e;
    }
    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DoublyNode<E> getNext() {
        return next;
    }

    public void setNext(DoublyNode<E> next) {
        this.next = next;
    }

    public DoublyNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyNode<E> previous) {
        this.previous = previous;
    }
}
