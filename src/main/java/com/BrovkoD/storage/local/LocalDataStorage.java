package com.BrovkoD.storage.local;

import com.BrovkoD.storage.DataStorage;

import java.util.ArrayList;
import java.util.List;

public class LocalDataStorage extends DataStorage {

    private List<Object> localData = new ArrayList<>();

    @Override
    public Object getData(int id) {
        return localData.get(id);
    }

    @Override
    public void setData(int id, Object data) {
        localData.set(id, data);
    }

    @Override
    public void addData(Object data) {
        localData.add(data);
    }

    @Override
    public void deleteDataById(int id) {
        localData.remove(id);
    }

    @Override
    public void deleteAllData() {
        localData = null;
    }

    @Override
    public String toString() {
        return "LocalDataStorage{" +
                "localData=" + localData +
                '}';
    }
}
