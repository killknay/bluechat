package fr.jondav.bluechat;

/**
 * @author David et Jonathan
 *
 * Represente l'en-tête de message de notre protocole. 
 * L'en-tête du protocole est de la forme : 
 *  DJB 1.00 \n
 *  From:sender|!|ethernet \n
 *  To:receiver|!|ethernet \n
 *  Request:req \n
 *  Content-Type:text\n
 *  
 * Pour plus d'informations voir Google Drive.
 */
public class DJ_EnTete {
	public static final int nombreLignes = 5;                 //< Le nombre de ligne de l'en-tête
	private static final String premiereLigne = "DJB 1.00";   //< Correspond à la première ligne du protocole
	private String envoyeur;                                  //< Le nom de celui qui envoie le message
	private String envoyeurEthernet;                          //< L'adresse ethernet de celui qui envoie le message
	private String recepteur;                                 //< Le nom du recepteur du message
	private String recepteurEthernet;                         //< L'adresse ethernet du recepteur du message
	private String requete;                                   //< La requete à envoyer (cf Google Drive)
	private String contentType;                               //< Le content-type de la suite du message

	/**
	 * Constructeur par défaut de la classe.
	 * Met toute les valeurs à "".
	 */
	public DJ_EnTete () {
		this ("", "", "", "", "", "");
	}
	
	/**
	 * Constucteur par paramètre de la classe.
	 * 
	 * @param envoyeur Le nom de celui qui envoie le message
	 * @param envoyeurEthernet L'adresse ethernet de celui qui envoie le message
	 * @param recepteur Le nom du recepteur du message
	 * @param recepteurEthernet Le nom du recepteur du message
	 * @param requete La requete à envoyer (cf Google Drive)
	 * @param contentType Le content-type de la suite du message
	 */
	public DJ_EnTete(String envoyeur, String envoyeurEthernet, String recepteur, String recepteurEthernet, String requete, String contentType) {
		this.envoyeur = envoyeur;
		this.envoyeurEthernet = envoyeurEthernet;
		this.recepteur = recepteur;
		this.recepteurEthernet = recepteurEthernet;
		this.requete = requete;
		this.contentType = contentType;
	}

	/**
	 * Permet de renvoyer l'objet sous forme de texte
	 * suivant le protocole définie sur Google Drive.
	 * 
	 * @return La chaine de caractère correspondant au corps de la requête, ou null si tout n'a pas été correctement définit.
	 */
	public String toProtocol() {
		if (envoyeur != null && envoyeurEthernet != null && recepteur != null && recepteurEthernet != null && requete != null && contentType != null) {
			String s = premiereLigne + 
				"\nFrom:" + envoyeur + "|!|" + envoyeurEthernet + 
				"\nTo:" + recepteur + "|!|" + recepteurEthernet + 
				"\nRequest:" + requete + 
				"\nContent-Type:" + contentType;
			return s;
		}
		else
			return null;
	}
	
	/**
	 * Permet à l'objet de s'afficher dans une chaine de 
	 * caractère.
	 * 
	 * @return Une chaine représentant l'objet.
	 */
	public String toString() {
		return toProtocol();
	}
	
	/**
	 * Permet de savoir si deux objet de la classe DJ_Corps
	 * correspondent au même objet.
	 * 
	 * @param c L'objet avec lequel on souhaite comparer l'objet.
	 * @return true si les objets sont les mêmes, false sinon.
	 */
	public boolean equals(DJ_Corps c) {
		return (toProtocol() == c.toProtocol());
	}
	
