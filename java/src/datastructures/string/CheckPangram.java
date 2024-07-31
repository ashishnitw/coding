package datastructures.string;

public class CheckPangram {
    public static boolean check(String s) {
        boolean[] mark = new boolean[26];
        int index;
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                index = s.charAt(i) - 'A';
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                index = s.charAt(i) - 'a';
            else
                continue;
            mark[index] = true;
        }
        for(int i=0; i<26; i++) {
            if(!mark[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "The quick brown fox jumps over the lazy dog";
        System.out.println(check(s));
    }
}
