package com.bessaleks.internetprovider.servises;

public interface MailService {
    void send(String emailTo,String subject, String message);
}
