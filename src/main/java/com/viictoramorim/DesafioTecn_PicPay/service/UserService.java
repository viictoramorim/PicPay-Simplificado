package com.viictoramorim.DesafioTecn_PicPay.service;

import com.viictoramorim.DesafioTecn_PicPay.entity.User;
import com.viictoramorim.DesafioTecn_PicPay.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User buscarUser(Long id){
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado!") );
    }
}
