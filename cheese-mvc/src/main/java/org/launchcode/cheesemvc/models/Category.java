package org.launchcode.cheesemvc.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

        @Id
        @GeneratedValue
        private int id;

        @NotNull
        @Size(min=3, max=15 )
        private String name;

        //Works with ManyToOne in Cheese.Java both are needed to show relation. Allows storing and retrieving.
        @OneToMany
        //Join Column populates cheeses list using the unique ids in category_id.
        @JoinColumn(name = "category_id")
        //owning class
        private List<Cheese> cheeses = new ArrayList<>();


        public Category(String name) { this.name = name;
        }

        //no args constructor.
        public Category() {
        }
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Cheese> getCheeses() {
                return cheeses;}



    }


