package pokerface.logic

import pokerface.entities.Hand

class HandEvaluator {

    fun evaluate(hand: Hand): HandRanking {
        return when {
//            hasStraight(hand) -> {
//                HandRanking.STRAIGHT
//            }
            hasThreeOfAKind(hand) -> {
                HandRanking.THREE_OF_A_KIND
            }
            hasTwoPairMinimum(hand) -> {
                HandRanking.TWO_PAIR
            }
            hasPairMinimum(hand) -> {
                HandRanking.PAIR
            }
            else -> {
                HandRanking.HIGH_CARD
            }
        }
    }

    fun hasPairMinimum(hand: Hand): Boolean {
        return hand.cards.distinctBy { card -> card.value }.size == 4
    }

    fun hasThreeOfAKind(hand: Hand): Boolean {
        return hand.cards.distinctBy { card -> card.value }.size == 3
    }

    fun hasTwoPairMinimum(hand: Hand): Boolean {
        return hand.cards.groupingBy { card -> card.value }
                .eachCount()
                .entries.stream()
                .filter { group -> group.value == 2 }
                .count().toInt() == 2
    }


}