package by.its.lightRoom.service;

import by.its.lightRoom.model.Bulb;
import by.its.lightRoom.model.Room;
import by.its.lightRoom.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Service
@Transactional
public class JpaRoomService implements RoomService {

    private final RoomRepository roomRepository;

    public JpaRoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void addRoom(Room room) {
        room.setBulb(new Bulb());
        roomRepository.saveRoom(room);
    }

    @Override
    @Transactional(readOnly = true)
    public Room findRoomById(Long id) {
        try{
            return roomRepository.findRoomById(id);
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Room> allListRooms() {
        return roomRepository.allListRooms();
    }

    @Override
    public void lightOn(Long id) {
        Room roomById = roomRepository.findRoomById(id);
        roomById.getBulb().setLight(true);
        roomRepository.updateRoom(roomById);
    }

    @Override
    public void lightOff(Long id) {
        Room roomById = roomRepository.findRoomById(id);
        roomById.getBulb().setLight(false);
        roomRepository.updateRoom(roomById);
    }
}
