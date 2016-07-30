package rc.ds.string;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Util {

	public static void main(String[] args) {
		
		/*ZipFile zipFile = null;
		try {
			
			 zipFile = new ZipFile("C:/code/Engineering/lib/activation.jar");
			 ZipEntry ze = zipFile.getEntry("META-INF/MANIFEST.MF");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			closeStreamQuitely(zipFile);
		}*/
		
		String baseName = getBaseNameOfFile("web/context/spring-context-support-4.1.2.RELEASE.jar");
		System.out.println(baseName);
		
		System.out.println("web/context/spring-context-support-4.1.2.RELEASE.jar".substring(0, "web/context/spring-context-support-4.1.2.RELEASE.jar".lastIndexOf("/")));
		
		File file = new File("C:/CodeSigningBase/AppFiles/exe/sign/signtool_v7.exe");
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader(new File("catalina.properties")));
			System.out.println(prop.getProperty("package.access"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
     * Util methos for closing the stream
     * 
     * @param Stream
     * @author ravi_chandra
     */
    public static void closeStreamQuitely(Closeable Stream){
        try{
            if(Stream!=null)Stream.close();
            System.out.println("closing stream");
        }catch(IOException e){
            //ignore
        }
    }
    
    public static String getBaseNameOfFile(String fileName) {
        String baseName = "";
        if (fileName != null && fileName.length() > 0) {
            int lastSlash = fileName.lastIndexOf(File.separatorChar);
            if (lastSlash == (-1)) {
                baseName = fileName;
            } else if ((lastSlash+1) < fileName.length()) {
                baseName = fileName.substring(lastSlash+1);
            }
            int lastDot = baseName.lastIndexOf(".");
            if (lastDot != (-1)) {
                baseName = baseName.substring(0, lastDot);
            }
        }
        return baseName;
    }
    
    public static String replace(String s, String oldSubStr, String newSubStr){
        if (s == null || oldSubStr == null || newSubStr == null){
            return s;
        }

//        int charsCreated = 0;
        String newStr = "";
        int i;
        int L = oldSubStr.length();

        while ((i = s.indexOf(oldSubStr)) != -1){
            newStr = newStr + s.substring(0, i) + newSubStr;
//            charsCreated+= newStr.length();
//            System.out.println("charsCreated1: " + charsCreated);
            s = s.substring(i + L );
//            charsCreated+= s.length();
//            System.out.println("charsCreated1: " + charsCreated);

        }
        newStr = newStr + s;

        return newStr;
    }

}
