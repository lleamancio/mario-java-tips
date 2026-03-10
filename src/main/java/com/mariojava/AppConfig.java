package com.mariojava;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Meta;
import com.vaadin.flow.theme.Theme;

@Theme("mario-java-tips")
@Meta(name = "viewport", content = "width=device-width, initial-scale=1")
@Meta(name = "description", content = "Dicas de Java dos releases mais recentes com analogias do Mario Bros — celebrando Mario Bros Day!")
public class AppConfig implements AppShellConfigurator {
}
