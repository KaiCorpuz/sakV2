import java.util.ArrayList;

//Hi Eric
//I could not figure out this part of the program. I feel like I was on the right track, but I could not 
//get to the next step to validate the key words.

public class JSONValidateIndex extends HttpRequestIndex{
    
    ArrayList<HttpRequestIndex> indexList = new ArrayList<HttpRequestIndex>(14);
    ArrayList<String> wordList = new ArrayList<String>();
    //I think I was doing something correct here but I did not know where to go from there.
    

    JSONValidateIndex(){
        super();
    }

    public Boolean parseIndex(){
        for(final String line : urlContent){
            parseLine(line);
        }
        
        return true;
    }

    public void parseLine(final String line){
        System.out.println("\nParsing:"+line);

        final String[] subString = line.split("\"");

        
        if (subString.length > 1){
            if(subString[9].equals("ContactURL")){
                String url = subString[11];
                HttpRequestIndex myHttpRequestIndex = new HttpRequestIndex();
                if(myHttpRequestIndex.readURL(url)){
                    indexList.add(myHttpRequestIndex);
                    System.out.println(indexList);
                }

            }

        }
        
    }

}

