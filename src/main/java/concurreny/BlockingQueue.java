package concurreny;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {

    Lock lock;
    int capacity;
    Condition full;
    Condition empty;
    Queue<Integer> queue;

    public BlockingQueue(int capacity) {
        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try{

            while(queue.size()==capacity){
                full.await();
            }

            queue.offer(element);
            empty.signal();

        }finally{
            lock.unlock();
        }


    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try{
            while(queue.size()==0){
                empty.await();
            }

            int element = queue.poll();
            full.signal();
            return element;

        }finally{
            lock.unlock();
        }


    }

    public int size() {
        return queue.size();
    }
}
