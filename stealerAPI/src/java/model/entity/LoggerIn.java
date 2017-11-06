/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author G0041775
 */
public abstract class LoggerIn {
    
    private String executor;
    
    public abstract String getAcao();
    
    public abstract String getInput();

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }
    
}
