package com.github.heuller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Servidor extends UnicastRemoteObject implements CadastroService {

    private List<Aluno> alunos;

    protected Servidor() throws RemoteException {
        super();
        alunos = new CopyOnWriteArrayList<>();
        System.out.println("Servidor Iniciado");
    }

    @Override
    public void cadastrar(Aluno aluno) throws RemoteException {
        System.out.println("Recebido pedido para cadastrar" + aluno);
        alunos.add(aluno);
        System.out.println("Aluno cadastrado\n Total de alunos= " + alunos.size());
    }

    @Override
    public List<Aluno> listarAlunos() throws RemoteException {
        System.out.println("Recebido pedido para ListarAlunos");
        return alunos;
    }

    @Override
    public Aluno buscarAluno(int id) throws RemoteException {
        System.out.println("Recebido pedido para buscar id= "+id);
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }


    public static void main(String[] args) {

        try{
            Servidor servidor = new Servidor();

            //rmi iniciado na porta 1099 padrão
            Registry registry = LocateRegistry.createRegistry(1099);

            registry.bind("CadastroService",servidor);

            System.out.println("Servidor rmi pronto");
        }catch (Exception e){
            System.err.println("Erro ao tentar abrir o servidor");
            e.printStackTrace();
        }
    }
}
