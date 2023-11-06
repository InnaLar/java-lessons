package org.example.hw4_2;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class PhoneHandBook {

    private final Map<String, SortedSet<PhoneNumber>> phoneBook = new ConcurrentHashMap<>();

    public void add(final String secondName, final String phoneNumber) {
        PhoneNumber phoneNumber1 = PhoneNumber.builder()
                .phone(phoneNumber)
                .build();

        SortedSet<PhoneNumber> treeSet = new TreeSet<>(Comparator.comparing(PhoneNumber::getPhone));

        treeSet.add(phoneNumber1);

        phoneBook.put(secondName, treeSet);
    }

    public SortedSet<PhoneNumber> get(final String secondName) {

        return phoneBook.getOrDefault(secondName, null);
    }
}
