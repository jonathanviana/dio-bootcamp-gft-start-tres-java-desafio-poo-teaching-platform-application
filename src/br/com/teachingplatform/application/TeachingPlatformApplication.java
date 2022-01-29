package br.com.teachingplatform.application;

import br.com.teachingplatform.application.services.Bootcamp;
import br.com.teachingplatform.application.services.Course;
import br.com.teachingplatform.application.services.Student;

public class TeachingPlatformApplication extends Bootcamp {
    public static void main(String[] args) {

        Student javaStudent = new Student();
        javaStudent.setName(" Mr. Java Jr.");

        System.out.println("Olá" + javaStudent.getName());

        Course javaCourse = new Course();
        javaCourse.setTitle("Introdução a linguagem de programação Java");
        javaCourse.setDescription("No curso você irá aprender os principais conceitos relacionados a linguagem Java");
        javaCourse.setWorkload(42);

        Bootcamp javaBootcamp = new Bootcamp();
        javaBootcamp.setName("GFT Start #3 Java");
        javaBootcamp.setDescription("Hey Dev, o Bootcamp GFT Start #3 Java foi pensado exclusivamente para o seu desenvolvimento na tecnologia de Java, \ncontendo uma sequência completa de cursos, mentorias e desafios.");
        javaBootcamp.getContents().add(javaCourse);

        javaStudent.subscribe(javaBootcamp);

    }
}
