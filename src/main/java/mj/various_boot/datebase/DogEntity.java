package mj.various_boot.datebase;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dog_entity")
public class DogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer dogIndex;

    private String name;
    private String age;
    private String breed;
    private String color;
    private String character;

    public Integer getDogIndex() {
        return dogIndex;
    }

    public void setDogIndex(Integer dogIndex) {
        this.dogIndex = dogIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
