package org.launchcode.cheesemvc.models;

public enum CheeseType {
    HARD("Hard"),
    SOFT("Soft"),
    FAKE("Fake");
    //final means fields cannot be changed once initialized.
    private final String name;

    //Constructor that initializes String name. Called by creating descriptor names next to each CheeseType ie."Hard"
    CheeseType(String name){
        this.name = name;
    }

    // Allows the information stored in CheeseType to be accessed and used in view. Like the select tag in add.html form.
    public String getName() {
        return name;
    }
}
