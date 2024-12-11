package com.club.management.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

    @Entity
    @Table(name = "users")
    public class Users {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long user_id;

        private String student_id;
        private String name;
        private String email;
        private String password;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        public Long getUser_id() {
            return user_id;
        }

        public void setUser_id(Long user_id) {
            this.user_id = user_id;
        }

        public String getStudent_id() {
            return student_id;
        }

        public void setStudentId(String student_id) {
            this.student_id = student_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }


    }

