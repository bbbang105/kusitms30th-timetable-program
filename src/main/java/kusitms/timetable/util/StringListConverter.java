package kusitms.timetable.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Collections;
import java.util.List;

@Converter(autoApply = true)
public class StringListConverter implements AttributeConverter<List<String>, String> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return "[]"; // 빈 리스트를 빈 JSON 배열로 저장
        }
        try {
            return mapper.writeValueAsString(dataList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting list to JSON", e);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String data) {
        if (data == null || data.isEmpty()) {
            return Collections.emptyList(); // null 또는 빈 문자열을 빈 리스트로 변환
        }
        try {
            return mapper.readValue(data, new TypeReference<List<String>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting JSON to list", e);
        }
    }
}