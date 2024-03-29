package stack;

import array.Array;

public class ArrayStack<E> implements Stack<E>{

    private Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<E>(capacity);
    }

    public ArrayStack(){
        array = new Array<E>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public boolean isEmpty() {
        return array.getSize() == 0 ? true : false;
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append( String.format("Stack: size = %d;",array.getSize()));
        res.append("[");
        for (int i = 0;i < array.getSize();i++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(",");
        }
        res.append("] top");
        return res.toString();
    }
}
