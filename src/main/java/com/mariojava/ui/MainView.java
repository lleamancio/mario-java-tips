package com.mariojava.ui;

import com.mariojava.data.JavaTip;
import com.mariojava.service.TipService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Route("")
@PageTitle("Mario Java Tips")
public class MainView extends VerticalLayout {

    private final TipService tipService;
    private final List<JavaTip> allTips;
    private List<JavaTip> remainingTips;

    private JavaTip currentTip;
    private int shownCount = 0;
    private boolean darkMode = true;

    // UI refs
    private Div       appWrapper;
    private Div       card;
    private Span      versionBadge;
    private Paragraph tipText;
    private Span      tipCounter;
    private Button    darkModeToggle;

    public MainView(TipService tipService) {
        this.tipService     = tipService;
        this.allTips        = tipService.getAllTips();
        resetTips();

        setPadding(false);
        setMargin(false);
        setSpacing(false);
        setSizeFull();

        buildUI();

        // Apply saved dark mode after attach
        addAttachListener(e -> applyDarkMode(false));
    }

    // ── Tip cycling ─────────────────────────────────────────────────────────

    private void resetTips() {
        remainingTips = new ArrayList<>(allTips);
        Collections.shuffle(remainingTips);
        shownCount = 0;
    }

    private JavaTip nextTip() {
        if (remainingTips.isEmpty()) {
            resetTips();
        }
        shownCount++;
        return remainingTips.remove(0);
    }

    private void displayTip(JavaTip tip) {
        currentTip = tip;

        // Badge text + version-specific colour class
        versionBadge.setText(tip.javaVersion());
        versionBadge.removeClassNames("badge-v21", "badge-v22", "badge-v23", "badge-v24", "badge-vrange");
        versionBadge.addClassName(versionClass(tip));

        // Card glow tint (dark mode picks it up via CSS)
        card.removeClassNames("badge-v21", "badge-v22", "badge-v23", "badge-v24", "badge-vrange");
        card.addClassName(versionClass(tip));

        tipText.setText(tip.tipText());
        tipCounter.setText("Tip " + shownCount + " of " + allTips.size());

        // Restart the fade-in animation
        UI.getCurrent().getPage().executeJs(
                "var c = document.querySelector('.tip-card');" +
                "if(c){c.classList.remove('tip-fade-in');void c.offsetWidth;" +
                "c.classList.add('tip-fade-in');}");
    }

    private String versionClass(JavaTip tip) {
        return switch (tip.javaVersion()) {
            case "Java 21"    -> "badge-v21";
            case "Java 22"    -> "badge-v22";
            case "Java 23"    -> "badge-v23";
            case "Java 24"    -> "badge-v24";
            default           -> "badge-vrange";
        };
    }

    // ── UI construction ─────────────────────────────────────────────────────

    private void buildUI() {
        appWrapper = new Div();
        appWrapper.setId("app-wrapper");
        appWrapper.addClassNames("app-wrapper", "dark-mode");

        // ── Top bar: dark-mode toggle ────────────────────────────────────────
        Div topBar = new Div();
        topBar.addClassName("top-bar");

        darkModeToggle = new Button("🌙");
        darkModeToggle.addClassName("toggle-btn");
        darkModeToggle.getElement().setAttribute("title", "Alternar modo escuro");
        darkModeToggle.addClickListener(e -> {
            darkMode = !darkMode;
            applyDarkMode(true);
        });
        topBar.add(darkModeToggle);

        // ── Title ─────────────────────────────────────────────────────────────
        Div titleSection = new Div();
        titleSection.addClassName("title-section");

        H1 title = new H1("🍄 Mario Java Tips");
        title.addClassName("main-title");

        Paragraph subtitle = new Paragraph("Learn Java through the Mushroom Kingdom");
        subtitle.addClassName("subtitle");

        titleSection.add(title, subtitle);

        // ── Tip card ─────────────────────────────────────────────────────────
        card = new Div();
        card.addClassName("tip-card");

        Div badgeRow = new Div();
        badgeRow.addClassName("badge-row");

        versionBadge = new Span("Java ??");
        versionBadge.addClassName("version-badge");
        badgeRow.add(versionBadge);

        tipText = new Paragraph();
        tipText.addClassName("tip-text");

        card.add(badgeRow, tipText);

        // ── Counter ──────────────────────────────────────────────────────────
        tipCounter = new Span();
        tipCounter.addClassName("tip-counter");

        // ── Buttons ──────────────────────────────────────────────────────────
        Button nextBtn = new Button("Next Tip 🍄");
        nextBtn.addClassName("btn-primary");
        nextBtn.addClickListener(e -> displayTip(nextTip()));

        Button copyBtn = new Button("Copy to LinkedIn 📋");
        copyBtn.addClassName("btn-secondary");
        copyBtn.addClickListener(e -> copyToClipboard());

        Div btnRow = new Div(nextBtn, copyBtn);
        btnRow.addClassName("btn-row");

        // ── Footer ────────────────────────────────────────────────────────────
        Div footer = new Div();
        footer.addClassName("footer");

        Span footerText = new Span("Made with ☕ by ");
        footerText.addClassName("footer-text");

        Anchor footerLink = new Anchor(
                "https://www.linkedin.com/in/leticiaamancio/",
                "Leticia Amancio"
        );
        footerLink.setTarget("_blank");
        footerLink.getElement().setAttribute("rel", "noopener noreferrer");
        footerLink.addClassName("footer-link");

        footer.add(footerText, footerLink);

        // ── Assemble ─────────────────────────────────────────────────────────
        appWrapper.add(topBar, titleSection, card, tipCounter, btnRow, footer);
        add(appWrapper);

        // Show the first tip
        displayTip(nextTip());
    }

    // ── Actions ─────────────────────────────────────────────────────────────

    private void copyToClipboard() {
        if (currentTip == null) return;

        String formatted =
                "🍄 Java Tip of the Day — " + currentTip.javaVersion() + "\n\n"
                + currentTip.tipText() + "\n\n"
                + "#Java #JavaDev #MarioBrosDay";

        // $0 is safely escaped by Vaadin's executeJs
        UI.getCurrent().getPage().executeJs(
                "var t = $0;" +
                "if (navigator.clipboard) {" +
                "  navigator.clipboard.writeText(t).catch(function(){fallbackCopy(t)});" +
                "} else { fallbackCopy(t); }" +
                "function fallbackCopy(text){" +
                "  var el = document.createElement('textarea');" +
                "  el.value = text; el.style.position='fixed'; el.style.opacity='0';" +
                "  document.body.appendChild(el); el.select();" +
                "  document.execCommand('copy'); document.body.removeChild(el);" +
                "}",
                formatted
        );

        Notification.show("Copied! Paste it on LinkedIn now \uD83C\uDF89", 3000,
                Notification.Position.BOTTOM_CENTER);
    }

    private void applyDarkMode(boolean animate) {
        if (darkMode) {
            appWrapper.removeClassName("light-mode");
            appWrapper.addClassName("dark-mode");
            darkModeToggle.setText("☀️");
        } else {
            appWrapper.removeClassName("dark-mode");
            appWrapper.addClassName("light-mode");
            darkModeToggle.setText("🌙");
        }
        // Sync the <html> element so CSS :root variables switch too
        UI.getCurrent().getPage().executeJs(
                "if ($0) { document.documentElement.classList.add('dark-mode'); }" +
                "else     { document.documentElement.classList.remove('dark-mode'); }",
                darkMode
        );
    }
}
