package uLogatti;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class testes1 {
public static void main(String[] args) throws IOException {
		
		Map<String, String> query = new HashMap<String, String>();
		
	/*	__VIEWSTATE:
	 * __EVENTVALIDATION:
	 *  
		
		*
		*/
		
		Document doc = Jsoup.connect("http://www.sectrainfo.com.br/web_logatti/Login.aspx")
				.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
			  	.timeout(0)
			  	.post();
		
		String viewState = doc.getElementById("__VIEWSTATE").val();
		String eventValidation = doc.getElementById("__EVENTVALIDATION").val();
				
		
		
		query.put("ctl00$MainContent$txtAluno","3313-387");
		query.put("ctl00$MainContent$txtSenha","403724");
		query.put("__VIEWSTATE",viewState);
		query.put("__EVENTVALIDATION",eventValidation);
		query.put("ctl00$MainContent$btnLogar","Entrar");
		
		doc = Jsoup.connect("http://www.sectrainfo.com.br/web_logatti/Login.aspx")
				.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
			//	.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
				.header("Accept-Encoding","gzip, deflate, sdch")
				.header("Accept-Language","en-US,en;q=0.8,es;q=0.6,pt;q=0.4")
				.header("Connection","keep-alive")
				.timeout(0)
			  	.data(query)
				.post();
		
		//Cookie:ASP.NET_SessionId=pbthzm2i0wcjgumh1meplus0; PHPSESSID=daptmjn159eljm8cne0jpc3mo5; alunoavaliacao=3313-381
	//	String cookie = doc.getElementById("Cookie").val();
		viewState = doc.getElementById("__VIEWSTATE").val();
	//	query.remove("__EVENTVALIDATION");
	//	query.remove("__VIEWSTATE");
	//	query.put("__VIEWSTATE",viewState);
		
		doc = Jsoup.connect("http://www.sectrainfo.com.br/web_logatti/DisciplinasMatriculadas.aspx")
				.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
				.header("Accept-Encoding","gzip, deflate, sdch")
				.header("Accept-Language","en-US,en;q=0.8,es;q=0.6,pt;q=0.4")
				.header("Connection","keep-alive")
				.header("Cookie","ASP.NET_SessionId=pbthzm2i0wcjgumh1meplus0; PHPSESSID=daptmjn159eljm8cne0jpc3mo5; alunoavaliacao=3313-381")
				.header("Host","www.sectrainfo.com.br")
				.header("Referer","http://www.sectrainfo.com.br/web_logatti/DadosCadastrais.aspx")
				.header("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36")
				.timeout(0)
			//	.data(query)
				.post();
	
		
		System.out.println(doc.toString());
		
		

		
	}

}
