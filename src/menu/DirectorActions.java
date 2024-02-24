package menu;

import classes.Course;
import classes.Director;
import classes.Student;
import classes.Teacher;
import classes.Class;
import data.ClassesData;
import data.CoursesData;
import data.StudentsData;
import data.TeachersData;
import enums.EmployeeLevel;
import utils.Scan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static data.TeachersData.removeTeacherById;


public class DirectorActions {

    public static void menu(Director director) {
        try {
            int optionSelected;

            do {

                System.out.println("\nFUNCIONÁRIO: " + director.getName());
                System.out.println("CARGO: DIRETOR");
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("| (1)  - Promover professor           |");
                System.out.println("| (2)  - Adicionar/Remover professor  |");
                System.out.println("| (3)  - Adicionar/Remover aluno      |");
                System.out.println("| (4)  - Criar um Curso               |");
                System.out.println("| (5)  - Criar uma turma              |");
                System.out.println("| (6)  - Listar Alunos na turma       |");
                System.out.println("| (7)  - Adicionar Aluno na turma     |");
                System.out.println("| (8)  - Remover Aluno da turma       |");
                System.out.println("| (9)  - Relatório geral              |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println("| (0) - Sair                          |");
                System.out.println("+-------------------------------------+");
                System.out.print("Selecione uma opção: ");

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        // Promover o cargo de um professor, default BEGINNER.
                        promoteTeacher();
                        break;
                    case 2:
                        // Adicionar ou remover professor
                        addRemoveTeacher();
                        break;
                    case 3:
                        // Adicionar ou remover aluno
                        addRemoveStudent();
                        break;
                    case 4:
                        //Criar um curso
                        createNewCourse();
                        break;
                    case 5:
                        //Criar uma turma
                        createNewClass();
                        break;
                    case 6:
                        // Listar ALunos na turma
                        TeacherActions.listStudentsInClassMenu();
                        break;
                    case 7:
                        // Adicionar Aluno na turma
                        TeacherActions.addStudentToClassMenu();
                        break;
                    case 8:
                        // Remover ALuno da Turma
                        TeacherActions.removeStudentFromClassMenu();
                        break;
                    case 9:
                        // Listar todos os professores e alunos com seus IDs
                        relatorioGeral();
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
     * Método para listar todos os professores e estudantes
     * */
    public static void relatorioGeral() {
        // Obter listas de professores, alunos e cursos
        List<Teacher> teachers = TeachersData.getAllTeachers();
        List<Student> students = StudentsData.getAllStudents();
        //List<Course> courses = CoursesData.getCoursesList();
        List<Class> classes = ClassesData.getAllClasses();

        // Exibir todos os professores
        System.out.println("\n------- Professores -------");
        for (Teacher teacher : teachers) {
            int index = teachers.indexOf(teacher) + 1;
            System.out.println(index + ". " + teacher.toString());
        }

        // Exibir todos os alunos
        System.out.println("\n------- Alunos -------");
        for (Student student : students) {
            int index = students.indexOf(student);
            System.out.println(index + ". " + student.toString());
        }

        // Exibir todos os cursos e turmas com seus respectivos professores
        System.out.println("\n------- Turmas e Cursos Asociados -------");
        for (Class class_ : classes) {
            Course course = class_.getCourse();
            String teacherName = course.getTeacher().getName();
            System.out.println("Turma: " + class_.getName() + ", Ano: " + class_.getYear() + ", Curso: " + course.getName() + ", Profesor: " + teacherName);
        }

        // Manter o menu ativo
        System.out.println("\nPressione qualquer tecla para voltar ao menu.");
        Scan.nextLine();
    }



    /*
     * Method to promote a teacher to the next job level
     * */
    public static void promoteTeacher() {
        try {
            // Lista de professores em ordem alfabética
            List<Teacher> teachers = TeachersData.getAllTeachers();
            teachers.sort(Comparator.comparing(Teacher::getName));

            // Exibindo a lista de professores com índices, cargos e experiência
            listTeachers(teachers);

            // Solicitar ao diretor que escolha o índice do professor a ser promovido
            System.out.print("Digite o índice do professor que deseja promover (0 para sair): ");
            int index = Scan.nextInt();

            if (index == 0) {
                System.out.println("Operação cancelada.");
                return;
            }

            if (index > 0 && index <= teachers.size()) {
                Teacher teacher = teachers.get(index - 1); // Ajuste o índice para começar em 1

                if (teacher.canBePromoted()) {
                    teacher.promotion();
                    String level = EmployeeLevel.getTranslated(teacher.getJobLevel());
                    System.out.println("Professor " + teacher.getName() + " promovido para " + level + ".");
                } else {
                    System.out.println("O professor " + teacher.getName() + " já atingiu o cargo mais alto.");
                }
            } else {
                System.out.println("Índice inválido. Por favor, selecione um índice válido.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao promover o professor: " + e.getMessage());
        }
    }

    private static void listTeachers(List<Teacher> teachers) {
        System.out.println("Lista de Professores:");
        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);
            int index = i + 1;
            String name = teacher.getName();
            String level = " - Cargo: " + EmployeeLevel.getTranslated(teacher.getJobLevel());
            String experience = ", Experiência: " + teacher.getEmploymentYears() + " anos.";
            System.out.println(index + ": " + name + level + experience);
        }
    }

    public static void addNewTeacher() {
        // método duplicado na Main
        try {
            System.out.println("*** Cadastro do novo professor ***\n");
            System.out.print("Digite o nome: ");
            String name = Scan.next();

            System.out.print("Digite a idade: ");
            int age = Scan.nextInt();
            System.out.print("Digite o salário: ");
            double salary = Scan.nextDouble();
            System.out.print("Digite os anos de experiência: ");
            int employmentYears = Scan.nextInt();

            Teacher newTeacher = new Teacher(name, age, salary, employmentYears);
            TeachersData.addTeacher(newTeacher);
            System.out.println("\nNovo professor adicionado com sucesso!");
        } catch (Exception exception) {
            System.out.println("\nNão foi possível adicionar um professor! Tente novamente.");
        }
    }

    /*
     * Method to remove a teacher.
     * */
    public static void removeTeacher() {
        try {
            // Lista de professores em ordem alfabética
            List<Teacher> teachers = TeachersData.getAllTeachers();
            teachers.sort(Comparator.comparing(Teacher::getName));

            // Exibindo a lista de professores com índices
            listTeachers(teachers);

            // Solicitar ao diretor que escolha o índice do professor a ser removido
            System.out.print("Digite o índice do professor que deseja remover: ");
            int index = Scan.nextInt();

            // Remover o professor utilizando o método da classe TeachersData
            removeTeacherById(index -1);
        } catch (Exception e) {
            System.out.println("Erro ao remover o professor: " + e.getMessage());
        }
    }

    public static void addRemoveTeacher() {
        try {
            System.out.println("*** Adicionar ou remover professor ***\n");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar novo professor");
            System.out.println("2. Remover professor existente");
            System.out.print("Opção: ");
            int option = Scan.nextInt();

            if (option == 1) {
                addNewTeacher();
            } else if (option == 2) {
                removeTeacher();
            } else {
                System.out.println("Opção inválida. Por favor, escolha 1 ou 2.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar a ação. Tente novamente.");
        }
    }
    /*
     * Method to create a new Course. A registered Teacher is linked to the new Course
     * */
    public static void createNewCourse() {
        try {
            List<Teacher> teachers = TeachersData.getAllTeachers();

            if (teachers.isEmpty()) {
                System.out.println("Nenhum professor cadastrado.");
                System.out.println("Por favor, adicione um novo professor antes de criar um curso.");
                System.out.print("Deseja adicionar um novo professor? (S/N)");
                String option = Scan.next();
                if (option.equalsIgnoreCase("S")) {
                    addNewTeacher();
                    // Recarregar a lista de professores
                    teachers = TeachersData.getAllTeachers();
                } else {
                    System.out.println("Operação cancelada.");
                    return;
                }
            }

            System.out.print("Digite o nome do novo curso: ");
            String courseName = Scan.next();

            System.out.println("Lista de Professores Disponíveis:");
            for (int i = 0; i < teachers.size(); i++) {
                System.out.println((i + 1) + ". " + teachers.get(i).getName());
            }

            System.out.print("Selecione o número do professor para este curso: ");
            int selectedTeacherIndex = Scan.nextInt();

            if (selectedTeacherIndex >= 1 && selectedTeacherIndex <= teachers.size()) {
                Teacher selectedTeacher = teachers.get(selectedTeacherIndex - 1);

                Course newCourse = new Course(courseName, selectedTeacher);
                CoursesData.addCourse(newCourse);

                System.out.println("Novo curso '" + newCourse.getName() + "' associado ao professor '" + selectedTeacher.getName() + "' criado com sucesso!");
            } else {
                System.out.println("Índice de professor selecionado inválido. O curso não foi criado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao criar o curso: " + e.getMessage());
        }
    }

    public static void addNewStudent() {
        // metodo duplicado na Main
        try {
            System.out.println("*** Cadastro do novo aluno ***\n");
            System.out.print("Digite o nome: ");
            String name = Scan.next();

            System.out.print("Digite o e-mail: ");
            String email = Scan.next();

            System.out.print("Digite o número de telefone: ");
            String phoneNumber = Scan.next();

            Student newStudent = new Student(name, email, phoneNumber);
            StudentsData.addStudent(newStudent);
            System.out.println("\nNovo aluno adicionado com sucesso!");
        } catch (Exception exception) {
            System.out.println("\nNão foi possível adicionar um aluno! Tente novamente.");
        }
    }

    public static void removeStudent() {
        try {
            System.out.println("*** Remoção de aluno ***\n");

            // Listar todos os estudantes antes de remover
            List<Student> students = StudentsData.getAllStudents();
            System.out.println("Lista de estudantes:");
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                System.out.println("ID: " + (i + 1) + ", Nome: " + student.getName());
            }

            System.out.print("Digite o ID do aluno a ser removido (0 para cancelar): ");
            int StudentId = Scan.nextInt();

            if (StudentId == 0) {
                return; // Cancelar a operação se o usuário digitar 0
            }

            // Verificar se o índice do aluno é válido
            if (StudentId > 0 && StudentId <= students.size()) {
                students.remove(StudentId - 1); // Remover o aluno da lista
                System.out.println("\nAluno removido com sucesso!");
            } else {
                System.out.println("\nID do aluno inválido. Verifique e tente novamente.");
            }
        } catch (Exception exception) {
            System.out.println("\nNão foi possível remover o aluno! Tente novamente.");
        }
    }

    public static void addRemoveStudent() {
        try {
            System.out.println("*** Adicionar ou remover aluno ***\n");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar novo aluno");
            System.out.println("2. Remover aluno existente");
            System.out.print("Opção: ");
            int option = Scan.nextInt();

            if (option == 1) {
                addNewStudent();
            } else if (option == 2) {
                removeStudent();
            } else {
                System.out.println("Opção inválida. Por favor, escolha 1 ou 2.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar a ação. Tente novamente.");
        }
    }

    public static void createNewClass() {
        try {
            // Obter a lista de turmas cadastradas
            ArrayList<Class> existingClasses = ClassesData.getAllClasses();

            // Se houver turmas cadastradas, imprimir a lista
            if (!existingClasses.isEmpty()) {
                System.out.println("\n------- Turmas Cadastradas -------");
                for (Class existingClass : existingClasses) {
                    Course course = existingClass.getCourse();
                    String teacherName = course.getTeacher().getName();
                    System.out.println("Turma: " + existingClass.getName() + ", Ano: " + existingClass.getYear() + ", Curso: " + course.getName() + ", Professor: " + teacherName);
                }
                System.out.println();
            }

            System.out.print("Digite o nome da nova turma: ");
            String className = Scan.next();

            System.out.print("Digite o ano da turma: ");
            int year = Scan.nextInt();

            // Obter a lista de cursos disponíveis
            List<Course> courses = CoursesData.getCoursesList();

            if (courses.isEmpty()) {
                // Se não houver cursos cadastrados, pedir para criar um novo curso
                System.out.print("\nNão há cursos cadastrados. Por favor, crie um novo curso.\n");
                createNewCourse();
                // Depois de criar um novo curso, recarregar a lista de cursos
                courses = CoursesData.getCoursesList();
            }

            if (!courses.isEmpty()) {
                // Se houver cursos cadastrados, mostrar a lista e permitir a seleção
                System.out.println("\n*** Lista de Cursos Disponíveis ***");
                for (int i = 0; i < courses.size(); i++) {
                    System.out.println((i + 1) + ". " + courses.get(i).getName());
                }
                System.out.println("0. Criar um novo curso");

                System.out.print("Selecione o número do curso para esta turma (ou 0 para criar um novo): ");
                int selectedCourseIndex = Scan.nextInt();

                if (selectedCourseIndex == 0) {
                    // Criar um novo curso
                    createNewCourse();
                    // Após criar um novo curso, recarregar a lista de cursos
                } else if (selectedCourseIndex >= 1 && selectedCourseIndex <= courses.size()) {
                    Course selectedCourse = courses.get(selectedCourseIndex - 1);

                    // Criar a nova turma associada ao curso selecionado
                    Class newClass = new Class(className, year, selectedCourse);
                    ClassesData.addClass(newClass);

                    System.out.println("\nNova turma -" + className + "- associada ao curso -" + selectedCourse.getName() + "- criada com sucesso!");
                } else {
                    System.out.println("\nOpção inválida. A turma não foi criada.");
                }
            }
        } catch (Exception e) {
            System.out.println("\nErro ao criar a turma: " + e.getMessage());
        }
    }
}
