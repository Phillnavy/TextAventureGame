import java.io.*;
import java.util.*;
/**
 * 
 * @author Cameron Fess
 *1/30/20
 *App that takes in a file and stores game data
 */
public class TextAdventureGameApp{

	public static void main (String args[]) {

		//////////////////////////////////////////////////////////Initialization//////////////////////////////////////////////////////////

		int roomIndex = 0; //Holds the index of how many rooms there are
		int decisionIndex = 0; //Holds how many decisions we have
		int roomNumber = 0; //Holds the number value of the room
		int objRN = 0; //Holds the object room number
		String objDesc = ""; //Holds the objects description
		String objName = ""; //Holds the object name
		String description = ""; //Holds the description of the room
		String roomName = ""; //Holds the name of the room
		boolean atDescription = true; //Tells us if we should be reading the description still
		boolean atDecisions = false; //Tells us if we should be reading the decisions
		TextAdventureGame rooms[] = new TextAdventureGame[200]; //Holds up to 200 rooms
		Movements movements[] = new Movements[4];

		//////////////////////////////////////////////////////////Begin Initialization of files////////////////////////////////////////////////////		

		File ObjectFile = new File("ObjectListTextFile.txt"); //Opens game object file
		File RoomsFile = new File("TextGameFile.txt"); //Opens room file

		//////////////////////////////////////////////////////////Beginning of Reading rooms file//////////////////////////////////////////////////////////

		//Try to open file with the name
		try(Scanner s = new Scanner(RoomsFile)){

			//While there is another line
			while(s.hasNext()) {
				String theLine = s.nextLine(); //Create a temp string to hold the line we are one

				//This is used for reading the last room of the file only
				if(s.hasNext() == false) {
					Movements movement = new Movements(theLine.replaceAll("[^0-9]", ""), theLine);
					movements[decisionIndex] = movement;		
					decisionIndex++; //Increment index
					TextAdventureGame room = new TextAdventureGame(roomNumber, roomName, description,movements);
					rooms[roomIndex] = room;
					roomIndex++;	
					System.out.println(room.toString()); //Uses toString
				}

				try{  //If the line is an integer
					roomNumber = Integer.parseInt(theLine); //Save the integer room number
					roomName = s.nextLine(); //Save the room name

				}catch (NumberFormatException e){ //If its not an integer
					//If the line isnt a - and we're at the description
					if(theLine.contains("-") == false && atDescription == true) {
						description +=theLine + "\n"; //add to the description
					}

					//If we are at the - point
					else if (theLine.contains("-") || atDecisions == true) {
						atDescription =false; //Changes when we find the -
						atDecisions = true;

						//add the line to decisions if its not empty
						if(theLine.isEmpty()== false && atDecisions == true) {
							Movements movement = new Movements(theLine.replaceAll("[^0-9]", ""), theLine);
							movements[decisionIndex] = movement;		
							decisionIndex++; //Increment index
						}

						else {
							TextAdventureGame room = new TextAdventureGame(roomNumber, roomName, description,movements);
							rooms[roomIndex] = room;
							roomIndex++;	
							System.out.println(room.toString()); //Uses toString
							/////////////////////////////////////////////////////////End first file begin second///////////////////////////////////////////////////////

							try(Scanner s2 = new Scanner(ObjectFile)){ //Try to open the file

								while (s2.hasNext()){ //While we have a line to use

									objName = s2.nextLine(); //Add the name of the object
									s2.nextLine(); //Skip to next line

									objDesc = s2.nextLine(); //Add the object description
									s2.nextLine();//Skip to the next line

									objRN = Integer.parseInt(s2.nextLine()); //Add the room number
									if(s2.hasNext() == true) { //If there is more lines
										s2.nextLine(); //Skip to the next line
									}
									GameObject object = new GameObject(objName, objDesc, objRN); //Add variables to object
										rooms[objRN].addObject(object);
								}

							}
							//////////////////////////////////////////////////////////Resetting for next run//////////////////////////////////////////////////////////

							Movements movementReset = new Movements("","");
							movements[0] = movementReset; 
							movements[1] = movementReset; 
							movements[2] = movementReset; 
							movements[3] = movementReset; 
							atDescription = true;
							atDecisions = false;
							description = "";
							roomName = "";
							decisionIndex = 0;		
							objRN = 0; //Holds the object room number
							objDesc = ""; //Holds the objects description
							objName = ""; //Holds the object name

							//////////////////////////////////////////////////////////End of resetting //////////////////////////////////////////////////////////////							
						}
					}
				}	
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}