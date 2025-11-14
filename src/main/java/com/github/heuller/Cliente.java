package com.github.heuller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {
        try{
            Registry registro = LocateRegistry.getRegistry(1099);

            CadastroService service = (CadastroService) registro.lookup("CadastroService");

            System.out.println("Conectado ao servidor. Realizando operações...");

            // --- Teste 1: Cadastrar Alunos ---
            System.out.println("\nCadastrando alunos...");
            service.cadastrar(new Aluno(1, "Ana Silva", "Engenharia"));
            service.cadastrar(new Aluno(2, "Bruno Costa", "Computação"));
            service.cadastrar(new Aluno(3, "Carla Dias", "Medicina"));
            System.out.println("Alunos cadastrados.");

            // --- Teste 2: Listar Todos ---
            System.out.println("\nListando todos os alunos:");
            List<Aluno> alunos = service.listarAlunos();
            for (Aluno a : alunos) {
                System.out.println(a.toString()); // Objeto complexo recebido!
            }

            // --- Teste 3: Buscar por ID ---
            System.out.println("\nBuscando aluno com ID 2:");
            Aluno alunoBuscado = service.buscarAluno(2);
            if (alunoBuscado != null) {
                System.out.println("Encontrado: " + alunoBuscado.toString()); // Objeto complexo recebido!
            } else {
                System.out.println("Aluno não encontrado.");
            }

            System.out.println("\nBuscando aluno com ID 99:");
            Aluno alunoInexistente = service.buscarAluno(99);
            if (alunoInexistente == null) {
                System.out.println("Aluno 99 não encontrado (correto).");
            }
        } catch (Exception e) {
            System.err.println("Erro ao tentar abrir o servidor");
            e.printStackTrace();
        }
    }

}
