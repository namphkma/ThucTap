package com.thuctap.api.service.dto;

import com.thuctap.api.exception.BadRequestException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateDto {


    private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
    private static final String PDF_PATTERN = "([^\\s]+(\\.(?i)(pdf))$)";

    private UserDto owner;

    private String termFile;
    private String policyFile;
    private String background;
    private String logo;
    private String desktopPreview;
    private String mobilePreview;


    public void validate(){

        validateUser();

        validatePDF();

        validateImage();
    }

    private void validateImage(){
        Boolean isBackgroundImage = isMatchPattern(IMAGE_PATTERN,background);
        if(!isBackgroundImage){
            throw new BadRequestException("Background is not image");
        }
        Boolean islogo = isMatchPattern(IMAGE_PATTERN,logo);
        if(!islogo){
            throw new BadRequestException("Logo is not image");
        }
        Boolean isDesktopPreview = isMatchPattern(IMAGE_PATTERN,desktopPreview);
        if(!isDesktopPreview){
            throw new BadRequestException("Desktop review is not image");
        }
        Boolean isMobilePreview = isMatchPattern(IMAGE_PATTERN,mobilePreview);
        if(!isMobilePreview){
            throw new BadRequestException("Mobile review is not image");
        }
    }

    private void validatePDF(){
        Boolean isTermFilePDF = isMatchPattern(PDF_PATTERN,termFile);
        if (!isTermFilePDF){
            throw  new BadRequestException("Term file is not pdf file");
        }
        Boolean isPolicyFilePDF = isMatchPattern(PDF_PATTERN,policyFile);
        if (!isPolicyFilePDF){
            throw  new BadRequestException("Policy file is not pdf file");
        }
    }
    private void validateUser(){
        if(Objects.isNull(owner)){
            throw  new BadRequestException("Owner cannot be null");
        }
        if(Objects.isNull(owner.getEmail())){
            throw  new BadRequestException(" Owner's Email cannot be null");
        }
        if(Objects.isNull(owner.getName())){
            throw  new BadRequestException("Owner's Name cannot be null");
        }

    }

    private Boolean isMatchPattern(String regex,String value){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

}
