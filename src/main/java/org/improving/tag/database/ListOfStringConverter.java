package org.improving.tag.database;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ListOfStringConverter implements AttributeConverter<ListOfStrings, String> {

    @Override
    public String convertToDatabaseColumn(ListOfStrings strings) {
        String stringOfAliases = "";
        for(String string : strings) {
            stringOfAliases += string + ", ";

       }
        return stringOfAliases.replaceAll(", $", "");
    }

    @Override
    public ListOfStrings convertToEntityAttribute(String s) {
        if (s != null) {
            String[] allAliases = s.trim().replace(" ", "").split(",");
            var list = new ListOfStrings();
            for (String alias : allAliases) {
                list.add(alias);
            }
            return list;
        }
        return null;
    }
}
