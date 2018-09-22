package ru.lastenko.partslist.entities;

import javax.persistence.*;

@Entity
@Table(name = "part", schema = "test", catalog = "")
public class Part {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_necessary")
    private Boolean necessary;

    @Column(name = "count")
    private Integer count;

    public Part() {
    }

    public Part(String name, Boolean necessary, Integer count) {
        this.name = name;
        this.necessary = necessary;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isNecessary() {
        return necessary;
    }

    public void setNecessary(Boolean necessary) {
        this.necessary = necessary;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
