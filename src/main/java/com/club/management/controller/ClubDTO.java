package com.club.management.controller;

import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.List;

public class ClubDTO {

    private Integer clubId;
    private String name;
    private String description;
    private String email;
    private String studentId; // Changed from student_id to camelCase
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private String createdBy;
    @Column(nullable = false) // Ensure password is not null
    private String password; // Add this field for password
    private List<Integer> memberIds; // Assuming you want to store member IDs

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Default constructor
    public ClubDTO() {
    }

    // Constructor with fields
    public ClubDTO(Integer clubId, String name, String description, String email, String studentId,
                   LocalDateTime createdAt, String createdBy, List<Integer> memberIds) {
        this.clubId = clubId;
        this.name = name;
        this.description = description;
        this.email = email;
        this.studentId = studentId;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.memberIds = memberIds;
    }

    // Getters and Setters
    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<Integer> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<Integer> memberIds) {
        this.memberIds = memberIds;
    }
}