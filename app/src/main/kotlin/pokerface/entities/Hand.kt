package pokerface.entities

class Hand(val cards: List<Card>) {

    override fun toString(): String {
        return cards.joinToString(separator = ", ") { card -> card.toString() }
    }
}
