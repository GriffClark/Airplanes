/*
 * Military planes can transport both people and cargo at the same time. They always have secure cargo
 * Need to find a way for them to fly because they will not be carrying regular people... create army people?
 */
public class MilitaryPlane extends Airplane{
	
		
	
	
	public MilitaryPlane()
	{
		super();
		hasSecureCargo = true;
		type = Airplane.AirplaneType.Military;
		
	}
	

	public boolean hasSecureCargo()
	{
		return true;
	}
	
	


}
