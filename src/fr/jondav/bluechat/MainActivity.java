package fr.jondav.bluechat;



import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	LinearLayout layoutGlobal = null;    //< Le layout global de l'activité
	private DJ_Bluetooth bluetooth = new DJ_Bluetooth();
	private final static int REQUEST_BLUETOOTH = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		layoutGlobal = (LinearLayout) RelativeLayout.inflate(this, R.layout.activity_main, null);
		
		
		/**
		 * Permet de gerer le click du bouton pour la connexion
		 * Si le bluetooth n'est pas activer on lance une boite de dialogue
		 * sinon on passe a l'activite correspondante.
		 */
		final Button BtConnexion = (Button) layoutGlobal.findViewById(R.id.bt_Connexion);
		BtConnexion.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Si le bluetooth n'est pas activer
				if(bluetooth.activeBluetooth() == false){
					Intent enableBlueTooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
					startActivityForResult(enableBlueTooth, REQUEST_BLUETOOTH);
				}
				//si le bluetooth est activer
				if(bluetooth.activeBluetooth() == true){
					Toast.makeText(MainActivity.this, "En cours...", Toast.LENGTH_LONG).show();

				}
			} 
		});
		/**
		 * Permet de gerer le click du bouton pour quitter 
		 * l'application
		 */
		final Button BtQuitter = (Button) layoutGlobal.findViewById(R.id.bt_Quitter);
		BtQuitter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			} 
		});
		
		setContentView(layoutGlobal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
