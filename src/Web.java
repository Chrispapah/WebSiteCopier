import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class Web{
	public String wget(String a) throws IOException {

        // Make a URL to the web page
        URL url = new URL(a);

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();


        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;

        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            a=a+line+"\n";
        }
        return a;
	}
}