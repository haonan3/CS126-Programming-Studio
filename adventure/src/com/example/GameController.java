package com.example;

import java.util.*;

public class GameController {
    public Layout layout;
    public static String roomState;//store the room state
    public static ArrayList<String> itemsPicked = new ArrayList<String>();//store the items you are picking
    public static Map<String, Room> roomsMap ;
    public static Map<String, ArrayList<String>> itemsMap;
    public static String url;

    /***
     * GameController's constructor is used to initialize room map and item map
     * itemsMap is useful for delete and add items
     * @param URL the default URL is Siebel Building's layout unless you put configuration
     */
    public GameController(String URL){
        url = URL;
        ParseSiebelJson parseSiebelJsonObject = new ParseSiebelJson(URL);
        layout = parseSiebelJsonObject.parseJson();
        roomsMap = new HashMap<String, Room>();
        itemsMap = new HashMap<String, ArrayList<String>>();
        int roomNum = layout.getRoomsArray().length;
        roomState = layout.getStartingRoom();
        for(int i = 0; i<roomNum;i++) {
            String roomName = layout.getRoomsArray()[i].getName();
            Room theRoom = layout.getRoomsArray()[i];
            String[] items = layout.getRoomsArray()[i].getItems();
            ArrayList<String> itemsArrayList = new ArrayList<String>(Arrays.asList(items));
            GameController.roomsMap.put(roomName, theRoom);
            GameController.itemsMap.put(roomName, itemsArrayList);
        }
    }

    /***
     * The method will create a string to store all possible directions of one room in format
     * @param currentRoom the room you are located
     * @return all possible directions of a room
     */
    public String HaveDirections(String currentRoom) {
        int directionsNum = roomsMap.get(currentRoom).getDirection().length;
        int lateDiretionIndex = directionsNum - 1;
        String[] directionsName = new String[directionsNum];
        String directionOutput = "From here you can go: ";
        for(int i = 0; i<directionsNum; i++){
            directionsName[i] = roomsMap.get(currentRoom).getDirection()[i].getDirectionName();
        }
        if(directionsNum == 1) {//only one is fine
            directionOutput += directionsName[0];
        }else{
            for(int i = 0; i<lateDiretionIndex; i++){
                directionOutput += directionsName[i]+", ";
            }
            directionOutput += "or "+directionsName[lateDiretionIndex];
        }
        return directionOutput;
    }

    /**
     * the method is used to update the room you located, if you cannot go next room, it will return current room
     * @param currentRoom the room you located
     * @param direction the user input direction
     * @param gameController the reference of gameController created in Adventure class
     * @return the room you located
     */
    public String GoOtherRoom(String currentRoom, String direction, GameController gameController) {
        int directionLen = gameController.roomsMap.get(currentRoom).getDirection().length;
        for(int i = 0; i < directionLen; i++){
            String directionName = roomsMap.get(currentRoom).getDirection()[i].getDirectionName();
            if(directionName.equalsIgnoreCase(direction)){
                roomState = roomsMap.get(currentRoom).getDirection()[i].getRoom();
                return roomState;
            }
        }
        return roomState;
    }

    /**
     * This method will check whether you item input is correct, and print whether you catch it successfully
     * @param currentRoom which room you located
     * @param items the item you want to catch
     * @param gameController the reference of gameController created in Adventure class
     */
    public void CatchItem(String currentRoom, String items, GameController gameController) {
        if(gameController.itemsMap.get(currentRoom).contains(items)){
            gameController.itemsPicked.add(items);
            gameController.itemsMap.get(currentRoom).remove(items);
            System.out.println(items+" is picked up");
        }else{
            System.out.println(items+" is not in "+currentRoom);
        }
    }

    public void LocateItem(String currentRoom, String items, GameController gameController) {
        if(gameController.itemsPicked.contains(items)){
            gameController.itemsMap.get(currentRoom).add(items);
            gameController.itemsPicked.remove(items);
            System.out.println(items+" is put in " + currentRoom);
        }else{
            System.out.println("you don't take " + items);
        }
    }

    /***
     * this method will print what you are catching
     */
    public void Showitems(){
        System.out.print("You are picking: ");
        for(int i = 0; i < itemsPicked.size(); i++){
            System.out.print(itemsPicked.get(i) + " ");
        }
        System.out.println("");
    }
}
