import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokedexGUI extends JFrame implements ActionListener {
    private JPanel centerPanel;
    public PokedexGUI(){
        super("Pokedex"); //sets the title window & constructor of JFrame
        setLayout(new BorderLayout()); //sets a layout inside the jFrame
        //so we are able to have a north south east west

        setSize(600, 800); //setting the size of the window
        setResizable(false);
        init();

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets the x button on the gui to actually close
    };

    private void init() {
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout()); //sets a flow layout in the south panel
        southPanel.setBackground(Color.BLACK);

        JButton pokedex = new JButton("Pokedex");
        southPanel.add(pokedex);
        pokedex.addActionListener(this);

        JButton moveDex = new JButton("MoveDex");
        southPanel.add(moveDex);

        JButton itemDex = new JButton("ItemDex");
        southPanel.add(itemDex);

        this.add(southPanel, BorderLayout.SOUTH); //command that actually adds the panel to the layout
        System.out.println("hello");

        //image
        centerPanel = new JPanel(new BorderLayout());
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\laemo\\Downloads\\main_menu.jpg");

        Image originalImage = originalIcon.getImage();

        //scaling
        Image scaledImage = originalImage.getScaledInstance(800,600, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        centerPanel.add(label, BorderLayout.CENTER);
        this.add(centerPanel, BorderLayout.CENTER);

    }
    @Override
    public void actionPerformed(ActionEvent e){ //method name & param cnnot be changed; actionEvent e contains info about which button was clicked etc
        JButton clickedButton = (JButton) e.getSource(); //this returns the button that was clicked
        String buttonText = clickedButton.getText(); //extracts the text on the button
        JOptionPane.showMessageDialog(this, "Opening Pokedex!", "Pokedex", JOptionPane.INFORMATION_MESSAGE);
        showPokedex();
    }

    public void showPokedex(){
        JPanel pokedexCenter = new JPanel();
        pokedexCenter.setLayout(new FlowLayout());

        this.remove(centerPanel);

        ImageIcon background = new ImageIcon("C:\\Users\\laemo\\Downloads\\pokemons.jpg");
        JLabel label = new JLabel(background);
        pokedexCenter.add(label);

        centerPanel = pokedexCenter;
        this.add(centerPanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

}
