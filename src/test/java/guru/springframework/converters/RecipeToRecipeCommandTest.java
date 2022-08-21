package guru.springframework.converters;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by robertZ on 2022-08-21.
 */
public class RecipeToRecipeCommandTest {
    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    public static final Integer PREP_TIME = Integer.valueOf(30);
    public static final Integer COOK_TIME = Integer.valueOf(20);
    public static final Integer SERVINGS = Integer.valueOf(10);
    public static final String SOURCE = "source";
    public static final String URL = "url";
    public static final String DIRECTIONS = "directions";
    public static final Difficulty EASY = Difficulty.EASY;
    public static final Long ID_NOTES = 2L;
    public static final String NOTES = "notes";
    public static final Long ID_INGREDIENT1 = 3L;
    public static final BigDecimal AMOUNT = new BigDecimal(300);
    private static final Long ID_INGREDIENT2 = 4L;
    RecipeToRecipeCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeToRecipeCommand(new CategoryToCategoryCommand(),
                new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),
                new NotesToNotesCommand());
    }

    @Test
    public void testNullObject(){
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject(){
        assertNotNull(converter.convert(new Recipe()));
    }
    @Test
    public void convert() {
        //given
        Recipe source = new Recipe();
        source.setId(ID_VALUE);
        source.setDescription(DESCRIPTION);
        source.setPrepTime(PREP_TIME);
        source.setCookTime(COOK_TIME);
        source.setServings(SERVINGS);
        source.setSource(SOURCE);
        source.setUrl(URL);
        source.setDirections(DIRECTIONS);
        source.setDifficulty(EASY);

        Notes notes = new Notes();
        notes.setId(ID_NOTES);
        notes.setRecipeNotes(NOTES);
        source.setNotes(notes);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(ID_INGREDIENT1);

        source.getIngredients().add(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(ID_INGREDIENT2);

        source.getIngredients().add(ingredient2);

        //when
        RecipeCommand recipeCommand = converter.convert(source);

        //then
        assertNotNull(recipeCommand);
        assertEquals(ID_VALUE, recipeCommand.getId());
        assertEquals(PREP_TIME, recipeCommand.getPrepTime());
        assertEquals(ID_NOTES, recipeCommand.getNotes().getId());
        assertEquals(NOTES, recipeCommand.getNotes().getRecipeNotes());
        assertEquals(2, recipeCommand.getIngredients().size());
    }
}