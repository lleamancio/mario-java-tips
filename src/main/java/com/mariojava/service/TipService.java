package com.mariojava.service;

import com.mariojava.data.JavaTip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipService {

    private final List<JavaTip> tips = List.of(

        // ── Java 21 ──────────────────────────────────────────────────────────

        new JavaTip("1", "Java 21",
            "Virtual Threads são os Koopa Troopas do Java: leves, numerosos e incansáveis! " +
            "Com Thread.ofVirtual().start(), você cria milhares de threads sem consumir uma " +
            "stack nativa completa — como ter um exército de Koopas preenchendo a fase sem " +
            "travar nem um frame!"),

        new JavaTip("2", "Java 21",
            "Sabe quando Mario entra em vários canos ao mesmo tempo no modo co-op? " +
            "Virtual Threads fazem isso no seu servidor! Com Project Loom no Java 21, " +
            "operações de I/O bloqueantes liberam a platform thread enquanto aguardam — " +
            "mais throughput, mesma CPU. Warp pipes para todos!"),

        new JavaTip("3", "Java 21",
            "Mario identifica cada inimigo instantaneamente: Goomba = pisar, Koopa = chutar, " +
            "Piranha Plant = desviar! Com Pattern Matching for switch do Java 21 você faz o " +
            "mesmo com tipos: case Goomba g -> g.stomp(). Chega de instanceof + cast — o " +
            "switch ganhou Estrela de Invencibilidade!"),

        new JavaTip("4", "Java 21",
            "O switch do Java 21 agora suporta guarded patterns: " +
            "case Integer i when i > 0 -> 'positivo'. É como Mario verificar se a moeda " +
            "está ao alcance antes de pular! Tipo + condição em uma única expressão — " +
            "elimina aquelas torres de ifs que pareciam o castelo do Bowser."),

        new JavaTip("5", "Java 21",
            "Abrir uma caixinha de item no Mario revela exatamente o que está dentro! " +
            "Com Record Patterns do Java 21: case Powerup(var nome, var efeito), você " +
            "desestrutura o record direto no pattern matching — sem getters, sem cast. " +
            "Código limpo e direto como a fase World 1-1."),

        new JavaTip("6", "Java 21",
            "As fases do Mario têm ordem garantida: World 1-1, 1-2, 1-3... " +
            "Java 21 trouxe SequencedCollection com getFirst(), getLast() e reversed()! " +
            "Chega de list.get(0) e list.get(list.size()-1) — acessar o início e o fim " +
            "é tão direto quanto ir do World 1 ao World 8."),

        // ── Java 22 ──────────────────────────────────────────────────────────

        new JavaTip("7", "Java 22",
            "Shy Guys usam máscara porque você não precisa saber o nome deles — " +
            "apenas que estão no caminho! Java 22 trouxe variáveis sem nome com _: " +
            "catch (Exception _) {} ou for (var _ : lista) {}. " +
            "Quando o nome não importa, use _ e avance como Mario pela fase!"),

        new JavaTip("8", "Java 22",
            "No Java 22, _ é como aquele bloco invisível que Mario sabe que existe " +
            "mas não precisa nomear! Use em lambdas: mapa.forEach((_, valor) -> processar(valor)). " +
            "Documenta a intenção sem poluir o escopo com variáveis nunca utilizadas — " +
            "código limpo, less is more!"),

        new JavaTip("9", "Java 22",
            "Toad sempre aparece com mensagens dinâmicas: 'Obrigado Mario, mas a " +
            "princesa está em outro castelo!' Com String Templates do Java 22 (preview): " +
            "STR.\"Obrigado \\{heroi}, castelo \\{numero}!\" — interpolação de strings " +
            "nativa no Java. Sem StringBuilder, sem +. Game changer!"),

        new JavaTip("10", "Java 22",
            "O placar do Mario combina números e texto em tempo real! " +
            "Com String Templates do Java 22: STR.\"Score: \\{score} | Vidas: \\{lives} | " +
            "Mundo: \\{world}-\\{level}\". Sem concatenação com +, sem String.format() confuso — " +
            "interpolação segura e legível como um HUD bem projetado!"),

        new JavaTip("11", "Java 22",
            "Bowser vive no mundo nativo (C/Assembly) e Mario precisa invadi-lo com segurança! " +
            "Java 22 estabilizou a Foreign Function & Memory API: acesse código nativo e " +
            "memória off-heap sem JNI. Como Mario entrando no castelo com armadura completa — " +
            "poder nativo com a segurança do Java!"),

        new JavaTip("12", "Java 22",
            "Com a FFM API do Java 22, o Java tem um warp pipe direto para o código nativo! " +
            "Use Linker.nativeLinker() e MemorySegment para chamar funções C e gerenciar " +
            "memória fora do heap — performance nativa sem o pesadelo do JNI. " +
            "Bowser vencido sem sair do castelo Java!"),

        // ── Java 23 ──────────────────────────────────────────────────────────

        new JavaTip("13", "Java 23",
            "Java 23 deixou os tipos primitivos entrarem no castelo do Pattern Matching (preview)! " +
            "Agora case int i when i > 100 funciona diretamente no switch — Bowser (primitivos) " +
            "aparece no pattern sem precisar de autoboxing para entrar pela porta. " +
            "Menos boxing, mais performance!"),

        new JavaTip("14", "Java 23",
            "Aquela moeda especial que parece normal mas vale mais? No Java 23 você distingue " +
            "sem boxing! case double d when d == 1.0 -> 'moeda especial' — primitivos como " +
            "cidadãos de primeira classe no pattern matching (preview). Sem Integer.valueOf(), " +
            "sem overhead desnecessário. Direto ao ponto!"),

        new JavaTip("15", "Java 23",
            "Java 23 trouxe Markdown para o Javadoc! Agora: /// # Castelo do Bowser " +
            "ao invés de /** <h1>Castelo do Bowser</h1> */. Troque as instruções confusas " +
            "do mapa do Mario por um guia visual moderno — mesmo resultado, muito mais " +
            "legível. Documentação que você quer escrever!"),

        new JavaTip("16", "Java 23",
            "Com Markdown no Javadoc do Java 23, o Toad finalmente escreve documentação " +
            "sem parecer HTML dos anos 90! Use /// com sintaxe Markdown: listas com -, " +
            "código com backticks, negrito com **texto**. Documentação que você quer ler, " +
            "não temer — uma Estrela brilhando no World 1!"),

        // ── Java 24 ──────────────────────────────────────────────────────────

        new JavaTip("17", "Java 24",
            "Stream Gatherers do Java 24 são os power-ups especiais que a Stream API " +
            "sempre precisou! Com stream.gather(Gatherers.windowSliding(3)), você processa " +
            "janelas deslizantes — algo impossível sem coletar tudo antes. " +
            "Operações intermediárias customizadas desbloqueadas. Fase nova no jogo!"),

        new JavaTip("18", "Java 24",
            "Antes do Java 24, a Stream API era como Mario sem poder pular — funcional, " +
            "mas limitada! Com Gatherers, implemente seu próprio Gatherer<T,A,R> para " +
            "operações stateful: scan, fold, janelas deslizantes. " +
            "O pipeline de dados agora é infinitamente extensível. Power-up máximo!"),

        new JavaTip("19", "Java 24",
            "Java 24 trouxe gatherers embutidos como presentes do Toad: " +
            "Gatherers.windowFixed(3) para janelas fixas, Gatherers.scan() para acúmulo " +
            "incremental, Gatherers.fold() para redução customizada. " +
            "Sua Stream API agora tem mais power-ups do que o World 4 inteiro!"),

        new JavaTip("20", "Java 24",
            "Scoped Values do Java 24 são como a Estrela de Invencibilidade: ativa para " +
            "uma tarefa, compartilhada com segurança entre threads, e expira ao fim do escopo! " +
            "ScopedValue.where(USUARIO, mario).run(this::salvarPontuacao) — sem ThreadLocal, " +
            "sem vazamentos. Poder temporário, seguro e preciso!"),

        new JavaTip("21", "Java 24",
            "ThreadLocal era como um item secreto no inventário que qualquer um podia " +
            "modificar — perigoso! Scoped Values (Java 24) são imutáveis e limitados ao escopo: " +
            "ScopedValue.where(FASE, faseAtual).call(this::jogarFase). " +
            "Compartilhamento seguro entre Virtual Threads. Inventário protegido!"),

        new JavaTip("22", "Java 24",
            "Mario e Luigi juntos são imbatíveis — e se Luigi cair, Mario cancela a missão! " +
            "Structured Concurrency do Java 24: try (var scope = new StructuredTaskScope" +
            ".ShutdownOnFailure()) garante que todas as subtarefas completem ou falhem " +
            "juntas. Co-op sem race conditions. Trabalho em equipe de verdade!"),

        new JavaTip("23", "Java 24",
            "Threads soltas em produção são como Goombas sem direção — caos total! " +
            "Java 24 resolve com Structured Concurrency: tasks têm hierarquia clara, " +
            "a task pai não termina antes dos filhos, e falhas cancelam o grupo. " +
            "Ordem no caos, como Mario organizando o Reino Cogumelo. Controle real!"),

        new JavaTip("24", "Java 24",
            "Com StructuredTaskScope.ShutdownOnSuccess, o primeiro a pegar a bandeira " +
            "vence e os outros param! Perfeito para buscar o resultado mais rápido entre " +
            "múltiplas fontes: scope.fork(this::buscarDoBanco); scope.fork(this::buscarDoCache). " +
            "Race útil, não race condition. Luigi ou Mario — o mais rápido vence!"),

        new JavaTip("25", "Java 21–24",
            "Java 21 + 24 = o dream team definitivo: Virtual Threads + Structured Concurrency " +
            "+ Scoped Values! Como Mario com Super Estrela, Fire Flower E Tanooki Suit " +
            "simultaneamente — concorrência moderna, segura e escalável. " +
            "Sem os pesadelos de ExecutorService, synchronized e ThreadLocal. " +
            "Game Over para o código legado!")
    );

    public List<JavaTip> getAllTips() {
        return tips;
    }
}
