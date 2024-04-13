package com.sinyak.ordercake.service.emailService;

import com.sinyak.ordercake.entity.Order;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
@PropertySource("classpath:application.properties")
@Service
public class EmailService {
   private final Environment environment;

    private final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender, Environment environment) {
        this.emailSender = emailSender;
        this.environment = environment;
    }


   public void sendSimpleEmail(String toAddress, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        emailSender.send(simpleMailMessage);
    }


    public void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setTo(toAddress);
        messageHelper.setSubject(subject);
        messageHelper.setText(message);
        FileSystemResource file = new FileSystemResource(ResourceUtils.getFile(attachment));
        messageHelper.addAttachment("Purchase Order", file);
        emailSender.send(mimeMessage);
    }

    public void sendMessageToAdmin(Order order){

        String address = environment.getProperty("es.address");
        String subjectOfMessage = "Новый заказ";
        StringBuilder message = new StringBuilder();
        message.append("Поступил новый заказ на торт: "+order.getCake().getNameCake()+"\n")
                        .append("Стоимость: "+order.getCost()+"\n")
                                .append("От: " + order.getClient().getSurName()+" "+order.getClient().getName()+"\n")
                                        .append("Номер телфона для связи: " + order.getClient().getPhone_number()+"\n")
                                                .append("Дата доставки: "+order.getDelivery().getDelivery_date()+"\n" )
                                                        .append("Адрес: улица"+order.getDelivery().getStreet()+" дом "+order.getDelivery().getHouse()
                                                        +" квартира "+order.getDelivery().getFlat()+"\n")
                                                                .append("Коментарий от клиента: "+order.getComment());
        sendSimpleEmail(address,subjectOfMessage,message.toString());
    }


    public void sendMessageToClientAfterOrdering(Order order){
        String address = order.getClient().getEmail();
        String subjectOfMessage = "Ваш заказ";
        StringBuilder message = new StringBuilder();
        message.append(order.getClient().getName()+ " благодарим вас за заказ. В скором времени с вами свяжется сотрудник для подтверждения заказа");
        sendSimpleEmail(address,subjectOfMessage,message.toString());
    }


}
