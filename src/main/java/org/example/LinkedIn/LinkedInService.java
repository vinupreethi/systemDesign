package org.example.LinkedIn;
/****/
//User can send request to each other.
//User can view the connection
//User can send messages,
//Notification service is used to send notification

import org.example.LinkedIn.notification.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/****/
public class LinkedInService {

    static LinkedInService linkedInService;
    private ConcurrentHashMap<String, User> profileHashMap;
    private ConcurrentHashMap<User, List<Job>> jobConcurrentHashMap;

    private LinkedInService() {

    }

    public ConcurrentHashMap<String, User> getProfileHashMap() {
        return profileHashMap;
    }

    public void setProfileHashMap(ConcurrentHashMap<String, User> profileHashMap) {
        this.profileHashMap = profileHashMap;
    }


    public static LinkedInService getInstance() {
        if (linkedInService == null) {
            synchronized (LinkedInService.class) {
                if (linkedInService == null) {
                    return new LinkedInService();
                }
            }
        }
        return linkedInService;
    }

    public static LinkedInService getLinkedInService() {
        return linkedInService;
    }

    public static void setLinkedInService(LinkedInService linkedInService) {
        LinkedInService.linkedInService = linkedInService;
    }


    public void createProfile(User user1) throws UserAlreadyPresentForEmailId {
        if (profileHashMap.get(user1.getEmailId()) == null)
            profileHashMap.put(user1.getEmailId(), user1);
        else
            throw new UserAlreadyPresentForEmailId("User is already present..!");
    }

    public void login(String emailId, String password) throws ExceptionWhileLoggingIn {
        User user = profileHashMap.get(emailId);
        if (user.getConnectionList().equals(password))
            System.out.println("Authenticated and logged in successfully");
        else
            throw new ExceptionWhileLoggingIn("Excpetionn in login");

    }


    public void acceptConnectionRequest(User user1, User user2) {
        LocalDateTime localDateTime = LocalDateTime.of(2025, Month.FEBRUARY, 12, 0, 0);
        NotificationService notificationService = new ConnectionAcceptNotification("1", user1, "Accepted the request", localDateTime);
        notificationService.notification(user1, user2);
        Connection connection = new Connection();
        connection.setUser1(user1);
        connection.setUser2(user2);
        connection.setConnectionDate(localDateTime);
        user1.getConnectionList().add(connection);
        user2.getConnectionList().add(connection);

    }

    public void sendConnectionRequest(User user1, User user2) {
        LocalDateTime localDateTime = LocalDateTime.of(2025, Month.FEBRUARY, 12, 0, 0);
        NotificationService notificationService = new ConnectionRequestNotification("1", user1, "Please accept my request", localDateTime);
        notificationService.notification(user1, user2);
        Connection connection = new Connection();
        connection.setUser1(user1);
        connection.setUser2(user2);


    }

    public void createAPost(User user) {
        Post post = new Post();
        user.getPosts().add(post);
        post.setContent("im Posting regarding a job opportunity");
        List<Connection> connections = user.getConnectionList();
        for (Connection connectionList : connections) {
            if (connectionList.getUser1() == user) {
                NotificationService notificationService = new PostNotificationConnection("1", user, post.getContent(), post.getTime());
                notificationService.notification(user, connectionList.getUser2());
            } else if (connectionList.getUser2() == user) {
                NotificationService notificationService = new PostNotificationConnection("1", user, post.getContent(), post.getTime());
                notificationService.notification(user, connectionList.getUser1());
            }
        }

    }

    public void checkNewFeed(User user) {
        List<Connection> connections = user.getConnectionList();
        for (Connection connectionList : connections) {
            connectionList.getUser2().getPosts();
        }
    }

    public List<Connection> checkNumberOfRequestReceived(User user) {
        return user.getReceivedConnection();

    }

    public List<Connection> checkNumberOfRequestSent(User user) {
        return user.getSentConnection();
    }

    public void sendMessage(User user1, User user2) {
        LocalDateTime localDateTime = LocalDateTime.of(2025, Month.FEBRUARY, 12, 0, 0);
        Message message = new Message("hello", "helloo");
        NotificationService notificationService = new SendMessageNotification("1", user1, message, localDateTime);
        NotificationService notificationService1 = new ReceiveMessageNotificatoin("1", user2, localDateTime);
        notificationService1.notification(user1, user2);
        notificationService.notification(user1, user2);
        user1.getSentMessage().add(message);
        user2.getInboxMessage().add(message);
    }

    public void searchAndapplyJob(User user1, String jobName) {
    }


    public void deactivateUser(User user1) throws UserNotAvailableException {
        if (!profileHashMap.containsKey(user1))
            throw new UserNotAvailableException("User is not available");
        profileHashMap.remove(user1.getEmailId());

    }

    public void addJob(User user, Job job) {
        /**Todo handle exception **/
       List<Job> jobs=jobConcurrentHashMap.get(user);
       jobs.add(job);
    }

    public void removeJob(User user, Job job) {
        /**Todo handle exception **/
        List<Job> jobs=jobConcurrentHashMap.remove(user);
        jobs.add(job);
    }
}
