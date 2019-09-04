package ru.job4j.addresslist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollectThenReturnListOfAddresses() {
        Profiles profiles = new Profiles();
        Address ad1 = new Address("NY", "st", 55, 11);
        Address ad2 = new Address("LA", "br", 22, 205);
        Address ad3 = new Address("SF", "zz", 11, 325);
        Profile one = new Profile(ad1);
        Profile two = new Profile(ad2);
        Profile three = new Profile(ad3);
        List<Profile> profilesList = List.of(one, two, three);
        List<Address> result = profiles.collect(profilesList);
        List<Address> checked = List.of(ad1, ad2, ad3);
        assertThat(result, is(checked));
    }
}