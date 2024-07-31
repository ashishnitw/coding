package datastructures.string;

public class RemovePunctuations {
    public static String remove(String s) {
        return s.replaceAll("\\p{Punct}","");
    }

    public static void main(String[] args) {
        String s = "%welcome' to @geeksforgeek<s. Hello!!!, he said ---and went.";
        System.out.println(remove(s));
    }
}
