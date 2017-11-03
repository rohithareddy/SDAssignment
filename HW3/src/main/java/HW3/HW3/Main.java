package HW3.HW3;

import org.apache.commons.cli.*;


public class Main  {
	
	public static void main(String[] args) {
		int returnValue = -1;
		
		Options options = new Options();
		Option type = Option.builder("Type")
				.required()
				.longOpt("type")
				.desc("specifies the type of input: 'i' for integer and 's' for string")
				.hasArg()
				.argName("TYPE")
				.build();
		options.addOption( type );
		
		
		
		Option key = Option.builder("Key")
				.required()
				.longOpt("key")
				.desc("specifies the element to be searched in the list")
				.hasArg()
		    	.argName("KEY")
		    	.build();
		options.addOption( key );
		
		
		
		Option list = Option.builder("List")
				.required()
				.longOpt("list")
				.desc("specifies the list of sorted integer or strings")
				.hasArgs()
				.argName("LIST")
				.build();
		options.addOption( list );
		
		
		CommandLineParser parser = new DefaultParser();	
		try {	
		    
		    CommandLine line = parser.parse( options, args );
		    String inputType = line.getOptionValue("type");
		    String inputKey = line.getOptionValue("key");
		    String[] inputList = line.getOptionValues("list");
		    if (inputType.equalsIgnoreCase("i")) {
		    	
		    	try {											
		    		Integer keyValue=Integer.parseInt(inputKey);
			    	int length= inputList.length;
			    	Integer[] listCopy= new Integer[length];
		    		for (int i = 0; i < length; i++) {
		    			listCopy[i]=Integer.parseInt(inputList[i]); 
			    	}
		    		
			    	if (binSearch(listCopy,keyValue)){
			    		returnValue = 1;
			    	}
			    	else {
			    		returnValue = 0;
			    	}
		    	} 
		    	catch (NumberFormatException e) {
		    		    System.out.println("Only integers are allowed " + e);
		    		    System.out.println("Program Terminated");
		    		    System.exit(1);
		    	}
		    }
		    else if (inputType.equalsIgnoreCase("s")) {
		    	String keyValue=inputKey;
		    	String[] listCopy=inputList;
		    	if (binSearch(listCopy,keyValue)){
		    		returnValue = 1;
		    	}
		    	else {
		    		returnValue = 0;
		    	}
		    }
		    System.out.println(returnValue);				
		}
		catch( ParseException e ) {
		    System.out.println("Unexpected exception:" + e.getMessage());
		    System.out.println("Unable to parse command line.");
		}
		
	}
		
	private static <T extends Comparable<T>> boolean binSearch(T[] aList, T key) {
		int first = 0,last=aList.length-1,middle=((first+last)/2);
		T middleValue=aList[middle];
		while (first <= last) {			
			if(key.compareTo(middleValue)==0){
				return true;				
			}
			else if (key.compareTo(middleValue)<0){
				
				last = middle-1	;		
			}
			else if (key.compareTo(middleValue)>0){
				first = middle+1;		
				
			}
			middle=(first+last)/2;
			middleValue=aList[middle];
		}
		return false;
	}
}
