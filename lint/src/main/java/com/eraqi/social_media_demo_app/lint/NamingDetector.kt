package com.eraqi.social_media_demo_app.lint

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.*
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement

class NamingDetector : Detector(), SourceCodeScanner {

    override fun getApplicableUastTypes(): List<Class<out UElement>> = listOf(UClass::class.java)

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            override fun visitClass(node: UClass) {
                val isViewModel = node.superTypes.any { 
                    it.canonicalText == "androidx.lifecycle.ViewModel" 
                }
                if (isViewModel && node.name?.endsWith("ViewModel") == false) {
                    context.report(
                        ISSUE_VIEW_MODEL_NAMING,
                        node,
                        context.getNameLocation(node),
                        "ViewModel names should end with 'ViewModel' suffix"
                    )
                }
            }
        }
    }

    companion object {
        val ISSUE_VIEW_MODEL_NAMING = Issue.create(
            id = "ViewModelNaming",
            briefDescription = "ViewModel should end with ViewModel suffix",
            explanation = "Enforcing a consistent naming convention for ViewModels makes the codebase easier to navigate.",
            category = Category.CORRECTNESS,
            priority = 5,
            severity = Severity.WARNING,
            implementation = Implementation(NamingDetector::class.java, Scope.JAVA_FILE_SCOPE)
        )
    }
}
