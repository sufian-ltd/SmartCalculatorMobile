package com.example.smartcalculator;

import java.text.BreakIterator;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Matrix extends Activity {

	EditText etFirstMatrix,etsecondMatrix,etMatrixRes;
	Spinner spn;
	String matrixCalStr[]= {"Addition","Subtraction","Multiplication",
			"Tranpose"};
	ArrayAdapter<String> adpterMatrix;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.matrix);
		getIntent();
		
		etFirstMatrix=(EditText) findViewById(R.id.editTextFirstMat);
		etsecondMatrix=(EditText) findViewById(R.id.editTextSecMat);
		etMatrixRes=(EditText) findViewById(R.id.editTextMatrixResult);
		spn=(Spinner) findViewById(R.id.spinnerMatrix);
		
		adpterMatrix=new ArrayAdapter<String>(this,
				R.layout.spinner_items,matrixCalStr);
		spn.setAdapter(adpterMatrix);
		
		spn.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub

				if(spn.getSelectedItem().equals("Addition"))
				{
					try
					{
					if(!etFirstMatrix.getText().toString().equals("") && 
							!etsecondMatrix.getText().toString().equals(""))
						{
						
							int x[][]=getvalueFromMatrix(etFirstMatrix);
							int y[][]=getvalueFromMatrix(etsecondMatrix);
							String temp="";
							if((x[0].length==y[0].length) && x.length==y.length)
							{
								for(int i=0;i<x.length;i++)
								{
									for(int j=0;j<x[0].length;j++)
									{
										temp+=x[i][j]+y[i][j];
										temp+=" ";
									}
									temp+='\n';
								}
								
								etMatrixRes.setText(temp);
							}
						}
					}
					catch(Exception ex)
					{
						etFirstMatrix.setText("");
						etsecondMatrix.setText("");
						Toast.makeText(Matrix.this, "invalid input", Toast.LENGTH_LONG).show();
					}
				}
				else if(spn.getSelectedItem().equals("Subtraction"))
				{
					try
					{
						if(!etFirstMatrix.getText().toString().equals("") && 
								!etsecondMatrix.getText().toString().equals(""))
						{
							
						int x[][]=getvalueFromMatrix(etFirstMatrix);
						int y[][]=getvalueFromMatrix(etsecondMatrix);
						String temp="";
						if((x[0].length==y[0].length) && x.length==y.length)
						{
							for(int i=0;i<x.length;i++)
							{
								for(int j=0;j<x[0].length;j++)
								{
									temp+=x[i][j]-y[i][j];
									temp+=" ";
								}
								temp+='\n';
							}
							
							etMatrixRes.setText(temp);
						}
						}
					}
					catch(Exception ex)
					{
						etFirstMatrix.setText("");
						etsecondMatrix.setText("");
						Toast.makeText(Matrix.this, "invalid input", Toast.LENGTH_LONG).show();
					}
				}
				else if(spn.getSelectedItem().equals("Multiplication"))
				{
					try
					{
					if(!etFirstMatrix.getText().toString().equals("") && 
							!etsecondMatrix.getText().toString().equals(""))
					{
					int x[][]=getvalueFromMatrix(etFirstMatrix);
					int y[][]=getvalueFromMatrix(etsecondMatrix);
					String temp="";
					if((x[0].length==y[0].length) && x.length==y.length)
					{
						for(int i=0;i<x.length;i++)
						{
							for(int j=0;j<x[0].length;j++)
							{
								temp+=x[i][j]*y[i][j];
								temp+=" ";
							}
							temp+='\n';
						}
						
						etMatrixRes.setText(temp);
					}
					}
					}
					catch(Exception ex)
					{
						etFirstMatrix.setText("");
						etsecondMatrix.setText("");
						Toast.makeText(Matrix.this, "invalid input", Toast.LENGTH_LONG).show();
					}
				}
				else if(spn.getSelectedItem().equals("Tranpose"))
				{
					try
					{
					if(etFirstMatrix.isFocusable())
					{
						String temp="";
						if(!etFirstMatrix.getText().toString().equals(""))
						{
							int x[][]=getvalueFromMatrix(etFirstMatrix);
							int d[][]=new int[100][100];
							for(int i=0;i<x.length;i++)
							{
								for(int j=0;j<x[0].length;j++)
								{
									d[i][j]=x[j][i];
									temp+=d[i][j];
									temp+=" ";
								}
								temp+='\n';
							}
							etMatrixRes.setText(temp);
						}
					}
					
					
					else if(etsecondMatrix.isFocusable())
					{
						String temp="";
						if(!etsecondMatrix.getText().toString().equals(""))
						{
							int y[][]=getvalueFromMatrix(etsecondMatrix);
							int d[][]=new int[100][100];
							for(int i=0;i<y.length;i++)
							{
								for(int j=0;j<y[0].length;j++)
								{
									d[i][j]=y[j][i];
									temp+=d[i][j];
									temp+=" ";
								}
								temp+='\n';
							}
							etMatrixRes.setText(temp);
						}
					}
					}
					catch(Exception ex)
					{
						etFirstMatrix.setText("");
						etsecondMatrix.setText("");
						Toast.makeText(Matrix.this, "invalid input", Toast.LENGTH_LONG).show();
					}
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public int[][] getvalueFromMatrix(EditText et)
	{
		
		String str=et.getText().toString();
		int row=1,col=0,max=-1;
		for(int m=0;m<str.length();m++)
		{
			if(str.charAt(m)=='\n')
			{
				++row;
				col=0;
			}
			else if(str.charAt(m)!=' ')
			{
				col++;
				if(col>max)
					max=col;
			}
		}
		int a[][]=new int[row][col];
		int i=0,j=0;
		for(int m=0;m<str.length();m++)
		{
			if(str.charAt(m)=='\n')
			{
				++i;
				j=0;
			}
			else if(str.charAt(m)!=' ')
				a[i][j++]=Integer.parseInt(str.charAt(m)+"");
		}
		return a;
		
		
	}
}
