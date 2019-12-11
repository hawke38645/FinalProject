import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WebScraperUI extends JFrame {
    private JTextArea dataTextArea;
    public void fillTextArea() {
        String contents = "";
        ArrayList<BookProfile> profiles = (DataParser.parseObjData(DataReader.readWebData()));
        for(int i = 0; i < profiles.size(); ++i) {
            contents = contents + (profiles.get(i).toString());
        }
        dataTextArea.setText(contents);
    }
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
        //todo
        miAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        menuFile.add(miExit);
        menuHelp.add(miAbout);
        setJMenuBar(menuBar);
    }
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

        JLabel URLLabel = new JLabel("Enter URL:");
        panNorth.add(URLLabel);

        JTextField URLField = new JFormattedTextField();
        panNorth.add(URLField);

        JButton Fetch = new JButton("Fetch");
        Fetch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillTextArea();
            }
        });
        panNorth.add(Fetch);

        JButton saveAsText = new JButton("Save as text");
        saveAsText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataWriter.writeProfilesToTextFile(DataParser.parseObjData(DataReader.readWebData()));
                JOptionPane.showMessageDialog(null, "Data saved to .txt file.");
            }
        });
        panSouth.add(saveAsText);

        JButton saveAsJSON = new JButton("Save as JSON");
        saveAsJSON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataWriter.writeProfilesToJSON(DataParser.parseObjData(DataReader.readWebData()));
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
