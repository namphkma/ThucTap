package com.thuctap.api.controller;

import com.thuctap.api.service.dto.TemplateDto;
import com.thuctap.api.exception.BadRequestException;
import com.thuctap.api.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ValidateRest {
    @Autowired
    private ValidateService validateService;

    @PostMapping("/template")
    public ResponseEntity<TemplateDto> createTemplate(@RequestBody TemplateDto templateDto) {
        return new ResponseEntity(validateService.insertTemplate(templateDto),HttpStatus.CREATED);
    }
}
