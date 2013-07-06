package fr.jondav.bluechat;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	LinearLayout layoutGlobal = null;    //< Le layout global de l'activité

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		layoutGlobal = (LinearLayout) RelativeLayout.inflate(this, R.layout.activity_main, null);
		
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
