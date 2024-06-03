package model

abstract class LibraryItem(
    protected var bookTitle : String,
    protected var bookGenre : String,
    protected var bookPublicationYear : String,
    private var count : Int = 5
)
{
    fun getTitle() = bookTitle
    fun getGenre() = bookGenre
    fun getYear() = bookPublicationYear

    fun getCount() = count
    fun inc() = count++
    fun dec()
    {
        if(count > 0)
        {
            count--
        }
    }
    open fun displayInfo()
    {
        println("Title: ${bookTitle}\n" +
                "Genre: $bookGenre\n" +
                "Year: $bookPublicationYear")
    }
}
