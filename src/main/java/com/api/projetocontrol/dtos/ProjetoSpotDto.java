package com.api.projetocontrol.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProjetoSpotDto {

    @NotBlank
    private String projetoSpotnome;
    @NotBlank
    @Size(max = 7)
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String endereco;
    @NotBlank
    private String rg;
    @NotBlank
    private String aparelhoDesejaDoar;
    @NotBlank
    private String PontodeRetirada;
    @NotBlank
    private String assunto;

    public String getProjetoSpotnome() {
        return projetoSpotnome;
    }

    public void setProjetoSpotnome(String projetoSpotnome) {
        this.projetoSpotnome = projetoSpotnome;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
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
        this.PontodeRetirada = pontodeRetirada;
    }

    public String getassunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
