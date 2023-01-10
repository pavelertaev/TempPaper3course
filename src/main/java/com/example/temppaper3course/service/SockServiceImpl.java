package com.example.temppaper3course.service;

import com.example.temppaper3course.model.Sock;
import com.example.temppaper3course.model.SockStore;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SockServiceImpl implements SockService {
    private static Map<Sock, Integer> socks = new HashMap<>();


    @Override
    public void addSock(SockStore sockStore) {
        Sock sock = sockStore.getSock();
        int quantity = sockStore.getQuantity();
        socks.put(sock, socks.getOrDefault(sock, 0) + quantity);

    }

    @Override
    public void putSock(SockStore sockStore) {
        if (socks.containsKey(sockStore.getSock())) {
            if (socks.get(sockStore.getSock()) >= sockStore.getQuantity()) {
                socks.put(sockStore.getSock(), socks.get(sockStore.getSock()) - sockStore.getQuantity());
            }
        }
    }






}
