public class Compass {
    //Compass problem
    //You're piloting an airplane, there are two compasses, something is wrong, instead of
    //both having the same heading, they are both showing different headings
    //One compass reads 40 and the other reads 50 Create a single heading
    //Given two compass headings return a single heading as the true heading (0 - 360)
        //Neither is more accurate than the other
        //The accurate heading would be between two headings

    public static void main(String[] args) {
        System.out.println(returnAccurateHeading(20, 340));
    }

    public static int returnAccurateHeading(int heading1, int heading2){
        int returnHeading;
        if(heading1 == heading2){
            return heading1;
        }
        int maxHeading = Math.max(heading1, heading2);
        int minHeading = Math.min(heading1, heading2);
        if(maxHeading - minHeading == 180){
            return -1;
        }else if(maxHeading - minHeading > 180){
            returnHeading = Math.abs((minHeading - maxHeading)/2 + maxHeading);
            returnHeading = returnHeading > 360 ? returnHeading - 360 : returnHeading;
        } else{
            returnHeading = (maxHeading - minHeading)/2 + minHeading;
        }

       return returnHeading;
    }
}
