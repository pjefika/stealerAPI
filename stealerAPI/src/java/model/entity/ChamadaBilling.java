/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "BITB67_CDR_FACT", schema = "PWMART")
@Immutable
public class ChamadaBilling implements Serializable {

    @Id
    @Column(name = "CDRF_IDEN_TRACKING_ID")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CDRF_DATE_START_CALL")
    private Calendar dataInicio;

    @Column(name = "CDRF_NMBR_PHONE_ORIG")
    private String numeroOrig;

    @Column(name = "CDRF_NMBR_PHONE_DEST")
    private String numeroDest;

    public ChamadaBilling() {
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getNumeroOrig() {
        return numeroOrig;
    }

    public void setNumeroOrig(String numeroOrig) {
        this.numeroOrig = numeroOrig;
    }

    public String getNumeroDest() {
        return numeroDest;
    }

    public void setNumeroDest(String numeroDest) {
        this.numeroDest = numeroDest;
    }

}
