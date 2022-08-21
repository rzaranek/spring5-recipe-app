package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by robertZ on 2022-08-21.
 */
public class CategoryCommandToCategoryTest {

    private static final Long LONG_VALUE = 1l;
    private static final String DESCRIPTION = "description";
    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void TestNullParametr(){
        assertNull(converter.convert(null));
    }

    @Test
    public void convert() {
        //given
        CategoryCommand source = new CategoryCommand();
        source.setId(LONG_VALUE);
        source.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(source);

        //then
        assertNotNull(category);
        assertEquals(LONG_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}