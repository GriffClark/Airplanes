/*
 * Military planes can transport both people and cargo at the same time. They always have secure cargo
 * Need to find a way for them to fly because they will not be carrying regular people... create army people?
 */
public class MilitaryPlane extends Airplane{
	
	public MilitaryPlane(int maxPassengers, int passengers, double cargo, double maxCargo, boolean hasSecureCargo,
			AirplaneType type, int speed, String name, int tailNumber) {
		super(maxPassengers, passengers, cargo, maxCargo, hasSecureCargo, type, speed, name, tailNumber);
		
		hasSecureCargo = true;
		type = Airplane.AirplaneType.Military;
		
	}
	
	public MilitaryPlane()
	{
		
	}
	

	public boolean hasSecureCargo()
	{
		return true;
	}
	
	


}
