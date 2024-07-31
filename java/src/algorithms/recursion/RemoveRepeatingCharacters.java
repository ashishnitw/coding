package algorithms.recursion;

public class RemoveRepeatingCharacters {

    public static String removeRepeating(String s) {
        if(s.length() <= 1) {
            return s;
        }
        if(s.substring(0, 1).equals(s.substring(1, 2))) {
            return removeRepeating(s.substring(1));
        }
        return s.substring(0, 1) + removeRepeating(s.substring(1));
    }

    public static void main(String[] args) {
        String input1 = "Helloo";
        String input2 = "Thiss iiss aa teesstt";
        System.out.println( "Original string: " + input1);
        System.out.println("String after: " + removeRepeating(input1));

        System.out.println( "Original string: " + input2);
        System.out.println("String after: " + removeRepeating(input2));
    }
}
