import model.*

class LibraryApp()
{
    fun init()
    {
        do {
            println("1.Login\n2.SignUp\n")
            val choice = Utility.readInt()
            when(choice)
            {
                1 -> login()
                2 -> signUp()
                0 -> return
                else -> println("Invalid choice")
            }
        }while (true)
    }
    private fun login()
    {
        val username = Utility.usernameInput()
        val password = Utility.passwordInput()
        Library.checkUser(username,password)?.let {
            println("\nwelcome back ${it.getUsername()}")
            when(it)
            {
                is Admin -> AdminView(it).show()
                is Member -> MemberView(it).show()
                is Librarian -> LibrarianView(it).show()
            }
        }?: println("Invalid username or password")
    }

    private fun signUp()
    {
        val name = Utility.nameInput()
        val username = Utility.getUsernameInput()
        val password = Utility.passwordInput()
        val contactInfo = Utility.contactInput()
        val member = Member(username,password,name,contactInfo)
        Library.addUser(member).also { println("Sign up successfully...") }
    }
}