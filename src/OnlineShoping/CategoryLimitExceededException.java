package OnlineShoping;
/*
* Превышен лимит категории
 */


public class CategoryLimitExceededException extends RuntimeException{
    private final String categoryName;
    private final int currentLimit;
    private final int attempted;

    public CategoryLimitExceededException(String categoryName, int currentLimit, int attempted){
        super(String.format("Превышен лимит категории '%s!' Максимум: %d товаров, попытка добавить: %d",
                categoryName, currentLimit, attempted));
        this.categoryName = categoryName;
        this.currentLimit = currentLimit;
        this.attempted = attempted;
    }
}
