package model

interface LibrarianAction : AddOrRemove{
    fun getMembers()
    fun removeMember(username : String)
}