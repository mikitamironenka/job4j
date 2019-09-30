package ru.job4j.tree;

import java.util.*;

//метод add - Должен находить элемент parent в дереве и добавлять в него дочерний элемент.
//node.children.add(child);
//Для поиска элементов в дереве надо использовать метод findBy - Он уже реализован.
//В дереве не может быть дубликатов, т.е. никакие узлы в дереве не должны иметь двух одинаковых дочерних узлов.
//Обязательно реализуйте итератор.

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;
    private E e;

    public Tree(E e) {
        this.e = e;
        this.root = new Node<>(this.e);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        boolean flag = false;
        Node<E> ch = new Node(child);
        Node<E> par = this.findBy(parent).get();
        Iterator it = this.iterator();
        while (it.hasNext()) {
            Node<E> node = (Node<E>) it.next();
            if (node.getValue().equals(child)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            par.add(ch);
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }
//Метод должен проверять количество дочерних элементов в дереве. Если их <= 2 - то дерево бинарное.
    public boolean isBinary() {
        boolean result = true;
        Iterator it = this.iterator();
        while (it.hasNext()) {
            Node<E> child = (Node<E>) it.next();
            if (child.leaves().size() > 2) {
                result = false;
                break;
            }
        }

        return result;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator it = new Iterator() {
            private Queue<Node<E>> data = new LinkedList<>();
            {
                this.data.offer(Tree.this.root);
            }
            @Override
            public boolean hasNext() {
                return !this.data.isEmpty();
            }

            @Override
            public Node<E> next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> element = this.data.remove();
                for (Node<E> child : element.leaves()) {
                    this.data.offer(child);
                }
                return element;
            }
        };
        return it;
    }

}
