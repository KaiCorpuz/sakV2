public class SwissArmyKnife{
    //this code is written similar to sakl, but I changed the prompts
    //This Program is intended to be used in the console in order to 
    //do different things
    
    public static void main(String[] args){
        int count = 0;
        if(count == 0){
            count++;
            System.out.println("Welcome to Swiss Army Knife!");
            System.out.println("This program allows you to do many different things\n"); 
        }
        System.out.println("Swiss Army Knife working...");//initial greeting message
        System.out.println("");
        
        if(args.length < 1){
            System.out.println("At least one argument is required for this application.");
            System.out.println("use 'java SwissArmyKnife -Help' for more options. ");
            System.out.println("");
        }
        else if (args[0].equalsIgnoreCase("-Help")) {//-Help command and it prints the help menu
            long start = System.currentTimeMillis();
			System.out.println("Getting Help...");
            Help.printHelpMenu();
            System.out.println("Runtime: "+ (System.currentTimeMillis() - start) + "Milliseconds");		  
        }
        else if (args[0].equalsIgnoreCase("-HttpRequest")){
            long start = System.currentTimeMillis();//This is what calculates the time elapsed. Repeated throughout.
            System.out.println("Obtaining Information...");
            if(args.length<2){
                System.out.println("Please provide a valid URL.");
            }else{
				String URL = args[1];
				HttpRequest request = new HttpRequest();
				if (request.readURL(URL)) {
					System.out.println(request);
				}
            }
            long fin = System.currentTimeMillis();
            long elapsedTime = fin-start;
            System.out.println("Total time elapsed: "+ elapsedTime);
        }
        else if (args[0].equalsIgnoreCase("-HttpRequestIndex")){//Parses the index
            long start = System.currentTimeMillis();
            System.out.println("Retrieving...");
            if(args.length < 2){
                System.out.println("Please Provide a valid URL.");
            }else{
                String URL = args[1];
                HttpRequestIndex requestIndex = new HttpRequestIndex();
                if(requestIndex.readURL(URL)){
                    System.out.println(requestIndex);
                    requestIndex.parseIndex();
                }
            }
            System.out.println(System.currentTimeMillis() - start);
        }
        else if (args[0].equalsIgnoreCase("-DoMagicStuff")){
            long start = System.currentTimeMillis();
            System.out.println("Abracadabra!!!"); 
            System.out.println(System.currentTimeMillis() - start);  
        } 
        else if (args[0].equalsIgnoreCase("-Sleep")){//I changed the name of the main functions to get the 
            Sleep mySleep = new Sleep();             // the functionality of the program
            mySleep.test();
        }
        else if (args[0].equalsIgnoreCase("-SleepFast")){
            SleepFast mySleepFast = new SleepFast();
            mySleepFast.test1();
        }
        else if (args[0].equalsIgnoreCase("-SleepFastImplementsRunnable")){
            SleepFastIR sfir = new SleepFastIR();
            sfir.test2();

        }
        else if (args[0].equalsIgnoreCase("-JSONValidateIndex")){//This one does not really work. Notes in class file.
            long start = System.currentTimeMillis();
            String url = args[1];
            JSONValidateIndex validate = new JSONValidateIndex();
            if(args.length<3){
                System.out.println("Please Provide a URL.");
            }else {
                validate.readURL(url);
                System.out.println(validate);
                validate.parseIndex(); 
            
            }
            System.out.println(System.currentTimeMillis() - start);  
        }
    
    
    
    }
} 