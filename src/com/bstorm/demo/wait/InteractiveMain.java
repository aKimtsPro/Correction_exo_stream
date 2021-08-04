package com.bstorm.demo.wait;

import java.util.Scanner;

public class InteractiveMain {

    public static void main(String[] args) {

        Test test = new Test();
        Thread t1 = new Thread(test::m1);
        Thread t2 = new Thread(test::m1);
        Thread t3 = new Thread(test::m1);
        Thread t4 = new Thread(test::m1);
        Scanner sc = new Scanner(System.in);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        while(true){
            sc.nextLine();
            test.m2();
        }
    }
}
