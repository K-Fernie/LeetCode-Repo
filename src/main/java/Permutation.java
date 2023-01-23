import java.util.Arrays;

public class Permutation {
    //Given two strings write a method to determine if one is a permutation of the other
    //abcde edcba <- this would evaluate to true
    public static void main(String[] args) {
        System.out.println(compareStrings("abd", "dcba"));
    }

    public static boolean compareStrings(String a, String b){
        char[] stringA = a.toCharArray();
        char[] stringB = b.toCharArray();
        Arrays.sort(stringA);
        Arrays.sort(stringB);
        return Arrays.equals(stringA, stringB);
    }
}
