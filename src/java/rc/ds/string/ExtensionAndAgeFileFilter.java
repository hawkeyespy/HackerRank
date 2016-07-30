package rc.ds.string;

import java.io.File;
import java.io.FileFilter;

public class ExtensionAndAgeFileFilter implements FileFilter {

    private static final double ONE_DAY_IN_MILLIS = 24*60*60*1000.0;

    private String extension;
    private double daysToRetain;

    public ExtensionAndAgeFileFilter(String extension, double daysToRetain) {
        this.extension = extension;
        this.daysToRetain = daysToRetain;
    }

    @Override
    public boolean accept(File file) {
        assert file != null;
        boolean isFile = file.isFile();
        boolean hasTargetExtension = file.getName().endsWith("."+extension);
        boolean isOld = ((double)((System.currentTimeMillis()-file.lastModified()))/ONE_DAY_IN_MILLIS > daysToRetain);
        return (hasTargetExtension||!isFile) && isOld;
    }

}
