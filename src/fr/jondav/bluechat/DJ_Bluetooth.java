package fr.jondav.bluechat;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.widget.Toast;

/**
 * 
 * @author Jonathan & David
 * 
 * Cette classe permet de savoir si 
 * le bluetooth est activé ou pas.
 * Et ainsi d'activer le bluetooth
 *
 */
public class DJ_Bluetooth {
	private boolean bluetooth = false;
	private static BluetoothAdapter bluetoothAdapter;
	/**
	 * Constructeur par defaut test si le
	 *  support android comporte
	 * la technologie du bluetooth.
	 * 
	 */
	public DJ_Bluetooth(){
		bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (bluetoothAdapter == null)
			bluetooth = false;
		else
			bluetooth = true;
	}
	
	/**
	 * Permet de savoir si le support android 
	 * supporte le bluetooth.
	 * @return true si il est equipé du bluetooth, false sinon.
	 */
	public boolean SupportBluetooth(){
		return bluetooth;
	}
	
	/**
	 * Permet de verifier si le Bluetooth est active ou non
	 * @return true si il est active, false sinon.
	 */
	public boolean activeBluetooth(){
		if (!bluetoothAdapter.isEnabled()) {
			return false;
		}
		return true;
	}
	
	
}
