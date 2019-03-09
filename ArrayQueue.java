import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T> {

  private T[] arr;
  private int head;
  private int tail;

  public ArrayQueue() {
    arr = (T[]) new Object[10];
    head = 0;
    tail = 0;
  }

  /**
   * Gets the head of the queue
   * 
   * @return The head of the queue
   */
  public T dequeue() {
    if (empty()) {
      throw new ArrayIndexOutOfBoundsException("Array is empty");
    }

    T temp = arr[head];
    head = (head + 1) % arr.length;

    return temp;
  }

  /**
   * Adds T object to the tail of the queue
   * 
   * @param item the object of type T that is stored at the tail
   */
  public void enqueue(T item) {
    if ((tail + 1) % arr.length == head) {
      growArray();
    }

    arr[tail] = item;
    tail = (tail + 1) % arr.length;
  }

  /**
   * Checks if the array is filled
   * 
   * @return true if the array is empty
   */
  public boolean empty() {
    return (head == tail);
  }

  /**
   * Increases the size of arr through amortization
   */
  private void growArray() {
    T[] leftSide = null;
    T[] rightSide = null;
    
    if (head < tail) {
      leftSide = Arrays.copyOfRange(arr, head, tail);
      
      arr = Arrays.copyOf(leftSide, arr.length * 2);
      tail = leftSide.length;
    } else {
      leftSide = Arrays.copyOfRange(arr, head, arr.length);
      rightSide = Arrays.copyOfRange(arr, 0, tail);
      
      arr = (T[]) new Object[arr.length * 2];
      
      System.arraycopy(leftSide, 0, arr, 0, leftSide.length);
      System.arraycopy(rightSide, 0, arr, leftSide.length, rightSide.length);
      
      tail = rightSide.length + leftSide.length;
    }
    
    head = 0;
  }
}
