//package com.example.demo2.test;
//
//import com.example.demo2.test.domain.Member;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class prac1{
//
//    public static void main(String[] args) {
//
//        Map<String, String> data = new HashMap<>();
//        data.put("dataA", "DataAA");
//        data.put("dataB", "DataBB");
//        data.put("dataC", "DataCC");
//        data.put("dataD", "DataDD");
//
//        String findValue = "DataBB";
//        // normal code style
//        for (String s : data.keySet()) {
//            if (data.get(s).equals(findValue)) {
//                System.out.println(s);
//            }
//        }
//
//        // lambda code style
//        data.values() // data.keySet()
//                .stream() // java stream function
//                .filter(s -> s.equals(findValue))
//                .findAny(); // get data
//
//
//
//        Map<String, Member> data2 = new HashMap<>();
//        data2.put("dataA", new Member(1L, "name1"));
//        data2.put("dataB", new Member(1L, "name2"));
//        data2.put("dataC", new Member(1L, "name3"));
//        data2.put("dataD", new Member(1L, "name4"));
//
//        String findValue2 = "name3";
//        // normal code style
//        for (String s : data2.keySet()) {
//            Member m = data2.get(s);
//            if (m.getName().equals(findValue2)) {
//                System.out.println(m.getId() +" // "+ m.getName());
//            }
//        }
//        // lambda code style
//        String name = new String();
//        data2.values() // map values
//                .stream() // java stream function
//                .filter(member -> member.getName().equals(name))
//                .findAny(); // get data
//
//    }
//}
