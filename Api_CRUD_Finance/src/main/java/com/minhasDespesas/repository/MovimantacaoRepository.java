package com.minhasDespesas.repository;

import com.minhasDespesas.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimantacaoRepository extends JpaRepository <Movimentacao, Long> {
}
