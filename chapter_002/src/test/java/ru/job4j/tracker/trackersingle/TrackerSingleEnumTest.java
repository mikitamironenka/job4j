package ru.job4j.tracker.trackersingle;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingleEnumTest {

    @Test
    public void whenCreateTwoInstanceEnumThenItTheSame() {

        TrackerSingleEnum trackerOne = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum trackerTwo = TrackerSingleEnum.INSTANCE;

        assertThat(trackerOne, is(trackerTwo));
    }

    @Test
    public void whenCreateTwoInstanceLazyThenItTheSame() {

        TrackerSingleLazy trackerOne = TrackerSingleLazy.getInstance();
        TrackerSingleLazy trackerTwo = TrackerSingleLazy.getInstance();

        assertThat(trackerOne, is(trackerTwo));
    }

    @Test
    public void whenCreateTwoInstanceEagerThenItTheSame() {

        TrackerSingleEager trackerOne = TrackerSingleEager.getInstance();
        TrackerSingleEager trackerTwo = TrackerSingleEager.getInstance();

        assertThat(trackerOne, is(trackerTwo));
    }

    @Test
    public void whenCreateTwoInstanceInnerThenItTheSame() {

        TrackerSingleInnerClass trackerOne = TrackerSingleInnerClass.getInstance();
        TrackerSingleInnerClass trackerTwo = TrackerSingleInnerClass.getInstance();

        assertThat(trackerOne, is(trackerTwo));
    }

}