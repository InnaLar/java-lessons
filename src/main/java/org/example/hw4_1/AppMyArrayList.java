package org.example.hw4_1;

public class AppMyArrayList {

    public static void main(final String[] args) {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("I");
        mal.add("n");
        mal.add("n");
        mal.add("a");
        //System.out.println(mal.size());
        //System.out.println(mal);
        mal.remove("n");
        //System.out.println(mal);
        //System.out.println(mal.contains("I"));
        mal.add("N");
        //System.out.println(mal);
        //System.out.println(mal.get(2));
        mal.clear();
        //System.out.println(mal);
        //System.out.println("Hello");
    }
}
