package ua.kpi.pti.task2;

import java.util.HashMap;
import java.util.Map;

public class Word {

    String word;
    Map<Character, Integer> symbols = new HashMap<>();

    public Word(String word) {
        this.word = word;
        for (char c : word.toLowerCase().toCharArray()) {
            Integer count = symbols.get(c);
            if (count == null) {
                count = 0;
            }
            count++;
            symbols.put(c, count);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        if (word != null ? !word.equals(word1.word) : word1.word != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }
}
