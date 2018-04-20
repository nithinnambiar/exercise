package com.sample.Exercise;

/**
 * Created by nithin on 25/04/17.
 */
public class BlockingQueueImpl {

    private final Object[] queue;
    private int count;
    private int takeIndex, putIndex=0;


    private final Object lock=new Object();

    public BlockingQueueImpl(int size){
        this.queue=new Object[size];
    }



    public void put(Object element) throws InterruptedException{

        synchronized (lock){

            while(count >= queue.length)
                lock.wait();
            queue[putIndex]=element;
            count++;
            putIndex++;
            if(putIndex==queue.length)
                putIndex=0;
            lock.notifyAll();

        }
    }

    public Object take() throws InterruptedException{



        synchronized (lock){
            Object element;

            while(count==0)
                lock.wait();
            element=queue[takeIndex];
            queue[takeIndex]=null;
            count--;
            takeIndex++;
            if(takeIndex==queue.length)
                takeIndex=0;

            lock.notifyAll();
            return element;


        }
    }

    public static void main(String args[]){


        var queue=new BlockingQueueImpl(5);

        try {
            queue.put("nithin");
            queue.put("jpseph");
            queue.put("kumaran");
            queue.put("fed");
            queue.put("emarald");
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
            queue.put("victor");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
