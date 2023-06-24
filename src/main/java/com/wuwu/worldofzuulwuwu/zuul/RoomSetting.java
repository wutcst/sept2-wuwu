package com.wuwu.worldofzuulwuwu.zuul;

import java.util.HashMap;

/**
 * The RoomSetting class represents the configuration of rooms in the game.
 * It provides a mapping between room IDs and corresponding Room objects.
 * It also sets up the exits between rooms.
 */
public class RoomSetting {
    public static HashMap<RoomId, Room> rooms = new HashMap<>();
    public static HashMap<Integer, RoomId> roomIds = new HashMap<>();

    static {
        // Create Room objects and add them to the rooms map
        rooms.put(RoomId.ENTRANCE, new Room("in a dungeon. Your journey for enormous treasure begins here."));
        rooms.put(RoomId.CAVE, new Room("in a cave. There is something glowing on the walls."));
        rooms.put(RoomId.TREASURE_ROOM, new Room("in an abandoned treasure room. You see a huge mouse"
            + "as big as you. Behind it is a gold cup. The mouse makes threatening noises when you approach."));
        rooms.put(RoomId.COOKIE_ROOM, new Room("in a kitchen. On the table is a piece of cookie. It seems"
            + " to possess some magic power."));
        rooms.put(RoomId.DARKROOM, new Room("in a dark cave. Some mushrooms are glowing in the darkness."));
        rooms.put(RoomId.LOBBY, new Room("in a lobby illuminated by a lantern."));
        rooms.put(RoomId.WEAPON_ROOM, new Room("in a weapon room. There is only a sword."));
        rooms.put(RoomId.JAIL, new Room("in a jail. A skeleton is wandering around. It is wearing"
            + " a gorgeous crown."));
        rooms.put(RoomId.READING_ROOM, new Room("in a library. You find a book has been opened"
            + " and glowing symbols on its pages."));
        rooms.put(RoomId.SECRET_ROOM, new Room("in a secret room. The secret hides behind the letters"
            + " on the wall: F F F R L R. As you start wondering what they mean, the whole dungeon begins"
            + " to collapse. You must run!"));
        rooms.put(RoomId.EXIT1, new Room("in front of an exit. On the wall, there is a warning written "
            + "in red capital letters: YOU SHALL BE BURIED HERE!"));
        rooms.put(RoomId.EXIT2, new Room("in a passage. Which way should you go?"));
        rooms.put(RoomId.EXIT3, new Room("in a dead end. There seems to be no way ahead..."));
        rooms.put(RoomId.EXIT4, new Room("in a passage. The collapsing is right behind you."));
        rooms.put(RoomId.EXIT5, new Room("in a dead end. There seems to be no way ahead..."));
        rooms.put(RoomId.EXIT6, new Room("in a treasure room. There is a hand bone with a magic ring on it."));
        rooms.put(RoomId.EXIT7, new Room("at the end of the exit. You can see the entrance in front of you."));

        // Set up the exits between rooms
        rooms.get(RoomId.ENTRANCE).setExit("north", rooms.get(RoomId.CAVE));
        rooms.get(RoomId.CAVE).setExit("west", rooms.get(RoomId.COOKIE_ROOM));
        rooms.get(RoomId.CAVE).setExit("north", rooms.get(RoomId.TREASURE_ROOM));
        rooms.get(RoomId.CAVE).setExit("south", rooms.get(RoomId.ENTRANCE));
        rooms.get(RoomId.COOKIE_ROOM).setExit("east", rooms.get(RoomId.CAVE));
        rooms.get(RoomId.TREASURE_ROOM).setExit("north", rooms.get(RoomId.LOBBY));
        rooms.get(RoomId.TREASURE_ROOM).setExit("west", rooms.get(RoomId.DARKROOM));
        rooms.get(RoomId.TREASURE_ROOM).setExit("south", rooms.get(RoomId.CAVE));
        rooms.get(RoomId.DARKROOM).setExit("east", rooms.get(RoomId.TREASURE_ROOM));
        rooms.get(RoomId.LOBBY).setExit("north", rooms.get(RoomId.JAIL));
        rooms.get(RoomId.LOBBY).setExit("east", rooms.get(RoomId.WEAPON_ROOM));
        rooms.get(RoomId.LOBBY).setExit("south", rooms.get(RoomId.TREASURE_ROOM));
        rooms.get(RoomId.WEAPON_ROOM).setExit("west", rooms.get(RoomId.LOBBY));
        rooms.get(RoomId.JAIL).setExit("south", rooms.get(RoomId.LOBBY));
        rooms.get(RoomId.JAIL).setExit("east", rooms.get(RoomId.READING_ROOM));
        rooms.get(RoomId.READING_ROOM).setExit("west", rooms.get(RoomId.JAIL));
        rooms.get(RoomId.READING_ROOM).setExit("east", rooms.get(RoomId.SECRET_ROOM));
        rooms.get(RoomId.SECRET_ROOM).setExit("west", rooms.get(RoomId.READING_ROOM));
        rooms.get(RoomId.SECRET_ROOM).setExit("south", rooms.get(RoomId.EXIT1));
        rooms.get(RoomId.EXIT1).setExit("south", rooms.get(RoomId.EXIT2));
        rooms.get(RoomId.EXIT1).setExit("north", rooms.get(RoomId.SECRET_ROOM));
        rooms.get(RoomId.EXIT2).setExit("south", rooms.get(RoomId.EXIT4));
        rooms.get(RoomId.EXIT2).setExit("west", rooms.get(RoomId.EXIT3));
        rooms.get(RoomId.EXIT3).setExit("east", rooms.get(RoomId.EXIT2));
        rooms.get(RoomId.EXIT4).setExit("west", rooms.get(RoomId.EXIT6));
        rooms.get(RoomId.EXIT4).setExit("south", rooms.get(RoomId.EXIT5));
        rooms.get(RoomId.EXIT5).setExit("north", rooms.get(RoomId.EXIT4));
        rooms.get(RoomId.EXIT6).setExit("south", rooms.get(RoomId.EXIT7));
        rooms.get(RoomId.EXIT7).setExit("west", rooms.get(RoomId.ENTRANCE));

        // Set the names of rooms based on their IDs and populate the roomIds map
        for (var entry : rooms.entrySet()) {
            var room = entry.getValue();
            var id = entry.getKey();
            room.setName(id.toString().toLowerCase());
            roomIds.put(id.getId(), id);
        }
    }

}
