/**
 * HaikuGUI --- create GUI to display haikus
 * @author    Saralin Zassman
 */
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HaikuGUI{

    public static void createGUI(){
        //create frame
        JFrame frame = createFrame();
        JTextArea textTitle = createTitle();
        JTextArea textHaiku = createHaikuText();
        JButton button = createButton(textHaiku);

        frame.add(textTitle);
        frame.add(button);
        frame.add(textHaiku);
        frame.setVisible(true);
    }

    public static JFrame createFrame(){
        JFrame frame = new JFrame("Haiku Generator");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(500, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    public static JTextArea createTitle(){
        JTextArea textTitle = new JTextArea("Welcome to the Haiku Generator");
        textTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        textTitle.setEditable(false);
        return textTitle;
    }

    public static JTextArea createHaikuText(){
        JTextArea textHaiku = new JTextArea("");
        textHaiku.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        textHaiku.setEditable(false);
        return textHaiku;
    }

    public static JButton createButton(JTextArea textHaiku){
        JButton button = new JButton("Create a Haiku!");
        //every time the button is pressed, display another Haiku
        button.addActionListener(e -> {
            String haiku = null;
            try {
                while(haiku==null){
                    haiku = HaikuGenerator.generateHaiku();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            textHaiku.setText(haiku);
        });
        return button;
    }

}
