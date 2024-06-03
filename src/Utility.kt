import model.*

import java.util.Scanner

object Utility
{
    private val sc = Scanner(System.`in`)
    fun getUsernameInput() : String
    {
        var username : String
        do
        {
            print("Enter a username: ")
            username = sc.nextLine()
            if(Library.checkAvailability(username))
            {
                break
            }
            println("Username not available..")
        } while (true)
        return username
    }
    fun nameInput() : String
    {
        print("Enter your name: ")
        val name = sc.nextLine()
        return name
    }
    fun usernameInput() : String
    {
        print("Enter the username: ")
        val username = sc.nextLine()
        return username
    }
    fun passwordInput() : String
    {
        print("Enter the password: ")
        val password = sc.nextLine()
        return password
    }
    fun contactInput() : String
    {
        print("Enter your contactInfo: ")
        val contact = sc.nextLine()
        return contact
    }
    fun readInt(): Int {
        return try {
            sc.nextInt().also { sc.nextLine() }
        } catch (e: Exception) {
            sc.nextLine()
            readInt()
        }
    }

    fun displayAllItem(callback : (Int) -> Unit)
    {
        Library.displayAll()
        print("select an Item: ")
        val index = readInt()
        callback(index)
    }

    fun searchItem()
    {
        print("Enter the query to searchItem: ")
        val query = sc.nextLine()
        Library.findItem(query).forEachIndexed { index, libraryItem ->
            println(" ${index + 1}.${libraryItem.getTitle()} x${libraryItem.getCount()}")
        }
    }

    fun addLibraryItem(addItem : (LibraryItem) -> Unit)
    {
        print("Enter the title: ")
        val title = sc.nextLine()
        print("Enter the genre: ")
        val genre = sc.nextLine()
        print("Enter the publication year: ")
        val year = sc.nextLine()
        print("Enter the count: ")
        val count = readInt()
        println("1.Book\n2.Magazine\n")
        val choice = readInt()
        when(choice)
        {
            1 -> {
                print("Enter the author name:")
                val author = sc.nextLine()
                addItem(Book(title, year, genre, author, count))
            }
            2 -> {
                println("Enter issue number:")
                val issueNumber = sc.nextInt()
                addItem(Magazine(title,genre,year,issueNumber, count))
            }
        }
    }
}