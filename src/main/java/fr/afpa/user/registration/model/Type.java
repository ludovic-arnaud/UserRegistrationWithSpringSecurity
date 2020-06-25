package fr.afpa.user.registration.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Type.findAll", query = "SELECT t FROM Type t")
public class Type implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtype")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtype;

	@Column(length = 10, unique = true, nullable = false)
	private String code;

	@Column(length = 500, nullable = true)
	private String description;

	@OneToMany(mappedBy = "type")
	private List<Activite> activite;

	public Type() {
		super();
	}

	public Type(String code, String description, List<Activite> activite) {
		super();
		this.code = code;
		this.description = description;
		this.activite = activite;
	}

	public Integer getIdtype() {
		return idtype;
	}

	public void setIdtype(Integer idtype) {
		this.idtype = idtype;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Activite> getactivite() {
		return activite;
	}

	public void setactivite(List<Activite> activite) {
		this.activite = activite;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activite == null) ? 0 : activite.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idtype == null) ? 0 : idtype.hashCode());
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
		Type other = (Type) obj;
		if (activite == null) {
			if (other.activite != null)
				return false;
		} else if (!activite.equals(other.activite))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idtype == null) {
			if (other.idtype != null)
				return false;
		} else if (!idtype.equals(other.idtype))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Type [idtype=" + idtype + ", code=" + code + ", description=" + description + ", activite=" + activite
				+ "]";
	}

}
