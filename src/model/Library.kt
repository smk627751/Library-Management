package model

object Library {
    private var users = mutableMapOf<String,User>()
    private var libraryItems = mutableListOf<LibraryItem>()

    init {
        val book1 = Book("The Great Gatsby", "1925", "Classic Fiction", "F. Scott Fitzgerald", 5)
        val book2 = Book("1984", "1949", "Dystopian Fiction", "George Orwell", 5)
        val book3 = Book("To Kill a Mockingbird", "1960", "Southern Gothic", "Harper Lee", 5)
        val book4 = Book("Brave New World", "1932", "Science Fiction", "Aldous Huxley", 4)
        val book5 = Book("Moby-Dick", "1851", "Adventure Fiction", "Herman Melville", 4)

        val magazine1 = Magazine("National Geographic", "Science and Nature", "2021", 5, 5)
        val magazine2 = Magazine("Time", "News and Politics", "2022", 4, 8)
        val magazine3 = Magazine("Vogue", "Fashion and Lifestyle", "2023", 5, 7)
        val magazine4 = Magazine("The Economist", "Economics and Finance", "2023", 4, 12)
        val magazine5 = Magazine("Scientific American", "Science and Technology", "2021", 5, 6)


        libraryItems.add(book1)
        libraryItems.add(book2)
        libraryItems.add(book3)
        libraryItems.add(book4)
        libraryItems.add(book5)

        libraryItems.add(magazine1)
        libraryItems.add(magazine2)
        libraryItems.add(magazine3)
        libraryItems.add(magazine4)
        libraryItems.add(magazine5)

        val admin = Admin("mathan","1234")
        addUser(admin)
    }
    fun getUsers() = users
    fun checkUser(username : String, password : String) : User?
    {
        if(users[username]?.checkPassword(password) == true)
        {
            return users[username]
        }
        return null
    }
    fun checkAvailability(username: String) = !users.containsKey(username)
    fun addUser(user : User)
    {
        when(user)
        {
            is Admin -> {
                user.setAction(object : AdminAction{
                    override fun addLibrarian(username: String, password: String) {
                        val librarian = Librarian(username,password)
                        addUser(librarian)
                        println("Librarian added..")
                    }

                    override fun removeLibrarian(username: String) {
                        users.remove(username)
                        println("Librarian removed..")
                    }

                    override fun getLibrarians() {
                        var index = 1
                        users.forEach {
                            if(it.value is Librarian)
                            {
                                println("${index++}.${it.value.getUsername()}")
                            }
                        }
                    }

                })
                users[user.getUsername()] = user
            }
            is Librarian -> {
                user.setAction(object : LibrarianAction{
                    override fun getMembers() {
                        var index = 1
                        users.forEach {
                            if(it.value is Member)
                            {
                                println("${index++}.${it.value.getUsername()}")
                            }
                        }
                    }

                    override fun removeMember(username: String) {
                        users.remove(username)
                        println("Member removed...")
                    }

                })
                users[user.getUsername()] = user
            }
            is Member ->{
                user.setAction(object : MemberAction{
                    override fun borrowItem(index: Int) {
                        val libraryItems = getItems()
                        val item = libraryItems[index - 1]
                        if(item is Borrowable)
                        {
                            (item as Borrowable).borrowItem()
                            user.borrowedItems.add(item)
                        }
                        else
                        {
                            println("Item cannot be borrowed or already borrowed")
                        }
                    }

                    override fun returnItem(index: Int) {
                        val libraryItems = getItems()
                        val item = libraryItems[index - 1]
                        if(item is Borrowable && user.borrowedItems.contains(item))
                        {
                            (item as Borrowable).returnItem()
                            user.borrowedItems.remove(item)
                        }
                        else
                        {
                            println("Item cannot be borrowed or already borrowed")
                        }
                    }

                })
                users[user.getUsername()] = user
            }
        }
    }
    fun getItems() = libraryItems
    fun displayAll()
    {
        libraryItems.forEachIndexed { index, libraryItem ->
            println(" ${index + 1}.${libraryItem.getTitle()} x${libraryItem.getCount()}")
        }
    }
    fun displayInfo(index : Int)
    {
        if (index == 0) return
        if (index <= libraryItems.size)
            libraryItems[index - 1].also { it.displayInfo() }
    }
    fun findItem(query : String) : List<LibraryItem>
    {
        return libraryItems.filter {
            it.getTitle().contains(query) || it.getGenre() == query || it.getYear() == query
        }
    }
    fun addItem(item : LibraryItem)
    {
        if (libraryItems.contains(item))
        {
            libraryItems.remove(item)
            item.inc()
            libraryItems.add(item)
        }
        else libraryItems.add(item)
    }
    fun removeItem(index: Int)
    {
        if (index == 0) return
        libraryItems.removeAt(index - 1)
    }
    fun displayUserInfo(username : String)
    {
        println(users[username])
    }
}