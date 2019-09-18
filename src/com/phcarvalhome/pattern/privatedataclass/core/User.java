package com.phcarvalhome.pattern.privatedataclass.core;

import com.phcarvalhome.pattern.privatedataclass.business.Entity;
import com.phcarvalhome.pattern.prototype.core.Operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User extends Entity {

    private String email;
    private String password;
    private String bankBranch;
    private String bankAccount;
    private List<Operation> operationList;

    public User(String email, String password, String bankBranch, String bankAccount) {
        this.email = email;
        this.password = password;
        this.bankBranch = bankBranch;
        this.bankAccount = bankAccount;
        operationList = new ArrayList<>();
    }

    public void changePassword(String currentPassword, String newPassword){

        if(currentPassword.equals(password))
            password = newPassword;
        else
            throw new RuntimeException("The password changing is not valid!");
    }

    public void changeBankAccount(String bankBranch, String bankAccount, String password){

        if(password.equals(this.password)){
            this.bankBranch = bankBranch;
            this.bankAccount = bankAccount;
        } else{
            throw new RuntimeException("The password changing is not valid!");
        }
    }

    public void addOperation(Operation operation){
        operationList.add(operation);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        String encryptedPassword = new StringBuilder(password).reverse().toString();

        return encryptedPassword;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public List<Operation> getOperationList() {
        return Collections.unmodifiableList(operationList);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bankBranch='" + bankBranch + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", operationList=" + operationList +
                "} " + super.toString();
    }
}
