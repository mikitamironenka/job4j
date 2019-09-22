package ru.job4j.list;

//Метод poll() - должен возвращать значение и удалять его из коллекции.
//Метод push(T value) - помещает значение в коллекцию.

public class SimpleStack<T> {

    private LinkedListContainer<T> list;

    public SimpleStack() {
        this.list = new LinkedListContainer<>();
    }

    /**
     * Removes last element from list with method {@link ru.job4j.list.LinkedListContainer#removeLast()}.
     * @return T element.
     */
    public T poll() {
        return list.removeLast();
    }

    /**
     * Adds element to the tail of list with method {@link ru.job4j.list.LinkedListContainer#add(T value)}}.
     * @param value
     */
    public void push(T value) {
        list.add(value);
    }

}
