import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.URL;

public class WebScraper {
    public static void main(String[] args) {
        System.out.println("Now reading data from the Web...");
        WebScraperUI frm = new WebScraperUI();
        frm.setVisible(true);
    }
     public static String getURL() {
        return ("https://thegreatestbooks.org/nonfiction");
    }
}


//Link to the website: https://thegreatestbooks.org/nonfiction