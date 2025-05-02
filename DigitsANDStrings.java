/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author u
 */
import java.util.Scanner;

public class DigitsANDStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("******************* Digits Library Menu *******************");

            System.out.println("1-  Most significant digit ");
            System.out.println("2-  My Substring ");
            System.out.println("3-  Longest Substring");
            System.out.println("4-  Repeared digits Length");
            System.out.println("5-  Digit Remove At");
            System.out.println("6-  Digit Remove All");
            System.out.println("7-  Generate random number");
            System.out.println("8-  Reverse digits");
            System.out.println("9-  Check palindrome");
            System.out.println("10- Char Digit");
            System.out.println("11- Exit");
            System.out.println("Select an operation:");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Please enter an integer parameter : ");
                    int n=input.nextInt();
                    System.out.println("First Digit is : "+FirstDigit(n));
                    break;
                case 2:
                    System.out.println("Please enter a String : ");
                    String first = input.next();
                    System.out.println("Please enter a String : ");
                    String second = input.next();
                    System.out.println("Result is : " + MySubstring(first,second));
                    break;
                case 3:
                    System.out.println("Please enter a String : ");
                    String first2 = input.next();
                    System.out.println("Please enter a String : ");
                    String second2 = input.next();
                    System.out.println("The longest substring between "+first2+" and "+second2+" is: "+LongestSubstring(first2,second2));
                    break;
                case 4 :
                    System.out.println("Please enter an integer parameter : ");
                    String d = input.next();
                    System.out.println("Result : "+RepeareddigitLength(d));
                    break;

                case 5:
                    System.out.println("Enter an integer:");
                    int n1 = input.nextInt();
                    System.out.println("Enter the index of the digit to be removed:");
                    int i = input.nextInt();
                    int result1 = digitRemoveAt(n1, i);
                    System.out.println("Result: " + result1);
                    break;
                case 6:
                    System.out.println("Enter an integer:");
                    int n2 = input.nextInt();
                    System.out.println("Enter the digit to be removed:");
                    int digit = input.nextInt();
                    int result2 = digitRemoveAll(n2, digit);
                    System.out.println("Result: " + result2);
                    break;
                case 7:
                    System.out.println("Enter the number of digits:");
                    int k = input.nextInt();
                    int result3 = randomNumber(k);
                    System.out.println("Result: " + result3);
                    break;
                case 8:
                    System.out.println("Enter an integer:");
                    int n4 = input.nextInt();
                    int result4 = reverse(n4);
                    System.out.println("Result: " + result4);
                    break;
                case 9:
                    System.out.println("Enter an integer:");
                    int n5 = input.nextInt();
                    boolean result5 = isPalindrome(n5);
                    System.out.println("Result: " + result5);
                    break;
                case 10:
                    System.out.println("Enter a String : ");
                    String str = input.next();
                    System.out.println("Enter an integer : ");
                    int code = input.nextInt();
                    System.out.println("Result is : "+charDigit(str,code));
                    break;
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 11);
        input.close();
    }






    public static int FirstDigit(int n){
     while (n>=10){
         n /= 10;
       }
     return n;
    }

    public static boolean MySubstring(String first, String second){
        if(first.contains(second)){
            return true;
        }else {
            return false;
        }
    }


    public static String LongestSubstring (String first, String second){
        String longestSubstring = "";
        int longestLength = 0;

        for (int i = 0; i <first.length() ; i++) {
            for (int j = 0; j <second.length() ; j++) {
                int length = 0;
                while (i + length < first.length() && j + length < second.length() && first.charAt(i + length) == second.charAt(j + length)) {
                    length++;
                }
                if (length > longestLength) {
                    longestLength = length;
                    longestSubstring = first.substring(i, i + length);
                }
            }
        }

        return longestSubstring;


            }



    public static int RepeareddigitLength(String number){
        int count = 0;
        for (int i = 0; i <number.length()-1 ; i++) {
            if(number.charAt(i)==number.charAt(i+1)){
                count++;
            }
        }
        return count;
    }

    public static int digitRemoveAt(int n, int i) {
        String str = Integer.toString(n);//int i Stringe çevirdim.
        String newStr = str.substring(0, i) + str.substring(i+1);
        return Integer.parseInt(newStr);//parseInt Stringi int e çevirir.
    }

    public static int digitRemoveAll(int n, int digit) {
        String str = Integer.toString(n);//int i Stringe çevirdim.
        String newStr = str.replace(Integer.toString(digit), "");//replace methodu değiştirir.
        return Integer.parseInt(newStr);//parseInt Stringi int e çevirir.
    }

    public static int randomNumber(int k) {
        int[] digits = new int[k]; // k basamaklı sayıyı tutacak dizi
        int number = 0;
        boolean unique;
        for (int i = 0; i < k; i++) {
            unique = false;
            while (!unique) {
                int digit = (int)(Math.random() * 10);
                if (i == 0 || !contains(digits, digit)) {
                    digits[i] = digit;
                    unique = true;
                }
            }
        }
        // Oluşturulan rakamları birleştirerek yeni bir tamsayı oluşturur.
        for (int i = 0; i < k; i++) {
            number += digits[i] * Math.pow(10, k - i - 1);
        }
        return number;
    }

    // Bir dizi içinde belirli bir rakamın olup olmadığını kontrol eder.
    public static boolean contains(int[] array, int digit) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == digit) {
                return true;
            }
        }
        return false;
    }

    public static int reverse(int n) {
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return reversed;
    }

    public static boolean isPalindrome(int n) {
        int reversed = 0;
        int original = n;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return original == reversed;
    }


    public static String charDigit(String str, int code) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == (char)code) {
                return str.substring(i,i+1);
            }
        }
        return "-1";//-1 dönder diyor ama dönmüyor.
    }}



