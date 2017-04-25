package org.stnetix.toDoApp.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javax.persistence.*;


/**
 * Created by Anton on 12.02.2017.
 */
@Entity
public class TaskItem {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private BooleanProperty completed = new SimpleBooleanProperty(false);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TaskItem(){

    }


    public TaskItem(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Access(AccessType.PROPERTY)
    public boolean getCompleted() {
        return completed.get();
    }

    public BooleanProperty completedProperty() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed.set(completed);
    }
}
