package edu.czb.datastructures.list;

import edu.czb.datastructures.util.Node;

/**
 * @author: 陈泽彬
 * @date: 2021/12/27 12:48
 * @description:
 */
public class MyLinkedList<E> {
    private Node<E> node;
    private int size=0;
    public boolean isEmpty(MyLinkedList<E> linkedList){
        return (this.node==null);
    }
    public MyLinkedList(){
        //this(Node<>)
        //this(null);
    }
    /*public MyLinkedList(E n){
        this.node=new Node(n,null);
    }*/
    public Node<E> find(E n){
        Node<E> node=this.node;
        while((node!=null)&&(!node.getElement().equals(n))){
            node=node.getNext();
        }
        return node;
    }
    public void delete(E n){
        if(this.node.getElement().equals(n)){
            this.node=this.node.getNext();
            this.size--;
            return;
        }
        Node<E> pos,tmp;
        pos=findPrevious(n);
        if(pos!=null&&pos.getNext()!=null){
           tmp=pos.getNext();
           pos.setNext(tmp.getNext());
            this.size--;
        }
    }

    public Node<E> findPrevious(E n){
        Node<E> node=this.node;
        while ((node!=null)&&(node.getNext()!=null)&&(!node.getNext().getElement().equals(n))){
            node=node.getNext();
        }
        return node;
    }

    public void insert(E e,Node<E> node){
        Node<E> tmp=new Node<E>();
        tmp.setElement(e);
        tmp.setNext(node.getNext());
        node.setNext(tmp);
        this.size++;

    }
    public void add(E e){
        if(this.node==null){
            this.node=new Node<E>(e);
            this.size++;
        }else{
            Node<E> node=this.node;
            while (node.getNext()!=null){
                node=node.getNext();
            }
            node.setNext(new Node<E>(e));
            this.size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        Node<E> node=this.node;
        while (node!=null){
            stringBuilder.append(node.getElement()).append(", ");
            node=node.getNext();
        }
        return "MyLinkedList{" +
                "node=" + stringBuilder.toString() +
                "size=" + size +
                '}';
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list=new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list.toString());
        Node<Integer> integerNode = list.find(4);
        list.insert(32,integerNode);
        System.out.println(list.toString());
    }
}
