import model.Admin
import model.Librarian
import model.Library
import model.Member

class AdminView(private val admin: Admin)
{
    fun show()
    {
        do {
            println("\n1.Display all items\n" +
                    "2.Search Item\n" +
                    "3.Display Librarians\n" +
                    "4.Add Librarian\n" +
                    "5.Remove Librarian\n" +
                    "6.Add Item\n" +
                    "7.Remove Item\n" +
                    "0.Log out\n")
            val choice = Utility.readInt()
            with(admin)
            {
                when(choice)
                {
                    1 -> Utility.displayAllItem(Library::displayInfo)
                    2 -> Utility.searchItem()
                    3 -> getAction().getLibrarians()
                    4 -> getAction().addLibrarian(Utility.getUsernameInput(),Utility.passwordInput())
                    5 -> getAction().removeLibrarian(Utility.usernameInput())
                    6 -> Utility.addLibraryItem(getAction()::addItem)
                    7 -> Utility.displayAllItem(getAction()::removeItem)
                    0 -> return
                    else -> println("Invalid choice")
                }
            }
        }while (true)
    }
}
class LibrarianView(private val librarian: Librarian)
{
    fun show()
    {
        do {
            println("\n1.Display all items\n" +
                    "2.Search Item\n" +
                    "3.Display members\n" +
                    "4.Display member info\n" +
                    "5.Remove member\n" +
                    "6.Add Item\n" +
                    "7.Remove Item\n" +
                    "0.Log out\n")
            val choice = Utility.readInt()
            with(librarian)
            {
                when(choice)
                {
                    1 -> Utility.displayAllItem(Library::displayInfo)
                    2 -> Utility.searchItem()
                    3 -> getAction().getMembers()
                    4 -> Library.displayUserInfo(Utility.usernameInput())
                    5 -> getAction().removeMember(Utility.usernameInput())
                    6 -> Utility.addLibraryItem(getAction()::addItem)
                    7 -> Utility.displayAllItem(getAction()::removeItem)
                    0 -> return
                    else -> println("Invalid choice")
                }
            }
        }while (true)
    }
}
class MemberView(private val member: Member)
{
    fun show()
    {
        do {
            println("\n1.Display all items\n" +
                    "2.Search Item\n" +
                    "3.Borrow item\n" +
                    "4.Return item\n" +
                    "0.Log out\n")
            val choice = Utility.readInt()
            with(member)
            {
                when(choice)
                {
                    1 -> Utility.displayAllItem(Library::displayInfo)
                    2 -> Utility.searchItem()
                    3 -> Utility.displayAllItem(getAction()::borrowItem)
                    4 -> Utility.displayAllItem(getAction()::returnItem)
                    0 -> return
                    else -> println("Invalid choice")
                }
            }
        }while (true)

    }
}