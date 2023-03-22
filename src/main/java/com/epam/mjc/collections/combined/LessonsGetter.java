package com.epam.mjc.collections.combined;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LessonsGetter {

    public Set<String> getLessons(Map<String, List<String>> timetable) {

        List<String> lessonsList = new ArrayList<>();
        for(Map.Entry<String, List<String>> m : timetable.entrySet()){
            lessonsList.addAll(m.getValue());
        }
        Set<String> lessons = new HashSet<>(lessonsList);
        return lessons;
    }

    public static void main(String[] args) {
        Map<String, List<String>> timetable = new HashMap<>();
        timetable.put("Monday", Arrays.asList("English"));
        timetable.put("Tuesday", Arrays.asList("Mathematics"));
        timetable.put("Wednesday", Arrays.asList("English", "Chemistry"));
        timetable.put("Thursday ", Arrays.asList("Literature", "Mathematics"));
        timetable.put("Friday", Arrays.asList("Physics"));

        LessonsGetter lessonsGetter = new LessonsGetter();
        lessonsGetter.getLessons(timetable);
    }
}
