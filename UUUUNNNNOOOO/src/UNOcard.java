
public class UNOcard {
	private String color;
	private int value;
	
	UNOcard(String color, int val){
		this.color = color;									//Val 20: Draw 1; Yellow/Green
		this.value = val;									//Val 10: Draw 2; Yellow/Blue						
															//Val 30: WILD
	}

	public String getColor() {	return color;}

	public void setColor(String color) {this.color = color;}

	public int getValue() {	return value;}

	public void setValue(int value) {	this.value = value;}
	
	public String toString(){	
		
		String returnString=this.getColor();
		String aString = value+"";
		if (value==30){
			returnString="R-G-B-Y";
		}
		
		
		if (value==30){
			aString = "WILD";
		}
		
		if (value==20){
			aString = "DRAW 2";
		}
		
		if (value==10){
			aString = "DRAW 1";
		}
		
		return aString+"|"+returnString; }

	public boolean equals(Object o){
		if (o instanceof UNOcard){
			
			if (this.getColor().equals(((UNOcard)o).getColor())&&(this.getValue()==((UNOcard)o).getValue())){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public int compareToColor(UNOcard c){
		if (this.getColor().length()>c.getColor().length()){
			return 1;
		}
		if (this.getColor().length()<c.getColor().length()){
			return -1;
		}
		return 0;
	}

}
