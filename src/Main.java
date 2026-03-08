import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   DESAFIO POO - BOOTCAMP DIO");
        System.out.println("========================================\n");

        // Criando cursos
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java Básico");
        curso1.setDescricao("Aprenda os fundamentos de Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Fundamentos de JavaScript para Web");
        curso2.setCargaHoraria(4);

        Curso curso3 = new Curso();
        curso3.setTitulo("Curso Spring Boot");
        curso3.setDescricao("Desenvolvimento de APIs com Spring Boot");
        curso3.setCargaHoraria(12);

        // Criando mentorias
        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria de Java");
        mentoria1.setDescricao("Tire suas dúvidas sobre Java com especialistas");
        mentoria1.setData(LocalDate.now());

        Mentoria mentoria2 = new Mentoria();
        mentoria2.setTitulo("Mentoria de Carreira");
        mentoria2.setDescricao("Como se destacar no mercado de tecnologia");
        mentoria2.setData(LocalDate.now().plusDays(7));

        // Criando bootcamp
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Aprenda Java do zero ao avançado");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(curso3);
        bootcamp.getConteudos().add(mentoria1);
        bootcamp.getConteudos().add(mentoria2);

        System.out.println("Bootcamp criado: " + bootcamp.getNome());
        System.out.println("Total de conteúdos: " + bootcamp.getConteudos().size());
        System.out.println("Período: " + bootcamp.getDataInicial() + " até " + bootcamp.getDataFinal());
        System.out.println();

        // Criando devs e inscrevendo no bootcamp
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);

        Dev devKaua = new Dev();
        devKaua.setNome("Kauã");
        devKaua.inscreverBootcamp(bootcamp);

        Dev devMaria = new Dev();
        devMaria.setNome("Maria");
        devMaria.inscreverBootcamp(bootcamp);

        System.out.println("\n--- DEVS PROGREDINDO NOS ESTUDOS ---\n");

        // Camila progride 2 conteúdos
        devCamila.progredir();
        devCamila.progredir();

        // Kauã progride 4 conteúdos
        devKaua.progredir();
        devKaua.progredir();
        devKaua.progredir();
        devKaua.progredir();

        // Maria progride 1 conteúdo
        devMaria.progredir();

        System.out.println("\n--- EXIBINDO PROGRESSO DETALHADO ---\n");
        
        devCamila.exibirProgresso();
        devKaua.exibirProgresso();
        devMaria.exibirProgresso();

        // Exibindo ranking
        bootcamp.exibirRanking();

        System.out.println("--- INFORMAÇÕES RESUMIDAS ---");
        System.out.println(devCamila);
        System.out.println(devKaua);
        System.out.println(devMaria);
        System.out.println("\n" + bootcamp);

    }
}
