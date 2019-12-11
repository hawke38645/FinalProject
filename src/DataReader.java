import java.util.Scanner;
import java.net.URL;
import java.util.ArrayList;

public class DataReader {
    /***
     * Takes in a string that contains a URL and connects to the internet, parsing a website's HTML foe information.
     * @param webLink
     * The return is an arrayList of String objects that contain all the lines of HTML with book information.
     * @return
     */
    public static ArrayList<String> readWebData(String webLink) {
        ArrayList<String> objData = new ArrayList<String>();
        try {
            URL link = new URL(webLink);
            Scanner urlScanner = new Scanner(link.openStream());
            //If the line begins with ". <a href=", it means this particular website HTML contains the book information.
            while(urlScanner.hasNextLine()) {
                String objString = urlScanner.nextLine();
                if (objString.startsWith(". <a href=")) {
                    objData.add(objString);
                }
                else {
                    continue;
                }
            }
            System.out.println("The data has been successfully read from the Web!");
        }
        catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Failed to read contents from the web...");
        }
        return objData;
    }
}
