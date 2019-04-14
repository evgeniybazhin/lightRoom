package by.its.lightRoom.service;


import by.its.lightRoom.model.Room;

import java.util.List;

public interface RoomService {
    void addRoom(Room room);
    Room findRoomById(Long id);
    List<Room> allListRooms();
    void lightOn(Long id);
    void lightOff(Long id);
}
