import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {

  private T[] arr;
  private int top;
  private int size;

  public ArrayStack() {
    arr = (T[]) new Object[10];
    top = -1;
    size = 10;
  }

  /**
   * Adds an item of type T to the array
   * 
   * @item the item that is added to the array
   */
  public void push(T item) {
    if (top == (size - 1)) {
      growArray();
    }

    arr[++top] = item;
  }

  /**
   * Removes the top of the stack and returns it
   * 
   * @return the top of the stack
   */
  public T pop() {
    if (empty()) {
      throw new ArrayIndexOutOfBoundsException("Array is empty");
    }

    return arr[top--];
  }

  /**
   * Checks to see what Object of type T is stored at the top of the stack
   */
  public T peek() {
    if (empty()) {
      throw new ArrayIndexOutOfBoundsException("Array is empty");
    }

    return arr[top];
  }

  /**
   * Checks if the array is empty
   * 
   * @return true if the array is empty
   */
  public boolean empty() {
    return (top == -1);
  }

  /**
   * Increases the size of arr by twice its size
   */
  private void growArray() {
    size *= 2;
    arr = Arrays.copyOf(arr, size);
  }
}
