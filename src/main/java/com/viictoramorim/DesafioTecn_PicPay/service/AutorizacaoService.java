package com.viictoramorim.DesafioTecn_PicPay.service;

import com.viictoramorim.DesafioTecn_PicPay.infrastructure.clients.AutorizacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AutorizacaoService {

    private final AutorizacaoClient client;

    public boolean validarTranferencia(){
        if (Objects.equals(client.validarAutorizacao().dataDTO().authorization(), "true")){
            return true;
        }
        return false;
    }
}
