package atividadeum;
// Generated 09/11/2019 17:26:02 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Aluno generated by hbm2java
 */
public class Aluno  implements java.io.Serializable {


     private String aluMatricula;
     private String aluNome;
     private Set notas = new HashSet(0);

    public Aluno() {
    }

	
    public Aluno(String aluMatricula, String aluNome) {
        this.aluMatricula = aluMatricula;
        this.aluNome = aluNome;
    }
    public Aluno(String aluMatricula, String aluNome, Set notas) {
       this.aluMatricula = aluMatricula;
       this.aluNome = aluNome;
       this.notas = notas;
    }
   
    public String getAluMatricula() {
        return this.aluMatricula;
    }
    
    public void setAluMatricula(String aluMatricula) {
        this.aluMatricula = aluMatricula;
    }
    public String getAluNome() {
        return this.aluNome;
    }
    
    public void setAluNome(String aluNome) {
        this.aluNome = aluNome;
    }
    public Set getNotas() {
        return this.notas;
    }
    
    public void setNotas(Set notas) {
        this.notas = notas;
    }




}


