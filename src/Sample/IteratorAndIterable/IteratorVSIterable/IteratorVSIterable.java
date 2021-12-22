package Sample.IteratorAndIterable.IteratorVSIterable;

import java.util.*;

class CustomList<E> implements List<E> {
    int cursor = 0;
    int size = 0;
    int lastRet = 0;
    Object[] elementData = null;

    @Override
    public int size() {
        return 0;
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
    @Override
    public boolean contains(Object o) {
        return false;
    }
    public Iterator<E> iterator(){
        return new Itr();
    }
    @Override
    public Object[] toArray() {
        return new Object[0];
    }
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
    @Override
    public boolean add(E e) {
        return false;
    }
    @Override
    public boolean remove(Object o) {
        return false;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    @Override
    public void clear() {

    }
    @Override
    public E get(int index) {
        return null;
    }
    @Override
    public E set(int index, E element) {
        return null;
    }
    @Override
    public void add(int index, E element) {

    }
    @Override
    public E remove(int index) {
        return null;
    }
    @Override
    public int indexOf(Object o) {
        return 0;
    }
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public class Itr<E> implements Iterator<E> {

        public boolean hasNext() {
            return cursor != size;
        }
        @SuppressWarnings("unchecked")
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = CustomList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        private void checkForComodification() {
        }
    }
}


