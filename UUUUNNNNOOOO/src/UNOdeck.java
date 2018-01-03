import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class UNOdeck {
	private ArrayList<UNOcard> DrawPile= new ArrayList<UNOcard>();
	private ArrayList<UNOcard> Discard = new ArrayList<UNOcard>();
	private UNOcard topCard;
	
	public String decktoString(ArrayList<UNOcard> M){
		String returnString="";
		for (int i = 1; i<M.size()+1;i++){
			returnString+=i+") "+M.get(i-1).toString()+"\n";
		}
		return returnString;
	}
	
	
	public UNOdeck(ArrayList<UNOcard> H,ArrayList<UNOcard> C){
		createDeck();
		Collections.shuffle(DrawPile);
		dealCards(H,C);
		setTopCard(startTopCard());
	}
	
	public void createDeck(){
		for (int i = 0; i<4;i++){
			DrawPile.add(new UNOcard("red|green|blue|yellow",30));
		}
			for (int i = 0; i<4; i++){
				if (i==0){
					for (int eachCard =1; eachCard<=7;eachCard++){
						DrawPile.add(new UNOcard("yellow",eachCard));
					}
				}
				
				else if (i==1){
					for (int eachCard =1; eachCard<=7;eachCard++){
						DrawPile.add(new UNOcard("red",eachCard));
					}
				}
				
				else if (i==2){
					for (int eachCard =1; eachCard<=7;eachCard++){
						DrawPile.add(new UNOcard("green",eachCard));
					}
				}
				
				else{
					for (int eachCard =1; eachCard<=7;eachCard++){
						DrawPile.add(new UNOcard("blue",eachCard));
					}
				}
			}
				DrawPile.add(new UNOcard("red",10));
				DrawPile.add(new UNOcard("blue",10));
				DrawPile.add(new UNOcard("green",20));
				DrawPile.add(new UNOcard("yellow",20));
			}

			
		
		
	public UNOcard DrawCard(){
		UNOcard DrewCard = DrawPile.get(0);
		DrawPile.remove(DrawPile.get(0));
		return DrewCard;
	}
	
	public UNOcard startTopCard(){
		for (int i = 0; i <DrawPile.size();i++){
			if (DrawPile.get(i).getValue()>=10){
				continue;
			}
			UNOcard returnMe = DrawPile.get(i);
			DrawPile.remove(i);
			return returnMe;
		}
		return new UNOcard(null,-1);
	}
	
	public void dealCards(ArrayList<UNOcard> H,ArrayList<UNOcard> C){
		for (int i = 0; i < 5; i++){
			H.add(DrawCard());
			C.add(DrawCard());
		}
	}
		
	public int whoGoesFirst(){
		for (int i = 0; i < DrawPile.size()-1;i++){
			System.out.println();
			System.out.println("CPU has drawn:"+DrawPile.get(i+1));
			System.out.println("HUM has drawn:"+DrawPile.get(i));
			if (DrawPile.get(i).getValue()>DrawPile.get(i+1).getValue()){
				System.out.println("------");
				System.out.println("HUM will draw first!");
				return 0;
			}
			else if (DrawPile.get(i).getValue()<DrawPile.get(i+1).getValue()){
				System.out.println("------");
				System.out.println("CPU will draw first!");
				return 1;
			}
			else{
				System.out.println("------");
				System.out.println("TIE draw  --  Redrawing...");
				continue;
			}
		}
		return -1;
	}

	public void ifEmptyThenReloadAndShuffle(){
		if (DrawPile.size()==0){
			for (int i = 0; i <Discard.size()-1;i++){
				DrawPile.add(Discard.get(i));
				Discard.remove(i);
			}
			
			Collections.shuffle(DrawPile);
		}
	}
	
	public void setTopCard(UNOcard c){
		topCard=  c;
	}
	
	public UNOcard getTopCard(){
		return topCard;
	}
	
	public boolean PTurn(int q, String color, ArrayList<UNOcard> PlayerHand){	
		if (PlayerHand.get(q).getValue()==30&&((color.equals("red"))||(color.equals("blue"))||(color.equals("green"))||color.equals("yellow"))){
			setTopCard(new UNOcard(color, 30));
			Discard.add(PlayerHand.get(q));
			PlayerHand.remove(q);
			return true;
		}
		
		else if ((PlayerHand.get(q).getValue()==20)&&(getTopCard().getColor().equals("red")||getTopCard().getColor().equals("blue"))){
			setTopCard(new UNOcard(getTopCard().getColor(),20));
			Discard.add(PlayerHand.get(q));
			PlayerHand.remove(q);
			return true;
		}
		else if((PlayerHand.get(q).getValue()==10)&&(getTopCard().getColor().equals("yellow")||getTopCard().getColor().equals("green"))){
			setTopCard(new UNOcard(getTopCard().getColor(),10));
			Discard.add(PlayerHand.get(q));
			PlayerHand.remove(q);
			return true;
		}
		else if(PlayerHand.get(q).getValue()==getTopCard().getValue()|| PlayerHand.get(q).getColor().equals(getTopCard().getColor())   ){
			setTopCard(PlayerHand.get(q));
			Discard.add(PlayerHand.get(q));
			PlayerHand.remove(q);
			return true;
		}
		
		else{
			System.out.println("CARD DOES NOT EXIST IN HAND. TRY AGAIN");
			
			return false;
		}
	}
	
	public boolean PlayerCanPlay(ArrayList<UNOcard> P){
		for (int i = 0; i<P.size();i++){
			if (P.get(i).getValue()==30||P.get(i).getColor().equals(getTopCard().getColor())||P.get(i).getValue()==getTopCard().getValue()){
				return true;
			}
		}
		return false;
	}
	
	public void CPUplay(ArrayList<UNOcard> C){
		for (int i = 0; i<C.size();i++){
			if(C.get(i).getValue()==30){
				int someMath =  1 + (int)(Math.random() * 4); 
				String tempTopColor = (someMath ==4) ? "yellow":(someMath==3)? "red":(someMath==2)? "green":"blue";
				setTopCard(new UNOcard(tempTopColor,30));
				Discard.add(C.get(i));
				C.remove(i);
				return;
			}
			
			else if(C.get(i).getColor().equals(getTopCard().getColor())){
					if (C.get(i).getValue()==20){
						String hue = getTopCard().getColor();
						setTopCard(new UNOcard(hue,20));
						Discard.add(C.get(i));
						C.remove(i);
						return;
					}
					else if(C.get(i).getValue()==10){
						String hue = getTopCard().getColor();
						setTopCard(new UNOcard(hue,20));
						Discard.add(C.get(i));
						C.remove(i);
						return;
					}
			}
			else if(C.get(i).getColor().equals(getTopCard().getColor())||C.get(i).getValue()==getTopCard().getValue()){
				setTopCard(C.get(i));
				Discard.add(C.get(i));
				C.remove(C.get(i));
				return;
			}
			else{
				continue;
			}
		}
		System.out.println("IMPOSSIBLE ERROR");
		return;
	}
	
	public String topCardToString(){
		String vS;
		String cS = getTopCard().getColor();
		if (getTopCard().getValue()==30){
			vS = "WILD";
		}
		else if (getTopCard().getValue()==20){
			vS = "DRAW 2";
		}
		else if (getTopCard().getValue()==10){
			vS = "DRAW 1";
		}
		else{
			vS =getTopCard().getValue()+"";
		}
	String returnString = cS+"|"+vS;
	return returnString;
	}

}
	
	
	
	
	
	
	
	
	
	

