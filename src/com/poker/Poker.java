package com.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poker
{
	public Hand getBestHand(List<Card> cards)
	{
		List<Integer> rankValues = new ArrayList<Integer>();
		for (Card card : cards)
		{
			rankValues.add(card.getRank().ordinal());
		}
		
		Collections.sort(rankValues);
		
		boolean straight = true;
		for (int i = 0; i < rankValues.size(); i++)
		{
			if (i == 0)
			{
				continue;
			}
			else
			{
				if (rankValues.get(i) - rankValues.get(i - 1) != 1)
				{
					straight = false;
				}
			}
		}
		if (straight)
		{
			return Hand.Straight;
		}
		
		List<Rank> ranks = new ArrayList<Rank>();
		List<Rank> pairs = new ArrayList<Rank>();
		for (Card card : cards)
		{			
			if (ranks.contains(card.getRank()))
			{
				if (pairs.contains(card.getRank()))
				{
					return Hand.ThreeOfAKind;
				}
				
				pairs.add(card.getRank());
			}
			ranks.add(card.getRank());
		}
		
		if (pairs.size() == 1)
		{
			return Hand.OnePair;
		}
		if (pairs.size() == 2)
		{
			return Hand.TwoPair;
		}
		
		return Hand.HighCard;
	}
}
