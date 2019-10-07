package com.thuctap.api.service;

import com.thuctap.api.service.dto.TemplateDto;
import com.thuctap.api.exception.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class ValidateService {

    public TemplateDto insertTemplate(TemplateDto templateDto) throws BadRequestException {
        templateDto.validate();
        return templateDto;
    }
}
