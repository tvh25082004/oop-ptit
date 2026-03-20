class GenericStack<E> {
    private E[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public GenericStack() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public GenericStack(int capacity) {
        elements = (E[]) new Object[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("==> empty");
        }
        return elements[size - 1];
    }
    
    public void push(E value) {
        if (isFull()) {
            throw new RuntimeException("==> full");
        }
        elements[size] = value;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("==> empty");
        }
        E value = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return value;
    }

    public int getSize() {
        return size;
    }
}


class Main {
    public static void main(String[] args) {
       
        GenericStack<Integer> intStack = new GenericStack<>(5);
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        System.out.println("Top Integer: " + intStack.peek());   
        System.out.println("Pop Integer: " + intStack.pop());    
        System.out.println("Size Integer: " + intStack.getSize()); 

        System.out.println();

        
        GenericStack<Character> charStack = new GenericStack<>(5);
        charStack.push('A');
        charStack.push('B');
        charStack.push('C');

        System.out.println("Top Char: " + charStack.peek());     
        System.out.println("Pop Char: " + charStack.pop());     
        System.out.println("Size Char: " + charStack.getSize());
    }
}