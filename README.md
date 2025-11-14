☕ Sistema de Cadastro Remoto com Java RMI
Este projeto é uma implementação de um sistema de cadastro simples (CRUD) utilizando Java RMI (Remote Method Invocation). Ele demonstra a comunicação entre um cliente e um servidor para manipular objetos complexos remotamente.

Status do Projeto: 🚧 Concluído 🚧

🎯 Motivação e Objetivos
O objetivo principal deste projeto é acadêmico: estudar e praticar os conceitos fundamentais de Sistemas Distribuídos usando a tecnologia Java RMI.

As principais motivações foram:

Comunicação Cliente/Servidor: Entender como um cliente pode "invocar" um método em uma máquina servidora como se fosse um método local.

RMI Registry: Praticar como o "RMI Registry" atua como um serviço de nomes (ou "lista telefônica") para que o cliente possa encontrar o servidor na rede.

Transmissão de Objetos Complexos: Focar no requisito de transmitir mais do que apenas dados primitivos (como números ou strings). O projeto força a transmissão de objetos Aluno e List<Aluno>, o que exige o uso correto da interface java.io.Serializable.

Abstração de Rede: Observar como o RMI abstrai a complexidade da comunicação de rede (sockets, serialização, desserialização) em chamadas de método simples.

⚙️ Funcionalidades do Sistema
O servidor RMI expõe um serviço que permite ao cliente realizar as seguintes operações:

✅ Cadastrar Aluno: O cliente cria um objeto Aluno localmente e o envia para o servidor, que o armazena em uma lista.

✅ Listar Todos os Alunos: O cliente solicita a lista completa de alunos e o servidor retorna uma List<Aluno>.

✅ Buscar Aluno por ID: O cliente envia um int (ID) e o servidor retorna o objeto Aluno correspondente, caso exista.

🛠️ Tecnologias Utilizadas
Java SE: Linguagem principal da aplicação.

Java RMI (Remote Method Invocation): A tecnologia central para a comunicação distribuída.

📂 Estrutura do Projeto
O sistema é composto por 4 arquivos principais, cada um com uma responsabilidade clara no padrão RMI:

Aluno.java (O Objeto de Dados)

É o "objeto complexo" a ser transmitido.

Obrigação: Deve implementar Serializable para que o RMI saiba como "empacotar" e "desempacotar" este objeto para envio pela rede.

CadastroService.java (A Interface Remota)

É o "contrato" ou "cardápio" que define o que o servidor oferece.

Obrigação: Deve estender Remote e todos os seus métodos devem declarar throws RemoteException.

Servidor.java (A Implementação / "A Cozinha")

É a lógica real do negócio. Ele implementa a interface CadastroService.

Obrigação: Deve estender UnicastRemoteObject (a forma mais fácil de "se transformar" em um servidor de rede) e se registrar (bind) no RMI Registry para que os clientes possam encontrá-lo.

Cliente.java (O Consumidor)

É a aplicação que consome os serviços.

Obrigação: Ele "procura" (lookup) o serviço no RMI Registry e o utiliza através da interface (o contrato).
🚀 Como Executar
Este projeto foi projetado para ser executado em uma IDE como o IntelliJ IDEA, que facilita o gerenciamento de múltiplos processos (Servidor e Cliente).

A ordem de execução é crucial:

Clone o repositório:

Execute o Servidor Primeiro:

Abra o arquivo Servidor.java.

Execute o método main().

Aguarde até que o console exiba: Servidor RMI pronto e ouvindo na porta 1099.

Execute o Cliente em Segundo:

Com o servidor ainda rodando, abra o arquivo Cliente.java.

Execute o método main().

Observe os Resultados:

O console do Cliente mostrará a saída das operações (cadastrando, listando e buscando).

O console do Servidor mostrará os logs de acesso (ex: "Recebido pedido de cadastro...").
