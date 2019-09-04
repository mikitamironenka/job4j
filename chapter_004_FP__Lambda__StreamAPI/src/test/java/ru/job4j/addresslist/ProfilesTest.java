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

    @Test
    public void whenCollectUniqueThenReturnListOfUniqueAddresses() {
        Profiles profiles = new Profiles();
        Address ad1 = new Address("NY", "st", 55, 11);
        Address ad2 = new Address("LA", "br", 22, 205);
        Address ad3 = new Address("SF", "zz", 11, 325);
        Address ad4 = new Address("SF", "zz", 11, 325);
        Address ad5 = new Address("AA", "bb", 05, 777);
        Profile pr1 = new Profile(ad1);
        Profile pr2 = new Profile(ad2);
        Profile pr3 = new Profile(ad3);
        Profile pr4 = new Profile(ad4);
        Profile pr5 = new Profile(ad5);
        List<Profile> profilesList = List.of(pr1, pr2, pr3, pr4, pr5);
        List<Address> result = profiles.collectUniqueAddresses(profilesList);
        List<Address> checked = List.of(ad5, ad2, ad1, ad3);
        assertThat(result, is(checked));
    }
}