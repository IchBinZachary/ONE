import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class UNOgame {
	public static void main(String[]args){
		ArrayList<UNOcard> HUM = new ArrayList<UNOcard>();
		ArrayList<UNOcard> CPU = new ArrayList<UNOcard>();
		UNOdeck Game = new UNOdeck(HUM,CPU);
		int Turn = Game.whoGoesFirst();
		int GameOver = -1;
		Scanner x = new Scanner(System.in);
		
		while (GameOver==-1){
			System.out.println("-----------------------------------");
			System.out.println("Size of CPU's Hand:"+CPU.size());
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("The top card is: \t "+Game.topCardToString());
			System.out.println();
			System.out.println();
			System.out.println("~~~~~~~~~~~");
			if (Turn==0){/////~~
			System.out.println(Game.decktoString(HUM));
			boolean canPlay = Game.PlayerCanPlay(HUM);
			if (canPlay==false){//-
				System.out.println("Based on your hand, you cannot play a card. You will be automatically draw a card");
				HUM.add(Game.DrawCard());
				canPlay=Game.PlayerCanPlay(HUM);
				if (canPlay==false){
					System.out.println();
					System.out.println("You drew your card and you still cannot play a a card! End Turn");
					Turn=1;
					continue;
				}
			}//-
			
				boolean PlayCard = false;
				while (PlayCard==false){//--
					System.out.println("Enter the index that corresponds to the card you want to play");
					int Ithcard = x.nextInt();
					if (HUM.get(Ithcard-1).getValue()==30){
						System.out.println("It seems you want to play a WILD card. Enter the color you want to change below:");
						String color = x.next();
						PlayCard = Game.PTurn(Ithcard-1,color,HUM);
					}
					else {
						PlayCard=Game.PTurn(Ithcard-1,null,HUM);
					}
				}//--
			
			
			if (Game.getTopCard().getValue()==20){//---
				System.out.println();
				System.out.println();
				System.out.println("PLAYER has drawn a Draw +2 Card!");
				CPU.add(Game.DrawCard());
				CPU.add(Game.DrawCard());
				System.out.println("COMPUTER has drawn 2 cards! COMPUTER's turn is skipped!");
				continue;
			}//---
			else if (Game.getTopCard().getValue()==10){//----
				System.out.println();
				System.out.println();
				System.out.println("PLAYER has drawn a Draw +1 Card!");
				CPU.add(Game.DrawCard());
				System.out.println("COMPUTER has drawn 1 card! COMPUTER's turn is skipped!");
				continue;
			}//----
			else{
				Turn=1;
				continue;
			}
		}/////~~
		if (Turn==1){
			System.out.println(Game.decktoString(CPU));
			boolean CPUcanPlay = Game.PlayerCanPlay(CPU);
			if (CPUcanPlay==false){//-
				System.out.println("CPU cannot play a card. CPU draws card!");
				CPU.add(Game.DrawCard());
				CPUcanPlay=Game.PlayerCanPlay(CPU);
				if (CPUcanPlay==false){
					System.out.println();
					System.out.println("CPU still cannot play a card after drawing! END TURN");
					Turn=0;
					continue;
				}
			}//-
			
			Game.CPUplay(CPU);
			System.out.println("COMPUTER has played:  "+Game.topCardToString());
			
			
			if (Game.getTopCard().getValue()==20){//---
				System.out.println();
				System.out.println();
				System.out.println("PLAYER has drawn a Draw +2 Card!");
				HUM.add(Game.DrawCard());
				HUM.add(Game.DrawCard());
				System.out.println("COMPUTER has drawn 2 cards! COMPUTER's turn is skipped!");
				continue;
			}//---
			else if (Game.getTopCard().getValue()==10){//----
				System.out.println();
				System.out.println();
				System.out.println("PLAYER has drawn a Draw +1 Card!");
				HUM.add(Game.DrawCard());
				System.out.println("COMPUTER has drawn 1 card! COMPUTER's turn is skipped!");
				continue;
			}//----
			else{
				Turn=0;
				continue;
			}
		}
	}
		
	
		//------------------------
		if (GameOver == 1) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("WINNER: COMPUTER");
			System.out.println();
			System.out.println("You lose...");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}
		if (GameOver == 0) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("CONGRATULATIONS");
			System.out.println();
			System.out.println("YOU WIN");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
}
