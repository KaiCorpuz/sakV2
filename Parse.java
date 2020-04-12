public class Parse{
    public static void main(final String[] args) {
        System.out.println("Starting Parse...");

        HttpRequestIndex requestIndex = new HttpRequestIndex();
        if(requestIndex.readURL("https://thunderbird-index.azurewebsites.net/w0a6zk195d.json")){
            System.out.println(requestIndex);
            requestIndex.parseIndex();
        }
        
    }
}