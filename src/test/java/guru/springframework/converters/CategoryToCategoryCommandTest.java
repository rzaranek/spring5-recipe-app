package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by robertZ on 2022-08-21.
 */
public class CategoryToCategoryCommandTest {

    private static final Long LONG_VALUE = 1l;
    public static final String DESCRIPTION= "description";
    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void TestParametrNull(){
        assertNull(converter.convert(null));
    }

    @Test
    public void convert() {
        //given
        Category source = new Category();
        source.setId(LONG_VALUE);
        source.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = converter.convert(source);

        //then
        assertNotNull(categoryCommand);
        assertEquals(LONG_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());
    }
}