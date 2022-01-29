package br.com.teachingplatform.application.services;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Student extends Content {

    private String name;
    private Set<Content> registered = new LinkedHashSet<>();
    private Set<Content> concluded = new LinkedHashSet<>();

    public void subscribe(Bootcamp bootcamp) {
        this.registered.addAll(bootcamp.getContents());
        bootcamp.getClients().add(this);

        System.out.println("Você está matriculado(a) nos seguintes Bootcamps:\n");
        for (Content content : registered) {
            System.out.printf("Nome: %s\nDescrição: %s\nData Inicio: %s\nData término: %s\n", bootcamp.getName(), bootcamp.getDescription(), bootcamp.getInitialDate(), bootcamp.getFinalDate());
            System.out.printf("\nCursos presentes no Bootcamp: \nNome: %s\nDescrição: %s\n", content.getTitle(), content.getDescription());
        }
    }

    public void progress() {
        Optional<Content> content = this.registered.stream().findFirst();
        if (content.isPresent()) {
            this.concluded.add(content.get());
            this.registered.remove(content.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Content> getRegistered() {
        return registered;
    }

    public void setRegistered(Set<Content> registered) {
        this.registered = registered;
    }

    public Set<Content> getConcluded() {
        return concluded;
    }

    public void setConcluded(Set<Content> concluded) {
        this.concluded = concluded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(registered, student.registered) && Objects.equals(concluded, student.concluded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, registered, concluded);
    }
}

