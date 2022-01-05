package edu.czb.datastructures.queue;

import java.lang.reflect.Array;

/**
 * @author: 陈泽彬
 * @date: 2022/1/5 19:06
 * @description:
 */
public class ArrayQueue<E> {
    private E[] es;
    private int Q_MAX_SIZE=100;
    private int qFront;
    private int qRear;
    private int qSize;
    public ArrayQueue(){

    }
    public boolean isEmpty(){
        return this.es==null;
    }
    public int succ(int value){
        if(++value==Q_MAX_SIZE){
            value=0;
        }
        return value;
    }

    public void init(E e){
        clear();
        this.es=(E[]) Array.newInstance(e.getClass(),Q_MAX_SIZE);
        this.es[this.qRear]=e;
    }
    public void clear(){
        this.es=null;
        this.qFront=0;
        this.qRear=0;
        this.qSize=0;
    }
    public boolean isFull(){
        return this.qSize==Q_MAX_SIZE;
    }
    public void enqueue(E e){
        if(isFull()) {
            return;
        }
        if(isEmpty())
        {
            init(e);
        }else {
            this.qSize++;
            this.qRear=succ(qRear);
            this.es[this.qRear]=e;
        }
    }

    public E dequeue(){
        if(!isEmpty()){
            this.qSize--;
            E e= this.es[this.qFront++];
            if(this.qFront==Q_MAX_SIZE){
                this.qFront=0;
            }
            return e;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue=new ArrayQueue<>();
        queue.enqueue(12);
        queue.enqueue(123);
        queue.enqueue(1234);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

}
