package com.BrovkoD.storage.local;

public class Client extends LocalDataStorage {

    public Client() {

        addData("Client started");
        System.out.println(this);

        deleteAllData();
        System.out.println(this);
    }
}
