package indirCommDetection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class JMSPatternHandler {
	private List<String> createProducerPatterns;
	private List<String> createReceiverPatterns;
	private List<LookUpPattern> lookupPatterns;
	private List<Integer>groupNrinLupPatterns;
	
	JMSPatternHandler() {
		createProducerPatterns = new ArrayList<>();
		createReceiverPatterns = new ArrayList<>();
		lookupPatterns = new ArrayList<>();
		groupNrinLupPatterns = new ArrayList<>();
		
		createProducerPatterns.add("(.+) = (.+).createProducer\\\\((.+)\\\\)");
		createReceiverPatterns.add("(.+) = (.+).createConsumer\\\\((.+)\\\\)");
		//lookupPatterns.add(Pattern.compile("Queue \"+dest_var_name+\" = \\\\(Queue\\\\) (.+).lookup\\\\(\\\"(.+)\\\"\\\\)"));
		lookupPatterns.add(new LookUpPattern("Queue( *)", "( *)=( *)\\\\(Queue\\\\)( *)(.+).lookup\\\\(\\\"(.+)\\\"\\\\)"));
		groupNrinLupPatterns.add(6);
		lookupPatterns.add(new LookUpPattern("Destination( *)","( *)=( *)(.+).createQueue\\(\\\"(.+)\\\"\\)"));
		groupNrinLupPatterns.add(5);
	}
	
	List<Pattern> getCreateProducerPatterns() {
		if (createProducerPatterns.isEmpty() == false)
		{
			List<Pattern> pattern = new ArrayList<Pattern>();
			
			ListIterator<String> litr= createProducerPatterns.listIterator();
		    
		    while(litr.hasNext()){
		    	pattern.add(Pattern.compile(litr.next()));
		    }
		    
		    return pattern;
		} else {
			// TODO dsg8fe Exception
			return null;
		}	
	}
	
	List<Pattern> getCreateReceiverPatterns() {
		if (createProducerPatterns.isEmpty() == false)
		{
			List<Pattern> pattern = new ArrayList<Pattern>();
			
			ListIterator<String> litr = createReceiverPatterns.listIterator();
		    
		    while(litr.hasNext()){
		    	pattern.add(Pattern.compile(litr.next()));
		    }
		    
		    return pattern;
		} else {
			// TODO dsg8fe Exception
			return null;
		}	
	}

	List<Pattern> getLookupPattern(String destination) {
		
		if (!lookupPatterns.isEmpty()) {
			List<Pattern> pattern = new ArrayList<Pattern>();
						
			ListIterator<LookUpPattern> litr = lookupPatterns.listIterator();
		    
		    while(litr.hasNext()){
		    	LookUpPattern aPattern = litr.next();
		    	pattern.add(Pattern.compile(aPattern.firstPart + destination + aPattern.secoundPart));
		    }
			
			return pattern;
		} else {
			// TODO dsg8fe Exception
			return null;
		}
	}
	
	List<Integer> getGroupNrForLookupPattern(){
		return groupNrinLupPatterns;
	}
	
	protected class LookUpPattern {
		protected String firstPart;
		protected String secoundPart;
		
		LookUpPattern(String firstPart, String secoundPart) {
			this.firstPart = firstPart;
			this.secoundPart = secoundPart;
		}
	}
}
