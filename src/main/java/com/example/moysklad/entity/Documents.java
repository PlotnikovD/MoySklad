package com.example.moysklad.entity;

import com.example.moysklad.controller.dto.ProductInfoDto;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "documents")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
        @TypeDef(name = "string-array", typeClass = StringArrayType.class
        )
})

public class Documents implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "first_storage_id", nullable = false, updatable = false)
    @Type(type = "string-array")
    private Storage firstStorage;
    @ManyToOne
    @JoinColumn(name = "second_storage_id", nullable = false, updatable = false)
    private Storage secondStorage;

    @Type(type = "jsonb")
    @Column(name = "info", columnDefinition = "jsonb")
    private List<ProductInfoDto> info;
    @Column(name = "type")
    private ProductInfoDto.Types type;

    public Documents(Long id, Storage firstStorage, Storage secondStorage, List<ProductInfoDto> info, ProductInfoDto.Types type) {
        this.id = id;
        this.firstStorage = firstStorage;
        this.secondStorage = secondStorage;
        this.info = info;
        this.type = type;
    }

    public Documents() {
    }

    public Documents(Storage firstStorage, Storage secondStorage, List<ProductInfoDto> info, ProductInfoDto.Types type) {
        this.firstStorage = firstStorage;
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

    public ProductInfoDto.Types getType() {
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

    public Documents setType(ProductInfoDto.Types type) {
        this.type = type;
        return this;
    }

}
