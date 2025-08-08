package com.viictoramorim.DesafioTecn_PicPay.service;

import com.viictoramorim.DesafioTecn_PicPay.controller.TransacaoDTO;
import com.viictoramorim.DesafioTecn_PicPay.entity.TipoUser;
import com.viictoramorim.DesafioTecn_PicPay.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferenciasService {

    private final UserService userService;
    private final AutorizacaoService autorizacaoService;

    //Recebe dados.
    @Transactional
    public void trasnferirValores(TransacaoDTO transacaoDTO) {
        //Buscar dados
        User pagador = userService.buscarUser(transacaoDTO.payer());
        User recebedor = userService.buscarUser((transacaoDTO.payee()));

        validaPagadorLogista(pagador);
        validarSaldoUser(pagador, transacaoDTO.value());
        validarTransferencia();
    }
// Ver se o pagador não é um logista
        private void validaPagadorLogista(User user) {
            try {
                if (user.getTipoUser().equals(TipoUser.LOGISTA)) {
                    throw new IllegalArgumentException("Transação não autorizada para logista");
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        //Ver saldo do User.
        private void validarSaldoUser(User user, BigDecimal valor){
            try{
                if (user.getCarteira().getSaldo().compareTo(valor) < 0){
                    throw  new IllegalArgumentException("Transação não autorizada, saldo insuficiente. ")
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

    private void validarTransferencia(){
        try{
            if (!autorizacaoService.validarTranferencia()){
                throw  new IllegalArgumentException("Transação não autorizada, pela API. ")
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
