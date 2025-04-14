package ch3.section6_abstract;

abstract class List{
    protected int size;
    public int length(){
        return size;
    }
    public abstract void insertFront(Object item);
}

public class prac {
}
