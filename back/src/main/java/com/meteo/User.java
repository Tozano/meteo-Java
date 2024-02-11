package com.meteo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    private Long id;
    private String username;

    // will be optional
    private String firstName;
    private String lastName;

    private List<Selection> ownSelection;

    public User(Long id, String username, String firstName, String lastName, List<Selection> ownSelection){
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ownSelection = ownSelection;
    }

    public void addSelection(Selection selection){
        ownSelection.add(selection);
    }

    public void removeSelection(Selection selection){
        ownSelection.remove(selection);
    }

    public int getSelectionLength(){
        int length = 0;
        for (Selection selection : ownSelection) {
            length++;
        }
        return length;
    }
}
