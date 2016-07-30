package rc.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import rc.ds.string.ExtensionAndAgeFileFilter;

public class IOUtils {
	
	public static void copyFile(File src, File dsc)
	{
		BufferedInputStream bis = null;;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dsc));
			int bytesRead;
			byte []buffer = new byte[1024];
			while((bytesRead = bis.read(buffer)) != -1)
			{
				
			}
		}		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException ignore) {
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException ignore) {
                }
            }
        }
	}
	
	private static void listAllSubdirectoriesFiles(ArrayList<File> oldUnsignedFiles, File baseDir, String extension, double daysToRetain) {
    	
    	File[] files = baseDir.listFiles(new ExtensionAndAgeFileFilter(extension, daysToRetain));
    	
    	for (File file : files) {
            if (file.isFile()) {
            	oldUnsignedFiles.add(file);            
            } else if (file.isDirectory()) {
            	listAllSubdirectoriesFiles(oldUnsignedFiles, file, extension, daysToRetain);
            }
    	}
	}

public static void deleteEmptyDirecoriesRecursively(ArrayList<File> emptyDirectories, File baseDir) {
    	
    	File[] files = baseDir.listFiles();
    	
    	for (File file : files) {
             if (file.isDirectory()) {
            	 deleteEmptyDirecoriesRecursively(emptyDirectories, file);
            	 if(file.list().length == 0)
            	 {
            		 file.delete();
            	 }
            }
            
    	}
	}
public static void main(String[] args) {
	File dir = new File(" ");
	if(!dir.mkdirs())
	{
		
	}
	
}
}
