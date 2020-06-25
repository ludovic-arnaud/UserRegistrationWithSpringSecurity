package fr.afpa.user.registration.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@NamedQuery(name="Activite.findAll", query="SELECT a FROM Activite a")
public class Activite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idactivite")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idActivite;
	
	@Column(length = 50, unique = true, nullable = false)
	private String nom;
	
	@Column(length = 200, nullable = true)
	private String description;
	
	@Column(name="descriptiondetaillee", length = 500, nullable = true)
	private String descriptionDetaillee;
	
	@Column(length = 3, nullable = true)
	private Long duree;
	
	@Column(length = 1, nullable = true)
	private Integer obligation;
	
	
	@ManyToOne
	@JoinColumn(name="idtype")
	private Type type;
	

	@ManyToOne
	@JoinColumn(name="idtheme")
	private Theme theme;
	
	
	@ManyToMany
	@JoinTable(
		name="animer"
		, joinColumns={
			@JoinColumn(name="idactivite")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idutilisateur")
			}
		)
	private List<Animateur> animateurs = new ArrayList<>();
	
	
	@OneToMany(mappedBy ="activite")
	private List<Creneau> creneaux ;
	
	
	@ManyToMany
	@JoinTable(
		name="referencer"
		, joinColumns={
			@JoinColumn(name="idactivite")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idcentre")
			}
		)
	private List<Centre> centres;
	

	public Activite() {
		super();
	}

	public Activite(String nom, String description, String descriptionDetaillee, Long duree, Integer obligation) {
		super();
		this.nom = nom;
		this.description = description;
		this.descriptionDetaillee = descriptionDetaillee;
		this.duree = duree;
		this.obligation = obligation;
	}
	

}
