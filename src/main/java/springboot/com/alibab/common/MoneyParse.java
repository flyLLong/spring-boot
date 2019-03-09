package springboot.com.alibab.common;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
		
public class MoneyParse {
	
	private static final List<String> cnNumber = 
										Arrays.asList("零","一","二","三","四","五","六","七","八","九");
	private static final int[]  arabNumber = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	public static void main(String[] args) {
		String money = "五百二十";
		System.out.println(numberParse(money));
	}
	
	private static BigDecimal numberParse(String number){
		double result = 0;
		
		int qianIndex = number.indexOf("千");
		if(qianIndex > 0){
			String qianNumber = number.substring(0, qianIndex);
			result += parseToArab(qianNumber, 1000);
			number = getRestNumber(number, qianIndex + 1, number.length());
		}
		
		int baiIndex = number.indexOf("百");
		if(baiIndex > 0){
			String baiNumber = number.substring(0, baiIndex);
			result += parseToArab(baiNumber, 100);
			number = getRestNumber(number, baiIndex + 1, number.length());
		}
		
		int shiIndex = number.indexOf("十");
		if(shiIndex > 0){
			String shiNumber = number.substring(0, shiIndex);
			result += parseToArab(shiNumber, 10);
			number = getRestNumber(number, shiIndex + 1, number.length());
		}
		
		result += parseToArab(number, 1);
		return new BigDecimal(result);
	}
	
	private static double parseToArab(String cnNum, int beishu){
		double d = 0;
		int index = cnNumber.indexOf(cnNum);
		if(index > 0){
			d += arabNumber[index] * beishu;
		}
		return d;
	}
	
	private static String getRestNumber(String number, int index, int length) {
		if(index >= length){
			return number;
		}
		return number.substring(index, length);
	}
}
