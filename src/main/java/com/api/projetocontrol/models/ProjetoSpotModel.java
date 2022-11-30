package com.api.projetocontrol.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PROJETO_SPOT")
public class ProjetoSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 20)
    private String nome;
    @Column(nullable = false, unique = true, length = 20)
    private String email;
    @Column(nullable = false, length = 70)
    private String telefone;
    @Column(nullable = false, length = 90)
    private String endereco;
    @Column(nullable = false, length = 70)
    private String rg;
    @Column(nullable = false)
    private LocalDateTime cpf;
    @Column(nullable = false, length = 130)
    private String aparelhoDesejaDoar;
    @Column(nullable = false, length = 30)
    private String PontodeRetirada;
    @Column(nullable = false, length = 230)
    private String Assunto;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDateTime getCpf() {
        return cpf;
    }

    public void setCpf(LocalDateTime cpf) {
        this.cpf = cpf;
    }

    public String getAparelhoDesejaDoar() {
        return aparelhoDesejaDoar;
    }

    public void setAparelhoDesejaDoar(String aparelhoDesejaDoar) {
        this.aparelhoDesejaDoar = aparelhoDesejaDoar;
    }

    public String getPontodeRetirada() {
        return PontodeRetirada;
    }

    public void setPontodeRetirada(String pontodeRetirada) {
        PontodeRetirada = pontodeRetirada;
    }

    public String getAssunto() {
        return Assunto;
    }

    public void setAssunto(String assunto) {
        Assunto = assunto;
    }
}