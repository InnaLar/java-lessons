package org.example.hw4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class PhoneHandBook {
    final Map<String, SortedSet<String>> hmPhoneBook = new HashMap<>();

    public void add(final String secondName, final String phoneNumber) {
        final SortedSet<String> phoneNumbers;
        if (hmPhoneBook.containsKey(secondName)) {
            phoneNumbers = hmPhoneBook.get(secondName);
        } else {
            phoneNumbers = new TreeSet<>();
        }
        phoneNumbers.add(phoneNumber);
        hmPhoneBook.put(secondName, phoneNumbers);
    }

    public SortedSet<String> get(final String secondName) {
        return hmPhoneBook.getOrDefault(secondName, null);
    }
}
