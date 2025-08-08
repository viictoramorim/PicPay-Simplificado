package com.viictoramorim.DesafioTecn_PicPay.service;

import com.viictoramorim.DesafioTecn_PicPay.entity.Carteira;
import com.viictoramorim.DesafioTecn_PicPay.entity.User;
import com.viictoramorim.DesafioTecn_PicPay.exceptions.UserNotFound;
import com.viictoramorim.DesafioTecn_PicPay.infrastructure.clients.AutorizacaoClient;
import com.viictoramorim.DesafioTecn_PicPay.repository.CarteiraRepository;
import com.viictoramorim.DesafioTecn_PicPay.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CarteiraService {

    private final CarteiraRepository repository;

    public void salvar(Carteira carteira){
        repository.save(carteira);
    }
}
