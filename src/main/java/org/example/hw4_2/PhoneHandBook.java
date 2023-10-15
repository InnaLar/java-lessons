package org.example.hw4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class PhoneHandBook {
    final Map<String, SortedSet<String>> phoneBook = new HashMap<>();

    // todo: TreeSet как работает (PhoneNumber)

    public void add(final String secondName, final String phoneNumber) {
        final SortedSet<String> phoneNumbers;
        if (phoneBook.containsKey(secondName)) {
            phoneNumbers = phoneBook.get(secondName);
        } else {
            phoneNumbers = new TreeSet<>();
        }
        phoneNumbers.add(phoneNumber);
        phoneBook.put(secondName, phoneNumbers);
    }

    public SortedSet<String> get(final String secondName) {
        return phoneBook.getOrDefault(secondName, null);
    }
}
