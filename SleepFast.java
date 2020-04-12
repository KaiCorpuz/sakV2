import java.util.ArrayList;


class OneSecondSleeper extends Thread{
    private int sleepNumber;

    OneSecondSleeper(int sleepNumberIn){
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



public class SleepFast{
    public void test1(){
        System.out.println("Sleep Starting...");

        OneSecondSleeper sleep0 = new OneSecondSleeper(0);
        OneSecondSleeper sleep1 = new OneSecondSleeper(1);
        

        System.out.println("\nSingle-Threaded Sleep");
        long start = System.currentTimeMillis();
        sleep0.sleep();
        sleep1.sleep();
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start));

        System.out.println("\nThreaded Sleep");
        start = System.currentTimeMillis();
        sleep0.start();

        try{
            sleep0.join();
            sleep1.join();
        }catch(Exception e){
            System.out.println("Exception" + e);
        }
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start + "\n"));

        //Sleeping Arraylist

        ArrayList<OneSecondSleeper> sleeperList = new ArrayList<OneSecondSleeper>();
        for (int i=2; i<12; i++){
            sleeperList.add(new OneSecondSleeper(i));
        }

        System.out.println("\nNon-Threaded ArrayList Sleep");
        start = System.currentTimeMillis();
        for (OneSecondSleeper s: sleeperList){
            s.sleep();
        }
        System.out.println("Elapsed time = " + (System.currentTimeMillis()- start));

        System.out.println("\nThreaded ArrayList Sleep:");
        start = System.currentTimeMillis();
        for(OneSecondSleeper s: sleeperList){
            s.start();
        }

        try{
            for(OneSecondSleeper s: sleeperList){
                s.join();
            }
        }catch(Exception e){
            System.out.println("Exception: "+ e);
        }
        System.out.println("Elapsed time = " +(System.currentTimeMillis()-start));
    }

}
