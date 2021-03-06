package pokerface

import org.junit.Test
import pokerface.entities.Card
import pokerface.entities.Face
import pokerface.entities.Hand
import pokerface.logic.HandEvaluator
import pokerface.logic.HandRanking
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class HandEvaluatorTest {

    private val evaluator: HandEvaluator = HandEvaluator()

    @Test
    fun testHandRankingStraight(){
        val hand = Hand(listOf(
                Card(Face.HEARTS, 10),
                Card(Face.DIAMONDS, 8),
                Card(Face.CLUBS, 6),
                Card(Face.SPADES, 7),
                Card(Face.HEARTS, 9))
        )

        // assertEquals(HandRanking.STRAIGHT, evaluator.evaluate(hand))
    }

    @Test
    fun testHandRankingThreeOfAKind(){
        val hand = Hand(listOf(
                Card(Face.HEARTS, 10),
                Card(Face.DIAMONDS, 8),
                Card(Face.CLUBS, 6),
                Card(Face.SPADES, 10),
                Card(Face.HEARTS, 10))
        )

        assertEquals(HandRanking.THREE_OF_A_KIND, evaluator.evaluate(hand))
    }

    @Test
    fun testHandHasStraight() {
       // TODO this
    }

    @Test
    fun testHandHasThreeOfAKind() {
        val handWithoutThreeOfAKind = Hand(listOf(
                Card(Face.HEARTS, 10),
                Card(Face.DIAMONDS, 8),
                Card(Face.CLUBS, 6),
                Card(Face.SPADES, 9),
                Card(Face.HEARTS, 2))
        )

        assertFalse { evaluator.hasThreeOfAKind(handWithoutThreeOfAKind) }

        val hand = Hand(listOf(
                Card(Face.HEARTS, 10),
                Card(Face.DIAMONDS, 8),
                Card(Face.CLUBS, 6),
                Card(Face.SPADES, 10),
                Card(Face.HEARTS, 10))
        )

        assertTrue { evaluator.hasThreeOfAKind(hand) }
    }

    @Test
    fun testHandHasTwoPair() {
        val handWithoutTwoPair = Hand(listOf(
                Card(Face.HEARTS, 10),
                Card(Face.DIAMONDS, 8),
                Card(Face.CLUBS, 6),
                Card(Face.SPADES, 9),
                Card(Face.HEARTS, 2))
        )

        assertFalse { evaluator.hasTwoPair(handWithoutTwoPair) }

        val hand = Hand(listOf(
                Card(Face.HEARTS, 10),
                Card(Face.DIAMONDS, 8),
                Card(Face.CLUBS, 8),
                Card(Face.SPADES, 10),
                Card(Face.HEARTS, 2))
        )

        assertTrue { evaluator.hasTwoPair(hand) }
    }

    @Test
    fun testHandHasPair() {
        val handWithoutPair = Hand(listOf(
                Card(Face.HEARTS, 10),
                Card(Face.DIAMONDS, 8),
                Card(Face.CLUBS, 6),
                Card(Face.SPADES, 9),
                Card(Face.HEARTS, 2))
        )

        assertFalse { evaluator.hasPair(handWithoutPair) }

        val hand = Hand(listOf(
                Card(Face.HEARTS, 10),
                Card(Face.DIAMONDS, 8),
                Card(Face.CLUBS, 6),
                Card(Face.SPADES, 10),
                Card(Face.HEARTS, 2))
        )

        assertTrue { evaluator.hasPair(hand) }
    }
}