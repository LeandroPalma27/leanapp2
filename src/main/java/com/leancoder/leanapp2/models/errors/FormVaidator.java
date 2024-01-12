package com.leancoder.leanapp2.models.errors;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.springframework.web.context.annotation.RequestScope;

@RequestScope
public class FormVaidator implements Cloneable, Serializable {

    private static final long serialVersionUID = 3106078418055108414L;
    
    private String message;
    private Map<String, String> fieldsWithErrors;
    private Date date;
    private int status;
    
    public FormVaidator(String message, Map<String, String> fieldsWithErrors, Date date, int status) {
        this.message = message;
        this.fieldsWithErrors = fieldsWithErrors;
        this.date = date;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getFieldsWithErrors() {
        return fieldsWithErrors;
    }

    public void setFieldsWithErrors(String field, String messageError) {
        this.fieldsWithErrors.put(field, messageError);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new FormVaidator(this.message, this.fieldsWithErrors, this.date, this.status);
        }
    }

}
