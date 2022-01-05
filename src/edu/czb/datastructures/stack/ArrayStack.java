package edu.czb.datastructures.stack;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: 陈泽彬
 * @date: 2022/1/5 18:05
 * @description:
 */
public class ArrayStack<E> {
    private final static int MAX_SIZE=100;
    E[] es;
    private int topOfStack=0;
    private int size;

    public void init(Class<E> type){
        this.es=(E[])Array.newInstance(type,MAX_SIZE);
        this.topOfStack=0;
        this.size=0;
    }

    boolean isEmpty(){
        return this.es==null;
    }

    public void push (E e){
        if(isEmpty()){
           init((Class<E>) e.getClass());
        }
        this.es[topOfStack++]=e;
        size++;
    }
    public E top(){
        if(!isEmpty()){
            return this.es[topOfStack-1];
        }else{
            return null;
        }
    }
    public E pop(){
        if(!isEmpty()){
            size--;
            E e=this.es[--topOfStack];
            if(size==0){
                this.es=null;
            }
            return e;
        }else{
            return null;
        }
    }
    public static void main(String[] args) {
        int[] e=new int[100];
        ArrayStack<Integer> stack=new ArrayStack<>();
        stack.push(2323);
        stack.push(2323111);
        stack.push(231132323);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
