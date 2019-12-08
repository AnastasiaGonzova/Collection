package interfaces;

public interface ILinkedList<E> extends Iterable<E>{

    public void Add(E element);
    public void Add(E element, int index);
    public void Clear();
    public E Get(int index);
    public int IndexOf(E element);
    public E Remove(int index);
    public E Set(E element, int index);
    public int Size();
    public E[] toArray(E[] array);
    public String toString();
}
