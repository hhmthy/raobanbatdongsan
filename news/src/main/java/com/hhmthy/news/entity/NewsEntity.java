package com.hhmthy.news.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "news", schema = "bds")
public class NewsEntity {
    private long newsId;
    private String newsTitle;
    private String newsContent;
    private Date newsCreatedAt;
    private Date newsUpdatedAt;
    private String newsBannerUrl;

    @Id
    @Column(name = "news_id", nullable = false)
    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "news_title", nullable = true, length = 255)
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Basic
    @Column(name = "news_content", nullable = true, length = -1)
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Basic
    @Column(name = "news_created_at", nullable = true)
    public Date getNewsCreatedAt() {
        return newsCreatedAt;
    }

    public void setNewsCreatedAt(Date newsCreatedAt) {
        this.newsCreatedAt = newsCreatedAt;
    }

    @Basic
    @Column(name = "news_updated_at", nullable = true)
    public Date getNewsUpdatedAt() {
        return newsUpdatedAt;
    }

    public void setNewsUpdatedAt(Date newsUpdatedAt) {
        this.newsUpdatedAt = newsUpdatedAt;
    }

    @Basic
    @Column(name = "news_banner_url", nullable = true, length = 255)
    public String getNewsBannerUrl() {
        return newsBannerUrl;
    }

    public void setNewsBannerUrl(String newsBannerUrl) {
        this.newsBannerUrl = newsBannerUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsEntity that = (NewsEntity) o;
        return newsId == that.newsId &&
                Objects.equals(newsTitle, that.newsTitle) &&
                Objects.equals(newsContent, that.newsContent) &&
                Objects.equals(newsCreatedAt, that.newsCreatedAt) &&
                Objects.equals(newsUpdatedAt, that.newsUpdatedAt) &&
                Objects.equals(newsBannerUrl, that.newsBannerUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, newsTitle, newsContent, newsCreatedAt, newsUpdatedAt, newsBannerUrl);
    }
}
