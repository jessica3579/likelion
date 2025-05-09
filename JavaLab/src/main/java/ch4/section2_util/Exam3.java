package ch4.section2_util;

import java.util.*;
// Collection type test - list, set, map
public class Exam3 {
    public static void main(String[] args) {
        // 클래스의 타입을 표현하면서 <클래스명>으로 지정하는 기법... 제네릭(generic)
        // 즉, ArrayList에 <String> 타입의 데이터를 담을거라고 선언하는 것!!!
        ArrayList<String> list = new ArrayList();
        list.add("뉴욕");
        list.add("서울");
        list.add("런던");
        list.add("서울");
        list.add(1, "LA");

        for(String str : list)
            System.out.println(str);

        // indexOf는 첫번째 위치를 반환
        // indexOf : 몇번째 위치에 있는지 반환, 없으면 -1 반환
        System.out.println(list.indexOf("서울")); // 2
        System.out.println(list.lastIndexOf("서울")); // 4
        System.out.println(list.contains("LA")); // true

        // set............. list와 다르게 중복데이터 허용하지 않는다.
        HashSet<String> set = new HashSet<>();
        set.add("서울");
        set.add("뉴욕");
        set.add("서울");
        for(String str : set)
            System.out.println(str); // 서울은 처음 한번만 출력됨! set은 중복 data 허용하지 않기때문

        // <String, String> : 키 - string, 값 - string
        // 키는 식별자로 중복되면 안됨
        HashMap<String, String> map = new HashMap<>();
        map.put("one", "서울");
        map.put("two", "뉴욕");

        System.out.println(list.get(0));
        System.out.println(map.get("one"));

        // 모든 키 획득
        System.out.println(map.keySet());
        // 모든 데이터 획득
        System.out.println(map.values());

        System.out.println(map.containsKey("one"));
        System.out.println(map.containsValue("서울"));

        // Entry : key-value 하나를 표현하는 객체
        for(Map.Entry<String, String> entry: map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // List, Set, Map
        // 순차적으로 모두 핸들링하고 싶을때....
        // for loop문 or iterator
        // iterator : 모든 collection에서 지원하는 기능
        // iterator의 이점 : 1. 모든 collection type의 데이터를 동일 api(코드)로 이용하라 수 있음
        // 2. 데이터를 순차적으로 이용하면서 삭제 기능까지 제공!!
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){ // 있니?
            String str = iterator.next(); // 하나 줘..
            System.out.println(str);
        }



    }
}
