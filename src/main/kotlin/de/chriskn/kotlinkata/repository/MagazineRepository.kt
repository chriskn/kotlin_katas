package de.chriskn.kotlinkata.repository

class MagazineRepository (repo: IBookRepository) : IBookRepository by repo {

    override fun getName(): String {
        return "MagazineRepository"
    }
}