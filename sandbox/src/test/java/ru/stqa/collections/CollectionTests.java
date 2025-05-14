package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionTests {

    @Test
    void arrayTests(){
        var array = new String[]{"a","b","c"};
        ///var array = new String[3]; ///создаем массив с кол-м 3, все равны null (массив имеет фиксированнную длину)
        Assertions.assertEquals(3, array.length); ///проверяем длину массива
        array[0] = "a";
        Assertions.assertEquals("a", array[0]); ///элемент с индексом 0 равен a

        array[0] = "d";
        Assertions.assertEquals("d", array[0]);
    }

    @Test
    void listTest(){
        ///var list = List.of("a","b","c"); ///задание списка сразу с элементами (но уже нельзя менять элементы в таком списке)
        ///var list = new ArrayList<String>(); ///создали список для хранения строк (список имеет переменную длину)
        var list = new ArrayList<>(List.of("a","b","c")); ///можно уже модифицировать такой список
        Assertions.assertEquals(3, list.size()); ///проверяем размер списка

//        list.add("a"); ///добавляем элементы в список
//        list.add("b");
//        list.add("c");
//        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("a", list.get(0));

        list.set(0, "d"); ///меняем первый элемент, устанавливаем его = d
        Assertions.assertEquals("d", list.get(0));
    }

    @Test
    void setTests (){
        var set = new HashSet<>(List.of("a", "b", "c", "a"));
        Assertions.assertEquals(3, set.size());
        set.add("d");
        Assertions.assertEquals(4, set.size());
    }

    @Test
    void testMap(){
        var digits = new HashMap<Character, String>();/// словарь
        digits.put('1', "one");
        digits.put('2', "two");
        digits.put('3', "three");
        Assertions.assertEquals("one", digits.get('1'));
        digits.put('1', "один");
        Assertions.assertEquals("один", digits.get('1'));
    }
}
