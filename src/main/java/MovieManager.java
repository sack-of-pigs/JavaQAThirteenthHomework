public class MovieManager {
    private String[] movies = new String[0]; //Массив фильмов
    private int limit; //Лимит для вывода фильмов в методе findLast()

    // Геттер для limit (для проверки в тестах)
    public int getLimit() {
        return limit;
    }

    // Первый конструктор: без аргументов, ограничение по умолчанию — 5
    public MovieManager() {
        this.limit = 5;
    }

    // Второй конструктор: с указанием ограничения для метода findLast()
    public MovieManager(int limit) {
        this.limit = limit;
    }

    //Добавляет новый фильм в конец массива
    public void addMovie(String movie) {
        String[] newMovies = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            newMovies[i] = movies[i]; //Можно заменить на arraycopy()
        }
        movies = newMovies;
        movies[movies.length - 1] = movie;
    }

    //Возвращает все фильмы в порядке их добавления
    public String[] findAll() {
        String[] result = new String[movies.length];

        for (int i = 0; i < movies.length; i++) {
            result[i] = movies[i]; //Можно заменить на arraycopy()
        }

        return result;
    }

    /**
     * Возвращает ограниченное количество фильмов в обратном порядке (от последних к первым).
     * Количество возвращаемых фильмов ограничено значением поля limit.
     * Если фильмов меньше, чем limit, возвращаются все имеющиеся фильмы.
     */
    public String[] findLast() {
        int resultSize = 0;
        if (limit > movies.length) { //Можно заменить на Math.min()
            resultSize = movies.length;
        } else {
            resultSize = limit;
        }
        String[] result = new String[resultSize];

        for (int i = 0; i < resultSize; i++) {
            result[i] = movies[movies.length - 1 - i];
        }

        return result;
    }
}
