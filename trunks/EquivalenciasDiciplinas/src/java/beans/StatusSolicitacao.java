/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author josimar
 */
public enum StatusSolicitacao{ 
    EM_ANDAMENTO, ACEITO, NEGADO;

   public String getEM_ANDAMENTO(){
       return "EM_ANDAMENTO";
   }
   public String getACEITO(){
       return "ACEITO";
   }
   public String getNEGADO(){
       return "NEGADO";
   }
}

