package kr.ed.haebeop.util;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
//BadWords : 비속어 문자열 배열이 있는 인터페이스
//ReadURL : 특정 URL의 페이지에 비속어가 있는지 검사하기 위해 URL을 단어로 분리해주는 기능의 인터페이스
//ReadFile : File 안에 비속어가 있는지 검사하기 위해 파일의 내용을 분리해주는 기능의 인터페이스
public class BadWordFilter  extends HashSet<String> implements BadWords, ReadURL, ReadFile {
    private String substituteValue = "*";

    //대체 문자 지정
    //기본값 : *
    public BadWordFilter() {
        addAll(List.of(koreaWord1));
    }

    public BadWordFilter(String substituteValue) {
        this.substituteValue = substituteValue;
    }

    //비속어 있다면 대체
    public String change(String text) {
        String[] words = stream().filter(text::contains).toArray(String[]::new);
        for (String v : words) {
            String sub = this.substituteValue.repeat(v.length());
            text = text.replace(v, sub);
        }
        return text;
    }

    public String change(String text, String[] sings) {
        StringBuilder singBuilder = new StringBuilder("[");
        for (String sing : sings) singBuilder.append(Pattern.quote(sing));
        singBuilder.append("]*");
        String patternText = singBuilder.toString();

        for (String word : this) {
            if (word.length() == 1) text = text.replace(word, substituteValue);
            String[] chars = word.chars().mapToObj(Character::toString).toArray(String[]::new);
            text = Pattern.compile(String.join(patternText, chars))
                    .matcher(text)
                    .replaceAll(v -> substituteValue.repeat(v.group().length()));
        }

        return text;
    }

    //비속어가 1개라도 존재하면 true 반환
    public boolean check(String text) {
        return stream().anyMatch(text::contains);
    }

    //공백제거
    public boolean blankCheck(String text) {
        return check(text.replace(" ", ""));
    }

    public String messagePrint(String text){
        String msg = "";
        if(check(text)){
            msg = "비속어나 욕설이 존재합니다.";
        } else {
            msg = "비속어나 욕설이 포함되어 있지 않습니다.";
        }
        return msg;
    }
}
