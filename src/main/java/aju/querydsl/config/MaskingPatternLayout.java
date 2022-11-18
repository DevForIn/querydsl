package aju.querydsl.config;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class MaskingPatternLayout extends PatternLayout{
	
	private Pattern multilinePattern;
	private List<String> maskPatterns = new ArrayList<>();
	
	public void addMaskPattern(String maskPattern) {
		maskPatterns.add(maskPattern);		
		multilinePattern =
				Pattern.compile(maskPatterns.stream().collect(Collectors.joining("|")),Pattern.MULTILINE);
	}
	
	@Override
	public String doLayout(ILoggingEvent event) {
		return maskMessage(super.doLayout(event));
	}
	
	public String maskMessage(String message) {
		if(multilinePattern == null) {
			return message;
		}
		
		
		StringBuilder sb = new StringBuilder(message);
		Matcher matcher = multilinePattern.matcher(sb);
		
		while(matcher.find()){
//			System.out.println("while ->"+message);
//			System.out.println("matcher.group() -> " + matcher.group());
//			System.out.println("matcher.group().toString() -> "+matcher.group().toString());			
//			System.out.println("matcher.start() -> " + matcher.start());
//			System.out.println("matcher.end() ->" + matcher.end());

			String str = matcher.group().split(" ")[1];
			
			int paramLeng = str.length()+5;
			
			for(int i=matcher.start()+paramLeng;i<matcher.end()-2;i++) {
				sb.setCharAt(i, '*');	
			}
		}		
		return sb.toString();
	}	
}
