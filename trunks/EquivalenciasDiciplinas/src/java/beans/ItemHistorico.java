/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author josimar
 */
@Entity
public class ItemHistorico implements Serializable {
    @ManyToOne
    private RequisicaoEquivalencia requisicao;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)  
    @Column(length=20)
    private StatusSolicitacao status;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Calendar dataModificacao;

    public ItemHistorico() {
    }

    public ItemHistorico(RequisicaoEquivalencia requisicao) {
        this.requisicao = requisicao;
        this.status = requisicao.getStatus();
        this.dataModificacao =Calendar.getInstance();
    }
    
    public Long getId() {
        return id;
    }

    public Calendar getDataModificacao() {
        return dataModificacao;
    }

   

    public RequisicaoEquivalencia getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(RequisicaoEquivalencia requisicao) {
        this.requisicao = requisicao;
    }

    public StatusSolicitacao getStatus() {
        return status;
    }

    public void setStatus(StatusSolicitacao status) {
        this.status = status;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemHistorico)) {
            return false;
        }
        ItemHistorico other = (ItemHistorico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.ItemHistorico[ id=" + id + " ]";
    }
    
}
