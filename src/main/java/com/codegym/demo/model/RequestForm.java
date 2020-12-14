package com.codegym.demo.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Data
public class RequestForm {
    private Long requestId;
    private User userId;
    private String title;
    private MultipartFile coverImg;
    private String description;
    private long publishedDate;
    private int pages;
    private String categories;
    private String author;
    private int requestStatus;
    private LocalDate createdAt;
    //    0: new, 1: đang xử lý, 2: đã xử lý xong
    public RequestForm() {
    }

    public RequestForm(Long requestId, User userId, String title, MultipartFile coverImg, String description, long publishedDate, int pages, String categories, String author, int requestStatus, Timestamp createdAt) {
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

    public RequestForm(Long requestId, User userId, String title, MultipartFile coverImg, String description, long publishedDate, int pages, String categories, String author, int requestStatus) {
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

    public MultipartFile getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(MultipartFile coverImg) {
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
