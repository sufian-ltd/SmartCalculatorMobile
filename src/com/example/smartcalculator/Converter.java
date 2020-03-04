package com.example.smartcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

public class Converter extends Activity {

    String []lenStr= {"centimeters","meters","kilometers","inches"};
    String []weightStr= {"grams","kilograms","pounds"};
    String []temStr= {"celsius","fahrenheit","kelvin"};
    String []angleStr= {"degree","radians","gradians"};
	ArrayAdapter<String> adapterLen,adapterWe,adaptertem,adapterAng;
	Spinner spn1,spn2;
	EditText et1,et2;
	RadioGroup group;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.converter);
		getIntent();
		
		spn1=(Spinner) findViewById(R.id.spinner1);
		spn2=(Spinner) findViewById(R.id.spinner2);
		et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		
		adapterLen=new ArrayAdapter<String>(this,
				R.layout.spinner_items, lenStr);
		adapterWe=new ArrayAdapter<String>(this,
				R.layout.spinner_items, weightStr);
		adaptertem=new ArrayAdapter<String>(this,
				R.layout.spinner_items, temStr);
		adapterAng=new ArrayAdapter<String>(this,
				R.layout.spinner_items, angleStr);
		spn1.setAdapter(adapterLen);
		spn2.setAdapter(adapterLen);
		group=(RadioGroup) findViewById(R.id.radioGroup);
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				switch (arg1) {
				case R.id.radioLen:
					et1.setHint("enter length ....");
					et2.setHint("enter length ....");
					spn1.setAdapter(adapterLen);
					spn2.setAdapter(adapterLen);
					break;
				case R.id.radioWe:
					et1.setHint("enter weight and mass..");
					et2.setHint("enter weight and mass..");
					spn1.setAdapter(adapterWe);
					spn2.setAdapter(adapterWe);
					break;	
				case R.id.radioTem:
					et1.setHint("enter temperature ....");
					et2.setHint("enter temperture ....");
					spn1.setAdapter(adaptertem);
					spn2.setAdapter(adaptertem);
					break;
				case R.id.radioAng:
					et1.setHint("enter angle ....");
					et2.setHint("enter angle ....");
					spn1.setAdapter(adapterAng);
					spn2.setAdapter(adapterAng);
					break;
				default:
					break;
				}
			}
		});
		
		

		
		spn1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if(!et2.getText().toString().equals(""))
				{
					double value=Double.parseDouble(et2.getText().toString());
					convertIt(spn1, spn2, et1, et2, value);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		spn2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				if(!et1.getText().toString().equals(""))
				{
					double value=Double.parseDouble(et1.getText().toString());
					convertIt(spn2, spn1, et2, et1, value);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void convertIt(Spinner spn1,Spinner spn2,EditText et1,
			EditText et2,double value)
	{
		try
		{
		if(group.getCheckedRadioButtonId()==R.id.radioLen)
		{
			
			convertLength(spn1, spn2, et1, et2, value);
		}
		else if(group.getCheckedRadioButtonId()==R.id.radioTem)
		{
			
			convertTemperature(spn1, spn2, et1, et2, value);
		}
		else if(group.getCheckedRadioButtonId()==R.id.radioAng)
		{
			
			convertAngle(spn1, spn2, et1, et2, value);
		}
		else if(group.getCheckedRadioButtonId()==R.id.radioWe)
		{
			
			convertWeight(spn1, spn2, et1, et2, value);
		}
		}
		catch(Exception ex)
		{
			
		}
	}
	public void convertWeight(Spinner spn1,Spinner spn2,EditText et1,
			EditText et2,double value)
	{
		if(spn1.getSelectedItem().equals("grams"))
		{
			if(spn2.getSelectedItem().equals("grams"))
			{
				et1.setText(value+"");
			}
			else if(spn2.getSelectedItem().equals("kilograms"))
			{
				et1.setText((value*1000)+"");
			}
			else if(spn2.getSelectedItem().equals("pounds"))
			{
				et1.setText((value*453.5924)+"");
			}
		}
		else if(spn1.getSelectedItem().equals("kilograms"))
		{
			if(spn2.getSelectedItem().equals("grams"))
			{
				et1.setText((value*0.001)+"");
			}
			else if(spn2.getSelectedItem().equals("kilograms"))
			{
				et1.setText(value+"");
			}
			else if(spn2.getSelectedItem().equals("pounds"))
			{
				et1.setText((value*0.453592)+"");
			}
		}
		else if(spn1.getSelectedItem().equals("pounds"))
		{
			if(spn2.getSelectedItem().equals("grams"))
			{
				et1.setText((value*0.002205)+"");
			}
			else if(spn2.getSelectedItem().equals("kilograms"))
			{
				et1.setText((value*2.204623)+"");
			}
			else if(spn2.getSelectedItem().equals("pounds"))
			{
				et1.setText(value+"");
			}
		}
	}
	
	public void convertAngle(Spinner spn1,Spinner spn2,EditText et1,
			EditText et2,double value)
	{
		if(spn1.getSelectedItem().equals("degree"))
		{
			if(spn2.getSelectedItem().equals("degree"))
			{
				et1.setText(value+"");
			}
			else if(spn2.getSelectedItem().equals("radians"))
			{
				et1.setText((value*57.29578)+"");
			}
			else if(spn2.getSelectedItem().equals("gradians"))
			{
				et1.setText((value*0.9)+"");
			}
		}
		else if(spn1.getSelectedItem().equals("radians"))
		{
			if(spn2.getSelectedItem().equals("degree"))
			{
				et1.setText((value*.017453)+"");
			}
			else if(spn2.getSelectedItem().equals("radians"))
			{
				et1.setText(value+"");
			}
			else if(spn2.getSelectedItem().equals("gradians"))
			{
				et1.setText((value*0.015708)+"");
			}
		}
		else if(spn1.getSelectedItem().equals("gradians"))
		{
			if(spn2.getSelectedItem().equals("degree"))
			{
				et1.setText((value*1.111111)+"");
			}
			else if(spn2.getSelectedItem().equals("radians"))
			{
				et1.setText((value*63.66198)+"");
			}
			else if(spn2.getSelectedItem().equals("gradians"))
			{
				et1.setText(value+"");
			}
		}
	}
	
	public void convertTemperature(Spinner spn1,Spinner spn2,EditText et1,
			EditText et2,double value)
	{
		if(spn1.getSelectedItem().equals("celsius"))
		{
			if(spn2.getSelectedItem().equals("celsius"))
			{
				et1.setText(value+"");
			}
			else if(spn2.getSelectedItem().equals("fahrenheit"))
			{
				et1.setText(fahrenheitToCelsius(value)+"");
			}
			else if(spn2.getSelectedItem().equals("kelvin"))
			{
				et1.setText(kelvinToCelsius(value)+"");
			}
		}
		else if(spn1.getSelectedItem().equals("fahrenheit"))
		{
			if(spn2.getSelectedItem().equals("celsius"))
			{
				et1.setText(celsiusToFahrenheit(value)+"");
			}
			else if(spn2.getSelectedItem().equals("fahrenheit"))
			{
				et1.setText(value+"");
			}
			else if(spn2.getSelectedItem().equals("kelvin"))
			{
				et1.setText(kelvinToFahrenheit(value)+"");
			}
		}
		else if(spn1.getSelectedItem().equals("kelvin"))
		{
			if(spn2.getSelectedItem().equals("celsius"))
			{
				et1.setText(celsiusToKelvin(value)+"");
			}
			else if(spn2.getSelectedItem().equals("fahrenheit"))
			{
				et1.setText(fahrenheitToKelvin(value)+"");
			}
			else if(spn2.getSelectedItem().equals("kelvin"))
			{
				et1.setText(value+"");
			}
		}
		
	}
	double fahrenheitToCelsius(double value)
	{
		return (value-32)*(5/9);
	}
	double celsiusToFahrenheit(double value)
	{
		return value*(9/5)+32;
	}
	double fahrenheitToKelvin(double value)
	{
		return (value-32)*(5/9)+273.15;
	}
	double kelvinToFahrenheit(double value)
	{
		return (value-273.15)*(9/5)+32;
	}
	double kelvinToCelsius(double value)
	{
		return value-273.15;
	}
	double celsiusToKelvin(double value)
	{
		return value+273.15;
	}
	public void convertLength(Spinner spn1,Spinner spn2,EditText et1,
			EditText et2,double value)
	{
			if(spn1.getSelectedItem().equals("centimeters"))
			{
				if(spn2.getSelectedItem().equals("centimeters"))
				{
					et1.setText(value+"");
				}
				else if(spn2.getSelectedItem().equals("meters"))
				{
					et1.setText((value*100)+"");
				}
				else if(spn2.getSelectedItem().equals("kilometers"))
				{
					et1.setText((value*1000)+"");
				}
				else if(spn2.getSelectedItem().equals("inches"))
				{
					et1.setText((value*.393701)+"");
				}
			}
			else if(spn1.getSelectedItem().equals("meters"))
			{
				if(spn2.getSelectedItem().equals("centimeters"))
				{
					et1.setText((value/100)+"");
				}
				else if(spn2.getSelectedItem().equals("meters"))
				{
					et1.setText(value+"");
				}
				else if(spn2.getSelectedItem().equals("kilometers"))
				{
					et1.setText((value/1000)+"");
				}
				else if(spn2.getSelectedItem().equals("inches"))
				{
					et1.setText((value*.0254)+"");
				}
			}
			else if(spn1.getSelectedItem().equals("kilometers"))
			{
				if(spn2.getSelectedItem().equals("centimeters"))
				{
					et1.setText((value/10000)+"");
				}
				else if(spn2.getSelectedItem().equals("meters"))
				{
					et1.setText((value/1000)+"");
				}
				else if(spn2.getSelectedItem().equals("kilometers"))
				{
					et1.setText(value+"");
				}
				else if(spn2.getSelectedItem().equals("inches"))
				{
					et1.setText((value*.000025)+"");
				}
			}
			else if(spn1.getSelectedItem().equals("inches"))
			{
				if(spn2.getSelectedItem().equals("centimeters"))
				{
					et1.setText((value*.393701)+"");
				}
				else if(spn2.getSelectedItem().equals("meters"))
				{
					et1.setText((value*39.37008)+"");
				}
				else if(spn2.getSelectedItem().equals("kilometers"))
				{
					et1.setText((value*39370.08)+"");
				}
				else if(spn2.getSelectedItem().equals("inches"))
				{
					et1.setText(value+"");
				}
			}
	}
}

