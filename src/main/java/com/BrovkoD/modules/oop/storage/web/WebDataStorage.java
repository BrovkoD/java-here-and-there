package com.BrovkoD.storage.web;

import com.BrovkoD.storage.DataStorage;

import java.util.ArrayList;
import java.util.List;

public class WebDataStorage extends DataStorage {

    private List<Object> webData = new ArrayList<>();

    @Override
    public Object getData(int id) {
        return webData.get(id);
    }

    @Override
    public void setData(int id, Object data) {
        webData.set(id, data);
    }

    @Override
    public void addData(Object data) {
        webData.add(data);
    }

    @Override
    public void deleteDataById(int id) {
        webData.remove(id);
    }

    @Override
    public void deleteAllData() {
        webData = null;
    }

    @Override
    public String toString() {
        return "WebDataStorage{" +
                "webData=" + webData +
                '}';
    }
}
