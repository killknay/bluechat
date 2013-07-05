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
public class DJ_Message {
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
	 * COnstructeur par défaut de la classe.
	 * Créé un message avec un en-tête vide et un corps
	 * de type texte.
	 */
	public DJ_Message () {
		this (null, null);
	}
}
