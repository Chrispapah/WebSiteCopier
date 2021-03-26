import java.io.IOException;
public class Major {
	public String operation(String a) throws IOException {
		Web obj=new Web();
		a=obj.wget(a);
		return a;
	}

}
