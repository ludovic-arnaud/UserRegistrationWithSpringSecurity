package fr.afpa.user.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.user.registration.model.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Integer> {

	public Utilisateur findByUsername(String username);

	public Utilisateur findByUsernameAndPassword(String username, String password);

}
