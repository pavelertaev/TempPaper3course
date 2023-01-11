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
            }else{
                throw new IllegalArgumentException("На складе  нет нужного кол-ва  носков");
            }
        }
    }
    @Override
    public int getQuantity(Sock sock){
        return socks.get(sock);
    }

    @Override
    public int getSock(String color, int size, int cottonPartMin, int cottonPartMax){
        int quantity = 0;
        Sock.Color color1 = Sock.convertColor(color);
        Sock.Size size1 = Sock.sizeConvertor(size);
        for(Sock sock : socks.keySet()){
            if(sock.getColor().equals(color1)&&sock.getSize().equals(size1)&&sock.getCottonPart()>=cottonPartMin&&sock.getCottonPart()<=cottonPartMax){
                quantity+= socks.get(sock);
            }else {
                throw new IllegalArgumentException("Нужных носков на складе нет");
            }
        }
        return quantity;
    }


}
