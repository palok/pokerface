package pokerface.entities

class Card(private val face: Face, val value: Int) {
    override fun toString(): String {
        return when (face) {
            Face.SPADES -> "${getFaceValue()}♠"
            Face.DIAMONDS -> "${getFaceValue()}♦"
            Face.CLUBS -> "${getFaceValue()}♣"
            Face.HEARTS -> "${getFaceValue()}♥"
        }
    }

    private fun getFaceValue(): String {
        return when (value) {
            1 -> "A"
            11 -> "J"
            12 -> "Q"
            13 -> "K"
            14 -> "A"
            else -> value.toString()
        }
    }
}
