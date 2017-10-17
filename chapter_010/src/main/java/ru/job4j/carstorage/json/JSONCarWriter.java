package ru.job4j.carstorage.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import ru.job4j.carstorage.Car;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/**
 * Util class for writing Cars as JSON.
 */
public class JSONCarWriter {
    /**
     * Method write json to PrintWriter.
     * @param carList - POJO object
     * @param out - target
     * @throws IOException if POJO object could not be written.
     */
    public static void writeJSONCars(List<Car> carList, PrintWriter out) throws IOException {
        String[] carFields = {"id", "user", "mark", "model", "cost", "images", "created", "owner"};
        String[] userFields = {"nickname"};

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        FilterProvider provider = new SimpleFilterProvider()
                .addFilter("carFilter", SimpleBeanPropertyFilter.filterOutAllExcept(carFields))
                .addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept(userFields));
        mapper.setFilterProvider(provider);
        mapper.writeValue(writer, carList);
        out.println(writer.toString());
        out.flush();
    }
}
