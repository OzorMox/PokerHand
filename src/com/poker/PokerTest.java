package com.poker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PokerTest
{
	@Test
	void highCard()
	{
		Poker p = new Poker();
		
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Rank.Five, Suit.Clubs));
		cards.add(new Card(Rank.Ten, Suit.Diamonds));
		cards.add(new Card(Rank.Two, Suit.Clubs));
		cards.add(new Card(Rank.Queen, Suit.Hearts));
		cards.add(new Card(Rank.Jack, Suit.Spades));
		
		Hand h = p.getBestHand(cards);
		assertEquals(Hand.HighCard, h);
	}
	
	@Test
	void onePair()
	{
		Poker p = new Poker();
		
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Rank.Five, Suit.Clubs));
		cards.add(new Card(Rank.Five, Suit.Diamonds));
		cards.add(new Card(Rank.Two, Suit.Clubs));
		cards.add(new Card(Rank.Queen, Suit.Hearts));
		cards.add(new Card(Rank.Jack, Suit.Spades));
		
		Hand h = p.getBestHand(cards);
		assertEquals(Hand.OnePair, h);
	}
	
	@Test
	void twoPair()
	{
		Poker p = new Poker();
		
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Rank.Five, Suit.Clubs));
		cards.add(new Card(Rank.Five, Suit.Diamonds));
		cards.add(new Card(Rank.Queen, Suit.Clubs));
		cards.add(new Card(Rank.Queen, Suit.Hearts));
		cards.add(new Card(Rank.Jack, Suit.Spades));
		
		Hand h = p.getBestHand(cards);
		assertEquals(Hand.TwoPair, h);
	}
	
	@Test
	void threeOfAKind()
	{
		Poker p = new Poker();
		
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Rank.Five, Suit.Clubs));
		cards.add(new Card(Rank.Queen, Suit.Diamonds));
		cards.add(new Card(Rank.Queen, Suit.Clubs));
		cards.add(new Card(Rank.Queen, Suit.Hearts));
		cards.add(new Card(Rank.Jack, Suit.Spades));
		
		Hand h = p.getBestHand(cards);
		assertEquals(Hand.ThreeOfAKind, h);
	}
	
	@Test
	void straight()
	{
		Poker p = new Poker();
		
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Rank.Five, Suit.Clubs));
		cards.add(new Card(Rank.Six, Suit.Diamonds));
		cards.add(new Card(Rank.Seven, Suit.Clubs));
		cards.add(new Card(Rank.Eight, Suit.Hearts));
		cards.add(new Card(Rank.Nine, Suit.Spades));
		
		Hand h = p.getBestHand(cards);
		assertEquals(Hand.Straight, h);
	}
}
