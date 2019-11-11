/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadeum;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author isabelatta
 */
public class NotaDAO {

    public NotaDAO() {
    }

    
    String mediaGeral(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        float media = 0;

        try {
            List<Nota> notas = session.createCriteria(Nota.class).list();
            for(Nota nota : notas){
                media += nota.getNotNota();
            }
            media = media/notas.size();
            session.close();
            return "A média geral é: " + media;

        } catch (HibernateException e) {
            e.printStackTrace(); 
            session.close();
            return "Ocorreu um erro inesperado";
        }
    }

}
