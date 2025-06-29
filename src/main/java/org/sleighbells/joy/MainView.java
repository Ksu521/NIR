package org.sleighbells.joy;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("main")
@CssImport("./themes/default/styles.css") // подключаем файл стилей
public class MainView extends VerticalLayout {

    public MainView() {
        add(createHeader(), createMainContent());
    }

    private Component createHeader() {
        Header header = new Header();
        HorizontalLayout layout = new HorizontalLayout();

        // Логотип

        // Меню навигации
        HorizontalLayout menu = new HorizontalLayout();

        // Выпадающее меню для выбора города
        ComboBox<String> citySelector = new ComboBox<>("Город");
        citySelector.setItems("Миасс", "Челябинск", "Екатеринбург");
        citySelector.setValue("Миасс"); // По умолчанию выбран Миасс
        menu.add(citySelector);

        // Ссылки на страницы
        Button scheduleButton = new Button("Расписание", e -> {
            // Логика перехода к расписанию
        });
        Button moviesButton = new Button("Фильмы", e -> {
            // Логика перехода к списку фильмов
        });
        Button loginButton = new Button("Войти", e -> {
            // Логика входа в личный кабинет
        });
loginButton.getStyle().setFlexGrow("1");

        menu.add(scheduleButton, moviesButton, loginButton);
        layout.add(menu);
        header.add(layout);
        return header;
    }

    private Component createMainContent() {
        Div mainContent = new Div();
        mainContent.add(new H1("Расписание сеансов"));

        // Выбор даты
        HorizontalLayout dateSelection = new HorizontalLayout();
        Button todayButton = new Button("Сегодня (08 апреля)", e -> {
            // Логика для отображения расписания на сегодня
        });
        Button tomorrowButton = new Button("Завтра (09 апреля)", e -> {
            // Логика для отображения расписания на завтра
        });
        Button thursdayButton = new Button("Четверг (10 апреля)", e -> {
            // Логика для отображения расписания на четверг
        });

        dateSelection.add(todayButton, tomorrowButton, thursdayButton);
        mainContent.add(dateSelection);
        return mainContent;
    }
}

