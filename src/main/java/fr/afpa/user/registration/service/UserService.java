package fr.afpa.user.registration.service;

import fr.afpa.user.registration.model.Utilisateur;

public interface UserService {
	
	void save(Utilisateur user);
	
	Utilisateur findByUsername(String username);
	

}
