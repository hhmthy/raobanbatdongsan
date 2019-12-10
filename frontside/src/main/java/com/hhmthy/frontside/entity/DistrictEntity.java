package com.hhmthy.frontside.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "district", schema = "bds")
public class DistrictEntity {
    private int id;
    private String name;
    private String prefix;
    private Integer provinceId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "_name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "_prefix", nullable = true, length = 20)
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Basic
    @Column(name = "_province_id", nullable = true)
    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistrictEntity that = (DistrictEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(prefix, that.prefix) &&
                Objects.equals(provinceId, that.provinceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, prefix, provinceId);
    }
}
