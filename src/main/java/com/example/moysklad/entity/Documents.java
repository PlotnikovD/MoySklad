package com.example.moysklad.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "documents")
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "moving_from")
    private String movingFrom;
    @Column(name = "moving_to")
    private String movingTo;
    @Column(name = "info")
    private List<ProductInfo> info;
    @Column(name = "type")
    private String type;

    public Documents() {
    }

    public Documents(Long id, String movingFrom, String movingTo, Object info, String type) {
        this.id = id;
        this.movingFrom = movingFrom;
        this.movingTo = movingTo;
        //this.info = info;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public Documents setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMovingFrom() {
        return movingFrom;
    }

    public Documents setMovingFrom(String movingFrom) {
        this.movingFrom = movingFrom;
        return this;
    }

    public String getMovingTo() {
        return movingTo;
    }

    public Documents setMovingTo(String movingTo) {
        this.movingTo = movingTo;
        return this;
    }

/*    public Object getInfo() {
        return info;
    }*/

/*    public Documents setInfo(Object info) {
        this.info = info;
        return this;
    }*/

    public String getType() {
        return type;
    }

    public Documents setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Documents{" +
                "id=" + id +
                ", movingFrom='" + movingFrom + '\'' +
                ", movingTo='" + movingTo + '\'' +
                ", info=" + //info +
                ", type='" + type + '\'' +
                '}';
    }

    public static class ProductInfo {
        private final Long id;
        private final Integer count;
        private final String name;
        private final Double cost;

        public ProductInfo(Long id, Integer count, String name, Double cost) {
            this.id = id;
            this.count = count;
            this.name = name;
            this.cost = cost;
        }
    }
    public enum Type {
        GET, SELL, TRANSFER
    }

}
