package lesson_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList("Apple", "Banana", "Lime", "Orange"));
        arrayList.addAll(Arrays.asList("Apple", "Banana"));
        System.out.println(arrayList);

        Map<String, Integer> map = new HashMap<>();

        for (String rep : arrayList) {
            map.put(rep, map.getOrDefault(rep, 0) + 1);
        }
        System.out.println(map);

        Phonebook phonebook = new Phonebook();
        phonebook.add("Smirnov","1234567");
        phonebook.add("Kuznetcov", "2345678");
        phonebook.add("Ivanov","3456789");

        phonebook.add("Smirnov","1234567");
        phonebook.add("Smirnov","0987655");

        System.out.println(phonebook.get("Smirnov"));
        System.out.println(phonebook.get("asasasas"));


    }
}
