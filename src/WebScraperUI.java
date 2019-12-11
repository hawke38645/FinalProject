import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WebScraperUI extends JFrame {
    public void setUpMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuHelp = new JMenu("Help");
        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        JMenuItem menuAbout = new JMenuItem("About");
        //todo
        menuAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        menuFile.add(menuExit);
        menuHelp.add(menuAbout);
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

        JTextField URLField = new JFormattedTextField();
        panNorth.add(URLField);
        JButton Fetch = new JButton("Fetch");
        //todo
        Fetch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        panNorth.add(Fetch);
        JButton saveAsText = new JButton("Save as text");
        //todo
        saveAsText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        panSouth.add(saveAsText);
        JButton saveAsJSON = new JButton("Save as JSON");
        //todo
        saveAsJSON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        panSouth.add(saveAsJSON);
        JTextArea text = new JTextArea();

        c.add(panSouth,BorderLayout.SOUTH);
        c.add(panNorth,BorderLayout.NORTH);
        c.add(text, BorderLayout.CENTER);
        setUpMenu();
    }
}
