/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadeum;

import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author isabelatta
 */
public class AlunoDAO {

    public AlunoDAO() {
    }
    
    String addAluno(Aluno aluno, Nota notaAluno1, Nota notaAluno2, Nota notaAluno3){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            session.save(aluno);

            session.save(notaAluno1);

            session.save(notaAluno2);

            session.save(notaAluno3);


            session.getTransaction().commit();
            session.close();
            return "Aluno adicionado com sucesso";
        } catch (HibernateException e) {
            e.printStackTrace();
            session.close();
            return "Ocorreu um erro inesperado";
        }
    }
    
    String removerAluno(String matricula){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Aluno aluno = (Aluno) session.get(Aluno.class, matricula);

            if (aluno != null) {
                session.beginTransaction();
                session.delete(aluno);
                session.getTransaction().commit();
                session.close();
                return "Aluno(a) " +aluno.getAluNome()+ " removido(a) com sucesso ";
            } else {
                session.close();
                return "Aluno não encontrado no sistema.";
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            session.close();
            return "Ocorreu um erro inesperado";
        }
    }
    
    String consultarMedia(String matricula){
        Session session = HibernateUtil.getSessionFactory().openSession();
        float media = 0;

        try {
            Aluno aluno = (Aluno) session.get(Aluno.class, matricula);
            if (aluno != null) {
                Set<Nota> notas = aluno.getNotas();
                for(Nota nota : notas){
                    media += nota.getNotNota();
                }
                media = media/notas.size();
                session.close();
                return "A média do aluno " + aluno.getAluNome() + " é: " + media;
            } else {   
                session.close();
                return "Aluno não encontrado no sistema.";
            }

        } catch (HibernateException e) {
            e.printStackTrace(); 
            session.close();
            return "Ocorreu um erro inesperado";
        }
    }
    
}
