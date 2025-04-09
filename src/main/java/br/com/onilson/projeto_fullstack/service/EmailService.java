package br.com.onilson.projeto_fullstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String remetente;

    @Autowired
    private JavaMailSender javaMailSender;

    public String enviarEmailDestinatario(String destinarario, String assunto, String mensagem) {

        try {
            SimpleMailMessage smm = new SimpleMailMessage();
            smm.setFrom(remetente);
            smm.setTo(destinarario);
            smm.setSubject(assunto);
            smm.setText(mensagem);
            javaMailSender.send(smm);
            return "Email enviado";
        }catch (Exception e) {
            return "Erro ao enviar email " + e.getLocalizedMessage();
        }
    }
}
