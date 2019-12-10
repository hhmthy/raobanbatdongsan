package com.hhmthy.searchpost.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "posts1", schema = "posts", catalog = "")
public class Posts1Entity {
    private long postId;
    private int area;
    private String catalog;
    private String certification;
    private String city;
    private String content;
    private String district;
    private int houseId;
    private int landId;
    private String location;
    private int price;
    private int rating;
    private String status;
    private String thumbnail;
    private String title;
    private String userId;
    private String createAt;

    @Id
    @Column(name = "post_id", nullable = false)
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "area", nullable = false)
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Basic
    @Column(name = "catalog", nullable = true, length = 255)
    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    @Basic
    @Column(name = "certification", nullable = true, length = 255)
    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "district", nullable = true, length = 255)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "house_id", nullable = false)
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Basic
    @Column(name = "land_id", nullable = false)
    public int getLandId() {
        return landId;
    }

    public void setLandId(int landId) {
        this.landId = landId;
    }

    @Basic
    @Column(name = "location", nullable = true, length = 255)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "rating", nullable = false)
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 255)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "thumbnail", nullable = true, length = 255)
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "user_id", nullable = true, length = 255)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "create_at", nullable = true, length = 255)
    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posts1Entity that = (Posts1Entity) o;
        return postId == that.postId &&
                area == that.area &&
                houseId == that.houseId &&
                landId == that.landId &&
                price == that.price &&
                rating == that.rating &&
                Objects.equals(catalog, that.catalog) &&
                Objects.equals(certification, that.certification) &&
                Objects.equals(city, that.city) &&
                Objects.equals(content, that.content) &&
                Objects.equals(district, that.district) &&
                Objects.equals(location, that.location) &&
                Objects.equals(status, that.status) &&
                Objects.equals(thumbnail, that.thumbnail) &&
                Objects.equals(title, that.title) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(createAt, that.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, area, catalog, certification, city, content, district, houseId, landId, location, price, rating, status, thumbnail, title, userId, createAt);
    }
}
