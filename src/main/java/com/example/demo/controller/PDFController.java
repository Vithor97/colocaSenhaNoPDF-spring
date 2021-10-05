package com.example.demo.controller;

import com.example.demo.dto.PDFDto;
import com.example.demo.model.PDF;
import com.example.demo.service.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/pdf")
public class PDFController {

    @Autowired
    private PDFService pdfService;

    @RequestMapping("/")
    public String getName() {
        return "oi";
    }

    @RequestMapping(value = "/", consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.POST)
    public ResponseEntity<PDF> insereSenhaPDF(@RequestBody PDFDto pdfDto) throws IOException {

        PDF pdf = pdfService.gerarSenha(pdfDto);

        return new ResponseEntity<>(pdf, HttpStatus.OK);
    }

}
