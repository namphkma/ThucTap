package com.thuctap.api.service;

import com.thuctap.api.exception.BadRequestException;
import com.thuctap.api.service.dto.TemplateDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TemplateDtoTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test(expected = BadRequestException.class)
    public void validateUser_Null_throwBadRequestException(){
        TemplateDto templateDto = new TemplateDto();
        try {
            templateDto.validate();
        }catch (BadRequestException e){
            String message = "Owner cannot be null";
            assertEquals(message, e.getMessage());
            throw e;
        }
    }
}
