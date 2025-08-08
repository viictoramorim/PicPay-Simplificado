package com.viictoramorim.DesafioTecn_PicPay.service;


import com.viictoramorim.DesafioTecn_PicPay.infrastructure.clients.NotificacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoClient client;

    public void enviarNotifcacao(){
        client.enviarNotificacao();
    }
}
