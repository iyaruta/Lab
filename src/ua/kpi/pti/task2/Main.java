package ua.kpi.pti.task2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String txt = "Hello. I am Inna. I like programming and I like Java. This text has 5 sentences and two of them has same sentences. Let's count.";
        Text text = new Text(txt);
        System.out.println(text.sentences());
        System.out.println(text.words());

        List<Sentence> maxWords = text.findMaxWords();
        System.out.println(maxWords.size());
    }

}
