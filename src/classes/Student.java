package classes;

import static utils.Validations.validateMail;
import static utils.Validations.validatePhoneNumber;

public class Student {
    // <editor-fold desc="Attributes">
    private int id;
    private String name;
    private byte age;
    private String mail;
    private String phoneNumber;
    // </editor-fold>

    // <editor-fold desc="Constructor">

    public Student(String name) {
        this.name = name;
    }

    public Student(int id){
        this.id = id;
    }

    /**
     * Method Student - "overload", with params mail and phoneNumber additional
     * */
    public Student(String name, String mail, String phoneNumber){
        this.name = name;
        try{
            validateMail(mail);
            validatePhoneNumber(phoneNumber);

            this.mail = mail;
            this.phoneNumber = phoneNumber;
        }catch (IllegalArgumentException e){
            System.out.println("Erro: "+e.getMessage());
        }finally {
            System.out.println("Fluxo de validação finalizado!");
        }
    }

    /**
     * Method Student - "overload", with params name and age
     * */
    public Student(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    // </editor-fold>

    //<editor-fold desc="ToString">
    @Override
    public String toString() {
        return "Aluno(a): "+
                "Nome: "+ name +
                ", Email: "+ mail +
                ", Telefone: "+ phoneNumber;
    }
    //</editor-fold>


    // <editor-fold desc="methods">

    /**
     * Method getName - return name student
     * */
    public String getName() {
        return name;
    }

    /**
     * Method setName - add name student
     * no usage created start project - (case study)
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getAge - return age student
     * no usage created start project - (case study)
     * */
    public byte getAge() {
        return age;
    }

    /**
     * Method setAge - add age student
     * no usage created start project - (case study)
     * */
    public void setAge(byte age) {
        this.age = age;
    }

    /**
     * Method getMail - return mail student
     * */
    public String getMail() {
        return mail;
    }

    /**
     * Method setMail - add mail student
     * no usage created start project - (case study)
     * */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Method getId - return id student
     * no usage created start project - (case study)
     * */
    public int getId() {
        return id;
    }
// </editor-fold>
}
