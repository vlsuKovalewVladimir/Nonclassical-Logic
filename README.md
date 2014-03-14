Fuzzy logic (неклассическая логика)
===================================

Общая информация
----------------

> Владимирский государственный университет. [ВлГУ](http://vlsu.ru)
>
> Факультет прикладной математики и физики. [ФПМФ](http://fpmf.vlsu.ru)

Лабораторные работы по предмету "неклассическая логика"

Выполнил студент группы: ИТс-112

Ковалев Владимир Евгеньевич

Компиляция
----------

Из командной строки

```sh
git clone https://github.com/vlsuKovalewVladimir/fuzzy-logic.git
cd fuzzy-logic
mkdir out
javac -sourcepath ./src -d ./out src/ru/fuzzyLogic/lab1/Main.java
```

Из файла run.sh

```sh
#!/bin/sh

git clone https://github.com/vlsuKovalewVladimir/fuzzy-logic.git
cd fuzzy-logic
mkdir out
echo "Компиляция..."
javac -sourcepath ./src -d ./out src/ru/fuzzyLogic/lab1/Main.java
echo "Запуск..."
java -classpath ./out ru.fuzzyLogic.lab1.Main

exit 0
```

Запуск
------

Из командной строки

```sh
java -classpath ./out ru.fuzzyLogic.lab1.Main
```

Из файла run.sh

```sh
sh run.sh
```

Контактная информация
---------------------

e-mail: <kovalew.vladimir@gmail.com>