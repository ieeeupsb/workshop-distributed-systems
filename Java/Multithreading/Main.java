package Multithreading;

import Multithreading.Multi;

public class Main{
    public static void main(String[] args){
        Multi m = new Multi();

        while(true){
            System.out.println(m.getcounter());
        }
    }
}