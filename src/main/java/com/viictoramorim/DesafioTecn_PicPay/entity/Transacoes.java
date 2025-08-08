package com.viictoramorim.DesafioTecn_PicPay.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "transacao")
@Builder
public class Transacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;

    @JoinColumn(name = "recebedor_id")
    @ManyToOne
    private User recebedor;

    @JoinColumn(name = "pagador_id")
    @ManyToOne
    private User pagador;
    private LocalDateTime dataHoraTransacao;

    @PrePersist
    void prePersist(){
        dataHoraTransacao = LocalDateTime.now();
    }
}
