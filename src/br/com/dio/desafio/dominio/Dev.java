package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp == null) {
            System.err.println("Bootcamp não pode ser nulo!");
            return;
        }
        if (bootcamp.getConteudos().isEmpty()) {
            System.err.println("Bootcamp não possui conteúdos disponíveis!");
            return;
        }
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
        System.out.println(this.nome + " inscrito(a) no Bootcamp: " + bootcamp.getNome());
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
            System.out.println(this.nome + " concluiu: " + conteudo.get().getTitulo());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public void exibirProgresso() {
        System.out.println("===== Progresso de " + this.nome + " =====");
        System.out.println("XP Total: " + calcularTotalXp());
        System.out.println("Conteúdos Concluídos: " + conteudosConcluidos.size());
        System.out.println("Conteúdos Restantes: " + conteudosInscritos.size());

        if (!conteudosConcluidos.isEmpty()) {
            System.out.println("\n✓ Concluídos:");
            conteudosConcluidos.forEach(c -> System.out.println(" - " + c.getTitulo() + " (XP: " + c.calcularXp() + ")"));
        }

        if (!conteudosInscritos.isEmpty()) {
            System.out.println("\n○ Pendentes:");
            conteudosInscritos.forEach(c -> System.out.println("  - " + c.getTitulo()));
        }
        System.out.println("=====================================\n");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

    @Override
    public String toString() {
        return "Dev { " +
                "nome = '" + nome + '\'' +
                ", conteudosInscritos = " + conteudosInscritos.size() +
                ", conteudosConcluidos = " + conteudosConcluidos.size() +
                ", totalXP = " + calcularTotalXp() +
                " }";
    }
}
