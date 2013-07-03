package fr.jondav.bluechat;

/**
 * @author David et Jonathan
 * 
 * Classe servant d'interface obligatoire à tous les objets
 * se voulant des objets de corps de message.
 * Les objets implémentant cette classe sont des objets 
 * qui correspondent à un corps de requete pour notre protocole
 * Bluetooth.
 */
public interface DJ_Corps {
	/**
	 * Permet de renvoyer l'objet sous forme de texte
	 * suivant le protocole définie sur Google Drive.
	 * 
	 * @return La chaine de caractère correspondant au corps de la requête
	 */
	public String toProtocol();
	
	/**
	 * Permet à l'objet de s'afficher dans une chaine de 
	 * caractère.
	 * 
	 * @return Une chaine représentant l'objet.
	 */
	public String toString();
	
	/**
	 * Permet de savoir si deux objet de la classe DJ_Corps
	 * correspondent au même objet.
	 * 
	 * @param c L'objet avec lequel on souhaite comparer l'objet.
	 * @return True si les objets sont les mêmes, false sinon.
	 */
	public boolean equals(DJ_Corps c);
	
	/**
	 * Permet de récupère le type du corps (image, texte, etc.).
	 * Cette information est nécessaire dans le header de requête bluetooth.
	 * 
	 * @return Le type du corps, à inscrire dans l'en-tête de requête.
	 */
	public String getContentType();
}
