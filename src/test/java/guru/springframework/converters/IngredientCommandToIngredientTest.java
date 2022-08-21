package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.Ingredient;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by robertZ on 2022-08-21.
 */
public class IngredientCommandToIngredientTest {

    public static final Long LONG_VALUES = 1L;
    public static final BigDecimal AMOUNT = new BigDecimal(10);
    public static final String DESCRIPTION = "description";
    IngredientCommandToIngredient converter;
    UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void TestParametrNull(){
        assertNull(converter.convert(null));
    }

    @Test
    public void TestEmptyObject(){
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() {
        //given
        IngredientCommand source = new IngredientCommand();
        source.setId(LONG_VALUES);
        source.setAmount(AMOUNT);
        source.setDescription(DESCRIPTION);
        UnitOfMeasureCommand uom = new UnitOfMeasureCommand();
        uom.setId(LONG_VALUES);
        uom.setDescription(DESCRIPTION);
        source.setUnitOfMeasure(uom);

        //when
        Ingredient ingredient = converter.convert(source);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(LONG_VALUES, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(LONG_VALUES, ingredient.getUom().getId());
        assertEquals(DESCRIPTION, ingredient.getUom().getDescription());

    }
}