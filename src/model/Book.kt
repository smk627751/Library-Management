package model

class Book(
    title: String,
    publicationYear: String,
    genre: String,
    private var author: String,
    count: Int
) : LibraryItem(title, genre, publicationYear,count), Borrowable {

    override fun displayInfo() {
        super.displayInfo()
        println("Author: $author, Count: ${getCount()}\n")
    }

    override fun borrowItem() {
        if (getCount() > 0) {
            dec()
            println("Book borrowed: ${bookTitle}\n")
        } else {
            println("Book already borrowed: ${bookTitle}\n")
        }
    }

    override fun returnItem() {
            inc()
            println("Book returned: $bookTitle")
    }
}