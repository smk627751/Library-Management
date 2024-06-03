package model

interface MemberAction {
    fun borrowItem(index : Int)
    fun returnItem(index : Int)
}