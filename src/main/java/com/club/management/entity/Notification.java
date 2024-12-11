//package com.club.management.entity;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "notifications")
//public class Notification {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long notificationId;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private Users recipient;
//
//    private String message;
//
//    @Column(name = "is_read", nullable = false)
//    private boolean isRead = false;
//
//    @Column(name = "sent_at", nullable = false)
//    private LocalDateTime sentAt;
//
//    // Getters and setters
//    public Long getNotificationId() {
//        return notificationId;
//    }
//
//    public void setNotificationId(Long notificationId) {
//        this.notificationId = notificationId;
//    }
//
//    public Users getRecipient() {
//        return recipient;
//    }
//
//    public void setRecipient(Users recipient) {
//        this.recipient = recipient;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public boolean isRead() {
//        return isRead;
//    }
//
//    public void setRead(boolean read) {
//        isRead = read;
//    }
//
//    public LocalDateTime getSentAt() {
//        return sentAt;
//    }
//
//    public void setSentAt(LocalDateTime sentAt) {
//        this.sentAt = sentAt;
//    }
//}
