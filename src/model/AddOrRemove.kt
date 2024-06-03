package model

interface AddOrRemove {
    fun addItem(item : LibraryItem)
    {
        Library.addItem(item)
        println("Item added..")
    }
    fun removeItem(index: Int)
    {
        Library.removeItem(index)
        println("Item removed..")
    }
}