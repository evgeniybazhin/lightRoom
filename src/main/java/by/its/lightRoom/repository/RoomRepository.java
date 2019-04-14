package by.its.lightRoom.repository;

import by.its.lightRoom.model.Room;

import java.util.List;

public interface RoomRepository {
    void saveRoom(Room room);
    Room findRoomById(Long id);
    List<Room> allListRooms();
    void updateRoom(Room room);
}
