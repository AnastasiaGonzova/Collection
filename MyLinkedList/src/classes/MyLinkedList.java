package classes;

import interfaces.ILinkedList;

import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {
    transient private int size = 0;
    transient private Node<E> first;
    transient private Node<E> last;
    private static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node (Node<E> prev, E element, Node<E> next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public Iterator<E> iterator(){
        return new Iterator<E>() {
            private Node<E> current = first;
            @Override
            public boolean hasNext() {
                if(current == null)
                    return false;
                return true;
            }

            @Override
            public E next() {
                if(hasNext()) {
                    E result = current.element;
                    current = current.next;
                    return result;
                }
                else
                    throw new IndexOutOfBoundsException();
            }
        };
    }

    public MyLinkedList() {
    }

    public void Add(E element){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l,element,null);
        last = newNode;
        if(l == null)
            first = newNode;
        else l.next = newNode;
        size++;

    }
    public void Add(E element, int index){
        if(isPositionIndex(index)){
            if(index == size)
                Add(element);
            else{
                final Node<E> needNode = Node(index);
                Node<E> pred = needNode.prev;
                final Node<E> newNode = new Node<>(pred, element, needNode);
                needNode.prev = newNode;
                if(index != 0)  {
                    if(pred == null)
                        first = newNode;
                    else pred.next = newNode;
                }
                else {
                    newNode.next = first;
                    first = newNode;

                }
                size++;
            }
        }
        else  throw new IndexOutOfBoundsException();
    }


    public void Clear(){
        for(Node<E> check = first; check != null;){
            Node<E> next = check.next;
            check.prev = null;
            check.element = null;
            check.next = null;
            check = next;
        }
        first = last = null;
        size = 0;
    }
    public E Get(int index){
        if(isPositionIndex(index))
            return Node(index).element;
        else  throw new IndexOutOfBoundsException();
    }

    private boolean isPositionIndex(int index){
        return index >= 0 && index < size;
    }

    public int IndexOf(E element){
        int index = 0;
        if(element == null){
            for(Node<E> check = first; check != null; check = check.next){
                if(check.element == null)
                    return index;
                index++;
            }
        }
        else{
            for(Node<E> check = first; check != null; check = check.next) {
                if (element.equals(check.element))
                    return index;
                index++;
            }
        }
        return -1;
    }

    private Node<E> Node(int index){
        Node<E> check = first;
        for(int i = 0; i < index; i++)
            check = check.next;

        return check;
    }

    public E Remove(int index){
        if(isPositionIndex(index)){
            final Node<E> removedNode = Node(index);
            final E removedElement = removedNode.element;
            final Node<E> removedPrev = Node(index).prev;
            final Node<E> removedNext = Node(index).next;
            if (removedPrev == null) first = removedNext;
            else{
                removedPrev.next = removedNext;
                removedNode.prev = null;
            }

            if(removedNext == null) last = removedPrev;
            else{
                removedNext.prev = removedPrev;
                removedNode.next = null;
            }
            removedNode.element = null;
            size--;
            return removedElement;
        }
        else  throw new IndexOutOfBoundsException();
    }
    public E Set(E element, int index){
        if(isPositionIndex((index))){
            Node<E> needNode = Node(index);
            E oldVal = needNode.element;
            needNode.element = element;
            return oldVal;
        }
        else  throw new IndexOutOfBoundsException();
    }
    public int Size(){
        return size;
    }
    public E[] toArray(E[] array){
        if (array.length < size)
            array = (E[])java.lang.reflect.Array.newInstance(
                    array.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = array;
        for (Node<E> check = first; check != null; check = check.next) {
            result[i] = check.element;
            i++;
        }

        if (array.length > size)
            array[size] = null;

        return array;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("");
        if(first == null) result.append("null") ;
        for(Node<E> check = first; check!= null; check = check.next){
            result.append(check.element.toString()) ;
            if(check.next != null) result.append(", ");
        }
        return result.toString();
    }
}
