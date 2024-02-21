import classes.Director;
import classes.Student;
import classes.Teacher;
import data.ClassesData;
import data.DirectorsData;
import data.StudentsData;
import data.TeachersData;
import menu.StudentActions;
import utils.Scan;

import static utils.Validations.validateEmail;
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
                System.out.println("+------------------------------+");
                System.out.println("+       PAINEL DO ALUNO        +");
                System.out.println("+       ---- LOGIN ----        +");
                System.out.println("+------------------------------+");
                System.out.println("|                              |");
                System.out.println("| (1) - Acessar meu painel     |");
                System.out.println("| (2) - Criar novo aluno(a)    |");
                System.out.println("|                              |");
                System.out.println("+------------------------------+");
                System.out.println("| (0) - Sair                   |");
                System.out.println("+------------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        loginStudent();
                        break;
                    case 2:
                        addNewStudent(null);
                        break;
                    case 0:
                        System.out.println("Saindo do painel do aluno ...");
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
     * Student login method
     * */
    public static void loginStudent() {
        try {
            String mail;

            do {
                System.out.println("Digite seu e-mail de acesso: ");
                mail = Scan.next().trim().toLowerCase();

                if (!mail.trim().isEmpty()) {
                    if (validateEmail(mail)) {

                        Student student = StudentsData.findStudentByMail(mail);
                        
                        if (student == null) {
                            System.out.println("Aluno(a) não encontrado!");
                            student = addNewStudent(mail);
                        }

                        menuStudentLogged(student);

                        // caso exista turma aberta perguntar se já deseja se vincular a uma turma existente e realizar matricula
                        // Aqui tem q ter a funcionalidade de matricular numa turma (Cartão novo)

                    } else {
                        System.out.println("Você não informou um email válido. Tente novamente!");
                    }
                } else {
                    System.out.println("Você não informou um email válido.");
                }
            } while (!validateEmail(mail));

        } catch (Exception exception) {
            System.out.println("Falha em identificar um aluno ou e-mail informado não é válido!");
        }
    }

    /*
     * Method to generate a menu for the logged in student and their available actions
     * */
    public static void menuStudentLogged(Student student) {
        StudentActions.menu(student);
    }

    /*
     * Method for adding a new student
     * */
    public static Student addNewStudent(String mail) {
        System.out.println("+---------------------------------+");
        System.out.println("+         NOVO ALUNO(A)           +");
        System.out.println("+---------------------------------+");
        if (mail == null || mail.isEmpty()) {
            System.out.println("Digite seu e-mail de acesso: ");
            mail = Scan.next().trim().toLowerCase();

            if (!validateEmail(mail) && !mail.trim().isEmpty()) {
                do  {
                    System.out.println("E-mail inválido! tente novamente.");
                    System.out.println("Digite seu e-mail de acesso: ");
                    mail = Scan.next().toLowerCase();
                } while ((!validateEmail(mail)));
            }
        }

        System.out.println("Digite seu nome: ");
        String nameStudent = Scan.next().toLowerCase();
        System.out.println("Digite seu telefone: ");
        System.out.println("Exemplo: 48999999999 ");
        String phoneNumber = Scan.next().toLowerCase();

        Student newStudent = new Student(nameStudent, mail, phoneNumber);
        StudentsData.addStudent(newStudent);

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
                System.out.println("+---------------------------------+");
                System.out.println("+       PAINEL DO FUNCIONÁRIO     +");
                System.out.println("+         ---- LOGIN ----         +");
                System.out.println("+---------------------------------+");
                System.out.println("|                                 |");
                System.out.println("| (1) - Acessar meu painel        |");
                System.out.println("| (2) - Criar novo funcionário(a) |");
                System.out.println("|                                 |");
                System.out.println("+---------------------------------+");
                System.out.println("| (0) - Sair                      |");
                System.out.println("+---------------------------------+");
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
            System.out.println("| (0) - Sair                      |");
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
        try {
            int optionSelected;

            do {

                System.out.println("\nFUNCIONÁRIO: " + teacher.getName() );
                System.out.println("CARGO: PROFESSOR");
                System.out.println("+---------------------------------+");
                System.out.println("|                                 |");
                System.out.println("| (1) - Listar Alunos             |");
                System.out.println("| (2) - Adicionar Aluno na turma  |");
                System.out.println("| (3) - Remover Aluno da turma    |");
                System.out.println("|                                 |");
                System.out.println("+---------------------------------+");
                System.out.println("| (0) - Sair                      |");
                System.out.println("+---------------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        System.out.println("Lista dos alunos: ");
                        for (int i = 0; i < StudentsData.getStudentsList().size(); i++) {
                            System.out.println(i+": "+StudentsData.findStudent(i).getName());
                        }
                        break;
                    case 2:
                        System.out.println("Lista das Turmas: ");
                        for (int i = 0; i < ClassesData.getAllClasses().size(); i++) {
                            System.out.println(i+": "+ClassesData.findClassById(i));
                        }
                        System.out.print("Selecione o ID da Turma para adicionar aluno: ");
                        int classID = scan.nextInt();
                        classes.Class class2 = ClassesData.findClassById(classID);
                        System.out.println("Lista de Alunos:");
                        for (int i = 0; i < StudentsData.getStudentsList().size(); i++) {
                            System.out.println(i+": "+StudentsData.findStudent(i).getName());
                        }
                        System.out.print("Selecione o ID do Aluno para adicionar à turma: ");
                        int studentID = scan.nextInt();
                        classes.Student class3 = StudentsData.findStudent(studentID);
                        class2.addStudent(class3);
                        break;
                    case 3:
                        System.out.println("Lista de Turmas:");
                        for (int i = 0; i < ClassesData.getAllClasses().size(); i++) {
                            System.out.println(i+": "+ClassesData.findClassById(i));
                        }
                        System.out.print("Selecione o ID da Turma para remover aluno: ");
                        int classID2 = scan.nextInt();
                        classes.Class class4 = ClassesData.findClassById(classID2);
                        System.out.println("Lista de Alunos na Turma:");
                        for (int i = 0; i < class4.getStudents().size(); i++) {
                            System.out.println(i+": "+class4.getStudents().get(i).getName());
                        }
                        System.out.print("Selecione o ID do Aluno para remover da turma: ");
                        int studantID4 = scan.nextInt();
                        class4.removeStudent(class4.getStudents().get(studantID4));
                    break;
                    case 0:
                        System.out.println("Deslogado com sucesso!");
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
     * Method to generate a menu for the logged in Director and their available actions
     * */
    public static void menuDirectorLogged(Director director) {
        try {
            int optionSelected;

            do {

                System.out.println("\nFUNCIONÁRIO: " + director.getName() );
                System.out.println("CARGO: DIRETOR");
                System.out.println("+---------------------------------+");
                System.out.println("|                                 |");
                System.out.println("| (1) - Promover professor        |");
                System.out.println("| (2) - Adicionar novo professor  |");
                System.out.println("| (3) - Remover professor         |");
                System.out.println("| (4) - Relatório geral           |");
                System.out.println("|                                 |");
                System.out.println("+---------------------------------+");
                System.out.println("| (0) - Sair                      |");
                System.out.println("+---------------------------------+");
                System.out.print  ("Selecione uma opção: "     );

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        System.out.println("Funcionalidade de listar alunos");
                        break;
                    case 2:
                        System.out.println("Funcionalidade de adicionar novo professor");
                        break;
                    case 3:
                        System.out.println("Funcionalidade de remover professor");
                        break;
                    case 4:
                        System.out.println("Funcionalidade de  listar todos os professores e todos os alunos, juntos dos ids deles");
                        break;
                    case 0:
                        System.out.println("Deslogado com sucesso!");
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
