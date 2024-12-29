# Оглавление

- [Лабораторная работа №1](#лабораторная-работа-1)

- [Лабораторная работа №2](#лабораторная-работа-2)

- [Лабораторная работа №3](#лабораторная-работа-3)

- [Лабораторная работа №4](#лабораторная-работа-4)

- [Лабораторная работа №5](#лабораторная-работа-5)

- [Лабораторная работа №6](#лабораторная-работа-6)

- [Лабораторная работа №7](#лабораторная-работа-7)

- [Лабораторная работа №8](#лабораторная-работа-8)

- [Лабораторная работа №9](#лабораторная-работа-9)

- [Лабораторная работа №10](#лабораторная-работа-10)

- [Лабораторная работа №11](#лабораторная-работа-11)

- [Зачетная работа](#зачетная-работа)


---

# Лабораторная работа №1
## Вариант №1

1. Создайте массив `int[]` на 1000 элементов, заполните его случайными числами.  
   Отсортируйте массив, используя метод простого выбора.
2. Напишите собственный парсер строки в целое число, используя метод `digit()` или  
   `getNumericValue()` класса `Character`. Учитывайте знак числа.

---

# Лабораторная работа №2
## Вариант №1

1. Создайте проект, включающий:
   - Интерфейс, содержащий метод `sort(…)` (нужно создать интерфейсную переменную).
   - Класс сортировки методом простого выбора.
   - Класс для сортировки пузырьком.
   - Запускаемый класс.
   
2. Метод `main` запускаемого класса должен выглядеть следующим образом:

```java
public static void main(String[] args) {
    createArray();
    chooseSortingAlgorithm();
    showSortedArray();
}
```

---

# Лабораторная работа №3

Создайте пользовательский интерфейс на любую тему. Минимальные требования:

1. Три вложенных макета. Можно использовать любые макеты кроме макета с ограничениями.
2. Пользовательский интерфейс должен содержать как минимум 2 `TextView`, 1 `EditText`, 2 `ImageView`, 2 `Button`.
3. Как минимум на 1-м `ImageView` сверху должен быть текст.
4. Создайте стили оформления `TextView` и `Button`.
5. Установите фон приложения.
6. Напишите метод обработки события нажатия хотя бы одной кнопки (реакция на нажатие кнопки должна быть видна пользователю).

---

# Лабораторная работа №4

Создайте пользовательский интерфейс на любую тему на основе `ConstraintLayout`. Минимальные требования:

1. Пользовательский интерфейс должен содержать как минимум 2 `TextView`, 1 `EditText`, 2 `ImageView`, 1 `Flow` (на 5-6 view), 1 `Barrier`, 1 `Chain`, гайдлайны где необходимо.
2. Установите фон приложения.
3. Интерфейс должен нормально отрисовываться, если `ImageView` уйдут в состояние `gone`.
4. Интерфейс должен нормально отрисовываться с учетом возможной разной длины текста в `TextView`.
5. Пользовательский интерфейс должен поддерживать возможность прокрутки.

---

# Лабораторная работа №5

1. Выберите тему, с которой будете работать на протяжении семестра.
2. Напишите приложение с тестами/интересными вопросами по выбранной теме. Тесты должны включать:
   - Вопрос с одним вариантом ответа
   - Вопрос с несколькими вариантами ответа
   - Вопрос со свободным ответом
   - Вопрос по изображению
3. Пользователь должен видеть текущее количество правильных и неправильных ответов.
4. Приложение должно корректно работать при повороте устройства.
5. Для хранения информации по заданиям создайте отдельный класс.
6. Не забывайте про презентабельность UI (макеты любые).

---

# Лабораторная работа №6

Продолжаем работать с приложением, начатым на лабораторной работе 5.

1. Вынесите статистику по количеству правильных/неправильных ответов, количеству пройденных тестов на отдельный экран.
2. Добавьте возможность поделиться статистикой (кнопка на втором экране).
3. Добавьте возможность открыть сайт с дополнительной информацией по теме (кнопка на втором экране).

---

# Лабораторная работа №7

Продолжаем работать с приложением, начатым на лабораторной работе 5.

1. Реорганизуйте код приложения так, чтобы в нем было две активности:
   - Активность с вопросами (вопросы отображаются по очереди)
   - Активность со статистикой и кнопками (кнопки добавлены в лабораторной работе 6)
2. Каждый вопрос расположите в отдельном фрагменте. Организуйте возвращение к предыдущему вопросу кнопкой назад.
3. В горизонтальном расположении устройства пользователь должен видеть:
   - Слева на экране текущий вопрос с вариантами ответа
   - Справа статистику и две кнопки (лабораторная работа 6)

---

# Лабораторная работа №8

Начинаем работу над приложением магазина (или ресторана, кафе и т.д.).

1. Добавьте панель приложения, на текущем этапе работы она должна содержать одну иконку «Начать квиз». По клику на иконку «Начать квиз» пользователь переходит на активность с вопросами (лаб. 5-7).

2. Панель приложения также должна содержать минимум 4 вкладки:
   - стартовый экран,
   - вкладки отдельных категорий товаров,
   - список адресов магазинов.
   
   Переключение вкладок – по клику на название вкладки и жестом смахивания. В каждой категории минимум 8 товаров, в адресах минимум 5 адресов.

3. К стартовому экрану требований нет, но он должен выглядеть презентабельно!

4. Вкладки категорий товаров и списка магазинов должны содержать `ListView` с названиями товаров / адресами.

5. По клику на конкретный товар в списке открывается активность детализации по товару (минимально `Image`, `TextView` c названием, `TextView` с подробным описанием, `TextView` c ценой).

6. Информацию о товарах храните в массивах объектов соответствующих классов (например, `Pizza[] pizzas = new Pizza[4];`…).

---

# Лабораторная работа №9

## Замените списки ListView на RecyclerView

1. В проекте замените все элементы `ListView` на `RecyclerView`.

## Использование различных LayoutManager

1. На одной из вкладок используйте `GridLayoutManager`.
2. На другой — `LinearLayoutManager`.
3. На третьей — любой `LayoutManager` из сторонних библиотек (кроме показанного на лекции).

---

# Лабораторная работа №10

## Добавление рекламы в список

1. Добавьте рекламу в список на одной из вкладок.
   - Используйте метод адаптера `getItemViewType(int position)` и `viewType` в методе `onCreateViewHolder`.
   - Убедитесь, что реклама не замещает элементы списка.

## Прокрутка панели инструментов

1. Реализуйте прокрутку панели инструментов.

## Добавление новой опции в меню

1. В меню панели инструментов добавьте новую опцию «Создать заказ».

## Активность создания заказа

1. Разметка активности должна включать:
   - FAB-кнопку с `Snackbar` по клику.
   - Прокручиваемое изображение на панели инструментов (`CollapsingToolbarLayout`).

---

# Лабораторная работа №11

## Игра «Пики-фазы»

### Правила игры

- Угадать последовательность из **4 уникальных цифр**.
- Обратная связь по вводу:
  - **Пика**: цифра есть в последовательности, но на другой позиции.
  - **Фаза**: цифра на правильной позиции.
- Пример:
  - Загадана последовательность `3745`.
  - Ввод `1798` → **0 пик, 1 фаза**.
  - Ввод `1759` → **1 пика, 1 фаза**.
  - Ввод `4795` → **1 пика, 2 фазы**.
- Победа — правильная последовательность, поражение — 15 попыток.

### Требования к реализации

1. **ViewBinding и DataBinding** в проекте.
2. Логика игры в **GameViewModel**.
3. Сохранение данных через **ViewModel**.
4. **История попыток**.
5. **Кнопка завершения игры**, которая показывает правильный ответ.

> *Дополнительно: реализуйте выбор режима с повторами и без.*

---

# Зачетная работа


