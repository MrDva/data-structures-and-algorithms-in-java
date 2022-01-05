package edu.czb.datastructures.stack;

import edu.czb.datastructures.util.Node;

/**
 * @author: 陈泽彬
 * @date: 2022/1/5 17:45
 * @description:
 */
public class LinkStack<E> {
    private Node<E> node;
    private int size=0;

    boolean isEmpty(){
        return node == null;
    }

    public void push (E e){
        Node<E> node=new Node<>(e);
        if(isEmpty()){
            //Node<E> node=new Node<>(e);
            this.node=node;
        }else{
            node.setNext(this.node);
            this.node=node;
        }
        size++;
    }
    public E top(){
        if(!isEmpty()){
            return this.node.getElement();
        }else{
            return null;
        }
    }
    public E pop(){
        if(!isEmpty()){
            E e= this.node.getElement();
            this.node=this.node.getNext();
            size--;
            return e;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        int[] e=new int[100];
        LinkStack<Integer> stack=new LinkStack<Integer>();
        stack.push(2323);
        stack.push(2323111);
        stack.push(231132323);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
