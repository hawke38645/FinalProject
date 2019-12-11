/***
 * This class has 4 private data members: title, itemNumber, author, and authorNumber.
 */
public class BookProfile {

    private String title;
    private String author;
    private int itemNumber;
    private int authorNumber;

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setItemNumber(int itemNum) {
        this.itemNumber = itemNum;
    }
    public void setAuthorNumber(int authorNum) {
         this.authorNumber = authorNum;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getItemNumber() {
        return itemNumber;
    }
    public int getAuthorNumber() {
        return authorNumber;
    }

    @Override
    public String toString() {
        return String.format(title + "\t" + itemNumber + "\t" + author + "\t" + authorNumber + "\r\n");
    }
}
