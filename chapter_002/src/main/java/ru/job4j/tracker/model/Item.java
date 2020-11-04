package ru.job4j.tracker.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "items")
public class Item {

    private String id;
    private String name;
    private String decs;
    private long time;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, String decs, long time) {
        this.name = name;
        this.decs = decs;
        this.time = time;
    }

    public Item(String name, String desc) {
        this.name = name;
        this.decs = desc;
        this.time = System.currentTimeMillis();
    }

    public Item(String id, String name, String decs, long time) {
        this.id = id;
        this.name = name;
        this.decs = decs;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return time == item.time
                && Objects.equals(id, item.id)
                && Objects.equals(name, item.name)
                && Objects.equals(decs, item.decs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, decs, time);
    }

    @Override
    public String toString() {
        return "id='" + id + '\''
                + ", name='" + name + '\''
                + ", decs='" + decs + '\''
                + ", time=" + time;
    }
}
