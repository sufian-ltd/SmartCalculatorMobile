package com.example.smartcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Programmer extends Activity {

	public String []str= {"Binary","Octal","Decimal","Hexadecimal"};
	ArrayAdapter<String> adapter;
	Spinner spn1,spn2;
	EditText et1,et2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.programmer);
		getIntent();
		spn1=(Spinner) findViewById(R.id.spinner1);
		spn2=(Spinner) findViewById(R.id.spinner2);
		et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		adapter=new ArrayAdapter<String>(this,R.layout.spinner_items, str);
		spn1.setAdapter(adapter);
		spn2.setAdapter(adapter);
		
		spn1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if(!et2.getText().toString().equals(""))
				{
					numberConversion(spn1,spn2, et1, et2.getText().toString());
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
					numberConversion(spn2,spn1, et2, et1.getText().toString());
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	public void numberConversion(Spinner spn,Spinner fromSpn,EditText et,String str)
	{
		try
		{
			
			if(fromSpn.getSelectedItem().equals("Hexadicmal"))
			{
				if(spn.getSelectedItem().equals("Hexadicmal"))
					et.setText(str.toString().toString());
				else if(spn.getSelectedItem().equals("Octal"))
					et.setText(hexToOctal(str).toString());
				else if(spn.getSelectedItem().equals("Binary"))
					et.setText(hexToBinary(str).toString());
				else if(spn.getSelectedItem().equals("Decimal"))
					et.setText(hexaToDecimal(str).toString());
				//et.setText(Double.toHexString(Double.parseDouble(str)));
			}
			else if(fromSpn.getSelectedItem().equals("Octal"))
			{
				//et.setText(Integer.toOctalString(Integer.parseInt(str)));
				if(spn.getSelectedItem().equals("Hexadicmal"))
					et.setText(octalToHex(str)+"");
				else if(spn.getSelectedItem().equals("Octal"))
					et.setText(str+"");
				else if(spn.getSelectedItem().equals("Binary"))
					et.setText(octalToBinary(str)+"");
				else if(spn.getSelectedItem().equals("Decimal"))
					et.setText(octalToDecimal(str)+"");
			}
			else if(fromSpn.getSelectedItem().equals("Binary"))
			{
				//et.setText(Integer.toBinaryString(Integer.parseInt(str)));
				for(int i=0;i<str.length();i++)
				{
					if(str.charAt(i)!='1' && str.charAt(i)!='0')
					{
						errorMsg();
						return;
					}
				}
				
				if(spn.getSelectedItem().equals("Hexadicmal"))
					et.setText(binaryToHex(str)+"");
				else if(spn.getSelectedItem().equals("Octal"))
					et.setText(binaryToOctal(str)+"");
				else if(spn.getSelectedItem().equals("Binary"))
					et.setText(str+"");
				else if(spn.getSelectedItem().equals("Decimal"))
					et.setText(binaryToDecimal(str)+"");
				
			}
			else if(fromSpn.getSelectedItem().equals("Decimal"))
			{
				//et.setText(Integer.parseInt(str,10)+"");
				if(spn.getSelectedItem().equals("Hexadicmal"))
					et.setText(decimalToHex(str)+"");
				else if(spn.getSelectedItem().equals("Octal"))
					et.setText(decimalToOctal(str)+"");
				else if(spn.getSelectedItem().equals("Binary"))
					et.setText(decimalToBinary(str)+"");
				else if(spn.getSelectedItem().equals("Decimal"))
					et.setText(str+"");
			}
		}
		catch(Exception ex)
		{
			errorMsg();
		}
	}
	public void errorMsg()
	{
		et1.setText("");
		et2.setText("");
		Toast.makeText(getApplicationContext(), "invalid input",Toast.LENGTH_LONG).show();
	}
	public String binaryToDecimal(String orgStr)
	{
		long binnum, decnum=0, i=1, rem;
        binnum = Long.parseLong(orgStr);
	
        // converting the number into decimal format
        while(binnum != 0)
        {
            rem = binnum%10;
            decnum = decnum + rem*i;
            i = i*2;
            binnum = binnum/10;
        }
        return decnum+"";
	}
	public String hexaToDecimal(String orgStr)
	{
		String digits = "0123456789ABCDEF";
        orgStr = orgStr.toUpperCase();
        long val = 0;
        for (int i = 0; i < orgStr.length(); i++)
        {
            char c = orgStr.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val+"";
		
	}
	public String octalToDecimal(String orgStr)
	{
		long octnum, decnum=0, i=0, orig;
        octnum = Long.parseLong(orgStr);
		
        orig = octnum;
		
        while(octnum != 0)
        {
            decnum = decnum + (octnum%10) * (int) Math.pow(8, i);
            i++;
            octnum = octnum/10;
        }
        return decnum+"";
		
	}
	public String binaryToHex(String orgStr)
	{
		String temp=binaryToDecimal(orgStr);
		return Long.toHexString(Long.parseLong(temp));
		
    }
	public String binaryToOctal(String orgStr)
	{
		String temp=binaryToDecimal(orgStr);
		return Long.toOctalString(Long.parseLong(temp));
	}
	public String decimalToHex(String orgStr)
	{
		
		return Long.toHexString(Long.parseLong(orgStr));
	}
	public String octalToHex(String orgStr)
	{
		String oct=octalToDecimal(orgStr);
		return Long.toHexString(Long.parseLong(oct));
		
	}
	public String decimalToOctal(String orgStr)
	{
		
		return Long.toOctalString(Long.parseLong(orgStr));
	}
	public String hexToOctal(String orgStr)
	{
		String dec=hexaToDecimal(orgStr);
		return Long.toOctalString(Long.parseLong(dec));
		
	}
	public String decimalToBinary(String orgStr)
	{
		return Long.toBinaryString(Long.parseLong(orgStr));
	}
	public String hexToBinary(String orgStr)
	{
		String dec=hexaToDecimal(orgStr);
		return Long.toBinaryString(Long.parseLong(dec));
		
	}
	public String octalToBinary(String orgStr)
	{
		String temp=octalToDecimal(orgStr);
		return Long.toBinaryString(Long.parseLong(temp));
	}
}
