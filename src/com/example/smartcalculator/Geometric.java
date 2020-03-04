package com.example.smartcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Geometric extends Activity {

	String area[]= {"Area of Circle","Area of Circle Sector(degree)",
			"Area of Circle Sector(radian)",
			"Area of Triangle","Area of equilateral Triangle",
			"Area of Square","Area of Rectangle","Area of Parallelogram",
			"Area of Trapezoid"};
	String volume[]= {"Volume of cube","Volume of rectangle prism",
			"Volume of irregular prism","Volume of Cylinder",
			"Volume of Pyramid","Volume of Cone",
			"Volume of Sphere"};
	
	RadioGroup group;
	Spinner spinnerGeo;
	TextView txtResult;
	EditText etX1,etY1,etX2,etY2,etRadius,etLen,etWidth,etHeight,etAngle;
	Button btnRes;
	ArrayAdapter<String> adapterArea,adapterVolume;

		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.geometric);
		getIntent();
		
		group=(RadioGroup) findViewById(R.id.radioGroup);
		spinnerGeo=(Spinner) findViewById(R.id.spinnerGeo);
		btnRes=(Button) findViewById(R.id.buttonRes);
		txtResult=(TextView) findViewById(R.id.textViewResult);
		etX1=(EditText) findViewById(R.id.editTextX1);
		etY1=(EditText) findViewById(R.id.editTextY1);
		etX2=(EditText) findViewById(R.id.editTextX2);
		etY2=(EditText) findViewById(R.id.editTextY2);
		etRadius=(EditText) findViewById(R.id.editTextRadius);
		etLen=(EditText) findViewById(R.id.editTextLength);
		etWidth=(EditText) findViewById(R.id.editTextWidth);
		etHeight=(EditText) findViewById(R.id.editTextHeight);
		etAngle=(EditText) findViewById(R.id.editTextAngle);
		
		
		adapterArea=new ArrayAdapter<String>(this,
				R.layout.spinner_items,area);
		adapterVolume=new ArrayAdapter<String>(this,
				R.layout.spinner_items,volume);
		spinnerGeo.setAdapter(adapterArea);
		btnRes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try
				{
					double x1=Double.parseDouble(etX1.getText().toString());
					double y1=Double.parseDouble(etY1.getText().toString());
					double x2=Double.parseDouble(etX2.getText().toString());
					double y2=Double.parseDouble(etY2.getText().toString());
					double x=Math.sqrt(Math.pow(x1-y1,2)+Math.pow(x2-y2,2));
					txtResult.setText("Distance : "+x);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if(arg1==R.id.radioArea)
				{
					spinnerGeo.setAdapter(adapterArea);
				}
				else 
				{
					spinnerGeo.setAdapter(adapterVolume);
				}
			}
		});
		
		spinnerGeo.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View view,
					int pos, long arg3) {
				// TODO Auto-generated method stub
				geoCalculation();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	public void geoCalculation()
	{
		try
		{
		if(group.getCheckedRadioButtonId()==R.id.radioArea)
		{
			
			if(spinnerGeo.getSelectedItem().equals("Area of Circle"))
			{
				if(!etRadius.getText().toString().equals(""))
				{
					double x=Double.parseDouble(etRadius.getText().toString());
					x=(3.1416*(x*x));
					txtResult.setText("Area of Circle :"+x);
				}
			}
			
			else if(spinnerGeo.getSelectedItem().equals("Area of Circle Sector(degree)"))
			{
				if(!etRadius.getText().toString().equals(""))
				{
					double r=Double.parseDouble(etRadius.getText().toString());
					double a=Double.parseDouble(etRadius.getText().toString());
					r=((a/360)*3.1416*r*r);
					txtResult.setText("area of Circle Sector(degree) is : "+r);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Area of Circle Sector(radian)"))
			{
				if(!etRadius.getText().toString().equals(""))
				{
					double r=Double.parseDouble(etRadius.getText().toString());
					double a=Double.parseDouble(etRadius.getText().toString());
					r=((a/(2*3.1416))*3.1416*r*r);
					txtResult.setText("area of Circle Sector(degree) is : "+r);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Area of Triangle"))
			{
				if(!etWidth.getText().toString().equals("") && 
						!etHeight.getText().toString().equals(""))
				{
					double x=Double.parseDouble(etWidth.getText().toString());
					double y=Double.parseDouble(etHeight.getText().toString());
					x=(.5*(x*y));
					txtResult.setText("Area of Triangle : "+x);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Area of equilateral Triangle"))
			{
				if(!etLen.getText().toString().equals("") && 
						!etWidth.getText().toString().equals(""))
				{
					double x=Double.parseDouble(etLen.getText().toString());
					x=((Math.sqrt(3)/4)*(x*x));
					txtResult.setText("Area of equilateral Triangle :"+x);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Area of Square"))
			{
				if(!etLen.getText().toString().equals("") && 
						!etWidth.getText().toString().equals(""))
				{
					double x=Double.parseDouble(etLen.getText().toString());
					x=(x*x);
					txtResult.setText("Area of Square :"+x);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Area of Rectangle"))
			{
				if(!etLen.getText().toString().equals("") && 
						!etWidth.getText().toString().equals(""))
				{
					double x=Double.parseDouble(etLen.getText().toString());
					x=(x*x*x);
					txtResult.setText("Area of Rectangle :"+x);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Area of Parallelogram"))
			{
				if(!etLen.getText().toString().equals("") && 
						!etWidth.getText().toString().equals(""))
				{
					double b=Double.parseDouble(etLen.getText().toString());
					double h=Double.parseDouble(etWidth.getText().toString());
					b=(b*h);
					txtResult.setText("Area of Parallelogram :"+b);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Area of Trapezoid"))
			{
				if(!etLen.getText().toString().equals("") && 
						!etWidth.getText().toString().equals(""))
				{
					double b1=Double.parseDouble(etLen.getText().toString());
					double b2=Double.parseDouble(etWidth.getText().toString());
					double h=Double.parseDouble(etHeight.getText().toString());
					b1=((h/2)*(b1+b2));
					txtResult.setText("Area of Trapezoid :"+b1);
				}
			}
			
		}
				
		 if(group.getCheckedRadioButtonId()==R.id.radioVolume)
		{
			if(spinnerGeo.getSelectedItem().equals("Volume of cube"))
			{
				if(!etLen.getText().toString().equals("") && 
						!etWidth.getText().toString().equals(""))
				{
					double x=Double.parseDouble(etLen.getText().toString());
					x=(x*x*x);
					txtResult.setText("Volume of cube : "+x);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Volume of rectangle prism"))
			{
				if(!etLen.getText().toString().equals("") && 
						!etWidth.getText().toString().equals(""))
				{
					double x=Double.parseDouble(etLen.getText().toString());
					double y=Double.parseDouble(etWidth.getText().toString());
					double z=Double.parseDouble(etHeight.getText().toString());
					x=(x*y*z);
					txtResult.setText("Volume of rectangle prism : "+x);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Volume of irregular prism"))
			{
				if(!etLen.getText().toString().equals("") && 
						!etWidth.getText().toString().equals(""))
				{
					double y=Double.parseDouble(etWidth.getText().toString());
					double z=Double.parseDouble(etHeight.getText().toString());
					y=(y*z);
					txtResult.setText("Volume of irregular prism : "+y);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Volume of Cylinder"))
			{
				if(!etLen.getText().toString().equals("") && 
						!etWidth.getText().toString().equals(""))
				{
					double r=Double.parseDouble(etRadius.getText().toString());
					double h=Double.parseDouble(etHeight.getText().toString());
					r=(3.1416*r*r*h);
					txtResult.setText("Volume of Cylinder : "+r);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Volume of Pyramid"))
			{
				if(!etLen.getText().toString().equals("") && 
						!etWidth.getText().toString().equals(""))
				{
					double b=Double.parseDouble(etWidth.getText().toString());
					double h=Double.parseDouble(etHeight.getText().toString());
					b=((1/3)*b*h);
					txtResult.setText("Volume of Pyramid : "+b);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Volume of Cone"))
			{
				if(!etLen.getText().toString().equals("") && 
						!etWidth.getText().toString().equals(""))
				{
					double r=Double.parseDouble(etRadius.getText().toString());
					double h=Double.parseDouble(etHeight.getText().toString());
					r=((1/3)*3.1416*r*r*h);
					txtResult.setText("Volume of Cone : "+r);
				}
			}
			else if(spinnerGeo.getSelectedItem().equals("Volume of Sphere"))
			{
				if(!etLen.getText().toString().equals("") && 
						!etWidth.getText().toString().equals(""))
				{
					double r=Double.parseDouble(etRadius.getText().toString());
					r=((4/3)*3.1416*r*r*r);
					txtResult.setText("Volume of Sphere : "+r);
				}
			}
			
		}
		}
		catch(Exception ex)
		{
			
		}
	}
}
