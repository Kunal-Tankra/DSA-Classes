
import java.util.*;
import java.util.Arrays;

public class Strings {

    public static void printAllChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
    }

    public static void checkPalindrome(String str) {
        boolean palindrome = true;

        for (int i = 0; i <= (str.length() - 1) / 2; i++) {
            int j = str.length() - 1 - i;

            if (str.charAt(i) != str.charAt(j)) {
                palindrome = false;
                break;
            }
        }

        if (palindrome) {

            System.out.println("palindrome");
        } else {
            System.out.println("Not Palindrome");

        }
    }

    public static void getShortestPath(String str) {
        int x = 0, y = 0;

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'N':
                    y++;
                    break;

                case 'S':
                    y--;
                    break;

                case 'E':
                    x++;
                    break;

                case 'W':
                    x--;
                    break;

            }
        }

        float displacement = (float) Math.sqrt((x * x) + (y * y));
        System.out.println(displacement);
    }

    public static void substring(String str, int si, int ei) {
        String substr = "";
        for (int i = si; i < ei; i++) {
            substr += str.charAt(i);
        }

        System.out.println(substr);
    }

    public static void toUpperCase(String str1) {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str1.charAt(0));
        sb.append(ch);

        for (int i = 1; i < str1.length(); i++) {
            if (str1.charAt(i - 1) == ' ') {
                sb.append(Character.toUpperCase(str1.charAt(i)));
            } else {
                sb.append(str1.charAt(i));
            }
        }

        System.out.println(sb.toString());
    }

    public static void compression(String str) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            char ch = str.charAt(i);

            while (i < str.length() - 1 && ch == str.charAt(i + 1)) {
                count++;
                i++;
            }

            sb.append(ch);
            if (count > 1) {
                sb.append(count);
            }

        }
        System.out.println(sb.toString());
    }

    // practice questions
    // 1.
    public static void countLowercaseVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        System.out.println(count);
    }

    // 4.
    public static void checkAnagrams(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        boolean anagrams = false;

        if (str1.length() == str2.length()) {
            // method 1.. mine

            // for (int i = 0; i < str1.length(); i++) {
            // boolean breakLoop = false;
            // for (int j = 0; j < str2.length(); j++) {
            // if (str1.charAt(i) == str2.charAt(j)) {
            // anagrams = true;
            // break;
            // } else if (j == str2.length() - 1 && str1.charAt(i) != str2.charAt(j)) {
            // anagrams = false;
            // breakLoop = true;
            // }
            // }

            // if (breakLoop) {
            // break;
            // }
            // }

            // method 2... best..
            char str1Arr[] = str1.toCharArray();
            char str2Arr[] = str2.toCharArray();
            
            Arrays.sort(str1Arr);
            Arrays.sort(str2Arr);

            anagrams = Arrays.equals(str1Arr, str2Arr);
            
        }

        if (anagrams) {
            System.out.println("anagrams");
        } else {
            System.out.println("not anagrams");

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // String str = "NS";
        // String str2 = new String("NS");

        // if(str.equals(str2)){
        // System.out.println(true);
        // }
        // else{
        // System.out.println(false);
        // }

        String str = "HelloWorld";
        // System.out.println(str.substring(0,6));
        // substring(str, 0, 6);

        String fruits[] = { "apple", "mango", "banana" };

        String biggest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (fruits[i].compareToIgnoreCase(biggest) > 0) {
                biggest = fruits[i];
            }
        }
        // System.out.println(biggest);

        StringBuilder sb = new StringBuilder("");
        for (char i = 'a'; i <= 'z'; i++) {
            sb.append(i);
        }
        // System.out.println(sb);

        String str1 = "hello WORLD";
        // toUpperCase(str1);

        String str2 = "abccd";
        // compression(str2);

        String str3 = "Aa";
        // countLowercaseVowels(str3);

        String str4 = "raey";
        String str5 = "yaer";
        // checkAnagrams(str4, str5);

      


		StringBuffer sb1 = new StringBuffer("Hello ");
        sb1.replace(1,3,"Java"); 
		System.out.println(sb1);
	}
}

