/**
 * 
 * @author Cameron Fess
 * 
 *
 */
public class GameObject {
	private String oN; //Holds the object name
	private String oD; //Holds object description
	private int rN; //Holds room number
	private int newRoom = 0; //Holds new room number

	/**
	 * 
	 * @param objectName holds object name
	 * @param objectDescription holds object description 
	 * @param roomNumber holds roomNumber
	 */
	
	public GameObject(String objectName, String objectDescription, int roomNumber) {
		oN = objectName;
		oD = objectDescription;
		rN = roomNumber;
	}
	
	//returns the name
	public String getName(){
		return oN;
	}
	
	//Returns description
	public String getDescription() {
		return oD;
	}
	
	//Returns inital location
	public int getInitialLocation() {
	return rN;
	}
	
	public void moveRoomTo(int givenRoom) {
		newRoom = givenRoom;
	}
	
	public int getCurrentRoom() {
		if(newRoom != 0)
		return newRoom;
		else
			return rN;
	}
	
}
