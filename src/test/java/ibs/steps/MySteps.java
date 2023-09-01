package ibs.steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;

public class MySteps {
    @Допустим("запустить jar-файл из терминала")
    public void запуститьJarФайлИзТерминала() {
    }

    @И("открыть страницу  в брузере")
    public void открытьСтраницуВБрузере() {
    }

    @И("нажать на раскрывающийся список {string}")
    public void нажатьНаРаскрывающийсяСписок(String arg0) {
    }

    @И("нажать {string} в раскрывшемся списке")
    public void нажатьВРаскрывшемсяСписке(String arg0) {
    }

    @И("нажать кнопку {string}")
    public void нажатьКнопку(String arg0) {
    }

    @И("поле {string} заполняется значением {string}")
    public void полеЗаполняетсяЗначением(String arg0, String arg1) {
    }

    @И("чек-бокс {string} значение {string}")
    public void чекбоксЗначение(String arg0, String arg1){}

    @То("в таблицу {string} добавилась строка с наименованием {string}, типом {string}, значением {string} false")
    public void результатЭкзотическийFalse(String arg0, String arg1, String arg2, String arg3){}

    @То("в таблицу {string} добавилась строка с наименованием {string}, типом {string}, значением {string} true")
    public void результатЭкзотическийTrue(String arg0, String arg1, String arg2, String arg3){}
}
