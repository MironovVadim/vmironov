package ru.job4j;

import java.util.Date;

public class User {
    int i = 4;
    int j = 3;
    String l = "a";
    private static boolean isFin = false;

    private static int count = 0;

    public static void main(String[] args) {
        Date date = new Date();
        for (int i = 0; i < 20000; i++) {
            new User();
        }
        Date date2 = new Date();
        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Total memory: " + (runtime.totalMemory() / 1000));
        System.out.println("Used memory: " + (memory / 1000));
        System.out.println("Free memory: " + (runtime.freeMemory() / 1000));
        System.out.println("Total time: " + (date2.getTime() - date.getTime()));
        System.out.println("Count of finalize: " + User.count);
    }

    @Override
    protected void finalize() throws Throwable {
        if (!isFin) {
            System.out.println("finalize()");
            isFin = true;
            count++;
        } else {
            count++;
        }
        super.finalize();
    }
}
