import java.util.ArrayList;
import java.util.Arrays;

public class TextAdventureGame{
	/**
	 * @author Cameron Fess
	 * 1/30/20
	 * Various 'get' methods and formatting for game app
	 */
	private int roomNumber; //Stores the room number
	private String description; //Stores the rooms description
	private  Movements[] decisions; //Stores the decision value
	private String roomName; //Stores the room name
	private String decisionsString = ""; //Stores the decisions in a string
	private ArrayList<GameObject> listOfObjects = new ArrayList<GameObject>();

	/**
	 * Constructor
	 * @param rn - Room number
	 * @param name - Room name
	 * @param desc - Room description
	 * @param decision - Movements 
	 */
	public TextAdventureGame(int rn, String name, String desc, Movements[] decision) {
		roomNumber = rn;
		description = desc;
		decisions = decision;
		roomName = name;
		for(int i = 0; i < decisions.length; i++) {
			decisionsString += decisions[i].getDirrection() + "\n"; 					
		}
	}

	//Override toString method
	public String toString() {
		String returnString = ""; //Temp value to store the returning string

		returnString += roomNumber + "\n" + roomName + "\n" + description + decisionsString;
		return returnString;
	}

	//Returns room number
	public int getRoomNumber(){
		return roomNumber;
	}

	//Returns description
	public String getDescription() {
		return description;
	}

	//Returns decisions
	public String getDecisions() {
		return decisionsString;
	}

	public String addObject(GameObject object) {
		listOfObjects.add(object);
		return "Object added";
	}

	public String removeObject(GameObject object) {
		if(listOfObjects.contains(object)) {
			listOfObjects.remove(object);
			return "Object removed";
		}
		else
			return "Object not removed object doesnt exist";
	}

		public boolean ContainsObject(GameObject object) {
			if(listOfObjects.contains(object))
				return true;
			else
				return false;	
		}
		public int getObjectCount() {
			return listOfObjects.size();
		}
		public GameObject getObject(int index) {
			return listOfObjects.get(index);
		}
	}
