import java.util.LinkedList;

public class LinkedListStack<T> implements Stack<T>{

    private LinkedList<T> items;
    
    public LinkedListStack(){
        items = new LinkedList<>();
    }
        
    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    @Override
    public int size(){
        return items.size();
    }
    
    @Override
    public void push(T t){
        items.addFirst(t);
    }

    @Override
    public T pop(){
        return items.removeFirst();
    }
 
    @Override
    public T top(){
        return items.getFirst();
    }
}
