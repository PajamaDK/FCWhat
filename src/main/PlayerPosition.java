package main;

public class PlayerPosition {
	
		private String id,match;
		private int position;

	public PlayerPosition(String id, String match, int position){
		this.id = id;
		this.match = match;
		this.position = position;
	}
	public String getId(){
		return this.id;
	}	
	public String getMatch(){
		return this.match;
	}
	public int getPosition(){
		return this.position;
	}
	public String getPositionInString(){
		String pos = Integer.toString(this.position);
		
		return pos;
	}

//class end.
}
