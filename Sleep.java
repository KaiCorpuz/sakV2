class OneSecondSleep{
    private int sleepNumber;

    OneSecondSleep(int sleepNumberIn){
        super();
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
}



public class Sleep{
    public void test(){
        System.out.println("Sleep Starting...");

        OneSecondSleep sleep0 = new OneSecondSleep(0);
        OneSecondSleep sleep1 = new OneSecondSleep(1);
        

        System.out.println("\nSleep");
        long start = System.currentTimeMillis();
        sleep0.sleep();
        sleep1.sleep();
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start));
    }
}