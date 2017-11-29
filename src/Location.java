
public class Location {
	int[] location = new int[2];
	//creates an in with [][] slots
	
	
	public int[] getLocation() {
		return location;
		
	}


	
	public void setLocation(int x, int y) {
		//why is this acting like the ints in Interface Location are final?
		this.location = location;
		location[0] = x;
		location[1] = y;
		
		//your location{x,y} is set
		
	}
}
