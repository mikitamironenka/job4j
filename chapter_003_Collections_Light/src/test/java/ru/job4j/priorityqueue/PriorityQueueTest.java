package ru.job4j.priorityqueue;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PriorityQueueTest {

    private PriorityQueue queue;
    @Before
    public void init() {
        queue = new PriorityQueue();
        var desc1 = "low";
        var desc2 = "urgent";
        var desc3 = "middle";
        var pr1 = 5;
        var pr2 = 1;
        var pr3 = 3;
        queue.put(new Task(desc1, pr1));
        queue.put(new Task(desc2, pr2));
        queue.put(new Task(desc3, pr3));
    }

    @Test
    public void whenHigherPriority() {
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}