//import java.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.URL;

public class ScreenScraper {
    public static void main(String[] args) {
        System.out.println("Now reading data from the Web...");
        ArrayList<BookProfile> books = DataParser.parseObjData(DataReader.readWebData());
    }
     public static String getURL() {
        return ("https://thegreatestbooks.org/nonfiction");
    }
}
