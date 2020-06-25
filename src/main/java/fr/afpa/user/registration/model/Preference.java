package fr.afpa.user.registration.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Preference.findAll", query = "SELECT p FROM Preference p")
public class Preference implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idpreference")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPreference;

	@Column(length = 20, unique = true, nullable = false)
	private String code;

	@Column(length = 10, nullable = true)
	private Integer valeur;

	@ManyToMany
	@JoinTable(name = "choisir", joinColumns = { @JoinColumn(name = "idpreference") }, inverseJoinColumns = {
			@JoinColumn(name = "idutilisateur") })
	private List<Utilisateur> utilisateurs;

	public Preference() {
		super();
	}

	public Integer getIdPreference() {
		return idPreference;
	}

	public void setIdPreference(Integer idPreference) {
		this.idPreference = idPreference;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getValeur() {
		return valeur;
	}

	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Preference(String code, Integer valeur, List<Utilisateur> utilisateurs) {
		super();
		this.code = code;
		this.valeur = valeur;
		this.utilisateurs = utilisateurs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((idPreference == null) ? 0 : idPreference.hashCode());
		result = prime * result + ((utilisateurs == null) ? 0 : utilisateurs.hashCode());
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
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
		Preference other = (Preference) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (idPreference == null) {
			if (other.idPreference != null)
				return false;
		} else if (!idPreference.equals(other.idPreference))
			return false;
		if (utilisateurs == null) {
			if (other.utilisateurs != null)
				return false;
		} else if (!utilisateurs.equals(other.utilisateurs))
			return false;
		if (valeur == null) {
			if (other.valeur != null)
				return false;
		} else if (!valeur.equals(other.valeur))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Preference [idPreference=" + idPreference + ", code=" + code + ", valeur=" + valeur + ", ]";
	}

}
