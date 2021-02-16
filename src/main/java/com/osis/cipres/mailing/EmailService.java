package com.osis.cipres.mailing;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;

	@Autowired
	private Configuration config;

	public MailResponse sendEmail(MailRequest request, Map<String, Object> model) {
		MailResponse response = new MailResponse();
		MimeMessage message = sender.createMimeMessage();
		try {
			// set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			// add attachment
			// helper.addAttachment("logo.png", new ClassPathResource("logo.png"));

			Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			helper.setTo(request.getTo());
			helper.setText(html, true);
			helper.setSubject(request.getSubject());
			helper.setFrom(request.getFrom());
			sender.send(message);

			response.setMessage("mail send to : " + request.getTo());
			response.setStatus(Boolean.TRUE);

		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail Sending failure : "+e.getMessage());
			response.setStatus(Boolean.FALSE);
		}

		return response;
	}

	
	//******************************************Email Notification *****************************************//
//	@Autowired
//	private SendNotifRepository sendnotifRepository;
//	
//	public MailResponse sendEmail2( Map<String, Object> model,SendNotification paraEnvoie) {
//		MailResponse response = new MailResponse();
//		MimeMessage message = sender.createMimeMessage();
//		try {
//			// set mediaType
//			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//					StandardCharsets.UTF_8.name());
//			// add attachment
//			// helper.addAttachment("logo.png", new ClassPathResource("logo.png"));
//
//			Template t = config.getTemplate("email-template2.ftl");
//			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
//
//			helper.setTo(paraEnvoie.getReceiveUser().getEmail());
//			helper.setText(html, true);
//			helper.setSubject("Nouvel indicateur");
//			helper.setFrom("MadouMail");
//			sender.send(message);
//			System.out.println("***************************************************************************************************");
//			System.out.println("***************************************************************************************************");
//			System.out.println("***************************************************************************************************");
//			response.setMessage("mail send to : " + paraEnvoie.getReceiveUser().getEmail());
//			response.setStatus(Boolean.TRUE);
//
//		} catch (MessagingException | IOException | TemplateException e) {
//			response.setMessage("Mail Sending failure : "+e.getMessage());
//			response.setStatus(Boolean.FALSE);
//		}
//		
//		paraEnvoie.setStatuts(1);
//		sendnotifRepository.saveAndFlush(paraEnvoie);
//
//		return response;
//	}


}
