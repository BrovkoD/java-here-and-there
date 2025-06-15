package com.BrovkoD.storage.web;

public class Server extends WebDataStorage {

    public Server() {

        addData("Server started");
        System.out.println(this);

        deleteAllData();
        System.out.println(this);
    }
}
