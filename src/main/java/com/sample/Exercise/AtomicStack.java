package com.sample.Exercise;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by nithin on 26/04/17.
 */
public class AtomicStack<E> {


    private final AtomicReference<Node<E>> top=new AtomicReference<>();

    public void push(E data){

        Node<E> newHead=new Node<>(data);
        Node<E> oldHead;
        do{
            oldHead=top.get();
            newHead.next=oldHead;

        }while(!top.compareAndSet(oldHead, newHead));

    }

    public E pop(){

        Node<E> oldHead;
        Node<E> newHead;
        do{
            oldHead=top.get();
            newHead=oldHead.next;

        }while(top.compareAndSet(oldHead, newHead));

        return oldHead.data;

    }


    static class Node<E>{

        E data;
        Node<E> next;

        Node(E data){
            this.data=data;
        }
    }
}
