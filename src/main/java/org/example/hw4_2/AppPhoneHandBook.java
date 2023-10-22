package org.example.hw4_2;

public class AppPhoneHandBook {

    public static void main(final String[] args) {
        final PhoneHandBook phBook = new PhoneHandBook();
        phBook.add("Ларина", "89022672754");
        phBook.add("Ларина", "89089127447");
        phBook.add("Мусина", "81234567890");
        for (String phone : phBook.get("Ларина")
        ) {
            System.out.println(phone);
        }
    }
}
