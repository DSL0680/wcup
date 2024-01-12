package org.zerock.wcup;

public class Sample<E, K> {

    public E value;
    private String type;



    Sample(E value){
        this.value = value;
    }

    public static void main(String[] args) {

        Sample<String,Integer > s1 = new Sample<>("AAA");
        Sample<Integer, String> s2 = new Sample<>(123);



    }

}