	/**
	 * Permet de créer un objet de cette classe depuis une trame.
	 * Remplis tous les champs de l'objet.
	 * 
	 * @param trame La trame (complete) a partir de laquelle vous souhaitez charger l'objet.
	 * @return L'objet créer si tout s'est bien passé, null sinon.
	 */
	public static DJ_EnTete chargerDepuisTrame (String trame) {
		DJ_EnTete e = new DJ_EnTete();
		
		if(trame == null)
			return null;
		
		String[] lignes = trame.split("\n"); // On split toutes les lignes
		
		if (!(lignes[0].equals(premiereLigne))) // On regarde si la premiere ligne correspond
			return null;
		
		//! Partie envoyeur
		String[] sender = lignes[1].split("From:");
		if (sender.length != 2) //< Si le split ne créé pas deux éléments s'est pas bon
			return null;
		
		String[] detailSender = sender[1].split("\\|!\\|");
		if (detailSender.length != 2) //< Si le split ne créé pas deux éléments s'est pas bon
			return null;
		e.setEnvoyeur(detailSender[0]);
		e.setEnvoyeurEthernet(detailSender[1]);
		
		//! Partie recepteur
		String[] receiver = lignes[2].split("To:");
		if (receiver.length != 2) //< Si le split ne créé pas deux éléments s'est pas bon
			return null;
		
		String[] detailReceiver = receiver[1].split("\\|!\\|");
		if (detailReceiver.length != 2) //< Si le split ne créé pas deux éléments s'est pas bon
			return null;
		e.setRecepteur(detailReceiver[0]);
		e.setRecepteurEthernet(detailReceiver[1]);
		
		//! Partie requête
		String[] requete = lignes[3].split("Request:");
		if (receiver.length != 2) //< Si le split ne créé pas deux éléments s'est pas bon
			return null;
		e.setRequete(requete[1]);
		
		//! Partie content-type
		String[] content = lignes[4].split("Content-Type:");
		if (receiver.length != 2) //< Si le split ne créé pas deux éléments s'est pas bon
			return null;
		e.setContentType(content[1]);
		
		return e;
	}
	
	/**
	 * Permet de récupérer le nom de l'envoyer du message.
	 * 
	 * @return Le nom de l'envoyeur du message.
	 */
	public String getEnvoyeur() {
		return envoyeur;
	}
	
	/**
	 * Permet de définir le nom de l'envoyeur du message.
	 * 
	 * @param envoyeur La valeur que souhaitez définir pour l'envoyeur
	 */
	public void setEnvoyeur(String envoyeur) {
		if (envoyeur != null)
			this.envoyeur = envoyeur;
	}
	
	/**
	 * Permet de récupérer l'adresse ethernet de l'envoyeur.
	 * 
	 * @return L'adresse ethernet de l'envoyeur.
	 */
	public String getEnvoyeurEthernet() {
		return envoyeurEthernet;
	}
	
	/**
	 * Permet de définir l'addresse ethernet de l'envoyeur.
	 * 
	 * @param envoyeurEthernet La valeur que souhaitez définir pour l'addresse ethernet de l'envoyeur
	 */
	public void setEnvoyeurEthernet(String envoyeurEthernet) {
		if (envoyeur != null)
			this.envoyeurEthernet = envoyeurEthernet;
	}
	
	/**
	 * Permet de récupérer le nom du recepteur du message.
	 * 
	 * @return Le nom du recepteur du message.
	 */
	public String getRecepteur() {
		return recepteur;
	}
	
	/**
	 * Permet de définir le nom du recepteur du message.
	 * 
	 * @param recepteur La valeur que vous voulez donner au nom du recepteur.
	 */
	public void setRecepteur(String recepteur) {
		if (envoyeur != null)
			this.recepteur = recepteur;
	}
	
	/**
	 * Permet de récupérer l'adresse ethernet du recepteur du message.
	 * 
	 * @return L'adresse ethernet du recepteur du message.
	 */
	public String getRecepteurEthernet() {
		return recepteurEthernet;
	}
	
	/**
	 * Permet de définir l'adresse ethernet du recepteur du message.
	 * 
	 * @param recepteurEthernet L'adresse ethernet à définir.
	 */
	public void setRecepteurEthernet(String recepteurEthernet) {
		if (envoyeur != null)
			this.recepteurEthernet = recepteurEthernet;
	}
	
	/**
	 * Permet de récupérer la requête du message.
	 * 
	 * @return La requête du message.
	 */
	public String getRequete() {
		return requete;
	}
	
	/**
	 * Permet de définir la requête de l'en-tête (cf Google Drive).
	 * 
	 * @param requete La valeur de la requête que vous souhaitez définir.
	 */
	public void setRequete(String requete) {
		if (envoyeur != null)
			this.requete = requete;
	}
	
	/**
	 * Permet de récupérer le content-type du message.
	 * 
	 * @return Le content-type du message.
	 */
	public String getContentType() {
		return contentType;
	}
	
	/**
	 * Permet de définir le content-type du message.
	 * 
	 * @param contentType Le content-type que vous souhaitez utiliser.
	 */
	public void setContentType(String contentType) {
		if (envoyeur != null)
			this.contentType = contentType;
	}
	
	/**
	 * Permet de récupérer la première ligne du protocole.
	 * 
	 * @return La première ligne du protocole.
	 */
	public String getPremiereLigne() {
		return premiereLigne;
	}
}
