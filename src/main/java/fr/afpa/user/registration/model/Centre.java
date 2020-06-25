package fr.afpa.user.registration.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the centre database table.
 * 
 */
@Entity
@NamedQuery(name = "Centre.findAll", query = "SELECT c FROM Centre c")
public class Centre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idcentre")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcentre;

	@Column(length = 150, nullable = true)
	private String adresse;

	@Column(length = 50, unique = true, nullable = false)
	private String nom;

	@Column(length = 10, nullable = true)
	private Integer telephone;

	// bi-directional many-to-many association to Activite
	@ManyToMany(mappedBy = "centres")
	private List<Activite> activites;

	// bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy = "centre")
	private List<Utilisateur> utilisateurs;

	// bi-directional many-to-one association to Session
	@OneToMany(mappedBy = "centre")
	private List<Session> sessions;

	// bi-directional many-to-one association to Lieu
	@OneToMany(mappedBy = "centre")
	private List<Lieu> lieux;

	// bi-directional many-to-one association to Creneau
	@OneToMany(mappedBy = "centre")
	private List<Creneau> creneaux;

	public Centre() {
	}

	public Centre(String adresse, String nom, Integer telephone) {
		super();
		this.adresse = adresse;
		this.nom = nom;
		this.telephone = telephone;
	}

	public Centre(String adresse, String nom, Integer telephone, List<Activite> activites,
			List<Utilisateur> utilisateurs, List<Session> sessions, List<Lieu> lieux, List<Creneau> creneaux) {
		super();
		this.adresse = adresse;
		this.nom = nom;
		this.telephone = telephone;
		this.activites = activites;
		this.utilisateurs = utilisateurs;
		this.sessions = sessions;
		this.lieux = lieux;
		this.creneaux = creneaux;
	}

	public Integer getIdcentre() {
		return idcentre;
	}

	public void setIdcentre(Integer idcentre) {
		this.idcentre = idcentre;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public List<Activite> getActivites() {
		return activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public List<Lieu> getLieux() {
		return lieux;
	}

	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}

	public List<Creneau> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(List<Creneau> creneaux) {
		this.creneaux = creneaux;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setCentre(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setCentre(null);
		return utilisateur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activites == null) ? 0 : activites.hashCode());
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((creneaux == null) ? 0 : creneaux.hashCode());
		result = prime * result + ((idcentre == null) ? 0 : idcentre.hashCode());
		result = prime * result + ((lieux == null) ? 0 : lieux.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((sessions == null) ? 0 : sessions.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((utilisateurs == null) ? 0 : utilisateurs.hashCode());
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
		Centre other = (Centre) obj;
		if (activites == null) {
			if (other.activites != null)
				return false;
		} else if (!activites.equals(other.activites))
			return false;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (creneaux == null) {
			if (other.creneaux != null)
				return false;
		} else if (!creneaux.equals(other.creneaux))
			return false;
		if (idcentre == null) {
			if (other.idcentre != null)
				return false;
		} else if (!idcentre.equals(other.idcentre))
			return false;
		if (lieux == null) {
			if (other.lieux != null)
				return false;
		} else if (!lieux.equals(other.lieux))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (sessions == null) {
			if (other.sessions != null)
				return false;
		} else if (!sessions.equals(other.sessions))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (utilisateurs == null) {
			if (other.utilisateurs != null)
				return false;
		} else if (!utilisateurs.equals(other.utilisateurs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Centre [idcentre=" + idcentre + ", adresse=" + adresse + ", nom=" + nom + ", telephone=" + telephone
				+ ", ]";
	}

}