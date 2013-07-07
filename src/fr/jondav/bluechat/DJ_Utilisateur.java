package fr.jondav.bluechat;

/**
 * @author Jonathan & David
 *
 * Classe représentant un utilisateur de l'application.
 * Contient son nom, son prénom et son age.
 * 
 * Peut être utiliser pour représenter les contacts d'un utilisateur 
 * ou bien la personne avec qui on parle.
 */
public class DJ_Utilisateur {
	public String nom;                //< Le nom de l'utilisateur
	public String prenom;             //< Le prénom de l'utilisateur
	public int age;                   //< L'age de l'utilisateur
	//public String lienPhoto ???????
	
	/**
	 * Constructeur par paramètre de la classe.
	 * 
	 * @param nom Le nom que vous souhaitez donner.
	 * @param prenom Le prenom que vous souhaitez donner.
	 * @param age L'age que vous voulez donner.
	 */
	public DJ_Utilisateur(String nom, String prenom, int age) {
		if (nom != null)
			this.nom = nom;
		else
			this.nom = "";
		
		if (prenom != null)
			this.prenom = prenom;
		else
			this.prenom = "";
		
		if (age < 0)
			this.age = 0;
		else
			this.age = age;
	}
	
	/**
	 * Constructeur par défaut de la classe.
	 * Remplis à vide tous les champs.
	 */
	public DJ_Utilisateur() {
		this(null, null, 0);
	}
	
	/**
	 * Permet de définir le nom de l'utilisateur.
	 * 
	 * @param nom Le nom que vous souhaitez définir.
	 */
	public void setNom(String nom) {
		if (nom != null)
			this.nom = nom;
	}
	
	/**
	 * Permet de définir le nom de l'utilisateur.
	 * 
	 * @param prenom Le prenom que vous souhaitez définir.
	 */
	public void setPrenom(String prenom) {
		if (prenom != null)
			this.prenom = prenom;
	}
	
	/**
	 * Permet de définir le nom de l'utilisateur.
	 * 
	 * @param age L'age que vous souhaitez définir.
	 */
	public void setAge(int age) {
		if (age >= 0)
			this.age = age;
	}
	
	/**
	 * Permet de récupérer le nom de l'utilisateur.
	 * 
	 * @return Le nom de l'utilisateur.
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Permet de récupérer le prénom de l'utilisateur.
	 * 
	 * @return Le prénom de l'utilisateur.
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Permet de récupérer l'age de l'utilisateur.
	 * 
	 * @return L'age de l'utilisateur.
	 */
	public int getAge() {
		return age;
	}
}
