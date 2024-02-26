import classes.Class;
import classes.Director;
import classes.Student;
import classes.Teacher;
import data.ClassesData;
import data.DirectorsData;
import data.StudentsData;
import data.TeachersData;
import menu.DirectorActions;
import menu.StudentActions;
import menu.TeacherActions;
import utils.Scan;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static utils.Validations.validateEmail;
import static utils.Validations.validatePhoneNumber;

public class Main {

    public static void main(String[] args) {
        try {
            int optionSelected;

            System.out.println("**************************************");
            System.out.println("*         UNIVERSIDADE ALT-F4        *");
            System.out.println("**************************************\n");

            do {
                System.out.println("+------------------------------------+");
                System.out.println("+           SEJA BEM VINDO           +");
                System.out.println("+------------------------------------+");
                System.out.println("| Você é aluno(a) ou funcionário(a)? |");
                System.out.println("|                                    |");
                System.out.println("| (1) - Sou Aluno(a)                 |");
                System.out.println("| (2) - Sou Funcionário(a)           |");
                System.out.println("|                                    |");
                System.out.println("+------------------------------------+");
                System.out.println("| (0) - Sair                         |");
                System.out.println("+------------------------------------+");
                System.out.print  ("Selecione uma opção para acesso: "     );

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        menuStudent();
                        break;
                    case 2:
                        menuEmployee();
                        break;
                    case 0:
                        System.out.println("Obrigado volte sempre. Universidade Alt F4, finalizada com sucesso!");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Informe uma opção do menu e tente novamente!");
                }
            } while (optionSelected != 0);

            Scan.close();
        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    // <editor-fold desc="Student Access Methods">
    /*
     * student home menu
     * */
    public static void menuStudent() {
        try {
            int optionSelected;

            do {
                System.out.println("+-------------------------------+");
                System.out.println("+        PAINEL DO ALUNO        +");
                System.out.println("+        ---- LOGIN ----        +");
                System.out.println("+-------------------------------+");
                System.out.println("|                               |");
                System.out.println("| (1) - Acessar meu painel      |");
                System.out.println("| (2) - Criar novo aluno(a)     |");
                System.out.println("|                               |");
                System.out.println("+-------------------------------+");
                System.out.println("| (0) - Sair do painel do aluno |");
                System.out.println("+-------------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        loginStudent();
                        break;
                    case 2:
                        addNewStudent();
                        break;
                    case 0:
                        System.out.println("Saindo do painel do aluno ...");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                        break;
                }
            } while (optionSelected != 0);
        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    /*
     * Student login method
     * */
    public static void loginStudent() {
        System.out.println("Digite seu e-mail de acesso: ");
        String mail = Scan.nextLine().strip().toLowerCase();

        if (mail.isEmpty()) {
            return;
        }

        if (!validateEmail(mail)) {
            System.out.println("Você não informou um email válido.");
            return;
        }

        Student student = StudentsData.findStudentByMail(mail);

        if (student == null) {
            System.out.println("Aluno(a) não encontrado!");
            student = addNewStudent(mail);

            if (student == null) {
                return;
            }
        }

        menuStudentLogged(student);
    }

    /*
     * Method to generate a menu for the logged in student and their available actions
     * */
    public static void menuStudentLogged(Student student) {
        StudentActions.menu(student);
    }

    public static Student addNewStudent() {
        return addNewStudent(null);
    }
    /*
     * Method for adding a new student
     * */
    public static Student addNewStudent(String mail) {
        System.out.println("+---------------------------------+");
        System.out.println("+         NOVO ALUNO(A)           +");
        System.out.println("+---------------------------------+");
        if (mail == null || mail.isEmpty()) {
            while (true) {
                System.out.println("Digite seu e-mail de acesso: ");
                mail = Scan.next().trim().toLowerCase();

                if (mail.isEmpty()) {
                    System.out.println("Cadastro de novo aluno cancelado.");
                    return null;
                }

                if (!validateEmail(mail)) {
                    System.out.println("E-mail inválido! tente novamente.");
                    continue;
                }

                if (!StudentsData.isEmailAdressAvailable(mail)) {
                    System.out.println("E-mail já está cadastrado. Utilize um e-mail diferente.");
                    continue;
                }

                break;
            }
        }

        System.out.println("Digite seu nome: ");
        String nameStudent = Scan.next().toLowerCase();

        if (nameStudent.isEmpty()) {
            System.out.println("Não é permitido criar um aluno com nome vazio.");
            System.out.println("Operação cancelada.");
            return null;
        }

        System.out.println("Digite seu telefone: ");
        System.out.println("Exemplo: 48999999999 ");
        String phoneNumber = Scan.next().toLowerCase();

        if (!phoneNumber.isEmpty()) {
            try {
                validatePhoneNumber(phoneNumber);
            } catch (IllegalArgumentException e) {
                System.out.println("Número de telefone inválido.");
                System.out.println("Operação cancelada.");
                return null;
            }
        }

        Student newStudent = new Student(nameStudent, mail, phoneNumber);
        StudentsData.addStudent(newStudent);

        try {
            System.out.println("Deseja selecionar uma turma para se matricular? (s/n)");

            String input = Scan.nextLine().strip().toLowerCase();

            if (input.equals("s") || input.equals("sim")) {
                System.out.println("Lista de turma:");
                ArrayList<Class> classes = ClassesData.getAllClasses();
                for (int i = 0; i < classes.size(); i++) {
                    Class aClass = classes.get(i);
                    int index = i + 1;

                    System.out.println(index + ". " + aClass);
                }
                System.out.println("Selecione a turma que deseja se matricular:");

                String classInput = Scan.nextLine();

                if (!classInput.isEmpty()) {
                    int classIndex = Integer.parseInt(classInput) - 1;
                    Class aClass = classes.get(classIndex);

                    aClass.addStudent(newStudent);

                    System.out.println("Matriculado com sucesso na turma " + aClass.getName() + ".");
                }
            }
        } catch (Exception e) {
            System.out.println("Não foi possível matriculá-lo a uma turma.");
        } finally {
            System.out.println("Novo aluno " + newStudent.getName() + " criado com sucesso.");
        }

        return newStudent;
    }


    // <editor-fold desc="Employee Access Methods">
    /*
     * employee home menu
     * */
    public static void menuEmployee() {
        try {
            int optionSelected;

            do {
                System.out.println("+------------------------------------+");
                System.out.println("+         PAINEL DO FUNCIONÁRIO      +");
                System.out.println("+           ---- LOGIN ----          +");
                System.out.println("+------------------------------------+");
                System.out.println("|                                    |");
                System.out.println("| (1) - Acessar meu painel           |");
                System.out.println("| (2) - Criar novo funcionário(a)    |");
                System.out.println("|                                    |");
                System.out.println("+---------------------------------- -+");
                System.out.println("| (0) -  Sair do painel do professor |");
                System.out.println("+------------------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        loginEmployee();
                        break;
                    case 2:
                        addNewEmployee(null, null, "");
                        break;
                    case 0:
                        System.out.println("Saindo do painel do funcionário ...");
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                }
            } while (optionSelected != 0);
        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    /*
     * Employee login method
     * */
    public static void loginEmployee() {
        try {
            String name;

            System.out.println("Digite seu nome para acesso: ");
            name = Scan.next();

            if (name != null && !name.trim().isEmpty()) {

                Teacher teacher = TeachersData.findTeacherByName(name);

                if (teacher == null) {

                    Director director = DirectorsData.findDirectorByName(name);

                    if (director == null){
                        System.out.println("Seu nome não foi identificado em nossa base de dados! Realize seu cadastro:");

                        addNewEmployee(null, null, name);

                    } else {
                        menuDirectorLogged(director);
                    }

                } else {
                    menuTeacherLogged(teacher);
                }

            } else {
                System.out.println("Você não informou um email válido.");
            }


        } catch (Exception exception) {
            System.out.println("Falha em identificar um aluno ou e-mail informado não é válido!");
        }
    }

    public static void addNewEmployee(Director director, Teacher teacher, String name) {
        try {
            int optionSelected;

            System.out.println("+---------------------------------+");
            System.out.println("+      NOVO FUNCIONÁRIO(A)        +");
            System.out.println("+---------------------------------+");
            System.out.println("|                                 |");
            System.out.println("| (1) - Novo(a) Professor(a)      |");
            System.out.println("| (2) - Novo(a) Diretor(a)        |");
            System.out.println("|                                 |");
            System.out.println("+---------------------------------+");
            System.out.println("| (0) - Voltar                    |");
            System.out.println("+---------------------------------+");

            System.out.print  ("Selecione uma opção: "     );

            optionSelected = Scan.nextInt();

            switch (optionSelected) {
                case 1:
                    teacher = addNewTeacher(name);
                    if (teacher != null) {
                        menuTeacherLogged(teacher);
                    }
                    break;
                case 2:
                    director = addNewDirector(name);
                    if (director != null) {
                        menuDirectorLogged(director);
                    }
                    break;
                case 0:
                    System.out.println("Voltando tela de login funcionário!");
                    break;
                default:
                    System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
            }

        } catch (Exception exception) {
            System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
        }
    }

    /*
     * Method to generate a menu for the logged in Teacher and their available actions
     * */
    public static void menuTeacherLogged(Teacher teacher) {
        TeacherActions.menu(teacher);
    }

    /*
     * Method to generate a menu for the logged in Director and their available actions
     * */
    public static void menuDirectorLogged(Director director) {
        DirectorActions.menu(director);
    }

    /*
     * Method for adding a new Director
     * */
    public static Director addNewDirector(String name) {

        try {
            if (name == null || name.isEmpty()) {
                System.out.println("Digite seu nome de acesso: ");
                name = Scan.next().toLowerCase();
            }

            System.out.println("Digite seu salário: ");
            double salary = Scan.nextDouble();
            System.out.println("Quantos ano(s) de experiência: ");
            int employmentYears = Scan.nextInt();

            Director newDirector = new Director(name, salary, employmentYears);
            DirectorsData.addDirector(newDirector);

            return newDirector;
        } catch (Exception exception) {
            System.out.println("Não foi possível adicionar um diretor! tente novamente.");
            return null;
        }
    }

    /*
     * Method for adding a new Teacher
     * */
    public static Teacher addNewTeacher(String name) {

        try {
            if (name == null || name.isEmpty()) {
                System.out.println("Digite seu nome de acesso: ");
                name = Scan.next().toLowerCase();
            }

            System.out.println("Quantos ano(s) você tem: ");
            int age = Scan.nextInt();
            System.out.println("Digite seu salário: ");
            double salary = Scan.nextDouble();
            System.out.println("Quantos ano(s) de experiência: ");
            int employmentYears = Scan.nextInt();

            Teacher newTeacher = new Teacher(name, age, salary, employmentYears);
            TeachersData.addTeacher(newTeacher);

            return newTeacher;
        } catch (Exception exception) {
            System.out.println("Não foi possível adicionar um professor! tente novamente.");
            return null;
        }
    }

    // </editor-fold>
}
