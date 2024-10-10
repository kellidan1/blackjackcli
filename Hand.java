import java.util.ArrayList;

public class Hand {

  private final ArrayList<Card> cards;

  public Hand() {
    cards = new ArrayList<>();
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public ArrayList<Card> getCards() {
    return cards;
  }

  public int getHandValue() {
    int value = 0;
    int aceCount = 0;
    for (Card card : cards) {
      value += card.getRank().getValue();
      if (card.getRank() == Rank.ACE) {
        aceCount++;
      }
    }
    while (value > 21 && aceCount > 0) {
      value -= 10;
      aceCount--;
    }
    return value;
  }

  public boolean isSoft() {
    return cards.stream().anyMatch(card -> card.getRank() == Rank.ACE) && getHandValue() <= 21;
  }
}