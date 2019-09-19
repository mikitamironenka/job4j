package ru.job4j.generic.storetask;

import ru.job4j.generic.SimpleArray;

public abstract class BaseStore<T extends Base> implements Store<T> {

    private SimpleArray<Base> simpleArray;
    private int size;

    public BaseStore(int size) {
        this.size = size;
        this.simpleArray = new SimpleArray(this.size);
    }

    @Override
    public void add(Base model) {
        this.simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        this.simpleArray.set(getIndexById(id), model);
        if (findById(model.getId()).equals(model)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        this.simpleArray.remove(getIndexById(id));
        if (findById(id) == null) {
            result = true;
        }
//        Base model;
//        for (int i = 0; i < this.simpleArray.getSize(); i++) {
//            model = this.simpleArray.get(i);
//            if (model.getId().equals(id)) {
//                this.simpleArray.remove(i);
//                result = true;
//            }
//        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        T item;
        for (int i = 0; i < this.size; i++) {
            item = (T) this.simpleArray.get(i);
            if ((item != null) && (id.equals(item.getId()))) {
                result = item;
                break;
            }
        }
        return result;
    }

    public int getIndexById(String id) {
        int result = 0;
        Base item;
        for (int i = 0; i < this.size; i++) {
            item = this.simpleArray.get(i);
            if ((item != null) && (id.equals(item.getId()))) {
                result = i;
                break;
            }
        }
        return result;
    }
}
