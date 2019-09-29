package ru.job4j.map;

//Ассоциативный массив на базе хэш-таблицы должен быть унифицирован через генерики и иметь методы:
//boolean insert(K key, V value);
//V get(K key);
//boolean delete(K key);
//Реализовывать итератор.
//Внутренняя реализация должна использовать массив. Нужно обеспечить фиксированное время вставки и получение.
// Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента.
//Методы разрешения коллизий реализовывать не надо. Например: если при добавлении ключ уже есть, то возвращать false

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Iterable {

    private Entry<K, V>[] buckets;
    private static final int DEFAULT_CAPACITY = 16;
    private int size = 0;
    private final double loadFactor = 0.75;
    private int threshold;
    /**
     * Default constructor is initialized with default capacity
     */
    public SimpleMap() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleMap(int capacity) {
        this.buckets = new Entry[capacity];
        this.threshold = (int) (capacity * loadFactor);
    }

    /**
     * Calculates index for key to put in buckets.
     * @param key key
     * @return int value of index
     */
    private int getIndex(K key) {
        return key.hashCode() % buckets.length;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * throws IllegalArgumentException if key is null
     * @param key
     */
    private void ifKeyIsNull(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key cant be null");
        }
    }

    private void resize(int newCapacity) {
        Entry<K, V>[] newBuckets = new Entry[newCapacity];
        transfer(newBuckets);
        this.buckets = newBuckets;
        this.threshold = (int) (newCapacity * loadFactor);
    }

    private void transfer(Entry<K, V>[] newBuckets) {
        Iterator it = this.iterator();
        while (it.hasNext()) {
            Entry<K, V> entry = (Entry<K, V>) it.next();
            this.insert(entry.getKey(), entry.getValue());
        }
    }
    /**
     * Inserts key value to the buckets[].
     * @param key key
     * @param value value
     * @return true if operation is finished successes, false if not.
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        ifKeyIsNull(key);

        if (this.size == threshold) {
            this.resize(this.buckets.length * 2);
        }

        Entry<K, V> entry = new Entry<>(key, value, null);
        int index = getIndex(key);
        Entry<K, V> existing = buckets[index];
        if (existing == null) {
            buckets[index] = entry;
            result = true;
            this.size++;
        }
        return result;
    }

    public V get(K key) {
        ifKeyIsNull(key);
        V result = null;
        Entry<K, V> bucket = buckets[getIndex(key)];
        if (bucket.getKey().equals(key)) {
            result = bucket.getValue();
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        Entry<K, V> bucket = buckets[getIndex(key)];
        if (bucket.getKey().equals(key) && key != null) {
            buckets[getIndex(key)] = null;
            result = true;
            size--;
        }

        return result;
    }


    @Override
    public Iterator iterator() {
        Iterator it  = new Iterator() {
            Entry<K, V> entry = null;
            Entry<K, V>[] table = buckets;
            int index = 0;
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (entry != null) {
                    result = entry.getNext() != null;
                }
                if (entry == null || !result) {
                    while (index < table.length) {
                        if (table[index] != null) {
                            result = true;
                            break;
                        }
                        index++;
                    }
                }
                return result;
            }

            @Override
            public Entry<K, V> next() {
                if (!hasNext()) {
                    new NoSuchElementException("No more elements");
                }
                Entry<K, V> result = entry;
                if (entry != null) {
                    result = entry.getNext();
                } else {
                    while (index < table.length) {
                        if (table[index] != null) {
                            result = table[index++];
                            break;
                        }
                        index++;
                    }
                }
                return result;
            }
        };
        return it;
    }

}
