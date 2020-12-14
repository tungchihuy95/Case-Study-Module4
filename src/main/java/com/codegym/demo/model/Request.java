package com.codegym.demo.model;

import com.codegym.demo.model.Category;
import com.codegym.demo.model.User;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Requests")
@Data
public class Request implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;
    @ManyToOne
    private User userId;

    @NotEmpty
    private String title;
    private String coverImg;
    private String description;
    private long publishedDate;
    private int pages;
    private String categories;
    @NotEmpty
    private String author;

    @Column(columnDefinition = "int default 0")
    private int requestStatus;
    //    0: new, 1: đang xử lý, 2: đã xử lý xong, 3: từ chối thêm bởi Admin
    private LocalDate createdAt;
    public Request() {
    }

    public Request(Long requestId, User userId, @NotEmpty String title, String coverImg, String description, long publishedDate, int pages, String categories, @NotEmpty String author, int requestStatus, LocalDate createdAt) {
        this.requestId = requestId;
        this.userId = userId;
        this.title = title;
        this.coverImg = coverImg;
        this.description = description;
        this.publishedDate = publishedDate;
        this.pages = pages;
        this.categories = categories;
        this.author = author;
        this.requestStatus = requestStatus;
        this.createdAt = LocalDate.now();
    }

    public Request(User userId, @NotEmpty String title, String coverImg, String description, long publishedDate, int pages, String categories, @NotEmpty String author, int requestStatus, LocalDate createdAt) {
        this.userId = userId;
        this.title = title;
        this.coverImg = coverImg;
        this.description = description;
        this.publishedDate = publishedDate;
        this.pages = pages;
        this.categories = categories;
        this.author = author;
        this.requestStatus = requestStatus;
        this.createdAt = createdAt;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(long publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(int requestStatus) {
        this.requestStatus = requestStatus;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}