package ru.windwail.collections;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by icetusk on 07.08.16.
 */
public class MostFrequentStrings {


    public static void main(String[] args) throws Exception {

        HashMap<String, Integer> wordCount = new HashMap<>();


        String textFile = MostFrequentStrings.class.getClassLoader().getResource("text.txt").getFile();
        System.out.println(textFile);
        Scanner sc = new Scanner(new File(textFile));
        while(sc.hasNext()) {
            String s = sc.next();

            wordCount.merge(s,1, (a,b) -> a+b);
        }

        for(int i=0; i<100; i++) {
            String word = Collections.max(wordCount.entrySet(), HashMap.Entry.comparingByValue()).getKey();

            System.out.println(word + ":" + wordCount.get(word));

            wordCount.remove(word);
        }

    }

}
