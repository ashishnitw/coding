package datastructures.string;

public class FindInitialsOfName {
    public static void printInitials(String name) {
        if(name.length() == 0) return;
        System.out.print(Character.toUpperCase(name.charAt(0)));
        for (int i = 1; i < name.length() - 1; i++) {
            if(name.charAt(i) == ' ')
                System.out.print(" " + Character.toUpperCase(name.charAt(i+1)));
        }
        System.out.print("\n");
    }

    public static void printInitials2(String name) {
        String[] s = name.split(" ");
        for(String word : s)
            System.out.print(Character.toUpperCase(word.charAt(0)) + " ");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        String name = "prabhat kumar singh";
        printInitials(name);
        printInitials2(name);
    }
}
