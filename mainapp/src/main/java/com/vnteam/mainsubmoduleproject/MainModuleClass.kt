package com.vnteam.mainsubmoduleproject

import com.vnteam.core.CoreModuleClass

open class MainModuleClass {

    fun textFromMainModule(): String {
        return "Text from MainModuleClass"
    }

    fun coreModuleTextFromMainModule(): String {
        val coreModuleClass = CoreModuleClass()
        return coreModuleClass.textFromCoreModule()
    }
}