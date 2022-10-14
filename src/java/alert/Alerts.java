/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alert;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author rafifajarrr
 */
@ManagedBean
public class Alerts {
    
    private String success;
    private String failed;
    private boolean status;

    public String getSuccess() {
        System.out.println("success : " + success);
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getFailed() {
        return failed;
    }

    public void setFailed(String failed) {
        this.failed = failed;
    }

    public boolean isStatus() {
        System.out.println("status : " + status);
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}
