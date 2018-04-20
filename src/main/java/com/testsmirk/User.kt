package com.testsmirk

import com.testsmirk.model.ErrorModel

class User {
    var username: String? = null
    var age: Int? = null
    var password: String? = null

    constructor(username: String, age: Int?) {
        this.username = username
        this.age = age
    }

    constructor(username: String, password: String) {
        this.username = username
        this.password = password
    }

    constructor() {

    }
    // 省略getter和setter
}