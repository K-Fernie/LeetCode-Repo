public class Replace {
    //Write a method to replace all " " with "%20"
    public static void main(String[] args) {
        System.out.println(replace("Gemstones are the best"));
    }

    public static String replace(String url){
        return url.replace(" ", "%20");
    }
}
