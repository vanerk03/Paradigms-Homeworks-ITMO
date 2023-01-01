# Решения домашних заданий по курсу Парадигмы Программирования (ITMO y2021)

### P.S. Возможно, вам будет интересно в какой среде удобнее писать домашки:
- __Java__ - VScode/Idea
- __Clojure__ - VScode + Lein (вот немного ресурсов, которые помогут вам разобраться как это поставить: https://leiningen.org/ https://www.youtube.com/watch?v=6uUynWkMDGM https://calva.io/ (расширение для vscode (линтинг кода + анализ)
- __JavaScript__ - VScode + NodeJS (для дз особо разницы не было)
- __Prolog__ - также можно в VScode, запуск через скрипт Корнеева

## Экзамен. [4 в ряд на Clojure](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/tree/master/exam).

Модификации
 * *Base*
    * Код должен находиться в файле `clojure-solutions/expression.clj`.
    * [Исходный код тестов](clojure/cljtest/parsing/ParserTest.java)
        * Запускать c указанием модификации и сложности (`easy` или `hard`).
 * *Variables* (31-33). Дополнительно реализовать поддержку:
    * Переменных, состоящих из произвольного количества букв `XYZ` в любом регистре
        * Настоящее имя переменной определяется первой буквой ее имени   


## Домашнее задание 12. [Комбинаторные парсеры](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/blob/master/clojure-solutions/expression.clj)

Модификации
 * *Base*
    * Код должен находиться в файле `clojure-solutions/expression.clj`.
    * [Исходный код тестов](clojure/cljtest/parsing/ParserTest.java)
        * Запускать c указанием модификации и сложности (`easy` или `hard`).
 * *Variables* (31-33). Дополнительно реализовать поддержку:
    * Переменных, состоящих из произвольного количества букв `XYZ` в любом регистре
        * Настоящее имя переменной определяется первой буквой ее имени   

## Домашнее задание 11. [Объектные выражения на Clojure](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/blob/master/clojure-solutions/expression.clj)

Модификации
 * *Базовая*
    * Код должен находиться в файле `clojure-solutions/expression.clj`.
    * [Исходный код тестов](clojure/cljtest/object/ObjectTest.java)
        * Запускать c указанием модификации и сложности (`easy` или `hard`).
 * *ExpLn* (32, 33). Дополнительно реализовать поддержку:
    * унарных операций:
        * `Exp` (`exp`) – экспонента, `(exp 8)` примерно равно 2981;
        * `Ln`  (`Ln`)  – натуральный логарифм абсолютной величины, `(ln 2981)` примерно равно 8.


## Домашнее задание 10. [Функциональные выражения на Clojure](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/blob/master/clojure-solutions/expression.clj)

Модификации
 * *Base*
    * Код должен находиться в файле `clojure-solutions/expression.clj`.
    * [Исходный код тестов](clojure/cljtest/functional/FunctionalTest.java)
        * Запускать c указанием модификации и сложности (`easy` или `hard`).
 * *ExpLn* (32, 33). Дополнительно реализовать поддержку:
    * унарных операций:
        * `exp` – экспонента, `(exp 8)` примерно равно 2981;
        * `ln`  – натуральный логарифм абсолютной величины, `(ln -2981)` примерно равно 8.


## Домашнее задание 9. [Линейная алгебра на Clojure](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/blob/master/clojure-solutions/linear.clj)

Модификации
 * *Базовая*
    * Код должен находиться в файле `clojure-solutions/linear.clj`.
    * [Исходный код тестов](clojure/cljtest/linear/LinearTest.java)
        * Запускать c указанием сложности (`easy` или `hard`) и модификации.
 * *Cuboid* (31, 32, 33)
    * Назовем _кубоидом_ трехмерную прямоугольную таблицу чисел.
    * Добавьте операции поэлементного 
        сложения (`c+`), вычитания (`c-`), умножения (`c*`) и деления (`cd`) 
        кубоидов.
        Например, `(с+ [[[1] [2]] [[3] [4]]] [[[5] [6]] [[7] [8]]])` 
        должно быть равно `[[[6] [8]] [[10] [12]]]`.


## Домашнее задание 8. [Обработка ошибок на JavaScript](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/blob/master/javascript-solutions/objectExpression.js)

Модификации
 * *Base*
    * Код должен находиться в файле `javascript-solutions/objectExpression.js`.
    * [Исходный код тестов](javascript/jstest/prefix/ParserTest.java)
        * Запускать c указанием модификации и сложности (`easy` или `hard`).
 * *Prefix*: *SinhCosh* (31, 32, 33). Дополнительно реализовать поддержку:
    * унарных операций:
        * `Sinh` (`sinh`) – гиперболический синус, `(sinh 3)` немного больше 10;
        * `Cosh` (`cosh`) – гиперболический косинус, `(cosh 3)` немного меньше 10.
    * [Исходный код тестов](javascript/jstest/prefix/PrefixTest.java)



## Домашнее задание 7. [Объектные выражения на JavaScript](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/blob/master/javascript-solutions/objectExpression.js)

Модификации
 * *Base*
    * Код должен находиться в файле `javascript-solutions/objectExpression.js`.
    * [Исходный код тестов](javascript/jstest/object/ObjectTest.java)
        * Запускать c указанием модификации и сложности (`easy`, `hard` или `bonus`).
 * *MinMax*. Дополнительно реализовать поддержку:
    * функций:
        * `Min3` (`min3`) – минимум из трех аргументов, `1 2 3 min` равно 1;
        * `Max5` (`max5`) – максимум из пяти аргументов, `1 2 3 4 5 max` равно 5.

## Домашнее задание 6. [Функциональные выражения на JavaScript](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/blob/master/javascript-solutions/functionalExpression.js)

Модификации
 * *Базовая*
    * Код должен находиться в файле `javascript-solutions/functionalExpression.js`.
    * [Исходный код тестов](javascript/jstest/functional/FunctionalTest.java)
        * Запускать c аргументом `hard` или `easy`;
 * *Mini* (для тестирования)
    * Не поддерживаются бинарные операции
    * Код находится в файле [functionalMiniExpression.js](javascript/functionalMiniExpression.js).
        * Запускать c аргументом `hard` или `easy`, например
          `testjs jstest.functional.MiniTest hard`
 * *Pie* (31-33). Дополнительно реализовать поддержку:
    * констант:
        * `pi` – π;
        * `e` – основание натурального логарифма;


## Домашнее задание 5. [Вычисление в различных типах](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/tree/master/java-solutions/expression)

Модификации
 * *Base*
    * Класс `expression.generic.GenericTabulator` должен реализовывать интерфейс
      [Tabulator](java/expression/generic/Tabulator.java) и
      строить трехмерную таблицу значений заданного выражения.
        * `mode` – режим вычислений:
           * `i` – вычисления в `int` с проверкой на переполнение;
           * `d` – вычисления в `double` без проверки на переполнение;
           * `bi` – вычисления в `BigInteger`.
        * `expression` – выражение, для которого надо построить таблицу;
        * `x1`, `x2` – минимальное и максимальное значения переменной `x` (включительно)
        * `y1`, `y2`, `z1`, `z2` – аналогично для `y` и `z`.
        * Результат: элемент `result[i][j][k]` должен содержать
          значение выражения для `x = x1 + i`, `y = y1 + j`, `z = z1 + k`.
          Если значение не определено (например, по причине переполнения),
          то соответствующий элемент должен быть равен `null`.
 * *Cmm* (31-39)
    * Дополнительно реализуйте унарные операции:
        * `count` – число установленных битов, `count 5` равно 2.
    * Дополнительно реализуйте бинарную операцию (минимальный приоритет):
        * `min` – минимум, `2 min 3` равно 2;
        * `max` – максимум, `2 max 3` равно 3.


## Домашнее задание 4. [Очереди](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/tree/master/java-solutions/queue)

Модификации
 * *Базовая*
    * [Исходный код тестов](java/queue/QueueTest.java)
    * [Откомпилированные тесты](artifacts/queue/QueueTest.jar)
 * *CountIf* (31-33)
    * Реализовать метод `countIf`, возвращающий число элеменов очереди, удовлетворяющих
      [предикату](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Predicate.html).


## Домашнее задание 3. [Очередь на массиве](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/tree/master/java-solutions/queue)

Модификации
 * *Базовая*
    * Классы должны находиться в пакете `queue`
    * [Исходный код тестов](java/queue/ArrayQueueTest.java)
    * [Откомпилированные тесты](artifacts/queue/ArrayQueueTest.jar)
 * *Count* (31-33)
    * Реализовать метод `count`, возвращающий число вхождений элемента в очередь.


## Домашнее задание 2. [Бинарный поиск](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/tree/master/java-solutions/search)

Модификации
 * *Базовая*
    * Класс `BinarySearch` должен находиться в пакете `search`
    * [Исходный код тестов](java/search/BinarySearchTest.java)
    * [Откомпилированные тесты](artifacts/search/BinarySearchTest.jar)
 * *Missing* (31-33)
    * На вход подаётся число `x` и массив, отсортированный по неубыванию.
    * Если в массиве отсутствует элемент, равный `x`, то требуется
      вывести индекс вставки в формате, определенном в
      [`Arrays.binarySearch`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html#binarySearch(int%5B%5D,int)).
    * Класс должен иметь имя `BinarySearchMissing`

## Домашнее задание 1. [Обработка ошибок](https://github.com/vanerk03/Paradigms-Homeworks-ITMO/tree/master/java-solutions/expression)

Модификации
 * *Base*
    * Класс `ExpressionParser` должен реализовывать интерфейс
        [TripleParser](java/expression/exceptions/TripleParser.java)
    * Классы `CheckedAdd`, `CheckedSubtract`, `CheckedMultiply`,
        `CheckedDivide` и `CheckedNegate` должны реализовывать интерфейс
        [TripleExpression](java/expression/TripleExpression.java)
    * Нельзя использовать типы `long` и `double`
    * Нельзя использовать методы классов `Math` и `StrictMath`
    * [Исходный код тестов](java/expression/exceptions/ExceptionsTest.java)
        * Первый аргумент: `easy` или `hard`
        * Последующие аргументы: модификации
 * *MinMax* (31-37)
    * Дополнительно реализуйте бинарные операции (минимальный приоритет):
        * `min` – минимум, `2 min 3` равно 2;
        * `max` – максимум, `2 max 3` равно 3.
 * *Zeroes* (31-35)
    * Дополнительно реализуйте унарные операции
      * `l0` – число старших нулевых бит, `l0 123456` равно 15;
      * `t0` – число младших нулевых бит, `t0 123456` равно 6.
