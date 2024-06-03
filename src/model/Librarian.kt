package model

class Librarian(
    username : String,
    password : String
)
    : User(username,password)
{
    private lateinit var librarianAction : LibrarianAction

    fun setAction(librarianAction: LibrarianAction)
    {
        this.librarianAction = librarianAction
    }
    fun getAction() = librarianAction

    override fun toString(): String {
        return "Librarian"
    }
}