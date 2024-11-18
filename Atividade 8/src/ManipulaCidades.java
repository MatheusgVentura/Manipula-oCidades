import java.util.*;

public class ManipulaCidades {
    public static void main(String[] args) {
        List<Cidade> cidades = new ArrayList<>(List.of(
                new Cidade("Anápolis", "GO", false),
                new Cidade("Goiânia", "GO", true),
                new Cidade("Ribeirão Preto", "SP", false),
                new Cidade("Campinas", "SP", false),
                new Cidade("Belo Horizonte", "MG", true),
                new Cidade("Uberlândia", "MG", false),
                new Cidade("Montes Claros", "MG", false),
                new Cidade("Unaí", "MG", false),
                new Cidade("Palmas", "TO", true),
                new Cidade("Araguarí", "TO", false),
                new Cidade("Cuiabá", "MT", true),
                new Cidade("Dourados", "MS", false),
                new Cidade("Campo Grande", "MS", true),
                new Cidade("Corumbá", "MS", false),
                new Cidade("Barra do Garças", "MT", false),
                new Cidade("Araguaiana", "MT", false),
                new Cidade("Porto Velho", "RO", true),
                new Cidade("Costa Marques", "RO", false)
        ));

        //Estrutura 1 :
        Map<String, List<Cidade>> cidadesPorUf = new TreeMap<>();
        for (Cidade cidade : cidades) {
            cidadesPorUf.computeIfAbsent(cidade.getUf(), k -> new ArrayList<>()).add(cidade);
        }

        System.out.println("\nCidades agrupadas por UF (ordem alfabética de nomes):");
        for (Map.Entry<String, List<Cidade>> entry : cidadesPorUf.entrySet()) {
            List<Cidade> cidadesNaUf = entry.getValue();
            cidadesNaUf.sort(Comparator.naturalOrder());
            System.out.println(entry.getKey() + ": " + cidadesNaUf);
        }

        // Estrutura 2:
        cidades.sort(Comparator.comparing(Cidade::isCapital).reversed().thenComparing(Cidade::getNome));
        System.out.println("\nCidades com capitais primeiro e ordem alfabética:");
        for (Cidade cidade : cidades) {
            System.out.println(cidade);
        }

        // Estrutura 3:
        Set<Cidade> conjuntoCidades = new TreeSet<>(Comparator.comparing(Cidade::getNome).reversed());
        conjuntoCidades.addAll(cidades);

        System.out.println("\nCidades em ordem alfabética decrescente:");
        for (Cidade cidade : conjuntoCidades) {
            System.out.println(cidade);
        }
    }
}