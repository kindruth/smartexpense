package com.devpia.dforge.smartexpense;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

public class SmsReadingActivity extends Activity implements OnTouchListener{
    
	Cursor c;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button readBtn = (Button)this.findViewById(R.id.readBtn);
        readBtn.setOnTouchListener(this);
        c = getContentResolver().query(Uri.parse("content://sms/inbox"), null ,null, null, null);
        
    }
    
    public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
    	c.moveToNext();
    	Toast.makeText(this, c.getString(11).toString(), Toast.LENGTH_SHORT).show();		
		return false;
	}
	
    
}