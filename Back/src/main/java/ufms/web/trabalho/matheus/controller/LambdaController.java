package ufms.web.trabalho.matheus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ufms.web.trabalho.matheus.service.LambdaService;


@Controller
@RequestMapping("/api/lambda")
public class LambdaController {

    @Autowired
    private LambdaService lambdaService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscarPorId() {
        return new ResponseEntity(lambdaService.findAll(), HttpStatus.OK);
    }
}
