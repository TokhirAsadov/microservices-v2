package uz.takhir.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/v1/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1","value2","value3");
    }

    @GetMapping("/v1/filtering-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList(
                new SomeBean("value1","value2","value3"),
                new SomeBean("value4","value5","value6")
        );
    }


    @GetMapping("/v2/filtering") // dynamic filtering
    public MappingJacksonValue filteringV2(){
        SomeBeanForDynamicFiltering someBean = new SomeBeanForDynamicFiltering("value1", "value2", "value3");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3"); // enable fields
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanForDynamicFilteringFilter",filter); // @JsonFilter([name_of_filter])
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    @GetMapping("/v2/filtering-list")
    public MappingJacksonValue filteringListV2(){

        List<SomeBeanForDynamicFiltering> list = Arrays.asList(
                new SomeBeanForDynamicFiltering("value1", "value2", "value3"),
                new SomeBeanForDynamicFiltering("value4", "value5", "value6")
        );

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanForDynamicFilteringFilter",filter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
