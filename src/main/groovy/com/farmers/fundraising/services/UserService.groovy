package com.farmers.fundraising.services
import com.farmers.fundraising.models.User
import com.farmers.fundraising.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

import javax.persistence.EntityNotFoundException

@Service
class UserService {
    @Autowired
    UserRepository userRepository

    List findAll() {
        def userList = userRepository.findAll().asList()
        userList

    }

    User findById(long id) {
        userRepository.findById(id).orElse(null)    }

    User findByIdOrError(long id) {
        userRepository.findById(id).orElseThrow({
            new EntityNotFoundException()
        })
    }

    User save(User User) {
        // assign User to every abilities
        User.abilities?.each { it.User = User }
        userRepository.save(User)
    }

    User update(User User, long id) {
        User persisted = findByIdOrError(id)
        persisted.with {
            name = User.name
        }
        def toBeRemoved = []
        // find values to update & delete
        persisted.abilities.each {
            def a = User.abilities.find { it2 -> it2.id == it.id }
            if (a == null) toBeRemoved.add(it)
            else it.name = a.name
        }
        persisted.abilities.removeAll(toBeRemoved)
        // assign persisted entity as the User
        User.abilities.each {
            if (it.id == null) {
                it.User = persisted
                persisted.abilities.add(it)
            }
        }

        userRepository.save(persisted)
    }

    User deleteById(long id) {
        def User = findByIdOrError(id)
        userRepository.delete(User)
        User
    }
}