package com.example.demowebiii.framework;


import javax.persistence.*;

@Entity
@Table
public class Framework {

    @Id
    @SequenceGenerator(
            name = "framework_sequence",
            sequenceName = "framework_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "framework_sequence"
    )
    private Long id;
    private String name;
    private String stars;
    public String type;


    public Framework(){
        super();
    }
    public Framework(Long id, String name, String stars, String type) {

        this.id = id;
        this.name = name;
        this.stars = stars;
        this.type = type;
    }


    public Framework(String name, String stars, String type) {
        this.name = name;
        this.stars = stars;
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getType() {
        return type;
    }

    public void setType(String x) {
        this.type = x;
    }

    @Override
    public String toString() {
        return "Framework{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", x=" + type +
                '}';
    }
}
