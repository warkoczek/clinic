package com.example.clinic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;


@Entity
public class Room {

    @Id
    @GeneratedValue(generator = "roomSeq")
    @SequenceGenerator(name = "roomSeq", sequenceName = "room_Seq", allocationSize = 1)
    private Long id;

    private String doorNumber;

    private String floorNumber;

    public Room() {
    }

    public Room(String doorNumber, String floorNumber) {
        this.doorNumber=doorNumber;
        this.floorNumber=floorNumber;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) &&
                Objects.equals(doorNumber, room.doorNumber) &&
                Objects.equals(floorNumber, room.floorNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doorNumber, floorNumber);
    }
}
