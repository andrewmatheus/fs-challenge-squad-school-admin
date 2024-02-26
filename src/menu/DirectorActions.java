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
import utils.Validations;

import static utils.Validations.validateEmail;


public class DirectorActions {

    public static void menu(Director director) {
        try {
            int optionSelected;

            do {
                System.out.println("\nFUNCIONÁRIO: " + director.getName());
                System.out.println("CARGO: DIRETOR");
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("| (1)  - Gerenciar cursos             |");
                System.out.println("| (2)  - Gerenciar turmas             |");
                System.out.println("| (3)  - Gerenciar professores        |");
                System.out.println("| (4)  - Gerenciar alunos             |");
                System.out.println("| (5)  - Relatório geral              |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println("| (0) - Voltar para o Login           |");
                System.out.println("+-------------------------------------+");
                System.out.print("Selecione uma opção: ");

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        manageCoursesSubmenu(director);
                        break;
                    case 2:
                        manageClassesSubmenu(director);
                        break;
                    case 3:
                        manageTeachersSubmenu(director);
                        break;
                    case 4:
                        manageStudentsSubmenu(director);
                        break;
                    case 5:
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

    private static void manageCoursesSubmenu(Director director) {
        try {
            int optionSelected;

            do {
                System.out.println("\nFUNCIONÁRIO: " + director.getName());
                System.out.println("CARGO: DIRETOR");
                System.out.println("+-------------------------------------+");
                System.out.println("|        Gerenciar cursos             |");
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("| (1)  - Listar cursos                |");
                System.out.println("| (2)  - Adicionar curso              |");
                System.out.println("| (3)  - Remover curso                |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println("| (0) - Voltar para o menu anterior   |");
                System.out.println("+-------------------------------------+");
                System.out.print("Selecione uma opção: ");

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        listCourses(CoursesData.getAllCourses());
                        break;
                    case 2:
                        createNewCourse();
                        break;
                    case 3:
                        removeCourse();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                }
            } while (optionSelected != 0);

        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    private static void manageClassesSubmenu(Director director) {
        try {
            int optionSelected;

            do {
                System.out.println("\nFUNCIONÁRIO: " + director.getName());
                System.out.println("CARGO: DIRETOR");
                System.out.println("+-------------------------------------+");
                System.out.println("|        Gerenciar turmas             |");
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("| (1)  - Listar turmas                |");
                System.out.println("| (2)  - Adicionar turma              |");
                System.out.println("| (3)  - Remover turma                |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("| (4)  - Listar alunos na turma       |");
                System.out.println("| (5)  - Adicionar aluno na turma     |");
                System.out.println("| (6)  - Remover aluno da turma       |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println("| (0) - Voltar para o menu anterior   |");
                System.out.println("+-------------------------------------+");
                System.out.print("Selecione uma opção: ");

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        listClasses(ClassesData.getAllClasses());
                        break;
                    case 2:
                        createNewClass();
                        break;
                    case 3:
                        removeClass();
                        break;
                    case 4:
                        TeacherActions.listStudentsInClassMenu();
                        break;
                    case 5:
                        TeacherActions.addStudentToClassMenu();
                        break;
                    case 6:
                        TeacherActions.removeStudentFromClassMenu();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                }
            } while (optionSelected != 0);

        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    private static void manageTeachersSubmenu(Director director) {

        try {
            int optionSelected;

            do {
                System.out.println("\nFUNCIONÁRIO: " + director.getName());
                System.out.println("CARGO: DIRETOR");
                System.out.println("+-------------------------------------+");
                System.out.println("|        Gerenciar professores        |");
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("| (1)  - Listar professores           |");
                System.out.println("| (2)  - Promover professor           |");
                System.out.println("| (3)  - Adicionar professor          |");
                System.out.println("| (4)  - Remover professor            |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println("| (0) - Voltar para o menu anterior   |");
                System.out.println("+-------------------------------------+");
                System.out.print("Selecione uma opção: ");

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        listTeachers(TeachersData.getAllTeachers());
                        break;
                    case 2:
                        promoteTeacher();
                        break;
                    case 3:
                        addNewTeacher();
                        break;
                    case 4:
                        removeTeacher();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção selecionada não é válida. Voltando ao menu principal...");
                }
            } while (optionSelected != 0);

        } catch (Exception exception) {
            System.out.println("Opção informada não é válida. Informe um número de acordo com menu.");
        }
    }

    private static void manageStudentsSubmenu(Director director) {
        try {
            int optionSelected;

            do {
                System.out.println("\nFUNCIONÁRIO: " + director.getName());
                System.out.println("CARGO: DIRETOR");
                System.out.println("+-------------------------------------+");
                System.out.println("|        Gerenciar alunos             |");
                System.out.println("+-------------------------------------+");
                System.out.println("|                                     |");
                System.out.println("| (1)  - Listar alunos                |");
                System.out.println("| (2)  - Adicionar aluno              |");
                System.out.println("| (3)  - Remover aluno                |");
                System.out.println("|                                     |");
                System.out.println("+-------------------------------------+");
                System.out.println("| (0) - Voltar para o menu anterior   |");
                System.out.println("+-------------------------------------+");
                System.out.print("Selecione uma opção: ");

                optionSelected = Scan.nextInt();

                switch (optionSelected) {
                    case 1:
                        listStudents(StudentsData.getAllStudents());
                        break;
                    case 2:
                        addNewStudent();
                        break;
                    case 3:
                        removeStudent();
                        break;
                    case 0:
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
        List<Course> courses = CoursesData.getAllCourses();

        // Exibir todos os professores
        System.out.println("\n------- Professores -------");
        if (teachers.isEmpty()) {
            System.out.println("Nenhum(a) professor(a) cadastrado(a) ainda!");
        } else {
            for (Teacher teacher : teachers) {
                int index = teachers.indexOf(teacher) + 1;
                System.out.println(index + ". " + teacher.toString());
            }
        }

        // Exibir todos os alunos
        System.out.println("\n------- Alunos -------");
        if (students.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado ainda!");
        } else {
            for (Student student : students) {
                int index = students.indexOf(student);
                System.out.println(index + ". " + student.toString());
            }
        }

        // Exibir todos os cursos e turmas com seus respectivos professores
        System.out.println("\n------- Cursos e Turmas Associados -------");
        if (courses.isEmpty()) {
            System.out.println("Nenhuma turma ou curso cadastrado ainda!");
        } else {
            listCourses(courses);
        }
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
            String indexString = Scan.nextLine().strip();

            if (indexString.isEmpty()) {
                System.out.println("Operação cancelada.");
                return;
            }

            int index = Integer.parseInt(indexString);

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
        if (teachers.isEmpty()) {
            System.out.println("Não há professores cadastrados.");
            return;
        }

        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);
            int index = i + 1;
            String name = teacher.getName();
            String level = " - Cargo: " + EmployeeLevel.getTranslated(teacher.getJobLevel());
            String experience = ", Experiência: " + teacher.getEmploymentYears() + " anos.";
            System.out.println(index + ": " + name + level + experience);
        }
    }

    private static void listStudents(List<Student> students) {
        System.out.println("Lista de estudantes:");
        if (students.isEmpty()) {
            System.out.println("Não há estudantes cadastrados.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            int index = i + 1;
            System.out.println(index + ". " + student.getName());
        }
    }

    private static void listCourses(List<Course> courses) {
        System.out.println("Lista de cursos:");
        if (courses.isEmpty()) {
            System.out.println("Não há cursos cadastrados.");
            return;
        }

        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            int index = i + 1;

            String name = course.getName();
            String teacher = " - Professor: " + course.getTeacher().getName();

            ArrayList<Class> classes = ClassesData.getClassessAssociatedWithCourse(course);
            if (classes.isEmpty()) {
                System.out.println(index + ". " + name + teacher + " (Nenhuma turma associada.)");
            } else {
                String indentation = "    ";
                System.out.println(index + ". " + name + teacher);
                System.out.println(indentation + "Turmas associadas:");
                for (Class currentClass : classes) {
                    String className = currentClass.getName();
                    String classYear = " - Ano: " + currentClass.getYear();
                    String studentCount = " - Alunos: " + currentClass.getStudents().size();
                    System.out.println(indentation + className + classYear + studentCount + ".");
                }
            }
        }
    }

    private static void listClasses(List<Class> classes) {
        System.out.println("Lista de turmas:");
        if (classes.isEmpty()) {
            System.out.println("Não há turmas cadastradas.");
            return;
        }

        for (int i = 0; i < classes.size(); i++) {
            Class currentClass = classes.get(i);
            int index = i + 1;

            String name = currentClass.getName();
            String course = " - Curso: " + currentClass.getCourse().getName();
            String year = " - Ano: " + currentClass.getYear();
            String studentCount = " - Alunos:" + currentClass.getStudents().size();
            System.out.println(index + ". " + name + course + year + studentCount + ".");
        }
    }

    public static void addNewTeacher() {
        // método duplicado na Main
        try {
            System.out.println("*** Cadastro do novo professor ***\n");
            System.out.print("Digite o nome: ");
            String name = Scan.next();

            if (name.isEmpty()) {
                System.out.println("Não é permitido criar um professor com nome vazio.");
                System.out.println("Operação cancelada.");
                return;
            }

            System.out.print("Digite a idade: ");
            String ageInput = Scan.nextLine().strip();

            if (ageInput.isEmpty()) {
                System.out.println("Operação cancelada.");
                return;
            }

            int age = Integer.parseInt(ageInput);

            System.out.print("Digite o salário: ");
            String salaryInput = Scan.nextLine().strip();

            if (salaryInput.isEmpty()) {
                System.out.println("Operação cancelada.");
                return;
            }

            double salary = Double.parseDouble(salaryInput);

            System.out.print("Digite os anos de experiência: ");
            String employmentYearsString = Scan.nextLine().strip();

            if (employmentYearsString.isEmpty()) {
                System.out.println("Operação cancelada.");
                return;
            }

            int employmentYears = Integer.parseInt(employmentYearsString);

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
            // Obter lista de professores
            List<Teacher> teachers = TeachersData.getAllTeachers();

            // Exibindo a lista de professores com índices
            listTeachers(teachers);

            if (teachers.isEmpty()) {
                return;
            }

            // Solicitar ao diretor que escolha o índice do professor a ser removido
            System.out.print("Digite o índice do professor que deseja remover: ");
            String input = Scan.nextLine().strip();

            if (input.isEmpty()) {
                return;
            }

            int index = Integer.parseInt(input) - 1;

            // Verificar se o índice é válido
            if (index >= 0 && index < teachers.size()) {
                Teacher teacher = teachers.get(index);

                ArrayList<Course> courses = CoursesData.getCoursesWithTeacher(teacher);
                if (!courses.isEmpty()) {
                    ArrayList<Course> allCourses = CoursesData.getAllCourses();

                    ArrayList<Teacher> otherTeachers = new ArrayList<>(teachers);
                    otherTeachers.remove(teacher);

                    ArrayList<int[]> toReplace = new ArrayList<>();

                    String teacherName = teacher.getName();
                    for (Course course : courses) {
                        String courseName = course.getName();

                        listTeachers(otherTeachers);

                        System.out.println(
                            "Escolha outro professor para substituir " +
                            teacherName + " no curso " + courseName + ":"
                        );

                        String indexString = Scan.nextLine().strip();

                        if (indexString.isEmpty()) {
                            System.out.println("Nenhum professor selecionado para substituir.");
                            System.out.println("Remoção do professor cancelada.");
                            return;
                        }

                        int replacementIndex = Integer.parseInt(indexString) - 1;

                        if (replacementIndex >= 0 && replacementIndex < otherTeachers.size()) {
                            Teacher replacementTeacher = otherTeachers.get(replacementIndex);

                            int courseIndex = allCourses.indexOf(course);
                            int teacherIndex = teachers.indexOf(replacementTeacher);

                            toReplace.add(new int[]{courseIndex, teacherIndex});

                            System.out.println(
                                "Professor " + teacherName + " será substituido por " +
                                replacementTeacher.getName() + " no curso " + courseName + "."
                            );
                        } else {
                            System.out.println("ID inválido do professor.");
                            System.out.println("Remoção do professor cancelada.");
                            return;
                        }
                    }

                    for (int[] ints : toReplace) {
                        int courseIndex = ints[0];
                        int teacherIndex = ints[1];

                        Course course = allCourses.get(courseIndex);
                        Teacher replacementTeacher = teachers.get(teacherIndex);

                        course.setTeacher(replacementTeacher);
                    }
                }

                TeachersData.removeTeacherById(index);
                System.out.println("Professor " + teacher.getName() + " removido com sucesso.");
            } else {
                System.out.println("ID do professor inválido.");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível remover o professor.");
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
                String option = Scan.next().strip().toLowerCase();
                if (option.equals("s") || option.equals("sim")) {
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

            if (courseName.isEmpty()) {
                System.out.println("Não é permitido um curso com nome vazio.");
                System.out.println("Operação cancelada.");
                return;
            }

            System.out.println("Lista de Professores Disponíveis:");

            for (int i = 0; i < teachers.size(); i++) {
                System.out.println((i + 1) + ". " + teachers.get(i).getName());
            }

            System.out.print("Selecione o número do professor para este curso: ");
            String teacherString = Scan.nextLine().strip();

            if (teacherString.isEmpty()) {
                System.out.println("Operação cancelada.");
                return;
            }

            int selectedTeacherIndex = Integer.parseInt(teacherString);

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

    private static void removeCourse() {
        try {
            ArrayList<Course> courses = CoursesData.getAllCourses();
            listCourses(courses);

            if (courses.isEmpty()) {
                return;
            }

            System.out.println("Selecione o curso a ser removido:");
            System.out.println("(todas as turmas associadas serão removidas também)");

            String indexString = Scan.nextLine().strip();

            if (indexString.isEmpty()) {
                return;
            }

            int courseIndex = Integer.parseInt(indexString) - 1;

            if (courseIndex >= 0 && courseIndex < courses.size()) {
                CoursesData.removeCourse(courseIndex);
            } else {
                System.out.println("ID do curso inválido.");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível remover o curso.");
        }
    }

    public static void addNewStudent() {
        // metodo duplicado na Main
        try {
            System.out.println("*** Cadastro do novo aluno ***\n");
            System.out.print("Digite o nome: ");
            String name = Scan.next();
            if (name.isEmpty()) {
                System.out.println("Não é permitido criar um aluno com nome vazio.");
                System.out.println("Operação cancelada.");
                return;
            }

            System.out.print("Digite o e-mail: ");
            String email = Scan.next();

            if (email.isEmpty()) {
                System.out.println("Não é permitido aluno com e-mail vazio.");
                System.out.println("Operação cancelada.");
                return;
            }

            if (!Validations.validateEmail(email)) {
                System.out.println("E-mail do aluno inválido.");
                return;
            }

            if (!StudentsData.isEmailAdressAvailable(email)) {
                System.out.println("E-mail já está cadastrado. Utilize um e-mail diferente.");
                return;
            }


            System.out.print("Digite o número de telefone: ");
            String phoneNumber = Scan.nextLine().strip();

            if (!phoneNumber.isEmpty()) {
                try {
                    Validations.validatePhoneNumber(phoneNumber);
                } catch (IllegalArgumentException e) {
                    System.out.println("Número de telefone inválido.");
                    System.out.println("Operação cancelada.");
                    return;
                }
            }

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
            listStudents(students);

            if (students.isEmpty()) {
                return;
            }

            System.out.print("Digite o ID do aluno a ser removido (0 para cancelar): ");

            String indexString = Scan.nextLine().strip();

            if (indexString.isEmpty()) {
                return;
            }

            int studentIndex = Integer.parseInt(indexString) - 1;

            // Verificar se o índice do aluno é válido
            if (studentIndex >= 0 && studentIndex < students.size()) {
                StudentsData.removeStudent(studentIndex); // Remover o aluno da lista
                System.out.println("\nAluno removido com sucesso!");
            } else {
                System.out.println("\nID do aluno inválido. Verifique e tente novamente.");
            }
        } catch (Exception exception) {
            System.out.println("\nNão foi possível remover o aluno! Tente novamente.");
        } finally {
            System.out.println("Voltando ao menu diretor!");
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

            if (className.isEmpty()) {
                System.out.println("Não é permitido criar uma turma com nome vazio.");
                System.out.println("Operação cancelada.");
                return;
            }

            System.out.print("Digite o ano da turma: ");
            String yearString = Scan.nextLine().strip();

            if (yearString.isEmpty()) {
                System.out.println("Operação cancelada.");
                return;
            }

            int year = Integer.parseInt(yearString);

            // Obter a lista de cursos disponíveis
            List<Course> courses = CoursesData.getAllCourses();

            if (courses.isEmpty()) {
                // Se não houver cursos cadastrados, pedir para criar um novo curso
                System.out.print("\nNão há cursos cadastrados. Por favor, crie um novo curso.\n");
                createNewCourse();
                // Depois de criar um novo curso, recarregar a lista de cursos
                courses = CoursesData.getAllCourses();
            }

            if (!courses.isEmpty()) {
                // Se houver cursos cadastrados, mostrar a lista e permitir a seleção
                System.out.println("\n*** Lista de Cursos Disponíveis ***");
                for (int i = 0; i < courses.size(); i++) {
                    System.out.println((i + 1) + ". " + courses.get(i).getName());
                }
                System.out.println("0. Criar um novo curso");

                System.out.print("Selecione o número do curso para esta turma (ou 0 para criar um novo): ");
                String input = Scan.nextLine().strip();

                if (input.isEmpty()) {
                    System.out.println("Operação cancelada.");
                    return;
                }

                int selectedCourseIndex = Integer.parseInt(input);

                if (selectedCourseIndex == 0) {
                    // Criar um novo curso
                    createNewCourse();
                    // Após criar um novo curso, recarregar a lista de cursos
                } else if (selectedCourseIndex >= 1 && selectedCourseIndex <= courses.size()) {
                    Course selectedCourse = courses.get(selectedCourseIndex - 1);

                    // Criar a nova turma associada ao curso selecionado
                    Class newClass = new Class(className, year, selectedCourse);
                    ClassesData.addClass(newClass);

                    System.out.println("\nNova turma: " + className + " associada ao curso: " + selectedCourse.getName() + ", criada com sucesso!");
                } else {
                    System.out.println("\nOpção inválida. A turma não foi criada.");
                }
            }
        } catch (Exception e) {
            System.out.println("\nErro ao criar a turma: " + e.getMessage());
        }
    }

    private static void removeClass() {
        try {
            ArrayList<Class> classes = ClassesData.getAllClasses();
            listClasses(classes);

            if (classes.isEmpty()) {
                return;
            }

            System.out.println("Selecione a turma a ser removida:");

            String indexString = Scan.nextLine().strip();

            if (indexString.isEmpty()) {
                return;
            }

            int classIndex = Integer.parseInt(indexString) - 1;

            if (classIndex >= 0 && classIndex < classes.size()) {
                ClassesData.removeClass(classIndex);
            } else {
                System.out.println("ID da turma inválido.");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível remover a turma.");
        }
    }
}
