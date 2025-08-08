package com.viictoramorim.DesafioTecn_PicPay.exceptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String mensagem){
        super(mensagem);
    }
}
