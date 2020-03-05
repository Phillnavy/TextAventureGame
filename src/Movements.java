/**
 * 
 * @author Cameron Fess
 *This class holds the movements for the game
 *
 */
public class Movements {
	private String roomNum; //Holds the room number
	private String dirrection; //Holds the direction
	
	/**
	 * @param rn //Holds room number
	 * @param dir //Holds direction
	 */
	public Movements(String rn, String dir) {
		roomNum = rn;
		dirrection = dir;
	}
	
	//Return roomNumber in string form
	public String getRoomNumber() {
		return roomNum;
		
	}
	//Returns the Direction in string form
	public String getDirrection() {
		return dirrection;
	}
	//Returns direction and room number in string form
	public String toString() {
		return dirrection + roomNum;
	}
}
