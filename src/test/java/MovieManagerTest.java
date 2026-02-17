import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    void testDefaultConstructor() { //Тест конструктора без параметров
        MovieManager manager = new MovieManager();
        assertEquals(5, manager.getLimit());
        assertEquals(0, manager.getMovieCount());
    }

    @Test
    void testParameterizedConstructor() { //Тест конструктора с параметрами
        MovieManager manager = new MovieManager(10);
        assertEquals(10, manager.getLimit());
        assertEquals(0, manager.getMovieCount());
    }

    @Test
    void testAddSingleMovie() { //Тест добавления фильма
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        String[] expected = {"Movie 1"};
        String[] actual = manager.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test
    void testFindLastWithDefaultLimit() { //Тест на нахождение последних фильмов с учетом лимита
        MovieManager manager = new MovieManager();
        for (int i = 0; i < 10; i++){
            manager.addMovie("Movie " + i);
        }
        String[] expected = {"Movie 9","Movie 8","Movie 7","Movie 6","Movie 5"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected,actual);
    }

    @Test
    void testFindLastWhenLessThanLimit() { //Тест на нахождение фильмов, если фильмов меньше лимита
        MovieManager manager = new MovieManager();
        for (int i = 0; i < 3; i++){
            manager.addMovie("Movie " + i);
        }
        String[] expected = {"Movie 2","Movie 1","Movie 0"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected,actual);
    }
}
