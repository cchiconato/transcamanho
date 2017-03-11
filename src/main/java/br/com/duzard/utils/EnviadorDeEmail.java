package br.com.duzard.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/enviaemail")
public class EnviadorDeEmail implements ServiceMap {

	@RequestMapping(path= "/{nome}/{emailDes}/{assunto}/{msg}",method = RequestMethod.POST)
	public void enviar(@PathVariable("nome") String nome, @PathVariable("emailDes") String emailDes,@PathVariable("assunto") String assunto,@PathVariable("msg") String msg) {
		  try {
	            Email email = new SimpleEmail();
	            email.setHostName("smtp.live.com");
	            email.setSmtpPort(587);
	            email.setAuthenticator(new DefaultAuthenticator("cc464@hotmail.com", "senha123?"));
	            email.setStartTLSEnabled(true);

	            email.setFrom(emailDes);
	            email.setSubject(assunto);
	            email.setMsg("De: "+emailDes+ "\n" + "Mensagem: " + msg);
	            email.addTo("transcamanho@hotmail.com");
	            email.send();

	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	}
}

