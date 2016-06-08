package it.uniroma3.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="EsamiMedico",
			query="SELECT e FROM Esame e WHERE medicoId = :id"),
	@NamedQuery(name="EsamiPaziente",
	query="SELECT e FROM Esame e WHERE pazienteId = :id")
})
public class Esame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private TipologiaDiEsame tipologia;

	@OneToOne
	private Medico medico;

	@Temporal (TemporalType.DATE)
	private Date dataPrenotazione;

	@Temporal (TemporalType.DATE)
	private Date dataEsameEffettuato;

	@OneToOne
	private Paziente paziente;

	protected Esame() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEsameEffettuato == null) ? 0 : dataEsameEffettuato.hashCode());
		result = prime * result + ((dataPrenotazione == null) ? 0 : dataPrenotazione.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (dataEsameEffettuato == null) {
			if (other.dataEsameEffettuato != null)
				return false;
		} else if (!dataEsameEffettuato.equals(other.dataEsameEffettuato))
			return false;
		if (dataPrenotazione == null) {
			if (other.dataPrenotazione != null)
				return false;
		} else if (!dataPrenotazione.equals(other.dataPrenotazione))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Esame [id=" + id + ", tipologia=" + tipologia + ", medico=" + medico + ", dataPrenotazione="
				+ dataPrenotazione + ", dataEsameEffettuato=" + dataEsameEffettuato +"]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipologiaDiEsame getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipologiaDiEsame tipologia) {
		this.tipologia = tipologia;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public Date getDataEsameEffettuato() {
		return dataEsameEffettuato;
	}

	public void setDataEsameEffettuato(Date dataEsameEffettuato) {
		this.dataEsameEffettuato = dataEsameEffettuato;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public Esame(Long id, Date dataPrenotazione, Date dataEsameEffettuato) {
		super();
		this.id = id;
		this.dataPrenotazione = dataPrenotazione;
		this.dataEsameEffettuato = dataEsameEffettuato;
	}


}
