package com.example.laboratory1

open class Film(val name: String, val age: Int, val description: String, val imageResId: Int) {
}

class Action(name: String, rating: Int, description: String, imageResId: Int) : Film(name, rating, description, imageResId) {
}

class Comedy(name: String, rating: Int, description: String, imageResId: Int) : Film(name, rating, description, imageResId) {
}

class Drama(name: String, rating: Int, description: String, imageResId: Int) : Film(name, rating, description, imageResId) {
}

class Fantasy(name: String, rating: Int, description: String, imageResId: Int) : Film(name, rating, description, imageResId) {
}

class Horror(name: String, rating: Int, description: String, imageResId: Int) : Film(name, rating, description, imageResId) {
}