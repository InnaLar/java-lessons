package org.example.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AppUserStore {
   public static List<User> getUsersFromFile(final String fileName) throws IOException {
       return Files.readAllLines(Paths.get(fileName)).stream().skip(1)
       .map(u -> User.builder().id(Integer.parseInt(u.split(";")[0]))
                       .lastName(u.split(";")[1])
                       .phoneNumber(u.split(";")[2])
                       .build())
                       //.filter(u -> u.getId() == 2)
                       .toList();
    }
    public static User getUserFromFile(final String fileName, final int pid) throws IOException {
        List<User> users = getUsersFromFile(fileName);
        return users.stream().filter(u -> u.getId() == pid).toList().get(0);
    }
    public static void main(final String[] args) throws IOException {
       List<User> users = getUsersFromFile("user.csv");
       for (User user:users
            ) {
           System.out.println(user.getLastName());
       }
       User user = getUserFromFile("user.csv", 1);
        System.out.println(user.getLastName());
   }
}
