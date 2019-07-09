package com.mahesaiqbal.fakeusermanagement.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.mahesaiqbal.fakeusermanagement.model.Data

class UserViewModel(model: Data): ViewModel() {

    var id: ObservableField<Int> = ObservableField()
    var email: ObservableField<String> = ObservableField()
    var firstName: ObservableField<String> = ObservableField()
    var lastName: ObservableField<String> = ObservableField()
    var avatar: ObservableField<String> = ObservableField()

    init {
        id.set(model.id)
        email.set(model.email)
        firstName.set(model.firstName + " ")
        lastName.set(model.lastName)
        avatar.set(model.avatar)
    }
}