package pokerface

import org.junit.Test
import pokerface.entities.Card
import pokerface.entities.Face
import pokerface.entities.Hand
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class HandTest {
    @Test
    fun testToString() {
        val hand = Hand(listOf(
                Card(Face.HEARTS, 10),
                Card(Face.DIAMONDS, 8),
                Card(Face.CLUBS, 6),
                Card(Face.SPADES, 4),
                Card(Face.HEARTS, 2))
        )
        assertNotNull(hand.toString(), "Hand toString should not be null")
        assertEquals("10♥, 8♦, 6♣, 4♠, 2♥", hand.toString(), "Hand toString is incorrect")
    }

    @Test
    fun testToStringWithFaceCards() {
        val hand = Hand(listOf(
                Card(Face.HEARTS, 11),
                Card(Face.DIAMONDS, 12),
                Card(Face.CLUBS, 14),
                Card(Face.SPADES, 13),
                Card(Face.HEARTS, 2)
        ))
        assertNotNull(hand.toString(), "Hand toString should not be null")
        assertEquals("J♥, Q♦, A♣, K♠, 2♥", hand.toString(), "Hand toString is incorrect")
    }
}