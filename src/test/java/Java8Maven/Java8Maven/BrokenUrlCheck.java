package Java8Maven.Java8Maven;

import java.net.HttpURLConnection;
import java.net.URL;

public class BrokenUrlCheck {

	public static Integer getResponseCode(String link) {
		URL url;
		HttpURLConnection con = null;
		Integer responseCode = 0;

		try {

			url = new URL(link);
			con = (HttpURLConnection) url.openConnection();
			responseCode = con.getResponseCode();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (con != null)
				con.disconnect();
		}
		return responseCode;
	}

	public static void main(String args[]) {

		BrokenUrlCheck brc = new BrokenUrlCheck();

		System.out.println(brc.getResponseCode("https://www.googlasdf.com/"));

	}
}
