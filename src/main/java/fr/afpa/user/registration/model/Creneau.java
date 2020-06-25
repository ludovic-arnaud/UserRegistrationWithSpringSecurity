package fr.afpa.user.registration.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Creneau.findAll", query = "SELECT c FROM Creneau c")
public class Creneau implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idcreneau")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcreneau;

	@Column(name="datetimedebut")
	private LocalDateTime dateTimeDebut;

	@Column(name="datetimefin")
	private LocalDateTime dateTimeFin;

	@Column(name="delaimini", length = 2, nullable = true)
	private Integer delaiMini;

	@Column(name="participantsmini", length = 3, nullable = true)
	private Integer participantsMini;

	@Column(name="participantsmaxi", length = 3, nullable = true)
	private Integer participantsMaxi;

	@Column(name="zonelibre", length = 500, nullable = true)
	private String zoneLibre;

	@Column(name="nomactivitedatecentre", length = 30, unique = true, nullable = true)
	private String NomActiviteDateCentre;

	// bi-directional many-to-one association to Centre
	@ManyToOne
	@JoinColumn(name = "idcentre")
	private Centre centre;

	// bi-directional many-to-one association to Lieu
	@ManyToOne
	@JoinColumn(name = "idlieu")
	private Lieu lieu;

	// bi-directional many-to-one association to Activite
	@ManyToOne
	@JoinColumn(name = "idactivite")
	private Activite activite;

	// bi-directional many-to-one association to Animateur
	@ManyToOne
	@JoinColumn(name = "idutilisateur")
	private Animateur animateur;

	// bi-directional one-to-many association to Inscription
	@OneToMany(mappedBy = "creneau")
	private List<Inscription> inscriptions;

	public Creneau() {
		super();
	}

	public Creneau(LocalDateTime dateTimeDebut, LocalDateTime dateTimeFin, Integer delaiMini, Integer participantsMini,
			Integer participantsMaxi, String zoneLibre, String nomActiviteDateCentre) {
		super();
		this.dateTimeDebut = dateTimeDebut;
		this.dateTimeFin = dateTimeFin;
		this.delaiMini = delaiMini;
		this.participantsMini = participantsMini;
		this.participantsMaxi = participantsMaxi;
		this.zoneLibre = zoneLibre;
		NomActiviteDateCentre = nomActiviteDateCentre;
	}

	public Creneau(LocalDateTime dateTimeDebut, LocalDateTime dateTimeFin, Integer delaiMini, Integer participantsMini,
			Integer participantsMaxi, String zoneLibre, String nomActiviteDateCentre, Centre centre, Lieu lieu,
			Activite activite, Animateur animateur, List<Inscription> inscriptions) {
		super();
		this.dateTimeDebut = dateTimeDebut;
		this.dateTimeFin = dateTimeFin;
		this.delaiMini = delaiMini;
		this.participantsMini = participantsMini;
		this.participantsMaxi = participantsMaxi;
		this.zoneLibre = zoneLibre;
		NomActiviteDateCentre = nomActiviteDateCentre;
		this.centre = centre;
		this.lieu = lieu;
		this.activite = activite;
		this.animateur = animateur;
		this.inscriptions = inscriptions;
	}

	public Integer getIdcreneau() {
		return idcreneau;
	}

	public void setIdcreneau(Integer idcreneau) {
		this.idcreneau = idcreneau;
	}

	public LocalDateTime getDateTimeDebut() {
		return dateTimeDebut;
	}

	public void setDateTimeDebut(LocalDateTime dateTimeDebut) {
		this.dateTimeDebut = dateTimeDebut;
	}

	public LocalDateTime getDateTimeFin() {
		return dateTimeFin;
	}

	public void setDateTimeFin(LocalDateTime dateTimeFin) {
		this.dateTimeFin = dateTimeFin;
	}

	public Integer getDelaiMini() {
		return delaiMini;
	}

	public void setDelaiMini(Integer delaiMini) {
		this.delaiMini = delaiMini;
	}

	public Integer getParticipantsMini() {
		return participantsMini;
	}

	public void setParticipantsMini(Integer participantsMini) {
		this.participantsMini = participantsMini;
	}

	public Integer getParticipantsMaxi() {
		return participantsMaxi;
	}

	public void setParticipantsMaxi(Integer participantsMaxi) {
		this.participantsMaxi = participantsMaxi;
	}

	public String getZoneLibre() {
		return zoneLibre;
	}

	public void setZoneLibre(String zoneLibre) {
		this.zoneLibre = zoneLibre;
	}

	public String getNomActiviteDateCentre() {
		return NomActiviteDateCentre;
	}

	public void setNomActiviteDateCentre(String nomActiviteDateCentre) {
		NomActiviteDateCentre = nomActiviteDateCentre;
	}

	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public Animateur getAnimateur() {
		return animateur;
	}

	public void setAnimateur(Animateur animateur) {
		this.animateur = animateur;
	}

	public List<Inscription> getInscriptions() {
		if (this.inscriptions == null) {
			this.inscriptions = new ArrayList<Inscription>();
		}
		return this.inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NomActiviteDateCentre == null) ? 0 : NomActiviteDateCentre.hashCode());
		result = prime * result + ((activite == null) ? 0 : activite.hashCode());
		result = prime * result + ((animateur == null) ? 0 : animateur.hashCode());
		result = prime * result + ((centre == null) ? 0 : centre.hashCode());
		result = prime * result + ((dateTimeDebut == null) ? 0 : dateTimeDebut.hashCode());
		result = prime * result + ((dateTimeFin == null) ? 0 : dateTimeFin.hashCode());
		result = prime * result + ((delaiMini == null) ? 0 : delaiMini.hashCode());
		result = prime * result + ((idcreneau == null) ? 0 : idcreneau.hashCode());
		result = prime * result + ((inscriptions == null) ? 0 : inscriptions.hashCode());
		result = prime * result + ((lieu == null) ? 0 : lieu.hashCode());
		result = prime * result + ((participantsMaxi == null) ? 0 : participantsMaxi.hashCode());
		result = prime * result + ((participantsMini == null) ? 0 : participantsMini.hashCode());
		result = prime * result + ((zoneLibre == null) ? 0 : zoneLibre.hashCode());
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
		Creneau other = (Creneau) obj;
		if (NomActiviteDateCentre == null) {
			if (other.NomActiviteDateCentre != null)
				return false;
		} else if (!NomActiviteDateCentre.equals(other.NomActiviteDateCentre))
			return false;
		if (activite == null) {
			if (other.activite != null)
				return false;
		} else if (!activite.equals(other.activite))
			return false;
		if (animateur == null) {
			if (other.animateur != null)
				return false;
		} else if (!animateur.equals(other.animateur))
			return false;
		if (centre == null) {
			if (other.centre != null)
				return false;
		} else if (!centre.equals(other.centre))
			return false;
		if (dateTimeDebut == null) {
			if (other.dateTimeDebut != null)
				return false;
		} else if (!dateTimeDebut.equals(other.dateTimeDebut))
			return false;
		if (dateTimeFin == null) {
			if (other.dateTimeFin != null)
				return false;
		} else if (!dateTimeFin.equals(other.dateTimeFin))
			return false;
		if (delaiMini == null) {
			if (other.delaiMini != null)
				return false;
		} else if (!delaiMini.equals(other.delaiMini))
			return false;
		if (idcreneau == null) {
			if (other.idcreneau != null)
				return false;
		} else if (!idcreneau.equals(other.idcreneau))
			return false;
		if (inscriptions == null) {
			if (other.inscriptions != null)
				return false;
		} else if (!inscriptions.equals(other.inscriptions))
			return false;
		if (lieu == null) {
			if (other.lieu != null)
				return false;
		} else if (!lieu.equals(other.lieu))
			return false;
		if (participantsMaxi == null) {
			if (other.participantsMaxi != null)
				return false;
		} else if (!participantsMaxi.equals(other.participantsMaxi))
			return false;
		if (participantsMini == null) {
			if (other.participantsMini != null)
				return false;
		} else if (!participantsMini.equals(other.participantsMini))
			return false;
		if (zoneLibre == null) {
			if (other.zoneLibre != null)
				return false;
		} else if (!zoneLibre.equals(other.zoneLibre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Creneau [idcreneau=" + idcreneau + ", dateTimeDebut=" + dateTimeDebut + ", dateTimeFin=" + dateTimeFin
				+ ", delaiMini=" + delaiMini + ", participantsMini=" + participantsMini + ", participantsMaxi="
				+ participantsMaxi + ", zoneLibre=" + zoneLibre + ", NomActiviteDateCentre=" + NomActiviteDateCentre
				+ ", centre=" + centre + ", lieu=" + lieu + ", activite=" + activite + ", animateur=" + animateur
				+ ", inscriptions=" + inscriptions + "]";
	}

}
