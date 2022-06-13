public interface Stack<T> {
    /**
     * Removes and returns the item at the top of the stack
     * 
     * @return the item at the top the stack 
     */
    T pop();
    
    /**
     * Inserts an object to the top of the stack
     * 
     * @param o the object to be pushed
     */
    void push(T t);
    
    /**
     * Tells us if the stack is empty
     * 
     * @return true if the stack is empty
     */
    boolean isEmpty();
    
    /**
     * Returns the number of items in the stack
     * 
     * @return the number of items in the stack
     */
    int size();
    
    /**
     * Tells us the item at the top without removing it
     * 
     * @return the object at the top of the stack 
     */
    T top();
}
