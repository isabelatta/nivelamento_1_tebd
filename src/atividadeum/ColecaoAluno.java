package atividadeum;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.util.*;
import java.sql.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public  class ColecaoAluno{
	
	public static final int ADICIONAR = 1;
	public static final int REMOVER = 2;
	public static final int CONSULTARMEDIA = 3;
	public static final int CONSULTARMEDIAGERAL = 4;
        private AlunoDAO alunoDAO;
        private NotaDAO notaDAO;
        
/**
* Metodo Construtor que gera uma conexao com o Banco de Dados
*/
	public ColecaoAluno() throws Exception{
            alunoDAO = new AlunoDAO();
            notaDAO = new NotaDAO();
	}
/**
* Metodo que monta o menu principal e 
* obtem uma opcao do usuario
*/
	public int criaMenuPrincipal(){
            int opcao;
            System.out.println("Menu de Opcoes:");
            System.out.println("-------------------");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Remover Aluno");
            System.out.println("3. Consultar Média de um Aluno");
            System.out.println("4. Consultar Média Geral");
            System.out.println("5. Sair do Programa");
            System.out.println("-------------------");
            return opcao = Console.readInt();
	}
/**	

/**
* 
*/	
	public void AdicionarAluno()throws Exception{
            Aluno aluno = null;
            Nota notaAluno1 = null;
            Nota notaAluno2 = null;
            Nota notaAluno3 = null;
            
            System.out.println("Adicionar Aluno:");
            System.out.println("-------------------");
            System.out.print("Nome do Aluno:");
            String nome = Console.readLine();
            System.out.print("Matricula do Aluno:");
            String matricula = Console.readLine();
            
            System.out.println("Adicionar Notas do Aluno:");
            System.out.println("-----------------------------");
            
            System.out.println("Nota 1: ");
            String nota1String = Console.readLine();
            float nota1 = parseFloat(nota1String);
  
            System.out.println("Nota 2: ");
            String nota2String = Console.readLine();
            float nota2 = parseFloat(nota2String);
            
            System.out.println("Nota 3: ");
            String nota3String = Console.readLine();
            float nota3 = parseFloat(nota3String);
            
            aluno = new Aluno();
            aluno.setAluMatricula(matricula);
            aluno.setAluNome(nome);

            notaAluno1 = new Nota();
            notaAluno1.setNotNota(nota1);
            notaAluno1.setAluno(aluno);

            notaAluno2 = new Nota();
            notaAluno2.setNotNota(nota2);
            notaAluno2.setAluno(aluno);

            notaAluno3 = new Nota();
            notaAluno3.setNotNota(nota3);
            notaAluno3.setAluno(aluno);    
            
            String msg = alunoDAO.addAluno(aluno, notaAluno1, notaAluno2, notaAluno3);
            
            System.out.println(msg);
            esperarEnter();

	}
	
	
	
	
	public void RemoverAluno()throws Exception{
            Session session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("Digite a matricula do aluno para ser removido: ");
            String matricula = Console.readLine();

            String msg = alunoDAO.removerAluno(matricula);
            System.out.println(msg);
            esperarEnter();
	}
	

	
	public void ConsultarMedia() throws Exception{
            Session session = HibernateUtil.getSessionFactory().openSession();
            float media = 0;
            System.out.println("Digite a matricula do aluno: ");
            String matricula = Console.readLine();
            

            String msg = alunoDAO.consultarMedia(matricula);
            System.out.println(msg);
            esperarEnter();
	
	}
        
        public void ConsultarMediaGeral() throws Exception{
            String msg = notaDAO.mediaGeral();
            System.out.println(msg);
            esperarEnter();
	}
        
        public void esperarEnter(){
            System.out.println("Pressione \"ENTER\" para continuar...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
	
	public static void main(String args[]){
		
		try {
                    ColecaoAluno ca = new ColecaoAluno();
                    int opcao;
                    while((opcao = ca.criaMenuPrincipal()) != 5){
                        switch (opcao) {
                            case ColecaoAluno.ADICIONAR:
                                ca.AdicionarAluno();
                                break;
                            case ColecaoAluno.CONSULTARMEDIA:
                                ca.ConsultarMedia();
                                break;
                            case ColecaoAluno.CONSULTARMEDIAGERAL:
                                ca.ConsultarMediaGeral();
                                break;
                            case ColecaoAluno.REMOVER:
                                ca.RemoverAluno();
                                break;
                            default:
                                System.out.println("Escolha uma opção válida.");
                        }
                    }
                    System.exit(0);
                    HibernateUtil.shutdown();
		}catch(Exception e){
                    e.printStackTrace();
                }	
	}
}