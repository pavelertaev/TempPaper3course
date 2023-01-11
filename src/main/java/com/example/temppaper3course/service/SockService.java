package com.example.temppaper3course.service;

import com.example.temppaper3course.model.Sock;
import com.example.temppaper3course.model.SockStore;

public interface SockService {

    void addSock(SockStore sockStore);

    void putSock(SockStore sockStore);

    int getQuantity(Sock sock);

    int getSock(String color, int size, int cottonPartMin, int cottonPartMax);
}
