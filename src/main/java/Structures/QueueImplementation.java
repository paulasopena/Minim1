package Structures;

import java.util.NoSuchElementException;

public class QueueImplementation<E> implements Queue<E> {
    public static class QueueNode<E>{
        E value;
        QueueNode<E> next;
        public QueueNode(E e){
            this.value=e;
        }
    }
    QueueNode<E> first;
    QueueNode<E> last;
    @Override
    public void push(E e){
        QueueNode<E> node= new QueueNode<E>(e);
        if(last!=null){
            last.next=node;
        }
        last=node;
        if(first==null){
            first=last;
        }

    }

    @Override
    public E pop() throws EmptyQueueException {
        if(first==null){
            throw new EmptyQueueException();
        }
        E elementPopped=first.value;
        first=first.next;
        if(first==null){
            last=null;
        }
        return elementPopped;
    }

    @Override
    public int size() {
        QueueNode<E> current=first;
        int size=0;
        while(current!=null){
            size++;
            current=current.next;
        }
        return size;
    }
    @Override
    public E getElement(E element){
        QueueNode<E> current=first;
        boolean found=false;
        while(current != null && found==false){
            if(current.value==element){
                found=true;
            }
            else{
                current=current.next;
            }
        }
        if(found==false){
            return null;
        }
        else{
            return element;
        }


    }
}
