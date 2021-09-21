import java.io.*;
import java.util.*;
import tracking.*;
import java.net.URL;

public class PackageTracker {
    public static void main(String[] args) throws IOException{
        // read from trackingNumbers.txt
        // create a myPackage object for each tracking number
        URL path = PackageTracker.class.getResource("trackingNumbers.txt");
        File file = new File(path.getFile());
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            List<myPackage> packages = new ArrayList<myPackage>();
            while ((line = br.readLine()) != null) {
                packages.add(new myPackage(line));
            }
            br.close();
            
            /*
            for (myPackage pkg : packages) {
                System.out.println(pkg.getTrackingNumber());
                System.out.println(pkg.getCarrier());
            }
            */
        }
        catch (FileNotFoundException ex) {
            System.out.println("You do not have a trackingNumbers.txt file.");
        }
    }
}