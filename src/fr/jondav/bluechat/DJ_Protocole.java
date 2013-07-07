package fr.jondav.bluechat;

/**
 * @author knay
 * 
 * Permet de traduire un message respectant le protocole en
 * trame envoyable par le bluetooth.
 */
public interface DJ_Protocole {
	/**
	 * Permet de renvoyer l'objet sous forme de texte
	 * suivant le protocole définie sur Google Drive.
	 * 
	 * @return La chaine de caractère correspondant au corps de la requête, ou null si tout n'a pas été correctement définit.
	 */
	public String toProtocol();
	
	/**
	 * Permet de récupérer le nom de l'envoyeur du message.
	 * 
	 * @return Le nom de l'envoyeur du message.
	 */
	public String getEnvoyeur();
	
	/**
	 * Permet de récupérer le nom du recepteur du message.
	 * 
	 * @return Le nom du récepteur du message.
	 */
	public String getRecepteur();
}
