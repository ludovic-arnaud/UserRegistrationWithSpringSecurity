package fr.afpa.user.registration.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Session.findAll", query = "SELECT u FROM Session u")
public class Session implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idsession")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSession;

	@Column(length = 50, unique = true, nullable = false)
	private String nom;

	@Column(name="datedebut", nullable = false)
	private LocalDate dateDebut;

	@Column(name="datefin", nullable = false)
	private LocalDate dateFin;

	@Column(name="datedebutpae", nullable = true)
	private LocalDate dateDebutPae;

	@Column(name="datefinpae", nullable = true)
	private LocalDate dateFinPae;

	@Column(name="datecertification", nullable = true)
	private LocalDate dateCertification;

	@Column(name="nomsessionaveccentre", length = 50, unique = true, nullable = false)
	private String nomSessionAvecCentre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idformation")
	private Formation formation;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcentre")
	private Centre centre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idutilisateur")
	private LGM lgm;

	@OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
	private List<Collaborateur> collaborateurs;

	@ManyToMany
	@JoinTable(name = "enseigner", joinColumns = { @JoinColumn(name = "idutilisateur") }, inverseJoinColumns = {
			@JoinColumn(name = "idsession") })
	private List<LGM> lgms;

	public Session() {
		super();
	}

	public Session(String nom, LocalDate dateDebut, LocalDate dateFin, LocalDate dateDebutPae, LocalDate dateFinPae,
			LocalDate dateCertification, String nomSessionAvecCentre) {
		super();
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateDebutPae = dateDebutPae;
		this.dateFinPae = dateFinPae;
		this.dateCertification = dateCertification;
		this.nomSessionAvecCentre = nomSessionAvecCentre;
	}

	public Session(String nom, LocalDate dateDebut, LocalDate dateFin, LocalDate dateDebutPae, LocalDate dateFinPae,
			LocalDate dateCertification, String nomSessionAvecCentre, Formation formation, Centre centre, LGM lgm,
			List<Collaborateur> collaborateurs, List<LGM> lgms) {
		super();
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateDebutPae = dateDebutPae;
		this.dateFinPae = dateFinPae;
		this.dateCertification = dateCertification;
		this.nomSessionAvecCentre = nomSessionAvecCentre;
		this.formation = formation;
		this.centre = centre;
		this.lgm = lgm;
		this.collaborateurs = collaborateurs;
		this.lgms = lgms;
	}

	public Session(String nom, LocalDate dateDebut, LocalDate dateFin, LocalDate dateDebutPae, LocalDate dateFinPae,
			LocalDate dateCertification, String nomSessionAvecCentre, Formation formation, Centre centre, LGM lgm) {
		super();
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateDebutPae = dateDebutPae;
		this.dateFinPae = dateFinPae;
		this.dateCertification = dateCertification;
		this.nomSessionAvecCentre = nomSessionAvecCentre;
		this.formation = formation;
		this.centre = centre;
		this.lgm = lgm;
	}

	public Integer getIdSession() {
		return idSession;
	}

	public void setIdSession(Integer idSession) {
		this.idSession = idSession;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public LocalDate getDateDebutPae() {
		return dateDebutPae;
	}

	public void setDateDebutPae(LocalDate dateDebutPae) {
		this.dateDebutPae = dateDebutPae;
	}

	public LocalDate getDateFinPae() {
		return dateFinPae;
	}

	public void setDateFinPae(LocalDate dateFinPae) {
		this.dateFinPae = dateFinPae;
	}

	public LocalDate getDateCertification() {
		return dateCertification;
	}

	public void setDateCertification(LocalDate dateCertification) {
		this.dateCertification = dateCertification;
	}

	public String getNomSessionAvecCentre() {
		return nomSessionAvecCentre;
	}

	public void setNomSessionAvecCentre(String nomSessionAvecCentre) {
		this.nomSessionAvecCentre = nomSessionAvecCentre;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	public LGM getLgm() {
		return lgm;
	}

	public void setLgm(LGM lgm) {
		this.lgm = lgm;
	}

	public List<Collaborateur> getCollaborateurs() {
		if (this.collaborateurs == null) {
			this.collaborateurs = new ArrayList<Collaborateur>();
		}
		return this.collaborateurs;
	}

	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public List<LGM> getLgms() {
		if (this.lgms == null) {
			this.lgms = new ArrayList<LGM>();
		}
		return lgms;
	}

	public void setLgms(List<LGM> lgms) {
		this.lgms = lgms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centre == null) ? 0 : centre.hashCode());
		result = prime * result + ((collaborateurs == null) ? 0 : collaborateurs.hashCode());
		result = prime * result + ((dateCertification == null) ? 0 : dateCertification.hashCode());
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateDebutPae == null) ? 0 : dateDebutPae.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((dateFinPae == null) ? 0 : dateFinPae.hashCode());
		result = prime * result + ((formation == null) ? 0 : formation.hashCode());
		result = prime * result + ((idSession == null) ? 0 : idSession.hashCode());
		result = prime * result + ((lgm == null) ? 0 : lgm.hashCode());
		result = prime * result + ((lgms == null) ? 0 : lgms.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((nomSessionAvecCentre == null) ? 0 : nomSessionAvecCentre.hashCode());
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
		Session other = (Session) obj;
		if (centre == null) {
			if (other.centre != null)
				return false;
		} else if (!centre.equals(other.centre))
			return false;
		if (collaborateurs == null) {
			if (other.collaborateurs != null)
				return false;
		} else if (!collaborateurs.equals(other.collaborateurs))
			return false;
		if (dateCertification == null) {
			if (other.dateCertification != null)
				return false;
		} else if (!dateCertification.equals(other.dateCertification))
			return false;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateDebutPae == null) {
			if (other.dateDebutPae != null)
				return false;
		} else if (!dateDebutPae.equals(other.dateDebutPae))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (dateFinPae == null) {
			if (other.dateFinPae != null)
				return false;
		} else if (!dateFinPae.equals(other.dateFinPae))
			return false;
		if (formation == null) {
			if (other.formation != null)
				return false;
		} else if (!formation.equals(other.formation))
			return false;
		if (idSession == null) {
			if (other.idSession != null)
				return false;
		} else if (!idSession.equals(other.idSession))
			return false;
		if (lgm == null) {
			if (other.lgm != null)
				return false;
		} else if (!lgm.equals(other.lgm))
			return false;
		if (lgms == null) {
			if (other.lgms != null)
				return false;
		} else if (!lgms.equals(other.lgms))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (nomSessionAvecCentre == null) {
			if (other.nomSessionAvecCentre != null)
				return false;
		} else if (!nomSessionAvecCentre.equals(other.nomSessionAvecCentre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Session [idSession=" + idSession + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", dateDebutPae=" + dateDebutPae + ", dateFinPae=" + dateFinPae + ", dateCertification="
				+ dateCertification + ", nomSessionAvecCentre=" + nomSessionAvecCentre + ", formation=" + formation
				+ ", centre=" + centre + ", lgm=" + lgm + "]";
	}

}
