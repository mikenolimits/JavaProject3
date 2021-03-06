

import java.util.*;
import java.util.ArrayList;

/**
 * Created by michaelkantor on 3/2/15.
 */

public class WordSorter {

    protected TextFileInput reader;

    protected String        location;
    protected LinkedList    players;

    protected ArrayList<Player> unorganizedList;

    public boolean unorganized;

    /*
     Basic Constructor For WordSorting Object. It basically
     fills up our Words List from the TextFile.
     */
    public WordSorter(String location){

        this.location        = location;
        this.players         = new LinkedList();
        this.unorganizedList = new ArrayList<Player>();
        this.unorganized     = true;

        setWords();
    }

    /*
       Setter for words that iterates through
       the text file specified in the constructor
     */

    public void setWords(){

        System.out.println("reading words....");

        reader            = new TextFileInput(location);

        String current;


        while( (current = reader.readLine()) != null) {

            String [] allWordsInLine = current.split(",");

                append(allWordsInLine);

                Player currentPlayer = new Player(
                        allWordsInLine[0].charAt(0),
                        allWordsInLine[4],
                        allWordsInLine[1],
                        allWordsInLine[3],
                        allWordsInLine[2]
                );

                //Our First Column needs to be unorganized therefore even as we're looping
                //We need to stick all the players in one big pile.
                unorganizedList.add(currentPlayer);
        }

    }

    /**
     *
     * This method is responsible for add a new KV pair
     * into the linked List. In the case of the pitcher,
     * the dictionary gets
     * @param allWordsInLine
     */
    private void append(String[] allWordsInLine) {

        Map<String,String> currentPlayer = new HashMap<String,String>();

        String playerType = allWordsInLine[0];

        currentPlayer.put("playerType",playerType);
        currentPlayer.put("number",allWordsInLine[1]);
        currentPlayer.put("lastName",allWordsInLine[2]);
        currentPlayer.put("firstName",allWordsInLine[3]);
        currentPlayer.put("battingAvg",allWordsInLine[4]);


        switch (playerType.charAt(0)){
            case 'F':
                players.add(currentPlayer);
                break;
            case 'P':
                currentPlayer.put("era",allWordsInLine[5]);
                players.add(currentPlayer);
                break;
            default:
                throw new IllegalArgumentException("The Type Doesn't Exist...");
        }
    }

    public LinkedList getWords(){

        return players;
    }


}
