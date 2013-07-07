package fr.jondav.bluechat;

/**
 * @author David et Jonathan
 *
 * Represente un message de notre protocole. 
 * Le message contient un en-tête et un corps.
 * L'en-tête du protocole est de la forme : 
 *  DJB 1.00 \n
 *  From:sender|!|ethernet \n
 *  To:receiver|!|ethernet \n
 *  Request:req \n
 *  Content-Type:text\n
 * Le corps du message quant à lui est de format 
 * variable, il dépend du type de message.
 *  
 * Pour plus d'informations voir Google Drive.
 */
public class DJ_Message implements DJ_Protocole {
	public static final String CONNECT = "connect";                 //< Message de demande de connexion
	public static final String CONNECT_REP = "connect-rep";         //< Message de reponse de connexion
	public static final String CHECKONLINE = "checkonline";         //< Message de vérification si personne est en ligne
	public static final String CHECKONLINE_REP = "checkonline-rep"; //< Message de réponse pour vérification en ligne
	public static final String MESSAGE = "message";                 //< Message determinant un vrai message
	
	private DJ_EnTete enTete;   //< L'en-tête du message
	private DJ_Corps corps;     //< Le corps du message

	/**
	 * Permet de créer un message directement avec un en-tête et un corps.
	 * 
	 * @param enTete L'en-tête du message.
	 * @param corps Le corps du message.
	 */
	public DJ_Message (DJ_EnTete enTete, DJ_Corps corps) {
		if (enTete != null)
			this.enTete = enTete;
		else
			this.enTete = new DJ_EnTete();
		
		if (corps != null)
			this.corps = corps;
		else 
			this.corps = new DJ_Corps_Texte();
		
		this.enTete.setContentType(this.corps.getContentType());
	}
	
	/**
	 * Constructeur par défaut de la classe.
	 * Créé un message avec un en-tête vide et un corps
	 * de type texte.
	 */
	public DJ_Message () {
		this (null, null);
	}
	
	/**
	 * Permet de renvoyer l'objet sous forme de texte
	 * suivant le protocole définie sur Google Drive.
	 * 
	 * @return La chaine de caractère correspondant au corps de la requête, ou null si tout n'a pas été correctement définit.
	 */
	public String toProtocol () {
		if (enTete == null || corps == null)
			return null;
		
		return (enTete.toProtocol() + "\n" + corps.toProtocol());
	}
	
	/**
	 * Permet à l'objet de s'afficher dans une chaine de 
	 * caractère.
	 * 
	 * @return Une chaine représentant l'objet.
	 */
	public String toString () {
		if (enTete == null || corps == null)
			return null;
		
		return "Message :" + enTete.toString() + "\n" + corps.toString();
	}
	
	/**
	 * Permet de définir le recepteur du message, en lui fournissant le nom
	 * et son adresse ethernet.
	 * 
	 * @param nom Le nom de l'envoyeur.
	 * @param adresse L'adresse ethernet de l'envoyeur.
	 */
	public void setRecepteur (String nom, String adresse) {
		setRecepteur (nom);
		setAdresseRecepteur(adresse);
	}
	
	/**
	 * Permet de définir le nom du recepteur.
	 * 
	 * @param nom Le nom de l'envoyeur.
	 */
	public void setRecepteur (String nom) {
		if (nom != null)
			enTete.setEnvoyeur(nom);
	}
	
	/**
	 * Permet de définir l'adresse ethernet du recepteur du message.
	 * 
	 * @param adresse L'adresse du recepteur.
	 */
	public void setAdresseRecepteur (String adresse) {
		if (adresse != null)
			enTete.setRecepteurEthernet(adresse);
	}
	
	/**
	 * Permet de définir l'envoyeur du message, en lui fournissant le nom
	 * et son adresse ethernet.
	 * 
	 * @param nom Le nom de l'envoyeur.
	 * @param adresse L'adresse ethernet de l'envoyeur.
	 */
	public void setEnvoyeur (String nom, String adresse) {
		setEnvoyeur (nom);
		setAdresseEnvoyeur(adresse);
	}
	
	/**
	 * Permet de définir le nom de l'envoyeur.
	 * 
	 * @param nom Le nom de l'envoyeur.
	 */
	public void setEnvoyeur (String nom) {
		if (nom != null)
			enTete.setEnvoyeur(nom);
	}
	
	/**
	 * Permet de définir l'adresse ethernet de l'envoyeur du message.
	 * 
	 * @param adresse L'adresse de l'envoyeur.
	 */
	public void setAdresseEnvoyeur (String adresse) {
		if (adresse != null)
			enTete.setEnvoyeurEthernet(adresse);
	}
	
	/**
	 * Permet de définir le corps du message. 
	 * Définie automatiquement le content-type du message
	 * (pour éviter les erreurs).
	 * 
	 * @param corps Le corps que vous souhaitez donner au message.
	 */
	public void setCorps (DJ_Corps corps) {
		if (corps != null) {
			this.corps = corps;
			enTete.setContentType(this.corps.getContentType());
		}
	}
	
	/**
	 * Permet de définir le type de message. 
	 * Utiliser les variables : 
	 * DJ_Message.CONNECT, DJ_Message.CONNECT_REP, 
	 * DJ_Message.CHECKONLINE, DJ_Message.CHECKONLINE_REP, 
	 * DJ_Message.MESSAGE, sinon DJ_Message sera définie.
	 * 
	 * @param req La requête que vous souhaitez effectuer.
	 */
	public void setRequete (String req) {
		if (req != null && (req.equals(CONNECT) || 
				            req.equals(CONNECT_REP) || 
				            req.equals(CHECKONLINE) || 
				            req.equals(CHECKONLINE_REP)))
			enTete.setRequete(req);
		else
			enTete.setRequete(MESSAGE);
	}
	
	/**
	 * Permet de récupérer le corps du message.
	 * 
	 * @return Le corps du message.
	 */
	public DJ_Corps getCorps () {
		return corps;
	}
	
	/**
	 * Permet de récupérer l'en-tête du message.
	 * 
	 * @return L'en-tête du message.
	 */
	public DJ_EnTete getEnTete () {
		return enTete;
	}
	
	/**
	 * Permet de récupérer la requête du message.
	 * 
	 * @return La requête du message.
	 */
	public String getRequete () {
		return enTete.getRequete();
	}
	
	/**
	 * Permet de récupérer le content-type du message.
	 * 
	 * @return Le type du corps du message.
	 */
	public String getContentType () {
		return enTete.getContentType();
	}
	
	/**
	 * Permet de récupérer le nom de l'envoyeur du message.
	 * 
	 * @return Le nom de l'envoyeur du message.
	 */
	public String getEnvoyeur () {
		return enTete.getEnvoyeur();
	}
	
	/**
	 * Permet de récupérer le nom du recepteur du message.
	 * 
	 * @return Le nom du récepteur du message.
	 */
	public String getRecepteur () {
		return enTete.getRecepteur();
	}
	
	/**
	 * Permet de savoir si deux objet de la classe DJ_Message
	 * correspondent au même objet.
	 * 
	 * @param m L'objet avec lequel on souhaite comparer l'objet.
	 * @return true si les objets sont les mêmes, false sinon.
	 */
	public boolean equals (DJ_Message m) {
		if (corps.equals(m.getCorps()) == true && enTete.equals(m.getEnTete()) == true)
			return true;
		return false;
	}
}
