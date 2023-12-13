package br.com.pedroceolato.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException{
    public UserFoundException() {
        super("Usuário ja existe");
    }
}
