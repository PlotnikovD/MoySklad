package com.example.moysklad.entity;

import com.example.moysklad.controller.dto.ProductInfoDto;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "documents")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "first_storage_id", nullable = false, updatable = false)
    private Storage firstStorage;
    @ManyToOne
    @JoinColumn(name = "second_storage_id", nullable = false, updatable = false)
    private Storage secondStorage;

    @Type(type = "jsonb")
    @Column(name = "info", columnDefinition = "jsonb")
    private List<ProductInfoDto> info;
    @Column(name = "type")
    private String type;

    public Documents(Storage firstStorage, Storage secondStorage, List<ProductInfoDto> info, String type) {
    }

    public Documents(Long id, Storage firstStorage, Storage secondStorage, List<ProductInfoDto> info, String type) {
        this.id = id;
        this.firstStorage = firstStorage;
        this.secondStorage = secondStorage;
        this.info = info;
        this.type = type;
    }

    public Documents() {
    }

    public Long getId() {
        return id;
    }

    public Documents setId(Long id) {
        this.id = id;
        return this;
    }

    public Storage getFirstStorage() {
        return firstStorage;
    }

    public Documents setFirstStorage(Storage firstStorage) {
        this.firstStorage = firstStorage;
        return this;
    }

    public Storage getSecondStorage() {
        return secondStorage;
    }

    public Documents setSecondStorage(Storage secondStorage) {
        this.secondStorage = secondStorage;
        return this;
    }

    public List<ProductInfoDto> getInfo() {
        return info;
    }

    public Documents setInfo(List<ProductInfoDto> info) {
        this.info = info;
        return this;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Documents{" +
                "id=" + id +
                ", firstStorage=" + firstStorage +
                ", secondStorage=" + secondStorage +
                ", info=" + info +
                ", type='" + type + '\'' +
                '}';
    }

    public Documents setType(String type) {
        this.type = type;
        return this;
    }

}
