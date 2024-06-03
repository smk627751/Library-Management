package model

interface AdminAction : AddOrRemove{
    fun addLibrarian(username : String,password : String)
    fun removeLibrarian(username: String)
    fun getLibrarians()
}