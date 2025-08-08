package com.viictoramorim.DesafioTecn_PicPay.service;

import com.viictoramorim.DesafioTecn_PicPay.controller.TransacaoDTO;
import com.viictoramorim.DesafioTecn_PicPay.entity.TipoUser;
import com.viictoramorim.DesafioTecn_PicPay.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferenciasService {

    private final UserService userService;

    //Recebe dados.
    public void trasnferirValores(TransacaoDTO transacaoDTO) {
        //Buscar dados
        User pagador = userService.buscarUser(transacaoDTO.payer());
        User recebedor = userService.buscarUser((transacaoDTO.payee()));

        validaPagadorLogista(pagador);
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


}
