package cs.yagozk.calculator;

import java.math.BigInteger;

public interface Calculator {
	public BigInteger add( BigInteger num1, BigInteger num2);
	public BigInteger sub( BigInteger num1, BigInteger num2);
	public BigInteger mul( BigInteger num1, BigInteger num2);
	public BigInteger div( BigInteger num1, BigInteger num2);
	public BigInteger translateFromTr( String trInput);
	public BigInteger translateFromEng( String engInput);
	public String translateToTr( BigInteger num);
	public String translateToEng( BigInteger num);
}
