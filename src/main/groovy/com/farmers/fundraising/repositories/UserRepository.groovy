package com.farmers.fundraising.repositories

import com.farmers.fundraising.models.User
import org.springframework.data.repository.CrudRepository

// we only need CRUD for Ability because it won't have its own endpoints
interface UserRepository extends CrudRepository<User, Long> {}