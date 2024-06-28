package model;

public class Counter implements AutoCloseable {
    private  int x;
    static int count;

    public Counter() throws Exception {
        x = 0 ;
    }
    public static void add() {
        count++;
    }

    @Override
    public void close() {
        System.out.println("Завершено");
    }
    public int getCount() {
        return count;
    }
}
