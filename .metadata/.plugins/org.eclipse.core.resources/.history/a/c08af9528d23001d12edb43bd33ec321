package cs.yagozk.calculator.impl;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import cs.yagozk.calculator.Calculator;
import org.osgi.service.component.annotations.Component;

@Component
public class CalculatorMethods implements Calculator {
	
    List<String> trWordList = Arrays.asList
    	    (
    	    "sıfır","bir","iki","üç","dört","beş","altı","yedi",
    	    "sekiz","dokuz","on","yirmi",
    	    "otuz","kırk","elli","altmış","yetmiş","seksen","doksan",
    	    "yüz","bin","milyon","milyar","trilyon", "katrilyon", "kentilyon",
    	    "sekstilyon", "septilyon", "oktilyon", "nonilyon" , "desilyon", "eksi"
    	    );
    List<String> engWordList = Arrays.asList
    	    (
    	    "zero","one","two","three","four","five","six","seven",
    	    "eight","nine","ten","eleven","twelve","thirteen","fourteen",
    	    "fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
    	    "thirty","forty","fifty","sixty","seventy","eighty","ninety",
    	    "hundred","thousand","million","billion","trillion", "quadrillion", "quintillion",
    	    "sextillion", "septillion", "octillion", "nonillion" , "decillion", "minus"
    	    );

	
	@Override
	public BigInteger add(BigInteger num1, BigInteger num2) {
		return num1.add(num2);
	}

	@Override
	public BigInteger sub(BigInteger num1, BigInteger num2) {
		return num1.subtract(num2);
	}

	@Override
	public BigInteger mul(BigInteger num1, BigInteger num2) {
		return num1.multiply(num2);
	}

	@Override
	public BigInteger div(BigInteger num1, BigInteger num2) {
		if ( num2 != BigInteger.ZERO )
			return num1.divide( num2);
		else
			return null;
	}

