package com.mariojava.service;

import com.mariojava.data.JavaTip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipService {

    private final List<JavaTip> tips = List.of(

        // ── Java 21 ──────────────────────────────────────────────────────────

        new JavaTip("1", "Java 21",
            "Virtual Threads are the Koopa Troopas of Java: lightweight, countless, and tireless! " +
            "With Thread.ofVirtual().start(), you spawn thousands of threads without burning a full " +
            "native stack — like filling an entire level with Koopas without dropping a single frame!"),

        new JavaTip("2", "Java 21",
            "Remember Mario entering multiple pipes at once in co-op mode? " +
            "Virtual Threads do exactly that on your server! With Project Loom in Java 21, " +
            "blocking I/O operations release the platform thread while they wait — " +
            "more throughput, same CPU. Warp pipes for everyone!"),

        new JavaTip("3", "Java 21",
            "Mario instantly knows how to handle each enemy: Goomba = stomp, Koopa = kick, " +
            "Piranha Plant = dodge! Pattern Matching for switch in Java 21 does the same with types: " +
            "case Goomba g -> g.stomp(). No more instanceof + cast — " +
            "the switch statement just got the Super Star treatment!"),

        new JavaTip("4", "Java 21",
            "Java 21's switch now supports guarded patterns: " +
            "case Integer i when i > 0 -> 'positive'. It's like Mario checking if the coin " +
            "is within reach before jumping! Type + condition in a single expression — " +
            "eliminates those towers of ifs that looked like Bowser's castle."),

        new JavaTip("5", "Java 21",
            "Opening an item box in Mario reveals exactly what's inside! " +
            "With Record Patterns in Java 21: case Powerup(var name, var effect), " +
            "you destructure the record directly in the pattern — no getters, no cast. " +
            "Clean and direct code, just like World 1-1."),

        new JavaTip("6", "Java 21",
            "Mario's levels have a guaranteed order: World 1-1, 1-2, 1-3... " +
            "Java 21 introduced SequencedCollection with getFirst(), getLast() and reversed()! " +
            "No more list.get(0) or list.get(list.size()-1) — accessing the first and last element " +
            "is now as straightforward as going from World 1 to World 8."),

        // ── Java 22 ──────────────────────────────────────────────────────────

        new JavaTip("7", "Java 22",
            "Shy Guys wear masks because you don't need to know their name — " +
            "just that they're in the way! Java 22 introduced unnamed variables with _: " +
            "catch (Exception _) {} or for (var _ : list) {}. " +
            "When the name doesn't matter, use _ and keep moving like Mario!"),

        new JavaTip("8", "Java 22",
            "In Java 22, _ is like that invisible block Mario knows exists but doesn't need to name! " +
            "Use it in lambdas: map.forEach((_, value) -> process(value)). " +
            "Documents intent without polluting the scope with unused variables — " +
            "clean code, less is more!"),

        new JavaTip("9", "Java 22",
            "Toad always shows up with dynamic messages: 'Thank you Mario, but the " +
            "princess is in another castle!' With String Templates in Java 22 (preview): " +
            "STR.\"Thank you \\{hero}, castle \\{number}!\" — native string interpolation in Java. " +
            "No StringBuilder, no +. Total game changer!"),

        new JavaTip("10", "Java 22",
            "Mario's scoreboard combines numbers and text in real time! " +
            "With String Templates in Java 22: STR.\"Score: \\{score} | Lives: \\{lives} | " +
            "World: \\{world}-\\{level}\". No + concatenation, no confusing String.format() — " +
            "safe and readable interpolation, like a well-designed HUD!"),

        new JavaTip("11", "Java 22",
            "Bowser lives in the native world (C/Assembly) and Mario needs to invade it safely! " +
            "Java 22 finalized the Foreign Function & Memory API: access native code and " +
            "off-heap memory without JNI. Like Mario entering the castle in full armor — " +
            "native power with the safety of Java!"),

        new JavaTip("12", "Java 22",
            "With the FFM API in Java 22, Java finally has a warp pipe straight into native code! " +
            "Use Linker.nativeLinker() and MemorySegment to call C functions and manage " +
            "memory outside the heap — native performance without the JNI nightmare. " +
            "Bowser defeated without leaving the Java castle!"),

        // ── Java 23 ──────────────────────────────────────────────────────────

        new JavaTip("13", "Java 23",
            "Java 23 let primitive types into the Pattern Matching castle (preview)! " +
            "Now case int i when i > 100 works directly in switch — primitives show up " +
            "in the pattern without needing autoboxing to get through the door. " +
            "Less boxing, more performance!"),

        new JavaTip("14", "Java 23",
            "That special coin that looks normal but is worth more? In Java 23 you tell them apart " +
            "without boxing! case double d when d == 1.0 -> 'special coin' — primitives as " +
            "first-class citizens in pattern matching (preview). No Integer.valueOf(), " +
            "no unnecessary overhead. Straight to the point!"),

        new JavaTip("15", "Java 23",
            "Java 23 brought Markdown to Javadoc! Now: /// # Bowser's Castle " +
            "instead of /** <h1>Bowser's Castle</h1> */. Swap the confusing map instructions " +
            "for a modern visual guide — same result, far more readable. " +
            "Documentation you actually want to write!"),

        new JavaTip("16", "Java 23",
            "With Markdown in Javadoc in Java 23, Toad can finally write docs " +
            "without it looking like 90s HTML! Use /// with Markdown syntax: lists with -, " +
            "code with backticks, bold with **text**. Documentation you want to read, " +
            "not fear — a Star shining bright in World 1!"),

        // ── Java 24 ──────────────────────────────────────────────────────────

        new JavaTip("17", "Java 24",
            "Stream Gatherers in Java 24 are the special power-ups the Stream API always needed! " +
            "With stream.gather(Gatherers.windowSliding(3)), you process sliding windows — " +
            "something impossible before without collecting everything first. " +
            "Custom intermediate operations unlocked. New level reached!"),

        new JavaTip("18", "Java 24",
            "Before Java 24, the Stream API was like Mario without the ability to jump — functional, " +
            "but limited! With Gatherers, implement your own Gatherer<T,A,R> for stateful operations: " +
            "scan, fold, sliding windows. " +
            "The data pipeline is now infinitely extensible. Maximum power-up!"),

        new JavaTip("19", "Java 24",
            "Java 24 shipped built-in gatherers like gifts from Toad: " +
            "Gatherers.windowFixed(3) for fixed windows, Gatherers.scan() for incremental accumulation, " +
            "Gatherers.fold() for custom reduction. " +
            "Your Stream API now has more power-ups than all of World 4 combined!"),

        new JavaTip("20", "Java 24",
            "Scoped Values in Java 24 are like the Super Star: active for a specific task, " +
            "safely shared across threads, and gone when the scope ends! " +
            "ScopedValue.where(USER, mario).run(this::saveScore) — no ThreadLocal, " +
            "no leaks. Temporary power, precise and safe!"),

        new JavaTip("21", "Java 24",
            "ThreadLocal was like a secret item in the inventory that anyone could modify — dangerous! " +
            "Scoped Values (Java 24) are immutable and scope-bound: " +
            "ScopedValue.where(LEVEL, currentLevel).call(this::playLevel). " +
            "Safe sharing across Virtual Threads. Inventory locked!"),

        new JavaTip("22", "Java 24",
            "Mario and Luigi together are unstoppable — and if Luigi falls, Mario cancels the mission! " +
            "Structured Concurrency in Java 24: try (var scope = new StructuredTaskScope" +
            ".ShutdownOnFailure()) ensures all subtasks complete or fail together. " +
            "Co-op without race conditions. Real teamwork!"),

        new JavaTip("23", "Java 24",
            "Loose threads in production are like Goombas with no direction — total chaos! " +
            "Java 24 fixes this with Structured Concurrency: tasks have a clear hierarchy, " +
            "the parent task doesn't finish before its children, and a failure cancels the group. " +
            "Order from chaos, like Mario organizing the Mushroom Kingdom. True control!"),

        new JavaTip("24", "Java 24",
            "With StructuredTaskScope.ShutdownOnSuccess, the first one to grab the flag " +
            "wins and the others stop! Perfect for fetching the fastest result from multiple sources: " +
            "scope.fork(this::fetchFromDB); scope.fork(this::fetchFromCache). " +
            "A useful race, not a race condition. Luigi or Mario — fastest wins!"),

        new JavaTip("25", "Java 21–24",
            "Java 21 + 24 = the ultimate dream team: Virtual Threads + Structured Concurrency " +
            "+ Scoped Values! Like Mario with Super Star, Fire Flower AND Tanooki Suit at the same time — " +
            "modern, safe, and scalable concurrency. " +
            "No more ExecutorService nightmares, no synchronized, no ThreadLocal. " +
            "Game Over for legacy concurrency code!")
    );

    public List<JavaTip> getAllTips() {
        return tips;
    }
}
