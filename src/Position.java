
public class Position {
	int[] position = new int[2];
	//creates an in with [][] slots
	
	
	public int[] getPosition() {
		return position;
		
	}


	
	public void setLocation(int x, int y) {
		//why is this acting like the ints in Interface Location are final?
		this.position = position; // it wants me to add int position[]. Do I need that?
		position[0] = x;
		position[1] = y;
		
		//your location{x,y} is set
		
	}
}
