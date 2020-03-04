package com.example.smartcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Scientific extends Activity {

	Button btSin,btCos,btTan,btSec,btCosec,btCot,btAsin,btACos,btAtan,
		btSinh,btCosh,btTanh,btLog,btFact,btOnePlusXInverse,
		btOneMinusXInverse,btNpr,btNcr,btXx,btXxx,btXtoThePowY,
		btEtoThePowX,btEtoThePowXMinusOne,btXqrt,btSqrt,btQubet,
		btAbs,btLog10,
		btOne,btTwo,btThree,btFour,btFive,btsix,btSev,btEight,btNine,
		btZero,btDoubleZero,btEqual,btMod,btPlus,btMinus,
		btMul,btdiv,btDel,btAc;
	
	TextView txt,txtRes;
	
	double first=0.0,second=0.0;
	String operators="#";
	boolean opeartorClickFirst=false,allClear=false;
	boolean xpow=false,ncr=false,cpr=false,xry=false,npr=false;
	boolean multipleOpClick=false,equalClick=false;;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scientific);
		getIntent();
		
		btSin=(Button) findViewById(R.id.buttonSin);
		btCos=(Button) findViewById(R.id.buttonCos);
		btTan=(Button) findViewById(R.id.buttonTan);
		btSec=(Button) findViewById(R.id.buttonSec);
		btCosec=(Button) findViewById(R.id.buttonCosec);
		btCot=(Button) findViewById(R.id.buttonCot);
		btAsin=(Button) findViewById(R.id.buttonAsin);
		btACos=(Button) findViewById(R.id.buttonAcos);
		btAtan=(Button) findViewById(R.id.buttonAtan);
		btSinh=(Button) findViewById(R.id.buttonSinh);
		btCosh=(Button) findViewById(R.id.buttonCosh);
		btTanh=(Button) findViewById(R.id.buttonTanh);
		btLog=(Button) findViewById(R.id.buttonLog);
		btFact=(Button) findViewById(R.id.buttonFactN);
		btOnePlusXInverse=(Button) findViewById(R.id.buttonOnePlusXInverseminusOne);
		btOneMinusXInverse=(Button) findViewById(R.id.buttonOneMinusXInverseminusOne);
		btNpr=(Button) findViewById(R.id.buttonNpr);
		btNcr=(Button) findViewById(R.id.buttonNcr);
		btXx=(Button) findViewById(R.id.buttonXsqr);
		btXxx=(Button) findViewById(R.id.buttonXcube);
		btXtoThePowY=(Button) findViewById(R.id.buttonXToThePowY);
		btEtoThePowX=(Button) findViewById(R.id.buttonEtoThePowX);
		btEtoThePowXMinusOne=(Button) findViewById(R.id.buttonEtoThePowXMinusOne);
		btXqrt=(Button) findViewById(R.id.buttonXqrt);
		btSqrt=(Button) findViewById(R.id.buttonSqrt);
		btQubet=(Button) findViewById(R.id.buttonCqrt);
		btAbs=(Button) findViewById(R.id.buttonAbs);
		btLog10=(Button) findViewById(R.id.buttonLog10);
		btOne=(Button) findViewById(R.id.buttonOne);
		btTwo=(Button) findViewById(R.id.buttonTwo);
		btThree=(Button) findViewById(R.id.buttonThree);
		btFour=(Button) findViewById(R.id.buttonFour);
		btFive=(Button) findViewById(R.id.buttonFive);
		btsix=(Button) findViewById(R.id.buttonSix);
		btSev=(Button) findViewById(R.id.buttonSev);
		btEight=(Button) findViewById(R.id.buttonEight);
		btNine=(Button) findViewById(R.id.buttonNine);
		btZero=(Button) findViewById(R.id.buttonZero);
		btDoubleZero=(Button) findViewById(R.id.buttonDoubleZero);
		btEqual=(Button) findViewById(R.id.buttonEqual);
		btMod=(Button) findViewById(R.id.buttonMod);
		btPlus=(Button) findViewById(R.id.buttonPlus);
		btMinus=(Button) findViewById(R.id.buttonMinus);
		btMul=(Button) findViewById(R.id.buttonMul);
		btdiv=(Button) findViewById(R.id.buttonDiv);
		btDel=(Button) findViewById(R.id.buttonDel);
		btAc=(Button) findViewById(R.id.buttonAc);
		
		txt=(TextView) findViewById(R.id.textViewShow);
		//txtRes=(TextView) findViewById(R.id.textViewRes);
	}
	
	
	public void twoOperatorNeed(View v)
	{
		try
		{
		if(txt.getText().equals(""))
			return;
		if(v==btXqrt)
		{
			xry=true;
			second=Double.parseDouble(txt.getText().toString());
		}
		else if(v==btXtoThePowY)
		{
			xpow=true;
			second=Double.parseDouble(txt.getText().toString());
		}
		else if(v==btNcr)
		{
			ncr=true;
			second=Double.parseDouble(txt.getText().toString());
		}
		else if(v==btNpr)
		{
			npr=true;
			second=Double.parseDouble(txt.getText().toString());
		}
		txt.setText("");
		}
		catch(Exception ex)
		{
			
		}
		
	}
	
	public void othersClick(View v)
	{
		try
		{
		if(txt.getText().toString().equals(""))
			return;
		double a=Double.parseDouble(txt.getText().toString());
		if(v== btSin)
		{
			first=Math.sin(a);
		}
		else if(v==btCos)
		{
			first=Math.cos(a);
		}
		else if(v==btTan)
		{
			first=Math.tan(a);
		}
		else if(v==btAsin)
		{
			first=Math.asin(a);
		}
		else if(v==btACos)
		{
			first=Math.acos(a);
		}
		else if(v==btAtan)
		{
			first=Math.atan(a);
		}
		else if(v==btCosh)
		{
			first=Math.cosh(a);
		}
		else if(v==btSinh)
		{
			first=Math.sinh(a);
		}
		else if(v==btTanh)
		{
			first=Math.tanh(a);
		}
		else if(v==btSec)
		{
			first=1/Math.cos(a);
		}
		else if(v==btCosec)
		{
			first=1/Math.sin(a);
		}
		else if(v==btCot)
		{
			first=1/Math.tan(a);
		}
		else if(v==btAbs)
		{
			first=Math.abs(a);
		}
		else if(v==btSqrt)
		{
			first=Math.sqrt(a);
		}
		else if(v==btQubet)
		{
			first=Math.cbrt(a);
		}
		else if(v==btOneMinusXInverse)
		{
			double i,x,y,t=1,sum=1;
		    
		    for(i=0;i<10;i++)
		    {
		        y=Math.pow(a,t);
		        sum=sum+y;
		        t++;
		    }
		    first=sum;
		}
		else if(v==btOnePlusXInverse)
		{
			double i,x,y,t=1,sum=1,sign=-1;
		    for(i=0;i<10;i++)
		    {
		        y=Math.pow(a,t);
		        sum=sum+sign*y;
		        t++;
		        sign=-1*sign;
		    }
		    first=sum;
		}
		else if(v==btXx)
		{
			first=Math.pow(a,2);
		}
		else if(v==btXxx)
		{
			first=Math.pow(a,3);
		}
		else if(v==btEtoThePowX)
		{
			first=Math.exp(a);
		}
		else if(v==btEtoThePowXMinusOne)
		{
			first=Math.exp(a)-1;
		}
		else if(v==btFact)
		{
			double d=1;
			for(int i=1;i<=(int)a;i++)
				d*=i;
			first=d;
		}
		else if(v==btLog)
		{
			first=Math.log10(a);
		}
		else if(v==btLog10)
		{
			first=Math.log10(a);
		}
		txt.setText(first+"");
		allClear=true;
		}
		catch(Exception ex)
		{
			
		}
	}
	
	public void numberClick(View v)
	{		
		try
		{
		if(multipleOpClick || equalClick)
			txt.setText("");
		if(equalClick)
			first=0.0;
		equalClick=false;
		if(v==btOne)
			txt.setText(txt.getText().toString()+1);
		else if(v==btTwo)
			txt.setText(txt.getText().toString()+2);
		else if(v==btThree)
			txt.setText(txt.getText().toString()+3);
		else if(v==btFour)
			txt.setText(txt.getText().toString()+4);
		else if(v==btFive)
			txt.setText(txt.getText().toString()+5);
		else if(v==btsix)
			txt.setText(txt.getText().toString()+6);
		else if(v==btSev)
			txt.setText(txt.getText().toString()+7);
		else if(v==btEight)
			txt.setText(txt.getText().toString()+8);
		else if(v==btNine)
			txt.setText(txt.getText().toString()+9);
		else if(v==btZero)
			txt.setText(txt.getText().toString()+0);
		else if(v==btDoubleZero)
			txt.setText(txt.getText().toString()+".");
		/*else if(v==btPi && txt.getText().equals(""))
			txt.setText(txt.getText().toString()+3.1416);*/
		equalClick=false;
		multipleOpClick=false;
		}
		catch(Exception ex)
		{
			
		}
	}
	
	public void operatorClick(View v)
	{
		try
		{
		if(multipleOpClick || txt.getText().equals(""))
			return;
		if(!operators.equals("#"))
		{
			first=multipleOperatorClick(Double.parseDouble(txt.getText().
					toString()));
			txt.setText(first+"");
		}
		else
		{
			first=Double.parseDouble(txt.getText().toString());
			txt.setText("");
		}
		multipleOpClick=true;
		equalClick=false;
		selectOPeratorFromButton(v);
		}
		catch(Exception ex)
		{
			
		}
	}
	
	public void equalClick(View v)
	{
		try
		{
		if(equalForTwoOperator())
			return;
		
		if(multipleOpClick || operators.equals("#") || txt.getText().equals(""))
		{
			txt.setText(first+"");
			return;
		}
		double temp=Double.parseDouble(txt.getText().toString());
		txt.setText(multipleOperatorClick(temp)+"");
		operators="#";
		multipleOpClick=false;
		equalClick=true;
		}
		catch(Exception ex)
		{
			
		}
		
	}
	
	boolean equalForTwoOperator()
	{
		try
		{
		if(txt.getText().equals(""))
		{
			makeFalseTwoOpneed();
			return true;
		}
		else if(xry)
		{
			first=Math.pow(second,(1/Double.parseDouble(txt.getText().toString())));
			xry=false;
			txt.setText(first+"");
			return true;
		}
		else if(xpow)
		{
			xpow=false;
			first=Math.pow(second, Double.parseDouble(txt.getText().toString()));
			txt.setText(first+"");
			return true;
		}
		else if(npr)
		{
			npr=false;
			first=nprValue(second,Double.parseDouble(txt.getText().toString()));
			txt.setText(first+"");
			return true;
		}
		else if(ncr)
		{
			ncr=false;
			first=ncrValue(second, Double.parseDouble(txt.getText().toString()));
			txt.setText(first+"");
			return true;
		}
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	double ncrValue(double n,double r)
	{
		int i,r1=1,r2=1,r3=1;
	    double r4;
	    for(i=1;i<=n;i++)
	    {
	        r1=r1*i;
	    }
	    for(i=1;i<=(n-r);i++)
	    {
	        r2=r2*i;
	    }
	    for(i=1;i<=r;i++)
	    {
	        r3=r3*i;
	    }
	    r4=r1/(r2*r3);
	    return r4;
	}
	double nprValue(double n,double r)
	{
		int i,r1=1,r2=1;
	    double r3;
	    for(i=1;i<=n;i++)
	    {
	        r1=r1*i;
	    }
	    for(i=1;i<=(n-r);i++)
	    {
	        r2=r2*i;
	    }
	    r3=r1/r2;
	    return r3;
	}
	public void acClick(View v)
	{
		txt.setText("");
		first=0.0;
		second=0.0;
		operators="#";
		makeFalseTwoOpneed();
	}
	public void delClick(View v)
	{
		if(txt.getText().equals(""))
			return;
		String temp=txt.getText().toString();
		temp=temp.substring(0, temp.length()-1);
		txt.setText(temp);
	}
	public double multipleOperatorClick(double temp)
	{
		double store=0.0;
		try
		{
			if(operators.equals("+"))
			{
				store=first+temp;
			}
			else if(operators.equals("-"))
			{
				store=first-temp;
			}
			else if(operators.equals("*"))
			{
				store=first*temp;
			}
			else if(operators.equals("/"))
			{
				store=first/temp;
			}
			else if(operators.equals("%"))
			{
				store=first%temp;
			}
		}
		catch(Exception ex)
		{
			Toast.makeText(Scientific.this, "Math error...", Toast.LENGTH_LONG).show();
		}
		return store;
	}
	public void selectOPeratorFromButton(View v)
	{
		if(v==btPlus)
		{			
			operators="+";
		}
		else if(v==btMinus)
		{
			operators="-";
		}
		else if(v==btMul)
		{
			operators="*";
		}
		else if(v==btdiv)
		{
			operators="/";
		}
		else if(v==btMod)
		{
			operators="%";
		}
	}
	void makeFalseTwoOpneed()
	{
		ncr=false;
		npr=false;
		xpow=false;
		xry=false;
	}
}
