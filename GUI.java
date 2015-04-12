
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI  extends JFrame{


    String words[];
    TextArea text1;
    TextArea text2;
    TextArea text3;

    /*
       Constructor for the GUI to do basic setup.
       It creates a 1 row, 2 column layout each with their own
       Textarea
     */
    public GUI(String title, int width, int height){

        words = new String[]{};
        text1 = new TextArea();
        text2 = new TextArea();
        text3 = new TextArea();


        setTitle(title);
        setSize(width,height);
        add(text1);
        add(text2);
        add(text3);

        setLayout(new GridLayout(1,3));
        setVisible(true);
        text1.setBackground(Color.cyan);
        text2.setBackground(Color.magenta);
        text3.setBackground(Color.pink);

    }

    /*
       Helper method to append text to the GUI from a LinkedList
       Instead of a regular one.
     */

    public void organizeColumn(LinkedList column, int index) {

        switch (index){
            case 2:
                for (int i = 0; i < column.fielders.size(); i++) {

                    Fielder player        =  column.fielders.get(i);
                    String currentLine    =  player.toString();
                    text2.append(currentLine);
                }
                break;
            case 3:
                for (int i = 0; i < column.pitchers.size(); i++) {
                    Pitcher player        =  column.pitchers.get(i);
                    String currentLine    =  player.toString();
                    text3.append(currentLine);
                }
                break;
            default:
                throw new IllegalArgumentException("Index out of bounds.");
        }
    }

      /*
      Just a tiny helper method to avoid 2 for loops. It takes the GUIs
      TextArea and appends the array of strings from the particular column into
      the GUI
     */

    public void organizeColumn(ArrayList<Player> column, TextArea text){
        for (int i = 0; i < column.size(); i++) {
            Player player        =  column.get(i);
            String currentLine   =  player.toString();
            text.append(currentLine);
        }
    }

}


