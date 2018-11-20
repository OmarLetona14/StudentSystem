 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.model;

/**
 *
 * @author Omar
 */
public class SystemUser {
    
    public static SystemUser[] systemusers = new SystemUser[1];
    
    private String carnet;
    private String password;
    private String role;
    private String name;
    private String CUI;
    private String email;
    private String address;

    public SystemUser(String carnet, String password, String role, String name, String CUI, String email, String address) {
        this.carnet = carnet;
        this.password = password;
        this.role = role;
        this.name = name;
        this.CUI = CUI;
        this.email = email;
        this.address = address;
    }

    public static SystemUser[] getSystemusers() {
        return systemusers;
    }

    public static void setSystemusers(SystemUser[] systemusers) {
        SystemUser.systemusers = systemusers;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCUI() {
        return CUI;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

}
