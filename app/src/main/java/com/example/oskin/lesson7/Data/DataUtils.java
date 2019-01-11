package com.example.oskin.lesson7.Data;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {

    public static List<MyNotification> generateData(){
        List<MyNotification> notifications = new ArrayList<>();

        notifications.add(new Call("John","9:30 AM"));
        notifications.add(new Call("Rob","9:40 AM"));
        notifications.add(new SMS("Sandy","Hey, what's up?","9:42 AM"));
        notifications.add(new Sbol(
                "McDonald’s",
                "https://i.ibb.co/3dcKh9n/ec8310bd6a3a14130896df93ed6fbfc4.png",
                "5678",
                "540,00",
                "50 145,00",
                "9:43 AM"));
        notifications.add(new Call("Peter","9:45 AM"));
        notifications.add(new SMS("John","Are you writing blog?","9:48 AM"));
        notifications.add(new Sbol(
                "Leroy Merlin",
                "https://i.ibb.co/b21V5mz/i.jpg",
                "5678",
                "13 372,28",
                "36 772,72",
                "9:50 AM"));
        notifications.add(new Call("Jack","9:50 AM"));
        notifications.add(new SMS("Kora","Thanks dude","9:51 AM"));
        notifications.add(new Sbol(
                "Billa",
                "https://i.ibb.co/Yh5NYRn/15976.jpg",
                "5678",
                "4240,00",
                "32 532,72",
                "9:55 AM"));
        notifications.add(new Call("Sandy","10:00 AM"));
        notifications.add(new Call("Kate","10:05 AM"));
        notifications.add(new SMS("Nick","Let's hang up","10:10 AM"));
        notifications.add(new Call("Roger","10:15 AM"));
        notifications.add(new Call("Sid","10:20 AM"));
        notifications.add(new Call("Kora","10:25 AM"));
        notifications.add(new Call("Nick","10:30 AM"));
        notifications.add(new SMS("Rose","Bring me some chocolates","1035:10 AM"));
        notifications.add(new Call("Mia","10:40 AM"));
        notifications.add(new Call("Scott","10:45 AM"));

        return notifications;
    }

}
