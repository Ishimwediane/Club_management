//package com.club.management.repo;
//
//import com.club.management.entity.Notification;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface NotificationRepo extends JpaRepository<Notification, Long> {
//    // Find notifications for a user
//    List<Notification> findByRecipientUserId(Long userId);
//
//    // Find unread notifications
//    List<Notification> findByRecipientUserIdAndIsReadFalse(Long user_id);
//}
