package org.zerock.wcup;

import java.lang.reflect.Field;

public class Student {

    public static void main(String[] args) throws Exception{

        Sample obj = new Sample();

        System.out.println(obj);

        Class clz = obj.getClass();

        Field  field = clz.getDeclaredField("name");

        field.setAccessible(true);

        field.set(obj, "AAAA");

        System.out.println(obj);


    }

}
