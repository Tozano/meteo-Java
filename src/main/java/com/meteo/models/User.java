package com.meteo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    @Column(name = "username")
    private String username;

    // will be optional
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "lang")
    private String lang;


    /*
    private List<Selection> ownSelection;

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
    */
}

/*
CREATE TABLE User (
    id_user int PRIMARY KEY NOT NULL,
    username VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    lang VARCHAR(20)
);

 */