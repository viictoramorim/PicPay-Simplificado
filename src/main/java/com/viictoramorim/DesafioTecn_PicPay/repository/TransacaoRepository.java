package com.viictoramorim.DesafioTecn_PicPay.repository;

import com.viictoramorim.DesafioTecn_PicPay.entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacoes, Long> {
}
