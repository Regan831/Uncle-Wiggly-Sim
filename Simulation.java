import java.util.*;
import java.io.*;
/**
 * This class simulates any number of games of Uncle Wiggily. The user puts in how many games they want to play, then
 * the program outputs the average, max and min games for both the original board and the modified board. The program 
 * also prints the order in which cards were played for the max and min of the original board game.
 * 
 * @Ryan Egan
 * @HW 2
 */
public class Simulation
{
    private int space, turns, turns2, max, max2 =0;
    private int min2= 999;
    private int min = 999;
    private double total,tot=0;
    private Deck gameDeck;
    private ModifiedDeck gameDeck2;
    private int cards = 47;
    private ArrayList<Card> maxList = new ArrayList<Card>();
    private ArrayList<Card> minList = new ArrayList<Card>();

    /**
     * main class. Just runs the simulation.
     */
    public static void main(String args[]){
        new Simulation();
    }

    /**
     * Constructor for the simulation. Runs both the normal board and modified board x number of times. The user inputs
     * x in the terminal.
     */
    public Simulation(){
        double games = findGames();

        for(int x = 0;x < games;x++){
            UncleWiggily();
        }
        System.out.println("Data for normal board:");
        System.out.println("Average: "+findAverage(total,games));
        System.out.println("");
        printGame(minList);

        printGame(maxList);

        for(int x = 0;x<games;x++){
            mUncleWiggily();
        }
        System.out.println("Data for modified board:");
        System.out.println("Average: "+findAverage(tot,games));
        System.out.println("Min: "+getMin2());
        System.out.println("Max: "+getMax2());
        printGame2(minList);
        printGame2(maxList);

    }

    /**
     * Asks the user how many games they would like to simulate. 
     * @return double the number of games the user is simulating
     */
    public double findGames(){
        Scanner in = new Scanner(System.in);
        System.out.println("How many games would you like to simulate?");
        double n = in.nextDouble();
        return n;
    }

    /**
     * The basic game of uncle wiggily used from the first hw. Runs through a one player game until the user lands exactly
     * on the space 100. The user cannot pass past 100 or they remain on the spot they were at the begininning of the turn.
     * There are other things such as spaces that move the user back and forward. Shuffles the deck when there are zero
     * cards remaining. Also cahnges the max and min values when necessary and keeps track of total moves for the average.
     */
    public void UncleWiggily(){
        space = 0;
        turns = 0;
        ArrayList<Card> tempList = new ArrayList<Card>();
        gameDeck = new Deck();
        while(space != 100){
            turns++;
            if(cards == 0){ 
                gameDeck.shuffleDeck();
                cards = 47;
            }
            Card currentCard = gameDeck.selectCard(cards);
            tempList.add(currentCard);
            cards--;
            if(space + currentCard.movement < 100){
                if(space + currentCard.movement <0){
                    if(space != 0){
                        space = 1;
                    }
                    else{
                        space = 0;
                    }
                }
                else{
                    if(space + currentCard.movement == 58){
                        space = 83;
                    }
                    else{
                        if((space+currentCard.movement == 6) || (space+currentCard.movement == 23) || (space+currentCard.movement == 33) ||  (space+currentCard.movement == 43) ||  (space+currentCard.movement == 80) || (space+currentCard.movement == 90)){
                            space = space + currentCard.movement -3;
                        }
                        else{
                            space = space + currentCard.movement;
                        }
                    }
                }
            }
            else if((space + currentCard.movement) == 100){
                space = 100;
            }
        }
        if(turns>max){
            maxList.clear();
            max = turns;
            maxList.addAll(tempList);
        }
        if(turns<min){
            minList.clear();
            min = turns;
            minList.addAll(tempList);
        }
        total = total + turns;
    }

    /**
     * Runs through a one player game until the user lands exactly on the space 100. The user cannot pass past 100 or they remain on the spot they were at the begininning of the turn.
     * There are other things such as spaces that move the user back and forward. Shuffles the deck when there are zero
     * cards remaining. Also cahnges the max and min values when necessary and keeps track of total moves for the average.
     * The deck contains 56 cards.
     */
    public void mUncleWiggily(){
        space = 0;
        turns2 = 0;
        ArrayList<Card> tempList = new ArrayList<Card>();
        gameDeck2 = new ModifiedDeck();
        while(space != 100){
            turns2++;
            if(cards == 0){ 
                gameDeck2.shuffleDeck();
                cards = 56;
            }
            Card currentCard = gameDeck2.selectCard(cards);
            tempList.add(currentCard);
            cards--;
            if(space + currentCard.movement < 100){
                if(space + currentCard.movement <0){
                    if(space != 0){
                        space = 1;
                    }
                    else{
                        space = 0;
                    }
                }
                else{
                    if(space + currentCard.movement == 58){
                        space = 83;
                    }
                    else if(space + currentCard.movement == 18){
                        space = 39;
                    }
                    else if(space + currentCard.movement == 72){
                        space = 95;
                    }
                    else{
                        if((space+currentCard.movement == 6) || (space+currentCard.movement == 26) || (space+currentCard.movement == 36) ||  (space+currentCard.movement == 43) || (space+currentCard.movement == 53) || (space+currentCard.movement == 70) || (space+currentCard.movement == 81) ||(space+currentCard.movement == 97) || (space+currentCard.movement == 90)){
                            space = space + currentCard.movement -3;
                        }
                        else if((space+currentCard.movement == 11) || (space+currentCard.movement == 54) || (space+currentCard.movement == 68) || (space+currentCard.movement == 76)){
                            space = space + currentCard.movement -2;
                        }
                        else{
                            space = space + currentCard.movement;
                        }
                    }
                }
            }
            else if((space + currentCard.movement) == 100){

                space = 100;
            }
        }
        if(turns2>max2){
            maxList.clear();
            max2 = turns2;
            maxList.addAll(tempList);
        }
        if(turns2<min2){
            minList.clear();
            min2 = turns2;
            minList.addAll(tempList);
        }
        tot = tot + turns2;
    }

