package org.launchcode.cheesemvc.models;

import javax.persistence.*;
import java.util.List;


// Tells springboot to set up database and store data in a table(name, description, cheeseId
@Entity
public class Cheese {
    //@Id creates unique Id and a primary key.
    @Id
    //@GeneratedValue tells hibernate to generate that value.
    @GeneratedValue
    private int id;

    //Create validation in model.
    //Makes sure field is not null.
    // Sets limits on the amount of characters in the string that can be entered into the field.
    private String name;

    //Set size to at least one. Create custom error message using message and a self created message string.
    private String description;

    @ManyToOne
    //Works with OneToMany in Category.Java both are needed to show relation. Allows storing and retrieving.
    private Category category;

    @ManyToMany(mappedBy = "cheeses")
    private List<Menu> menus;

    //Creates CheeseType enum that gives cheese a type.
    private CheeseType type;

    /*Created id for cheese to allow for duplicates in name and description to remain as distinct entries.
    Removed to allow spring to create ids.
    private int cheeseId;
    private static int nextId = 1;*/

    public Cheese(String name, String description) {
        // this(); necessary to call no args constructor and initialize cheeseId. Must be first.
       // this(); removed because cheeseId was removed to work with databases.
        this.name = name;
        this.description =  description;
    }

    //no args constructor that gives makes all cheeseId's unique. Set cheeseId equal to nextId and increment.
    public Cheese(){

        /*Removed along with other cheeseId initializers.
        cheeseId = nextId;
        nextId++;*/
    }
    //getter for id. Id does not need setter because id should not be changeable.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
