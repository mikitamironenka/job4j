package ru.job4j.garbagecollector;

public class MemoryUsage {

    public static class User {

        private String name;
        private int num;

        public User(String name, int num) {
            this.name = name;
            this.num = num;
        }

//        @Override
//        protected void finalize() throws Throwable {
//            super.finalize();
//            System.out.println("finalize");
//        }
    }

    public static void main(String[] args) {
        info("start");
        long start = System.currentTimeMillis();

//        User user = new User("test");
//        info("after creating user");
//        user = null;
        for (int i = 0; i < 500000; i++) {
            new User("User", i);
        }

//        System.gc();

        info("after null and System.gc() ");
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println("Время выполнения программы - " + timeConsumedMillis);
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
