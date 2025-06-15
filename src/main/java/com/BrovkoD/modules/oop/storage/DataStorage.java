package com.BrovkoD.storage;

public abstract class DataStorage implements Removable {

    public abstract Object getData(int id);

    public abstract void setData(int id, Object data);

    public abstract void addData(Object data);
}
