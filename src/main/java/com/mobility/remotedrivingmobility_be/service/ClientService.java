package com.mobility.remotedrivingmobility_be.service;

import com.mobility.remotedrivingmobility_be.domain.member.Client;
import com.mobility.remotedrivingmobility_be.domain.member.Member;
import com.mobility.remotedrivingmobility_be.domain.remotedrivingroom.RemoteDrivingRoom;
import com.mobility.remotedrivingmobility_be.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mobility.remotedrivingmobility_be.domain.member.Client.*;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public void addClient(Member member, RemoteDrivingRoom room, String session) {
        clientRepository.save(createClient(member, room, session));
    }

    public List<Client> searchClientsByRoom(RemoteDrivingRoom room) {
        return clientRepository.findByRemoteDrivingRoom(room).orElse(new ArrayList<>());
    }

    public Client searchClientBySessionId(String sessionId) {
        return clientRepository.findBySessionId(sessionId).orElseThrow(() -> new IllegalArgumentException("해당 세션에 해당하는 클라이언트가 존재하지 않습니다."));
    }
}
