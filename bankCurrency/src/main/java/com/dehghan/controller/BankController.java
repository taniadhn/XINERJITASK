package com.dehghan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BankController {

    @GetMapping("/getCurrencies")
    public   List<Object> getAllCurrencies(@RequestParam String trxnDate) {


        RestTemplate restTemplate = new RestTemplate();
        URI xmlUrl;
        try {
            String dateString = "202302";
            SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyyMM");
            SimpleDateFormat outputFormatter = new SimpleDateFormat("ddMMyyyy");

            Date date = inputFormatter.parse(dateString);
            String formattedDate = outputFormatter.format(date);
            String url = "https://www.tcmb.gov.tr/kurlar/"+ trxnDate+"/"+ formattedDate + ".xml";
            xmlUrl=new URI(url);
            ResponseEntity<Object[]> responseString= restTemplate.getForEntity(xmlUrl, Object[].class);

            Object[] productsJson = responseString.getBody();

            List<Object> list= Arrays.asList(productsJson);
            return list;
        }catch (ResponseStatusException e){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No currency data found for the input date range.", e);
        } catch (Exception ex) {


        }
        return null;
    }


}
