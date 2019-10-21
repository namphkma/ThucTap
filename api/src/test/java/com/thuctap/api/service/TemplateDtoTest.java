package com.thuctap.api.service;

import com.thuctap.api.exception.BadRequestException;
import com.thuctap.api.service.dto.TemplateDto;
import com.thuctap.api.service.dto.UserDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TemplateDtoTest {

    @Test(expected = BadRequestException.class)
    public void validate_userNull_throwBadRequestException(){
        TemplateDto templateDto = new TemplateDto();
        try {
            templateDto.validate();
        }catch (BadRequestException e){
            String message = "Owner cannot be null";
            assertEquals(message, e.getMessage());
            throw e;
        }
    }

    @Test(expected = BadRequestException.class)
    public void validate_emailNull_throwBadRequestException(){
        TemplateDto templateDto = new TemplateDto();
        UserDto userDto = new UserDto();
        templateDto.setOwner(userDto);
        try {
            templateDto.validate();
        }catch (BadRequestException e){
            String message = "Owner's Email cannot be null";
            assertEquals(message, e.getMessage());
            throw e;
        }
    }

    @Test(expected = BadRequestException.class)
    public void validate_nameNull_throwBadRequestException(){
        TemplateDto templateDto = new TemplateDto();
        UserDto userDto = new UserDto();
        userDto.setEmail("nam@gmail.com");
        templateDto.setOwner(userDto);
        try {
            templateDto.validate();
        }catch (BadRequestException e){
            String message = "Owner's Name cannot be null";
            assertEquals(message, e.getMessage());
            throw e;
        }
    }

    @Test(expected = BadRequestException.class)
    public void validate_termUrlNotPFD_throwBadRequestException(){
        TemplateDto templateDto = new TemplateDto();
        UserDto userDto = new UserDto();
        userDto.setEmail("nam@gmail.com");
        userDto.setName("nam");
        templateDto.setOwner(userDto);
        templateDto.setTermFile("term.word");
        try {
            templateDto.validate();
        }catch (BadRequestException e){
            String message = "Term file is not pdf file";
            assertEquals(message, e.getMessage());
            throw e;
        }
    }

    @Test(expected = BadRequestException.class)
    public void validate_policyUrlNotPFD_throwBadRequestException(){
        TemplateDto templateDto = new TemplateDto();
        UserDto userDto = new UserDto();
        userDto.setEmail("nam@gmail.com");
        userDto.setName("nam");
        templateDto.setOwner(userDto);
        templateDto.setTermFile("http://localhost/term.pdf");
        templateDto.setPolicyFile("http://policy.word");
        try {
            templateDto.validate();
        }catch (BadRequestException e){
            String message = "Policy file is not pdf file";
            assertEquals(message, e.getMessage());
            throw e;
        }
    }

    @Test(expected = BadRequestException.class)
    public void validate_backgroundUrlNotimg_throwBadRequestException(){
        TemplateDto templateDto = new TemplateDto();
        UserDto userDto = new UserDto();
        userDto.setEmail("nam@gmail.com");
        userDto.setName("nam");
        templateDto.setOwner(userDto);
        templateDto.setTermFile("http://localhost/term.pdf");
        templateDto.setPolicyFile("http://localhost/policy.pdf");
        templateDto.setBackground("http://localhost/back-ground.pdf");
        try {
            templateDto.validate();
        }catch (BadRequestException e){
            String message = "Background is not image";
            assertEquals(message, e.getMessage());
            throw e;
        }
    }

    @Test(expected = BadRequestException.class)
    public void validate_logoUrlNotimg_throwBadRequestException(){
        TemplateDto templateDto = new TemplateDto();
        UserDto userDto = new UserDto();
        userDto.setEmail("nam@gmail.com");
        userDto.setName("nam");
        templateDto.setOwner(userDto);
        templateDto.setTermFile("http://localhost/term.pdf");
        templateDto.setPolicyFile("http://localhost/policy.pdf");
        templateDto.setBackground("http://localhost/back-ground.jpg");
        templateDto.setLogo("http://localhost/logo.pdf");
        try {
            templateDto.validate();
        }catch (BadRequestException e){
            String message = "Logo is not image";
            assertEquals(message, e.getMessage());
            throw e;
        }
    }

    @Test(expected = BadRequestException.class)
    public void validate_desktopReviewUrlNotimg_throwBadRequestException(){
        TemplateDto templateDto = new TemplateDto();
        UserDto userDto = new UserDto();
        userDto.setEmail("nam@gmail.com");
        userDto.setName("nam");
        templateDto.setOwner(userDto);
        templateDto.setTermFile("http://localhost/term.pdf");
        templateDto.setPolicyFile("http://localhost/policy.pdf");
        templateDto.setBackground("http://localhost/back-ground.jpg");
        templateDto.setLogo("http://localhost/logo.png");
        templateDto.setDesktopPreview("http://localhost/desktop.pdf");
        try {
            templateDto.validate();
        }catch (BadRequestException e){
            String message = "Desktop review is not image";
            assertEquals(message, e.getMessage());
            throw e;
        }
    }

    @Test(expected = BadRequestException.class)
    public void validate_mobileReviewUrlNotimg_throwBadRequestException(){
        TemplateDto templateDto = new TemplateDto();
        UserDto userDto = new UserDto();
        userDto.setEmail("nam@gmail.com");
        userDto.setName("nam");
        templateDto.setOwner(userDto);
        templateDto.setTermFile("http://localhost/term.pdf");
        templateDto.setPolicyFile("http://localhost/policy.pdf");
        templateDto.setBackground("http://localhost/back-ground.jpg");
        templateDto.setLogo("http://localhost/logo.png");
        templateDto.setDesktopPreview("http://localhost/desktop.jpg");
        templateDto.setMobilePreview("http://localhost/mobile.pdf");
        try {
            templateDto.validate();
        }catch (BadRequestException e){
            String message = "Mobile review is not image";
            assertEquals(message, e.getMessage());
            throw e;
        }
    }
    @Test
    public void validate(){
        TemplateDto templateDto = new TemplateDto();
        UserDto userDto = new UserDto();
        userDto.setEmail("nam@gmail.com");
        userDto.setName("nam");
        templateDto.setOwner(userDto);
        templateDto.setTermFile("http://localhost/term.pdf");
        templateDto.setPolicyFile("http://localhost/policy.pdf");
        templateDto.setBackground("http://localhost/back-ground.jpg");
        templateDto.setLogo("http://localhost/logo.png");
        templateDto.setDesktopPreview("http://localhost/desktop.jpg");
        templateDto.setMobilePreview("http://localhost/mobile.jpg");
        templateDto.validate();
    }
}
