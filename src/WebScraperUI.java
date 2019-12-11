import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WebScraperUI extends JFrame {
    private JTextArea dataTextArea;
    private ArrayList<BookProfile> bookProfiles;
    /***
     * Takes in a String of the URL and connects online and retrieves the text into a string variable.
     *
     * @param webLink
     */
    public void fillTextArea(String webLink) {
        String contents = "";
        bookProfiles = (DataParser.parseObjData(DataReader.readWebData(webLink)));
        for(int i = 0; i < bookProfiles.size(); ++i) {
            contents = contents + (bookProfiles.get(i).toString());
        }
        dataTextArea.setText(contents);
    }
    /***
     * Sets up the top menu for the UI.
     */
    public void setUpMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuHelp = new JMenu("Help");
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Enter the URL in the field on top and press ENTER!");
            }
        });

        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        menuFile.add(miExit);
        menuHelp.add(miAbout);
        setJMenuBar(menuBar);
    }
    /***
     * Sets up the UI.
     */
    public WebScraperUI() {
        setTitle("Web Scraper");
        setBounds(200, 100, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        JPanel panSouth = new JPanel();
        panNorth.setLayout(new FlowLayout());
        panSouth.setLayout(new FlowLayout());

        dataTextArea = new JTextArea();
        Font Courier = new Font("Courier", Font.PLAIN, 10);
        dataTextArea.setFont(Courier);

        JLabel URLLabel = new JLabel("Enter URL:");
        panNorth.add(URLLabel);

        JTextField URLField = new JFormattedTextField();
        URLField.setColumns(31);
        panNorth.add(URLField);

        JButton Fetch = new JButton("Fetch");
        Fetch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillTextArea(URLField.getText());
            }
        });
        panNorth.add(Fetch);

        JButton saveAsText = new JButton("Save as text");
        saveAsText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataWriter.writeProfilesToTextFile(bookProfiles);
                JOptionPane.showMessageDialog(null, "Data saved to .txt file.");
            }
        });
        panSouth.add(saveAsText);

        JButton saveAsJSON = new JButton("Save as JSON");
        saveAsJSON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataWriter.writeProfilesToJSON(bookProfiles);
                JOptionPane.showMessageDialog(null, "Data saved to .json file.");
            }
        });
        panSouth.add(saveAsJSON);

        c.add(panSouth,BorderLayout.SOUTH);
        c.add(panNorth,BorderLayout.NORTH);
        c.add(dataTextArea, BorderLayout.CENTER);
        setUpMenu();
    }
}
