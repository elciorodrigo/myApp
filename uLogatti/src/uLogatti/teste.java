package uLogatti;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**@author
 * Elcio Rodrigo
 * 
 * /




public class teste {
	public static void main(String[] args) throws IOException {
		
		
		
		
		
		Connection.Response response = Jsoup.connect("http://www.sectrainfo.com.br/web_logatti/Login.aspx")
		        .method(Connection.Method.GET)
		        .execute();
		
		Document loginPage = response.parse();

		response = Jsoup.connect("http://www.sectrainfo.com.br/web_logatti/Login.aspx")
		 			//.data("ctl00$MainContent$txtAluno","3313-381")
			    	//.data("ctl00$MainContent$txtSenha","418088")
			      	//.data("ctl00$MainContent$txtAluno","3313-367")
			      	//.data("ctl00$MainContent$txtSenha","301192")
			        .data("ctl00$MainContent$txtAluno","3313-387")
			      	.data("ctl00$MainContent$txtSenha","403724")
			        .data("ctl00$MainContent$btnLogar","Entrar")
			        .data("__VIEWSTATE", loginPage.getElementById("__VIEWSTATE").val())
			        .data("__EVENTVALIDATION", loginPage.getElementById("__EVENTVALIDATION").val())
			        .cookies(response.cookies())
		        .method(Connection.Method.POST)
		        .execute();

		Document homePage = Jsoup.connect("http://www.sectrainfo.com.br/web_logatti/DisciplinasMatriculadas.aspx")
		       .cookies(response.cookies())
		        .get();
		
		//Document homePage = Jsoup.connect("http://www.sectrainfo.com.br/web_logatti/Historico.aspx")
		 //       .cookies(response.cookies())
		  //      .get();
		
		
		
		for(int i=0; i < homePage.getElementsByTag("td").size(); i++){
				
				if(homePage.getElementsByTag("td").get(i).text().equals("M")){
					System.out.println(homePage.getElementsByTag("td").get(i+2).text() + 
			     	" : " +homePage.getElementsByTag("td").get(i+3).text()+
					" : " + homePage.getElementsByTag("td").get(i+4).text()+
					" : " + homePage.getElementsByTag("td").get(i+5).text()+
					" : " + homePage.getElementsByTag("td").get(i+6).text());
				}
			
		}
		
	//System.out.println(homePage.toString());
		
	
		

		
	}
	
	
	
}
