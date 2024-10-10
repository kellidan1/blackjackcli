public class Dealer {

  private final Hand hand;

  public Dealer() {
    hand = new Hand();
  }

  public void hit(Deck deck) {
    hand.addCard(deck.dealCard());
  }

  public Hand getHand() {
    return hand;
  }

  public int getHandValue() {
    return hand.getHandValue();
  }

  public boolean isBust() {
    return getHandValue() > 21;
  }

  public Card getUpCard() {
    return hand.getCards().get(0);
  }
}