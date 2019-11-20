package com.alg.struct;


/**
 * @author
 */
public class StringConstantPool {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = s1;
        String s3 = new String("123");

        String s4 = new String("123");

        System.out.println("s1==s2 : " + (s1 == s2)); // true

        System.out.println("s1==s3 : " + (s1 == s3)); // false

        System.out.println("s3==s4 : " + (s4 == s3)); // false

        s1 = "456";
        String intern = s3.intern();

        System.out.println("s1==s2 : " + (s1 == s2)); // false

        System.out.println("s2==s3 : " + (s2 == s3)); // false

        System.out.println("s2==intern : " + (s2 == intern));  // true

        System.out.println("s1 = " + s1 + "\t s2 =" + s2); //s1 = 456	 s2 =123
    }
}
