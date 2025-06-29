package org.sleighbells.joy.taskmanagement.ui.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("kino-Mania")
public class TaskListView extends VerticalLayout {

    public TaskListView() {
        // Настройка шапки сайта
        add(createHeader());

        // Основное содержимое
        add(createScheduleSection());
    }

    private Component createHeader() {
        // Логотип в левом верхнем углу
        Image logo = new Image("images/logo.png", "KinoMania");
        logo.setWidth("150px");

        // Меню навигации
        HorizontalLayout menu = new HorizontalLayout();
        menu.addClassName(LumoUtility.Padding.SMALL);

        // Выпадающее меню для выбора города
        Span cityDropdown = new Span("Миасс ▼");
        cityDropdown.addClassName(LumoUtility.TextColor.SECONDARY);

        // Пункты меню
        Button scheduleButton = new Button("Расписание");
        Button moviesButton = new Button("Фильмы");
        Button loginButton = new Button("Войти");
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        menu.add(cityDropdown, scheduleButton, moviesButton, loginButton);

        // Шапка сайта
        HorizontalLayout header = new HorizontalLayout(logo, menu);
        header.setWidthFull();
        header.setAlignItems(Alignment.CENTER);
        header.addClassName(LumoUtility.Padding.MEDIUM);
        header.addClassName(LumoUtility.Background.CONTRAST_5);

        return header;
    }

    private Component createScheduleSection() {
        // Заголовок
        H1 title = new H1("Расписание сеансов");
        String BOTTOM_SMALL = "";
        title.addClassName(BOTTOM_SMALL);

        // Блоки для выбора даты
        HorizontalLayout dateBlocks = new HorizontalLayout();
        dateBlocks.addClassName(LumoUtility.Gap.SMALL);

        // Сегодня (08 апреля)
        Div todayBlock = createDateBlock("Сегодня", "08 апреля");

        // Завтра (09 апреля)
        Div tomorrowBlock = createDateBlock("Завтра", "09 апреля");

        // Четверг (10 апреля)
        Div thursdayBlock = createDateBlock("Четверг", "10 апреля");

        dateBlocks.add(todayBlock, tomorrowBlock, thursdayBlock);

        // Основной контейнер
        VerticalLayout scheduleSection = new VerticalLayout(title, dateBlocks);
        scheduleSection.setWidthFull();
        scheduleSection.addClassName(LumoUtility.Padding.MEDIUM);

        return scheduleSection;
    }

    private Div createDateBlock(String label, String date) {
        Div block = new Div();
        block.add(new Span(label), new Span(date));
        block.addClassName(LumoUtility.Background.CONTRAST_5);
        block.addClassName(LumoUtility.Padding.SMALL);
        block.addClassName(LumoUtility.BorderRadius.SMALL);
        block.getStyle().set("cursor", "pointer");
        return block;
    }

    private class BOTTOM_SMALL {
    }
}