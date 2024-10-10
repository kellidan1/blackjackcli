import java.util.ArrayList;
import java.util.Collections;

public class Deck {

  private final ArrayList<Card> cards;

  public Deck() {
    cards = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        cards.add(new Card(suit, rank));
      }
    }
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }

  public Card dealCard() {
    return cards.remove(cards.size() - 1);
  }

  public boolean isEmpty() {
    return cards.isEmpty();
  }
}