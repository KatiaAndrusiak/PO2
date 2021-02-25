import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<T> {
    private final T[] array;
    private int current_size;
    private final int max_size;
    public Stack(int max_size){
        this.max_size = max_size;
        this.current_size = -1;
        @SuppressWarnings("unchecked")
        final T[]data = (T[]) new Object[max_size];
        this.array=data;

    }

    public boolean isEmpty(){
        return current_size == -1;
    }

    public boolean isFull(){
        return current_size == max_size - 1;
    }

    public void  push( T x) throws StackOverflowException{
        if(this.isFull()){
            throw new StackOverflowException("Stack is Full You can't add more data");
        }
        else{
            array[++current_size] = x;
        }
    }

    public T pop() throws StackUnderflowException{
        if(this.isEmpty()){
            throw new StackUnderflowException("Stack is Empty You can't get data");
        }
        else {
            T poped = array[current_size];
            array[current_size] = null;
            current_size--;
            return poped;
        }
    }

    @Override
    public String toString() {
        String str="";
        for (int i = 0; i < current_size; i++){
            str+=array[i]+", ";
        }
        str+= array[current_size];
        return str;

    }
}


