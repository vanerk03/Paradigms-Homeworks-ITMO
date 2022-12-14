# Тесты к курсу «Парадигмы программирования»

[Условия домашних заданий](https://www.kgeorgiy.info/courses/paradigms/homeworks.html)


## Домашнее задание X. Простые числа на Prolog

Модификации
 * *Базовая*
    * Код должен находиться в файле `prolog-solutions/primes.pl`.
    * [Исходный код тестов](prolog/prtest/primes/PrologPrimesTest.java)
        * Запускать c указанием сложности (`easy`, `hard` или `bonus`) и модификации.


## Исходный код к лекциям по Prolog

Запуск Prolog
 * [Windows](prolog/RunProlog.cmd)
 * [*nix](prolog/RunProlog.sh)

Лекция 1. Факты, правила и вычисления
 * [Учебный план](prolog/examples/1_1_plan.pl)
 * [Вычисления](prolog/examples/1_2_calc.pl)
 * [Списки](prolog/examples/1_3_lists.pl)
 * [Правила высшего порядка](prolog/examples/1_4_high-order.pl)


## Домашнее задание 12. Комбинаторные парсеры

Модификации
 * *Base*
    * Код должен находиться в файле `clojure-solutions/expression.clj`.
    * [Исходный код тестов](clojure/cljtest/parsing/ParserTest.java)
        * Запускать c указанием модификации и сложности (`easy` или `hard`).
 * *Variables* (31-33). Дополнительно реализовать поддержку:
    * Переменных, состоящих из произвольного количества букв `XYZ` в любом регистре
        * Настоящее имя переменной определяется первой буквой ее имени
 * *Bitwise* (34-35). Сделать модификацию *Variables* и дополнительно реализовать поддержку:
    * Побитовых операций
        * `BitAnd` (`&`) – и: `5 & 6` равно 4
        * `BitOr` (`|`) - или: `5 | 6` равно 7
        * `BitXor` (`^`) - исключающее или: `5 ^ 6` примерно равно 1.66881E-308
        * для реализации операций используйте
            [doubleToLongBits](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Double.html#doubleToLongBits(double))
            и [longBitsToDouble](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Double.html#longBitsToDouble(long))
        * операции по увеличению приоритета: `^`, `|`, `&`, операции базовой модификации
 * *PowLog* (36-37). Сделать модификацию *Variables* и дополнительно реализовать поддержку:
    * Бинарных правоассоциативных операций максимального приоритета:
        * `IPow` (`**`) – возведения в степень:
            `4 ** 3 ** 2` равно `4 ** (3 ** 2)` равно 262144
        * `ILog` (`//`) – взятия логарифма (абсолютной величины по основанию абсолютной величины):
            `8 // 9 // 3` равно `8 // (9 // 3)` равно 3
 * *BitImplIff*. Сделать модификацию *Bitwise* и дополнительно реализовать поддержку:
    * Побитовых операций
        * `BitImpl` (`=>`) – импликация (правоассоциативна): `4 => 1` примерно равно -2
        * `BitIff` (`<=>`) - тогда и только тогда: `2 <=> 6` примерно равно -1.34827E308
        * операции по увеличению приоритета: `<=>`, `=>`, операции модификации *Bitwise*
   

## Домашнее задание 11. Объектные выражения на Clojure

Модификации
 * *Базовая*
    * Код должен находиться в файле `clojure-solutions/expression.clj`.
    * [Исходный код тестов](clojure/cljtest/object/ObjectTest.java)
        * Запускать c указанием модификации и сложности (`easy` или `hard`).
 * *MeanVarn* (36, 37). Дополнительно реализовать поддержку:
    * операций произвольного числа аргументов:
        * `Mean` (`mean`) – математическое ожидание аргументов, `(mean 1 2 6)` равно 3;
        * `Varn` (`varn`) – дисперсия аргументов, `(varn 2 5 11)` равно 14;
 * *SumexpSoftmax*. Дополнительно реализовать поддержку:
    * операций произвольного числа аргументов:
        * `Sumexp` (`sumexp`) – сумма экспонент, `(sumexp 8 8 9)` примерно равно 14065;
        * `Softmax` (`Softmax`) – [softmax](https://ru.wikipedia.org/wiki/Softmax) первого аргумента, `(softmax 1 2 3)` примерно равно 0.09;
 * *PowLog* (31, 34, 35). Дополнительно реализовать поддержку:
    * бинарных операций:
        * `Pow` (`pow`) – возведение в степень, `(pow 2 3)` равно 8;
        * `Log` (`log`) – логарифм абсолютной величины по основанию абсолютной величины, `(log -2 -8)` равно 3.
 * *ExpLn* (32, 33). Дополнительно реализовать поддержку:
    * унарных операций:
        * `Exp` (`exp`) – экспонента, `(exp 8)` примерно равно 2981;
        * `Ln`  (`Ln`)  – натуральный логарифм абсолютной величины, `(ln 2981)` примерно равно 8.


## Домашнее задание 10. Функциональные выражения на Clojure

Модификации
 * *Base*
    * Код должен находиться в файле `clojure-solutions/expression.clj`.
    * [Исходный код тестов](clojure/cljtest/functional/FunctionalTest.java)
        * Запускать c указанием модификации и сложности (`easy` или `hard`).
 * *MeanVarn* (36, 37). Дополнительно реализовать поддержку:
    * операций произвольного числа аргументов:
        * `mean` – математическое ожидание аргументов, `(mean 1 2 6)` равно 3;
        * `varn` – дисперсия аргументов, `(varn 2 5 11)` равно 14;
 * *SumexpSoftmax* (38, 39). Дополнительно реализовать поддержку:
    * операций произвольного числа аргументов:
        * `sumexp` – сумма экспонент, `(sumexp 8 8 9)` примерно равно 14065;
        * `softmax` – [softmax](https://ru.wikipedia.org/wiki/Softmax) первого аргумента, `(softmax 1 2 3)` примерно равно 0.09;
 * *PowLog* (31, 34, 35). Дополнительно реализовать поддержку:
    * бинарных операций:
        * `pow` – возведение в степень, `(pow 2 3)` равно 8;
        * `log` – логарифм абсолютной величины по основанию абсолютной величины, `(log -2 -8)` равно 3.
 * *ExpLn* (32, 33). Дополнительно реализовать поддержку:
    * унарных операций:
        * `exp` – экспонента, `(exp 8)` примерно равно 2981;
        * `ln`  – натуральный логарифм абсолютной величины, `(ln -2981)` примерно равно 8.


## Домашнее задание 9. Линейная алгебра на Clojure

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
 * *Shapeless* (34, 35)
    * Добавьте операции поэлементного 
        сложения (`s+`), вычитания (`s-`), умножения (`s*`) и деления (`sd`)
        чисел и векторов любой (в том числе, переменной) формы.
        Например, `(s+ [[1 2] 3] [[4 5] 6])` 
        должно быть равно `[[5 7] 9]`.
 * *Simplex* (36, 37)
    * Назовем _симплексом_ многомерную таблицу чисел, 
      такую что для некоторого `n` в ней существуют все значения
      с суммой индексов не превышающей `n` и только эти значения.
    * Добавьте операции поэлементного 
        сложения (`x+`), вычитания (`x-`), умножения (`x*`) и деления (`xd`) 
        симплексов.
        Например, `(x+ [[1 2] [3]] [[5 6] [7]])` 
        должно быть равно `[[6 8] [10]]`.
    * [Исходный код тестов](clojure/cljtest/linear/SimplexTester.java)
 * *Broadcast* (38, 39)
    * Назовем _тензором_ многомерную прямоугольную таблицу чисел.
    * _Форма_ тензора – последовательность чисел
        (_s_<sub>1..n</sub>)=(_s_<sub>1</sub>, _s_<sub>2</sub>, …, _s<sub>n</sub>_), где
        _n_ – размерность тензора, а _s<sub>i</sub>_ – число элементов
        по _i_-ой оси.
      Например, форма тензора `[[[2 3 4] [5 6 7]]]`  равна (1, 2, 3),
      а форма `1` равна ().
    * Тензор формы (_s_<sub>1.._n_</sub>) может быть _распространен_ (broadcast)
      до тензора формы (_u_<sub>1.._m_</sub>), если (_s_<sub>i.._n_</sub>) является
      суффиксом (_u<sub>1..m</sub>_). 
      Для этого, исходный тензор копируется по недостающим осям.
      Например, распространив тензор `[ [2] [3] ]` формы (2, 1) до
      формы (3, 2, 1) получим `[ [ [2] [3] ] [ [2] [3] ] [ [2] [3] ] ]`,
      а распространив `1` до формы (2, 3) получим `[ [1 1 1] [1 1 1] ]`.
    * Тензоры называются совместимыми, если один из них может быть распространен
      до формы другого.
      Например, тензоры формы (3, 2, 1) и (2, 1) совместимы, а
      (3, 2, 1) и (1, 2) – нет. Числа совместимы с тензорами любой формы.
    * Добавьте операции поэлементного 
      сложения (`hb+`), вычитания (`hb-`), умножения (`hb*`) и деления (`hbd`)
      совместимых тензоров.
      Если формы тензоров не совпадают, то тензоры меньшей размерности
      должны быть предварительно распространены до тензоров большей размерности.
      Например, `(hb+ 1 [ [10 20 30] [40 50 60] ] [100 200 300] )` 
      должно быть равно `[ [111 221 331] [141 251 361] ]`.
    * [Исходный код тестов](clojure/cljtest/linear/HeadBroadcastTester.java)


## Исходный код к лекциям по Clojure

Документация
 * [Clojure Reference](https://clojure.org/reference/documentation)
 * [Clojure Cheat Sheet](https://clojure.org/api/cheatsheet)

Запуск Clojure
 * Консоль: [Windows](clojure/RunClojure.cmd), [*nix](clojure/RunClojure.sh)
    * Интерактивный: `RunClojure`
    * С выражением: `RunClojure --eval "<выражение>"`
    * Скрипт: `RunClojure <файл скрипта>`
    * Справка: `RunClojure --help`
 * IDE
    * IntelliJ Idea: [плагин Cursive](https://cursive-ide.com/userguide/)
    * Eclipse: [плагин Counterclockwise](https://marketplace.eclipse.org/content/counterclockwise)

[Скрипт со всеми примерами](clojure/examples.clj)

Лекция 1. Функции
 * [Введение](clojure/examples/1_1_intro.clj)
 * [Функции](clojure/examples/1_2_functions.clj)
 * [Списки](clojure/examples/1_3_lists.clj)
 * [Вектора](clojure/examples/1_4_vectors.clj)
 * [Функции высшего порядка](clojure/examples/1_5_functions-2.clj)

Лекция 2. Внешний мир
 * [Ввод-вывод](clojure/examples/2_1_io.clj)
 * [Разбор и гомоиконность](clojure/examples/2_2_read.clj)
 * [Порядки вычислений](clojure/examples/2_3_evaluation-orders.clj)
 * [Потоки](clojure/examples/2_4_streams.clj)
 * [Отображения и множества](clojure/examples/2_5_maps.clj)

Лекция 3. Объекты
 * [Прототипное наследование](clojure/examples/3_1_js-objects.clj)
    * Библиотека для ДЗ: [proto.clj](clojure/examples/proto.clj)
 * [Java-классы](clojure/examples/3_2_java-objects.clj)
    
Лекция 4. Разное
 * [Макросы](clojure/examples/4_1_macro.clj)
 * [Изменяемое состояние](clojure/examples/4_2_mutable-state.clj)
 * [Числа Чёрча](clojure/examples/4_3_church.clj)

Лекция 5. Комбинаторные парсеры
 * [Базовые функции](clojure/examples/5_1_base.clj)
 * [Комбинаторы](clojure/examples/5_2_combinators.clj)
    * Библиотека для ДЗ [parser.clj](clojure/examples/parser.clj)
 * [JSON](clojure/examples/5_3_json.clj)
 * [Макросы](clojure/examples/5_4_macro.clj)


## Домашнее задание 8. Обработка ошибок на JavaScript

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
 * *Prefix*: *MeanVar* (34, 35). Дополнительно реализовать поддержку:
    * операций произвольного числа аргументов:
        * `Mean` (`mean`) – математическое ожидание аргументов, `(mean 1 2 6)` равно 3;
        * `Var` (`var`) – дисперсия аргументов, `(var 2 5 11)` равно 14.
    * [Исходный код тестов](javascript/jstest/prefix/PrefixTest.java)
 * *PostfixMeanVar* (36, 37). Дополнительно реализовать поддержку:
    * выражений в постфиксной записи: `(2 3 +)` равно 5
    * операций произвольного числа аргументов:
        * `Mean` (`mean`) – математическое ожидание аргументов, `(1 2 6 mean)` равно 3;
        * `Var` (`var`) – дисперсия аргументов, `(2 5 11 var)` равно 14.
    * [Исходный код тестов](javascript/jstest/prefix/PostfixTest.java)
 * *PostfixSumexpSoftmax* (38, 39). Дополнительно реализовать поддержку:
    * выражений в постфиксной записи: `(2 3 +)` равно 5
    * унарных операций:
        * `Sumexp` (`sumexp`) – сумма экспонент, `(8 8 9 sumexp)` примерно равно 14065;
        * `Softmax` (`softmax`) – [softmax](https://ru.wikipedia.org/wiki/Softmax) первого аргумента, `(1 2 3 softmax)` примерно 0.09.
    * [Исходный код тестов](javascript/jstest/prefix/PostfixTest.java)



## Домашнее задание 7. Объектные выражения на JavaScript

Модификации
 * *Base*
    * Код должен находиться в файле `javascript-solutions/objectExpression.js`.
    * [Исходный код тестов](javascript/jstest/object/ObjectTest.java)
        * Запускать c указанием модификации и сложности (`easy`, `hard` или `bonus`).
 * *SinhCosh* (31, 34, 45). Дополнительно реализовать поддержку:
    * унарных функций:
        * `Sinh` (`sinh`) – гиперболический синус, `3 sinh` немного больше 10;
        * `Cosh` (`cosh`) – гиперболический косинус, `3 cosh` немного меньше 10.
 * *MinMax*. Дополнительно реализовать поддержку:
    * функций:
        * `Min3` (`min3`) – минимум из трех аргументов, `1 2 3 min` равно 1;
        * `Max5` (`max5`) – максимум из пяти аргументов, `1 2 3 4 5 max` равно 5.
 * *PowLog* (36, 37). Дополнительно реализовать поддержку:
    * бинарных операций:
        * `Power` (`pow`) – возведение в степень, `2 3 pow` равно 8;
        * `Log` (`log`) – логарифм абсолютного значения аргумента
            по абсолютному значению основания `-2 -8 log` равно 3.
 * *Gauss* (38, 39). Дополнительно реализовать поддержку:
    * функций:
        * `Gauss` (`gauss`) – [функция Гаусса](https://ru.wikipedia.org/wiki/%D0%93%D0%B0%D1%83%D1%81%D1%81%D0%BE%D0%B2%D0%B0_%D1%84%D1%83%D0%BD%D0%BA%D1%86%D0%B8%D1%8F);
          от четырех аргументов: `a`, `b`, `c`, `x`.

## Домашнее задание 6. Функциональные выражения на JavaScript

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
 * *PieSinhCosh* (34, 35). Дополнительно реализовать поддержку:
    * модификации *Pie*
    * операций:
        * `sinh` – гиперболический синус, `(sinh 3)` немного больше 10;
        * `cosh` – гиперболический косинус, `(cosh 3)` немного меньше 10.
 * *PieIffAbs* (36, 37). Дополнительно реализовать поддержку:
    * модификации *Pie*
    * операций:
        * `abs` – абсолютное значение, `-2 abs` равно 2;
        * `iff` – условный выбор:
            если первый аргумент неотрицательный,
            вернуть второй аргумент,
            иначе вернуть первый третий аргумент.
            * `one two 3 iff` равно 2
            * `-1 -2 -3 iff` равно -3
            * `0 one two iff` равно 1;
 * *PieAvgMed* (38, 39). Дополнительно реализовать поддержку:
    * модификации *Pie*
    * операций:
        * `avg3` – арифметическое среднее трёх аргументов, `1 2 3 avg3` равно 2;
        * `med5` – медиана пяти аргументов, `1 2 -10 100 -100 med5` равно 1.


Запуск тестов
 * Для запуска тестов используется [GraalJS](https://github.com/graalvm/graaljs)
   (часть проекта [GraalVM](https://www.graalvm.org/), вам не требуется их скачивать отдельно)
 * Для запуска тестов можно использовать скрипты [TestJS.cmd](javascript/TestJS.cmd) и [TestJS.sh](javascript/TestJS.sh)
    * Репозиторий должен быть скачан целиком.
    * Скрипты должны находиться в каталоге `javascript` (их нельзя перемещать, но можно вызывать из других каталогов).
    * В качестве аргументов командной строки указывается полное имя класса теста и модификация, 
      например `jstest.functional.FunctionalTest hard base`.
 * Для самостоятельно запускаго из консоли необходимо использовать командную строку вида:
    `java -ea --module-path=<js>/graal --class-path <js> jstest.functional.FunctionalTest {hard|easy} <variant>`, где
    * `-ea` – включение проверок времени исполнения;
    * `--module-path=<js>/graal` путь к модулям Graal (здесь и далее `<js>` путь к каталогу `javascript` этого репозитория);
    * `--class-path <js>` путь к откомпилированным тестам;
    * {`hard`|`easy`} указание тестируемой сложности;
    * `<variant>`} указание тестируемой модификации.
 * При запуске из IDE, обычно не требуется указывать `--class-path`, так как он формируется автоматически.
   Остальные опции все равно необходимо указать.
 * Troubleshooting
    * `Error occurred during initialization of boot layer java.lang.module.FindException: Module org.graalvm.truffle not found, required by jdk.internal.vm.compiler` – неверно указан `--module-path`;
    * `Graal.js not found` – неверно указаны `--module-path`
    * `Error: Could not find or load main class jstest.functional.FunctionalTest` – неверно указан `--class-path`;
    * `Exception in thread "main" java.lang.AssertionError: You should enable assertions by running 'java -ea jstest.functional.FunctionalExpressionTest'` – не указана опция `-ea`;
    * `Exception in thread "main" jstest.EngineException: Script 'functionalExpression.js' not found` – в текущем каталоге отсутствует решение (`functionalExpression.js`)


## Исходный код к лекциям по JavaScript

[Скрипт с примерами](javascript/examples.js)

Запуск примеров
 * [В браузере](javascript/RunJS.html)
 * Из консоли
    * [на Java](javascript/RunJS.java): [RunJS.cmd](javascript/RunJS.cmd), [RunJS.sh](javascript/RunJS.sh)
    * [на node.js](javascript/RunJS.node.js): `node RunJS.node.js`

Лекция 1. Типы и функции
 * [Типы](javascript/examples/1_1_types.js)
 * [Функции](javascript/examples/1_2_functions.js)
 * [Функции высшего порядка](javascript/examples/1_3_functions-hi.js).
   Обратите внимание, что функции `array.map` и 
   `array.reduce` (аналог `leftFold` входят в стандартную библиотеку).
   Обратите внимание на реализацию функции `mCurry`.
 * [Пример: вектора и матрицы](javascript/examples/1_4_vectors.js).

Лекция 2. Объекты и замыкания
 * [Поля](javascript/examples/2_1_fields.js)
 * [Методы](javascript/examples/2_2_methods.js)
 * [Замыкания](javascript/examples/2_3_closures.js)
 * [Модули](javascript/examples/2_4_modules.js)
 * [Пример: стеки](javascript/examples/2_5_stacks.js)

Лекция 3. Другие возможности
 * [Обработка ошибок](javascript/examples/3_1_errors.js)
 * [Чего нет в JS](javascript/examples/3_2_no.js)
 * [Стандартная библиотека](javascript/examples/3_3_builtins.js)
 * [Работа со свойствами](javascript/examples/3_4_properties.js)
 * [Методы и классы](javascript/examples/3_5_classes.js)
 * [JS 6+](javascript/examples/3_6_js6.js)
 * Модули: 
   [объявление](javascript/examples/3_7_js6_module.mjs)
   [использование](javascript/examples/3_7_js6_module_usage.mjs)
 * [Простейший ввод-вывод](javascript/examples/3_8_io.js)


## Домашнее задание 5. Вычисление в различных типах

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
 * *CmmUls* (34, 35)
     * Реализуйте операции из модификации *Cmm*.
    * Дополнительно реализуйте поддержку режимов:
        * `u` – вычисления в `int` без проверки на переполнение;
        * `l` – вычисления в `long` без проверки на переполнение;
        * `s` – вычисления в `short` без проверки на переполнение.
 * *CmmUlf* (36, 37)
    * Реализуйте операции из модификации *Cmm*.
    * Дополнительно реализуйте поддержку режимов:
        * `u` – вычисления в `int` без проверки на переполнение;
        * `l` – вычисления в `long` без проверки на переполнение;
        * `f` – вычисления в `float` без проверки на переполнение.
 * *CmmUlt* (38, 39)
    * Реализуйте операции из модификации *Cmm*.
    * Дополнительно реализуйте поддержку режимов:
        * `u` – вычисления в `int` без проверки на переполнение;
        * `l` – вычисления в `long` без проверки на переполнение;
        * `t` – вычисления с усечением до кратных 10.


## Домашнее задание 4. Очереди

Модификации
 * *Базовая*
    * [Исходный код тестов](java/queue/QueueTest.java)
    * [Откомпилированные тесты](artifacts/queue/QueueTest.jar)
 * *CountIf* (31-33)
    * Реализовать метод `countIf`, возвращающий число элеменов очереди, удовлетворяющих
      [предикату](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Predicate.html).



## Домашнее задание 3. Очередь на массиве

Модификации
 * *Базовая*
    * Классы должны находиться в пакете `queue`
    * [Исходный код тестов](java/queue/ArrayQueueTest.java)
    * [Откомпилированные тесты](artifacts/queue/ArrayQueueTest.jar)
 * *Count* (31-33)


## Домашнее задание 2. Бинарный поиск

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

## Домашнее задание 1. Обработка ошибок

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
 * *Zeroes* (31-35)
    * Дополнительно реализуйте унарные операции
      * `l0` – число старших нулевых бит, `l0 123456` равно 15;
      * `t0` – число младших нулевых бит, `t0 123456` равно 6.
#   P a r a d i g m s - H o m e w o r k s - I T M O  
 