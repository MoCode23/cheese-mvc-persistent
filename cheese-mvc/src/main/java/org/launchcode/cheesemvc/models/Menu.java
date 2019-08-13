package org.launchcode.cheesemvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;


@Entity
public class Menu {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany
    private List<Cheese> cheeses;

    public Menu() {    }

    public Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public void addItem(Cheese item) {
        cheeses.add(item);
    }


}


