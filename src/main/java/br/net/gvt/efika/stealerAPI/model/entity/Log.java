/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Calendar;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author G0042204
 */
@Entity(value = "log")
public class Log {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private String action;

    private Calendar data;

    private Object input;

    private String executor;

    private Object output;

    public Log() {
    }

    public Log(String action) {
        this.action = action;
        this.data = Calendar.getInstance();
    }

    public Log(LoggerIn in) {
        this.action = in.getAcao();
        this.input = in.getInput();
        this.executor = in.getExecutor();
        this.data = Calendar.getInstance();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Object getInput() {
        return input;
    }

    public void setInput(Object input) {
        this.input = input;
    }

    public Object getOuput() {
        return output;
    }

    public void setOuput(Object ouput) {
        this.output = ouput;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }
    
    

}
