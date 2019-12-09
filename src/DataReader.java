import java.util.Scanner;
import java.net.URL;
import java.util.ArrayList;
import java.io.File;
import java.util.regex.Pattern;


public class DataReader {
    public static ArrayList<String> readWebData() {
        ArrayList<String> objData = new ArrayList<String>();
        try {
            URL link = new URL(ScreenScraper.getURL());
            Scanner urlScanner = new Scanner(link.openStream());
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
        for(int i = 0; i < objData.size(); ++i) {
            System.out.println(objData.get(i));
        }
        return objData;
    }
}
