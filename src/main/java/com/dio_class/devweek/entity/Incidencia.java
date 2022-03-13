package com.dio_class.devweek.entity;

import javax.persistence.*;

@Entity
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Integer Regiao_id;
    private Integer Mes;
    private Long Faixa_id;
    private Integer Qnt_exames;

    public Incidencia() {
    }

    public Incidencia(Integer regiao_id, Integer mes, Long faixa_id, Integer qnt_exames) {
        Regiao_id = regiao_id;
        Mes = mes;
        Faixa_id = faixa_id;
        Qnt_exames = qnt_exames;
    }

    public Long getId() {
        return id;
    }


    public Integer getRegiao_id() {
        return Regiao_id;
    }

    public void setRegiao_id(Integer regiao_id) {
        this.Regiao_id = regiao_id;
    }

    public Integer getMes() {
        return Mes;
    }

    public void setMes(Integer mes) {
        this.Mes = mes;
    }

    public Long getFaixa_id() {
        return Faixa_id;
    }

    public void setFaixa_id(Long faixa_id) {
        this.Faixa_id = faixa_id;
    }

    public Integer getQnt_exames() {
        return Qnt_exames;
    }

    public void setQnt_exames(Integer qnt_exames) {
        this.Qnt_exames = qnt_exames;
    }
}
