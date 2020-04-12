import java.util.ArrayList;


class OneSecondSleeper1 implements Runnable{
    private int sleepNumber;

    OneSecondSleeper1(int sleepNumberIn){
        sleepNumber = sleepNumberIn;
    }
    public void sleep(){//this uses the thread library and does time in milliseconds
        System.out.println(sleepNumber + "- Going to sleep");
        try{
            Thread.sleep(1000); //sleep for one second
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }
        System.out.println("... " + sleepNumber + "- Done sleeping");
    }

    public void run(){
        sleep();
    }
}



public class SleepFastIR{
    public void test2(){
        System.out.println("Sleep Starting...");

        OneSecondSleeper1 sleep0 = new OneSecondSleeper1(0);
        OneSecondSleeper1 sleep1 = new OneSecondSleeper1(1);
        

        System.out.println("\nSingle-Threaded Sleep");
        long start = System.currentTimeMillis();
        sleep0.sleep();
        sleep1.sleep();
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start));

        System.out.println("\nThreaded Sleep");
        start = System.currentTimeMillis();

        Thread t0 = new Thread(sleep0);
        Thread t1 = new Thread(sleep1);

        t0.start();
        t1.start();

        try{
            t0.join();
            t1.join();
        }catch(Exception e){
            System.out.println("Exception" + e);
        }
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start + "\n"));

        //Sleeping Arraylist

        ArrayList<OneSecondSleeper1> sleeperList = new ArrayList<OneSecondSleeper1>();
        for (int i=2; i<12; i++){
            sleeperList.add(new OneSecondSleeper1(i));
        }

        System.out.println("\nNon-Threaded ArrayList Sleep");
        start = System.currentTimeMillis();
        for (OneSecondSleeper1 s: sleeperList){
            s.sleep();
        }
        System.out.println("Elapsed time = " + (System.currentTimeMillis()- start));

        System.out.println("\nThreaded ArrayList Sleep:");
        ArrayList<Thread> threadList = new ArrayList<Thread>();
        for (OneSecondSleeper1 s: sleeperList){
            threadList.add(new Thread(s));
        }

        start = System.currentTimeMillis();
        for(Thread t: threadList){
            t.start();
        }

        try{
            for(Thread t: threadList){
                t.join();
            }
        }catch(Exception e){
            System.out.println("Exception: "+ e);
        }
        System.out.println("Elapsed time = " +(System.currentTimeMillis()-start));
    }

}
