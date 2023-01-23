import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneAway {
    //given two strings write a method to determine if they are one edit or zero edits away
    public static void main(String[] args) {
        System.out.println(oneOrZeroEditsAway("gfg", "gfggg"));
    }

    public static boolean oneOrZeroEditsAway(String a, String b){
        //two arrays, if the arrays are equal length I do a comparison and am done
        int counter = 0;
        if(a.length() > b.length()){
            for(int i = 0; i < b.length(); i++){
                if(a.contains(String.valueOf(b.charAt(i)))){
                    counter++;
                };
            }
            return Math.abs(counter - a.length()) == 1;
        } else {
            for(int i = 0; i < a.length(); i++){
                if(b.contains(String.valueOf(a.charAt(i)))){
                    counter++;
                };
            }
            return Math.abs(counter - b.length()) == 1;
        }
        //otherwise if the arrays are unequal I determine if they are only 1 letter off
    }
}
