package ru.job4j.garbagecollector;

public class MemoryUsage {

    public static class User {

        public String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize");
        }
    }

    public static void main(String[] args) {
        info("start");
//        User user = new User("test");
//        info("after creating user");
//        user = null;
        for (int i = 0; i < 5000; i++) {
            new User("test");
        }

//        System.gc();
        info("after null and System.gc() ");
    }

    public static void info(String info) {
        Runtime runtime = Runtime.getRuntime();
        int mb = 1024 * 1024;
        System.out.printf("##### %s  #####%n", info);
        System.out.println("Used Memory:" + (runtime.totalMemory() / mb - runtime.freeMemory() / mb));
        System.out.println("Free Memory:" + runtime.freeMemory() / mb);
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);
        System.out.println("#################################");
    }
}
