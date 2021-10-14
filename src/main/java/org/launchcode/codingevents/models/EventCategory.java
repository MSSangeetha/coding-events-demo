package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class EventCategory extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private int id;

    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    private EventType type;

    //Constructor
    public EventCategory(@Size(min = 3, message = "Name must be at least 3 characters long") String name) {
        this.name = name;
    }

    //Empty constructor for the entity class
    public EventCategory() {

    }

    //Getters and Setters

//    public int getId() {
//        return id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //To String

    @Override
    public String toString() {
        return name;
    }

    //Equals and Hashcode

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        EventCategory that = (EventCategory) o;
//        return id == that.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
