package com.viictoramorim.DesafioTecn_PicPay.controller;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal value, Long payer, Long payee) {
}
