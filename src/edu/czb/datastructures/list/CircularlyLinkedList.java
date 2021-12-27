package edu.czb.datastructures.list;

/**
 * @author: 陈泽彬
 * @date: 2021/12/27 14:30
 * @description:
 */
public class CircularlyLinkedList<E> {
    private DoublyNode<E> node;
    private int size=0;
    public boolean isEmpty(MyLinkedList<E> linkedList){
        return (this.node==null);
    }
    public CircularlyLinkedList(){
        //this(Node<>)
        //this(null);
    }

    public DoublyNode<E> find(E n){
        DoublyNode<E> node=this.node;
        int pos=0;
        while((node!=null)&&(!node.getElement().equals(n))&&pos<this.size){
            pos++;
            node=node.getNext();
        }
        return node;
    }
    public void delete(E n){
        if(this.node.getElement().equals(n)){
            DoublyNode<E> tmp=this.node.getNext();
            tmp.setPrevious(this.node.getPrevious());
            this.node=tmp;
            this.size--;
            return;
        }
        DoublyNode<E> pos,tmp;
        pos=findPrevious(n);
        if(pos!=null&&pos.getNext()!=null){
            tmp=pos.getNext();
            tmp.getNext().setPrevious(pos);
            pos.setNext(tmp.getNext());
            this.size--;
        }
    }

    public DoublyNode<E> findPrevious(E n){
        DoublyNode<E> node=this.node;
        int pos=0;
        while ((node!=null)&&(node.getNext()!=null)&&(!node.getNext().getElement().equals(n))&&pos<this.size){
            pos++;
            node=node.getNext();
        }
        return node;
    }

    public void insert(E e,DoublyNode<E> node){
        DoublyNode<E> tmp=new DoublyNode<E>();
        tmp.setElement(e);
        tmp.setNext(node.getNext());
        tmp.setPrevious(node);
        node.getNext().setPrevious(tmp);
        node.setNext(tmp);
        this.size++;

    }
    public void add(E e){
        if(this.node==null){
            this.node=new DoublyNode<E>(e);
            this.node.setPrevious(this.node);
            this.node.setNext(this.node);
            this.size++;
        }else{
            DoublyNode<E> node=this.node.getPrevious();
            /*if(node==null){
                DoublyNode<E> doublyNode = new DoublyNode<E>(e);
                doublyNode.setPrevious(this.node);
                doublyNode.setNext(this.node);
                this.node.setNext(doublyNode);
                this.node.setPrevious(doublyNode);
                return;
            }*/
            DoublyNode<E> doublyNode = new DoublyNode<E>(e);
            doublyNode.setPrevious(node);
            doublyNode.setNext(this.node);
            node.setNext(doublyNode);
            this.node.setPrevious(doublyNode);
            this.size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        DoublyNode<E> node=this.node;
        int pos=0;
        while (node!=null&&pos<this.size){
            stringBuilder.append(node.getElement()).append(", ");
            pos++;
            node=node.getNext();
        }
        return "MyLinkedList{" +
                "node=" + stringBuilder.toString() +
                "size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CircularlyLinkedList<Integer> myDoublyLinkList=new CircularlyLinkedList<>();
        myDoublyLinkList.add(1);
        myDoublyLinkList.add(2);
        myDoublyLinkList.add(4);
        myDoublyLinkList.add(53);
        System.out.println(myDoublyLinkList.find(1).getPrevious().getElement());
        System.out.println(myDoublyLinkList.toString());
        DoublyNode<Integer> integerDoublyNode = myDoublyLinkList.find(53);
        myDoublyLinkList.insert(32,integerDoublyNode);
        System.out.println(myDoublyLinkList.toString());
        myDoublyLinkList.delete(1);
        System.out.println(myDoublyLinkList.find(2).getPrevious().getElement());

    }
}
