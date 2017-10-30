package HW3.HW3;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class BinarySearch {
	 public static final int NOT_FOUND = -1;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int binarySearch( Comparable [ ] list, Comparable x )
  {
      int first= 0,middle,last=list.length-1;
      while(last>=first )
      {
          middle = ( first + last ) / 2;
          if( list[ middle ].compareTo( x ) < 0 )
              first = middle + 1;
          else if( list[ middle ].compareTo( x ) > 0 )
              last = middle - 1;
          else
              return middle;
      }

      return NOT_FOUND;     
  }


public static void main(String[] args) throws Exception {
	
Options options = new Options();

Option inputtype = new Option("type", "inputtype", true, "type of the input");
options.addOption(inputtype);

Option key = new Option("key", "key", true, "element to be searched for");
options.addOption(key);

Option inputlist = new Option("list", "inputlist", true, "index of the element found");
options.addOption(inputlist);

CommandLineParser commandLineParser = new DefaultParser();

CommandLine commandLine;
try{
commandLine = commandLineParser.parse(options, args);

String inputoftype = commandLine.getOptionValue("inputtype");
String keyvalue = commandLine.getOptionValue("key");
String firstelement = commandLine.getOptionValue("inputlist");
List<String> list = commandLine.getArgList();


String [ ] a1 = new String [list.size()+1];
a1[0]=firstelement;
for (int i=1;i<list.size()+1;i++)
	  a1[i]=list.get(i-1);

if(inputoftype.compareTo("i")==0){
	int x=binarySearch(a1,keyvalue);
	if(x==-1)
		System.out.println("0");
	else
		System.out.println("1");
}
else if(inputoftype.compareTo("s")==0)
{
	int x1=binarySearch(a1,keyvalue);
	if(x1==-1)
	System.out.println("0");
else
	System.out.println("1");
	  
}
	}

catch( ParseException exp ) {
	    System.out.println( "Unexpected exception:" + exp.getMessage() );
	}



}

}
