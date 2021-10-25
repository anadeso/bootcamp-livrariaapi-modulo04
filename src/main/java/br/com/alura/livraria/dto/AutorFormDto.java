package br.com.alura.livraria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import java.time.LocalDate;

@Getter
@Setter
public class AutorFormDto {

    @NotBlank(message = "Deve ser informado, por favor!")
    @Size(min = 3, max = 40)
    private String nome;

    @NotBlank
    @Email
    @Size(min = 8, max = 40)
    private String email;

    @NotNull
    @Past
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotBlank
    @Size(min = 10, max = 300)
    private String miniCurriculo;

    public AutorFormDto(String nome, String email, LocalDate dataNascimento, String miniCurriculo) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.miniCurriculo = miniCurriculo;
    }
}
