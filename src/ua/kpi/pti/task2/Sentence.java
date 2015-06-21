package ua.kpi.pti.task2;

import java.util.HashMap;
import java.util.Map;

public class Sentence {

    String sentence;
    Map<Word, Integer> wordsMap = new HashMap<>();

    public Sentence(String sentence) {
        this.sentence = sentence;
        String[] words = sentence.split(" ");
        for (String w : words) {
            w = w.trim();
            if ("".equals(w)) {
                continue;
            }
            Word word = new Word(w);
            Integer count = wordsMap.get(word);
            if (count == null) {
                count = 0;
            }
            count++;
            wordsMap.put(word, count);
        }
    }

    public Map<Word, Integer> getWordsMap() {
        return wordsMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence1 = (Sentence) o;

        if (sentence != null ? !sentence.equals(sentence1.sentence) : sentence1.sentence != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return sentence != null ? sentence.hashCode() : 0;
    }

    public int words() {
        return wordsMap.size();
    }
}
