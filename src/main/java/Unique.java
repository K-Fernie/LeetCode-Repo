import java.util.HashMap;

public class Unique {

    public static boolean isUnique(String uniqueString)
    {
        HashMap<String, Integer> stringMap = new HashMap<>();
        for(char character : uniqueString.toCharArray()){
            String search = String.valueOf(character);
            if(!search.equals(" ")){
                stringMap.merge(search.toLowerCase(), 1, Integer::sum);
            }
            System.out.println(stringMap);
        }
        return stringMap.values().stream().allMatch(n -> n == 1);
    }
    public static void main(String[] args) {
        System.out.println(isUnique("The quick brown fox jumps over the lazy dog"));
    }
}
