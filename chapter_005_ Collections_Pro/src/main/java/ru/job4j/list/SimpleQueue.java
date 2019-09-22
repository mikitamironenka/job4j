package ru.job4j.list;

//Нужно реализовать очередь.
//public class SimpleQueue<T> {
//   public <T> poll()
//   public void push(T value);
//}
//Метод poll() - должен возвращать значение и удалять его из коллекции.
//Метод push(T value) - помещает значение в коллекцию.
//Внутри очереди нужно использовать Стеки из задания 5.3.3. Используя контейнер
// на базе связанного списка создать контейнер Stack
//Описание Queue - очередь. Описывается FIFO - first input first output.
//То есть, первый зашел и первый вышел. Например.
//push(1);      poll() - 1
//push(2);      poll() - 2
//push(3);      poll() - 3

public class SimpleQueue<T> {

    /**
     * Stack for added elements
     */
    private SimpleStack<T> added;
    /**
     * Stack for coping elements when trying get element,
     * in that case the stack will store element in reverse order.
     */
    private SimpleStack<T> copied;

    public SimpleQueue() {
        this.added = new SimpleStack<>();
        this.copied = new SimpleStack<>();
    }

    public T poll() {
        this.shift();
        return this.copied.poll();
    }

    /**
     * Copy elements from "added" stack to "copied" stack in revers order.
     */
    private void shift() {
        while (this.added.getSize() > 0) {
            this.copied.push(added.poll());
        }
    }

    public void push(T value){
        this.added.push(value);
   }

}
