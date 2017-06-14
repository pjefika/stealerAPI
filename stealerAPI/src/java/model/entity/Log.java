/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
    * @author G0042204
 */
@Entity
@Table(name = "STEALERAPI_LOG")
public class Log extends AbstractEntity {

    private String action;

    private Calendar data;

    private String input;

    @Lob
    @Column(length = 255555)
    private String output;

    public Log(String action) {
        this.action = action;
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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOuput() {
        return output;
    }

    public void setOuput(String ouput) {
        this.output = ouput;
    }

}
