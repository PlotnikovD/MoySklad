package com.example.moysklad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 100)
    private String name;

    @ManyToMany
    @JoinTable(name = "prod_store",
            joinColumns = @JoinColumn(name = "storage_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonIgnore
    private List<Product> products;

    public Storage(String name) {
    }

    public Storage() {
    }

    public Storage(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Storage setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Storage setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
