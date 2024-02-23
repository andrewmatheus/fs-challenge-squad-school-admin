package classes;

import java.util.ArrayList;
import java.util.List;

public class Student {
    // <editor-fold desc="Attributes">
    private int id;
    private String name;
    private byte age;
    private String email;
    private String phoneNumber;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public Student(String name) {
        this.name = name;
    }
    // </editor-fold>

    // <editor-fold desc="try/catch">
    // Another overload / With try/catch
    public Student(String name, String email, String phoneNumber){
        this.name = name;
        try{
            validateEmail(email);
            validatePhoneNumber(phoneNumber);

            //Caso esteja validado corretamente o email e telefone:
            this.email = email;
            this.phoneNumber = phoneNumber;
        }catch (IllegalArgumentException e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
    public Student(int id){
        this.id = id;
    }

    //Method to validate if the email is correct
    public void validateEmail(String email){
        if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@.+\\..+$")) {
            throw new IllegalArgumentException("O email informado não é valido!");
        }
    }
    //Method to validate if the Phone is correct

    public void validatePhoneNumber(String phoneNumber){
        if (!phoneNumber.matches("\\d{11}")){
            throw new IllegalArgumentException("Numero de telefone INVALIDO!");
        }
    }

    // </editor-fold>

    //<editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Estudante: "+
                "Nome: "+ name +
                ", Email: "+ email +
                ", Telefone: "+ phoneNumber;
    }
    //</editor-fold>

    // <editor-fold desc="Overload">
    public Student(String name, byte age) {
        this.name = name;
        this.age = age;
    }
    // </editor-fold>

    // <editor-fold desc="methods">

    /*
     * Method getName - return name student
     * */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Method getAge and SetAge
     * */
    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    /*
     * Method getEmail
     * */
    public String getEmail() {
        return email;
    }
    /*
     * Method setEmail
     * */
    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }
// </editor-fold>
}
