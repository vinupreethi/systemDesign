package org.example.LinkedIn;
/****/
//User can send request to each other.
//User can view the connection
//User can send messages,
//Notification service is used to send notification
//


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/****/
public class LinkedInDemo {
    public static void main(String args[]) throws UserAlreadyPresentForEmailId, ExceptionWhileLoggingIn, UserNotAvailableException {
        LinkedInService linkedInService = LinkedInService.getInstance();
        Profile profile = new Profile();
        User user1 = new User("vinu", "vinuvas321@gmail.com", "hello", profile, null, null, null);
        linkedInService.createProfile(user1);

        Profile profile1 = new Profile();
        User user2 = new User("preethi", "preethiav123@gmail.com", "hello", profile1, null, null, null);

        /**** User can register in linkedin ******/
        linkedInService.createProfile(user2);

        /**** User can login ******/
        Scanner scanner = new Scanner(System.in);
        String emailId = scanner.next();
        String password = scanner.next();
        linkedInService.login(emailId, password);

        /**** Search by User and User can send connection request ******/
        linkedInService.sendConnectionRequest(user1, user2);

        /**** User can accept connection request ******/
        linkedInService.acceptConnectionRequest(user1, user2);

        /** user can post  ****/
        linkedInService.createAPost(user1);

        /*** User can view list of post from connections ***/
        linkedInService.checkNewFeed(user1);

        /**** User can send & receive message request ******/
        linkedInService.sendMessage(user1, user2);

        /** User can view List of jobs and apply for the job **/

        /** User can search by company name and view list of jobs **/

        /** User can add a job**/
        Job job=new Job(1,"ABC","ABCD");
        linkedInService.addJob(user1,job);
        linkedInService.removeJob(user1,job);

        /** User can search by job name and apply it**/

        /**** User can check notifications from list of connections ******/

        /*** User can deactivate profile ****/
        linkedInService.deactivateUser(user1);


    }


}
