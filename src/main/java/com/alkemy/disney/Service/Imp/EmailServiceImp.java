package com.alkemy.disney.Service.Imp;

import com.alkemy.disney.Exception.ParamNotFound;
import com.alkemy.disney.Service.EmailService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailServiceImp implements EmailService {

    @Value("${com.alkemy.disney.email.sender}")
    private String emailSender;

    @Value("${com.alkemy.disney.email.enabled}")
    private boolean enabled;
    private Environment env;
    private SendGrid sendGrid;

    @Autowired
    public EmailServiceImp(Environment env,
                            SendGrid sendGrid) {
        this.env = env;
        this.sendGrid = sendGrid;
    }

    @Override
    public void sendWelcomeEmailTo(String to) {
        if (!enabled) {
            return;
        }

        Email fromEmail = new Email(emailSender);
        Email toEmail = new Email(to);
        String subject = "Disney application";
        Content content = new Content(
                "text/plain",
                "Bienvenido/a a Disney Application"
        );
        Mail mail = new Mail(fromEmail, subject, toEmail, content);

        Request request = new Request();
        Response response = null;

        try {

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = this.sendGrid.api(request);

        } catch (IOException e) {
            throw new ParamNotFound("Error to send mail");
        }

    }
}
