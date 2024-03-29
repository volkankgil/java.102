package Multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class mainhomework {
    public static void main(String[] args) {

        Homework h1=new Homework();

        //Thread t1=new Thread(h1);
        //t1.start();

        ExecutorService exe= Executors.newFixedThreadPool(4);

        for(int i=1;i<=10000;i++){
            exe.execute(h1);
        }
        //exe.shutdown();  //iş parçaçığının durması için yazıyoruz.
        try {
            exe.awaitTermination(1,TimeUnit.MILLISECONDS);// BU METODDAN SONRA PROGRAMIN NE KADAR ÇALIŞACAĞINI BELİRLEYEBİLİYORUZ.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Even Numbers : " +h1.getTeksayılar().size());

        System.out.println("Odd Numbers : " +h1.getçiftsayılar().size());

    }
}
