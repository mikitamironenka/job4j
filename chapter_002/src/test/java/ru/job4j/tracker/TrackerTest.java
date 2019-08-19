package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenDeleteItemThenTrackerHasNotItem() {
        Tracker tracker = new Tracker();
        long created1 = System.currentTimeMillis();
        long created2 = System.currentTimeMillis();
        long created3 = System.currentTimeMillis();
        Item item1 = new Item("test1", "testDescription", created1);
        Item item2 = new Item("test2", "testDescription", created2);
        Item item3 = new Item("test3", "testDescription", created3);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        Item[] checked = new Item[2];
        checked[0] = item1;
        checked[1] = item3;
        assertThat(tracker.findAll(), is(checked));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFindByNameThenReturnItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item1 = new Item("test1", "testDescription1", created);
        Item item2 = new Item("test1", "testDescription2", created);
        tracker.add(item1);
        tracker.add(item2);
        Item[] checked = new Item[2];
        checked[0] = item1;
        checked[1] = item2;
        Item[] result = tracker.findByName("test1");
        assertThat(result, is(checked));
    }
}