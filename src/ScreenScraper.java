//import java.swing.*;
import java.util.Scanner;
import java.net.URL;

public class ScreenScraper {
    public static void main(String[] args) {
        System.out.println("Now reading data from the Web...");
        DataReader.readWebData();
    }
     public static String getURL() {
        return ("https://thegreatestbooks.org/nonfiction");
    }
}
