package com.data.production.demo;
import java.util.Random;

public class RandomStrings {

    public void randomString() {
        String[] arr={"AB", "CD", "EF", "GH", "IJ", "KL", "MN", "OP", "QR"};
        Random r=new Random();
        int randomNumber=r.nextInt(arr.length);
        System.out.println(arr[randomNumber]);
    }
}