
/**
 * A simple class to create the cards to the deck of Uncle Wiggily
 * 
 * @Ryan Egan
 * @HW #1
 */
public class Card
{
    public int movement;
    public String cardMessage;
    /**
     * The constructor for the card. input the message on the card and the number of spaces to be moved.
     * @Param int move is the number of spaces to be moved.
     * @Param String message is the message that is on the card.
     */
   public Card(int move, String message){
       movement = move;
       cardMessage = message;
    }
}
