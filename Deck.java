import java.util.*;
import java.lang.Object;
/**
 * Creates the deck for the Uncle Wiggily game.
 * 
 * @Ryan Egan
 * @HW #1
 */
public class Deck
{
    private ArrayList<Card> currentDeck = new ArrayList<Card>(47);
    private Integer number;
    /**
     * Constructor to make a new deck.
     */
    public Deck(){
        shuffleDeck();
    }
  
    /**
     * "Shuffles" the deck. Places all cards into an array list aka the deck. 
     * @returns an array list full of 47 cards.
     */
    public ArrayList shuffleDeck(){
        currentDeck.add(new Card(10,"A cabbage lollipop now and then, will gain Uncle Wiggily a hop of ten!"));
        currentDeck.add(new Card(2,"Two hops more, that's what you're due, Uncle Wiggily loves you true!"));
        currentDeck.add(new Card(9,"Uncle Wiggily's paws aren't sore, he bounces ahead nine spots more!"));
        currentDeck.add(new Card(5,"Move five nice hops, are you nearly through? Uncle Wiggily thinks a lot of you."));
        currentDeck.add(new Card(7,"Uncle Wiggily hops seven ahead, along the path his paws will tread."));
        currentDeck.add(new Card(10,"Ten hops now, wow what speed!  Uncle Wiggily is happy indeed."));
        currentDeck.add(new Card(-2,"Uncle Wiggily says "+"achoo!" +" Now he'll have to hop back two."));
        currentDeck.add(new Card(2,"Uncle Wiggily hops ahead two, he loves to play this game with you!"));
        currentDeck.add(new Card(9,"Uncle Wiggily is feeling fine, with great speed he hops ahead nine."));
        currentDeck.add(new Card(4,"Uncle Wiggly hops along by four, now he likes you even more."));
        currentDeck.add(new Card(7,"Seven hops now for our favorite bunny, sometimes I think this game is funny."));
        currentDeck.add(new Card(10,"Hope you get this card again, Uncle Wiggily skips ahead ten!"));
        currentDeck.add(new Card(2,"Two hops more on this fine day, it's fun to help the bunny find his way."));
        currentDeck.add(new Card(-3,"Uncle Wiggily stops for tea, now he'll have to hop back three."));
        currentDeck.add(new Card(9,"Oh boy, what a good sign! Uncle Wiggily hops ahead nine."));
        currentDeck.add(new Card(4,"Move the bunny by four hops please, I hope you win this game with ease."));
        currentDeck.add(new Card(7,"Uncle Wiggily hops seven spots fast, he doesn't want to end up last! "));
        currentDeck.add(new Card(-3,"Uncle Wiggily stops for tea, now he'll have to hop back three."));
        currentDeck.add(new Card(10,"Hope you get this card again, Uncle Wiggily skips ahead ten!"));
        currentDeck.add(new Card(1,"Uncle Wiggily's as slow as a snail, move one hop then wag your tail."));
        currentDeck.add(new Card(8,"Hurry!  Hurry!  Don't be late, Uncle Wiggily hops ahead eight!"));
        currentDeck.add(new Card(4,"Uncle Wiggily's spirits soar, now he hops ahead by four!"));
        currentDeck.add(new Card(9,"Uncle Wiggily is looking good, hop ahead nine--you know he should!"));
        currentDeck.add(new Card(1,"Uncle Wiggily hops ahead one, he's moving slow--but still it's fun."));
        currentDeck.add(new Card(20,"Uncle Wiggily has speed aplenty, this time you move ahead by twenty!"));
        currentDeck.add(new Card(3,"Excuse me, but this is your chance, hop three spaces then do a dance."));
        currentDeck.add(new Card(10,"Hope you get this card again, Uncle Wiggily skips ahead ten!"));
        currentDeck.add(new Card(6,"Hop Uncle Wiggily ahead by six, this clever rabbit knows all the tricks."));
        currentDeck.add(new Card(8,"You'll win the game at this rate, hop Uncle Wiggily ahead by eight."));
        currentDeck.add(new Card(1,"Uncle Wiggily takes his time, just one hop says this rhyme."));
        currentDeck.add(new Card(12,"Twelve hops now, what a pace!  Uncle Wiggily's rushing to Possum's place."));
        currentDeck.add(new Card(3,"Where do I go?  Now I know, I'll take three hops and take them slow."));
        currentDeck.add(new Card(10,"Ha!  Ha!  Ha!  Isn't this funny?  Ten hops please for the rabbit bunny."));
        currentDeck.add(new Card(6,"Six hops now for the gentleman bunny, he's looking fine, he's feeling sunny."));
        currentDeck.add(new Card(8,"Uncle Wiggily won't be late, he hops along, this time by eight."));
        currentDeck.add(new Card(1,"Uncle Wiggily will not run, he's going forward--but just by one."));
        currentDeck.add(new Card(12,"Uncle Wiggily has twelve hops more, he's flying now--could you ask for more?"));
        currentDeck.add(new Card(3,"Uncle Wiggily hops ahead three, he's having fun--don't you agree?"));
        currentDeck.add(new Card(10,"If I were you, I think--just now, I'd take ten hops then stop and bow."));
        currentDeck.add(new Card(5,"He'd rather walk than take a drive, Uncle Wiggily hops ahead by five."));
        currentDeck.add(new Card(8,"The bunny jumps right through the air, eight nice hops--isn't that fair?"));
        currentDeck.add(new Card(1,"Just one hop for the bunny rabbit, If he loses his hat--the fox will grab it!"));
        currentDeck.add(new Card(10,"Put a smile on your face, ten hops forward might win the race!"));
        currentDeck.add(new Card(2,"Help Uncle Wiggily move right along, give him two hops and sing a song."));
        currentDeck.add(new Card(-2,"Uncle Wiggily says 'achoo!' Now he'll have to hop back two."));
        currentDeck.add(new Card(7,"Seven hops Uncle Wiggily will go, he waves at you and says hello!"));
        currentDeck.add(new Card(5,"Now you've done it! Look right there! Five hops--But don't fall off your chair!"));
        return currentDeck;
    }

    /**
     * Selects a card for the game. Picks one random card out of the deck and then removes it from the array. Also 
     * returns the card so that the user can use it.
     * @Param remainingCards is the number of cards remaining in the deck so that this method can correctly pick a random number.
     * @returns a Card, the selected card.
     */
    public Card selectCard(int remainingCards){
        Random pick = new Random();
        Integer number = pick.nextInt(remainingCards);
        Card pickedCard = currentDeck.get(number);
        currentDeck.remove(pickedCard);
        return pickedCard;
    }
   
}
