package com.careerit.jfs.cj.day10;


import java.util.Arrays;

class Student{
    private String name;
    private int age;
    private double height;
    private String mobile;

    public Student(String name, int age, double height, String mobile) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.mobile = mobile;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Mobile: " + mobile);
    }
}
public class StringAssignmentQuestion {


    public static void main(String[] args) {

        String data ="liril,john,malayalam,java,python,mom,dad,radar,.Net";
        String[] palindromeArr = getPalindromes(data);
        System.out.println(Arrays.toString(palindromeArr));


        String studentData ="Krish-30- 5.6 -1234567890 ,Manoj-25-5.5- 1234567891 ,Praveen-30-5.5-1234567892,Ramesh- 30 -5.5- 1234567893";

        // Convert studentData to Student array and display student details by calling showDetails method on each student
        int[] arr = new int[10];
        arr[0] = 10;
        System.out.println(Arrays.toString(arr));

    }

    private static String[] getPalindromes(String data) {
        String[] arr = data.split(",");
        int count = 0;
        String[] temp = new String[arr.length];
        for(int i=0;i<arr.length;i++){
            if(isPalindrome(arr[i])){
                temp[count++] = arr[i];
            }
        }
        if(count != temp.length){
            String[] res = new String[count];
            System.arraycopy(temp,0,res,0,count);
            temp = res;
        }
      return temp;
    }


    private static boolean isPalindrome(String str) {
        for(int i=0,j=str.length()-1;i<j;i++,j--){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
