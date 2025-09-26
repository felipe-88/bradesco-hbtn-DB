package demo;

import entities.*;
import models.AlunoModel;
import models.AuxiliarModel;
import models.CursoModel;

import java.util.Date;

public class GestaoCursosMain {
    public static void main(String[] args) {
        AuxiliarModel auxiliarModel = new AuxiliarModel();
        CursoModel cursoModel = new CursoModel();
        AlunoModel alunoModel = new AlunoModel();

        Professor professor = new Professor();
        professor.setNomeCompleto("Beltrano Teste");
        professor.setMatricula("321");
        professor.setEmail("beltrano@teste.com");
        auxiliarModel.createProfessor(professor);


        Curso curso = new Curso();
        curso.setNome("Holberton");
        curso.setSigla("HBTN");
        professor.getCursos().add(curso);
        curso.setProfessor(professor);
        cursoModel.create(curso);

        MaterialCurso materialCurso = new MaterialCurso();
        materialCurso.setUrl("www.holberton.com");
        materialCurso.setCurso(curso);
        curso.setMaterialCurso(materialCurso);
        auxiliarModel.createMaterialCurso(materialCurso);

        Telefone telefone = new Telefone();
        telefone.setDDD("11");
        telefone.setNumero("123456789");
        auxiliarModel.createTelefone(telefone);

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Teste");
        endereco.setNumero("1");
        endereco.setBairro("Lapa");
        endereco.setCidade("São Paulo");
        endereco.setEstado("São Paulo");
        endereco.setCep(12345789);
        auxiliarModel.createEndereco(endereco);

        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("Fulano Teste");
        aluno.setMatricula("1234");
        aluno.setNascimento(new Date(1980, 1, 1));
        aluno.setEmail("fulano@teste.com");

        alunoModel.create(aluno);
    }
}
