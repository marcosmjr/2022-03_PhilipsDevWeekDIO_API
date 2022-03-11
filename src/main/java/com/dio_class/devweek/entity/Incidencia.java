package com.dio_class.devweek.entity;

import javax.persistence.*;

@Entity
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Integer regiao_id;
    private Integer mes;
    private Long faixa_id;
    private Integer qnt_exames;

    public Incidencia() {
    }

    public Long getId() {
        return id;
    }


    public Integer getRegiao_id() {
        return regiao_id;
    }

    public void setRegiao_id(Integer regiao_id) {
        this.regiao_id = regiao_id;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Long getFaixa_id() {
        return faixa_id;
    }

    public void setFaixa_id(Long faixa_id) {
        faixa_id = faixa_id;
    }

    public Integer getQnt_exames() {
        return qnt_exames;
    }

    public void setQnt_exames(Integer qnt_exames) {
        this.qnt_exames = qnt_exames;
    }
}
