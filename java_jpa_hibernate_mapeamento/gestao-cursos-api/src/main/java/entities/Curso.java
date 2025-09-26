package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToOne(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private MaterialCurso materialCurso;

    @ManyToMany(mappedBy = "cursos")
    private Set<Aluno> alunos = new HashSet<>();

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }
    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }
    public MaterialCurso getMaterialCurso() { return materialCurso; }
    public void setMaterialCurso(MaterialCurso materialCurso) { this.materialCurso = materialCurso; }
    public Set<Aluno> getAlunos() { return alunos; }
    public void setAlunos(Set<Aluno> alunos) { this.alunos = alunos; }
}