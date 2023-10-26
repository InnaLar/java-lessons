package org.example.hw4_2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class PhoneHandBook {

    // todo: TreeSet как работает (PhoneNumber)
    private final Map<String, TreeSet<PhoneNumber>> phoneBook = new HashMap<>();

    public void add(final String secondName, final String phoneNumber) {
        PhoneNumber phoneNumber1 = PhoneNumber.builder()
                .phone(phoneNumber)
                .build();

        TreeSet<PhoneNumber> treeSet = new TreeSet<>(Comparator.comparing(PhoneNumber::getPhone));

        treeSet.add(phoneNumber1);

        phoneBook.put(secondName, treeSet);
    }

    public TreeSet<PhoneNumber> get(final String secondName) {
        return null;
    }
}
