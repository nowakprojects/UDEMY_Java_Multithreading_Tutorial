package firsttime.lecutre14interruptingthreads;

import java.util.Random;

/**
 * Created by Mateusz on 12.01.2017.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting...");
        Thread t1 = new Thread(()->{
           Random random = new Random();

           for(int i=0;i<1E8;i++){
               /*if(Thread.currentThread().isInterrupted()){
                   System.out.println("Interrupted!");
                   break;
               }*/
               try {
                   Thread.sleep(1);
               } catch (InterruptedException e) {
                   System.out.println("Interrupted!");
                   break;
               }

               Math.sin(random.nextDouble());
           }
        });

        t1.start();

        Thread.sleep(1000);
        t1.interrupt();

        t1.join();

        System.out.println("Finished");
    }
}
