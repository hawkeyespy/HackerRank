package rc.ds.string;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

import rc.utils.IOUtils;

public class Matcher {

	public static void main(String[] args) {
		
//	Pattern pattern = Pattern.compile("(^((c|C)lass\\.).*)|(.*\\.(c|C)lass\\..*)");
//	ArrayList<String> arr = new ArrayList<String>();
//	arr.add("class");
//	arr.add(".class");
//	arr.add("class.");
//	arr.add(".class.");
//	arr.add("sign.class");
//	arr.add("sign.class.sign");
//	arr.add("sign.class.");
//	arr.add("class.sign");
//	arr.add(".class.sign");
//	
//	for(String st:arr)
//	{
//	System.out.println(pattern.matcher(st).matches()+" : "+st);
//	}
//	
//	System.out.println("-----------------------------------------------");
//	
//	pattern = Pattern.compile(".*?class");
//	for(String st:arr)
//	{
//	System.out.println(pattern.matcher(st).matches()+" : "+st);
//	}
	
	ArrayList<File> oldUnsignedFiles = new ArrayList<File>();
    listAllSubdirectoriesFiles(oldUnsignedFiles, new File("C:/CodeSigningBase/AppFiles"), 0);
    
    for (File file : oldUnsignedFiles)
    {
    	System.out.println(file.getAbsolutePath());
    }
    
    craeteDirectoryIfNotFound("C:/CodeSigningBase/AppFiles/1/3/4");
//	IOUtils.deleteEmptyDirecoriesRecursively(oldUnsignedFiles, new File("C:/CodeSigningBase/AppFiles"));
//		compileAndPrint();
	}
	
	private static void craeteDirectoryIfNotFound(String path) {
		File file = new File(path);
		if(!file.exists())
		{
			file.mkdirs();
		}
		
	}

	private static void listAllSubdirectoriesFiles(ArrayList<File> oldUnsignedFiles, File baseDir, int daysToRetain) {
    	
    	File[] files = baseDir.listFiles(new ExtensionAndAgeFileFilter("exe", daysToRetain));
    	    	
    	for (File file : files) {
            if (file.isFile()) {
            	oldUnsignedFiles.add(file);            
            } else if (file.isDirectory()) {
            	if(file.listFiles().length == 0)
            		{
            			oldUnsignedFiles.add(file);
            		}
            	listAllSubdirectoriesFiles(oldUnsignedFiles, file, daysToRetain);
            }
    	}
	}
	
	private static void compileAndPrint()
	{
		String nameString = "cglib-nodep-3.1.jar,commons-logging-1.1.3.jar,javax.mail.jar,spring-aop-4.1.2.RELEASE.jar,spring-beans-4.1.2.RELEASE.jar,spring-core-4.1.2.RELEASE.jar,spring-expression-4.1.2.RELEASE.jar,spring-oxm-4.1.2.RELEASE.jar,spring-test-4.1.2.RELEASE.jar,spring-instrument-4.1.2.RELEASE.jar,spring-instrument-tomcat-4.1.2.RELEASE.jar,spring-security-config-3.2.5.RELEASE.jar,spring-security-core-3.2.5.RELEASE.jar,spring-security-taglibs-3.2.5.RELEASE.jar,spring-security-web-3.2.5.RELEASE.jar,spring-web-4.1.2.RELEASE.jar,spring-webmvc-4.1.2.RELEASE.jar,spring-webmvc-portlet-4.1.2.RELEASE.jar,spring-context-4.1.2.RELEASE.jar,spring-context-support-4.1.2.RELEASE.jar";
		String regExString = "s.*?.jar,c.*?.jar";
		regExString = regExString.replace(",", "|");
		Pattern pattern = Pattern.compile(regExString);
		for(String fileName: nameString.split(","))
		{
			if(pattern.matcher(fileName).matches())
				{
				System.out.println(fileName);
				}
		}
	}
}
