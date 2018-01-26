package com.example;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Adventure {
    public static GameController gameController;
    public static Adventure adventure;

    /***
     * Big picture: the URL will be passed to ParseSiebelJson
     * @param URL the default URL is Siebel Building's layout unless you put configuration
     */
    public Adventure(String URL) {
        gameController = new GameController(URL);
    }

    /***
     * This method will execute the user command, and print feedback in format
     * @param inputLine the input string
     * @param currentRoom the current room you are located
     */
    public void processInput(String inputLine, String currentRoom) {
        String[] inputArray = inputLine.split(" ");
        String roomName = currentRoom;
        //check whether the go command is correct
        if (inputArray.length == 2 && inputArray[0].equalsIgnoreCase("go") && (
                !currentRoom.equalsIgnoreCase(gameController.GoOtherRoom(currentRoom, inputArray[1], gameController))
        )) {
            roomName = gameController.GoOtherRoom(currentRoom, inputArray[1], gameController);//update
        }
        //check whether the catch command is correct, if the item's name are two words, it will be concatenate into one
        else if (inputArray.length > 1 && inputArray[0].equalsIgnoreCase("catch")) {
            if (inputArray.length == 2) {
                gameController.CatchItem(roomName, inputArray[1], gameController);
            } else {
                String item = inputArray[1] + " " + inputArray[2];
                gameController.CatchItem(roomName, item, gameController);
            }
        }
        //check whether the locate command is correct, if the item's name are two words, it will be concatenate into one
        else if (inputArray.length > 1 && inputArray[0].equalsIgnoreCase("locate")) {
            if (inputArray.length == 2) {
                gameController.LocateItem(roomName, inputArray[1], gameController);
            } else {
                String item = inputArray[1] + " " + inputArray[2];
                gameController.LocateItem(roomName, item, gameController);
            }
        }
        //check whether user try to go a wrong direction or the go after "go" is not a direction
        else if (inputArray.length == 2 && inputArray[0].equalsIgnoreCase("go") && (
                currentRoom.equalsIgnoreCase(gameController.GoOtherRoom(currentRoom, inputArray[1], gameController))
        )) {
            System.out.println("I can't " + inputLine);
        }
        //show command is to show what you are catching
        else if (inputArray.length == 1 && inputArray[0].equalsIgnoreCase("show")) {
            gameController.Showitems();
        } else {
            System.out.println("I don't understand '" + inputLine + "'");
        }
        //print the description and direction of the room where you located
        String roomDescription = gameController.roomsMap.get(roomName).getDescription();
        System.out.println(roomDescription);
        System.out.println(gameController.HaveDirections(roomName));
        adventure.printItems(roomName, gameController.itemsMap);
    }

    /***
     * Print what items in this room
     * @param currentRoom the room you located
     * @param itemsMap the map of key: room name, value: items array
     */

    public void printItems(String currentRoom, Map itemsMap) {
        ArrayList<String> itemsList = ((ArrayList<String>) itemsMap.get(currentRoom));
        int itemsNum = itemsList.toArray().length; //why it can only be casted to Array?
        //      System.out.println("item in room: " + currentRoom);
        for (int i = 0; i < itemsNum; i++) {
            System.out.println(itemsList.get(i) + " in this room");
        }
    }


    public static void main(String[] args) {
        //if you don't give a url, main function will provide a default url
        if (args.length == 0) {
            String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
            adventure = new Adventure(url);
        } else {
            adventure = new Adventure(args[0]);
        }
        String inputLine;
        boolean gameRunning = true;
        String startingRoomName = gameController.roomState;
        String startingRoomDescription = gameController.roomsMap.get(startingRoomName).getDescription();
        System.out.println("You are on " + startingRoomName + " " + startingRoomDescription);
        System.out.println(gameController.HaveDirections(startingRoomName));
        //Unless you input exit or quit, it will execute again
        while (gameRunning) {
            Scanner scan = new Scanner(System.in);
            inputLine = scan.nextLine();
            String currentRoom = gameController.roomState;
            //System.out.println("the main is in: "+currentRoom);
            if (inputLine.equalsIgnoreCase("quit") || inputLine.equalsIgnoreCase("exit")) {
                break;
            }
            adventure.processInput(inputLine, currentRoom);
        }
    }
}
