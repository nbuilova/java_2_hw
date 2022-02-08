package lesson_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phonebook {
    private Map<String, Set<String>> phones = new HashMap<>();

    public void add(String name, String number){
        Set<String> tel = phones.getOrDefault(name, new HashSet<>());
        tel.add(number);
        phones.put(name, tel);
    }

    public Set<String> get(String name) {
        return phones.get(name);
    }
}
