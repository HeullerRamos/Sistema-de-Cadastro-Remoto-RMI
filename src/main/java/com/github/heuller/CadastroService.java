package com.github.heuller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CadastroService extends Remote {

    void cadastrar(Aluno aluno) throws RemoteException;
    List<Aluno> listarAlunos()throws RemoteException;
    Aluno buscarAluno(int id) throws RemoteException;

}
