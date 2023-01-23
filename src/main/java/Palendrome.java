public class Palendrome {
    public static void main(String[] args) {
        String a = "abcde ";
        String b = "edcba     ";
        System.out.println(isPalendrome(a, b));
    }

    public static boolean isPalendrome(String a, String b){
        String cleanA = a.replaceAll("\\s", "");
        String cleanB = b.replaceAll("\\s", "");
        StringBuilder builder = new StringBuilder(cleanA);
        builder.reverse();
        return builder.toString().equals(cleanB);
    }
}
