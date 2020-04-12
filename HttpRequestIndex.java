//this part of the code was written based off the Parsing tutorial provided by Eric Pogue
public class HttpRequestIndex extends HttpRequest{
    public int obtainURL = 0;

    HttpRequestIndex(){
        super();
    }

    public Boolean parseIndex(){
        for(final String line : urlContent){
            parseLine(line);
        }
        
        return true;
    }

    private void parseLine(final String line){
        System.out.println("\nParsing:"+line);

        final String[] subString = line.split("\"");


        
        if (subString.length > 1){
            if(subString[9].equals("ContactURL")){
                String url = subString[11];
                HttpRequestIndex myHttpRequestIndex = new HttpRequestIndex();

                if(myHttpRequestIndex.readURL(url)){
                    System.out.println(myHttpRequestIndex);
                    obtainURL += 1;
                } 
            }
        }
    }
}