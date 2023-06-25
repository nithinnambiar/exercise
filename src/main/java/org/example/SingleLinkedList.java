package org.example;

public class SingleLinkedList<E> {

private  Node<E> head;
private Node<E> currentNode;

private int size=0;
    public SingleLinkedList(){


    }

    boolean add(E data){

        Node<E> node = new Node<>();
        node.add(data);

        if (head==null) {

            head=node;
            currentNode=node;

                    }
                    else{

            currentNode.next=node;
            currentNode=node;

        }

        size++;

        return true;



    }

    void print(){

        Node<E> node=head;
        while(node!=null){

            System.out.println(node.data);
            node=node.next;
        }

    }

    boolean remove(E data){

        Node<E> temp=head;
        Node<E> prev=head;
        boolean remove=false;
        while(temp!=null){

            if (temp.data.equals(data)){


                if(head==temp)
                    head=temp.next;

                if(currentNode==temp)
                    currentNode=prev;

                    prev.next=temp.next;
                    size--;
                    remove=true;
                    return remove;

            }
            prev=temp;
            temp=temp.next;
        }

        return remove;


    }

    public int size(){
        return size;
    }


    private static class  Node<E>{

        E data;
        Node<E> next;

       void add(E data){

           this.data=data;

        }

    }

    public static void main(String[] args) {


        SingleLinkedList<Integer> linkedList=new SingleLinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);

       // linkedList.print();

        linkedList.remove(50);
        linkedList.print();
        linkedList.add(60);
        linkedList.print();
    }


}