    /**
     * finds the average number of turns for a simulation.
     * @param double total turns taken
     * @param double total games played
     * @return double the average game length
     */
    public double findAverage(double t,double g){
        return (t/g);
    }

    /**
     * gets minimum number of turns to win for normal board.
     * @return int minimum number
     */
    public int getMin(){
        return min; 
    }

    /**
     * gets the minimum number of turns to win for the modified board.
     * @return int minimum number
     */
    public int getMin2(){
        return min2;
    }

    /**
     * gets the maximum number of turns to win for the modified board.
     * @return int maximum number
     */
    public int getMax2(){
        return max2;
    }

    /**
     * gets the maximum number of turns to win for the modified board.
     * @return int maximum number
     */
    public int getMax(){
        return max;
    }

    /**
     * Prints the gameplay of an array list. This is used to print the max and min of the normal board. The cards sequence
     * is saved in an array list then played here and printed.
     * @param ArrayList<Card> a cards in a specific order
     */
    public void printGame(ArrayList<Card> a){
        if(a!=null){
            space = 0;
      
            for(int i = 0;i<a.size();i++){
                Card currentCard = a.get(i);

            
                if(cards == 0){ 
                    System.out.println("Deck is out of cards, reshuffling the deck.");
                    gameDeck.shuffleDeck();
                    cards = 47;
                }

                cards--;
                System.out.println(currentCard.cardMessage);

                if(space + currentCard.movement < 100){
                    if(space + currentCard.movement <0){
                        space = 0;
                        System.out.println("Player moves from space " + space + " to 0.");
                    }
                    else{
                        if(space + currentCard.movement == 58){
                            System.out.println("Player has found a rabbit hole.");
                            System.out.println("Player moves from space " + space + " to 83");
                            space = 83;
                        }
                        else{
                            if((space+currentCard.movement == 6) || (space+currentCard.movement == 23) || (space+currentCard.movement == 33) ||  (space+currentCard.movement == 43) ||  (space+currentCard.movement == 80) || (space+currentCard.movement == 90)){
                                space = space + currentCard.movement -3;
                                System.out.println("Player has to move back three spaces.");
                            }
                            else{

                                System.out.println("Player moves from space " + space + " to " + (space+currentCard.movement) + ".");
                                space = space + currentCard.movement;
                            }
                        }
                    }

                }
                else if(space + currentCard.movement > 100){
                    System.out.println("Player has to stay put.");
                    System.out.println("Player moves from space " + space + " to " + space +".");

                }
                else if((space + currentCard.movement) == 100){
                    System.out.println("Player moves from space " + space + " to 100");
                    System.out.println("Player has won the game.");
                    System.out.println("The number of turns in this game was " + a.size());
                    space = 100;
                }

            }
        }
        System.out.println("");
    }

    public void printGame2(ArrayList<Card> a){
        if(a!=null){
            space = 0;
            cards = 56;
            turns = 0;
            for(int i = 0;i<a.size();i++){
                turns++;
                Card currentCard = a.get(i);
                if(cards == 0){ 
                    gameDeck2.shuffleDeck();
                    cards = 56;
                }
               cards--;
               System.out.println(currentCard.cardMessage);

                if(space + currentCard.movement < 100){
                    if(space + currentCard.movement <0){
                        if(space != 0){
                            space = 1;
                        System.out.println("Player moves from space " + space + " to 0.");
                        }
                        else{
                            space = 0;
                        System.out.println("Player moves from space " + space + " to 0.");
                        }
                    }
                    else{
                        if(space + currentCard.movement == 58){
                             System.out.println("Player has found a rabbit hole.");
                            System.out.println("Player moves from space " + space + " to 83");
                            space = 83;
                        }
                        else if(space + currentCard.movement == 18){
                             System.out.println("Player has found a rabbit hole.");
                            System.out.println("Player moves from space " + space + " to 39");
                            space = 39;
                        }
                        else if(space + currentCard.movement == 72){
                             System.out.println("Player has found a rabbit hole.");
                            System.out.println("Player moves from space " + space + " to 95");
                            space =95;
                        }
                        else{
                            if((space+currentCard.movement == 6) || (space+currentCard.movement == 26) || (space+currentCard.movement == 36) ||  (space+currentCard.movement == 43) || (space+currentCard.movement == 53) || (space+currentCard.movement == 70) || (space+currentCard.movement == 81) ||(space+currentCard.movement == 97) || (space+currentCard.movement == 90)){
                                space = space + currentCard.movement -3;
                                System.out.println("Player has to move back three spaces.");
                            }
                            else if((space+currentCard.movement == 11) || (space+currentCard.movement == 54) || (space+currentCard.movement == 68) || (space+currentCard.movement == 76)){
                                space = space + currentCard.movement -2;
                                System.out.println("Player has to move back two spaces.");
                            }
                            else{
                                System.out.println("Player moves from space " + space + " to " + (space+currentCard.movement) + ".");
                                space = space + currentCard.movement;
                            }
                        }
                    }
                }
                else if((space + currentCard.movement) == 100){
                    System.out.println("Player moves from space " + space + " to 100");
                    System.out.println("Player has won the game.");
                    System.out.println("The number of turns in this game was " + turns);
                    space = 100;
                }
                else{
                    System.out.println("Player has to stay put.");
                    System.out.println("Player moves from space " + space + " to " + space +".");
                }
                
            }
        }
        System.out.println("");
    }
}

