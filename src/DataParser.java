import java.util.ArrayList;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class DataParser {
    public static ArrayList<BookProfile> parseObjData(ArrayList<String> objData) {
        ArrayList<BookProfile> bookProfiles = new ArrayList<BookProfile>();
        for(int i = 0; i < objData.size(); ++i) {
            //These are temporary data holders for the object data parsed and sent from DataReader. I split the data
            //based on the "by" that is in between all of the html code that deals with the author and title names.
            String temp = objData.get(i);
            String[] tempDataArray = temp.split("a> by");
            //This code creates a substring from the data that goes directly into the ArrayList of BookProfile objects.
            String titleNameTemp = StringUtils.substringBetween(tempDataArray[0], ">", "<");
            String itemNumberTemp = StringUtils.substringBetween(tempDataArray[0], "items/", ">");
            int itemNumber = Integer.parseInt(itemNumberTemp.substring(0, itemNumberTemp.length()-1));
            //This code does the same, both parse the author and item numbers as ints and subtracts 1 from the length in
            //order to take away a double apostrophe that got caught with them.
            String authorNameTemp = StringUtils.substringBetween(tempDataArray[1], ">", "<");
            String authorNumberTemp = StringUtils.substringBetween(tempDataArray[1], "authors/", ">");
            int authorNumber = Integer.parseInt(authorNumberTemp.substring(0, authorNumberTemp.length()-1));

            BookProfile newBook = new BookProfile();
            newBook.setTitle(titleNameTemp);
            newBook.setItemNumber(itemNumber);
            newBook.setAuthor(authorNameTemp);
            newBook.setAuthorNumber(authorNumber);

            bookProfiles.add(newBook);
        }
        return bookProfiles;
    }
}
