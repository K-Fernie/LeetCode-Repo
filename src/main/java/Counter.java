import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Counter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] words = input.nextLine().split(" ");
        Map<String, Integer> wordMap = new HashMap<>();

        for(String word: words){
            if(!wordMap.containsKey(word)){
                wordMap.put(word, 1);
            }else{
                int count = wordMap.get(word) + 1;
                wordMap.put(word,count);
            }
        }

        for(Map.Entry<String, Integer> entry:wordMap.entrySet()){
            System.out.println(String.format("%s",entry));
        }

    }
}
