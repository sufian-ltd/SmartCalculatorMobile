package com.example.smartcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


public class StartMenu extends Activity {

	Intent  intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void startMenuButtonsClick(View v)
	{
		if(v.getId()==R.id.buttonSci)
		{
			intent=new Intent(StartMenu.this,Scientific.class);
			startActivity(intent);
		}
		else if(v.getId()==R.id.buttonCon)
		{
			intent=new Intent(StartMenu.this,Converter.class);
			startActivity(intent);
		}
		else if(v.getId()==R.id.buttonGeo)
		{
			intent=new Intent(StartMenu.this,Geometric.class);
			startActivity(intent);
		}
		else if(v.getId()==R.id.buttonMat)
		{
			intent=new Intent(StartMenu.this,Matrix.class);
			startActivity(intent);
		}
		else if(v.getId()==R.id.buttonProg)
		{
			intent=new Intent(StartMenu.this,Programmer.class);
			startActivity(intent);
		}
	}

}
