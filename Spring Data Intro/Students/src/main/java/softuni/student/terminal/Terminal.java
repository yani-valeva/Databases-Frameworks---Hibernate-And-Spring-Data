package softuni.student.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.student.entities.*;
import softuni.student.enums.MyContentType;
import softuni.student.enums.MyResourceType;
import softuni.student.services.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private CourseService<Course, Long> courseService;

    @Autowired
    private HomeworkService<Homework, Long> homeworkService;

    @Autowired
    private StudentService<Student, Long> studentService;

    @Autowired
    private ResourceService<Resource, Long> resourceService;

    @Autowired
    private LicenseService<License, Long> licenseService;

    @Override
    public void run(String... strings) throws Exception {
        seed();

        // first task
//        List<Object[]> studentsHomeworks = studentService.findAllStudentsAndHomeworkSubmissions();
//        studentsHomeworks.forEach(s -> System.out.printf("%s - %s, %s\n", s[0], s[1], s[2]));

        //second task
//        List<Object[]> coursesAndResources = courseService.findAllCoursesAndResources();
//        coursesAndResources.forEach(c -> System.out.println(String.join(", ",
//                Arrays.stream(c)
//                        .filter(x -> x != null)
//                        .map(Object::toString).collect(Collectors.toList()))));

        //third task
//        List<String> allCoursesWithMoreThanFiveResources = courseService.findAllCoursesWithMoreThan5Resources();
//        System.out.println(String.join("\n", allCoursesWithMoreThanFiveResources));

        // fourth task
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = simpleDateFormat.parse("15-11-2017");
//        List<Object[]> activeCourses = courseService.findAllCoursesActiveOnDate(date);
//        activeCourses.forEach(c -> System.out.println(String.join(", ",
//                Arrays.stream(c).map(Object::toString).collect(Collectors.toList()))));

        // five task
        List<Object[]> studentsInfo = studentService.findStudentInfo();
        studentsInfo.forEach(s -> {
            System.out.println(String.format("Name: %s, Number of courses: %s, Total price: %s, Average price per course: %s",
                    s[0], s[1], s[2], s[3]));
        });
    }

    public void seed() throws ParseException {

        if (studentService.findAll().size() > 0) {
            return;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        List<Student> students = new ArrayList<>();

        Student firstStudent = new Student();
        firstStudent.setName("Misho");
        firstStudent.setPhoneNumber("0884567892");
        firstStudent.setRegistrationDate(formatter.parse("15/06/2017"));
        studentService.save(firstStudent);
        students.add(firstStudent);

        Student secondStudent = new Student();
        secondStudent.setName("Mimi");
        secondStudent.setPhoneNumber("0898776633");
        secondStudent.setRegistrationDate(formatter.parse("10/08/2016"));
        studentService.save(secondStudent);
        students.add(secondStudent);

        Student thirdStudent = new Student();
        thirdStudent.setName("Lily");
        thirdStudent.setPhoneNumber("0886378261");
        thirdStudent.setRegistrationDate(formatter.parse("01/01/2017"));
        studentService.save(thirdStudent);
        students.add(thirdStudent);

        Course firstCourse = new Course();
        firstCourse.setName("Java DB Advanced");
        firstCourse.setDescription("Interesting course!");
        firstCourse.setStartDate(formatter.parse("24/07/2017"));
        firstCourse.setEndDate(new Date());
        firstCourse.setPrice(new BigDecimal("390"));
        firstCourse.setStudents(new HashSet<>(students.subList(0, 1)));
        courseService.save(firstCourse);

        Course secondCourse = new Course();
        secondCourse.setName("Java Fundamentals");
        secondCourse.setDescription("The best course ever!");
        secondCourse.setStartDate(formatter.parse("20/01/2017"));
        secondCourse.setEndDate(formatter.parse("18/03/2017"));
        secondCourse.setPrice(new BigDecimal("190"));
        secondCourse.setStudents(new HashSet<>(students.subList(0, 2)));
        courseService.save(secondCourse);

        Course thirdCourse = new Course();
        thirdCourse.setName("Java OOP");
        thirdCourse.setDescription("Difficult but useful course!");
        thirdCourse.setStartDate(formatter.parse("15/09/2016"));
        thirdCourse.setEndDate(formatter.parse("15/01/2017"));
        thirdCourse.setPrice(new BigDecimal("1500"));
        secondCourse.setStudents(new HashSet<>(students.subList(1, 2)));
        courseService.save(thirdCourse);

        Homework firstHomework = new Homework();
        firstHomework.setContent("Java basic introduction");
        firstHomework.setContentType(MyContentType.PDF);
        firstHomework.setSubmissionDate(formatter.parse("27/07/2017"));
        firstHomework.setStudent(firstStudent);
        homeworkService.save(firstHomework);

        Homework secondHomework = new Homework();
        secondHomework.setContent("Introduction in Hibernate");
        secondHomework.setContentType(MyContentType.ZIP);
        secondHomework.setSubmissionDate(formatter.parse("22/01/2017"));
        secondHomework.setStudent(secondStudent);
        homeworkService.save(secondHomework);

        Homework thirdHomework = new Homework();
        thirdHomework.setContent("Spring data intro");
        thirdHomework.setContentType(MyContentType.PDF);
        thirdHomework.setSubmissionDate(formatter.parse("10/10/2016"));
        thirdHomework.setStudent(thirdStudent);
        homeworkService.save(thirdHomework);

        Resource firstResource = new Resource();
        firstResource.setName("Lab documents");
        firstResource.setCourse(firstCourse);
        firstResource.setResourceType(MyResourceType.DOCUMENT);
        firstResource.setUrl("softuni.bg/trainings/lab");
        resourceService.save(firstResource);

        Resource secondResource = new Resource();
        secondResource.setName("Video lesson");
        secondResource.setCourse(secondCourse);
        secondResource.setResourceType(MyResourceType.VIDEO);
        secondResource.setUrl("softuni.bg/trainings/resources/video/121");
        resourceService.save(secondResource);

        Resource thirdResource = new Resource();
        thirdResource.setName("Google");
        thirdResource.setCourse(thirdCourse);
        thirdResource.setResourceType(MyResourceType.OTHER);
        thirdResource.setUrl("stackoverflow.com");
        resourceService.save(thirdResource);

        License firstLicense = new License();
        firstLicense.setName("ADW license");
        firstLicense.setResource(firstResource);
        licenseService.save(firstLicense);

        License secondLicense = new License();
        secondLicense.setName("QLA license");
        secondLicense.setResource(secondResource);
        licenseService.save(secondLicense);

        License thirdLicense = new License();
        thirdLicense.setName("TSL license");
        thirdLicense.setResource(thirdResource);
        licenseService.save(thirdLicense);
    }
}
