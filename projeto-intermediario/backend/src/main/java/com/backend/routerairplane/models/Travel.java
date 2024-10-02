package com.backend.routerairplane.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Travel {

        private Long idViagem;
        private Long idUser;
        private String localViagem;
        private String localHospedagem;
        private LocalDate dataInicio;
        private LocalDate dataFim;
        private BigDecimal valorPassagem;
        private BigDecimal valorHospedagem;
        private BigDecimal valorConsumo;
        private BigDecimal valorTotal;

        // Getters e Setters.

        public Long getIdViagem() {
            return idViagem;
        }

        public void setIdViagem(Long idViagem) {
            this.idViagem = idViagem;
        }

        public Long getIdUser() {
            return idUser;
        }

        public void setIdUser(Long idUser) {
            this.idUser = idUser;
        }

        public String getLocalViagem() {
            return localViagem;
        }

        public void setLocalViagem(String localViagem) {
            this.localViagem = localViagem;
        }

        public String getLocalHospedagem() {
            return localHospedagem;
        }

        public void setLocalHospedagem(String localHospedagem) {
            this.localHospedagem = localHospedagem;
        }

        public LocalDate getDataInicio() {
            return dataInicio;
        }

        public void setDataInicio(LocalDate dataInicio) {
            this.dataInicio = dataInicio;
        }

        public LocalDate getDataFim() {
            return dataFim;
        }

        public void setDataFim(LocalDate dataFim) {
            this.dataFim = dataFim;
        }

        public BigDecimal getValorPassagem() {
            return valorPassagem;
        }

        public void setValorPassagem(BigDecimal valorPassagem) {
            this.valorPassagem = valorPassagem;
        }

        public BigDecimal getValorHospedagem() {
            return valorHospedagem;
        }

        public void setValorHospedagem(BigDecimal valorHospedagem) {
            this.valorHospedagem = valorHospedagem;
        }

        public BigDecimal getValorConsumo() {
            return valorConsumo;
        }

        public void setValorConsumo(BigDecimal valorConsumo) {
            this.valorConsumo = valorConsumo;
        }

        public BigDecimal getValorTotal() {
            return valorTotal;
        }

        public void setValorTotal(BigDecimal valorTotal) {
            this.valorTotal = valorTotal;
        }
}
