package com.hhmthy.newscat.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "news_cat", schema = "bds")
public class NewsCatEntity {
    private long newsCatId;
    private String nameCat;
    private String desciptionCat;

    @Id
    @Column(name = "news_cat_id", nullable = false)
    public long getNewsCatId() {
        return newsCatId;
    }

    public void setNewsCatId(long newsCatId) {
        this.newsCatId = newsCatId;
    }

    @Basic
    @Column(name = "name_cat", nullable = true, length = 255)
    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }

    @Basic
    @Column(name = "desciption_cat", nullable = true, length = 255)
    public String getDesciptionCat() {
        return desciptionCat;
    }

    public void setDesciptionCat(String desciptionCat) {
        this.desciptionCat = desciptionCat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsCatEntity that = (NewsCatEntity) o;
        return newsCatId == that.newsCatId &&
                Objects.equals(nameCat, that.nameCat) &&
                Objects.equals(desciptionCat, that.desciptionCat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsCatId, nameCat, desciptionCat);
    }
}