	@Override
	public BigInteger translateFromTr(String trInput) {

	    BigInteger tempResult = BigInteger.ZERO;
	    BigInteger finalResult = BigInteger.ZERO;
	    boolean inputValid = true;
	    boolean resultNegative = false;
	    
	    if ( trInput != null && trInput.length() > 0 ) {
	    	// Replace "and" and "-" for a whitespace
	    	trInput = trInput.replaceAll("-", " ");
	    	trInput = trInput.toLowerCase().replaceAll( " and", " ");
	    	//Split the input into an array, separated by whitespace
	    	String[] splittedArr = trInput.trim().split("\\s+");
	    	
	    	if ( splittedArr[0].equalsIgnoreCase("eksi") )
	    		resultNegative = true;

	    	
	    	// Check if the input has any invalid words
	    	for ( int i = 0; i < splittedArr.length; i++ ) {
	    		String s = splittedArr[i];
	    		if ( !trWordList.contains(s) ) {
	    			inputValid = false;
	    			return null;
	    		}
	    		if ( s.equals("eksi") && i != 0 ) {
	    			inputValid = false;
	    			return null;
	    		}

	    	}
	    	
	    	// if the input is valid, iterate through the input and form the final result as a BigInt
	    	if ( inputValid ) {
	    		for ( int i = 0; i < splittedArr.length; i++ ) {
	    			String str = splittedArr[i];
	    			
	    			if ( str.equals("eksi")) {
	    				continue;
	    			}
	    			
	    			// Handling error cases for numbers smaller than 10
	    			if ( trWordList.indexOf( str) < 10 ) {
	    				if ( i + 1 < splittedArr.length && trWordList.indexOf( splittedArr[i+1]) < 19 ) {
	    					return null;
	    				}
	    			}
	    			// Handling error cases for numbers between 10-100
	    			if ( trWordList.indexOf( str) >= 10 && trWordList.indexOf( str) < 19 ) {
	    				if ( i + 1 < splittedArr.length && trWordList.indexOf( splittedArr[i+1]) <= 19 &&
	    					trWordList.indexOf( splittedArr[i+1]) >= 10 ) {
	    					return null;
	    				}
	    			}
	    			if ( trWordList.indexOf( str) == 19 && i + 1 < splittedArr.length && trWordList.indexOf( splittedArr[i+1]) == 19 )
	    				return null;
	    			
	    			// Handling error cases for numbers larger than 100
	    			if ( trWordList.indexOf( str) > 19 ) {
	    				for ( int index = i + 1; index < splittedArr.length; index++ ) {
	    					if ( trWordList.indexOf( splittedArr[index]) >= trWordList.indexOf( str) ) {
	    						return null;
	    					}
	    				}
	    			}

	    			
	                if(str.equalsIgnoreCase("sıfır")) 
	                	tempResult = tempResult.add(BigInteger.ZERO);
	                else if(str.equalsIgnoreCase("bir"))
	                	tempResult = tempResult.add(BigInteger.valueOf(1));
	                else if(str.equalsIgnoreCase("iki"))
	                	tempResult = tempResult.add(BigInteger.valueOf(2));
	                else if(str.equalsIgnoreCase("üç"))
	                	tempResult = tempResult.add(BigInteger.valueOf(3));
	                else if(str.equalsIgnoreCase("dört"))
	                	tempResult = tempResult.add(BigInteger.valueOf(4));
	                else if(str.equalsIgnoreCase("beş"))
	                	tempResult = tempResult.add(BigInteger.valueOf(5));
	                else if(str.equalsIgnoreCase("altı"))
	                	tempResult = tempResult.add(BigInteger.valueOf(6));
	                else if(str.equalsIgnoreCase("yedi"))
	                	tempResult =  tempResult.add(BigInteger.valueOf(7));
	                else if(str.equalsIgnoreCase("sekiz"))
	                	tempResult = tempResult.add(BigInteger.valueOf(8));
	                else if(str.equalsIgnoreCase("dokuz"))
	                	tempResult = tempResult.add(BigInteger.valueOf(9));
	                else if(str.equalsIgnoreCase("on"))
	                	tempResult = tempResult.add(BigInteger.valueOf(10));
	                	               
	                else if(str.equalsIgnoreCase("yirmi"))
	                	tempResult = tempResult.add(BigInteger.valueOf(20));
	                else if(str.equalsIgnoreCase("otuz"))
	                	tempResult = tempResult.add(BigInteger.valueOf(30));
	                else if(str.equalsIgnoreCase("kırk"))
	                	tempResult = tempResult.add(BigInteger.valueOf(40));
	                else if(str.equalsIgnoreCase("elli"))
	                	tempResult = tempResult.add(BigInteger.valueOf(50));
	                else if(str.equalsIgnoreCase("altmış"))
	                	tempResult = tempResult.add(BigInteger.valueOf(60));
	                else if(str.equalsIgnoreCase("yetmiş"))
	                	tempResult = tempResult.add(BigInteger.valueOf(70));
	                else if(str.equalsIgnoreCase("seksen"))
	                	tempResult = tempResult.add(BigInteger.valueOf(80));
	                else if(str.equalsIgnoreCase("doksan"))
	                	tempResult = tempResult.add(BigInteger.valueOf(90));
	                
	                if ( tempResult.equals( BigInteger.ZERO ) && !str.equalsIgnoreCase( "sıfır") && !str.equalsIgnoreCase( "yüz") && 
	                		!str.equalsIgnoreCase( "bin") )
	                	return null;
	                
	                else if(str.equalsIgnoreCase("yüz")) {
	                	if ( tempResult.equals(BigInteger.ZERO) ) {
	                		tempResult = BigInteger.ONE;
	                		
	                	}
	                	tempResult = tempResult.multiply(BigInteger.valueOf(100));
	                }
	                else if(str.equalsIgnoreCase("bin")) {
	                	if ( tempResult.equals(BigInteger.ZERO) ) {
	                		tempResult = BigInteger.ONE;
	                	}
	                	tempResult = tempResult.multiply( new BigInteger("1000"));
	                    finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                	                
	                else if(str.equalsIgnoreCase("milyon")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("milyar")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("trilyon")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("katrilyon")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("kentilyon")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("sekstilyon")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("septilyon")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("oktilyon")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("nonilyon")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("desilyon")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000000000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }

	    		}
	    		
	    		finalResult = finalResult.add(tempResult);
	    		tempResult = BigInteger.ZERO;
	    		
	    	}
	    	
	    }
	    
	    if ( resultNegative)
	    	return finalResult.negate();
		return finalResult;
	}

	@Override
	public BigInteger translateFromEng(String engInput) {
	    BigInteger tempResult = BigInteger.ZERO;
	    BigInteger finalResult = BigInteger.ZERO;
	    boolean inputValid = true;
	    boolean resultNegative = false;
	    
	    if ( engInput != null && engInput.length() > 0 ) {
	    	// Replace "and" and "-" for a whitespace
	        engInput = engInput.replaceAll("-", " ");
	    	engInput = engInput.toLowerCase().replaceAll( " and", " ");
	    		    	
	    	//Split the input into an array, separated by whitespace
	    	String[] splittedArr = engInput.trim().split("\\s+");
	    	
	    	if ( splittedArr[0].equalsIgnoreCase("minus") )
	    		resultNegative = true;
	    	
	    	// Check if the input has any invalid words
	    	for ( int i = 0; i < splittedArr.length; i++ ) {
	    		String s = splittedArr[i];
	    		if ( !engWordList.contains(s) ) {
	    			inputValid = false;
	    			return null;
	    		}
	    		if ( s.equals("minus") && i != 0 ) {
	    			inputValid = false;
	    			return null;
	    		}
	    	}
	    	
	    	// if the input is valid, iterate through the input and form the final result as a BigInt
	    	if ( inputValid ) {
	    		for ( int i = 0; i < splittedArr.length; i++ ) {
	    			String str = splittedArr[i];
	    			
	    			if ( str.equals( "minus"))
	    				continue;
	    			
	    			// Handling error cases for numbers smaller than 20
	    			if ( engWordList.indexOf( str) < 20 ) {
	    				if ( i + 1 < splittedArr.length && engWordList.indexOf( splittedArr[i+1]) < 28 ) {
	    					return null;
	    				}
	    			}
	    			// Handling error cases for numbers between 20-100
	    			if ( engWordList.indexOf( str) >= 20 && engWordList.indexOf( str) < 28 ) {
	    				if ( i + 1 < splittedArr.length && engWordList.indexOf( splittedArr[i+1]) <= 28 &&
	    					engWordList.indexOf( splittedArr[i+1]) >= 10 ) {
	    					return null;
	    				}
	    			}
	    			// Handling error cases for numbers larger than 100
	    			if ( engWordList.indexOf( str) > 28 ) {
	    				for ( int index = i + 1; index < splittedArr.length; index++ ) {
	    					if ( engWordList.indexOf( splittedArr[index]) >= engWordList.indexOf( str) ) {
	    						return null;
	    					}
	    				}
	    			}
	    			
	    			
	                if(str.equalsIgnoreCase("zero"))
	                	tempResult = tempResult.add(BigInteger.ZERO);
	                else if(str.equalsIgnoreCase("one"))
	                	tempResult = tempResult.add(BigInteger.valueOf(1));
	                else if(str.equalsIgnoreCase("two"))
	                	tempResult = tempResult.add(BigInteger.valueOf(2));
	                else if(str.equalsIgnoreCase("three"))
	                	tempResult = tempResult.add(BigInteger.valueOf(3));
	                else if(str.equalsIgnoreCase("four"))
	                	tempResult = tempResult.add(BigInteger.valueOf(4));
	                else if(str.equalsIgnoreCase("five"))
	                	tempResult = tempResult.add(BigInteger.valueOf(5));
	                else if(str.equalsIgnoreCase("six"))
	                	tempResult = tempResult.add(BigInteger.valueOf(6));
	                else if(str.equalsIgnoreCase("seven"))
	                	tempResult =  tempResult.add(BigInteger.valueOf(7));
	                else if(str.equalsIgnoreCase("eight"))
	                	tempResult = tempResult.add(BigInteger.valueOf(8));
	                else if(str.equalsIgnoreCase("nine"))
	                	tempResult = tempResult.add(BigInteger.valueOf(9));
	                else if(str.equalsIgnoreCase("ten"))
	                	tempResult = tempResult.add(BigInteger.valueOf(10));
	                
	                else if(str.equalsIgnoreCase("eleven"))
	                	tempResult = tempResult.add(BigInteger.valueOf(11));
	                else if(str.equalsIgnoreCase("twelve"))
	                	tempResult = tempResult.add(BigInteger.valueOf(12));
	                else if(str.equalsIgnoreCase("thirteen"))
	                	tempResult = tempResult.add(BigInteger.valueOf(13));
	                else if(str.equalsIgnoreCase("fourteen"))
	                	tempResult = tempResult.add(BigInteger.valueOf(14));
	                else if(str.equalsIgnoreCase("fifteen"))
	                	tempResult = tempResult.add(BigInteger.valueOf(15));
	                else if(str.equalsIgnoreCase("sixteen"))
	                	tempResult = tempResult.add(BigInteger.valueOf(16));
	                else if(str.equalsIgnoreCase("seventeen"))
	                	tempResult = tempResult.add(BigInteger.valueOf(17));
	                else if(str.equalsIgnoreCase("eighteen"))
	                	tempResult = tempResult.add(BigInteger.valueOf(18));
	                else if(str.equalsIgnoreCase("nineteen"))
	                	tempResult = tempResult.add(BigInteger.valueOf(19));
	               
	                else if(str.equalsIgnoreCase("twenty"))
	                	tempResult = tempResult.add(BigInteger.valueOf(20));
	                else if(str.equalsIgnoreCase("thirty"))
	                	tempResult = tempResult.add(BigInteger.valueOf(30));
	                else if(str.equalsIgnoreCase("forty"))
	                	tempResult = tempResult.add(BigInteger.valueOf(40));
	                else if(str.equalsIgnoreCase("fifty"))
	                	tempResult = tempResult.add(BigInteger.valueOf(50));
	                else if(str.equalsIgnoreCase("sixty"))
	                	tempResult = tempResult.add(BigInteger.valueOf(60));
	                else if(str.equalsIgnoreCase("seventy"))
	                	tempResult = tempResult.add(BigInteger.valueOf(70));
	                else if(str.equalsIgnoreCase("eighty"))
	                	tempResult = tempResult.add(BigInteger.valueOf(80));
	                else if(str.equalsIgnoreCase("ninety"))
	                	tempResult = tempResult.add(BigInteger.valueOf(90));
	                
	                if ( tempResult.equals( BigInteger.ZERO) && !str.equalsIgnoreCase("zero")) {
	                	return null;
	                }
	                
	                else if(str.equalsIgnoreCase("hundred"))
	                	tempResult = tempResult.multiply(BigInteger.valueOf(100));
	                else if(str.equalsIgnoreCase("thousand")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000"));
	                    finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("million")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("billion")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("trillion")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("quadrillion")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("quintillion")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("sextillion")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("septillion")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("octillion")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	                else if(str.equalsIgnoreCase("nonillion")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }	                
	                else if(str.equalsIgnoreCase("decillion")) {
	                	tempResult = tempResult.multiply( new BigInteger("1000000000000000000000000000000000"));
	                	finalResult = finalResult.add(tempResult);
	                    tempResult = BigInteger.ZERO;
	                }
	    		}
	    		
	    		finalResult = finalResult.add(tempResult);
	    		tempResult = BigInteger.ZERO;
	    		
	    	}
	    	
	    }
	    
	    if ( resultNegative)
	    	return finalResult.negate();
		return finalResult;
	}

	@Override
	public String translateToTr( BigInteger num) {
		String result = "";
		
		if ( num.compareTo( new BigInteger("1000000000000000000000000000000000")) > 0) {
			return "Hata: Sonuç, maksimum sınırı geçiyor";
		}
		
		else if ( num.equals( new BigInteger("1000000000000000000000000000000000") ))
			return "bir desilyon";
		
		if ( num.equals(BigInteger.ZERO) ) {
			return "sıfır";
		}
		String numStr = num.toString();
		
		String mask = "000000000000000000000000000000000";
		DecimalFormat form = new DecimalFormat(mask);
		numStr = form.format( num);
		
		int nonilyonlar = Integer.parseInt( numStr.substring(0,3));
		int oktilyonlar = Integer.parseInt( numStr.substring(3,6));
		int septilyonlar = Integer.parseInt( numStr.substring(6,9));
		int sekstilyonlar = Integer.parseInt( numStr.substring(9,12));
		int kentilyonlar = Integer.parseInt( numStr.substring(12,15));
		int katrilyonlar = Integer.parseInt( numStr.substring(15,18));
		int trilyonlar = Integer.parseInt( numStr.substring(18,21));
		int milyarlar = Integer.parseInt( numStr.substring(21,24));
		int milyonlar = Integer.parseInt( numStr.substring(24,27));
		int yüzbinler = Integer.parseInt( numStr.substring(27,30));
		int binler = Integer.parseInt( numStr.substring(30,33));

		String strTemp;
		if ( nonilyonlar == 0) {
			strTemp = "";
		}
		else {
			strTemp = translateSmallTr( nonilyonlar) + " nonilyon ";
		}
		result = strTemp;
		
		if ( oktilyonlar == 0) {
			strTemp = "";
		}
		else {
			strTemp = translateSmallTr( oktilyonlar) + " oktilyon ";
		}
		result = result + strTemp;
		
		if ( septilyonlar == 0) {
			strTemp = "";
		}
		else {
			strTemp = translateSmallTr( septilyonlar) + " septilyon ";
		}
		result = result + strTemp;
		
		if ( sekstilyonlar == 0) {
			strTemp = "";
		}
		else {
			strTemp = translateSmallTr( sekstilyonlar) + " sekstilyon ";
		}
		result = result + strTemp;

		if ( kentilyonlar == 0) {
			strTemp = "";
		}
		else {
			strTemp = translateSmallTr( kentilyonlar) + " kentilyon ";
		}
		result = result + strTemp;

		if ( katrilyonlar == 0) {
			strTemp = "";
		}
		else {
			strTemp = translateSmallTr( katrilyonlar) + " katrilyon ";
		}
		
		result = result + strTemp;
		if ( trilyonlar == 0) {
			strTemp = "";
		}
		else {
			strTemp = translateSmallTr( trilyonlar) + " trilyon ";
		}
		result = result + strTemp;
		
		if ( milyarlar == 0) {
			strTemp = "";
		}
		else {
			strTemp = translateSmallTr( milyarlar) + " milyar ";
		}
		result = result + strTemp;

		if ( milyonlar == 0) {
			strTemp = "";
		}
		else {
			strTemp = translateSmallTr( milyonlar) + " milyon ";
		}
		result = result + strTemp;

		if ( yüzbinler == 0) {
			strTemp = "";
		}
		else {
			strTemp = translateSmallTr( yüzbinler) + " bin ";
		}
		result = result + strTemp;
		
		strTemp = translateSmallTr( binler);
		result = result + strTemp;

		return replaceHelper(result).replaceAll("  ", " ");
	}

	@Override
	public String translateToEng( BigInteger num) {
		
		String result = "";
		
		if ( num.compareTo( new BigInteger("1000000000000000000000000000000000")) > 0) {
			return "Error: Number out of bounds";
		}
		
		if ( num.equals(BigInteger.ZERO) ) {
			return "zero";
		}
		
		else if ( num.equals( new BigInteger("1000000000000000000000000000000000") ))
			return "one decillion";
		
		String numStr = num.toString();

		String mask = "000000000000000000000000000000000";
		DecimalFormat form = new DecimalFormat(mask);
		numStr = form.format( num);
		
		int nonillions = Integer.parseInt( numStr.substring(0,3));
		int octillions = Integer.parseInt( numStr.substring(3,6));
		int septillions = Integer.parseInt( numStr.substring(6,9));
		int sextillions = Integer.parseInt( numStr.substring(9,12));
		int quintillions = Integer.parseInt( numStr.substring(12,15));
		int quadrillions = Integer.parseInt( numStr.substring(15,18));
		int trillions = Integer.parseInt( numStr.substring(18,21));
		int billions = Integer.parseInt( numStr.substring(21,24));
		int millions = Integer.parseInt( numStr.substring(24,27));
		int hundredThousands = Integer.parseInt( numStr.substring(27,30));
		int thousands = Integer.parseInt( numStr.substring(30,33));
		
		String strNon;
		if ( nonillions == 0) {
			strNon = "";
		}
		else {
			strNon = translateSmallEng( nonillions) + " nonillion ";
		}
		result = strNon;
		
		String strOct;
		if ( octillions == 0) {
			strOct = "";
		}
		else {
			strOct = translateSmallEng( octillions) + " octillion ";
		}
		result = result + strOct;
		
		String strSept;
		if ( septillions == 0) {
			strSept = "";
		}
		else {
			strSept = translateSmallEng( septillions) + " septillion ";
		}
		result = result + strSept;
		
		String strSext;
		if ( sextillions == 0) {
			strSext = "";
		}
		else {
			strSext = translateSmallEng( sextillions) + " sextillion ";
		}
		result = result + strSext;
		
		String strQuin;
		if ( quintillions == 0) {
			strQuin = "";
		}
		else {
			strQuin = translateSmallEng( quintillions) + " quintillion ";
		}
		result = result + strQuin;

		String strQuad;
		if ( quadrillions == 0) {
			strQuad = "";
		}
		else {
			strQuad = translateSmallEng( quadrillions) + " quadrillion ";
		}
		result = result + strQuad;

		String strTril;
		if ( trillions == 0) {
			strTril = "";
		}
		else {
			strTril = translateSmallEng( trillions) + " trillion ";
		}
		result = result + strTril;

		String strBil;
		if ( billions == 0) {
			strBil = "";
		}
		else {
			strBil = translateSmallEng( billions) + " billion ";
		}
		result = result + strBil;
		
		String strMil;
		if ( millions == 0) {
			strMil = "";
		}
		else {
			strMil = translateSmallEng( millions) + " million ";
		}
		result = result + strMil;
		
		String strHundT;
		if ( hundredThousands == 0) {
			strHundT = "";
		}
		else {
			strHundT = translateSmallEng( hundredThousands) + " thousand ";
		}
		result = result + strHundT;

		String strTh;
		strTh = translateSmallEng( thousands);
		result = result + strTh;



		return result.replaceAll( "  ", " ");
	}
	
	/*
	 * Helper method to translate numbers less than 1000
	 */
	private String translateSmallEng( int number) {
		List<String> tens = Arrays.asList("", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety");
		
		String result;
		
		if ( number % 100 < 20 ) {
			result = engWordList.get( number % 100);
			number = number / 100;
		}
		else {
			result = engWordList.get( number % 10);
			number = number / 10;
			
			result = tens.get( number % 10) + " " + result;
			number = number / 10;
		}
		result = result.replaceAll( "zero", "");
		if ( number == 0 ) {
			return result;
		}
		
		result = engWordList.get( number) + " hundred " + result;
		
		return result;
		
	}
	
	/*
	 * Helper method to translate numbers less than 1000 (türkçe)
	 */
	private String translateSmallTr( int number) {
		List<String> onlar = Arrays.asList( "", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan");
		
		String result;
		
		if ( number % 100 < 10 ) {
			result = trWordList.get( number % 100);
			number = number / 100;
		}
		else {
			result = trWordList.get( number % 10);
			number = number / 10;
			
			result = onlar.get( number % 10) + " " + result;
			number = number / 10;
		}
		result = result.replaceAll( "sıfır", "");
		if ( number == 0 ) {
			return result;
		}
		
		result = trWordList.get( number) + " yüz " + result;
		return result;
		
	}
	
	private String replaceHelper( String result) {
		result = result.replaceAll( "yüz bir", "token1");
		result = result.replaceAll( "on bir", "token2");
		result = result.replaceAll( "yirmi bir", "token3");
		result = result.replaceAll( "otuz bir", "token4");
		result = result.replaceAll( "kırk bir", "token5");
		result = result.replaceAll( "elli bir", "token6");
		result = result.replaceAll( "altmış bir", "token7");
		result = result.replaceAll( "yetmiş bir", "token8");
		result = result.replaceAll( "seksen bir", "token9");
		result = result.replaceAll( "doksan bir", "token10");

		result = result.replaceAll( "bir bin", "bin");
		result = result.replaceAll( "bir yüz", "yüz");
		result = result.replaceAll( "bir on", "on");
		
		result = result.replaceAll( "token2", "on bir");
		result = result.replaceAll( "token1", "yüz bir");
		result = result.replaceAll( "token3" , "yirmi bir");
		result = result.replaceAll( "token4" , "otuz bir");
		result = result.replaceAll( "token5", "kırk bir");
		result = result.replaceAll( "token6", "elli bir");
		result = result.replaceAll( "token7", "altmış bir");
		result = result.replaceAll( "token8", "yetmiş bir");
		result = result.replaceAll( "token9", "seksen bir");
		result = result.replaceAll( "token10", "doksan bir");
		return result;
	}
}
