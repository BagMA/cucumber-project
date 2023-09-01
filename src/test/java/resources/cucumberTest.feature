# language: ru

  @all
  Функция: Проверка добавления товара в таблицу "Список товаров" типа "Овощ"

    Предыстория:
      Допустим запустить jar-файл из терминала
      И открыть страницу  в брузере
      И нажать на раскрывающийся список "Песочница"
      И нажать "Товары" в раскрывшемся списке
      И нажать кнопку "Добавить"

      @correct
      Сценарий: успешное добавление товара типа "Овощ" в список
        И поле "Наименование" заполняется значением "Картофель"
        И поле "Тип" заполняется значением "Овощ"
        И чек-бокс "Экзотический" значение "не отмечен"
        И нажать кнопку "Сохранить"
        То в таблицу "Список товаров" добавилась строка с наименованием "Картофель", типом "Овощ", значением "Экзотический" false

      @correct
      Сценарий: успешное добавление товара типа "Фрукт" в список
        И поле "Наименование" заполняется значением "Ананас"
        И поле "Тип" заполняется значением "Фрукт"
        И чек-бокс "Экзотический" значение "отмечен"
        И нажать кнопку "Сохранить"
        То в таблицу "Список товаров" добавилась строка с наименованием "Ананас", типом "Фрукт", значением "Экзотический" true