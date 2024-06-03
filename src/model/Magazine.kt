package model

class Magazine(
    title: String,
    genre: String,
    publicationYear: String,
    private var issueNumber: Int,
    count: Int
)
    : LibraryItem(title, genre,publicationYear,count) {
    override fun displayInfo() {
        super.displayInfo()
        println("Issue Number: $issueNumber, Count: ${getCount()}\n")
    }
}