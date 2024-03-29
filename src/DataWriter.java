import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayList;
import org.json.simple.*;

public class DataWriter {
    /***
     * Takes in an ArrayList of BookProfile objects and writes them to a tab delimited text file.
     * @param bookProfiles
     */
    public static void writeProfilesToTextFile(ArrayList<BookProfile> bookProfiles) {
        try {
            //Creating a new file and object to write to the file
            String fileName = "booksText";
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            //Here we cycle through the ArrayList of BookProfile objects and use the get functions to push out each
            //individual profile's information with a tab. A new line is created at the end and it all repeats.
            for (int i = 0; i < bookProfiles.size(); ++i) {
                bw.write(bookProfiles.get(i).getTitle() + "\t");
                bw.write(bookProfiles.get(i).getItemNumber() + "\t");
                bw.write(bookProfiles.get(i).getAuthor() + "\t");
                bw.write(bookProfiles.get(i).getAuthorNumber() + "\t");
                bw.newLine();
            }
            bw.close();
            System.out.println("The data has been successfully written to the file.");
        }
        catch (IOException ex) {
            System.out.println("Could not write to file...");
        }
    }
    /***
     * Takes in an ArrayList of BookProfile objects and writes them to a JSON file.
     * @param bookProfiles
     */
    public static void writeProfilesToJSON(ArrayList<BookProfile> bookProfiles) {
        try {
            String fileName = "bookJS";
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            JSONObject bookObj;
            JSONArray bookObjArray = new JSONArray();
            //This is the loop for
            for (int i = 0; i < bookProfiles.size(); ++i) {
                bookObj = new JSONObject();
                bookObj.put("TitleName",bookProfiles.get(i).getTitle());
                bookObj.put("ItemNumber",bookProfiles.get(i).getItemNumber());
                bookObj.put("AuthorName",bookProfiles.get(i).getAuthor());
                bookObj.put("AuthorNumber",bookProfiles.get(i).getAuthorNumber());
                bookObjArray.add(bookObj);
            }
            JSONObject outer = new JSONObject();
            outer.put("Book Profiles", bookObjArray);
            pw.println(outer.toJSONString());
            pw.close();
            System.out.println("The data has been successfully written to the file.");
        }
        catch(Exception ex) {
            System.out.println("Could not write to the file...");
        }
    }
    /***
     * Takes in an ArrayList of BookProfile objects and writes them to the screen.
     * @param bookProfiles
     */
    public static void writeProfilesToScreen(ArrayList<BookProfile> bookProfiles) {
        for(int i = 0; i < bookProfiles.size(); ++i) {
            System.out.println(bookProfiles.get(i).toString());
        }
    }
}
