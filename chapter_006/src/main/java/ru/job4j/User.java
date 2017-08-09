package ru.job4j;

public class User {
    int i = 4;
    int j = 3;
    String l = "a";

    public static void main(String[] args) {
        for (int i = 0; i < 7500; i++) {
            new User();
        }
        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Total memory: " + runtime.totalMemory());
        System.out.println("Used memory: " + memory);
        System.out.println("Free memory: " + runtime.freeMemory());
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize()");
        super.finalize();
    }


}
