package com.thererolando.groovybasics.lesson23inheritance

import com.thererolando.groovybasics.lesson23inheritance.domain.IPhone
import com.thererolando.groovybasics.lesson23inheritance.domain.Phone

IPhone iPhone = new IPhone(name: 'IPhone', appStore: 'Apple', os: 'ios')
println iPhone

Phone phone = new Phone(name: 'Phone')
println phone
