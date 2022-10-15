package Structures;

public interface Queue<E> {
    /**
     * Mètode que permet afegir/encuar un nou element a la cua
     * @param e l'element a "encuar" llença aquesta excepció en el cas que
     * la cua estigui plena
     */
    public void push(E e);

    public E pop() throws EmptyQueueException;
    public int size();
    public E getElement(E element);
}
