package ua.kpi.pti.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Text {

    private String text;
    private Map<Sentence, Integer> sentences = new HashMap<>();

    public Text(String text) {
        this.text = text;
        String[] split = text.split("\\.");
        for (String s : split) {
            Sentence sentence = new Sentence(s);
            Integer count = sentences.get(sentence);
            if (count == null) {
                count = 0;
            }
            count++;
            sentences.put(sentence, count);
        }
    }

    public int sentences() {
        return sentences.size();
    }

    public int words() {
        int words = 0;
        for (Sentence sentence : sentences.keySet()) {
            words += sentence.words();
        }
        return words;
    }

    // 1. Найти наибольшее количество предложений текста, в которых есть одинаковые слова
    public List<Sentence> findMaxWords() {
        List<Sentence> result = new ArrayList<>();

        for (Sentence sentence : sentences.keySet()) {
            Map<Word, Integer> wordsMap = sentence.getWordsMap();
            for (Map.Entry<Word, Integer> entry : wordsMap.entrySet()) {
                if (entry.getValue() > 1) {
                    result.add(sentence);
                    break;
                }
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text1 = (Text) o;

        if (text != null ? !text.equals(text1.text) : text1.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }
}

